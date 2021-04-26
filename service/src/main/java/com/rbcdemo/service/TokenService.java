package com.rbcdemo.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.rbcdemo.dao.entity.User;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    public String getToken(User user) {
        String token="";
        token= JWT.create().withAudience(user.getId().toString())
                .sign(Algorithm.HMAC256(user.getUserPassword()));
        return token;
    }
}
