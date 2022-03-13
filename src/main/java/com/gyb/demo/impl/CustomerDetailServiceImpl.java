package com.gyb.demo.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gyb.demo.bean.CustomerDetailDO;
import com.gyb.demo.dao.CustomerDetailMapper;
import com.gyb.demo.service.CustomerDetailService;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @author GB
 * @date 2022/3/8 11:47
 *
 * <pre>
 *              www.dustess.com
 *      Copyright (c) 2022. All Rights Reserved.
 * </pre>
 */
@Service
public class CustomerDetailServiceImpl extends ServiceImpl<CustomerDetailMapper, CustomerDetailDO> implements CustomerDetailService {
}
