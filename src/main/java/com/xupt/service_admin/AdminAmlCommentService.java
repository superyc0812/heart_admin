package com.xupt.service_admin;

import com.xupt.vo_admin.AdminAmlComment;

import java.util.List;

public interface AdminAmlCommentService {

    /**
     * 根据评论编号，获取二级评论列表
     * @param articleId
     * @return
     */
    public List<AdminAmlComment> getMoreLevelComment(Integer articleId);

    /**
     * 根据二级评论编号，删除评论
     * @param commentId
     * @return
     */
    public Integer deleteMoreLevelComment(Integer commentId);
}
