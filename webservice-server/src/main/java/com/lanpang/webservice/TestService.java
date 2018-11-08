package com.lanpang.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(name = "TestService", // 暴露服务名称
        targetNamespace = "http://webservice.lanpang.com"// 命名空间,一般是接口的包名倒序
)
public interface TestService {

    @WebMethod//标注该方法为webservice暴露的方法,用于向外公布，它修饰的方法是webservice方法，去掉也没影响的，类似一个注释信息。
    @WebResult(name = "String")//注释用于定制从返回值至 WSDL 部件或 XML 元素的映射。

    String sendMessage(@WebParam(name = "username") String username);
}
