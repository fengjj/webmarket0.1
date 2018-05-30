package com.sitech.market.atom.destribution.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sitech.jcf.core.dao.IBaseDao;
import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.util.CassandraUtil;
import com.sitech.util.ConfigBeanFactory;

/**
 * Create on 2015-6-10
 * @author: liuhaoa
 * @Title: ImportCustGroupInfo
 * @Description：客户群号码导入
 * @version 1.0  
 * update_data:     update_author:     update_note:
 */
@SuppressWarnings("all")
public class ImportCustGroupInfo extends DBMysqlClass {
	
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	String datetime = simpleDateFormat.format(new Date());
	private String filePath = "/app/mysql/mktapp/applications/appmarket/upload/" + datetime.split("-")[0] + "/" + datetime.split("-")[1] + "/" + datetime.split("-")[2];
	private CassandraUtil cassandraUtil = (CassandraUtil) ConfigBeanFactory.getBean("cassandraUtil");
	private IBaseDao baseDao;
	
	public void setBaseDao(IBaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public void run(){
		int allcount = 0;
		String cust_type = "";			//客户类型 0、运营商同网  1、与运营商异网
		String custGroupId = "";		//客户群ID
		boolean bool = false;			//判断是否需要修改mysql中的目标客户群表
		try{
			System.out.println("=======================开始处理====================" + cassandraUtil);
			System.out.println("=======================开始处理====================" + filePath);
			File dir = new File(filePath);
			File[] files = dir.listFiles(new FilenameFilter(){
				public boolean accept(File dir,String name){
					System.out.println(dir.getName() + "==========内部=============" + name);
					if(name.toLowerCase().endsWith(".tmp")){
						return true;
					}else{
						System.out.println("==========内部=============");
						return false;
					}
				}
			});
			System.out.println(files + "====================files==================");
			if(files != null && files.length > 0){
				System.out.println(files.length + "=============files.length=================");
				for(int i = 0; i < files.length; i++){
					List<Map<String, Object>> myParamList = new ArrayList<Map<String, Object>>();
					List<Map<String, Map<String, Object>>> noParamList = null;
					Map<String, Map<String, Object>> rowKey = new HashMap<String, Map<String, Object>>();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");			//操作时间日期格式
					String operTime = sdf.format(new Date());
					String fileName = files[i].getName();
					System.out.println("=======================开始处理文件：" + fileName);
					Map map = new HashMap();
					map.put("systemName", fileName);
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~map~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+map);
					List<Map> attachList = baseDao.queryForList("MkAttachInfo.selectMkAttachInfo", map);
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~attachList~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+attachList.size());
					if(attachList != null && attachList.size() > 0){
						Map attachMap = attachList.get(0);
						Map inMap = new HashMap();
					    inMap.put("attachId", attachMap.get("attachId"));
						List<Map> busiattachList = baseDao.queryForList("MkBusiattachRel.selectMkBusiattachRel", inMap);
						if(busiattachList != null && busiattachList.size() > 0){
							Map busiattachMap = busiattachList.get(0);
							custGroupId = busiattachMap.get("busiId") + "";
							List<Map> custList = baseDao.queryForList("MkCustgroupInfo.selectMkCustgroupInfoById", custGroupId);
							if(custList != null && custList.size() > 0){
								Map custMap = custList.get(0);
								cust_type = custMap.get("custType") + "";
							}
						}
					}
					if(cust_type != null && !"".equals(cust_type)){
						BufferedReader reader = new BufferedReader(new FileReader(filePath + "/" + fileName), 5 * 1024 * 1024);
						String tempString = null;
						int line = 0;
						String idNos = "";
						//导入客户明细
						int count = 0;
						noParamList = new ArrayList<Map<String, Map<String, Object>>>();
						while((tempString = reader.readLine()) != null && !"".equals(tempString)){
							Map myMap = new HashMap();
							Map noColumn = new HashMap(); 
							String temp = tempString;
							String idNo = temp;
							String phoneNo = temp;
							myMap.put("phone_no", phoneNo);
							myParamList.add(myMap);
							noColumn.put("phone_no", phoneNo);
							StringBuffer sb = new StringBuffer();
							sb.append(idNo);
							rowKey.put(sb.toString(), noColumn);
							noParamList.add(rowKey);
							if(myParamList.size()%100 == 0){
								noParamList = new ArrayList<Map<String, Map<String, Object>>>();
								noParamList.add(rowKey);
								myParamList = new ArrayList<Map<String, Object>>();
								//noParamList.add(rowKey);
								count++;
							}else{
								count++;
							}
							
							if(count == 100){
								if("0".equals(cust_type)){
									cassandraUtil.insertMultiCloumAndRows("mk_actcust_info", noParamList);
								}
								if("1".equals(cust_type)){
									cassandraUtil.insertMultiCloumAndRows("mk_custphone_info", noParamList);
								}
								noParamList = new ArrayList<Map<String, Map<String, Object>>>();
								rowKey = new HashMap<String, Map<String, Object>>();
								count = 0;
							}
							allcount++;
						}
						System.out.println("-------myParamList.size()--------------------"+myParamList.size()+"\t"+count+"\t"+noParamList.size());
						if(count > 0){
							if("0".equals(cust_type)){
								cassandraUtil.insertMultiCloumAndRows("mk_actcust_info", noParamList);
							}
							if("1".equals(cust_type)){
								cassandraUtil.insertMultiCloumAndRows("mk_custphone_info", noParamList);
							}
							System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+allcount);
						}
						File file = new File(filePath + "/" + fileName);
						bool = file.delete();
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~文件删除是否成功~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+bool);
						if(bool){
							Map inParam = new HashMap();
							inParam.put("custGroupId", custGroupId);
							inParam.put("custNum", allcount);
							baseDao.update("MkCustgroupInfo.updateMkCustgroupInfoById", inParam);
							bool = false;
						}
						reader.close();
						System.out.println("=======================================完成========");
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static String getXmlPath(){
		String path = "/shell/beanContext.xml";
		path = "/springConfig/beanContext.xml";
		System.out.println("===================path======================"+path);
		return path;
	}
	
	public static void main(String[] args){
		ClassPathXmlApplicationContext c = new ClassPathXmlApplicationContext(new String[] {getXmlPath()});
		ImportCustGroupInfo i = (ImportCustGroupInfo)c.getBean("ImportCustGroupInfo");
		i.run();
	}
	
}