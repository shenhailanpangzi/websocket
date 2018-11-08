package com.lanpang.webservice.impl;

import com.lanpang.webservice.TestService;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * @program: websocket
 * @description:
 * @author: yanghao
 * @create: 2018-10-25 14:08
 **/
@WebService(serviceName = "TestService", // 与接口中指定的name一致 对外发布的服务名
        targetNamespace = "http://webservice.lanpang.com", // 与接口中的命名空间一致,一般是接口的包名倒
        endpointInterface = "com.lanpang.webservice.TestService"// 接口地址 服务接口全路径, 指定做SEI（Service EndPoint Interface）服务端点接口
)
@Component
public class TestServiceImpl implements TestService {

    @Override
    public String sendMessage(String username) {

        return "hello~~~"+username;
    }

}