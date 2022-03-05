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
    private Integer Id;

    private String Name;

    private String Birth;

    private String Sex;

    private String Address;

    private String Message;

    private String Test1;

    private String Test2;

    private String Test3;

    private static final long serialVersionUID = 1L;

}