package com.xupt.vo_admin;

public class AdminAmlComment {
    private Integer ml_comment_id;
    private Integer comment_id;
    private String user_one;
    private String user_two;
    private String aml_content;
    private String aml_comment_date;

    public Integer getMl_comment_id() {
        return ml_comment_id;
    }

    public void setMl_comment_id(Integer ml_comment_id) {
        this.ml_comment_id = ml_comment_id;
    }

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public String getUser_one() {
        return user_one;
    }

    public void setUser_one(String user_one) {
        this.user_one = user_one;
    }

    public String getUser_two() {
        return user_two;
    }

    public void setUser_two(String user_two) {
        this.user_two = user_two;
    }

    public String getAml_content() {
        return aml_content;
    }

    public void setAml_content(String aml_content) {
        this.aml_content = aml_content;
    }

    public String getAml_comment_date() {
        return aml_comment_date;
    }

    public void setAml_comment_date(String aml_comment_date) {
        this.aml_comment_date = aml_comment_date;
    }
}
