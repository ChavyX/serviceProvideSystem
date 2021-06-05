package com.chavy.www.service_provide.scenario;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chavy.www.service_provide.module.Project;
import com.chavy.www.service_provide.module.dto.ProjectQueryDTO;
import com.chavy.www.service_provide.result.CommonResult;
import com.chavy.www.service_provide.service.ProjectDomainService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController("/project")
public class ProjectClient {

    @Resource
    private ProjectDomainService projectDomainService;

    @PostMapping("/add")
    public CommonResult<Void> add(@RequestBody Project project) {
        return CommonResult.of(projectDomainService.addProject(project));
    }

    @GetMapping("/delete")
    public CommonResult<Void> delete(@RequestParam("id") Integer id) {
        return CommonResult.of(projectDomainService.deleteProject(id));
    }

    @PostMapping("/update")
    public CommonResult<Void> update(@RequestBody Project project) {
        return CommonResult.of(projectDomainService.updateProject(project));
    }

    @PostMapping("/select")
    public CommonResult<Page<Project>> select(@RequestBody ProjectQueryDTO projectQueryDTO) {
        return new CommonResult<Page<Project>>().success(projectDomainService.selectProject(projectQueryDTO));
    }
}
