package com.xupt.service_admin;

import com.xupt.vo_admin.*;

import java.util.List;

public interface AdminMusicService {

    /**
     * 获取音乐列表
     * @param adminPageBean
     * @return
     */
    public List<AdminMusic> getMusicList(AdminPageBean adminPageBean);

    /**
     * 获取音乐总数
     * @return
     */
    public Integer getTotalMusics();

    /**
     * 根据音乐编号获取音乐信息
     * @param musicId
     * @return
     */
    public AdminMusic2 getMusicById(Integer musicId);

    /**
     * 获取音乐类型列表
     * @return
     */
    public List<AdminMusicType> getLabels();

    /**
     * 添加音乐
     * @param adminMusic3
     * @return
     */
    public Integer addMusic(AdminMusic3 adminMusic3);

    /**
     * 更新音乐
     * @param adminMusic2
     * @return
     */
    public Integer editMusic(AdminMusic2 adminMusic2);

    /**
     * 搜索音乐
     * @return
     */
    public List<AdminMusic> searchMusics();

    /**
     * 根据音乐编号删除音乐
     * @param item
     * @return
     */
    public Integer deleteMusics(Integer[] item);

    /**
     * 根据类型编号，修改状态
     * @param labelId
     * @return
     */
    public Integer changeLabelStatus(Integer labelId);

    /**
     * 添加音乐类型
     * @param labelName
     * @return
     */
    public Integer addLabel(String labelName);
}
