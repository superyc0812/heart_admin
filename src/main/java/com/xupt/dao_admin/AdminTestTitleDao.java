package com.xupt.dao_admin;

import com.xupt.vo_admin.AdminTestTitle;

import java.util.List;

public interface AdminTestTitleDao {

    /**
     * 根据测试编号，获取测试题目
     * @param testId
     * @return
     */
    public List<AdminTestTitle> getQuestions(Integer testId);

    /**
     * 批量删除问题
     * @param item
     * @return
     */
    public Integer deleteTestQuestions(Integer[] item);

    /**
     * 添加试题题目
     * @param adminTestTitle
     * @return
     */
    public Integer addQuestions(AdminTestTitle adminTestTitle);

    /**
     * 更新题目信息
     * @param adminTestTitle
     * @return
     */
    public Integer editQuestions(AdminTestTitle adminTestTitle);
}
