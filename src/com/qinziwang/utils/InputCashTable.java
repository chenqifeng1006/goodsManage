package com.qinziwang.utils;

import java.sql.Timestamp;

import com.qinziwang.domain.MemberInfo;
public class InputCashTable {
    /*收入编号*/
    private int inputId;
    public int getInputId() {
        return inputId;
    }
    public void setInputId(int inputId) {
        this.inputId = inputId;
    }

    /*收入者*/
    private MemberInfo member;
    public MemberInfo getMember() {
        return member;
    }
    public void setMember(MemberInfo member) {
        this.member = member;
    }

    /*收入来源*/
    private String inputsComesFrom;
    public String getInputsComesFrom() {
        return inputsComesFrom;
    }
    public void setInputsComesFrom(String inputsComesFrom) {
        this.inputsComesFrom = inputsComesFrom;
    }

    /*收入类型*/
    private ClassInputCashTable inputFroms;
    public ClassInputCashTable getInputFroms() {
        return inputFroms;
    }
    public void setInputFroms(ClassInputCashTable inputFroms) {
        this.inputFroms = inputFroms;
    }

    /*支付方式*/
    private PayWay payWayObj;
    public PayWay getPayWayObj() {
        return payWayObj;
    }
    public void setPayWayObj(PayWay payWayObj) {
        this.payWayObj = payWayObj;
    }

    /*收入金额*/
    private float inputCash;
    public float getInputCash() {
        return inputCash;
    }
    public void setInputCash(float inputCash) {
        this.inputCash = inputCash;
    }

    /*收入日期*/
    private Timestamp inputDateTime;
    public Timestamp getInputDateTime() {
        return inputDateTime;
    }
    public void setInputDateTime(Timestamp inputDateTime) {
        this.inputDateTime = inputDateTime;
    }

    /*备注信息*/
    private String inputContent;
    public String getInputContent() {
        return inputContent;
    }
    public void setInputContent(String inputContent) {
        this.inputContent = inputContent;
    }

}