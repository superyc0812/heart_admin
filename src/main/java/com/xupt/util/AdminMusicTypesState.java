package com.xupt.util;

import com.xupt.vo_admin.AdminMusicType;

import java.util.List;

public class AdminMusicTypesState {
    private Integer state;
    private String msg;
    private List<AdminMusicType> list;

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

    public List<AdminMusicType> getList() {
        return list;
    }

    public void setList(List<AdminMusicType> list) {
        this.list = list;
    }
}
