package com.xupt.util;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class QiNiuUtils {
    //设置秘钥
    public static final String ACCESS_KEY = "PP0-WfHqwTiyu1GEoyvkSna-7dr7fDRFnukMkSyo";
    public static final String SECRET_KEY = "yf4VSikAyab705zxOZm8znVgOC3iZ6xp84fHUw1g";
    public static final String filePath_img = "http://p7km87g42.bkt.clouddn.com/";
    public static final String filePath_song = "http://p7kmu6zps.bkt.clouddn.com/";

    //存储图片和音乐空间名
    private static final String bucket = "picture";
    public static final String save_img = "heart-website-img";
    public static final String save_song = "heart-website-song";

    /**
     * 设置指定的存储空间
     * @param bucketName
     * @return
     */
    public static String token(String bucketName){
        Auth auth = Auth.create(ACCESS_KEY,SECRET_KEY);
        String upToken = auth.uploadToken(bucketName);
        return upToken;
    }

    /**
     * 设置默认的存储空间
     * @return
     */
    public static String token() {
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        String upToken = auth.uploadToken(bucket);
        return upToken;
    }

    /**
     * 上传文件
     * @param fileName
     * @param flag
     * @return
     */
    public static String uploadFile(MultipartFile file, String fileName, Integer flag) {
        String bucketName = save_img;
        String filePath = filePath_img;
        if(flag == 1){
            bucketName = save_song;
            filePath = filePath_song;
        }
        try {
            byte[] bytes = file.getBytes();
            ByteArrayInputStream byteInputStream = new ByteArrayInputStream(bytes);
            Configuration cfg = new Configuration(Zone.zone2());    //华南
            UploadManager uploadManager = new UploadManager(cfg);
            Response response = uploadManager.put(byteInputStream, fileName, token(bucketName),null,null);
            // 解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            //System.out.println(putRet.key);
            //System.out.println(putRet.hash);
            return filePath + fileName;
        } catch (QiniuException ex) {
            Response r = ex.response;
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                ex2.printStackTrace();
            }
            return null;
        }catch(IOException e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据Key值删除云端文件
     * @param key
     */
    public static Boolean deleteFile(String key){
        Configuration cfg = new Configuration(Zone.zone2());
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        BucketManager bucketManager = new BucketManager(auth, cfg);
        try {
            Response result =  bucketManager.delete(bucket, key);
            System.err.println(new Gson().toJson(result));
            if(result.statusCode==200){
                return true;
            }
        } catch (QiniuException ex) {
            //如果遇到异常，说明删除失败
            System.err.println(ex.code());
            System.err.println(ex.response.toString());
        }
        return false;
    }
}
