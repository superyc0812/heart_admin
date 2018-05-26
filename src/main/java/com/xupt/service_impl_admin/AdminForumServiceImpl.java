package com.xupt.service_impl_admin;

import com.xupt.dao_admin.AdminForumDao;
import com.xupt.service_admin.AdminForumService;
import com.xupt.vo_admin.AdminForum;
import com.xupt.vo_admin.AdminForumType;
import com.xupt.vo_admin.AdminPageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminForumServiceImpl implements AdminForumService {

    @Resource
    AdminForumDao adminForumDao;

    public List<AdminForum> getForumList(AdminPageBean adminPageBean) {
        return adminForumDao.getForumList(adminPageBean);
    }

    public Integer getTotalForums() {
        return adminForumDao.getTotalForums();
    }

    public List<AdminForum> searchForums() {
        return adminForumDao.searchForums();
    }

    public Integer deleteForums(Integer[] item) {
        return adminForumDao.deleteForums(item);
    }

    public List<AdminForumType> getLabels() {
        return adminForumDao.getLabels();
    }

    public Integer changeLabelStatus(Integer labelId) {
        return adminForumDao.changeLabelStatus(labelId);
    }

    public Integer addLabel(String labelName) {
        return adminForumDao.addLabel(labelName);
    }
}
