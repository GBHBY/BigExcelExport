package com.gyb.demo.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * student
 * @author 
 */
@Data
public class Student implements Serializable {
    private Integer id;

    private String name;

    private String birth;

    private String sex;

    private String address;

    private String message;

    private String test1;

    private String test2;

    private String test3;

    private static final long serialVersionUID = 1L;

  }