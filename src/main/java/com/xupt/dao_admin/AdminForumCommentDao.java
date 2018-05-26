package com.xupt.dao_admin;

import com.xupt.vo_admin.AdminForumComment;

import java.util.List;

public interface AdminForumCommentDao {

    /**
     * 根据论坛编号，获取一级评论
     * @param forumId
     * @return
     */
    public List<AdminForumComment> getFirstLevelComment(Integer forumId);

    /**
     * 根据评论编号，删除评论
     * @param commentId
     * @return
     */
    public Integer deleteFirstLevelComment(Integer commentId);
}
