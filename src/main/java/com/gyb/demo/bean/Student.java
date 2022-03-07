package com.gyb.demo.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * student
 *
 * @author
 */
@Data
public class Student implements Serializable {
    private Integer sId;

    private String sName;

    private String sBirth;

    private String sSex;

    private String sAddress;

    private String sMessage;

    private String sTest1;

    private String sTest2;

    private String sTest3;

    private static final long serialVersionUID = 1L;

}