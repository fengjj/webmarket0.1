package com.sitech.market.dbo.destribution.impl;

import java.util.List;
import java.util.Map;

import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkActClassMeansClassRel;
import com.sitech.util.MBeanUtil;

public class MkActClassMeansClassRel extends DBMysqlClass implements
		IMkActClassMeansClassRel {

	@Override
	public List queryActClassMeansClassRel(Map bean) {
		return baseDao.queryForList("MkActclassmeansclassRel.selectMeansClass", bean);
	}

}

