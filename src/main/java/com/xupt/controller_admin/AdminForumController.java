package com.xupt.controller_admin;

import com.xupt.service_admin.AdminFmlCommentService;
import com.xupt.service_admin.AdminForumCommentService;
import com.xupt.service_admin.AdminForumService;
import com.xupt.util.*;
import com.xupt.vo_admin.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mapis/forum")
public class AdminForumController {

    @Resource
    AdminForumService adminForumService;

    @Resource
    AdminForumCommentService adminForumCommentService;

    @Resource
    AdminFmlCommentService adminFmlCommentService;

    @RequestMapping("/getForumList")
    @ResponseBody
    public AdminForumsState getForumList(HttpServletRequest request){
        String jsonString = Utils.getRequestBody(request);
        JSONObject obj = JSONObject.fromObject(jsonString);
        AdminForumsState adminForumsState = new AdminForumsState();
        AdminPageBean adminPageBean = new AdminPageBean(Integer.parseInt(obj.getString("page")),10);
        List<AdminForum> forums = adminForumService.getForumList(adminPageBean);
        if(forums != null){
            adminForumsState.setState(1);
            adminForumsState.setMsg("成功");
            Integer total = adminForumService.getTotalForums();
            adminForumsState.setTotal(total);
            adminForumsState.setList(forums);
        }else{
            adminForumsState.setState(0);
            adminForumsState.setMsg("失败");
            adminForumsState.setTotal(0);
            adminForumsState.setList(null);
        }
        return adminForumsState;
    }

    @RequestMapping("/searchForums")
    @ResponseBody
    public AdminForumsState searchForums(HttpServletRequest request){
        String jsonString = Utils.getRequestBody(request);
        JSONObject obj = JSONObject.fromObject(jsonString);
        AdminForumsState adminForumsState = new AdminForumsState();
        List<AdminForum> forums = adminForumService.searchForums();
        List<AdminForum> list = new ArrayList<AdminForum>();
        if(forums != null){
            Boolean flag = false;
            for (int i = 0; i < forums.size(); i++) {
                flag = forums.get(i).toString().contains(obj.getString("keyWord"));
                if (flag) {
                    list.add(forums.get(i));
                }
            }
            if (list.size() > 0) {
                adminForumsState.setState(1);
                adminForumsState.setMsg("成功");
                adminForumsState.setList(list);
                adminForumsState.setTotal(list.size());
            } else {
                adminForumsState.setState(0);
                adminForumsState.setMsg("未找到");
                adminForumsState.setList(null);
                adminForumsState.setTotal(0);
            }
        } else {
            adminForumsState.setState(0);
            adminForumsState.setMsg("失败");
            adminForumsState.setList(null);
            adminForumsState.setTotal(0);
        }
        return adminForumsState;
    }

    @RequestMapping("/deleteForums")
    @ResponseBody
    public State deleteForums(HttpServletRequest request){
        String jsonString = Utils.getRequestBody(request);
        JSONObject obj = JSONObject.fromObject(jsonString);
        State state = new State();
        JSONArray arr = obj.getJSONArray("forumsId");
        Integer[] item = new Integer[arr.size()];
        for (int i = 0;i < arr.size();i++){
            item[i] = arr.getInt(i);
        }
        Integer num = adminForumService.deleteForums(item);
        if(num != null){
            state.setState(1);
            state.setMsg("成功");
        }else{
            state.setState(0);
            state.setMsg("失败");
        }
        return state;
    }

    @RequestMapping("/getFirstLevelComment")
    @ResponseBody
    public AdminForumCommsState getFirstLevelComment(HttpServletRequest request){
        String jsonString = Utils.getRequestBody(request);
        JSONObject obj = JSONObject.fromObject(jsonString);
        AdminForumCommsState adminForumCommsState= new AdminForumCommsState();
        List<AdminForumComment> forums = adminForumCommentService.getFirstLevelComment(Integer.parseInt(obj.getString("forumId")));
        if(forums != null){
            adminForumCommsState.setState(1);
            adminForumCommsState.setMsg("成功");
            adminForumCommsState.setList(forums);
        }else{
            adminForumCommsState.setState(0);
            adminForumCommsState.setMsg("失败");
            adminForumCommsState.setList(null);
        }
        return adminForumCommsState;
    }

