package com.sitech.market.dbo.contact.inter;


import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

/**phone表实体类
 * create on 2014-11-05
 * @author sunliang
 */
public interface IMkPhoneInfo {
	/**通过phoneNo查询mk_phone_info记录
	 * create on 2014-11-05
	 * @author sunliang
	 */
	public String getIdNoByPhoneNo(String phoneNo);

	public List<String> getIdNoByPhoneNos(List<String> phoneList);
	
	/**
	 * @Description:根据phoneNo服务号码查询信息
	 * create on 2015-7-19
	 * @Title:selectMkPhoneInfoByPhoneNo
	 * @param phoneNo
	 * @return
	 */
	public JSONObject selectMkPhoneInfoByPhoneNo(String phoneNo);
	
	/**
	 * 根据电话号集合，查询idNo集合
	 * @Create on 2015-7-29 
	 * @author: wangdw
	 * @Title: getIdNosByPhoneNos 
	 * @Description: 
	 * @param phoneList
	 * @return Map<String, String>类型，其中：key=phoneNo，value=idNo。
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	public Map<String, String> getIdNosByPhoneNos(List<String> phoneList);
	
	/**
	 * 查询idNos，查询不出不报异常
	 * @Create on 2015-7-29 
	 * @author: wangdw
	 * @Title: getIdNosWithNoExp 
	 * @Description: 
	 * @param phoneList
	 * @return 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	public List<String> getIdNosWithNoExp(List<String> phoneList);
	/**
	 * 插入数据
	 * @Create on 2015-8-27 
	 * @author: tangll
	 * @Title: insertMkPhoneInfo 
	 * @Description: 
	 * @param phoneList
	 * @return 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	public void insertMkPhoneInfo(String phone,String id_no);
	public JSONObject selectMkPhoneInfoByIdNo(String id_no);
	/**
	 * 删除数据
	 * @Create on 2015-8-27 
	 * @author: tangll
	 * @Title: deleteMkPhoneInfo 
	 * @Description: 
	 * @param phoneList
	 * @return 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	public void deleteMkPhoneInfo(String phone);
}
