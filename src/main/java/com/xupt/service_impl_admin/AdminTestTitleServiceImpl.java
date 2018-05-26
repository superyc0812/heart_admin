package com.xupt.service_impl_admin;

import com.xupt.dao_admin.AdminTestTitleDao;
import com.xupt.service_admin.AdminTestTitleService;
import com.xupt.vo_admin.AdminTestTitle;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminTestTitleServiceImpl implements AdminTestTitleService {

    @Resource
    AdminTestTitleDao adminTestTitleDao;

    public List<AdminTestTitle> getQuestions(Integer testId) {
        return adminTestTitleDao.getQuestions(testId);
    }

    public Integer deleteTestQuestions(Integer[] item) {
        return adminTestTitleDao.deleteTestQuestions(item);
    }

    public Integer addQuestions(AdminTestTitle adminTestTitle) {
        return adminTestTitleDao.addQuestions(adminTestTitle);
    }

    public Integer editQuestions(AdminTestTitle adminTestTitle) {
        return adminTestTitleDao.editQuestions(adminTestTitle);
    }
}
