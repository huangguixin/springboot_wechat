package com.hgx.message.reply;

import com.hgx.entity.ReplyItem;
import lombok.Data;

import java.util.List;

/**
 * @author :huangguixin / 2677540604@qq.com
 * @version : 1.0
 */
@Data
public class ReplyNewsMessage extends ReplyBaseMessage {

    /**
     * 图文消息个数；当用户发送文本、图片、视频、图文、地理位置这五种消息时，
     * 开发者只能回复1条图文消息；其余场景最多可回复8条图文消息
     */
    private Integer ArticleCount;

    /**
     * 图文消息信息，注意，如果图文数超过限制，则将只发限制内的条数
     */
    private List<ReplyItem> Articles;

}
