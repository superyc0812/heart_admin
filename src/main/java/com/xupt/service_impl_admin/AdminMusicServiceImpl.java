package com.xupt.service_impl_admin;

import com.xupt.dao_admin.AdminMusicDao;
import com.xupt.service_admin.AdminMusicService;
import com.xupt.vo_admin.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminMusicServiceImpl implements AdminMusicService {

    @Resource
    AdminMusicDao adminMusicDao;

    public List<AdminMusic> getMusicList(AdminPageBean adminPageBean) {
        return adminMusicDao.getMusicList(adminPageBean);
    }

    public Integer getTotalMusics() {
        return adminMusicDao.getTotalMusics();
    }

    public AdminMusic2 getMusicById(Integer musicId) {
        return adminMusicDao.getMusicById(musicId);
    }

    public List<AdminMusicType> getLabels() {
        return adminMusicDao.getLabels();
    }

    public Integer addMusic(AdminMusic3 adminMusic3) {
        return adminMusicDao.addMusic(adminMusic3);
    }

    public Integer editMusic(AdminMusic2 adminMusic2) {
        return adminMusicDao.editMusic(adminMusic2);
    }

    public List<AdminMusic> searchMusics() {
        return adminMusicDao.searchMusics();
    }

    public Integer deleteMusics(Integer[] item) {
        return adminMusicDao.deleteMusics(item);
    }

    public Integer changeLabelStatus(Integer labelId) {
        return adminMusicDao.changeLabelStatus(labelId);
    }

    public Integer addLabel(String labelName) {
        return adminMusicDao.addLabel(labelName);
    }
}
