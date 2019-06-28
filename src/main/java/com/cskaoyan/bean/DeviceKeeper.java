package com.cskaoyan.bean;

/**
 * created by ZengWei
 * on 2019/6/28
 */
public class DeviceKeeper extends Employee {
    Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
