package com.xupt.vo_admin;

public class AdminTestPaperType {
    private Integer paper_label_id;     //类型编号
    private String paper_label_name;    //类型名称
    private Boolean paper_label_status; //类型状态

    public Integer getPaper_label_id() {
        return paper_label_id;
    }

    public void setPaper_label_id(Integer paper_label_id) {
        this.paper_label_id = paper_label_id;
    }

    public String getPaper_label_name() {
        return paper_label_name;
    }

    public void setPaper_label_name(String paper_label_name) {
        this.paper_label_name = paper_label_name;
    }

    public Boolean getPaper_label_status() {
        return paper_label_status;
    }

    public void setPaper_label_status(Boolean paper_label_status) {
        this.paper_label_status = paper_label_status;
    }
}
