
package cn.com.webxml;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WeatherWebServiceSoap", targetNamespace = "http://WebXml.com.cn/")
@XmlSeeAlso({
    cn.com.webxml.ObjectFactory.class
})
public interface WeatherWebServiceSoap {


    /**
     * <br /><h3>��ѯ������Ԥ��Web Services֧�ֵĹ�������л������Ϣ</h3><p>���������byProvinceName = ָ�����޻���ڵ�ʡ�ݣ���ΪALL������ʾ����ȫ�����У��������ݣ�һ��һά�ַ������� String()���ṹΪ����������(���д���)��</p><br />
     * 
     * @param byProvinceName
     * @return
     *     returns cn.com.webxml.ArrayOfString
     */
    @WebMethod(action = "http://WebXml.com.cn/getSupportCity")
    @WebResult(name = "getSupportCityResult", targetNamespace = "http://WebXml.com.cn/")
    @RequestWrapper(localName = "getSupportCity", targetNamespace = "http://WebXml.com.cn/", className = "cn.com.webxml.GetSupportCity")
    @ResponseWrapper(localName = "getSupportCityResponse", targetNamespace = "http://WebXml.com.cn/", className = "cn.com.webxml.GetSupportCityResponse")
    public cn.com.webxml.ArrayOfString getSupportCity(
        @WebParam(name = "byProvinceName", targetNamespace = "http://WebXml.com.cn/")
        String byProvinceName);

    /**
     * <br /><h3>��ñ�����Ԥ��Web Services֧�ֵ��ޡ�������ʡ�ݺͳ�����Ϣ</h3><p>����������ޣ� �������ݣ�һ��һά�ַ������� String()������Ϊ�޻����ʡ�ݵ����ơ�</p><br />
     * 
     * @return
     *     returns cn.com.webxml.ArrayOfString
     */
    @WebMethod(action = "http://WebXml.com.cn/getSupportProvince")
    @WebResult(name = "getSupportProvinceResult", targetNamespace = "http://WebXml.com.cn/")
    @RequestWrapper(localName = "getSupportProvince", targetNamespace = "http://WebXml.com.cn/", className = "cn.com.webxml.GetSupportProvince")
    @ResponseWrapper(localName = "getSupportProvinceResponse", targetNamespace = "http://WebXml.com.cn/", className = "cn.com.webxml.GetSupportProvinceResponse")
    public cn.com.webxml.ArrayOfString getSupportProvince();

    /**
     * <br><h3>��ñ�����Ԥ��Web Services֧�ֵ��ޡ�������ʡ�ݺͳ�����Ϣ</h3><p>����������ޣ����أ�DataSet ��DataSet.Tables(0) Ϊ֧�ֵ��޺͹���ʡ�����ݣ�DataSet.Tables(1) Ϊ֧�ֵĹ�������л�������ݡ�DataSet.Tables(0).Rows(i).Item("ID") ������Ӧ DataSet.Tables(1).Rows(i).Item("ZoneID") �����<br />Tables(0)��ID = ID������Zone = ֧�ֵ��ޡ�ʡ�ݣ�Tables(1)��ID ������ZoneID = ��ӦTables(0)ID�������Area = ���л������AreaCode = ���л�������롣</p><br />
     * 
     * @return
     *     returns cn.com.webxml.GetSupportDataSetResponse.GetSupportDataSetResult
     */
    @WebMethod(action = "http://WebXml.com.cn/getSupportDataSet")
    @WebResult(name = "getSupportDataSetResult", targetNamespace = "http://WebXml.com.cn/")
    @RequestWrapper(localName = "getSupportDataSet", targetNamespace = "http://WebXml.com.cn/", className = "cn.com.webxml.GetSupportDataSet")
    @ResponseWrapper(localName = "getSupportDataSetResponse", targetNamespace = "http://WebXml.com.cn/", className = "cn.com.webxml.GetSupportDataSetResponse")
    public cn.com.webxml.GetSupportDataSetResponse.GetSupportDataSetResult getSupportDataSet();

