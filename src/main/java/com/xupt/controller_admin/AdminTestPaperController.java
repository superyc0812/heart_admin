package com.xupt.controller_admin;

import com.xupt.service_admin.AdminTestAnswerService;
import com.xupt.service_admin.AdminTestPaperService;
import com.xupt.service_admin.AdminTestTitleService;
import com.xupt.util.*;
import com.xupt.vo_admin.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mapis/test")
public class AdminTestPaperController {

    @Resource
    AdminTestPaperService adminTestPaperService;

    @Resource
    AdminTestTitleService adminTestTitleService;

    @Resource
    AdminTestAnswerService adminTestAnswerService;

    @RequestMapping(path = "/getTestList",method = RequestMethod.POST)
    @ResponseBody
    public AdminTestPapersState getTestList(HttpServletRequest request){
        String jsonString = Utils.getRequestBody(request);
        JSONObject obj = JSONObject.fromObject(jsonString);
        AdminTestPapersState adminTestPapersState = new AdminTestPapersState();
        AdminPageBean adminPageBean = new AdminPageBean(Integer.parseInt(obj.getString("page")),10);
        List<AdminTestPaper> testPapers = adminTestPaperService.getTestList(adminPageBean);
        if(testPapers != null){
            adminTestPapersState.setState(1);
            adminTestPapersState.setMsg("成功");
            adminTestPapersState.setList(testPapers);
        }else{
            adminTestPapersState.setState(0);
            adminTestPapersState.setMsg("失败");
            adminTestPapersState.setList(null);
        }
        return adminTestPapersState;
    }

    @RequestMapping(path = "/getTestById",method = RequestMethod.POST)
    @ResponseBody
    public AdminTestPaperState getTestById(HttpServletRequest request){
        String jsonString = Utils.getRequestBody(request);
        JSONObject obj = JSONObject.fromObject(jsonString);
        AdminTestPaperState adminTestPaperState = new AdminTestPaperState();
        AdminTestPaper2 adminTestPaper2 = adminTestPaperService.getTestById(Integer.parseInt(obj.getString("testId")));
        if(adminTestPaper2 != null){
            adminTestPaperState.setState(1);
            adminTestPaperState.setMsg("成功");
            adminTestPaperState.setList(adminTestPaper2);
        }else{
            adminTestPaperState.setState(0);
            adminTestPaperState.setMsg("失败");
            adminTestPaperState.setList(null);
        }
        return adminTestPaperState;
    }

    @RequestMapping(path = "/addTestPaper",method = RequestMethod.POST)
    @ResponseBody
    public AdminAddTeatPaperState addTestPaper(HttpServletRequest request){
        AdminTestPaper2 paper = new AdminTestPaper2();
        paper.setTypeId(Utils.getParameter(request,"typeId",Integer.class));
        paper.setTest_name(Utils.getParameter(request,"test_name",String.class));
        MultipartRequest req = (MultipartRequest)request;
        MultipartFile mfile = req.getFile("picture_addr");
        if(mfile != null){
            String fileName = Utils.getFileId(mfile.getOriginalFilename());
            String picture_addr = QiNiuUtils.uploadFile(mfile,fileName,0);
            paper.setPicture_addr(picture_addr);
        }
        AdminAddTeatPaperState adminAddTeatPaperState = new AdminAddTeatPaperState();
        Integer num = adminTestPaperService.addTestPaper(paper);
        if (num != null) {
            adminAddTeatPaperState.setState(1);
            adminAddTeatPaperState.setMsg("成功");
            adminAddTeatPaperState.setTestId(paper.getTest_id());
        } else {
            adminAddTeatPaperState.setState(0);
            adminAddTeatPaperState.setMsg("失败");
            adminAddTeatPaperState.setTestId(null);
        }
        return adminAddTeatPaperState;
    }

