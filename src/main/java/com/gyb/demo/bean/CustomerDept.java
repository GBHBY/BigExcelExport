package com.gyb.demo.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * Description:
 *
 * @author GB
 * @date 2022/3/3 17:06
 *
 * <pre>
 *              www.dustess.com
 *      Copyright (c) 2022. All Rights Reserved.
 * </pre>
 */
@Data
public class CustomerDept implements Serializable {

    private Long deptId;

    private Long customerId;

    private static final long serialVersionUID = 1L;
}
