package com.hgx.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author :huangguixin / 2677540604@qq.com
 * @version : 1.0
 */
@Data
public class AccessToken implements Serializable {

    /**
     * Access token
     */
    private String access_token;

    /**
     * Expires in
     */
    private Long expires_in;

}
