package com.qinziwang.utils;

import java.sql.Timestamp;

import com.qinziwang.domain.MemberInfo;
public class InputCashTable {
    /*������*/
    private int inputId;
    public int getInputId() {
        return inputId;
    }
    public void setInputId(int inputId) {
        this.inputId = inputId;
    }

    /*������*/
    private MemberInfo member;
    public MemberInfo getMember() {
        return member;
    }
    public void setMember(MemberInfo member) {
        this.member = member;
    }

    /*������Դ*/
    private String inputsComesFrom;
    public String getInputsComesFrom() {
        return inputsComesFrom;
    }
    public void setInputsComesFrom(String inputsComesFrom) {
        this.inputsComesFrom = inputsComesFrom;
    }

    /*��������*/
    private ClassInputCashTable inputFroms;
    public ClassInputCashTable getInputFroms() {
        return inputFroms;
    }
    public void setInputFroms(ClassInputCashTable inputFroms) {
        this.inputFroms = inputFroms;
    }

    /*֧����ʽ*/
    private PayWay payWayObj;
    public PayWay getPayWayObj() {
        return payWayObj;
    }
    public void setPayWayObj(PayWay payWayObj) {
        this.payWayObj = payWayObj;
    }

    /*������*/
    private float inputCash;
    public float getInputCash() {
        return inputCash;
    }
    public void setInputCash(float inputCash) {
        this.inputCash = inputCash;
    }

    /*��������*/
    private Timestamp inputDateTime;
    public Timestamp getInputDateTime() {
        return inputDateTime;
    }
    public void setInputDateTime(Timestamp inputDateTime) {
        this.inputDateTime = inputDateTime;
    }

    /*��ע��Ϣ*/
    private String inputContent;
    public String getInputContent() {
        return inputContent;
    }
    public void setInputContent(String inputContent) {
        this.inputContent = inputContent;
    }

}