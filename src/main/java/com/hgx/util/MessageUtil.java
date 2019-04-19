package com.hgx.util;

import com.hgx.entity.*;
import com.hgx.message.reply.*;
import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author :huangguixin / 2677540604@qq.com
 * @version : 1.0
 */
public class MessageUtil {

    /**
     * 文本消息
     */
    public static final String MESSAGE_TYPE_TEXT = "text";

    /**
     * 图片消息
     */
    public static final String MESSAGE_TYPE_IMAGE = "image";

    /**
     * 语音消息
     */
    public static final String MESSAGE_TYPE_VOICE = "voice";

    /**
     * 视频消息
     */
    public static final String MESSAGE_TYPE_VIDEO = "video";

    /**
     * 小视频消息
     */
    public static final String MESSAGE_TYPE_SHORT_VIDEO = "shortvideo";

    /**
     * 地理位置消息
     */
    public static final String MESSAGE_TYPE_LOCATION = "location";

    /**
     * 链接消息
     */
    public static final String MESSAGE_TYPE_LINK = "link";

    /**
     * 音乐消息
     */
    public static final String MESSAGE_TYPE_MUSIC = "music";

    /**
     * 图文消息
     */
    public static final String MESSAGE_TYPE_NEWS = "news";

    /**
     * xml转map对象
     *
     * @param request the request
     * @return the map
     * @throws IOException       the io exception
     * @throws DocumentException the document exception
     * @author : huangguixin / 2019-04-07
     */
    public static Map<String, String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException {
        Map<String, String> map = new HashMap<String, String>();
        SAXReader saxReader = new SAXReader();
        InputStream inputStream = request.getInputStream();
        Document document = saxReader.read(inputStream);
        Element rootElement = document.getRootElement();
        List<Element> elements = rootElement.elements();
        elements.stream().forEach(element -> {
            map.put(element.getName(), element.getText());
        });
        inputStream.close();
        return map;
    }

    /**
     * 构建回复通用的信息消息
     *
     * @author : huangguixin / 2019-04-07
     */
    public static void mapToReplyBaseMessage(ReplyBaseMessage replyBaseMessage, Map<String, String> map) {
        replyBaseMessage.setFromUserName(map.get("ToUserName"));
        replyBaseMessage.setToUserName(map.get("FromUserName"));
        replyBaseMessage.setMsgType(map.get("MsgType"));
        replyBaseMessage.setCreateTime(Instant.now().toEpochMilli());
    }

    /**
     * 构建回复的文本信息对象
     *
     * @param map     the map
     * @param content the content
     * @return the reply text message
     * @author : huangguixin / 2019-04-07
     */
    public static ReplyTextMessage mapToReplyTextMessage(Map<String, String> map, String content) {
        ReplyTextMessage replyTextMessage = new ReplyTextMessage();
        mapToReplyBaseMessage(replyTextMessage, map);
        replyTextMessage.setContent(content);
        return replyTextMessage;
    }

    /**
     * 构建回复的图片信息对象
     *
     * @param map the map
     * @return the reply image message
     * @author : huangguixin / 2019-04-07
     */
    public static ReplyImageMessage mapToReplyImageMessage(Map<String, String> map) {
        ReplyImageMessage replyImageMessage = new ReplyImageMessage();
        mapToReplyBaseMessage(replyImageMessage, map);
        ReplyImage replyImage = new ReplyImage();
        replyImage.setMediaId(map.get("MediaId"));
        replyImageMessage.setImage(replyImage);
        return replyImageMessage;
    }

    /**
     * 构建回复的语音信息对象
     *
     * @param map the map
     * @return the reply voice message
     * @author : huangguixin / 2019-04-07
     */
    public static ReplyVoiceMessage mapToReplyVoiceMessage(Map<String, String> map) {
        ReplyVoiceMessage replyVoiceMessage = new ReplyVoiceMessage();
        mapToReplyBaseMessage(replyVoiceMessage, map);
        ReplyVoice replyVoice = new ReplyVoice();
        replyVoice.setMediaId(map.get("MediaId"));
        replyVoiceMessage.setVoice(replyVoice);
        return replyVoiceMessage;
    }

    /**
     * 构建回复的视屏信息对象
     *
     * @param map the map
     * @return the reply video message
     * @author : huangguixin / 2019-04-07
     */
    public static ReplyVideoMessage mapToReplyVideoMessage(Map<String, String> map) {
        ReplyVideoMessage replyVideoMessage = new ReplyVideoMessage();
        mapToReplyBaseMessage(replyVideoMessage, map);
        ReplyVideo replyVideo = new ReplyVideo();
        replyVideo.setMediaId(map.get("MsgId"));
        replyVideo.setDescription("视屏描述");
        replyVideo.setTitle("视屏");
        replyVideoMessage.setVideo(replyVideo);
        return replyVideoMessage;
    }

