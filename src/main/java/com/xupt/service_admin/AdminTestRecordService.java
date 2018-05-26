package com.xupt.service_admin;

import com.xupt.vo_admin.AdminUserTestRecord;

import java.util.List;

public interface AdminTestRecordService {

    /**
     * 根据用户编号获取测试记录
     * @param item
     * @return
     */
    public List<AdminUserTestRecord> getUserRecordsByUserId(Integer[] item);

    /**
     * 根据记录编号修改记录状态
     * @param recordId
     * @return
     */
    public Integer changeRecordStatus(Integer recordId);
}
