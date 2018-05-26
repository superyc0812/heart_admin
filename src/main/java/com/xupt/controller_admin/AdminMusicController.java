package com.xupt.controller_admin;

import com.xupt.service_admin.AdminMusicService;
import com.xupt.util.*;
import com.xupt.vo_admin.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mapis/music")
public class AdminMusicController {

    @Resource
    AdminMusicService adminMusicService;

    @RequestMapping("/getMusicList")
    @ResponseBody
    public AdminMusicsState getMusicList(HttpServletRequest request){
        String jsonString = Utils.getRequestBody(request);
        JSONObject obj = JSONObject.fromObject(jsonString);
        AdminMusicsState adminMusicsState = new AdminMusicsState();
        AdminPageBean adminPageBean = new AdminPageBean(Integer.parseInt(obj.getString("page")),10);
        List<AdminMusic> musics = adminMusicService.getMusicList(adminPageBean);
        if(musics != null){
            adminMusicsState.setState(1);
            adminMusicsState.setMsg("成功");
            Integer total = adminMusicService.getTotalMusics();
            adminMusicsState.setTotal(total);
            adminMusicsState.setList(musics);
        }else{
            adminMusicsState.setState(0);
            adminMusicsState.setMsg("失败");
            adminMusicsState.setTotal(0);
            adminMusicsState.setList(null);
        }
        return adminMusicsState;
    }

    @RequestMapping("/getMusicById")
    @ResponseBody
    public AdminMusicState getMusicById(HttpServletRequest request){
        String jsonString = Utils.getRequestBody(request);
        JSONObject obj = JSONObject.fromObject(jsonString);
        AdminMusicState adminMusicState = new AdminMusicState();
        AdminMusic2 adminMusic2 = adminMusicService.getMusicById(Integer.parseInt(obj.getString("musicId")));
        if(adminMusic2 != null){
            adminMusicState.setState(1);
            adminMusicState.setMsg("成功");
            adminMusicState.setList(adminMusic2);
        }else{
            adminMusicState.setState(0);
            adminMusicState.setMsg("失败");
            adminMusicState.setList(null);
        }
        return adminMusicState;
    }

    @RequestMapping("/getLabels")
    @ResponseBody
    public AdminMusicTypesState getLabels(){
        AdminMusicTypesState adminMusicTypesState = new AdminMusicTypesState();
        List<AdminMusicType> types = adminMusicService.getLabels();
        if(types != null){
            adminMusicTypesState.setState(1);
            adminMusicTypesState.setMsg("成功");
            adminMusicTypesState.setList(types);
        }else{
            adminMusicTypesState.setState(0);
            adminMusicTypesState.setMsg("失败");
            adminMusicTypesState.setList(null);
        }
        return adminMusicTypesState;
    }

    @RequestMapping("/addMusic")
    @ResponseBody
    public AdminMusicAddState addMusic(HttpServletRequest request){
        AdminMusic3 music = new AdminMusic3();
        music.setName(Utils.getParameter(request,"name",String.class));
        music.setTypeId(Utils.getParameter(request,"typeId",Integer.class));
        music.setDescription(Utils.getParameter(request,"description",String.class));
        music.setMusician(Utils.getParameter(request,"musician",String.class));
        music.setUpload_date(Utils.getParameter(request,"upload_date",String.class));
        music.setKeywords(Utils.getParameter(request,"keywords",String.class));
        MultipartRequest req = (MultipartRequest)request;
        MultipartFile mfile1 = req.getFile("img_addr");
        if(mfile1 != null){
            String fileName = Utils.getFileId(mfile1.getOriginalFilename());
            String img_addr = QiNiuUtils.uploadFile(mfile1,fileName,0);
            music.setImg_addr(img_addr);
        }
        MultipartFile mfile2 = req.getFile("save_addr");
        if(mfile2 != null){
            String fileName = Utils.getFileId(mfile2.getOriginalFilename());
            String save_addr = QiNiuUtils.uploadFile(mfile2,fileName,1);
            music.setSave_addr(save_addr);
        }
        AdminMusicAddState adminMusicAddState = new AdminMusicAddState();
        Integer num = adminMusicService.addMusic(music);
        if(num != null){
            adminMusicAddState.setState(1);
            adminMusicAddState.setMsg("成功");
            adminMusicAddState.setMusicId(music.getMusic_id());
        }else{
            adminMusicAddState.setState(0);
            adminMusicAddState.setMsg("失败");
            adminMusicAddState.setMusicId(null);
        }
        return adminMusicAddState;
    }

