package com.gyb.demo.util;

import com.gyb.demo.bean.CustomerDept;
import com.gyb.demo.bean.DepartmentDO;
import com.gyb.demo.bean.QYEntity;
import com.gyb.demo.controller.QYExport;
import com.gyb.demo.dao.CustomerMapper;
import com.gyb.demo.thread.QYThread;
import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
public class QYExportService extends BigExcelStyle {
    private static int SIZE = 30000;
    final CountDownLatch cdl = new CountDownLatch(1);

    @Autowired
    private QYExport qyExport;
    @Autowired
    private QYExportService qyExportService;


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
     * @return null
     */
    public void createEveryRow(Sheet sheet, QYEntity qy, int i, int number) {
        Row row1 = sheet.createRow(i);
        int line = 0;
        Cell cell1 = row1.createCell(line++);
        cell1.setCellValue(qy.getDeptId());
        cell1.setCellStyle(styleMap.get("head"));


        Cell cell2 = row1.createCell(line++);
        cell2.setCellValue(qy.getYesterdayAddedNum());
        cell1.setCellStyle(styleMap.get("head"));

        Cell cell3 = row1.createCell(line++);
        cell3.setCellValue(qy.getYesterdayLoseNum());
        cell3.setCellStyle(styleMap.get("head"));

        Cell cell4 = row1.createCell(line++);
        cell4.setCellValue(qy.getYesterdayNetIncreaseNum());
        cell4.setCellStyle(styleMap.get("head"));

        Cell cell5 = row1.createCell(line++);
        cell5.setCellValue(qy.getTotalCustomerNum());
        cell5.setCellStyle(styleMap.get("head"));

        Cell cell6 = row1.createCell(line++);
        cell6.setCellValue(qy.getTotalLoseCustomerNum());
        cell6.setCellStyle(styleMap.get("head"));


    }

    /**
     * create by: gb
     * description: TODO
     * create time: 2021/2/25 19:27
     *
     * @param sheet sheet对象
     * @return null
     */
    private void createHeadRow(Sheet sheet) {
        int line = 0;
        Row sheetTitleRow = sheet.createRow(0);
        sheetTitleRow.setHeightInPoints(20);

        Cell cell0 = sheetTitleRow.createCell(line++);
        cell0.setCellValue("部门");
        cell0.setCellStyle(styleMap.get("head"));
        sheet.setColumnWidth(0, "序号".getBytes().length * 2 * 256);

        Cell cell1 = sheetTitleRow.createCell(line++);
        cell1.setCellValue("昨日新增客户数");
        cell1.setCellStyle(styleMap.get("head"));
        sheet.setColumnWidth(1, "序号".getBytes().length * 2 * 256);

        Cell cell2 = sheetTitleRow.createCell(line++);
        cell2.setCellValue("昨日流失客户数");
        cell2.setCellStyle(styleMap.get("head"));
        sheet.setColumnWidth(2, "id".getBytes().length * 2 * 256);

        Cell cell3 = sheetTitleRow.createCell(line++);
        cell3.setCellValue("昨日日净增客户数");
        cell3.setCellStyle(styleMap.get("head"));
        sheet.setColumnWidth(3, "名字".getBytes().length * 10 * 256);

        Cell cell4 = sheetTitleRow.createCell(line++);
        cell4.setCellValue("累计客户总数");
        cell4.setCellStyle(styleMap.get("head"));
        sheet.setColumnWidth(4, "出生日期".getBytes().length * 2 * 256);

        Cell cell5 = sheetTitleRow.createCell(line++);
        cell5.setCellValue("累计流失客户总数");
        cell5.setCellStyle(styleMap.get("head"));
        sheet.setColumnWidth(5, "性别".getBytes().length * 2 * 256);


    }


    public List<QYEntity> findAll() {
        try {
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
            deptList.stream().forEach(x -> {
                if (x.getId().equals(50576L)) {
                    System.out.println();
                }
                List<CustomerDept> allEmp = customerMapper.findAllEmp(x.getPaths());
                pathEmp.put(x.getPaths(), allEmp);

            });


//            部门，员工
            Map<Long, List<Long>> deptEm = new HashMap<>();
            deptList.stream().forEach(x -> {
                //拿到这个路径下的员工集合
                List<CustomerDept> customerDepts = pathEmp.get(x.getPaths());
                // 把一个部门下的所有员工放入，如果是1级部门，就会把全部的员工都放进去
                deptEm.put(x.getId(), customerDepts.parallelStream().map(CustomerDept::getCustomerId).collect(Collectors.toList()));
                deptPath.put(x.getId(), x);
            });
            List<QYEntity> qyEntities = new ArrayList<>();

            for (Map.Entry<Long, List<Long>> entry : deptEm.entrySet()) {
                List<Long> value = entry.getValue();
                Long deptId = entry.getKey();
                //        拿到昨日新增客户数
                QYEntity qyEntity = new QYEntity();
                int yestodayAddLose = 0;
                if (value.size() > 0) {
                    Integer yestodayAddLose1 = customerMapper.getYestodayAddLose(value);
                    if (ObjectUtils.isEmpty(yestodayAddLose1)) {
                        yestodayAddLose = 0;
                    } else {

                        yestodayAddLose = customerMapper.getYestodayAddLose(value);
                    }
                }
                qyEntity.setYesterdayAddedNum(yestodayAddLose);

                qyEntity.setDeptId(deptId);

                //昨日流失
                int yestodayLose = 0;
                if (value.size() > 0) {
                    Integer yestodayLose1 = customerMapper.getYestodayLose(value);
                    if (ObjectUtils.isEmpty(yestodayLose1)) {
                        yestodayLose = 0;
                    } else {
                        yestodayLose = yestodayLose1;

                    }
                }

                qyEntity.setYesterdayLoseNum(yestodayLose);
                //净增
                qyEntity.setYesterdayNetIncreaseNum(qyEntity.getYesterdayAddedNum() - yestodayLose);
                //客户总数。去重
                int none = 0;

                if (value.size() > 0) {
                    none = customerMapper.count(value, "NONE", true);
                }

                //累计失去
                int employee_del = 0;
                if (value.size() > 0) {
                    employee_del = customerMapper.count(value, "EMPLOYEE_DEL", false);
                }
                DepartmentDO departmentDO = deptPath.get(deptId);
                qyEntity.setDeptName(departmentDO.getDepName());
                qyEntity.setTotalCustomerNum(none);
                qyEntity.setTotalLoseCustomerNum(employee_del);
                qyEntity.setPath(departmentDO.getPaths());
                qyEntity.setParentId(departmentDO.getParentId());
                qyEntity.setLevel(departmentDO.getDepLevel());
                qyEntities.add(qyEntity);
            }
            //先倒序
            List<QYEntity> collect = qyEntities.stream().sorted(Comparator.comparing(QYEntity::getLevel)).collect(Collectors.toList());
            return collect;
        } catch (Exception e) {
            System.out.println("报错");
            System.out.println(prinError(e));
        }
        return null;
    }

