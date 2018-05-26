package com.xupt.dao_admin;

import com.xupt.vo_admin.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * 管理员数据库访问层接口
 */
public interface AdminDao {

    /**
     * 管理员密码登录
     * @param account
     * @param password
     * @return
     */
    public Admin login(@Param("account") String account, @Param("password") String password);
}
