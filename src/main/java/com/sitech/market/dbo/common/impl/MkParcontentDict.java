package com.sitech.market.dbo.common.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.sitech.jcf.core.exception.BaseException;
import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.common.inter.IMkParcontentDict;
import com.sitech.util.MBeanUtil;

/**
 * 营销执行前台界面配置,元素内容表实现
 * Create on 2015-1-14
 * @author dongyh
 */
public class MkParcontentDict extends DBMysqlClass implements IMkParcontentDict {
	
	/** 
	  * 入参map里取出list，list格式：[{provinceGroup=10011, parameterId=A0206, contentId=Y028}, {provinceGroup=10011, parameterId=B0206, contentId=Y070}]
	  * Create on 2015-2-3
	  * @author yugl
	  * Copyright(c) 北京思特奇信息技术股份有限公司
	  * 修改日期:     修改人:     修改目的:
	  */
	public List<Map> selectMkParcontentDictByContentId(Map map) {
		List list = (List) map.get("parameterContentList");
		List<Map> contentList = null;
		try {
			contentList = baseDao.queryForList("MkParcontentDict.selectMkParcontentDictByContentId",list);
		} catch (Exception e) {
			throw new BaseException("selectMkParcontentDictByContentId","亲,selectMkParcontentDictByContentId出异常了,到后台看看吧" + e);
		}
		return contentList;
	}

	@Override
	public List selectParContentInfo(Map inParam) {
		return baseDao.queryForList("MkParcontentDict.selectMkParcontentDict",inParam);
	}

	@Override
	public List queryParContent(Map contentBean) {
		return baseDao.queryForList("MkParcontentDict.selectInitParamContentSql", contentBean);
	}

	@Override
	public List queryParContentTrac(Map contentBean) {
		return baseDao.queryForList("MkParcontentDict.selectInitParamContentTracSql",contentBean);
	}
	
	
}
