package com.sitech.market.dbo.destribution.impl;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.log4j.Logger;
import org.dom4j.DocumentException;

import com.sitech.crmpd.core.exception.BusiAppException;
import com.sitech.crmpd.core.service.impl.ServiceUtil;
import com.sitech.crmpd.core.xml.IXMLReader;
import com.sitech.crmpd.core.xml.impl.StAXReaderFactory;
import com.sitech.crmpd.core.xml.impl.Unmarshalling;
import com.sitech.market.busiobject.basicclass.dbclass.DBServiceClass;
import com.sitech.market.dbo.destribution.inter.IPublishDBO;
import com.sitech.util.PropertiesUtil;

public class PublishDBO extends DBServiceClass implements IPublishDBO {

	String NAMESPACE_SITECH = PropertiesUtil.getProperty("CONFIG.properties", "ESBNAMESPACE");

    public String prePublish(Map bean) {
     String orderId = (String) bean.get("orderId");
     String result = getResultDocument("PReleaseService","callService","keycode",orderId);
     log.debug("prePublish---------PReleaseService------"+result);
     return result;
    }
    
    public String publish(Map bean) {
     String orderId = (String) bean.get("orderId");
     String result = getResultDocument("ReleaseService","callService","keycode",orderId);
     log.debug("publish---------ReleaseService------"+result);
     return result;
    }
    
    public String getConfigStatus(Map bean) {
     String opId = (String) bean.get("opId");
     String result = getResultDocument("ProdStatService","callService","pin",opId);
     log.debug("publish---------ProdStatService------"+result);
     return result;
    }
    public String tellUnline(Map bean) {
     String param = (String) bean.get("param");
     String result = getResultDocument("UnlineService","callService","keycode",param);
     log.debug("publish---------UnlineService------"+result);
     return result;
    }
     /** 
       * 应用document方式调用 
       * serviceName:服务名
       * method:方法名
       * param：入参参数名
       * paramValue:参数值
     * @throws DocumentException 
     * @throws BusiAppException 
       */  
      public String  getResultDocument(String serviceName,String meth,String param,String paramValue){  
        try {  
          String url = PropertiesUtil.getProperty("CONFIG.properties", "ESBURL_")+serviceName+"?wsdl";  
          Options options = new Options();  
          // 指定调用WebService的URL  
          EndpointReference targetEPR = new EndpointReference(url);  
          options.setTo(targetEPR);  
      
          ServiceClient sender = new ServiceClient();  
          sender.setOptions(options);  
            
          OMFactory fac = OMAbstractFactory.getOMFactory();  
          // 命名空间，有时命名空间不增加没事，不过最好加上，因为有时有事，你懂的  
          OMNamespace omNs = fac.createOMNamespace(NAMESPACE_SITECH, "ns");  
      
          OMElement method = fac.createOMElement(meth, omNs);  
          OMElement value = fac.createOMElement(param, omNs, method);
          value.setText(paramValue);
          method.addChild(value);  
          method.build();  

          String result = sender.sendReceive(method).toString();
          log.debug(result);
          IXMLReader xmlReader = null;
          try {
      xmlReader = StAXReaderFactory.getInstance().createReader(new StringReader(result));
     } catch (BusiAppException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
     }
          Unmarshalling context = new Unmarshalling(xmlReader);
          Map map = new HashMap();
          try {
      context.parseXML(map);
     } catch (BusiAppException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
     }
      Iterator<String> it = map.keySet().iterator();
         String resultStr ="";  
         while(it.hasNext()){
           resultStr = map.get(it.next()).toString();
          }
          return resultStr;
        } catch (AxisFault axisFault) {  
          axisFault.printStackTrace();  
        }
        return "";
   }

}
