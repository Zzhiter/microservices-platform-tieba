package com.central.post.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.central.post.model.User;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {
    public String getToken(User user) {
        Date start = new Date();
        Date end = new Date(start.getTime() + (long) 30 * 24 * 60 * 60 * 1000);//30天有效时间
        return JWT.create().withAudience(user.getUid().toString()).withIssuedAt(start)
                .withExpiresAt(end).sign(Algorithm.HMAC256(user.getPassword()));
    }
}
