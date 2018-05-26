package com.xupt.util;

import com.xupt.vo_admin.AdminUser;

import java.util.List;

public class AdminUsersState {
    private Integer state;
    private String msg;
    private Integer total;
    private List<AdminUser> list;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<AdminUser> getList() {
        return list;
    }

    public void setList(List<AdminUser> list) {
        this.list = list;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
