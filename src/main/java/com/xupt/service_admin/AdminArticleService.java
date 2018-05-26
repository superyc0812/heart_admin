package com.xupt.service_admin;

import com.xupt.vo_admin.*;

import java.util.List;

public interface AdminArticleService {

    /**
     * 获取文章类型列表
     * @return
     */
    public List<AdminArticleType> getLabels();

    /**
     * 修改文章类型状态
     * @param lableId
     * @return
     */
    public Integer changeLabelStatus(Integer lableId);

    /**
     * 添加文章类型
     * @param lableName
     * @return
     */
    public Integer addLable(String lableName);

    /**
     * 获取文章列表
     * @param adminPageBean
     * @return
     */
    public List<AdminArticle> getArticleList(AdminPageBean adminPageBean);

    /**
     * 获取文章总数
     * @return
     */
    public Integer getTotalArticles();

    /**
     * 根据文章编号获取文章信息
     * @param articleId
     * @return
     */
    public AdminArticle getArticleById(Integer articleId);

    /**
     * 添加文章信息
     * @param adminArticle
     * @return
     */
    public Integer addArticle(AdminArticle3 adminArticle);

    /**
     * 更新文章信息
     * @param adminArticle
     * @return
     */
    public Integer editArticle(AdminArticle adminArticle);

    /**
     * 根据文章编号，删除文章
     * @param item
     * @return
     */
    public Integer deleteArticles(Integer[] item);

    /**
     * 关键字搜索文章
     * @return
     */
    public List<AdminArticle2> searchArticles();

}
