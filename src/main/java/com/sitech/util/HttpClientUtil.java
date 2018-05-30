package com.sitech.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class HttpClientUtil {

	public static String inputStream2String(byte[] bs) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		baos.write(bs);
		return baos.toString("UTF-8");
	}

	/**
	 * http请求调用华为PAE服务
	 * 
	 * @param http_url
	 * @param xml
	 * @return
	 * @throws Exception
	 */
	public static String con_header_Xml(String service_name, Object obj)
			throws Exception {
		HttpClient client = new HttpClient();
		// 调用华为PAE服务
		String hw_url = PropertiesUtil.getProperty("CONFIG.properties","pae_url");
		String http_url = hw_url+service_name; 
		PostMethod postMethod = new PostMethod(http_url);
		System.out.println(http_url);
		
		//
		JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");// //编码格式
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);// 是否格式化生成的xml串
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);// 是否省略xm头声明信息
        StringWriter writer = new StringWriter();
        marshaller.marshal(obj, writer);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		postMethod.setRequestHeader("version", "1.0");
		String sourceDeviceCode = "sitech";
		String sharedSecret = "sitech12345";
		//String sharedSecret = "sitech123";
		String timeStamp = sdf.format(new Date());
		postMethod.setRequestHeader("sourceDeviceCode", sourceDeviceCode);
		String authenticatorSource = StringEncrypt.Encrypt(sourceDeviceCode
				+ sharedSecret + timeStamp, "");
		postMethod.setRequestHeader("authenticatorSource", authenticatorSource);
		postMethod.setRequestHeader("timeStamp", timeStamp);

		// 中文编码
		postMethod.getParams().setParameter(
				HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
		System.out.println(writer.toString());
		// postMethod.setRequestHeader("Content-type", "text/xml; charset=GBK");
		postMethod.setRequestBody(writer.toString());
		

		// postMethod.setRequestBody(new NameValuePair[]{name});
		// 设置成了默认的恢复策略，在发生异常时候将自动重试3次，在这里你也可以设置成自定义的恢复策略
		// postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
		// new DefaultHttpMethodRetryHandler());
		postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
				new DefaultHttpMethodRetryHandler());

		// int statusCode = httpClient.executeMethod(postMethod);
		int statusCode = client.executeMethod(postMethod);

		if (statusCode != HttpStatus.SC_OK) {
			// System.err.println("Call 4A check token method failed: " +
			// postMethod.getStatusLine());
			System.err.println("Call httpservice method failed: "+ postMethod.getStatusLine());
		}

		// String rspStr=postMethod.getResponseBodyAsString();
		String rspStr = inputStream2String(postMethod.getResponseBody());

		System.out.println(rspStr);

//		Map map = new HashMap(13);
//		try {
//			ServiceUtil.parseMap(rspStr, map);
//		} catch (BusiAppException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		return rspStr;
	}
	
	public static String request_xml(String service_name, String str)
			throws Exception {
		HttpClient client = new HttpClient();
		// 调用华为PAE服务
		String hw_url = PropertiesUtil.getProperty("CONFIG.properties","pae_url");
		String http_url = hw_url+service_name; 
		PostMethod postMethod = new PostMethod(http_url);
		System.out.println(http_url);
		
		//
//		JAXBContext context = JAXBContext.newInstance(obj.getClass());
//        Marshaller marshaller = context.createMarshaller();
//        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");// //编码格式
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);// 是否格式化生成的xml串
//        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);// 是否省略xm头声明信息
//        StringWriter writer = new StringWriter();
//        marshaller.marshal(obj, writer);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		postMethod.setRequestHeader("version", "1.0");
		String sourceDeviceCode = "sitech";
		String sharedSecret = "sitech123";
		String timeStamp = sdf.format(new Date());
		postMethod.setRequestHeader("sourceDeviceCode", sourceDeviceCode);
		String authenticatorSource = StringEncrypt.Encrypt(sourceDeviceCode
				+ sharedSecret + timeStamp, "");
		postMethod.setRequestHeader("authenticatorSource", authenticatorSource);
		postMethod.setRequestHeader("timeStamp", timeStamp);

		// 中文编码
		postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
		// postMethod.setRequestHeader("Content-type", "text/xml; charset=GBK");
		postMethod.setRequestBody(str);
		

		// postMethod.setRequestBody(new NameValuePair[]{name});
		// 设置成了默认的恢复策略，在发生异常时候将自动重试3次，在这里你也可以设置成自定义的恢复策略
		// postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
		// new DefaultHttpMethodRetryHandler());
		postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
				new DefaultHttpMethodRetryHandler());
		// int statusCode = httpClient.executeMethod(postMethod);
		int statusCode = client.executeMethod(postMethod);

		if (statusCode != HttpStatus.SC_OK) {
			// System.err.println("Call 4A check token method failed: " +
			// postMethod.getStatusLine());
			System.err.println("Call httpservice method failed: "+ postMethod.getStatusLine());
		}

		// String rspStr=postMethod.getResponseBodyAsString();
		String rspStr = inputStream2String(postMethod.getResponseBody());

		System.out.println(rspStr);

//		Map map = new HashMap(13);
//		try {
//			ServiceUtil.parseMap(rspStr, map);
//		} catch (BusiAppException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		return rspStr;
	}
	
}
