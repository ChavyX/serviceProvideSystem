package com.chavy.www.service_provide.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chavy.www.service_provide.domain.IRoleDomain;
import com.chavy.www.service_provide.domain.IUserDomain;
import com.chavy.www.service_provide.module.Role;
import com.chavy.www.service_provide.module.User;
import com.chavy.www.service_provide.module.context.RoleRequestContext;
import com.chavy.www.service_provide.module.context.UserRequestContext;
import com.chavy.www.service_provide.module.dto.UserLoginDTO;
import com.chavy.www.service_provide.service.UserDomainService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;

@Service
public class UserDomainServiceImpl implements UserDomainService {

    @Resource
    private IUserDomain userDomain;

    @Resource
    private IRoleDomain roleDomain;

    @Override
    public UserLoginDTO login(User user) {
        UserRequestContext userRequestContext = new UserRequestContext();
        userRequestContext.setUser(user);
        user = userDomain.selectUser(userRequestContext);
        Assert.notNull(user, "登录失败");
        RoleRequestContext roleRequestContext = new RoleRequestContext();
        roleRequestContext.setUserId(user.getId());
        Role role = roleDomain.selectRole(roleRequestContext);
        UserLoginDTO userLoginDTO = new UserLoginDTO();
        userLoginDTO.setAccount(user.getAccount());
        userLoginDTO.setRoleId(role.getId());
        userLoginDTO.setUserId(user.getId());
        return userLoginDTO;
    }

    @Override
    public boolean signUp(User user) {
        UserRequestContext userRequestContext = new UserRequestContext();
        userRequestContext.setUser(user);
        user = userDomain.selectUser(userRequestContext);
        Assert.isNull(user, "用户名已存在");
        return userDomain.addUser(userRequestContext);
    }

    @Override
    public Page<User> selectUserList(User user) {
        UserRequestContext userRequestContext = new UserRequestContext();
        userRequestContext.setUser(user);
        RoleRequestContext roleRequestContext = new RoleRequestContext();
        roleRequestContext.setRoleId(0);
        userRequestContext.setUserIdList(roleDomain.selectUserIds(roleRequestContext));
        return userDomain.selectUserList(userRequestContext);
    }
}
