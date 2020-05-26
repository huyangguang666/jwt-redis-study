package com.practice.jwtredisstudy.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.practice.jwtredisstudy.domain.User;
import org.springframework.stereotype.Service;

/**
 * 生成token
 */
@Service
public class TokenServiceImpl implements TokenService {

    public String getToken(User user) {
        String token = "";
        token = JWT.create().withAudience(String.valueOf(user.getId()))//将user id保存到token里面
                .sign(Algorithm.HMAC256(user.getPassword()));//以password作为token的密钥
        return token;
    }
}
