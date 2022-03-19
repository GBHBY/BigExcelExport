package com.gyb.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gyb.demo.bean.CustomerDetailDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Description:
 *
 * @author GB
 * @date 2022/3/8 11:44
 *
 * <pre>
 *              www.dustess.com
 *      Copyright (c) 2022. All Rights Reserved.
 * </pre>
 */
@Repository
public interface CustomerDetailMapper extends BaseMapper<CustomerDetailDO> {
    /**
     *  计算净增
     * @param value 员工id
     * @param date
     * @return
     */
    List<Long> selectIncrease(@Param("ids") List<Long> value, @Param("date") LocalDate date);

    List<CustomerDetailDO> selectCusDelete(@Param("ids") List<Long> value, @Param("date") LocalDate date);

    List<CustomerDetailDO> selectAllCustomer(@Param("ids") List<Long> value,@Param("date") LocalDate date);


    Integer selectAddAllNum(@Param("ids") List<Long> value);

    List<CustomerDetailDO> selectUpToDate(@Param("ids") List<Long> idCustomer, @Param("date") LocalDate localDate);


}
