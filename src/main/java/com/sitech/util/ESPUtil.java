package com.sitech.util;

import java.io.*;


/**
 * 
 *@Title:DateUtil
 *@Description: 日期，时间相关工具类
 *@Author:wangwga
 *@Since:Oct 13, 2011
 *@Version:1.1.0
 */
public class ESPUtil {
    /** 日期斜线分隔符*/
	//"/data/eventapp4/locationevent/bin/startweb.sh";
    public static final String shell_path = PropertiesUtil.getProperty("CONFIG.properties", "publish_ESP_shell");
    
    /**
     * 用脚本加载阀值到esp
     * opt:UPSERT, DELETE
     * @param eventType
     * 04:流量累计
     * 06：dpi上网内容
     * 11：位置
     * 12：余额
     * @return 
     */
    public static String publishToESPWindow(String eventType,String eventId,String opt){

    	System.out.println("eventType:"+eventType);
    	String[] types = eventType.split(",");
    	for(String type:types){
    		String shellName="";
    		if("04".equals(type)){
    			shellName = "PublisherCommonThresholdData";
    		} else if("06".equals(type)){
    			shellName = "PublisherToDpiESPWindow";
    		} else if("11".equals(type)){
    			shellName = "PublisherToESPWindow";
    		} else {
    			System.out.println("error param eventType"+type);
    			continue;
    		}
    		
    		try {
    			String comond = shell_path+" "+shellName+" "+eventId+" "+opt;
    			System.out.println("run Process:"+comond);
    			Process process = Runtime.getRuntime().exec(comond);
    			process.waitFor();
    			
    			InputStream in = process.getInputStream();
    			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
    			int ch = 0;
    			while ((ch = reader.read()) != -1) { // 不用readLine是为了防止print没有回车的输出
    				System.out.print((char) (ch));
    			}
    			System.out.println("Process end."+comond);
    			// 当读取到-1时，说明proc已经结束，所以本程序也应该结束了(或者结束输出线程)
    			// System.exit(0); 
    		} catch (IOException | InterruptedException e) {
    			e.printStackTrace();
    		}
    	}
        //TODO 如果不是全网，要加载目标客户群
        
        return "success";
    }
   
}
