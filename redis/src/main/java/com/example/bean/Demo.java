package com.example.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Demo implements Serializable {

    private String name;

    private Boolean flag;

    public Demo() {
    }
}
