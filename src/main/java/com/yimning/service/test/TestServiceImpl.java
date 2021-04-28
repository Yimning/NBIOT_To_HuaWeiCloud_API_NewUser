package com.yimning.service.test;

import com.yimning.entity.deviceMessage.QueryDeviceMessageByIDResponse;
import com.yimning.entity.productManagement.*;
import com.yimning.service.apig.SignUtil;
import com.yimning.service.test.utils.FileUtils;
import com.yimning.service.test.utils.JsonToEntityBean;
import com.yimning.utils.Constant;
import com.yimning.utils.HttpUtils;
import com.yimning.utils.JsonUtils;
import com.yimning.utils.StreamClosedHttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

import java.io.File;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestServiceImpl {

    public static void main(String[] args) throws Exception {
        String json = "{\"message_id\":\"b320826d-ded0-45d6-a200-40d63a01bec0\",\"name\":\"demoData1\",\"message\":{\"data\": \"demoData\",\"test\": \"demoData\"},\"encoding\":\"none\",\"payload_format\":\"standard\",\"topic\":null,\"status\":\"DELIVERED\",\"created_time\":\"20210419T072224Z\",\"finished_time\":\"20210419T072224Z\"}\n";
        System.out.println(JsonUtils.jsonString2SimpleObj(json, QueryDeviceMessageByIDResponse.class));
        System.out.println(JsonUtils.convertObject2ObjectNode(JsonUtils.jsonString2SimpleObj(json, QueryDeviceMessageByIDResponse.class)));
        System.out.println(JsonUtils.convertJsonStringToObject(json, QueryDeviceMessageByIDResponse.class));
        System.out.println(JsonUtils.fromJson(json, QueryDeviceMessageByIDResponse.class));


        String jsonParas = FileUtils.readToString(new File(
                Constant.PROJECT_FILE_PATH + "/src/main/resources/JsonString.json"), "UTF-8");

        String writeToFilePath = Constant.PROJECT_FILE_PATH + "/src/main/java/com/yimning/entity/deviceMessage/Test.java";

        for (String retval : jsonParas.split(",")) {
            System.out.println("retval" + retval);
        }

        /** 
         * 取两个字符之间的字符串 
         * 正则表达式（）
         */
        String filetext = "{\"data\": \"demoData\",\"test\": \"demoData\",\"name\":\"demoData1\",\"topic\":null,\"status\":\"DELIVERED\"}";
        String filetext1 = filetext.replaceAll(",", "");
        System.out.println(filetext1);//m.group(1)不包括这两个字符

        filetext1 = filetext1.replaceAll(" ", "");
        filetext1 = filetext1.replaceAll(":null", "");
        System.out.println(filetext1);//m.group(1)不包括这两个字符
        filetext1 = filetext1.replaceAll("\\:\\\"(.*?)\\\"", "");
        System.out.println(filetext1);//m.group(1)不包括这两个字符

        filetext = filetext.replaceAll(" ", "");
        String filetext2 = filetext.replaceAll(",", "");
        Pattern p = Pattern.compile("\\\"(.*?)\"\\:(.*?)");//正则表达式
        System.out.println("----" + filetext2);//m.group(1)不包括这两个字符
        Matcher m1 = p.matcher(filetext2);
        while (m1.find()) {
            //System.out.println(m1.group(0));//m.group(1)不包括这两个字符
            System.out.println(m1.group(1));//m.group(1)不包括这两个字符
            //System.out.println(m1.group(2));//m.group(1)不包括这两个字符
        }


        // JsonToEntityBean.parseJson2Java(jsonParas,writeToFilePath);
    }
}
