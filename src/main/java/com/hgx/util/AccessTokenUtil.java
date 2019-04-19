package com.hgx.util;

import com.hgx.constant.WeChatConstant;
import com.hgx.entity.AccessToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.time.Instant;

/**
 * @author :huangguixin / 2677540604@qq.com
 * @version : 1.0
 */
@Slf4j
public class AccessTokenUtil {

    public static String getAccessToken() {

        AccessToken accessToken = readAccessToken();
        if (!checkAccessToken(accessToken)) {
            RestTemplate restTemplate = new RestTemplate();
            accessToken = restTemplate.getForObject(WeChatConstant.ACCESS_TOKEN_URL, AccessToken.class);
            accessToken.setExpires_in(Instant.now().getEpochSecond() + 6000);
            writeAccessToken(accessToken);
        }
        return accessToken.getAccess_token();
    }

    public static Boolean checkAccessToken(AccessToken accessToken) {
        if (accessToken != null && accessToken.getExpires_in() > Instant.now().getEpochSecond()) {
            return true;
        }
        return false;
    }

    public static void writeAccessToken(AccessToken accessToken) {
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(new File("accessToken.properties"));
                ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        ) {
            outputStream.writeObject(accessToken);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AccessToken readAccessToken() {
        AccessToken accessToken = null;
        try (
                FileInputStream fileInputStream = new FileInputStream(new File("accessToken.properties"));
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ) {
            Object object = objectInputStream.readObject();
            if (object != null) {
                accessToken = ((AccessToken) object);
            }
        } catch (Exception e) {
            log.debug("accessToken过期，再次向微信服务器请求accessToken信息");
        }
        return accessToken;
    }

    public static void main(String[] args) {
        getAccessToken();
    }
}
