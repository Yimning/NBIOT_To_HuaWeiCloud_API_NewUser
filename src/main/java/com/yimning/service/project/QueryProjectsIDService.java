package com.yimning.service.project;

import com.yimning.common.lang.HttpResponseResult;
import com.yimning.entity.product.*;
import com.yimning.entity.project.ProjectsID;
import com.yimning.service.apig.SignUtil;
import com.yimning.utils.Constant;
import com.yimning.utils.HttpUtils;
import com.yimning.utils.JsonUtils;
import com.yimning.utils.StreamClosedHttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface QueryProjectsIDService {
    /** 
     * @Description: 查询项目ID
     */
    public ProjectsID QueryProjectsID(ProjectsID projectsID) throws Exception ;

}
