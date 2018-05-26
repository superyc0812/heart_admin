package com.xupt.service_admin;

import com.xupt.vo_admin.AdminAnswer;
import com.xupt.vo_admin.AdminTestAnswer;


public interface AdminTestAnswerService {

    /**
     * 根据测试题目编号，获取测试答案
     * @param testId
     * @return
     */
    public AdminTestAnswer getAnswer(Integer testId);

    /**
     * 更新测试答案
     * @param adminTestAnswer
     * @return
     */
    public Integer editAnswer(AdminTestAnswer adminTestAnswer);

    /**
     * 添加指定测试试题的答案
     * @param adminAnswer
     * @return
     */
    public Integer addAnswer(AdminAnswer adminAnswer);
}
