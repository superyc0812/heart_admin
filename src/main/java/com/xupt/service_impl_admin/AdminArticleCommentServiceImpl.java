package com.xupt.service_impl_admin;

import com.xupt.dao_admin.AdminArticleCommentDao;
import com.xupt.service_admin.AdminArticleCommentService;
import com.xupt.vo_admin.AdminArticleComment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminArticleCommentServiceImpl implements AdminArticleCommentService {

    @Resource
    AdminArticleCommentDao adminArticleCommentDao;

    public List<AdminArticleComment> getFirstLevelComment(Integer articleId) {
        return adminArticleCommentDao.getFirstLevelComment(articleId);
    }

    public Integer deleteFirstLevelComment(Integer commentId) {
        return adminArticleCommentDao.deleteFirstLevelComment(commentId);
    }
}
