package com.gyb.demo.util;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.gyb.demo.bean.*;
import com.gyb.demo.controller.QYExport;
import com.gyb.demo.dao.CustomerDetailMapper;
import com.gyb.demo.dao.CustomerMapper;
import com.gyb.demo.thread.QYThread;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * Description:
 *
 * @author GB
 * @date 2022/3/3 16:34
 *
 * <pre>
 *              www.dustess.com
 *      Copyright (c) 2022. All Rights Reserved.
 * </pre>
 */
@Component
@Slf4j
public class QYExportService extends BigExcelStyle {
    private static int SIZE = 30000;
    final CountDownLatch cdl = new CountDownLatch(1);

    @Autowired
    private QYExport qyExport;
    @Autowired
    private QYExportService qyExportService;

    @Autowired
    private CustomerDetailMapper customerDetailMapper;


    private final String CUSTOMER_DEL = "CUSTOMER_DEL";
    private final String EMPLOYEE_DEL = "EMPLOYEE_DEL";
    private final String ADD = "ADD";


    @Autowired
    private CustomerMapper customerMapper;


    public void exportExcel(File file) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor
                (2, 4, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(4));

        SXSSFWorkbook wb = new SXSSFWorkbook(60000);
        wb.setCompressTempFiles(true);
        styleMap.clear();
        styleMap.put("head", getAndSetXSSFCellStyleHeader(wb));
        styleMap.put("text", getDataTextStyleEven(wb));
        Sheet sheet = wb.createSheet("demo");
        createHeadRow(sheet);
        long l = System.currentTimeMillis();
        QYThread exportThread1 = new QYThread(600000, SIZE, qyExportService, qyExport, sheet, 1, 1, 1);
        exportThread1.run();


