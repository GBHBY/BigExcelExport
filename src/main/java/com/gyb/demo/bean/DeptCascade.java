package com.gyb.demo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Description:
 *
 * @author GB
 * @date 2022/3/19 22:55
 *
 * <pre>
 *              www.dustess.com
 *      Copyright (c) 2022. All Rights Reserved.
 * </pre>
 */
@ApiModel(value = "DeptCascade", description = "部门级联")
@Data
public class DeptCascade implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "部门名称")
    private String name;

    @ApiModelProperty(value = "部门路径")
    private String path;

    @ApiModelProperty(value = "1级父部门")
    private String firstFatherName;

    @ApiModelProperty(value = "二级父部门")
    private String secFatherName;

    @ApiModelProperty(value = "3级父部门")
    private String thirdFatherName;

    @ApiModelProperty(value = "4级父部门")
    private String fourthFatherName;

    @ApiModelProperty(value = "5级父部门")
    private String fifthFatherName;

    @ApiModelProperty(value = "6级父部门")
    private String sixthFatherName;


    @ApiModelProperty(value = "7级父部门")
    private String seventhFatherName;

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty("等级")
    private Integer level;
}