    @RequestMapping(path = "/editTestPaper",method = RequestMethod.POST)
    @ResponseBody
    public State editTestPaper(HttpServletRequest request){
        AdminTestPaper2 paper = new AdminTestPaper2();
        paper.setTest_id(Utils.getParameter(request,"test_id",Integer.class));
        paper.setTypeId(Utils.getParameter(request,"typeId",Integer.class));
        paper.setTest_name(Utils.getParameter(request,"test_name",String.class));
        paper.setPicture_addr(Utils.getParameter(request,"picture_addr",String.class));
        MultipartRequest req = (MultipartRequest)request;
        MultipartFile mfile = req.getFile("picture_addr");
        if(mfile != null){
            String fileName = Utils.getFileId(mfile.getOriginalFilename());
            String picture_addr = QiNiuUtils.uploadFile(mfile,fileName,0);
            paper.setPicture_addr(picture_addr);
        }
        State state = new State();
        Integer num = adminTestPaperService.editTestPaper(paper);
        if(num != null){
            state.setState(1);
            state.setMsg("成功");
        }else{
            state.setState(0);
            state.setMsg("失败");
        }
        return state;
    }

    @RequestMapping(path = "/getQuestions",method = RequestMethod.POST)
    @ResponseBody
    public AdminTestTitlesState getQuestions(HttpServletRequest request){
        String jsonString = Utils.getRequestBody(request);
        JSONObject obj = JSONObject.fromObject(jsonString);
        AdminTestTitlesState adminTestTitlesState = new AdminTestTitlesState();
        List<AdminTestTitle> titles = adminTestTitleService.getQuestions(Integer.parseInt(obj.getString("testId")));
        if(titles != null){
            adminTestTitlesState.setState(1);
            adminTestTitlesState.setMsg("成功");
            adminTestTitlesState.setList(titles);
        }else{
            adminTestTitlesState.setState(0);
            adminTestTitlesState.setMsg("失败");
            adminTestTitlesState.setList(null);
        }
        return adminTestTitlesState;
    }

