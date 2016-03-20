package com.qinziwang.utils;

import java.sql.Timestamp;
public class PayWay {
    /*记录编号*/
    private int payWayId;
    public int getPayWayId() {
        return payWayId;
    }
    public void setPayWayId(int payWayId) {
        this.payWayId = payWayId;
    }

    /*支付方式*/
    private String payWayName;
    public String getPayWayName() {
        return payWayName;
    }
    public void setPayWayName(String payWayName) {
        this.payWayName = payWayName;
    }

}