package com.example.bugs.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName("list")
@Data
public class Lists {
    @TableId
    private Integer id;
    private String project;
    private String module;
    private String title;
    private int priority;
    private int level;
    private String version;
    private String people;
    private String createBy;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    private String modifyBy;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
