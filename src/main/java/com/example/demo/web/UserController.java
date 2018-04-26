package com.example.demo.web;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "/test", tags = "用户信息接口模块")
@RestController
@RequestMapping("/api")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @ApiOperation(value = "根据Id查询用户信息", notes = "根据Id查询用户信息,这里是详细说明")
    @ApiImplicitParam(name = "id", value = "用户唯一id", required = true, dataType = "Long")
    @RequestMapping(value = "/user", params = "id", method = RequestMethod.GET)
    public User getUserById(@RequestParam Long id) {
        return userService.findById(id);
    }

    @ApiOperation(value = "根据Id添加用户信息", notes = "根据Id添加用户信息,这里是详细说明")
    @ApiImplicitParam(name = "id", value = "用户唯一id", required = true, dataType = "Long")
    @RequestMapping(value = "/user", params = "id", method = RequestMethod.POST)
    public User addUser(@RequestParam Long id) {
        return userService.addUser(id);
    }
    @ApiOperation(value="用户登录", notes="用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true ,dataType = "string"),
            @ApiImplicitParam(name = "password", value = "密码", required = true ,dataType = "string")
    })
    @RequestMapping(value = "/login", params = {"username", "password"}, method = RequestMethod.GET)
    public User tryLogin(@RequestParam String username, @RequestParam String password) {
        return userService.findByUserNameAndPassword(username, password);
    }

    @ApiOperation(value = "根据Id修改用户信息", notes = "根据Id修改用户信息,这里是详细说明")
    @ApiImplicitParam(name = "id", value = "用户唯一id", required = true, dataType = "Long")
    @RequestMapping(value = "/user", params = "id", method = RequestMethod.PUT)
    public User updateUser(@RequestParam Long id) {
        return userService.updateById(id);
    }

    @ApiOperation(value = "根据Id删除用户信息", notes = "根据Id删除用户信息,这里是详细说明")
    @ApiImplicitParam(name = "id", value = "用户唯一id", required = true, dataType = "Long")
    @RequestMapping(value = "/user", params = "id", method = RequestMethod.DELETE)
    public String deleteUser(@RequestParam Long id) {
        return userService.deleteById(id);
    }
}
