package com.xupt.vo_admin;

public class AdminTestPaper {
    private Integer test_id;
    private String test_name;
    private Integer test_num;
    private String typeName;
    private String picture_addr;

    public Integer getTest_id() {
        return test_id;
    }

    public void setTest_id(Integer test_id) {
        this.test_id = test_id;
    }

    public String getTest_name() {
        return test_name;
    }

    public void setTest_name(String test_name) {
        this.test_name = test_name;
    }

    public Integer getTest_num() {
        return test_num;
    }

    public void setTest_num(Integer test_num) {
        this.test_num = test_num;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getPicture_addr() {
        return picture_addr;
    }

    public void setPicture_addr(String picture_addr) {
        this.picture_addr = picture_addr;
    }

    @Override
    public String toString() {
        return test_name + typeName + test_num;
    }
}
