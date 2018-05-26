package com.xupt.controller_admin;

import com.xupt.service_admin.AdminTestRecordService;
import com.xupt.util.AdminTestRecordsState;
import com.xupt.util.State;
import com.xupt.util.Utils;
import com.xupt.vo_admin.AdminUserTestRecord;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/mapis/record")
public class AdminTestRecordController {

    @Resource
    AdminTestRecordService adminTestRecordService;

    @RequestMapping("/getUserRecordsByUserId")
    @ResponseBody
    public AdminTestRecordsState getUserRecordsByUserId(HttpServletRequest request){
        String jsonString = Utils.getRequestBody(request);
        JSONObject obj = JSONObject.fromObject(jsonString);

        JSONArray arr = obj.getJSONArray("ids");
        Integer[] item = new Integer[arr.size()];
        for (int i = 0;i < arr.size();i++){
            item[i] = arr.getInt(i);
        }
        AdminTestRecordsState adminTestRecordsState = new AdminTestRecordsState();
        List<AdminUserTestRecord> records = adminTestRecordService.getUserRecordsByUserId(item);
        if(records != null){
            adminTestRecordsState.setState(1);
            adminTestRecordsState.setMsg("成功");
            adminTestRecordsState.setList(records);
        }else{
            adminTestRecordsState.setState(0);
            adminTestRecordsState.setMsg("失败");
            adminTestRecordsState.setList(null);
        }
        return adminTestRecordsState;
    }

    @RequestMapping("/changeRecordStatus")
    @ResponseBody
    public State changeRecordStatus(HttpServletRequest request){
        String jsonString = Utils.getRequestBody(request);
        JSONObject obj = JSONObject.fromObject(jsonString);
        State state  = new State();
        Integer change = adminTestRecordService.changeRecordStatus(Integer.parseInt(obj.getString("recordId")));
        if(change != null){
            state.setState(1);
            state.setMsg("成功");
        }else{
            state.setState(0);
            state.setMsg("失败");
        }
        return state;
    }
}
