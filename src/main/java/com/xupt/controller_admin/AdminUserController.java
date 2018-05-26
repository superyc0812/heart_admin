package com.xupt.controller_admin;

import com.xupt.service_admin.AdminUserService;
import com.xupt.util.AdminUsersState;
import com.xupt.util.Utils;
import com.xupt.vo_admin.AdminPageBean;
import com.xupt.vo_admin.AdminUser;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户控制器
 */
@Controller
@RequestMapping("/mapis/user")
public class AdminUserController {

    @Resource
    AdminUserService adminUserService;

    @RequestMapping("/getUsers")
    @ResponseBody
    public AdminUsersState getUsers(HttpServletRequest request){
        String jsonString = Utils.getRequestBody(request);
        JSONObject obj = JSONObject.fromObject(jsonString);
        AdminUsersState adminUsersState = new AdminUsersState();
        AdminPageBean adminPageBean = new AdminPageBean(Integer.parseInt(obj.getString("page")),10);

        //获取当前页用户列表
        List<AdminUser> users = adminUserService.getUsers(adminPageBean);
        if(users != null){
            adminUsersState.setState(1);
            adminUsersState.setMsg("成功");
            adminUsersState.setList(users);
        }else{
            adminUsersState.setState(0);
            adminUsersState.setMsg("失败");
            adminUsersState.setList(null);
        }
        return adminUsersState;
    }

    @RequestMapping("/searchUser")
    @ResponseBody
    public AdminUsersState searchUser(HttpServletRequest request){
        String jsonString = Utils.getRequestBody(request);
        JSONObject obj = JSONObject.fromObject(jsonString);
        AdminUsersState adminUsersState = new AdminUsersState();
        List<AdminUser> users = adminUserService.searchUser();
        List<AdminUser> list = new ArrayList<AdminUser>();
        if (users != null) {
            Boolean flag = false;
            for (int i = 0; i < users.size(); i++) {
                flag = users.get(i).toString().contains(obj.getString("keyWord"));
                if (flag) {
                    list.add(users.get(i));
                }
            }
            if (list.size() > 0) {
                adminUsersState.setState(1);
                adminUsersState.setMsg("成功");
                adminUsersState.setList(list);
                adminUsersState.setTotal(list.size());
            } else {
                adminUsersState.setState(0);
                adminUsersState.setMsg("未找到");
                adminUsersState.setList(null);
                adminUsersState.setTotal(0);
            }
        } else {
            adminUsersState.setState(0);
            adminUsersState.setMsg("失败");
            adminUsersState.setList(null);
            adminUsersState.setTotal(0);
        }
        return adminUsersState;
    }

}
