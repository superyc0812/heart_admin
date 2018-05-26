package com.xupt.dao_admin;

import com.xupt.vo_admin.AdminForum;
import com.xupt.vo_admin.AdminForumType;
import com.xupt.vo_admin.AdminPageBean;

import java.util.List;

public interface AdminForumDao {

    /**
     * 获取评论列表
     * @param adminPageBean
     * @return
     */
    public List<AdminForum> getForumList(AdminPageBean adminPageBean);

    /**
     * 获取评论总数
     * @return
     */
    public Integer getTotalForums();

    /**
     * 搜索评论
     * @return
     */
    public List<AdminForum> searchForums();

    /**
     * 根据评论编号，删除评论
     * @param item
     * @return
     */
    public Integer deleteForums(Integer[] item);

    /**
     * 获取所有评论类型列表
     * @return
     */
    public List<AdminForumType> getLabels();

    /**
     * 根据类型编号，修改状态
     * @param labelId
     * @return
     */
    public Integer changeLabelStatus(Integer labelId);

    /**
     * 添加评论类型
     * @param labelName
     * @return
     */
    public Integer addLabel(String labelName);
}
