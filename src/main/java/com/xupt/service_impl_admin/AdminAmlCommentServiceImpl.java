package com.xupt.service_impl_admin;

import com.xupt.dao_admin.AdminAmlCommentDao;
import com.xupt.service_admin.AdminAmlCommentService;
import com.xupt.vo_admin.AdminAmlComment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminAmlCommentServiceImpl implements AdminAmlCommentService{

    @Resource
    AdminAmlCommentDao adminAmlCommentDao;

    public List<AdminAmlComment> getMoreLevelComment(Integer articleId) {
        return adminAmlCommentDao.getMoreLevelComment(articleId);
    }

    public Integer deleteMoreLevelComment(Integer commentId) {
        return adminAmlCommentDao.deleteMoreLevelComment(commentId);
    }
}
