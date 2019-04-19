package com.hgx.message.reply;

import lombok.Data;

/**
 * @author :huangguixin / 2677540604@qq.com
 * @version : 1.0
 */
@Data
public class ReplyTextMessage extends ReplyBaseMessage{

    /**
     * 回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
     */
    private String Content;

}
