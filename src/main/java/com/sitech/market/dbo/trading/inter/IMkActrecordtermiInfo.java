package com.sitech.market.dbo.trading.inter;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface IMkActrecordtermiInfo {
	
	/**
	 * Create on 2015-4-6 
	 * @author: gengws
	 * @Title: updateImei 
	 * @Description: 更新IMEI信息
	 * @param inMap 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void updateImei(Map inMap);
	
	
	/**
     * 批量向MK_ACTRECORDTERMI_INFO表中插入相关数据
     * Create on 2014-11-26
     * @author hanzh_bj
     * @version 1.0
     * Copyright(c) 北京思特奇信息技术股份有限公司
     * 修改日期:     修改人:     修改目的:
     */
	public void insertBatchToActRecordTermi(Map<String, Map<String, Object>> termiRecordMap);
	
	/**
	 * Create on 2015-4-16 
	 * @author: gengws
	 * @Title: queryActRecordTermi 
	 * @Description: 通过主表的serialId去查询mk_actrecord_info
	 * @param list
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List queryActRecordTermi(List list);
	/**
     * 退订订购记录改变状态
     * Create on 2014-11-25
     * @author wenzt
     * @version 1.0
     * Copyright(c) 北京思特奇信息技术股份有限公司
     * 修改日期:     修改人:     修改目的:
     */
	public void insertActRecordTermi(Map<String, String> datas, String recordId);
	
	/**
	 * Create on 2015-4-22 
	 * @author: zhaoyue
	 * @Title: queryMkActRecordTermiInfo 
	 * @Description: 跟据分表的serial_id去查询mk_actrecordter_info
	 * @param keys
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public JSONObject queryMkActRecordTermiInfoBySerialId(List list, String[] keys);
	
	/**
	 * Create on 2015-6-2
	 * @author:liuhaoa
	 * @Title: getActIMEIRecordList
	 * @Description: 终端IMEI使用信息查询
	 * @param inParam
	 * @return OutDTO
	 * @version 1.0
	 * update_data:     update_author:     update_note:
	 */
	public List getActIMEIRecordList(Map inMap);
	
	/**
	 * Create on 2015-6-3
	 * @author:liuhaoa
	 * @Title: getAtomPhoneNoList
	 * @Description: 终端捆绑备用号码管理
	 * @param inParam
	 * @return OutDTO
	 * @version 1.0
	 * update_data:     update_author:     update_note:
	 */
	public List getAtomPhoneNoList(Map inMap);
	
	/**
	 * @author: liuhaoa
	 * @Title: getAtomUnIMEIList 
	 * @Description:终端取消捆绑IMEI登记
	 * @return 
	 * @version 1.0 
	 * date:2015-6-4
	 */
	public List getAtomUnIMEIList(Map inMap);
	
	/**
	 * @author: liuhaoa
	 * @Title: getAtomIMEISyList 
	 * @Description:终端IMEI捆绑顺延登记
	 * @return 
	 * @version 1.0 
	 * date:2015-6-4
	 */
	public List getAtomIMEISyList(Map inMap);
	
	/**
	 * @author: liuhaoa
	 * @Title: getAtomIMEIUnSyList 
	 * @Description:终端IMEI捆绑顺延登记取消
	 * @return 
	 * @version 1.0 
	 * date:2015-6-4
	 */
	public List getAtomIMEIUnSyList(Map inMap);

	/**
	 * Create on 2015-6-18 
	 * @author: gengws
	 * @Title: getTermiRecordByIdNo 
	 * @Description: 通过ID_NO去查询mk_indextoquery_idx,mk_actrecordtermi_info
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List getTermiRecordByIdNo(Map inMap);
	
	
	/** 
	 * Create on 2015-7-10 
	 * @author: wenzt
	 * @Title: queryActRecordTermiBySerialIds 
	 * @Description: 
	 * @param serialIds
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note: 
	 */
	public JSONObject queryActRecordTermiBySerialIds(String serialId);
	
	
		/**
	 * 获得终端订购记录表
	 * @Create on 2015-7-15 
	 * @author: wangdw
	 * @Title: getActRecordTermList 
	 * @Description: 
	 * @param termKeys
	 * @return 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	public List<Map> getActRecordTermList(String[] termKeys);
	/** 
	 * Create on 2015-7-10 
	 * @author: wenzt
	 * @Title: queryActRecordTermiTracBySerialIds 
	 * @Description: 
	 * @param serialIds
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note: 
	 */
	public JSONObject queryActRecordTermiTracBySerialIds(String serialId);
	
	/** 
	 * Create on 2015-7-10 
	 * @author: wenzt
	 * @Title: insertToActRecordTermiTrac 
	 * @Description: 
	 * @param datas
	 * @param serialId
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note: 
	 */
	public boolean insertToActRecordTermiTrac(Map<String, Map<String,Object>> datas);
	/**
	 * Create on 2015-7-17 
	 * @author: gengws
	 * @Title: getActRecordTermiByImeiNo
	 * @Description: 根据IMEI_NO查询订购记录
	 * @param  
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public JSONObject getActRecordTermiByImeiNo(String imeiNo);
		/**
	 * Create on 2015-7-17
	 * @author: liuhaoa
	 * @Title: selectMkActrecordRel 
	 * @Description: 根据key查询MkActrecordtermiInfo成本终端分表
	 * @param inParam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public JSONObject selectMkActrecordtermiInfo(String[] keys);

	
	/**
	 * 3.2.12更新营销活动订购数据
	 * @param inparam
	 * @author gengws
	 * Create on 2015-03-02
	 */
	public void updateMkActrecordtermiInfo(Map<String,String> map);

	
	
	/**
	 * Create on 2015-7-27 
	 * @author:zhaoyue
	 * @Title: queryActrecordTermiInfoByIdNo 
	 * @Description:根据idNo查询mk_actrecordtermi_info数据 
	 * @param idNo
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List queryActrecordTermiInfoByIdNo(String idNo);
	
	
}
