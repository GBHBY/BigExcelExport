package com.gyb.demo.util;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.gyb.demo.bean.*;
import com.gyb.demo.controller.QYExport;
import com.gyb.demo.dao.CustomerDetailMapper;
import com.gyb.demo.dao.CustomerMapper;
import com.gyb.demo.thread.QuanYeeThread;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
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

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    /**
     * 所有部门信息集合
     */
    private static final String ALL_DEPARTMENT_KEY = "ALL_DEPARTMENT";

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

    private final String CUSTOMER_NUM_KEY = "CUSTOMER_NUM";


    @Autowired
    private CustomerMapper customerMapper;


    public void exportExcel(File file, String date) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor
                (2, 4, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(4));

        SXSSFWorkbook wb = new SXSSFWorkbook(60000);
        wb.setCompressTempFiles(true);
        styleMap.clear();
        styleMap.put("head", getAndSetXSSFCellStyleHeader(wb));
        styleMap.put("text", getDataTextStyleEven(wb));
        Sheet sheet = wb.createSheet("统计");
        createHeadRow(sheet);
        long l = System.currentTimeMillis();
        QuanYeeThread exportThread1 = new QuanYeeThread(600000, SIZE, qyExportService, qyExport, sheet, 1, 1, 1, date);
        exportThread1.run();
        long l1 = System.currentTimeMillis();
        log.info("插入时间：{}", (l1 - l) / 1000);
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
        if(ObjectUtils.isEmpty(qy.getTotalCustomerNum())){
            System.out.println();
            qy.setTotalCustomerNum(888888);
        }

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
        cell3.setCellValue("日员工删除客户数");
        cell3.setCellStyle(styleMap.get("head"));
        sheet.setColumnWidth(3, "名字".getBytes().length * 10 * 256);

        Cell cell4 = sheetTitleRow.createCell(line++);
        cell4.setCellValue("日客户删除员工数");
        cell4.setCellStyle(styleMap.get("head"));
        sheet.setColumnWidth(4, "出生日期".getBytes().length * 2 * 256);


        Cell cell5 = sheetTitleRow.createCell(line++);
        cell5.setCellValue("累计客户总数");
        cell5.setCellStyle(styleMap.get("head"));
        sheet.setColumnWidth(5, "出生日期".getBytes().length * 2 * 256);


    }

    /**
     * 获取每个部门的员工列表
     *
     * @return
     */
    public Map<Long, List<Long>> getDeptEmployee() {
//            部门，员工
        Map<Long, List<Long>> deptEm = new HashMap<>();

        Object deptEmployee = stringRedisTemplate.opsForValue().get(ALL_DEPARTMENT_KEY);
        if (ObjectUtils.isNotEmpty(deptEmployee)) {
            Map<String, List<String>> temMap = JSONUtil.toBean(deptEmployee.toString(), Map.class);
            for (Map.Entry<String, List<String>> entry : temMap.entrySet()) {
                JSONArray jsonArray = JSONUtil.parseArray(entry.getValue());
                List<Long> ids = JSONUtil.toList(jsonArray, Long.class);
                deptEm.put(Long.valueOf(entry.getKey()), ids);

            }
            return deptEm;
        }


        //所有部门
        List<DepartmentDO> deptList = customerMapper.finadAllDept();

        //路径，人员
        Map<String, List<CustomerDept>> pathEmp = new HashMap<>();

        //拿到员工
        deptList.forEach(x -> {
            List<CustomerDept> allEmp = customerMapper.findAllEmp(x.getPaths());
            pathEmp.put(x.getPaths(), allEmp);

        });

        deptList.forEach(x -> {
            //拿到这个路径下的员工集合
            List<CustomerDept> customerDepts = pathEmp.get(x.getPaths());
            // 把一个部门下的所有员工放入，如果是1级部门，就会把全部的员工都放进去
            deptEm.put(x.getId(), customerDepts.parallelStream().map(CustomerDept::getCustomerId).collect(Collectors.toList()));
        });

        return deptEm;
    }


    /**
     * @param date
     * @return
     */
    public List<QYEntity> findAll(String date) {
        long l = System.currentTimeMillis();
        try {
            LocalDate localDate = LocalDate.parse(date);
            Map<Long, List<Long>> deptEm = getDeptEmployee();

            List<QYEntity> qyEntities = new ArrayList<>();
            log.info("获取部门耗时{}秒", (System.currentTimeMillis() - 1));

            Map<String, Integer> allCustomer = getAllCustomer(localDate, deptEm);

            for (Map.Entry<Long, List<Long>> entry : deptEm.entrySet()) {
//            List<Long> value = new ArrayList<>();
//            value.add(1L);
//            value.add(2L);
//            value.add(3L);
//            value.add(4L);
//            value.add(5L);
//            Long deptId = 1L;
                List<Long> value = entry.getValue();
                Long deptId = entry.getKey();
                QYEntity qyEntity = new QYEntity();
                qyEntity.setDeptId(deptId);
                qyEntity.setLocalDate(localDate);
                if (value.size() == 0) {
                    qyEntity.setDeptId(deptId);
                    qyEntity.setTotalCustomerNum(0);
                    qyEntity.setYesterdayAddedNum(0);
                    qyEntity.setYesterdayCustomerDel(0);
                    qyEntity.setYesterdayEmployeeDel(0);
                    qyEntities.add(qyEntity);
                    continue;

                }
                //拿到今日新增的客户id，并去重
                List<Long> idList = customerDetailMapper.selectIncrease(value, localDate);
                //拿到该部门下所有已经是好友的客户
                List<Long> allAddCustomer = customerMapper.selectAddCustomerIds(value, localDate.minusDays(1));
//                idList.removeAll(allAddCustomer);
                List<Long> longs = removeAll(idList, allAddCustomer);

                qyEntity.setYesterdayAddedNum(longs.size());
                //累计客户
                Integer all = allCustomer.get(String.valueOf(deptId));
                if(ObjectUtils.isEmpty(all)){
                    System.out.println();
                }
                //拿到所有客户id
                qyEntity.setTotalCustomerNum(all);
                //拿到日期为date的被删除的客户id
                List<Long> todayDeleteCusList = customerDetailMapper.selectCusDelete(value, localDate).parallelStream().map(CustomerDetailDO::getIdCustomer).collect(Collectors.toList());
                if (todayDeleteCusList.size() > 0) {

                    //拿到date日期被删除的客户和他的员工的最新关系是ADD的

                    List<CustomerDetailDO> upDateIsAdd = customerDetailMapper.selectUpToDate(todayDeleteCusList, localDate);
                    List<Long> upDateIsAddId = upDateIsAdd.parallelStream().filter(x -> StringUtils.equals(ADD, x.getState())).map(CustomerDetailDO::getIdCustomer).collect(Collectors.toList());


                    //此时的todayDeleteCusList全部为完全解除关系的客户id
                    todayDeleteCusList.removeAll(upDateIsAddId);
                    //计算员工删除的客户数
                    // 拿到今天所有的员工和客户关系
                    List<CustomerDetailDO> todayCustomerDetailDOS = customerDetailMapper.selectAllCustomer(value, localDate);

                    //此时的customerId就已经都是非客户id

                    //非客户
                    List<CustomerDetailDO> notCustomerAll = new ArrayList<>();
                    todayDeleteCusList.stream().forEach(x -> {
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
                        List<CustomerDetailDO> doubleRemoveList = map.getValue();
                        String type = doubleRemoveList.parallelStream().sorted(Comparator.comparing(CustomerDetailDO::getId).reversed()).collect(Collectors.toList()).get(0).getType();
                        if (type.equals(EMPLOYEE_DEL)) {
                            employeeDeleteNum++;
                        } else {
                            customerDeleteNum++;
                        }


                    }
                    qyEntity.setYesterdayEmployeeDel(employeeDeleteList.parallelStream().map(CustomerDetailDO::getIdCustomer).distinct().collect(Collectors.toList()).size() - customerDeleteNum);
                    qyEntity.setYesterdayCustomerDel(customerDeleteList.parallelStream().map(CustomerDetailDO::getIdCustomer).distinct().collect(Collectors.toList()).size() - employeeDeleteNum);
                } else {

                    qyEntity.setYesterdayEmployeeDel(0);
                    qyEntity.setYesterdayCustomerDel(0);
                }

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


    /**
     * Description: 获取每个部门的总客户数
     * params:
     * author: GB
     * datetime: 2022/3/16 20:05
     */

    public Map<String, Integer> getAllCustomer(LocalDate localDate, Map<Long, List<Long>> deptEm) {

        String s = stringRedisTemplate.opsForValue().get(CUSTOMER_NUM_KEY);
        if (StringUtils.isBlank(s)) {

            //每个部门的总客户数
            Map<String, Integer> allCustomerNum = new HashMap<>(128);
            for (Map.Entry<Long, List<Long>> map : deptEm.entrySet()) {
                Integer none = customerMapper.count(map.getValue(), "NONE", localDate);
                allCustomerNum.put(String.valueOf(map.getKey()), none);
            }
            stringRedisTemplate.opsForValue().set(CUSTOMER_NUM_KEY, JSONUtil.parseObj(allCustomerNum, false).toString(), 1, TimeUnit.DAYS);

            return allCustomerNum;

        } else {
            Map map1 = JSONUtil.toBean(s, Map.class);
            return map1;
        }
    }


    public static void main(String[] args) {
        List<Integer> ids = new ArrayList<>();
        ids.add(213);
        ids.add(214);
        ids.add(215);
        ids.add(216);
        ids.add(217);
        ids.add(219);
        List<Integer> ids2 = new ArrayList<>();
        ids2.add(213);
        ids2.add(214);
        ids2.add(215);
        ids2.add(216);
        ids2.add(217);
        ids2.add(2312);
        ids2.add(2315);
        ids2.add(2317);
        ids.removeAll(ids2);
        System.out.println();

    }

    public List<Long> removeAll(List<Long> source, List<Long> destination) {
        List<Long> result = new LinkedList<>();
        Set<Long> destinationSet = new HashSet<Long>(destination);
        for(Long t : source) {
            if (!destinationSet.contains(t)) {
                result.add(t);
            }
        }
        return result;
    }


}
