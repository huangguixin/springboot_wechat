package com.hgx.message.reply;

import com.hgx.entity.ReplyVoice;
import lombok.Data;

/**
 * @author :huangguixin / 2677540604@qq.com
 * @version : 1.0
 */
@Data
public class ReplyVoiceMessage extends ReplyBaseMessage{

    /**
     * 语音
     */
    private ReplyVoice Voice;

}
