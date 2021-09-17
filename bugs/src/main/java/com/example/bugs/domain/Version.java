package com.example.bugs.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName("version")
@Data
public class Version {
    @TableId
    private Integer id;
    private String version;
    private String detail;
    private String createBy;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    private String modifyBy;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
