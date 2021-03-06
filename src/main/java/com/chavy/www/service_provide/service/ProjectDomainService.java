package com.chavy.www.service_provide.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chavy.www.service_provide.module.Project;
import com.chavy.www.service_provide.module.dto.ProjectQueryDTO;

public interface ProjectDomainService {

    boolean addProject(Project project);

    boolean updateProject(Project project);

    boolean deleteProject(Integer project);

    Page<Project> selectProject(ProjectQueryDTO project);
}