    @RequestMapping("/getMoreLevelComment")
    @ResponseBody
    public AdminMLFmlCommentState getMoreLevelComment(HttpServletRequest request){
        String jsonString = Utils.getRequestBody(request);
        JSONObject obj = JSONObject.fromObject(jsonString);
        AdminMLFmlCommentState adminMLFmlCommentState = new AdminMLFmlCommentState();
        List<AdminFmlComment> comments = adminFmlCommentService.getMoreLevelComment(Integer.parseInt(obj.getString("forumId")));
        if(comments != null){
            adminMLFmlCommentState.setState(1);
            adminMLFmlCommentState.setMsg("成功");
            adminMLFmlCommentState.setList(comments);
        }else{
            adminMLFmlCommentState.setState(0);
            adminMLFmlCommentState.setMsg("失败");
            adminMLFmlCommentState.setList(null);
        }
        return adminMLFmlCommentState;
    }

    @RequestMapping("/deleteFirstLevelComment")
    @ResponseBody
    public State deleteFirstLevelComment(HttpServletRequest request){
        String jsonString = Utils.getRequestBody(request);
        JSONObject obj = JSONObject.fromObject(jsonString);
        State state = new State();
        Integer num = adminForumCommentService.deleteFirstLevelComment(Integer.parseInt(obj.getString("commentId")));
        if (num != null) {
            state.setState(1);
            state.setMsg("成功");
        } else {
            state.setState(0);
            state.setMsg("失败");
        }
        return state;
    }

    @RequestMapping("/deleteMoreLevelComment")
    @ResponseBody
    public State deleteMoreLevelComment(HttpServletRequest request){
        String jsonString = Utils.getRequestBody(request);
        JSONObject obj = JSONObject.fromObject(jsonString);
        State state = new State();
        Integer num = adminFmlCommentService.deleteMoreLevelComment(Integer.parseInt(obj.getString("commentId")));
        if (num != null) {
            state.setState(1);
            state.setMsg("成功");
        } else {
            state.setState(0);
            state.setMsg("失败");
        }
        return state;
    }

    @RequestMapping("/getLabels")
    @ResponseBody
    public AdminForumTypesState getLabels(){
        AdminForumTypesState adminForumTypesState = new AdminForumTypesState();
        List<AdminForumType> types = adminForumService.getLabels();
        if(types != null){
            adminForumTypesState.setState(1);
            adminForumTypesState.setMsg("成功");
            adminForumTypesState.setList(types);
        }else{
            adminForumTypesState.setState(0);
            adminForumTypesState.setMsg("失败");
            adminForumTypesState.setList(null);
        }
        return adminForumTypesState;
    }

    @RequestMapping("/changeLabelStatus")
    @ResponseBody
    public State changeLabelStatus(HttpServletRequest request){
        String jsonString = Utils.getRequestBody(request);
        JSONObject obj = JSONObject.fromObject(jsonString);
        State state = new State();
        Integer num = adminForumService.changeLabelStatus(Integer.parseInt(obj.getString("labelId")));
        if (num != null) {
            state.setState(1);
            state.setMsg("成功");
        } else {
            state.setState(0);
            state.setMsg("失败");
        }
        return state;
    }

    @RequestMapping("/addLabel")
    @ResponseBody
    public State addLabel(HttpServletRequest request){
        String jsonString = Utils.getRequestBody(request);
        JSONObject obj = JSONObject.fromObject(jsonString);
        State state = new State();
        Integer num = adminForumService.addLabel(obj.getString("labelName"));
        if (num != null) {
            state.setState(1);
            state.setMsg("成功");
        } else {
            state.setState(0);
            state.setMsg("失败");
        }
        return state;
    }

}
