package com.chavy.www.service_provide.domain.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.chavy.www.service_provide.dao.RoleMapper;
import com.chavy.www.service_provide.dao.UserRoleMapper;
import com.chavy.www.service_provide.domain.IRoleDomain;
import com.chavy.www.service_provide.module.Role;
import com.chavy.www.service_provide.module.UserRole;
import com.chavy.www.service_provide.module.context.RoleRequestContext;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoleDomain implements IRoleDomain {

    @Resource
    private UserRoleMapper userRoleMapper;

    @Resource
    private RoleMapper roleMapper;

    @Override
    public boolean addRole(RoleRequestContext requestContext) {
        Assert.notNull(requestContext.getUserId(), "用户id不为空");
        Assert.notNull(requestContext.getRoleId(), "角色id不为空");
        UserRole userRole = new UserRole();
        userRole.setRoleId(requestContext.getRoleId());
        userRole.setUserId(requestContext.getUserId());
        Assert.state(userRoleMapper.insert(userRole) == 1, "SYSTEM_ERROR");
        return true;
    }

    @Override
    public Role selectRole(RoleRequestContext requestContext) {
        Assert.notNull(requestContext.getUserId(), "用户id不为空");
        QueryWrapper<UserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UserRole::getUserId, requestContext.getUserId());
        UserRole userRole = userRoleMapper.selectOne(queryWrapper);
        return roleMapper.selectById(userRole.getRoleId());
    }

    @Override
    public List<Integer> selectUserIds(RoleRequestContext requestContext) {
        QueryWrapper<UserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UserRole::getRoleId, requestContext.getRoleId());
        return userRoleMapper.selectList(queryWrapper)
                .stream()
                .map(UserRole::getUserId)
                .collect(Collectors.toList());
    }
}
