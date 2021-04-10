package com.springboot.demo.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value="t_user")
public class User {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer  id;
    private String username;
    private String password;
    private String salt;
    @TableLogic
    private Integer active;
}