    @RequestMapping("/editMusic")
    @ResponseBody
    public State editMusic(HttpServletRequest request){
        AdminMusic2 music = new AdminMusic2();
        music.setMusic_id(Utils.getParameter(request,"music_id",Integer.class));
        music.setName(Utils.getParameter(request,"name",String.class));
        music.setTypeId(Utils.getParameter(request,"typeId",Integer.class));
        music.setPlay_num(Utils.getParameter(request,"play_num",Integer.class));
        music.setDescription(Utils.getParameter(request,"description",String.class));
        music.setMusician(Utils.getParameter(request,"musician",String.class));
        music.setUpload_date(Utils.getParameter(request,"upload_date",String.class));
        MultipartRequest req = (MultipartRequest)request;
        MultipartFile mfile1 = req.getFile("img_addr");
        if(mfile1 != null){
            String fileName = Utils.getFileId(mfile1.getOriginalFilename());
            String img_addr = QiNiuUtils.uploadFile(mfile1,fileName,0);
            music.setImg_addr(img_addr);
        }
        MultipartFile mfile2 = req.getFile("save_addr");
        if(mfile2 != null){
            String fileName = Utils.getFileId(mfile2.getOriginalFilename());
            String save_addr = QiNiuUtils.uploadFile(mfile2,fileName,1);
            music.setSave_addr(save_addr);
        }
        State state = new State();
        Integer num = adminMusicService.editMusic(music);
        if(num != null){
            state.setState(1);
            state.setMsg("成功");
        }else{
            state.setState(0);
            state.setMsg("失败");
        }
        return state;
    }

    @RequestMapping("/searchMusics")
    @ResponseBody
    public AdminMusicsState searchMusics(HttpServletRequest request){
        String jsonString = Utils.getRequestBody(request);
        JSONObject obj = JSONObject.fromObject(jsonString);
        AdminMusicsState adminMusicsState = new AdminMusicsState();
        List<AdminMusic> musics = adminMusicService.searchMusics();
        List<AdminMusic> list = new ArrayList<AdminMusic>();
        if(musics != null){
            Boolean flag = false;
            for (int i = 0; i < musics.size(); i++) {
                flag = musics.get(i).toString().contains(obj.getString("keyWord"));
                if (flag) {
                    list.add(musics.get(i));
                }
            }
            if (list.size() > 0) {
                adminMusicsState.setState(1);
                adminMusicsState.setMsg("成功");
                adminMusicsState.setList(list);
                adminMusicsState.setTotal(list.size());
            } else {
                adminMusicsState.setState(0);
                adminMusicsState.setMsg("未找到");
                adminMusicsState.setList(null);
                adminMusicsState.setTotal(0);
            }
        } else {
            adminMusicsState.setState(0);
            adminMusicsState.setMsg("失败");
            adminMusicsState.setList(null);
            adminMusicsState.setTotal(0);
        }
        return adminMusicsState;
    }

    @RequestMapping("/deleteMusics")
    @ResponseBody
    public State deleteMusics(HttpServletRequest request){
        String jsonString = Utils.getRequestBody(request);
        JSONObject obj = JSONObject.fromObject(jsonString);
        State state = new State();

        JSONArray arr = obj.getJSONArray("musicsId");
        Integer[] item = new Integer[arr.size()];
        for (int i = 0;i < arr.size();i++){
            item[i] = arr.getInt(i);
        }
        Integer num = adminMusicService.deleteMusics(item);
        if(num != null){
            state.setState(1);
            state.setMsg("成功");
        }else{
            state.setState(0);
            state.setMsg("失败");
        }
        return state;
    }

    @RequestMapping("/changeLabelStatus")
    @ResponseBody
    public State changeLabelStatus(HttpServletRequest request){
        String jsonString = Utils.getRequestBody(request);
        JSONObject obj = JSONObject.fromObject(jsonString);
        State state = new State();
        Integer num = adminMusicService.changeLabelStatus(Integer.parseInt(obj.getString("labelId")));
        if(num != null){
            state.setState(1);
            state.setMsg("成功");
        }else{
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
        Integer num = adminMusicService.addLabel(obj.getString("labelName"));
        if(num != null){
            state.setState(1);
            state.setMsg("成功");
        }else{
            state.setState(0);
            state.setMsg("失败");
        }
        return state;
    }
}
