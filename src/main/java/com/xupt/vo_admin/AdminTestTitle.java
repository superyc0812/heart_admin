package com.xupt.vo_admin;

public class AdminTestTitle {
    private Integer title_id;       //编号
    private Integer test_id;        //测试标题编号
    private String title_name;      //题目名称
    private String choose_one;      //选项一
    private String choose_two;      //选项二
    private String choose_three;    //选项三
    private String choose_four;     //选项四

    public Integer getTitle_id() {
        return title_id;
    }

    public void setTitle_id(Integer title_id) {
        this.title_id = title_id;
    }

    public Integer getTest_id() {
        return test_id;
    }

    public void setTest_id(Integer test_id) {
        this.test_id = test_id;
    }

    public String getTitle_name() {
        return title_name;
    }

    public void setTitle_name(String title_name) {
        this.title_name = title_name;
    }

    public String getChoose_one() {
        return choose_one;
    }

    public void setChoose_one(String choose_one) {
        this.choose_one = choose_one;
    }

    public String getChoose_two() {
        return choose_two;
    }

    public void setChoose_two(String choose_two) {
        this.choose_two = choose_two;
    }

    public String getChoose_three() {
        return choose_three;
    }

    public void setChoose_three(String choose_three) {
        this.choose_three = choose_three;
    }

    public String getChoose_four() {
        return choose_four;
    }

    public void setChoose_four(String choose_four) {
        this.choose_four = choose_four;
    }
}
