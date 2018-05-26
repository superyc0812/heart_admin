package com.xupt.service_admin;

import com.xupt.vo_admin.AdminPageBean;
import com.xupt.vo_admin.AdminUser;

import java.util.List;

/**
 * User业务逻辑接口
 */
public interface AdminUserService {

    /**
     * 获取当前页用户列表
     * @return
     */
    public List<AdminUser> getUsers(AdminPageBean adminPageBean);

    /**
     * 根据搜索的账户，获取用户列表
     * @return
     */
    public List<AdminUser> searchUser();

}