    @RequestMapping(path = "/addQuestions",method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public State addQuestions(HttpServletRequest request){
        String jsonString = Utils.getRequestBody(request);
        JSONObject obj = JSONObject.fromObject(jsonString);
        State state = new State();
        AdminTestTitle adminTestTitle = null;
        JSONArray arr = obj.getJSONArray("questions");
        if(arr != null){
            Integer testId = Integer.parseInt(obj.getString("testId"));
            for (int i=0;i<arr.size();i++){
                adminTestTitle = new AdminTestTitle();
                adminTestTitle.setTest_id(testId);
                adminTestTitle.setTitle_name(arr.getJSONObject(i).getString("title_name"));
                adminTestTitle.setChoose_one(arr.getJSONObject(i).getString("choose_one"));
                adminTestTitle.setChoose_two(arr.getJSONObject(i).getString("choose_two"));
                adminTestTitle.setChoose_three(arr.getJSONObject(i).getString("choose_three"));
                adminTestTitle.setChoose_four(arr.getJSONObject(i).getString("choose_four"));
                Integer num = adminTestTitleService.addQuestions(adminTestTitle);
                if(num != null){
                    state.setState(1);
                    state.setMsg("成功");
                }else{
                    state.setState(0);
                    state.setMsg("失败");
                    break;
                }
            }
        }else{
            state.setState(0);
            state.setMsg("失败");
        }
        return state;
    }

    @RequestMapping(path = "/editQuestions",method = RequestMethod.POST)
    @ResponseBody
    public State editQuestions(HttpServletRequest request){
        String jsonString = Utils.getRequestBody(request);
        JSONObject obj = JSONObject.fromObject(jsonString);
        State state = new State();
        AdminTestTitle adminTestTitle = null;
        JSONArray arr = obj.getJSONArray("questions");
        if(arr != null){
            for (int i=0;i<arr.size();i++){
                adminTestTitle = new AdminTestTitle();
                adminTestTitle.setTitle_name(arr.getJSONObject(i).getString("title_name"));
                adminTestTitle.setChoose_one(arr.getJSONObject(i).getString("choose_one"));
                adminTestTitle.setChoose_two(arr.getJSONObject(i).getString("choose_two"));
                adminTestTitle.setChoose_three(arr.getJSONObject(i).getString("choose_three"));
                adminTestTitle.setChoose_four(arr.getJSONObject(i).getString("choose_four"));
                Integer num = null;
                if(arr.getString(i).contains("title_id")) {      //编辑
                    adminTestTitle.setTest_id(Integer.parseInt(arr.getJSONObject(i).getString("test_id")));
                    request.getSession().setAttribute("test_id",Integer.parseInt(arr.getJSONObject(i).getString("test_id")));
                    adminTestTitle.setTitle_id(Integer.parseInt(arr.getJSONObject(i).getString("title_id")));
                    num = adminTestTitleService.editQuestions(adminTestTitle);
                }else {     //添加
                    adminTestTitle.setTest_id((Integer)request.getSession().getAttribute("test_id"));
                    num = adminTestTitleService.addQuestions(adminTestTitle);
                }
                if(num != null){
                    state.setState(1);
                    state.setMsg("成功");
                }else{
                    state.setState(0);
                    state.setMsg("失败");
                    break;
                }
            }
        }else{
            state.setState(0);
            state.setMsg("失败");
        }
        request.getSession().removeAttribute("test_id");
        return state;
    }

    @RequestMapping(path = "/deleteTestQuestions",method = RequestMethod.POST)
    @ResponseBody
    public State deleteTestQuestions(HttpServletRequest request){
        String jsonString = Utils.getRequestBody(request);
        JSONObject obj = JSONObject.fromObject(jsonString);
        State state = new State();
        JSONArray arr = obj.getJSONArray("titlesId");
        Integer[] item = new Integer[arr.size()];
        for (int i = 0;i < arr.size();i++){
            item[i] = arr.getInt(i);
        }
        Integer num = adminTestTitleService.deleteTestQuestions(item);
        if (num != null) {
            state.setState(1);
            state.setMsg("成功");
        } else {
            state.setState(0);
            state.setMsg("失败");
        }
        return state;
    }

    @RequestMapping(path = "/getAnswer",method = RequestMethod.POST)
    @ResponseBody
    public AdminTestAnswersState getAnswer(HttpServletRequest request){
        String jsonString = Utils.getRequestBody(request);
        JSONObject obj = JSONObject.fromObject(jsonString);
        AdminTestAnswersState adminTestAnswersState = new AdminTestAnswersState();
        AdminTestAnswer answer = adminTestAnswerService.getAnswer(Integer.parseInt(obj.getString("testId")));
        if(answer != null){
            adminTestAnswersState.setState(1);
            adminTestAnswersState.setMsg("成功");
            adminTestAnswersState.setList(answer);
        }else{
            adminTestAnswersState.setState(0);
            adminTestAnswersState.setMsg("失败");
            adminTestAnswersState.setList(null);
        }
        return adminTestAnswersState;
    }

    @RequestMapping(path = "/editAnswer",method = RequestMethod.POST)
    @ResponseBody
    public State editAnswer(HttpServletRequest request){
        String jsonString = Utils.getRequestBody(request);
        JSONObject object = JSONObject.fromObject(jsonString);
        State state = new State();
        AdminTestAnswer adminTestAnswer = new AdminTestAnswer();
        adminTestAnswer.setTest_id(Integer.parseInt(object.getString("testId")));
        JSONObject obj = JSONObject.fromObject(object.get("answers"));
        adminTestAnswer.setRegion_one(obj.getString("region_one"));
        adminTestAnswer.setRegion_two(obj.getString("region_two"));
        adminTestAnswer.setRegion_three(obj.getString("region_three"));
        Integer num = adminTestAnswerService.editAnswer(adminTestAnswer);
        if (num != null) {
            state.setState(1);
            state.setMsg("成功");
        } else {
            state.setState(0);
            state.setMsg("失败");
        }
        return state;
    }

    @RequestMapping(path = "/addAnswer",method = RequestMethod.POST)
    @ResponseBody
    public State addAnswer(HttpServletRequest request){
        String jsonString = Utils.getRequestBody(request);
        JSONObject object = JSONObject.fromObject(jsonString);
        AdminAnswer adminAnswer = new AdminAnswer();
        State state = new State();
        JSONObject obj = object.getJSONObject("answers");
        adminAnswer.setTest_id(Integer.parseInt(object.getString("testId")));
        adminAnswer.setRegion_one(obj.getString("region_one"));
        adminAnswer.setRegion_two(obj.getString("region_two"));
        adminAnswer.setRegion_three(obj.getString("region_three"));
        Integer num = adminTestAnswerService.addAnswer(adminAnswer);
        if (num != null) {
            state.setState(1);
            state.setMsg("成功");
        } else {
            state.setState(0);
            state.setMsg("失败");
        }
        return state;
    }

    @RequestMapping(path = "/searchTest",method = RequestMethod.POST)
    @ResponseBody
    public AdminTestPapersState searchTest(HttpServletRequest request){
        String jsonString = Utils.getRequestBody(request);
        JSONObject obj = JSONObject.fromObject(jsonString);
        AdminTestPapersState adminTestPapersState = new AdminTestPapersState();
        List<AdminTestPaper> papers = adminTestPaperService.searchTest();
        List<AdminTestPaper> list = new ArrayList<AdminTestPaper>();
        if (papers != null) {
            Boolean flag = false;
            for (int i = 0; i < papers.size(); i++) {
                flag = papers.get(i).toString().contains(obj.getString("keyWord"));
                if (flag) {
                    list.add(papers.get(i));
                }
            }
            if (list.size() > 0) {
                adminTestPapersState.setState(1);
                adminTestPapersState.setMsg("成功");
                adminTestPapersState.setList(list);
                adminTestPapersState.setTotal(list.size());
            } else {
                adminTestPapersState.setState(0);
                adminTestPapersState.setMsg("未找到");
                adminTestPapersState.setList(null);
                adminTestPapersState.setTotal(0);
            }
        } else {
            adminTestPapersState.setState(0);
            adminTestPapersState.setMsg("失败");
            adminTestPapersState.setList(null);
            adminTestPapersState.setTotal(0);
        }
        return adminTestPapersState;
    }

    @RequestMapping(path = "/deleteTest",method = RequestMethod.POST)
    @ResponseBody
    public State deleteTest(HttpServletRequest request){
        String jsonString = Utils.getRequestBody(request);
        JSONObject obj = JSONObject.fromObject(jsonString);
        State state = new State();
        JSONArray arr = obj.getJSONArray("testsId");
        Integer[] item = new Integer[arr.size()];
        for (int i = 0;i < arr.size();i++){
            item[i] = arr.getInt(i);
        }
        Integer num = adminTestPaperService.deleteTest(item);
        if (num != null) {
            state.setState(1);
            state.setMsg("成功");
        } else {
            state.setState(0);
            state.setMsg("失败");
        }
        return state;
    }

    @RequestMapping(path = "/getLabels",method = RequestMethod.POST)
    @ResponseBody
    public AdminTestPaperTypesState getLabels(){
        AdminTestPaperTypesState adminTestPaperTypesState = new AdminTestPaperTypesState();
        List<AdminTestPaperType> types = adminTestPaperService.getLabels();
        if(types != null){
            adminTestPaperTypesState.setState(1);
            adminTestPaperTypesState.setMsg("成功");
            adminTestPaperTypesState.setList(types);
        }else{
            adminTestPaperTypesState.setState(0);
            adminTestPaperTypesState.setMsg("失败");
            adminTestPaperTypesState.setList(null);
        }
        return adminTestPaperTypesState;
    }

    @RequestMapping("/changeLabelStatus")
    @ResponseBody
    State changeLabelStatus(HttpServletRequest request) {
        String jsonString = Utils.getRequestBody(request);
        JSONObject obj = JSONObject.fromObject(jsonString);
        State state = new State();
        Integer num = adminTestPaperService.changeLabelStatus(Integer.parseInt(obj.getString("labelId")));
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
    public State addLable(HttpServletRequest request) {
        String jsonString = Utils.getRequestBody(request);
        JSONObject obj = JSONObject.fromObject(jsonString);
        State state = new State();
        Integer num = adminTestPaperService.addLable(obj.getString("labelName"));
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
