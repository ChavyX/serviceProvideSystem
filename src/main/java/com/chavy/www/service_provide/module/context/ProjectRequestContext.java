package com.chavy.www.service_provide.module.context;

import com.chavy.www.service_provide.module.Project;
import lombok.Getter;
import lombok.Setter;

public class ProjectRequestContext {

    @Getter
    @Setter
    private Project project;

    @Getter
    @Setter
    private Integer projectId;

    @Getter
    @Setter
    private int size = 10;

    @Getter
    @Setter
    private int current = 1;
}
