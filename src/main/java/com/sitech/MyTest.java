package com.sitech;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.eclipse.jetty.http.security.Credential.MD5;

public class MyTest {
	/*public static final String DATA_ENDPOINT = "http://132.121.85.7:8901/dataService/services/DataInfoImpl?wsdl";
	public static final String DATA_ENDPOINT1 = "http://132.121.85.7:8901/dataService/services/METAINFOREQUEST?wsdl";
	public static final String DATA_WSDL = "http://webservice.dataservice.dic.tydic.com/";
	public static final String DATA_WSDLNAME = "getDataInfo";*/
	// public static final String DATA_ENDPOINT = "http://127.0.0.1:8080/appmarket/services/DataInfoInvok?wsdl";
	public static final String DATA_ENDPOINT = "http://132.121.86.58:21099/appmarket/services/DataInfoInvok?wsdl";
	public static final String DATA_WSDL = "http://schemas.xmlsoap.org/wsdl/";
	public static final String DATA_WSDLNAME = "notify";

	public static void main1(String[] args) throws Exception {
		Document doc = DocumentHelper.createDocument(DocumentHelper.createElement("USERINFORESPONSE"));
		Element msgHead = doc.getRootElement().addElement("MSGHEADER");
		Element msgBody = doc.getRootElement().addElement("MSGBODY");
		msgHead.addElement("SESSIONID").addText("20140924000001221");
		msgHead.addElement("USERNAME").addText("root");
		msgHead.addElement("PASSWORD").addText("e10adc3949ba59");
		msgHead.addElement("MSGTYPE").addText("1");
		msgHead.addElement("VERSION").addText("10");
		msgHead.addElement("TRANSMISSION").addText("1");
		msgHead.addElement("FETCHTYPE").addText("1");
		msgBody.addElement("TYPE").addText("0");
		msgBody.addElement("DATALIST").addText("");//手机号码
		msgBody.addElement("CONDITIONLIST").addElement("CONDITION").addText("");//查询条件
		
		System.out.println(doc.asXML());
		
	}
/*	public static void main(String[] a){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date d1;
		try {
			d1 = sdf.parse("20160301");
			Date d2 = sdf.parse("20161230");
			System.out.println(d1);
			System.out.println(d1.getTime());
			long l = d2.getTime()-d1.getTime();
			l = l/1000/3600/24;
			System.out.println(l);
			System.out.println(l*5/7);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
public static void main(String[] args) throws Exception {
		Service service = new Service();
		SAXReader sr = new SAXReader();
		String dataxml = "D:\\temp\\test1.xml";//开发本地路径
		//String dataxml = "D:\\fileinfo.xml";//开发本地路径
		// String dataxml1 = "D:\\qushu1.xml";//开发本地路径
		Document doc = sr.read(dataxml);
		System.out.println(doc.getText());
		String xml = doc.asXML();
		long bi=System.currentTimeMillis();
		System.out.println("请求的报文:" + xml);
		Call call = (Call) service.createCall();
		call.setTargetEndpointAddress(new URL(DATA_ENDPOINT));
		call.setOperationName(new QName(DATA_WSDL, DATA_WSDLNAME));
		call.setUseSOAPAction(true);
		call.setTimeout(new Integer(600000));
		call.addParameter("arg0", XMLType.XSD_STRING, ParameterMode.IN);
		System.out.println(call.getEncodingStyle());
		call.setReturnType(XMLType.XSD_STRING);
		String result = (String) call.invoke(new Object[]{xml});
		System.out.println("返回的报文 : " + result);
		long eg=System.currentTimeMillis();
		System.out.println("use time : "+(eg-bi)+" ms");
	}
}
