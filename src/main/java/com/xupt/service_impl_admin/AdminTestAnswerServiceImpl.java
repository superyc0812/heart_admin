package com.xupt.service_impl_admin;

import com.xupt.dao_admin.AdminTestAnswerDao;
import com.xupt.service_admin.AdminTestAnswerService;
import com.xupt.vo_admin.AdminAnswer;
import com.xupt.vo_admin.AdminTestAnswer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminTestAnswerServiceImpl implements AdminTestAnswerService {

    @Resource
    AdminTestAnswerDao adminTestAnswerDao;

    public AdminTestAnswer getAnswer(Integer testId) {
        return adminTestAnswerDao.getAnswer(testId);
    }

    public Integer editAnswer(AdminTestAnswer adminTestAnswer) {
        return adminTestAnswerDao.editAnswer(adminTestAnswer);
    }

    public Integer addAnswer(AdminAnswer adminAnswer) {
        return adminTestAnswerDao.addAnswer(adminAnswer);
    }
}
