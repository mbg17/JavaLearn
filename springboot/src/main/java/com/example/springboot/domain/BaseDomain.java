package com.example.springboot.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseDomain implements Serializable {
    /**
     *
     */
    private Integer createBy;

    /**
     *
     */
    private Date createTime;

    /**
     *
     */
    private Integer updateBy;

    /**
     *
     */
    private Date updateTime;
}
