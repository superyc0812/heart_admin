package com.xupt.service_impl_admin;

import com.xupt.dao_admin.AdminTestPaperDao;
import com.xupt.service_admin.AdminTestPaperService;
import com.xupt.vo_admin.AdminPageBean;
import com.xupt.vo_admin.AdminTestPaper;
import com.xupt.vo_admin.AdminTestPaper2;
import com.xupt.vo_admin.AdminTestPaperType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminTestPaperServiceImpl implements AdminTestPaperService {

    @Resource
    AdminTestPaperDao adminTestPaperDao;

    public List<AdminTestPaper> getTestList(AdminPageBean adminPageBean) {
        return adminTestPaperDao.getTestList(adminPageBean);
    }

    public AdminTestPaper2 getTestById(Integer testId) {
        return adminTestPaperDao.getTestById(testId);
    }

    public List<AdminTestPaperType> getLabels() {
        return adminTestPaperDao.getLabels();
    }

    public Integer editTestPaper(AdminTestPaper2 adminTestPaper2) {
        return adminTestPaperDao.editTestPaper(adminTestPaper2);
    }

    public Integer addTestPaper(AdminTestPaper2 adminTestPaper2) {
        return adminTestPaperDao.addTestPaper(adminTestPaper2);
    }

    public List<AdminTestPaper> searchTest() {
        return adminTestPaperDao.searchTest();
    }

    public Integer deleteTest(Integer[] item) {
        return adminTestPaperDao.deleteTest(item);
    }

    public Integer changeLabelStatus(Integer labelId) {
        return adminTestPaperDao.changeLabelStatus(labelId);
    }

    public Integer addLable(String labelName) {
        return adminTestPaperDao.addLable(labelName);
    }
}
