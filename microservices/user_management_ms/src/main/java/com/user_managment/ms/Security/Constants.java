package com.user_managment.ms.Security;

public interface Constants {
    long ACCESS_TOKEN_VALIDITY_SECONDS = 5 * 60 * 60;
    String SIGNING_KEY = "telenash";
    String TOKEN_PREFIX = "Bearer ";
    String HEADER_STRING = "Authorization";
}
