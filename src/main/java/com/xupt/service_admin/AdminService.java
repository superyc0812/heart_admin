package com.xupt.service_admin;

import com.xupt.vo_admin.Admin;

/**
 * 管理员业务逻辑层接口
 */
public interface AdminService {
    /**
     * 管理员密码登录
     * @param account
     * @param password
     * @return
     */
    public Admin login(String account, String password);
}
