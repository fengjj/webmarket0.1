package com.sitech.market.dbo.destribution.impl;

import java.util.List;
import java.util.Map;

import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkImportbusiexpTmp;
/**
 * 批量业务导入临时异常表
 * @Create on 2015-7-29 
 * @author: wangdw
 * @Title: MkImportbusiexpTmp 
 * @Description： 
 * @version 1.0 
 * update_date:      update_author:      update_note:
 */
public class MkImportbusiexpTmp extends DBMysqlClass implements
		IMkImportbusiexpTmp {
	/**
	 * 插入
	 * @Create on 2015-7-29 
	 * @author: wangdw
	 * @Title: insertMkImportbusiexpTmp 
	 * @Description: 
	 * @param inMap 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	@Override
	public void insertMkImportbusiexpTmp(Map inMap) {
		baseDao.insert("MkImportbusiexpTmp.insertMkImportbusiexpTmp", inMap);
	}
	
	/**
	 * 批量插入
	 * @Create on 2015-7-29 
	 * @author: wangdw
	 * @Title: batchInsertMkImportbusiexpTmp 
	 * @Description: 
	 * @param inMap 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	@Override
	public void batchInsertMkImportbusiexpTmp(List list) {
		baseDao.batchInsert("MkImportbusiexpTmp.insertMkImportbusiexpTmp", list);
	}
	
	/**
	 * 查询
	 * @Create on 2015-7-30 
	 * @author: wangdw
	 * @Title: selectMkImportbusiexpTmp 
	 * @Description: 
	 * @param inParam
	 * @return 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	@Override
	public List<Map> selectMkImportbusiexpTmp(Map inParam) {
		return baseDao.queryForList("MkImportbusiexpTmp.selectMkImportbusiexpTmp", inParam);
	}
}
