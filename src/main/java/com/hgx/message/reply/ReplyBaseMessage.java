package com.hgx.message.reply;

import lombok.Data;

/**
 * @author :huangguixin / 2677540604@qq.com
 * @version : 1.0
 */
@Data
public class ReplyBaseMessage {

    /**
     * 接收方帐号（收到的OpenID）
     */
    private String ToUserName;

    /**
     * 开发者微信号
     */
    private String FromUserName;

    /**
     * 消息创建时间 （整型）
     */
    private Long CreateTime;

    /**
     * 消息类型，文本为text
     */
    private String MsgType;

}
