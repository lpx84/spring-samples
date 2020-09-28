package com.percylee.sample.beanvalidation.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 用户信息
 *
 * @author 李鹏翔(lipengxiang1)
 * @date 2019-09-06
 **/
@Setter
@Getter
@NoArgsConstructor
public class UserInfo {

    private Long id;

    private String username;

    private String name;

    private LocalDateTime lastLoginTime;
}
