package com.sitech.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 读取文件,将数据插入nosql数据库
 * @author Administrator
 *
 */

public class toCassandra {
	private static CassandraUtil cassandraDao = null;
    
	public static void main(String[] args) {
        String filePath = "/ngmkt/shell/yq.txt";
        try {
        	cassandraDao = (CassandraUtil) ConfigBeanFactory.getBean("cassandraUtil");
			BufferedReader reader = new BufferedReader(new FileReader(filePath), 5 * 1024 * 1024);
			String tempString = null;
			Map<String, Object> data_ = null;
			Map<String, Map<String, Object>> data = null;
			List<Map<String, Map<String, Object>>> datas = new ArrayList<Map<String, Map<String, Object>>>();
			int line = 0;
			while ((tempString = reader.readLine()) != null && !"".equals(tempString)) {
				data_ = new HashMap<String, Object>();
				data = new HashMap<String, Map<String, Object>>();
				String[] temp = tempString.split(",");
				String phoneNo = temp[0];
				String idNo = temp[1];
				if(temp.length >=2){
					idNo = temp[1];
				}else{
					idNo = "";
				}
				data_.put("phone_no", phoneNo);
				data_.put("id_no", idNo);
				String key = phoneNo;
				data.put(key, data_);
				datas.add(data);
				if(datas.size() % 100 == 0){
					System.out.println("data==================:"+datas.size());
					cassandraDao.insertMultiCloumAndRows("mk_phone_info", datas);
					datas = new ArrayList<Map<String, Map<String, Object>>>();
				}
			}
			if(datas.size() > 0){
				System.out.println("data==================:"+datas.size());
				cassandraDao.insertMultiCloumAndRows("mk_phone_info", datas);
				datas = new ArrayList<Map<String, Map<String, Object>>>();
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
