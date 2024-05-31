package com.example.loginapp.user;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.sql.Timestamp;

public class KakaoResponse {

    @Data // getter, setter
    public static class TokenDTO {
        @JsonProperty("access_token")
        private String accessToken;
        @JsonProperty("token_type")
        private String tokenType;
        @JsonProperty("refresh_token")
        private String refreshToken;
        @JsonProperty("expires_in")
        private Integer expiresIn;
        private String scope; // 조심하자
        @JsonProperty("refresh_token_expires_in")
        private Integer refreshTokenExpiresIn;
    }

    @Data
    public static class KakaoUserDTO {
        private Long id;
        @JsonProperty("connected_at")
        private Timestamp connectedAt;
        private Properties properties;

        @Data
        class Properties {
            private String nickname;
        }
    }
//    {
//        "access_token": "cF8KxpGGr_PZ6RQhX6VW7qy9kAcKPhMJAAAAAQo9c-wAAAGPzRoMqcYNwJ_muSR4",
//        "token_type": "bearer",
//        "refresh_token": "CkRmjTlcVkiVgvedDVGT7eCd9LK-T0UbAAAAAgo9c-wAAAGPzRoMpsYNwJ_muSR4",
//        "expires_in": 21599,
//        "scope": "profile_nickname",
//        "refresh_token_expires_in": 5183999
//    }


//    {
//        "id":3506279095,
//        "connected_at":"2024-05-31T05:23:08Z",
//        "properties":{
//            "nickname":"최주호"
//        }
//    }

//    {
//            "access_token": "MD4HatwY7ykS3rEsFYfkzpz1upkyEI9dAAAAAQo9dJcAAAGPzTMIEiHmgQBvj-MV",
//            "token_type": "bearer",
//            "refresh_token": "L14a0pxftYv0_HMr7t2MNLKfD10Y49dEAAAAAgo9dJcAAAGPzTMIDiHmgQBvj-MV",
//            "expires_in": 21599,
//            "scope": "profile_nickname",
//            "refresh_token_expires_in": 5183999
//    }

//    {
//        "id": 3506315748,
//            "connected_at": "2024-05-31T05:50:25Z",
//            "properties": {
//                 "nickname": "D.K"
//
//         }
//    }
}