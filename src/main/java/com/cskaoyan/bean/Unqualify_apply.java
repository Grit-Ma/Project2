package com.cskaoyan.bean;

import java.util.Date;

public class Unqualify_apply {
    /*{"unqualifyApplyId":"123",
    "productId":"00001",
    "unqualifyItem":"123",
    "unqualifyCount":123,
    "assemblyDate":1561521600000,
    "empId":"003",
    "applyDate":1561521600000,
    "note":"123",
    "productName":"投影机",
    "empName":"刘高升"}
    */
    private String unqualifyApplyId;

    private String productId;

    private String unqualifyItem;

    private Integer unqualifyCount;

    private Date assemblyDate;

    private String empId;

    private Date applyDate;

    private String note;

    private String productName;

    private String empName;


    public Unqualify_apply() {
    }

    public Unqualify_apply(String unqualifyApplyId, String productId, String unqualifyItem, Integer unqualifyCount, Date assemblyDate, String empId, Date applyDate, String note, String productName, String empName) {
        this.unqualifyApplyId = unqualifyApplyId;
        this.productId = productId;
        this.unqualifyItem = unqualifyItem;
        this.unqualifyCount = unqualifyCount;
        this.assemblyDate = assemblyDate;
        this.empId = empId;
        this.applyDate = applyDate;
        this.note = note;
        this.productName = productName;
        this.empName = empName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getUnqualifyApplyId() {
        return unqualifyApplyId;
    }

    public void setUnqualifyApplyId(String unqualifyApplyId) {
        this.unqualifyApplyId = unqualifyApplyId == null ? null : unqualifyApplyId.trim();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getUnqualifyItem() {
        return unqualifyItem;
    }

    public void setUnqualifyItem(String unqualifyItem) {
        this.unqualifyItem = unqualifyItem == null ? null : unqualifyItem.trim();
    }

    public Integer getUnqualifyCount() {
        return unqualifyCount;
    }

    public void setUnqualifyCount(Integer unqualifyCount) {
        this.unqualifyCount = unqualifyCount;
    }

    public Date getAssemblyDate() {
        return assemblyDate;
    }

    public void setAssemblyDate(Date assemblyDate) {
        this.assemblyDate = assemblyDate;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId == null ? null : empId.trim();
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    @Override
    public String toString() {
        return "Unqualify_apply{" +
                "unqualifyApplyId='" + unqualifyApplyId + '\'' +
                ", productId='" + productId + '\'' +
                ", unqualifyItem='" + unqualifyItem + '\'' +
                ", unqualifyCount=" + unqualifyCount +
                ", assemblyDate=" + assemblyDate +
                ", empId='" + empId + '\'' +
                ", applyDate=" + applyDate +
                ", note='" + note + '\'' +
                ", productName='" + productName + '\'' +
                ", empName='" + empName + '\'' +
                '}';
    }
}