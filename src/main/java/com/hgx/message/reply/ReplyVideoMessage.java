package com.hgx.message.reply;

import com.hgx.entity.ReplyVideo;
import lombok.Data;

/**
 * @author :huangguixin / 2677540604@qq.com
 * @version : 1.0
 */
@Data
public class ReplyVideoMessage extends ReplyBaseMessage {

    /**
     * 视屏
     */
    private ReplyVideo Video;

}


