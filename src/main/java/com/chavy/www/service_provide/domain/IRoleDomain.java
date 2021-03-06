package com.chavy.www.service_provide.domain;

import com.chavy.www.service_provide.module.Role;
import com.chavy.www.service_provide.module.context.RoleRequestContext;

import java.util.List;

/**
 * @author Chavy
 */
public interface IRoleDomain {

    boolean addRole(RoleRequestContext requestContext);

    Role selectRole(RoleRequestContext requestContext);

    List<Integer> selectUserIds(RoleRequestContext requestContext);
}
