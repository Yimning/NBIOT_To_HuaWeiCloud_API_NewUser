package com.yimning.controller.projectController;
import com.yimning.entity.product.AddProduct;
import com.yimning.entity.project.ProjectsID;
import com.yimning.service.project.QueryProjectsIDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/project")
public class QueryProjectsIDController {
    @Autowired
    private QueryProjectsIDService queryProjectsIDService;

    @PostMapping("/queryProjectsID")
    public ProjectsID QueryDevice(@RequestBody ProjectsID projectsID)throws Exception {
        projectsID = queryProjectsIDService.QueryProjectsID(projectsID);
        return projectsID;
    }
}
