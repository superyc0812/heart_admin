package com.xupt.vo_admin;

public class AdminMusic {

    private Integer music_id;       //编号

    private String name;            //名称

    private String musician;        //演唱者

    private String upload_date;     //上传日期

    private String description;     //描述

    private Integer typeId;         //类型

    private String typeName;        //类型名称

    private Integer play_num;       //播放次数

    private String img_addr;        //图片地址

    private String save_addr;       //音乐地址

    public Integer getMusic_id() {
        return music_id;
    }

    public void setMusic_id(Integer music_id) {
        this.music_id = music_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMusician() {
        return musician;
    }

    public void setMusician(String musician) {
        this.musician = musician;
    }

    public String getUpload_date() {
        return upload_date;
    }

    public void setUpload_date(String upload_date) {
        this.upload_date = upload_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getPlay_num() {
        return play_num;
    }

    public void setPlay_num(Integer play_num) {
        this.play_num = play_num;
    }

    public String getImg_addr() {
        return img_addr;
    }

    public void setImg_addr(String img_addr) {
        this.img_addr = img_addr;
    }

    public String getSave_addr() {
        return save_addr;
    }

    public void setSave_addr(String save_addr) {
        this.save_addr = save_addr;
    }

    @Override
    public String toString() {
        return name + musician + upload_date + description + typeName;
    }
}
