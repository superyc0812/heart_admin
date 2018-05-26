package com.xupt.util;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 工具类
 */
public class Utils {

    public static final Map<String,Integer[]> testTypeMap = new HashMap<String,Integer[]>();

    public static final Map map = new HashMap();
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    private static int count = 0;

    /**
     * 获取4 ~ 6之间的随机整数
     * @return
     */
    public static Integer getRandom(){
        Integer num = null;
        while(true){
            num = (int)(Math.random() * 7);
            if(num > 3 && num < 7) {
                break;
            }
        }
        return num;
    }

    public static Boolean removeDuplicateNum(Integer[] nums,Integer key){
        Boolean flag = false;
        int i;
        for(i = 0;i < nums.length && (nums[i] != key);i++);
        return (i < nums.length ? false : true);
    }

    public static <T> T getParameter(HttpServletRequest request, String paraName, Class<T> clz){
        T result = null;
        String value = request.getParameter(paraName);
        if(value != null && value.length() >= 0){
            //字符串类String，Number的子类都有一个接受String类型的参数
            try{
                result = clz.getDeclaredConstructor(String.class).newInstance(value);
            }catch(Exception e){
                e.printStackTrace();
            };
        }
        return result;
    }

    /**
     * 读取过滤文件中的文字
     * @param src
     * @return
     */
    public static void readFilterProperties(String src){
        Properties props = new Properties();
        try{
            InputStream input = new BufferedInputStream(new FileInputStream(src));
            InputStreamReader in = new InputStreamReader(input,"utf-8");
            props.load(in);
            Enumeration en = props.propertyNames();
            while (en.hasMoreElements()) {
                String key = (String) en.nextElement();
                String value = props.getProperty(key);
                Utils.map.put(key, value);//把properties文件中的key-value存放到一个map中
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 对于符合map中的key值实现替换功能
     * @param map
     * @param name
     * @return
     */
    public static String replaceCheck(Map map,String name){
        Integer senLen = 0;     //统计铭感文字个数
        Set<String> keys = map.keySet();
        Iterator<String> iter = keys.iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            String value = (String) map.get(key);
            if (name.contains(key)) {
                senLen += key.length();
                name=name.replace(key, value);//对于符合map中的key值实现替换功能
            }
        }
        if(senLen > name.length()/2){ //铭感文字超过内容一半
            name = null;
        }
        return name;
    }

    /**
     * 获取请求的 body
     * @param req
     * @return
     * @throws IOException
     */
    public synchronized static String getRequestBody(HttpServletRequest req){
        StringBuffer requestBody = null;
        try {
            BufferedReader reader = req.getReader();    //获取请求体的输入流
            String input = null;
            requestBody = new StringBuffer();
            while ((input = reader.readLine()) != null) {
                requestBody.append(input);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return requestBody.toString();
    }

    /**
     * 获取独一无二的文件名
     * @param name
     * @return
     */
    public static String getFileId(String name){
        String fileId = sdf.format(new Date()) + (count++);
        if(count >= 10){
            count = 0;
        }
        int index = name.lastIndexOf(".");	//获取到文件的扩展名
        String extension = null;
        if(index > 0){
            extension = name.substring(index);	//截取
        }
        if(extension != null){
            fileId += extension;
        }
        return fileId;
    }
}
