package com.practice.jwtredisstudy.domain;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

@TableName("t_sys_user")
@Getter
@Setter
public class User extends Model {

    private Long id;

    private String username;

    private String password;

    @TableField("del_flag")
    Integer delFlag;

    @TableField("created_at")
    Timestamp createdAt;

    @TableField("updated_at")
    Timestamp updatedAt;

    @Override
    protected Serializable pkVal() {
        return null;
    }
}
