package com.sitech.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

import com.sitech.cache.Cache;
import com.sitech.cache.CacheHelper;
import com.sitech.jcfx.dt.MBean;

public class SynDealFileUtil extends Thread{
	private File file;
	private String busiId;
	@Override
	public void run(){
		long l0 = new Date().getTime();
		System.out.println("------开始处理文件--------"+file.getName());
		FileReader reader;
		BufferedReader br;
		int num = 0 ;
		try {
			reader = new FileReader(file);
			br = new BufferedReader(reader);
			String str;
			Cache c = CacheHelper.getInstance();
			
			while((str = br.readLine()) != null) {
				c.set(str+"|"+busiId,"");
				num++;
			}
			
			// 调用客户群更新客户数量字段
            MBean custGroupParaMBean = new MBean();
            custGroupParaMBean.addBody("CUST_GROUP_ID", busiId);
            custGroupParaMBean.addBody("CUST_NUM", num+"");
            System.out.println("DataInfoInvokImpl custGroupParaMBean.toString()" + custGroupParaMBean.toString());
            String result=SitechClient.callService(SvcConst.AtomCustGroupSvc_updateCustGroupInfo, custGroupParaMBean.toString());
            System.out.println("result="+result);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		long l1 = new Date().getTime();
		System.out.println("------处理文件 结束--------used time is:"+(l1-l0)+"毫秒:"+file.getName());
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getBusiId() {
		return busiId;
	}
	public void setBusiId(String busiId) {
		this.busiId = busiId;
	}
	
	
	
}