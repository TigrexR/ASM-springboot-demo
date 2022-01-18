package com.tigrex.bytecode.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tigrex.bytecode.entity.query.UserQuery;
import com.tigrex.bytecode.entity.vo.UserVO;
import com.tigrex.bytecode.service.IUserService;
import com.tigrex.bytecode.utils.JacksonUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author linus
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/user/hello", method = RequestMethod.GET)
	public String hello() {
        return "hello world!";
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    public UserVO getUser(
            @RequestBody() UserQuery userQuery) throws JsonProcessingException {
        logger.info(JacksonUtils.getJackson().writeValueAsString(userQuery));
        return JacksonUtils.getJackson().convertValue(userService.getUser(userQuery), UserVO.class);
    }

}
