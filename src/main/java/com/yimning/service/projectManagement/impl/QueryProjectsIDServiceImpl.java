package com.yimning.service.projectManagement.impl;

import com.alibaba.fastjson.JSONObject;
import com.yimning.common.lang.HttpResponseResult;
import com.yimning.entity.projectManagement.ProjectsID;
import com.yimning.service.auth.Authentication;
import com.yimning.service.projectManagement.QueryProjectsIDService;
import com.yimning.utils.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class QueryProjectsIDServiceImpl implements QueryProjectsIDService {

    @Override
    public ProjectsID queryProjectsID(ProjectsID projectsID) throws Exception {
        String token = Authentication.getToken();
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.initClient();

        String url = Constant.PROJECTS_ID_URL;

        Map<String, String> header = new HashMap<String, String>();
        header.put("Content-Type", "application/json");
        header.put("X-Auth-Token", token);
        Map map = TypeConversionUtils.getObjectToValMap(projectsID, false);
        System.out.println(map);
        StreamClosedHttpResponse httpResponse = httpUtils.doGet(url, header, map);

        System.out.println(httpResponse.getStatusLine());
        System.out.println(httpResponse.getContent());
        System.out.println();

        HttpResponseResult httpResponseResult = new HttpResponseResult();
        if (httpResponse.getStatusLine().getStatusCode() == 200) {
            projectsID = JSONObject.parseObject(httpResponse.getContent(), ProjectsID.class);
        }
        httpResponseResult.setStatus_code(httpResponse.getStatusLine().getStatusCode());
        httpResponseResult.setReason_phrase(httpResponse.getStatusLine().getReasonPhrase());
        projectsID.setHttpResponseResult(httpResponseResult);

//        List<Projects> list1 =projectsID.getProjects();
//        Iterator<Projects> iter = list1.iterator();
//        while(iter.hasNext()){  //执行过程中会执行数据锁定，性能稍差，若在循环过程中要去掉某个元素只能调用iter.remove()方法。
//            System.out.println(iter.next());
//        }
        return projectsID;
    }
}
