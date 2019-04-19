package com.hgx.constant;


/**
 * 微信常量
 *
 * @author :huangguixin / 2677540604@qq.com
 * @version : 1.0
 */
public class WeChatConstant {

    /**
     * App id
     */
    public static final String APPID = "wxa8bc8460a875e0bc";

    /**
     * Appsecret
     */
    public static final String APPSECRET = "4756b3dad3b05863a1e568e39901209a";

    /**
     * Token
     */
    public static final String TOKEN = "hgx";

    /**
     * ACCESS_TOKEN_URL
     */
    public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?" +
            "grant_type=client_credential&appid=APPID&secret=APPSECRET"
                    .replace("APPID", WeChatConstant.APPID)
                    .replace("APPSECRET", WeChatConstant.APPSECRET);
}
