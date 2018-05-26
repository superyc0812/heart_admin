package com.xupt.service_impl_admin;

import com.xupt.dao_admin.AdminArticleDao;
import com.xupt.service_admin.AdminArticleService;
import com.xupt.vo_admin.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminArticleServiceImpl implements AdminArticleService {

    @Resource
    AdminArticleDao adminArticleDao;

    public List<AdminArticleType> getLabels() {
        return adminArticleDao.getLabels();
    }

    public Integer changeLabelStatus(Integer lableId) {
        return adminArticleDao.changeLabelStatus(lableId);
    }

    public Integer addLable(String lableName) {
        return adminArticleDao.addLable(lableName);
    }

    public List<AdminArticle> getArticleList(AdminPageBean adminPageBean) {
        return adminArticleDao.getArticleList(adminPageBean);
    }

    public Integer getTotalArticles() {
        return adminArticleDao.getTotalArticles();
    }

    public AdminArticle getArticleById(Integer articleId) {
        return adminArticleDao.getArticleById(articleId);
    }

    public Integer addArticle(AdminArticle3 adminArticle) {
        return adminArticleDao.addArticle(adminArticle);
    }

    public Integer editArticle(AdminArticle adminArticle) {
        return adminArticleDao.editArticle(adminArticle);
    }

    public Integer deleteArticles(Integer[] item) {
        return adminArticleDao.deleteArticles(item);
    }

    public List<AdminArticle2> searchArticles() {
        return adminArticleDao.searchArticles();
    }
}
