package com.example.bugs.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("user")
public class User {
    @TableId
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String createBy;
    private Date createTime;
    private String modifyBy;
    @TableField(fill = FieldFill.UPDATE)
    private String updateTime;
}
