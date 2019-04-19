package com.hgx.controller;

import com.hgx.constant.WeChatConstant;
import com.hgx.message.reply.*;
import com.hgx.util.MessageUtil;
import com.hgx.util.SignUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 微信控制器
 *
 * @author :huangguixin / 2677540604@qq.com
 * @version : 1.0
 */
@RestController
@RequestMapping("/wechat")
public class WeChatController {

    /**
     * 验证服务器有效性
     *
     * @return the string
     * @author : huangguixin / 2019-04-07
     */
    @GetMapping
    public String verifyServerValidity(HttpServletRequest request) {

        // 微信加密签名
        String signature = request.getParameter("signature");
        // 随机字符串
        String echostr = request.getParameter("echostr");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        //token
        String token = WeChatConstant.TOKEN;
        // 校验成功返回  echostr，成功成为开发者；否则返回error，接入失败
        if (SignUtil.validSign(signature, token, timestamp, nonce)) {
            return echostr;
        }

        return "error";

    }

    /**
     * 响应消息
     *
     * @return the string
     * @author : huangguixin / 2019-04-07
     */
    @PostMapping
    public String responseMessage(HttpServletRequest request) {
        try {
            Map<String, String> map = MessageUtil.xmlToMap(request);
            String msgType = map.get("MsgType");
            if (MessageUtil.MESSAGE_TYPE_TEXT.equals(msgType)) {
                ReplyTextMessage replyTextMessage = MessageUtil.mapToReplyTextMessage(map, "666666");
                String toXml = MessageUtil.replyTextMessageToXml(replyTextMessage);
                System.out.println(toXml);
                return toXml;
            } else if (MessageUtil.MESSAGE_TYPE_IMAGE.equals(msgType)) {
                ReplyImageMessage replyImageMessage = MessageUtil.mapToReplyImageMessage(map);
                String toXml = MessageUtil.replyImageMessage(replyImageMessage);
                System.out.println(toXml);
                return toXml;
            } else if (MessageUtil.MESSAGE_TYPE_LINK.equals(msgType)) {
                ReplyMusicMessage replyMusicMessage = MessageUtil.mapToReplyMusicMessage(map);
                String toXml = MessageUtil.replyMusicMessage(replyMusicMessage);
                System.out.println(toXml);
                return toXml;
            } else if (MessageUtil.MESSAGE_TYPE_LOCATION.equals(msgType)) {
                ReplyNewsMessage replyNewsMessage = MessageUtil.mapToReplyNewsMessage(map);
                String toXml = MessageUtil.replyNewsMessage(replyNewsMessage);
                System.out.println(toXml);
                return toXml;
            } else if (MessageUtil.MESSAGE_TYPE_VIDEO.equals(msgType)) {
                ReplyVideoMessage replyVideoMessage = MessageUtil.mapToReplyVideoMessage(map);
                String toXml = MessageUtil.replyVideoMessage(replyVideoMessage);
                System.out.println(toXml);
                return toXml;
            } else if (MessageUtil.MESSAGE_TYPE_VOICE.equals(msgType)) {
                ReplyVoiceMessage replyVoiceMessage = MessageUtil.mapToReplyVoiceMessage(map);
                String toXml = MessageUtil.replyVoiceMessage(replyVoiceMessage);
                System.out.println(toXml);
                return toXml;
            } else if (MessageUtil.MESSAGE_TYPE_SHORT_VIDEO.equals(msgType)) {
                ReplyVideoMessage replyVideoMessage = MessageUtil.mapToReplyVideoMessage(map);
                String toXml = MessageUtil.replyVideoMessage(replyVideoMessage);
                System.out.println(toXml);
                return toXml;
            }
            return "error";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

}
