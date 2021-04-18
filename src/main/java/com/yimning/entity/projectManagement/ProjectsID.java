/**
  * Copyright 2021 json.cn 
  */
package com.yimning.entity.projectManagement;
import com.yimning.common.lang.HttpResponseResult;
import lombok.Data;

import java.util.List;

/**
 * Auto-generated: 2021-04-16 18:58:13
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Data
public class ProjectsID {
    private String  domain_id; //项目所属帐号ID

    private Boolean  enabled;//项目是否启用。

    private Boolean  is_domain;//该字段无需填写。

    private  String  name;//项目名称，获取方式请参见：获取帐号、IAM用户、项目、用户组、区域、委托的名称和ID。

    private Integer page;//分页查询时数据的页数，查询值最小为1。需要与per_page同时存在。

    private String  parent_id;//如果查询自己创建的项目，则此处应填为所属区域的项目ID。

    private Integer  per_page;//分页查询时每页的数据个数，取值范围为[1,5000]。需要与page同时存在。


    private List<Projects> projects;
    private Links links;
    private  HttpResponseResult httpResponseResult;

}