    /**
     * 构建回复的音乐信息对象
     *
     * @param map the map
     * @return the reply music message
     * @author : huangguixin / 2019-04-07
     */
    public static ReplyMusicMessage mapToReplyMusicMessage(Map<String, String> map) {
        ReplyMusicMessage replyMusicMessage = new ReplyMusicMessage();
        mapToReplyBaseMessage(replyMusicMessage, map);
        ReplyMusic replyMusic = new ReplyMusic();
        replyMusic.setMusicUrl("https://music.163.com/#/song?id=1356499052");
        replyMusic.setDescription("歌手：隔壁老樊");
        replyMusic.setHQMusicUrl("https://music.163.com/#/song?id=1356499052");
        replyMusic.setThumbMediaId(map.get("MediaId"));
        replyMusic.setTitle("你的姑娘");
        replyMusicMessage.setMusic(replyMusic);
        replyMusicMessage.setMsgType(MessageUtil.MESSAGE_TYPE_MUSIC);
        return replyMusicMessage;
    }

    /**
     * 构建回复的图文信息对象
     *
     * @param map the map
     * @return the reply news message
     * @author : huangguixin / 2019-04-07
     */
    public static ReplyNewsMessage mapToReplyNewsMessage(Map<String, String> map) {
        ReplyNewsMessage replyNewsMessage = new ReplyNewsMessage();
        mapToReplyBaseMessage(replyNewsMessage, map);
        ReplyItem replyItem = new ReplyItem();
        replyItem.setDescription("高一的第一首歌，送给每一个爱人在远方的人，祝有情人终成眷属。");
        replyItem.setPicUrl("https://p1.music.126.net/u0yBRGJfPzJZ7s66nt2yaw==/109951163936022046.jpg?param=50y50");
        replyItem.setTitle("你的姑娘");
        replyItem.setUrl("https://music.163.com/#/song?id=1356499052");
        List<ReplyItem> replyItems = new ArrayList<ReplyItem>();
        replyItems.add(replyItem);
        replyNewsMessage.setArticleCount(replyItems.size());
        replyNewsMessage.setArticles(replyItems);
        replyNewsMessage.setMsgType(MESSAGE_TYPE_NEWS);
        return replyNewsMessage;
    }

    /**
     * 回复的文本消息对象转xml
     *
     * @param replyTextMessage the text message
     * @return the string
     * @author : huangguixin / 2019-04-07
     */
    public static String replyTextMessageToXml(ReplyTextMessage replyTextMessage) {
        XStream xStream = new XStream();
        xStream.alias("xml", ReplyTextMessage.class);
        return xStream.toXML(replyTextMessage);
    }

    /**
     * 回复的图片消息对象转xml
     *
     * @param replyImageMessage the reply image message
     * @return the string
     * @author : huangguixin / 2019-04-07
     */
    public static String replyImageMessage(ReplyImageMessage replyImageMessage) {
        XStream xStream = new XStream();
        xStream.alias("xml", ReplyImageMessage.class);
        xStream.alias("image", ReplyImage.class);
        return xStream.toXML(replyImageMessage);
    }

    /**
     * 回复的音乐消息对象转xml
     *
     * @param replyMusicMessage the reply music message
     * @return the string
     * @author : huangguixin / 2019-04-07
     */
    public static String replyMusicMessage(ReplyMusicMessage replyMusicMessage) {
        XStream xStream = new XStream();
        xStream.alias("xml", ReplyMusicMessage.class);
        xStream.alias("music", ReplyMusic.class);
        return xStream.toXML(replyMusicMessage);
    }

    /**
     * 回复的语音消息对象转xml
     *
     * @param replyVoiceMessage the reply voice message
     * @return the string
     * @author : huangguixin / 2019-04-07
     */
    public static String replyVoiceMessage(ReplyVoiceMessage replyVoiceMessage) {
        XStream xStream = new XStream();
        xStream.alias("xml", ReplyVoiceMessage.class);
        xStream.alias("voice", ReplyVoice.class);
        return xStream.toXML(replyVoiceMessage);
    }

    /**
     * 回复的视频消息对象转xml
     *
     * @param replyVideoMessage the reply voice message
     * @return the string
     * @author : huangguixin / 2019-04-07
     */
    public static String replyVideoMessage(ReplyVideoMessage replyVideoMessage) {
        XStream xStream = new XStream();
        xStream.alias("xml", ReplyVideoMessage.class);
        xStream.alias("video", ReplyVideo.class);
        return xStream.toXML(replyVideoMessage);
    }

    /**
     * 回复图文消息对象转xml
     *
     * @param replyNewsMessage the reply news message
     * @return the string
     * @author : huangguixin / 2019-04-07
     */
    public static String replyNewsMessage(ReplyNewsMessage replyNewsMessage) {
        XStream xStream = new XStream();
        xStream.alias("xml", ReplyNewsMessage.class);
        xStream.alias("item", ReplyItem.class);
        return xStream.toXML(replyNewsMessage);
    }

}