    public static String prinError(Exception e) {
        StringBuffer messages = new StringBuffer();
        StackTraceElement[] message = e.getStackTrace();
        for (StackTraceElement element : message) {
            messages.append("\t" + element.toString() + "\n");
        }
        return messages.toString();
    }

    //1-50576-50577-50608-50610-50611

    /**
     * 设置上级部门的客户数
     *
     * @return
     */
    private List<QYEntity> setSuperiorCustomerNum(List<QYEntity> list, Map<Long, DepartmentDO> deptPath) {
        list.parallelStream().forEach(x -> {
            if (x.getParentId().equals(1L) || !isShop(x.getDeptName(), x.getLevel())) {
                return;
            } else {
                if (x.getDeptId().equals(51478L) || x.getParentId().equals(51477L)) {
                    System.out.println();
                }
                add(list, x.getParentId(), x);
            }
        });
        QYEntity qyEntity = new QYEntity();
        list.parallelStream().forEach(x -> {
            if (x.getDeptId().equals(1L)) {
                qyEntity.setTotalLoseCustomerNum(x.getTotalLoseCustomerNum());
                qyEntity.setYesterdayLoseNum(x.getYesterdayLoseNum());
                qyEntity.setYesterdayAddedNum(x.getYesterdayAddedNum());
                qyEntity.setYesterdayNetIncreaseNum(x.getYesterdayNetIncreaseNum());
                qyEntity.setTotalCustomerNum(x.getTotalCustomerNum());
            }
        });


        list.parallelStream().forEach(x -> {
            if (x.getDeptId().equals(50576L) || x.getDeptId().equals(50638L)) {
                x.setTotalLoseCustomerNum(qyEntity.getTotalLoseCustomerNum());
                x.setYesterdayLoseNum(qyEntity.getYesterdayLoseNum());
                x.setYesterdayAddedNum(qyEntity.getYesterdayAddedNum());
                x.setYesterdayNetIncreaseNum(qyEntity.getYesterdayNetIncreaseNum());
                x.setTotalCustomerNum(qyEntity.getTotalCustomerNum());
            }

        });

        List<QYEntity> collect = list.stream().sorted(Comparator.comparing(QYEntity::getLevel)).collect(Collectors.toList());
        return collect;
    }

    /**
     * @param list     实体
     * @param id       父级id
     * @param qyEntity 子实体
     */
    private void add(List<QYEntity> list, Long id, QYEntity qyEntity) {
        List<String> parentIds = split(qyEntity.getPath(), String.valueOf(qyEntity.getDeptId()));

        parentIds.parallelStream().forEach(x -> {
            list.stream().forEach(y -> {
                if (x.equals(String.valueOf(y.getDeptId()))) {
                    y.setYesterdayAddedNum(y.getYesterdayAddedNum() + qyEntity.getYesterdayAddedNum());
                    y.setTotalCustomerNum(y.getTotalCustomerNum() + qyEntity.getTotalCustomerNum());
                    y.setTotalLoseCustomerNum(y.getTotalLoseCustomerNum() + qyEntity.getTotalLoseCustomerNum());
                    y.setYesterdayLoseNum(y.getYesterdayLoseNum() + qyEntity.getYesterdayLoseNum());
                    y.setYesterdayNetIncreaseNum(y.getYesterdayNetIncreaseNum() + qyEntity.getYesterdayNetIncreaseNum());
                }
            });
        });
    }

    public static void main(String[] args) {
//        split("1-50576-50577-50608-50610-50611");

    }

    //1-50576-50577-50608-50610-50611
    private List<String> split(String path, String id) {
        String[] split = path.split("-");
        List<String> strings = Arrays.asList(split);
        List<String> collect = strings.parallelStream().filter(a -> !Objects.equals("1", a)).filter(a -> !Objects.equals(a, id)).collect(Collectors.toList());
        return collect;
    }


    private boolean isShop(String name, int level) {

        if (8 == level || name.endsWith("诊所") || name.endsWith("店") || name.endsWith("药房") || name.endsWith("食品") || name.endsWith("卖场") || name.endsWith("保健")) {
            return true;
        } else {
            return false;
        }


    }


}
