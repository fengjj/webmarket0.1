package com.sitech.market.dbo.destribution.impl;

import java.util.List;
import java.util.Map;

import com.sitech.jcf.core.exception.BusiException;
import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkBusiRel;
/**
 * 
 * Create on 2015-3-17
 * @author: gengws
 * @Title: MkBusiRel 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class MkBusiRel extends DBMysqlClass implements IMkBusiRel {

	@Override
	public String selectRuleSerialIdByActId(String actId) {
		String ruleSerialId = "-1";
		try{
			ruleSerialId = (String) baseDao.queryForObject("MkBusiRel.selectRuleSerialIdByActId",actId);
		}catch(Exception e){
			throw new BusiException("-1","selectRuleSerialIdByActId","亲,selectRuleSerialIdByActId出錯了");
		}
		return ruleSerialId;
	}

	/** 
	 * Create on 2015-6-22 
	 * @author: songxj
	 * @Title: selectMkBusiRel 
	 * @Description: 查询mk_busi_rel中所有信息
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note: 
	 */
	@Override
	public List selectMkBusiRel(Map inMap) {
		return baseDao.queryForList("MkBusiRel.selectMkBusiRel", inMap);
	}
	
}
