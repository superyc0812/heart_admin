package com.xupt.dao_admin;

import com.xupt.vo_admin.AdminFmlComment;

import java.util.List;

public interface AdminFmlCommentDao {

    /**
     * 根据论坛编号，获取二级评论信息
     * @param forumId
     * @return
     */
    public List<AdminFmlComment> getMoreLevelComment(Integer forumId);

    /**
     * 根据二级评论编号，删除评论
     * @param commentId
     * @return
     */
    public Integer deleteMoreLevelComment(Integer commentId);
}
