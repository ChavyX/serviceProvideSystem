package com.chavy.www.service_provide.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chavy.www.service_provide.module.Permission;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {
}