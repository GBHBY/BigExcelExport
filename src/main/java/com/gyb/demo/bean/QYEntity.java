package com.gyb.demo.bean;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Description:
 *
 * @author GB
 * @date 2022/3/3 16:35
 *
 * <pre>
 *              www.dustess.com
 *      Copyright (c) 2022. All Rights Reserved.
 * </pre>
 */
@Data
public class QYEntity implements Serializable {


    @ApiModelProperty(value = "日新增客户数")
    private Integer yesterdayAddedNum;

    @ApiModelProperty(value = "日员工删除客户数")
    private Integer yesterdayEmployeeDel;



    @ApiModelProperty(value = "日客户删除员工数")
    private Integer yesterdayCustomerDel;

    @ApiModelProperty(value = "累计客户总数")
    private Integer totalCustomerNum;

    @ApiModelProperty(value = "部门Id")
    private Long deptId;

    @ApiModelProperty(value = "部门名称")
    private String deptName;

    @ApiModelProperty(value = "路径")
    private String path;

    @ApiModelProperty(value = "级别")
    private Integer level;

    @ApiModelProperty(value = "日期")
    private LocalDate localDate;


    private static final long serialVersionUID = 9147621738022695711L;
}
