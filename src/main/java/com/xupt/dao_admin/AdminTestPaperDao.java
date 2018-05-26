package com.xupt.dao_admin;

import com.xupt.vo_admin.AdminPageBean;
import com.xupt.vo_admin.AdminTestPaper;
import com.xupt.vo_admin.AdminTestPaper2;
import com.xupt.vo_admin.AdminTestPaperType;

import java.util.List;

public interface AdminTestPaperDao {

    /**
     * 获取测试题列表
     * @param adminPageBean
     * @return
     */
    public List<AdminTestPaper> getTestList(AdminPageBean adminPageBean);

    /**
     * 根据编号，获取测试题
     * @param testId
     * @return
     */
    public AdminTestPaper2 getTestById(Integer testId);

    /**
     * 获取测试试题类型列表
     * @return
     */
    public List<AdminTestPaperType> getLabels();

    /**
     * 更新测试题
     * @param adminTestPaper2
     * @return
     */
    public Integer editTestPaper(AdminTestPaper2 adminTestPaper2);

    /**
     * 添加测试试题
     * @param adminTestPaper2
     * @return
     */
    public Integer addTestPaper(AdminTestPaper2 adminTestPaper2);

    /**
     * 搜索试题
     * @return
     */
    public List<AdminTestPaper> searchTest();

    /**
     * 批量删除测试题
     * @param item
     * @return
     */
    public Integer deleteTest(Integer[] item);

    /**
     * 根据编号，修改测试题的状态
     * @param labelId
     * @return
     */
    public Integer changeLabelStatus(Integer labelId);

    /**
     * 添加测试类型
     * @param labelName
     * @return
     */
    public Integer addLable(String labelName);
}
