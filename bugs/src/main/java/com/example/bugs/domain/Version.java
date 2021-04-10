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
    private Date createTime;
    private String modifyBy;
    @TableField(fill = FieldFill.UPDATE)
    private String updateTime;
}
