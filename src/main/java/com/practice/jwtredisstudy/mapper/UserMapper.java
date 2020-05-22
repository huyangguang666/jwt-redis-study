package com.practice.jwtredisstudy.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.practice.jwtredisstudy.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper extends BaseMapper<User> {

}
