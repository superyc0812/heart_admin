package com.xupt.vo_admin;

public class AdminFmlComment {
    private Integer ml_comment_id;
    private Integer comment_id;
    private String user_one;
    private String user_two;
    private String fml_comment_date;
    private String fml_content;

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

    public String getFml_comment_date() {
        return fml_comment_date;
    }

    public void setFml_comment_date(String fml_comment_date) {
        this.fml_comment_date = fml_comment_date;
    }

    public String getFml_content() {
        return fml_content;
    }

    public void setFml_content(String fml_content) {
        this.fml_content = fml_content;
    }
}
