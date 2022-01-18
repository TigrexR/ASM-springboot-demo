package com.tigrex.bytecode.service.impl;

import com.tigrex.bytecode.entity.bo.UserBO;
import com.tigrex.bytecode.entity.query.UserQuery;
import com.tigrex.bytecode.mapper.UserMapper;
import com.tigrex.bytecode.service.IUserService;
import com.tigrex.bytecode.utils.JacksonUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author linus
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public UserBO getUser(UserQuery userQuery) {
        return JacksonUtils.getJackson().convertValue(mapper.selectById(userQuery.getName()), UserBO.class);
    }

}