    /**
     * <br><h3>���ݳ��л�������Ʋ�ѯ���δ��������������������ڵ�����ʵ��������������ָ��</h3><p>���÷������£����������theCityName = ������������(������п���Ӣ��)����д���(������Ĭ��Ϊ�Ϻ���)���磺�Ϻ� �� 58367�����г��������ظ���ʹ�ó��д����ѯ(��ͨ�� getSupportCity �� getSupportDataSet ���)���������ݣ� һ��һά���� String(22)������23��Ԫ�ء�<br />String(0) �� String(4)��ʡ�ݣ����У����д��룬����ͼƬ���ƣ�������ʱ�䡣String(5) �� String(11)������� ���£��ſ�������ͷ������������ƿ�ʼͼƬ����(���³ƣ�ͼ��һ)���������ƽ���ͼƬ����(���³ƣ�ͼ���)�����ڵ�����ʵ��������������ָ����String(12) �� String(16)���ڶ���� ���£��ſ�������ͷ�����ͼ��һ��ͼ�����String(17) �� String(21)��������� ���£��ſ�������ͷ�����ͼ��һ��ͼ�����String(22) ����ѯ�ĳ��л�����Ľ��� <br /><a href="http://www.webxml.com.cn/images/weather.zip">��������ͼ��<img src="http://www.webxml.com.cn/images/download_w.gif" border="0" align="absbottom" /></a>(�������С�С�ߴ�) <a href="http://www.webxml.com.cn/zh_cn/weather_icon.aspx" target="_blank">����ͼ��˵��</a> <a href="http://www.webxml.com.cn/files/weather_eg.zip">���ô�����Ԥ��Web Servicesʵ������</a> (VB ASP.net 2.0)</p><br />
     * 
     * @param theCityName
     * @return
     *     returns cn.com.webxml.ArrayOfString
     */
    @WebMethod(action = "http://WebXml.com.cn/getWeatherbyCityName")
    @WebResult(name = "getWeatherbyCityNameResult", targetNamespace = "http://WebXml.com.cn/")
    @RequestWrapper(localName = "getWeatherbyCityName", targetNamespace = "http://WebXml.com.cn/", className = "cn.com.webxml.GetWeatherbyCityName")
    @ResponseWrapper(localName = "getWeatherbyCityNameResponse", targetNamespace = "http://WebXml.com.cn/", className = "cn.com.webxml.GetWeatherbyCityNameResponse")
    public cn.com.webxml.ArrayOfString getWeatherbyCityName(
        @WebParam(name = "theCityName", targetNamespace = "http://WebXml.com.cn/")
        String theCityName);

    /**
     * <br><h3>���ݳ��л�������Ʋ�ѯ���δ��������������������ڵ�����ʵ��������������ָ����For��ҵ�û���</h3><p>���÷���ͬ getWeatherbyCityName�����������theUserID = ��ҵ�û�ID</p><br />
     * 
     * @param theCityName
     * @param theUserID
     * @return
     *     returns cn.com.webxml.ArrayOfString
     */
    @WebMethod(action = "http://WebXml.com.cn/getWeatherbyCityNamePro")
    @WebResult(name = "getWeatherbyCityNameProResult", targetNamespace = "http://WebXml.com.cn/")
    @RequestWrapper(localName = "getWeatherbyCityNamePro", targetNamespace = "http://WebXml.com.cn/", className = "cn.com.webxml.GetWeatherbyCityNamePro")
    @ResponseWrapper(localName = "getWeatherbyCityNameProResponse", targetNamespace = "http://WebXml.com.cn/", className = "cn.com.webxml.GetWeatherbyCityNameProResponse")
    public cn.com.webxml.ArrayOfString getWeatherbyCityNamePro(
        @WebParam(name = "theCityName", targetNamespace = "http://WebXml.com.cn/")
        String theCityName,
        @WebParam(name = "theUserID", targetNamespace = "http://WebXml.com.cn/")
        String theUserID);

}