        long l1 = System.currentTimeMillis();
        System.out.println("插入时间：" + (l1 - l) / 1000);
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(file);
            wb.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(out);
        }


    }

    /**
     * create by: gb
     * description:
     * create time: 2021/2/25 19:27
     *
     * @param sheet  sheet对象
     * @param qy     实体类对象
     * @param i      行数
     * @param number 行值
     */
    public void createEveryRow(Sheet sheet, QYEntity qy, int i, int number) {
        Row row1 = sheet.createRow(i);
        int line = 0;
        Cell cell1 = row1.createCell(line++);
        cell1.setCellValue(qy.getLocalDate().toString());
        cell1.setCellStyle(styleMap.get("head"));

        Cell cell2 = row1.createCell(line++);
        cell2.setCellValue(qy.getDeptId());
        cell2.setCellStyle(styleMap.get("head"));


        Cell cell3 = row1.createCell(line++);
        cell3.setCellValue(qy.getYesterdayAddedNum());
        cell3.setCellStyle(styleMap.get("head"));

        Cell cell4 = row1.createCell(line++);
        cell4.setCellValue(qy.getYesterdayEmployeeDel());
        cell4.setCellStyle(styleMap.get("head"));

        Cell cell5 = row1.createCell(line++);
        cell5.setCellValue(qy.getYesterdayCustomerDel());
        cell5.setCellStyle(styleMap.get("head"));

        Cell cell6 = row1.createCell(line++);
        cell6.setCellValue(qy.getTotalCustomerNum());
        cell6.setCellStyle(styleMap.get("head"));


    }

    /**
     * create by: gb
     * description: TODO
     * create time: 2021/2/25 19:27
     *
     * @param sheet sheet对象
     */
    private void createHeadRow(Sheet sheet) {
        int line = 0;
        Row sheetTitleRow = sheet.createRow(0);
        sheetTitleRow.setHeightInPoints(20);

        Cell cell0 = sheetTitleRow.createCell(line++);
        cell0.setCellValue("日期");
        cell0.setCellStyle(styleMap.get("head"));
        sheet.setColumnWidth(0, "序号".getBytes().length * 2 * 256);

        Cell cell1 = sheetTitleRow.createCell(line++);
        cell1.setCellValue("部门");
        cell1.setCellStyle(styleMap.get("head"));
        sheet.setColumnWidth(1, "序号".getBytes().length * 2 * 256);

        Cell cell2 = sheetTitleRow.createCell(line++);
        cell2.setCellValue("日新增客户数");
        cell2.setCellStyle(styleMap.get("head"));
        sheet.setColumnWidth(2, "id".getBytes().length * 2 * 256);

        Cell cell3 = sheetTitleRow.createCell(line++);
        cell3.setCellValue("昨日员工删除客户数");
        cell3.setCellStyle(styleMap.get("head"));
        sheet.setColumnWidth(3, "名字".getBytes().length * 10 * 256);

        Cell cell4 = sheetTitleRow.createCell(line++);
        cell4.setCellValue("昨日客户删除员工数");
        cell4.setCellStyle(styleMap.get("head"));
        sheet.setColumnWidth(4, "出生日期".getBytes().length * 2 * 256);


        Cell cell5 = sheetTitleRow.createCell(line++);
        cell5.setCellValue("累计客户总数");
        cell5.setCellStyle(styleMap.get("head"));
        sheet.setColumnWidth(5, "出生日期".getBytes().length * 2 * 256);


    }

    /**
     * @return
     */
    public List<QYEntity> findAll() {
        try {
            LocalDate date = LocalDate.of(2022, Month.MARCH, 12);
            //所有部门
            List<DepartmentDO> deptList = customerMapper.finadAllDept();

            //路径，部门
            Map<String, DepartmentDO> pathDept = new HashMap<>();

            deptList.parallelStream().forEach(x -> {
                pathDept.put(x.getPaths(), x);
            });

            // 部门
            Map<Long, DepartmentDO> deptPath = new HashMap<>();
            //路径，人员
            Map<String, List<CustomerDept>> pathEmp = new HashMap<>();

            //拿到员工
            deptList.forEach(x -> {
                List<CustomerDept> allEmp = customerMapper.findAllEmp(x.getPaths());
                pathEmp.put(x.getPaths(), allEmp);

            });

//            部门，员工
            Map<Long, List<Long>> deptEm = new HashMap<>();
            deptList.forEach(x -> {
                //拿到这个路径下的员工集合
                List<CustomerDept> customerDepts = pathEmp.get(x.getPaths());
                // 把一个部门下的所有员工放入，如果是1级部门，就会把全部的员工都放进去
                deptEm.put(x.getId(), customerDepts.parallelStream().map(CustomerDept::getCustomerId).collect(Collectors.toList()));
                deptPath.put(x.getId(), x);
            });
            List<QYEntity> qyEntities = new ArrayList<>();

            for (Map.Entry<Long, List<Long>> entry : deptEm.entrySet()) {
//            List<Long> value = new ArrayList<>();
//            value.add(1L);
//            value.add(2L);
//            value.add(3L);
//            Long deptId = 1L;
                List<Long> value = entry.getValue();
                Long deptId = entry.getKey();
                QYEntity qyEntity = new QYEntity();
                qyEntity.setDeptId(deptId);
                qyEntity.setLocalDate(date);
                if (value.size() == 0) {
                    qyEntity.setDeptId(deptId);
                    qyEntity.setTotalCustomerNum(0);
                    qyEntity.setYesterdayAddedNum(0);
                    qyEntity.setYesterdayCustomerDel(0);
                    qyEntity.setYesterdayEmployeeDel(0);
                    qyEntities.add(qyEntity);
                    continue;

                }
                //计算净增
                Integer increase = customerDetailMapper.selectIncrease(value, date);
                qyEntity.setYesterdayAddedNum(increase);
                //累计客户
                Integer all = customerMapper.count(value, "NONE", date);
                //拿到所有客户id
                //*************************************千万不要忘记这个要从客户关系表中查********************************************//
                qyEntity.setTotalCustomerNum(customerDetailMapper.selectAddAllNum(value));
                List<Long> customerId = customerDetailMapper.selectCusDelete(value, date).parallelStream().map(EmployeeCustomerListDTO::getIdCustomer).collect(Collectors.toList());
                //计算员工删除客户数
                // 拿到今天所有的员工和客户关系
                List<CustomerDetailDO> todayCustomerDetailDOS = customerDetailMapper.selectAllCustomer(value, date);
                //拿到全部的员工客户关系,包括以前的
                List<CustomerDetailDO> customerDetailDOS = customerDetailMapper.selectAllCustomer(value, null);
                //拿到还是客户的客户id
                List<Long> isCustomer = customerDetailDOS.parallelStream().filter(x -> StringUtils.equals(x.getState(), ADD)).map(CustomerDetailDO::getIdCustomer).collect(Collectors.toList());
                //此时的customerId就已经都是非客户id
                customerId.removeAll(isCustomer);
                //非客户
                List<CustomerDetailDO> notCustomerAll = new ArrayList<>();
                customerId.stream().forEach(x -> {
                    todayCustomerDetailDOS.forEach(y -> {
                        Long idCustomer = y.getIdCustomer();
                        if (x.equals(idCustomer)) {
                            notCustomerAll.add(y);
                        }
                    });
                });
                //把删除客户或者客户删除员工的那一条记录拿到
                List<CustomerDetailDO> notCustomer = notCustomerAll.parallelStream().filter(x -> StringUtils.equals(x.getState(), x.getType())).collect(Collectors.toList());
                //是员工删除客户的集合
                List<CustomerDetailDO> customerDeleteList = notCustomer.parallelStream().filter(x -> StringUtils.equals(x.getState(), CUSTOMER_DEL)).collect(Collectors.toList());
                //客户删除员工的集合
                List<CustomerDetailDO> employeeDeleteList = notCustomer.parallelStream().filter(x -> StringUtils.equals(x.getState(), EMPLOYEE_DEL)).collect(Collectors.toList());
                List<Long> customerDeleteIds = customerDeleteList.parallelStream().map(CustomerDetailDO::getIdCustomer).collect(Collectors.toList());
                List<Long> employeeDeleteIds = employeeDeleteList.parallelStream().map(CustomerDetailDO::getIdCustomer).collect(Collectors.toList());
                //双删客户
                List<Long> doubleRemove = customerDeleteIds.parallelStream().filter(employeeDeleteIds::contains).collect(Collectors.toList());
                //双删客户实体
                List<CustomerDetailDO> doubleRemoveEntity = new ArrayList<>();
                doubleRemove.parallelStream().forEach(x -> {
                    todayCustomerDetailDOS.forEach(y -> {
                        if (x.equals(y.getIdCustomer())) {
                            doubleRemoveEntity.add(y);
                        }
                    });
                });
                int customerDeleteNum = 0;
                int employeeDeleteNum = 0;
                //根据客户id分组
                Map<Long, List<CustomerDetailDO>> doubleRemoveGroup = doubleRemoveEntity.parallelStream().collect(Collectors.groupingBy(CustomerDetailDO::getIdCustomer));


                for (Map.Entry<Long, List<CustomerDetailDO>> map : doubleRemoveGroup.entrySet()) {
                    Long idCustomer = map.getKey();
                    List<CustomerDetailDO> doubleRemoveList = map.getValue();
                    String type = doubleRemoveList.parallelStream().sorted(Comparator.comparing(CustomerDetailDO::getId).reversed()).collect(Collectors.toList()).get(0).getType();
                    if (type.equals(EMPLOYEE_DEL)) {
                        employeeDeleteNum++;
                    } else {
                        customerDeleteNum++;
                    }


                }

                qyEntity.setYesterdayEmployeeDel(employeeDeleteList.size() - customerDeleteNum);
                qyEntity.setYesterdayCustomerDel(customerDeleteList.size() - employeeDeleteNum);

                qyEntities.add(qyEntity);
            }
            //先倒序
            return qyEntities;
        } catch (
                Exception e) {
            log.error("错误", e);
        }
        return null;
    }


}
