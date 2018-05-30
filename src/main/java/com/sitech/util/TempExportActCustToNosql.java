package com.sitech.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TempExportActCustToNosql {
	private static CassandraUtil cassandraDao = null;
	public static void main(String[] args) {
		
		String filePath = "/ngmkt/shell/11.txt";
		//String filePath = "E:/11.txt";
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
				String idNoAndCustGroupId = temp[0];
				String serialId = temp[1];
				String phoneNo = temp[2];
				String statusCode = temp[3];
				String uploadSeqNo = temp[4];
				String operNo = temp[5];
				String operName = temp[6];
				String operTime = "";
				if(temp.length >=8){
					operTime = temp[7];
				}else{
					operTime = "";
				}
				data_.put("serial_id", serialId);
				data_.put("oper_name", operName);
				data_.put("phone_no", phoneNo);
				data_.put("oper_no", operNo);
				data_.put("oper_time", operTime);
				data_.put("upload_seq_no", uploadSeqNo);
				data_.put("status_code", statusCode);
				String key = idNoAndCustGroupId;
				data.put(key, data_);
				datas.add(data);
				if(datas.size() % 100 == 0){
					System.out.println("data==================:"+datas.size());
					cassandraDao.insertMultiCloumAndRows("mk_actcust_info", datas);
					datas = new ArrayList<Map<String, Map<String, Object>>>();
				}
			}
			if(datas.size() > 0){
				System.out.println("data==================:"+datas.size());
				cassandraDao.insertMultiCloumAndRows("mk_actcust_info", datas);
				datas = new ArrayList<Map<String, Map<String, Object>>>();
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
