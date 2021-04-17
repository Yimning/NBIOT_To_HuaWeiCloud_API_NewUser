package com.yimning.entity.device;

import lombok.Data;

@Data
public class AuthInfo {
    private String auth_type;
    private String secret;
    private String fingerprint;
    private boolean secure_access;
    private Integer timeout;
}
