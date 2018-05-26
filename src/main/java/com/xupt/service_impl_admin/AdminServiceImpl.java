package com.xupt.service_impl_admin;

import com.xupt.dao_admin.AdminDao;
import com.xupt.service_admin.AdminService;
import com.xupt.vo_admin.Admin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    AdminDao adminDao;

    public Admin login(String account, String password) {
           return adminDao.login(account, password);
    }
}
