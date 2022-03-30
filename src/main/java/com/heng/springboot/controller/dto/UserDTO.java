package com.heng.springboot.controller.dto;

import lombok.Data;

/*登陆前端请求的参数*/
@Data
public class UserDTO {
    private String username;
    private String password;
    private String nickname;
    private String avatar;
    private String token;
}
