package com.lanpang.webservice;

import com.lanpang.client.com.lanpang.webservice.TestService;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * webservice客户端：
 *  该类提供两种不同的方式来调用webservice服务
 *  1：代理工厂方式
 *  2：动态调用webservice
 */
public class TestServiceTest {

    /**
     * 1.代理类工厂的方式,需要拿到对方的接口地址
     */
    @Test
    public void test() {
        try {
            // 接口地址
            String address = "http://localhost:8080/services/TestService?wsdl";
            // 代理工厂
            JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
            // 设置代理地址
            jaxWsProxyFactoryBean.setAddress(address);
            // 设置接口类型
            jaxWsProxyFactoryBean.setServiceClass(TestService.class);
            // 创建一个代理接口实现
            TestService us = (TestService) jaxWsProxyFactoryBean.create();
            // 数据准备
            String username = "蓝胖子";
            // 调用代理接口的方法调用并返回结果
            String result = us.sendMessage(username);
            System.out.println("返回结果:" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 2：动态调用
     */
    @Test
    public void testSend1(){
        // 创建动态客户端
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://localhost:8080/soap/TestService?wsdl");
        // 需要密码的情况需要加上用户名和密码
        // client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME,PASS_WORD));
        Object[] objects = new Object[0];
        try {
            // invoke("方法名",参数1,参数2,参数3....);
            objects = client.invoke("sendMessage", "蓝胖子");
            System.out.println("返回数据:" + objects[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}