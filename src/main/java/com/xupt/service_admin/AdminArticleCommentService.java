package com.xupt.service_admin;

import com.xupt.vo_admin.AdminArticleComment;

import java.util.List;

public interface AdminArticleCommentService {

    /**
     * 根据文章编号获取一级评论
     * @param articleId
     * @return
     */
    public List<AdminArticleComment> getFirstLevelComment(Integer articleId);

    /**
     * 根据一级评论编号，删除评论
     * @param commentId
     * @return
     */
    public Integer deleteFirstLevelComment(Integer commentId);


}
