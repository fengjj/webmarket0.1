package com.sitech.market.busiobject.entity.common.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sitech.cache.Cache;
import com.sitech.cache.CacheHelper;
import com.sitech.market.busiobject.basicclass.busientity.BusiEntity;
import com.sitech.market.busiobject.entity.busi.inter.ICustGroupAtomEntity;
import com.sitech.market.busiobject.entity.common.inter.ICommonAtomEntity;
import com.sitech.market.dbo.common.inter.ICommonDBO;
import com.sitech.market.dbo.common.inter.IMkCodenameDict;
import com.sitech.market.dbo.destribution.inter.IMkAuditresultInfo;
import com.sitech.market.dbo.destribution.inter.IMkBusiareaInfo;
import com.sitech.market.dbo.destribution.inter.IMkBusichnRel;
import com.sitech.market.dbo.destribution.inter.IMkBusicustgroupRel;
import com.sitech.market.dbo.destribution.inter.IMkBusievalInfo;
import com.sitech.market.dbo.destribution.inter.IMkBusimeansRel;
import com.sitech.market.dbo.destribution.inter.IMkBusiruleRel;
import com.sitech.market.dbo.destribution.inter.IMkBusitemplateRel;
import com.sitech.util.CommonUtil;
import com.sitech.util.Const;

/**
 * 公共原子实体
 * Create on 2015-5-6 
 * @author: wangdw
 * @Title: CommonAtomEntity 
 * @Description 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
@SuppressWarnings("unchecked")
public class CommonAtomEntity extends BusiEntity implements ICommonAtomEntity {
	// dbo
	private IMkCodenameDict mkCodenameDict;
//	private IMkBusievalInfo mkBusievalInfo;
//	private IMkBusiareaInfo mkBusiareaInfo;
//	private IMkBusitemplateRel mkBusitemplateRel;
//	private IMkBusicustgroupRel mkBusicustgroupRel;
//	private IMkBusiruleRel mkBusiruleRel;
//	private IMkAuditresultInfo mkAuditresultInfo;
//	private IMkBusichnRel mkBusichnRel;
//	private IMkBusimeansRel mkBusimeansRel;
	private ICommonDBO commonDBO;
	 
//	private ICustGroupAtomEntity custGroupAtomEntity;
	
	

	/**
	 * 查询mk_codename_dict表信息
	 * Create on 2015-5-6 
	 * @author: wangdw
	 * @Title: queryCodeName 
	 * @Description: 
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public Map queryCodeName(Map map) {
		Map returnMap = new HashMap();
		List<Map> codenameList = mkCodenameDict.queryCodeNameList(map);
		returnMap.put("codenameList", codenameList);
		return returnMap;
	}
	
	/**
	 * 查询name值
	 * Create on 2015-5-18 
	 * @author: wangdw
	 * @Title: getCodeName 
	 * @Description: 根据table_en_name和filed_value查询mk_codename_dict表，获取name值。
	 * @param tableEnName
	 * @param filedValue
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public String getCodeName(String tableEnName, String filedValue, String provinceGroup) {
		Map codeMap=new HashMap();
		codeMap.put("tableEnName", tableEnName);
		codeMap.put("provinceGroup", provinceGroup);
		codeMap.put("fieldValue", filedValue);
		List nameList=mkCodenameDict.queryCodeNameList(codeMap);
		if (!CommonUtil.isEmpty(nameList)) {
			Map map = (Map)nameList.get(0);
			return (String)map.get("fieldDesc");
		}
		return null;
	}
	
	public Map queryForPagingList(Map inMap) {
		Map retMap = commonDBO.queryForPagingList(inMap);
		return retMap;
	}
	
	public void setMkCodenameDict(IMkCodenameDict mkCodenameDict) {
		this.mkCodenameDict = mkCodenameDict;
	}
	
//	public void setMkBusievalInfo(IMkBusievalInfo mkBusievalInfo) {
//		this.mkBusievalInfo = mkBusievalInfo;
//	}
//	
//	public void setMkBusiareaInfo(IMkBusiareaInfo mkBusiareaInfo) {
//		this.mkBusiareaInfo = mkBusiareaInfo;
//	}
//	
//	public void setMkBusitemplateRel(IMkBusitemplateRel mkBusitemplateRel) {
//		this.mkBusitemplateRel = mkBusitemplateRel;
//	}
//	
//	public void setMkBusicustgroupRel(IMkBusicustgroupRel mkBusicustgroupRel) {
//		this.mkBusicustgroupRel = mkBusicustgroupRel;
//	}
//	
//	
//	public void setMkAuditresultInfo(IMkAuditresultInfo mkAuditresultInfo) {
//		this.mkAuditresultInfo = mkAuditresultInfo;
//	}
//	
//	public void setMkBusiruleRel(IMkBusiruleRel mkBusiruleRel) {
//		this.mkBusiruleRel = mkBusiruleRel;
//	}
//
//	public void setMkBusichnRel(IMkBusichnRel mkBusichnRel) {
//		this.mkBusichnRel = mkBusichnRel;
//	}
//
//	public void setMkBusimeansRel(IMkBusimeansRel mkBusimeansRel) {
//		this.mkBusimeansRel = mkBusimeansRel;
//	}
	public void setCommonDBO(ICommonDBO commonDBO) {
		this.commonDBO = commonDBO;
	}
//	public void setCustGroupAtomEntity(ICustGroupAtomEntity custGroupAtomEntity) {
//		this.custGroupAtomEntity = custGroupAtomEntity;
//	}

	@Override
	public Map queryBusiInfo(String elementId, Map budiInMap) {
		// TODO Auto-generated method stub
		return null;
	}
}
