package com.qinziwang.utils;

import java.sql.Timestamp;
public class ClassInputCashTable {
    /*收入类型编号*/
    private int inputClassId;
    public int getInputClassId() {
        return inputClassId;
    }
    public void setInputClassId(int inputClassId) {
        this.inputClassId = inputClassId;
    }

    /*收入类型名称*/
    private String inputClassName;
    public String getInputClassName() {
        return inputClassName;
    }
    public void setInputClassName(String inputClassName) {
        this.inputClassName = inputClassName;
    }

}