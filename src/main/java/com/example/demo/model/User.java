package com.example.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "用户信息",description = "这里包含用户的信息")
public class User implements Serializable {

    @ApiModelProperty(value = "用户名",example = "forgot2015")
    private String name;

    @ApiModelProperty(value = "用户密码",example = "123456")
    private String password;

    @ApiModelProperty(value = "年龄",example = "18")
    private Long age;

    public User(String name, String password, Long age) {
        this.name = name;
        this.password = password;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
