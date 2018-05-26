package com.xupt.controller_admin;

import com.xupt.service_admin.AdminAmlCommentService;
import com.xupt.service_admin.AdminArticleCommentService;
import com.xupt.service_admin.AdminArticleService;
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
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mapis/article")
public class AdminArticleController {

    @Resource
    AdminArticleService adminArticleService;

    @Resource
    AdminArticleCommentService adminArticleCommentService;

    @Resource
    AdminAmlCommentService amlCommentService;

    @RequestMapping("/getLabels")
    @ResponseBody
    public AdminArticleTypesState getLabels() {
        AdminArticleTypesState adminArticleTypesState = new AdminArticleTypesState();
        List<AdminArticleType> articleTypes = adminArticleService.getLabels();
        if (articleTypes != null) {
            adminArticleTypesState.setState(1);
            adminArticleTypesState.setMsg("成功");
            adminArticleTypesState.setList(articleTypes);
        } else {
            adminArticleTypesState.setState(0);
            adminArticleTypesState.setMsg("失败");
            adminArticleTypesState.setList(null);
        }
        return adminArticleTypesState;
    }

    @RequestMapping("/changeLabelStatus")
    @ResponseBody
    State changeLabelStatus(HttpServletRequest request) {
        String jsonString = Utils.getRequestBody(request);
        JSONObject obj = JSONObject.fromObject(jsonString);
        State state = new State();
        Integer num = adminArticleService.changeLabelStatus(Integer.parseInt(obj.getString("labelId")));
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
        Integer num = adminArticleService.addLable(obj.getString("labelName"));
        if (num != null) {
            state.setState(1);
            state.setMsg("成功");
        } else {
            state.setState(0);
            state.setMsg("失败");
        }
        return state;
    }

    @RequestMapping("/getArticleList")
    @ResponseBody
    public AdminArticlesState getArticleList(HttpServletRequest request) {
        String jsonString = Utils.getRequestBody(request);
        JSONObject obj = JSONObject.fromObject(jsonString);
        AdminArticlesState adminArticlesState = new AdminArticlesState();
        AdminPageBean adminPageBean = new AdminPageBean(Integer.parseInt(obj.getString("page")), 10);
        List<AdminArticle> articles = adminArticleService.getArticleList(adminPageBean);
        if (articles != null) {
            adminArticlesState.setState(1);
            adminArticlesState.setMsg("成功");
            Integer total = adminArticleService.getTotalArticles();
            adminArticlesState.setTotal(total);
            adminArticlesState.setList(articles);
        } else {
            adminArticlesState.setState(0);
            adminArticlesState.setMsg("失败");
            adminArticlesState.setTotal(0);
            adminArticlesState.setList(null);
        }
        return adminArticlesState;
    }

    @RequestMapping("/getArticleById")
    @ResponseBody
    public AdminArticleState getArticleById(HttpServletRequest request) {
        String jsonString = Utils.getRequestBody(request);
        JSONObject obj = JSONObject.fromObject(jsonString);
        AdminArticleState adminArticleState = new AdminArticleState();
        AdminArticle adminArticle = adminArticleService.getArticleById(Integer.parseInt(obj.getString("articleId")));
        if (adminArticle != null) {
            adminArticleState.setState(1);
            adminArticleState.setMsg("成功");
            adminArticleState.setList(adminArticle);
        } else {
            adminArticleState.setState(0);
            adminArticleState.setMsg("失败");
            adminArticleState.setList(null);
        }
        return adminArticleState;
    }

    @RequestMapping("/addArticle")
    @ResponseBody
    public AdminAddArticleState addArticle(HttpServletRequest request) {
        AdminArticle3 article = new AdminArticle3();
        article.setAuthor(Utils.getParameter(request,"author",String.class));
        article.setContent(Utils.getParameter(request,"content",String.class));
        article.setDescription(Utils.getParameter(request,"description",String.class));
        article.setTitle(Utils.getParameter(request,"title",String.class));
        article.setUpload_date(Utils.getParameter(request,"upload_date",String.class));
        article.setTypeId(Utils.getParameter(request,"typeId",Integer.class));
        article.setKeywords(Utils.getParameter(request,"keywords",String.class));
        AdminAddArticleState adminAddArticleState = new AdminAddArticleState();
        if (article != null) {
            MultipartRequest req = (MultipartRequest)request;
            MultipartFile mfile = req.getFile("picture_addr");
            if(mfile != null){
                String fileName = Utils.getFileId(mfile.getOriginalFilename());
                String picture_addr = QiNiuUtils.uploadFile(mfile,fileName,0);
                article.setPicture_addr(picture_addr);
            }
            Integer num = adminArticleService.addArticle(article);
            if (num != null) {
                adminAddArticleState.setState(1);
                adminAddArticleState.setMsg("成功");
                adminAddArticleState.setArticleId(article.getArticle_id());
            } else {
                adminAddArticleState.setState(0);
                adminAddArticleState.setMsg("失败");
                adminAddArticleState.setArticleId(null);
            }
        }
        return adminAddArticleState;
    }

