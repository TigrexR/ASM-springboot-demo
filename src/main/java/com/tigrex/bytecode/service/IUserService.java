package com.tigrex.bytecode.service;

import com.tigrex.bytecode.entity.bo.UserBO;
import com.tigrex.bytecode.entity.query.UserQuery;

/**
 * @author linus
 */
public interface IUserService {

    /**
     * get user
     * @param userQuery
     * @return userBO
     */
    public UserBO getUser(UserQuery userQuery);
}