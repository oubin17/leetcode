package com.ob.algorithm.coding;

import java.util.Date;

/**
 * @Author: oubin
 * @Date: 2020/9/4 15:35
 * @Description:
 */
public class SaleItem {

    private int month;
    private Date date;
    private String transationId;
    private double saleNumbers;


    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getTransationId() {
        return transationId;
    }
    public void setTransationId(String transationId) {
        this.transationId = transationId;
    }
    public double getSaleNumbers() {
        return saleNumbers;
    }
    public void setSaleNumbers(double saleNumbers) {
        this.saleNumbers = saleNumbers;
    }
}
