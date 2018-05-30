package com.sitech.market.service.taginfo;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.sitech.util.WebServiceCallUtil;

public class TestClient {

	public static void main(String[] a) throws Exception{
		
		
		/*//String url = "http://127.0.0.1:8080/appmarket/services/PublishEvent?wsdl";
    	//String url = "http://132.121.86.100:21099/appmarket/services/PublishEvent?wsdl";
		//String url = "http://132.121.86.58:21099/appmarket/services/PublishEvent?wsdl";
		
    	//String url = "http://132.120.115.23:7008/salemanm/services/DcEventSyncInterface";
    	//String url = "http://132.120.115.23:7008/salemanm/services/DcLoginCheckInterface";
    	//String url = "http://132.120.115.22:7001/salemanm/services/DcLoginCheckInterface";
    	String url = "http://132.120.115.22:7001/salemanm/services/DcEventSyncInterface";
    	String wsdl = "http://www.forgetme.cn";
    	//String name = "publish";
    	String name = "getReader";
    	Document doc = DocumentHelper.createDocument();
    	
    	
    	Element root = doc.addElement("ROOT");
    	Element e = root.addElement("EVENT_ID");
    	Element u = root.addElement("USERID");
    	Element o = root.addElement("OPT_TYPE");
    	Element o1 = root.addElement("OPT_TIME");
    	u.setText("HZSYX001");
    	e.setText("109400041");
    	o.setText("1");
    	o1.setText("20160704143441");
    	Element root = doc.addElement("USERINFOREQUEST");
    	Element e = root.addElement("MSGHEADER");
    	
    	Element u = e.addElement("SESSIONID");
    	u.setText("20160527215987654987");
    	Element u1 = e.addElement("STAFFID");
    	u1.setText("gz_admin");
    	Element u2 = e.addElement("EPARCHYCODE");
    	u2.setText("0020");
    	Element u3 = e.addElement("RANDOMNUMBER");
    	u3.setText("33334567898rsazxf");
    	
    	String res = WebServiceCallUtil.call(url, wsdl, name, doc.asXML());
    	System.out.println("result:"+res);*/
    	
		
		sysEvent();
    }
	public static void sysEvent() throws Exception{
		String url = "http://132.120.115.22:7001/salemanm/services/DcEventSyncInterface";//广东正式
		//String url = "http://132.120.115.156:7001/salemanm/services/DcEventSyncInterface";//广西正式
    	String wsdl = "http://www.forgetme.cn";
    	//String name = "publish";
    	String name = "getReader";
		Document doc = DocumentHelper.createDocument();
  		Element root0 = doc.addElement("USERINFOREQUEST");
  		Element root = root0.addElement("MSGHEADER");
  		Element esession = root.addElement("SESSIONID");//
  		Element etype = root.addElement("DCEVENTTYPE");//事件类型：即活动大类编码
  		Element eid = root.addElement("DCEVENTID");//
  		Element ename = root.addElement("DCEVENTNAME");//
  		Element etarget = root.addElement("DCEVENTTAG");//即指标代码
  		Element estatus = root.addElement("DCEVENTSTATE");//事件状态。0：有效；1：失效
  		Element estart = root.addElement("STARTDATE");//
  		Element eend = root.addElement("ENDDATE");//
  		Element earea = root.addElement("EPARCHYCODE");//地市
  		Element edesc = root.addElement("REMARK");//备注信息
  		Element eformatid = root.addElement("FORMATID");//消息格式编码
  		String eventId = "110700900";
  		String eventname = "流量1-流量剩余10%";
  		String targetValue = "L681";
  		esession.setText("20170731174400654910");
  		eid.setText(eventId);
  		ename.setText(eventname);
  		edesc.setText(eventname);
  		etarget.setText(targetValue);
  		
  		earea.setText("000");
  		//dpi 10317;位置：10315；流量月：720
  		etype.setText("720");
  		//dpi类：d06；流量按月l720_2
		eformatid.setText("l720_2");
  		//事件状态。0：有效；1：失效
  		estatus.setText("0");
  		estart.setText("20170801");
  		eend.setText("20181231");
  		
  		String res = WebServiceCallUtil.call(url, wsdl, name, doc.asXML());
    	System.out.println("result:"+res);
	}
}
