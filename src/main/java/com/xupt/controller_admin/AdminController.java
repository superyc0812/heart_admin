package com.xupt.controller_admin;

import com.xupt.service_admin.AdminService;
import com.xupt.util.State;
import com.xupt.util.Utils;
import com.xupt.vo_admin.Admin;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 用户控制器
 */
@Controller
@RequestMapping("/mapis/admin")
public class AdminController {

    @Resource
    AdminService adminService;

    @RequestMapping(path = "/login",method = RequestMethod.POST)
    @ResponseBody
    public State login(HttpServletRequest request){
        String jsonString = Utils.getRequestBody(request);
        JSONObject obj = JSONObject.fromObject(jsonString);
        State state = new State();
        if(jsonString != null){
           Admin admin = adminService.login(obj.getString("account"),obj.getString("password"));
           if(admin != null){
               state.setState(1);
               state.setMsg("成功");
               HttpSession session = request.getSession();
               session.removeAttribute("userInfo");
               session.setAttribute("admin", admin);
           }else{
               state.setState(0);
               state.setMsg("登录失败");
           }
        }else{
            state.setState(0);
            state.setMsg("请填写账户和密码");
        }
        return state;
    }

}