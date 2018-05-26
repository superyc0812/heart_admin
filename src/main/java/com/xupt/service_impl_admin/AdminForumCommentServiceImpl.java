package com.xupt.service_impl_admin;

import com.xupt.dao_admin.AdminForumCommentDao;
import com.xupt.service_admin.AdminForumCommentService;
import com.xupt.vo_admin.AdminForumComment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminForumCommentServiceImpl implements AdminForumCommentService {

    @Resource
    AdminForumCommentDao adminForumCommentDao;

    public List<AdminForumComment> getFirstLevelComment(Integer forumId) {
        return adminForumCommentDao.getFirstLevelComment(forumId);
    }

    public Integer deleteFirstLevelComment(Integer commentId) {
        return adminForumCommentDao.deleteFirstLevelComment(commentId);
    }
}
