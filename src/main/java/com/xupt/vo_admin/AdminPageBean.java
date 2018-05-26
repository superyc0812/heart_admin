package com.xupt.vo_admin;
/**
 * 分页Model类
 * @author
 *
 */
public class AdminPageBean {

    private int page;       // 第几页
    private int pageSize;   // 每页记录数
    private int start;      // 起始页
    private int type;       // 类型

    public AdminPageBean(int page, int pageSize) {
        super();
        this.page = page;
        this.pageSize = pageSize;
    }

    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStart() {
        return (page-1)*pageSize;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
