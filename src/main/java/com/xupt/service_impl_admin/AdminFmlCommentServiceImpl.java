package com.xupt.service_impl_admin;

import com.xupt.dao_admin.AdminFmlCommentDao;
import com.xupt.service_admin.AdminFmlCommentService;
import com.xupt.vo_admin.AdminFmlComment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminFmlCommentServiceImpl implements AdminFmlCommentService{

    @Resource
    AdminFmlCommentDao adminFmlCommentDao;

    public List<AdminFmlComment> getMoreLevelComment(Integer forumId) {
        return adminFmlCommentDao.getMoreLevelComment(forumId);
    }

    public Integer deleteMoreLevelComment(Integer commentId) {
        return adminFmlCommentDao.deleteMoreLevelComment(commentId);
    }
}
