package com.sitech.market.dbo.common.impl;

import java.util.List;
import java.util.Map;

import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.common.inter.IMkAuditroleDict;
import com.sitech.util.MBeanUtil;

public class MkAuditroleDict extends DBMysqlClass implements IMkAuditroleDict {
   /**
	* 审批角色查询
	* Create on 2014-11-13 上午11:45:21
	* @author tianyy_bj
	* @version 1.0
	* Copyright(c) 北京思特奇信息技术股份有限公司
	* 功能描述：
	* 修改日期:     修改人:     修改目的:
	*/
	@Override
	public List selectMkAuditroleDict(Map inParam) {
		List roleList = baseDao.queryForList("MkAuditroleDict.selectMkAuditroleDict", inParam);
		return roleList;
	}

	/**
	 * 查询角色最高级别
	 * @author hanzh_bj
	 * @param paraMap
	 * @return
	 */
	@Override
	public String selectMaxRoleLevel(Map inParam) {
		return (String) baseDao.queryForObject("MkAuditroleDict.selectMaxRoleLevel", inParam);
	}

}
