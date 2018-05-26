package com.xupt.service_impl_admin;

import com.xupt.dao_admin.AdminTestRecordDao;
import com.xupt.service_admin.AdminTestRecordService;
import com.xupt.vo_admin.AdminUserTestRecord;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminTestRecordServiceImpl implements AdminTestRecordService{

    @Resource
    AdminTestRecordDao adminTestRecordDao;

    public List<AdminUserTestRecord> getUserRecordsByUserId(Integer[] item) {
        return adminTestRecordDao.getUserRecordsByUserId(item);
    }

    public Integer changeRecordStatus(Integer recordId) {
        return adminTestRecordDao.changeRecordStatus(recordId);
    }
}
