package com.sitech.market.dbo.common.impl;


import java.util.List;
import java.util.Map;

import com.sitech.jcf.core.exception.BusiException;
import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.common.inter.IMkChngroupRel;

public class MkChngroupRel extends DBMysqlClass implements IMkChngroupRel{

    /**
     * 查询mk_chngroup_rel
     * Create on 2015-02-03
     * @author zhouwy
     * @version 1.0 
     * Copyright(c) 北京思特奇信息技术股份有限公司 
     * 功能描述：mk_chngroup_rel
     * 修改日期: 修改人: 修改目的:
     */
	@Override
	public List<Map> queryChngroupRelInfo(Map map) {
		List list = null;
    	try{
    		list = baseDao.queryForList("MkChngroupRel.selectMkChngroupRel", map);
    	}catch(Exception e){
    		throw new BusiException("MkChngroupRel.selectMkChngroupRel", e + "报告大王，查询数据的时候出错了！");
    	}
		return list;
	}
}
