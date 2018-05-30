/**
 * PaymentBindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sitech.market.service.taginfo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;

import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.BaseClass;
import com.sitech.util.PropertiesUtil;
import com.sitech.util.SitechClient;
import com.sitech.util.SvcConst;

public class DataInfoInvokImpl extends BaseClass implements  java.rmi.Remote{
    public String notify(String callMsg){
    	System.out.println("callMsg : "+callMsg);
    	try {
			Document doc = DocumentHelper.parseText(callMsg);
			String custGroupId = doc.selectSingleNode("/NOTICEREQUEST/MSGHEADER/SESSIONID").getText();
			String custNum = doc.selectSingleNode("/NOTICEREQUEST/MSGHEADER/RESULTCOUNT").getText();
			String path = doc.selectSingleNode("/NOTICEREQUEST/MSGBODY/RETFILEINFO/RETFILEPATH").getText();
			String filePath = path.substring(0,path.lastIndexOf("/")+1);
			String fileName = path.substring(path.lastIndexOf("/")+1);
			System.out.println(custGroupId+"::::"+fileName+"::::::"+filePath+" "+filePath);
			
			String shellPath = PropertiesUtil.getProperty("CONFIG.properties", "get_cust_group.sh");
			String shell = "sh "+shellPath+"get_cust_group.sh "+filePath+" "+fileName+" "+custGroupId+".txt";
			System.out.println("shell : " + shell);
			
			//执行Shell命令   取文件
			 final Process pid = Runtime.getRuntime().exec(shell);
			 InputStream in = pid.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(in));

             try {
                 int ch = 0;
                 while ((ch = reader.read()) != -1) { // 不用readLine是为了防止print没有回车的输出
                     System.out.print((char) (ch));
                 }
                 System.out.println("Process end.");
                 // 当读取到-1时，说明proc已经结束，所以本程序也应该结束了(或者结束输出线程)
                // System.exit(0); 
             } catch (IOException e) {
                 e.printStackTrace();
             }
             // 调用客户群更新客户数量字段
             MBean custGroupParaMBean = new MBean();
             custGroupParaMBean.addBody("CUST_GROUP_ID", custGroupId);
             custGroupParaMBean.addBody("CUST_NUM", custNum);
             System.out.println("DataInfoInvokImpl custGroupParaMBean.toString()" + custGroupParaMBean.toString());
             String result=SitechClient.callService(SvcConst.AtomCustGroupSvc_updateCustGroupInfo, custGroupParaMBean.toString());
             System.out.println("result="+result);
			/*new Thread() {
	            public void run() {
	                InputStream in = pid.getInputStream();
	                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	 
	                try {
	                    int ch = 0;
	                    while ((ch = reader.read()) != -1) { // 不用readLine是为了防止print没有回车的输出
	                        System.out.print((char) (ch));
	                    }
	                    System.out.println("Process end.");
	                    // 当读取到-1时，说明proc已经结束，所以本程序也应该结束了(或者结束输出线程)
	                    System.exit(0); 
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }.start();
				if (pid != null) {  
		    	pid.waitFor();  
		    	}*/
				
		} catch (Exception e) {
			e.printStackTrace();
		}  
    	
        return "hello";
    }
}
