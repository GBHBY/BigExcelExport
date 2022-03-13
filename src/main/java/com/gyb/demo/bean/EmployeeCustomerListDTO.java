package com.gyb.demo.bean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Description:
 *
 * @author GB
 * @date 2022/3/10 3:57
 *
 * <pre>
 *              www.dustess.com
 *      Copyright (c) 2022. All Rights Reserved.
 * </pre>
 */
@Data
@ApiModel("EmployeeCustomerListDTO")
public class EmployeeCustomerListDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("员工id")
    private Long idCustomer;

    @ApiModelProperty(value = "员工删除客户集合")
    private List<EmployeeDeleteDTO> employeeDeleteDTO;

}
