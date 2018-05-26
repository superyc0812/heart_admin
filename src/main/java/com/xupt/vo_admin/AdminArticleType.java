package com.xupt.vo_admin;

public class AdminArticleType {
    private Integer article_type_id;
    private String article_type_name;
    private Boolean article_type_status;

    public Integer getArticle_type_id() {
        return article_type_id;
    }

    public void setArticle_type_id(Integer article_type_id) {
        this.article_type_id = article_type_id;
    }

    public String getArticle_type_name() {
        return article_type_name;
    }

    public void setArticle_type_name(String article_type_name) {
        this.article_type_name = article_type_name;
    }

    public Boolean getArticle_type_status() {
        return article_type_status;
    }

    public void setArticle_type_status(Boolean article_type_status) {
        this.article_type_status = article_type_status;
    }
}
