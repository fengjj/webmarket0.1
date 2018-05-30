package com.sitech.util;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;

public class WebServiceCallUtil {

	/**
	 * 
	 * @param url 请求地址
	 * @param wsdl 命名空间
	 * @param name 方法名
	 * @param content 请求报文
	 * @return
	 * @throws Exception
	 */
	public static String call(String url,String wsdl, String name, String content)throws Exception {
		Service service = new Service();
		System.out.println("请求的报文:" + content);
		Call call = (Call) service.createCall();
		call.setTargetEndpointAddress(new URL(url));
		call.setOperationName(new QName(wsdl, name));
		call.setUseSOAPAction(true);
		call.setTimeout(new Integer(600000));
		call.addParameter("arg0", XMLType.XSD_STRING, ParameterMode.IN);
		call.setReturnType(XMLType.XSD_STRING);
		String result = (String) call.invoke(new Object[]{content});
		System.out.println("返回的报文 : " + result);
		return result;
	}
	
}
