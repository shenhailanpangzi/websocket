package com.lanpang.thirdparty;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Test;

import java.util.List;

/**
 * @program: websocket
 * @description: 测试类
 * @author: yanghao
 * @create: 2018-10-25 15:25
 **/
public class Test1 {

    @Test
    public void test(){
        // 接口地址
        String address = "http://www.webxml.com.cn/WebServices/WeatherWebService.asmx?wsdl";
        // 代理工厂
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        // 设置代理地址
        jaxWsProxyFactoryBean.setAddress(address);
        // 设置接口类型
        jaxWsProxyFactoryBean.setServiceClass(cn.com.webxml.WeatherWebServiceSoap.class);
        // 创建一个代理接口实现
        cn.com.webxml.WeatherWebServiceSoap us = (cn.com.webxml.WeatherWebServiceSoap) jaxWsProxyFactoryBean.create();
        // 数据准备
        String byProvinceName = "山西";
        // 调用代理接口的方法调用并返回结果
        cn.com.webxml.ArrayOfString result = us.getSupportCity (byProvinceName);
        System.out.println("返回结果:" + result);
        List<String> resultString = result.getString();
        //遍历天气预报信息
        for (String string : resultString) {
            System.out.println(string);
            System.out.println("------------------------");
        }
    }
}
