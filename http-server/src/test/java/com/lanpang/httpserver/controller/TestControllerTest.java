package com.lanpang.httpserver.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lanpang.httpserver.utils.HttpUtil;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.junit.Assert.*;

public class TestControllerTest {

    @Test
    public void findUserByName() {
        String url="http://localhost:8080/restFul/finduserbyname";
        HttpUtil httpUtil = HttpUtil.getInstance();
        String str=httpUtil.sendHttpPost(url,"name","String");
        System.out.println(str);
    }
}