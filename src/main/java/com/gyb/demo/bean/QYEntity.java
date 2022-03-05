package com.gyb.demo.bean;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

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


    @ApiModelProperty(value = "昨日新增数")
    private Integer yesterdayAddedNum;

    @ApiModelProperty(value = "昨日流失数")
    private Integer yesterdayLoseNum;

    @ApiModelProperty(value = "昨日净增人数")
    private Integer yesterdayNetIncreaseNum;

    @ApiModelProperty(value = "累计客户总数")
    private Integer totalCustomerNum;

    @ApiModelProperty(value = "累计流失总数")
    private Integer totalLoseCustomerNum;

    @ApiModelProperty(value = "部门Id")
    private Long deptId;

    @ApiModelProperty(value = "父级部门Id")
    private Long parentId;

    @ApiModelProperty(value = "部门名称")
    private String deptName;

    @ApiModelProperty(value = "路径")
    private String path;


    private Integer level;


    private static final long serialVersionUID = 9147621738022695711L;
}
