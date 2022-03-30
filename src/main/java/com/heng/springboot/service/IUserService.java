package com.heng.springboot.service;

import com.heng.springboot.controller.dto.UserDTO;
import com.heng.springboot.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author heng
 * @since 2022-02-12
 */
public interface IUserService extends IService<User> {

    UserDTO login(UserDTO user);

    User register(UserDTO userDTO);
}
