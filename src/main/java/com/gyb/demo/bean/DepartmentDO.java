package com.gyb.demo.bean;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Description:
 *
 * @author GB
 * @date 2022/3/4 18:41
 *
 * <pre>
 *              www.dustess.com
 *      Copyright (c) 2022. All Rights Reserved.
 * </pre>
 */
@Data
@ApiModel("DepartmentDO")
public class DepartmentDO implements Serializable {

    private static final long serialVersionUID = -804691803698941757L;

    private Long id;

    /**
     * 上级部门id
     */
    private Long parentId;

    /**
     * 所属租户id
     */
    private Long tenantId;

    /**
     * 部门名称
     */
    private String depName;

    /**
     * 部门说明
     */
    private String depDesc;

    /**
     * 部门等级，1为顶级部门节点
     */
    private Integer depLevel;

    /**
     * 是否可用，0：否，1：是
     */
    private Boolean enable;

    /**
     * 创建人
     * czw 2021-5-25
     */
    /*    private Long createUser;*/

    /**
     * 创建日期
     */
    private Date gmtCreate;

    /**
     * 修改人
     * czw 2021-5-25
     */
    /*    private Long modifyUser;*/

    /**
     * 删除人
     */
    private Long deleteUser;

    /**
     * 删除日期
     */
    private Date deleteDate;

    /**
     * 正常:0    已删除:1
     */
    private Boolean deleted;

    /**
     * 企业微信Id
     */
    private String qwDepartmentId;

    /**
     *  路径
     */
    private String paths;

    /**
     *  全路径名称
     */
    private String pathsName;

    /**
     * 排序
     */
    private Integer sort;
}
