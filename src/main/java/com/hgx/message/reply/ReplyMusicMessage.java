package com.hgx.message.reply;

import com.hgx.entity.ReplyMusic;
import lombok.Data;

/**
 * @author :huangguixin / 2677540604@qq.com
 * @version : 1.0
 */
@Data
public class ReplyMusicMessage extends ReplyBaseMessage {

    /**
     * 音乐
     */
    private ReplyMusic Music;

}
