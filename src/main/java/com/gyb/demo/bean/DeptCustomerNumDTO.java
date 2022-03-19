package com.gyb.demo.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * Description:
 *
 * @author GB
 * @date 2022/3/16 20:13
 *
 * <pre>
 *              www.dustess.com
 *      Copyright (c) 2022. All Rights Reserved.
 * </pre>
 */
@Data
public class DeptCustomerNumDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long deptId;

    private Integer num;
}
