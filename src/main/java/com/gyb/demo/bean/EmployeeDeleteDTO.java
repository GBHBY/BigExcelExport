package com.gyb.demo.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Description:
 *
 * @author GB
 * @date 2022/3/9 21:39
 *
 * <pre>
 *              www.dustess.com
 *      Copyright (c) 2022. All Rights Reserved.
 * </pre>
 */
@Data
@ApiModel(value = "EmployeeDeleteDTO",description = "客户对应各种情况的数量")
public class EmployeeDeleteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 类型：客户删除员工：CUS_DEL;员工删除客户：EMP_DEL;添加客户ADD;
     */
    @ApiModelProperty(value = "类型：客户删除员工：CUS_DEL;员工删除客户：EMP_DEL;添加客户ADD;")
    private String type;

    /**
     * 员工id
     */
    @ApiModelProperty(value = "员工id")
    private Long idEmployee;

    /**
     * 客户id
     */
    @ApiModelProperty(value = "客户id")
    private Long idCustomer;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreate;

    /**
     * 添加客户时间或删除时间（避免时间格式化）
     */
    @ApiModelProperty(value = "创建时间（避免时间格式化）")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;


    private String state;





}
