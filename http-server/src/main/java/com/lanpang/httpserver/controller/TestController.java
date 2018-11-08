package com.lanpang.httpserver.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: websocket
 * @description:
 * @author: yanghao
 * @create: 2018-10-25 16:10
 **/
@RestController
public class TestController {

    @ApiOperation(value = "根据id查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", dataType = "String", name = "String", value = "请求参数", required = true)})
    @PostMapping("/restFul/finduserbyname")
    public User findUserByName(@RequestParam("name") String name) throws Exception{
        return new User("蓝胖子",18);
    }
    @AllArgsConstructor
    @Data
    @ToString
    class User{
        private String name;
        private Integer age;
    }
}
