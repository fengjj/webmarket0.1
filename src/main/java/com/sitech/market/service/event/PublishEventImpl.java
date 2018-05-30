/**
 * PaymentBindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sitech.market.service.event;


import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.BaseClass;
import com.sitech.util.ESPUtil;
import com.sitech.util.SitechClient;
import com.sitech.util.SvcConst;

public class PublishEventImpl extends BaseClass implements  java.rmi.Remote{
    public String publish(String callMsg){
    	System.out.println("callMsg : "+callMsg);
    	String resultCode = "0";
    	String resultMsg = "发布成功";
    	try {
			Document doc = DocumentHelper.parseText(callMsg);
			String event_id = doc.selectSingleNode("/ROOT/EVENT_ID").getText();
			String login_no = doc.selectSingleNode("/ROOT/USERID").getText();
			String opt_type = doc.selectSingleNode("/ROOT/OPT_TYPE").getText();
			if(event_id==null||"".equals(event_id)){
				resultCode = "-1";
				resultMsg = "event_id 不能为空";
			}
			if(login_no==null||"".equals(login_no)){
				resultCode = "-1";
				resultMsg = "USERID 不能为空";
			}
			if(opt_type==null||"".equals(opt_type)){
				resultCode = "-1";
				resultMsg = "OPT_TYPE 不能为空";
			}
             // 调用客户群更新客户数量字段
			String optStr = "UPSERT";
			MBean bean = new MBean();
	          bean.setBody("eventId", event_id);
	          if("1".equals(opt_type)){
	        	  bean.setBody("statuscode", "04");
	          }else{
	        	  bean.setBody("statuscode", "00");
	        	  optStr = "DELETE";
	        	  resultMsg="取消发布成功";
	          }
	          
	          bean.setBody("operNo", login_no);
	          bean.setBody("operName", "fromSystem");
	          String url = SvcConst.EventSvc_publishEvent;
	          String result = SitechClient.callService(url, bean.toString());
             System.out.println("result="+result);
             MBean b = new MBean(result);
             String returnCode = b.getBodyStr("OUT_DATA.returnCode");
             if(!"0".equals(returnCode)){
            	 resultCode = returnCode;
            	 resultMsg = "事件id" + ":"+event_id+"不存在或者状态有误";
             }else{
            	 
            	 String eventType = b.getBodyStr("OUT_DATA.eventType");
            	 String custGroupId = b.getBodyStr("OUT_DATA.custGroupId");
            	 if(eventType.indexOf(",")!=-1){
            		 String[] ets = eventType.split(",");
            		 for(String et:ets){
            			 ESPUtil.publishToESPWindow(et,event_id,optStr);
            		 }
            	 }else{
            		 ESPUtil.publishToESPWindow(eventType,event_id,optStr);
            	 }
            	 
             }
			
		} catch (Exception e) {
			e.printStackTrace();
		}  
    	
    	Document document = DocumentHelper.createDocument();
    	Element root = DocumentHelper.createElement("ROOT");
        document.setRootElement(root);
        
        Element retCode = root.addElement("RETURN_CODE");
        Element returnMsg = root.addElement("RETURN_MSG");
		retCode.setText(resultCode);
        returnMsg.setText(resultMsg);
        log.info("------------reslut----------------"+root.asXML());
    	return root.asXML();
    }
    
    
}
