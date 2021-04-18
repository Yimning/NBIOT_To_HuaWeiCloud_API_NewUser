package com.yimning.controller.projectManagementController;
import com.yimning.entity.project.ProjectsID;
import com.yimning.service.projectManagement.QueryProjectsIDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projectManagement")
public class QueryProjectsIDController {
    @Autowired
    private QueryProjectsIDService queryProjectsIDService;

    @PostMapping("/queryProjectsID")
    public ProjectsID QueryDevice(@RequestBody ProjectsID projectsID)throws Exception {
        projectsID = queryProjectsIDService.queryProjectsID(projectsID);
        return projectsID;
    }
}
