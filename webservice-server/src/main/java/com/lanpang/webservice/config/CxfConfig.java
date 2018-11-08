package com.lanpang.webservice.config;

import com.lanpang.webservice.TestService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * @program: websocket
 * @description:cxf发布webservice配置
 * @author: yanghao
 * @create: 2018-10-25 14:10
 **/
@Configuration
public class CxfConfig {

    @Autowired
    private Bus bus;

    @Autowired
    private TestService testService;

    @Bean
    public Endpoint endpoint(){
        EndpointImpl endpoint = new EndpointImpl(bus, testService);
//     将TestService接口发布在了路径/services/TestService下,wsdl文档路径为，http://localhost:8080/services/TestService?wsdl
        endpoint.publish("/TestService");
        return endpoint;
    }

    /**
     * 此方法作用是改变项目中服务名的前缀名，此处127.0.0.1或者localhost不能访问时，请使用ipconfig查看本机ip来访问
     * 此方法被注释后:wsdl访问地址为http://127.0.0.1:8080/services/TestService?wsdl
     * 去掉注释后：wsdl访问地址为：http://127.0.0.1:8080/soap/TestService?wsdl
     * @return
     */
//    @SuppressWarnings("all")
//    @Bean
//    public ServletRegistrationBean dispatcherServlet() {
//        return new ServletRegistrationBean(new CXFServlet(), "/soap/*");
//    }

}