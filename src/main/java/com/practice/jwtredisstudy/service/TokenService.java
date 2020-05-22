package com.practice.jwtredisstudy.service;

import com.practice.jwtredisstudy.domain.User;

public interface TokenService {

    String getToken(User user);
}