    @RequestMapping("/editArticle")
    @ResponseBody
    public State editArticle(HttpServletRequest request) {
        AdminArticle article = new AdminArticle();
        article.setArticle_id(Utils.getParameter(request,"article_id",Integer.class));
        article.setAuthor(Utils.getParameter(request,"author",String.class));
        article.setContent(Utils.getParameter(request,"content",String.class));
        article.setDescription(Utils.getParameter(request,"description",String.class));
        article.setTitle(Utils.getParameter(request,"title",String.class));
        article.setUpload_date(Utils.getParameter(request,"upload_date",String.class));
        article.setTypeId(Utils.getParameter(request,"typeId",Integer.class));
        State state = new State();
        MultipartRequest req = (MultipartRequest)request;
        MultipartFile mfile = req.getFile("picture_addr");
        if(mfile != null){
            String fileName = Utils.getFileId(mfile.getOriginalFilename());
            String picture_addr = QiNiuUtils.uploadFile(mfile,fileName,0);
            article.setPicture_addr(picture_addr);
        }
        Integer num = adminArticleService.editArticle(article);
        if (num != null) {
            state.setState(1);
            state.setMsg("成功");
        } else {
            state.setState(0);
            state.setMsg("失败");
        }
        return state;
    }

    @RequestMapping("/getFirstLevelComment")
    @ResponseBody
    public AdminArticleCommentState getFirstLevelComment(HttpServletRequest request) {
        String jsonString = Utils.getRequestBody(request);
        JSONObject obj = JSONObject.fromObject(jsonString);
        AdminArticleCommentState aacSatte = new AdminArticleCommentState();
        List<AdminArticleComment> comments = adminArticleCommentService.getFirstLevelComment(Integer.parseInt(obj.getString("articleId")));
        if (comments != null) {
            aacSatte.setState(1);
            aacSatte.setMsg("成功");
            aacSatte.setList(comments);
        } else {
            aacSatte.setState(0);
            aacSatte.setMsg("失败");
            aacSatte.setList(null);
        }
        return aacSatte;
    }

    @RequestMapping("/getMoreLevelComment")
    @ResponseBody
    public AdminMoreLevelArticleComState getMoreLevelComment(HttpServletRequest request) {
        String jsonString = Utils.getRequestBody(request);
        JSONObject obj = JSONObject.fromObject(jsonString);
        AdminMoreLevelArticleComState amlacState = new AdminMoreLevelArticleComState();
        List<AdminAmlComment> comments = amlCommentService.getMoreLevelComment(Integer.parseInt(obj.getString("articleId")));
        if (comments != null) {
            amlacState.setState(1);
            amlacState.setMsg("成功");
            amlacState.setList(comments);
        } else {
            amlacState.setState(0);
            amlacState.setMsg("失败");
            amlacState.setList(null);
        }
        return amlacState;
    }

    @RequestMapping("/deleteFirstLevelComment")
    @ResponseBody
    public State deleteFirstLevelComment(HttpServletRequest request) {
        String jsonString = Utils.getRequestBody(request);
        JSONObject obj = JSONObject.fromObject(jsonString);
        State state = new State();
        Integer num = adminArticleCommentService.deleteFirstLevelComment(Integer.parseInt(obj.getString("commentId")));
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
    public State deleteMoreLevelComment(HttpServletRequest request) {
        String jsonString = Utils.getRequestBody(request);
        JSONObject obj = JSONObject.fromObject(jsonString);
        State state = new State();
        Integer num = amlCommentService.deleteMoreLevelComment(Integer.parseInt(obj.getString("commentId")));
        if (num != null) {
            state.setState(1);
            state.setMsg("成功");
        } else {
            state.setState(0);
            state.setMsg("失败");
        }
        return state;
    }

    @RequestMapping("/deleteArticles")
    @ResponseBody
    public State deleteArticles(HttpServletRequest request) {
        String jsonString = Utils.getRequestBody(request);
        JSONObject obj = JSONObject.fromObject(jsonString);
        State state = new State();

        JSONArray arr = obj.getJSONArray("articlesId");
        Integer[] item = new Integer[arr.size()];
        for (int i = 0;i < arr.size();i++){
            item[i] = arr.getInt(i);
        }

        Integer num = adminArticleService.deleteArticles(item);
        if (num != null) {
            state.setState(1);
            state.setMsg("成功");
        } else {
            state.setState(0);
            state.setMsg("失败");
        }
        return state;
    }

    @RequestMapping("/searchArticles")
    @ResponseBody
    public AdminArticlesState searchArticles(HttpServletRequest request) {
        String jsonString = Utils.getRequestBody(request);
        JSONObject obj = JSONObject.fromObject(jsonString);
        AdminArticlesState adminArticlesState = new AdminArticlesState();
        List<AdminArticle2> articles = adminArticleService.searchArticles();
        List<AdminArticle2> list = new ArrayList<AdminArticle2>();
        if (articles != null) {
            Boolean flag = false;
            for (int i = 0; i < articles.size(); i++) {
                flag = articles.get(i).toString().contains(obj.getString("keyWord"));
                if (flag) {
                    list.add(articles.get(i));
                }
            }
            if (list.size() > 0) {
                adminArticlesState.setState(1);
                adminArticlesState.setMsg("成功");
                adminArticlesState.setList(list);
                adminArticlesState.setTotal(list.size());
            } else {
                adminArticlesState.setState(0);
                adminArticlesState.setMsg("未找到");
                adminArticlesState.setList(null);
                adminArticlesState.setTotal(0);
            }
        } else {
            adminArticlesState.setState(0);
            adminArticlesState.setMsg("失败");
            adminArticlesState.setList(null);
            adminArticlesState.setTotal(0);
        }
        return adminArticlesState;
    }

}
