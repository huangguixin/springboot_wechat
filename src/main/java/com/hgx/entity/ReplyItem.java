package com.hgx.entity;

import lombok.Data;

/**
 * @author :huangguixin / 2677540604@qq.com
 * @version : 1.0
 */
@Data
public class ReplyItem {

    /**
     * 图文消息标题
     */
    private String Title;

    /**
     * 图文消息描述
     */
    private String Description;

    /**
     * 	图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
     */
    private String PicUrl;

    /**
     * 	点击图文消息跳转链接
     */
    private String Url;

}
