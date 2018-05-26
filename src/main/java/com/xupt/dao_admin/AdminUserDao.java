package com.xupt.dao_admin;

import com.xupt.vo_admin.AdminPageBean;
import com.xupt.vo_admin.AdminUser;
import com.xupt.vo_admin.AdminUserTestRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * User接口
 */
public interface AdminUserDao {
    /**
     * 获取当前页用户列表
     * @return
     */
    public ArrayList<AdminUser> getUsers(AdminPageBean adminPageBean);

    /**
     * 根据用户编号获取测试记录
     * @param user_id
     * @return
     */
    public List<AdminUserTestRecord> getUserRecordsByUserId(Integer user_id);

    /**
     * 根据搜索的账户，获取用户列表
     * @return
     */
    public List<AdminUser> searchUser();
}
