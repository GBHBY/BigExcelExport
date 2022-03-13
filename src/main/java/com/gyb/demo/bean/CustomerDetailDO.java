package com.gyb.demo.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author gyb
 */
@ApiModel(value = "generate.BfCustomerDetail")
@TableName("bf_customer_detail_copy1")
@Data
public class CustomerDetailDO implements Serializable {
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    @TableId(type = IdType.AUTO)
    private Long id;

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
    private Date gmtCreate;

    /**
     * 创建时间（避免时间格式化）
     */
    @ApiModelProperty(value = "创建时间（避免时间格式化）")
    private Date createTime;

    /**
     * 最新的状态
     */
    @ApiModelProperty(value = "最新的状态")
    private String state;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    private Date gmtModify;

    private static final long serialVersionUID = 1L;
}