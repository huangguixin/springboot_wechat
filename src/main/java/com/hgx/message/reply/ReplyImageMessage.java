package com.hgx.message.reply;

import com.hgx.entity.ReplyImage;
import lombok.Data;

/**
 * @author :huangguixin / 2677540604@qq.com
 * @version : 1.0
 */
@Data
public class ReplyImageMessage extends ReplyBaseMessage {

    /**
     * 图片
     */
    private ReplyImage Image;

}
