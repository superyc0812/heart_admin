package com.xupt.service_impl_admin;


import com.xupt.dao_admin.AdminUserDao;
import com.xupt.service_admin.AdminUserService;
import com.xupt.vo_admin.AdminPageBean;
import com.xupt.vo_admin.AdminUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * User接口实现类
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Resource
    AdminUserDao adminUserDao;

    public ArrayList<AdminUser> getUsers(AdminPageBean adminPageBean) {
        return adminUserDao.getUsers(adminPageBean);
    }

    public List<AdminUser> searchUser() {
        return adminUserDao.searchUser();
    }
}
