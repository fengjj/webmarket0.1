package com.sitech.market.dbo.trading.inter;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

/**
 * Create on 2015-4-6 
 * @author: gengws
 * @Title: IMkActrecordInfo 
 * @Description： MkActrecordInfo表dbo
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface IMkActrecordInfo {

	/**
     * 将活动订购信息插入MK_ACTRECORD_INFO表中
     * Create on 2014-11-25
     * @author zhaiwt
     * @version 1.0
     * Copyright(c) 北京思特奇信息技术股份有限公司
     * 修改日期:     修改人:     修改目的:
     */
    public boolean insertToActRecord(Map<String, String> datas, String str);
	//public boolean insertToActRecord(Map<String, Object> datas, String recordId);

	/** 
	  * 回滚MK_ACTRECORD_INFO表中的营销业务订购次数
	  * Create on 2014-11-27 
	  * @author zhaiwt
	  * @version 1.0
	  * Copyright(c) 北京思特奇信息技术股份有限公司
	  * 修改日期:     修改人:     修改目的:
	  */
	public void rollbackActRecord(String recordId, Map<String, String> datas);
	/**
	 * 
	 * Create on 2015-4-6 
	 * @author: gengws
	 * @Title: getActRecordsByImei 
	 * @Description: 根据imei查询订购记录
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List getActRecordsByImei(Map inMap);
	/**
	 * 
	 * Create on 2015-4-6 
	 * @author: gengws
	 * @Title: getActRecordsByIdNo 
	 * @Description: 根据IdNo查询订购记录
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List getActRecordsByIdNo(Map inMap);

	/**
     * 查询活动订购记录主表信息
     * 返回值类型：JSONObject
     * 作者： fengjj
     * 日期： 2015年3月16日
     * @throws Exception 
     */
    public JSONObject getActrecordInfo(String tableId,String orderNoStr, String idNo) throws Exception;
    /**
     * 根据用户标识查询索引表记录的serial_id
     * Create on 2014-09-24
     * @author fengjj
     * @version 1.0
     * Copyright(c) 北京思特奇信息技术股份有限公司
     * 修改日期:     修改人:     修改目的:
     */
    public JSONObject getSerialId(String idNo,String tableId);
    
    /**
     * 根据索引表列值--主键序列号 查主表
     * 返回值类型：JSONObject
     * 作者： fengjj
     * 日期： 2015年3月16日
     */
    public JSONObject getMainInfo(String tableName,String key) throws Exception;
    /**
     * 根据主键从关系表查分表数据
     * 返回值类型：JSONObject
     * 作者： fengjj
     * 日期： 2015年3月17日
     * @throws Exception 
     */
    public JSONObject getOtherOrderInfo(String tableId,String serial) throws Exception;
    /**
     * 根据主键从关系表查退订分表数据
     * 返回值类型：JSONObject
     * 作者： tangll
     * 日期： 2015年9月25日
     * @throws Exception 
     */
    public JSONObject getOtherUnOrderInfo(String tableId,String tablename,String serial) throws Exception;
    /**
     * Create on 2015-4-27 
     * @author: hanzh_bj
     * @Title: queryActrecordBySerialIds 
     * @Description: 根据主键查询查询活动订购记录
     * @param serialId
     * @return 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */
	public Map queryActrecordBySerialIds(String... serialIds);
    
    public JSONObject queryCheckPhone(Map<String,String> bean);
    
	/**
	 * Create on 2015-7-16 
	 * @author: liuhaoa
	 * @Title: selectMkActrecordInfo 
	 * @Description: 根据serail_id查询MkActrecordInfo成本总表信息
	 * @param inParam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note: 
	 */
	public JSONObject queryActrecordTracBySerialIds(String serialId);
    
    
    
    /** 
     * Create on 2015-7-10 
     * @author: wenzt
     * @Title: insertToActRecordTrac 
     * @Description: 
     * @param datas
     * @param str
     * @return 
     * @version 1.0 
     * update_data:       update_author:       update_note: 
     */
    public boolean insertToActRecordTrac(Map<String, Map<String,Object>> datas);
    /**
	 * 根据rowkey查询索引表
	 * @Create on 2015-7-15 
	 * @author: wangdw
	 * @Title: queryIndexByKey 
	 * @Description: 
	 * @param rowKey
	 * @return 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	public List queryIndexByKey(String rowKey); 
	/**
	 * Create on 2015-7-17 
	 * @author: gengws
	 * @Title: getActRecordsByKeys
	 * @Description: 主键集合查询
	 * @param  
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public JSONObject getActRecordsByKeys(String[] keys);
	/**
	 * Create on 2015-7-16 
	 * @author: liuhaoa
	 * @Title: selectMkActrecordInfo 
	 * @Description: 根据serail_id查询MkActrecordInfo成本总表信息
	 * @param inParam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public JSONObject selectMkActrecordInfo(String serial_id);
	/**
	 * 
	* Create on Aug 11, 2015 
	* @author: qijh
	* @Title: getActrecordInfo 
	* @Description: 
	* @param tableId
	* @param orderNoStr
	* @param idNo
	* @param contactId
	* @return
	* @throws Exception 
	* @version 1.0 
	* update_data: update_author: update_note:
	 */
    public JSONObject getActrecordInfo(String tableId,String orderNoStr, String idNo ,String contactId) throws Exception;
}
