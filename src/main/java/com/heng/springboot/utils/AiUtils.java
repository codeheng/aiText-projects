package com.heng.springboot.utils;


import com.baidu.aip.ocr.AipOcr;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
//文字识别工具，百度paddle
public class AiUtils {
    //设置APPID/AK/SK
    public static final String APP_ID = "25573864";
    public static final String API_KEY = "LeBtTz2SkbRYU6iyr2G3mrEh";
    public static final String SECRET_KEY = "KZYFiIzGpUypyUkRGmVhpT7IbwISyorD";

    public static String picToWords(MultipartFile file) throws IOException {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 调用接口
        // String path = "src/main/resources/img/test.jpg";
        JSONObject res = client.basicGeneral(file.getBytes(), new HashMap<String, String>());
        //获取结果中 words_result
        JSONArray words_result = res.getJSONArray("words_result");
        //遍历
        String result = "";
        for (int i = 0; i < words_result.length(); i++) {
            JSONObject jsonObject = words_result.getJSONObject(i);//获得每一个列表
            String words = (String) jsonObject.get("words");//得到key对应的value
            result += words +" ";
        }
        return  result;
    }
}