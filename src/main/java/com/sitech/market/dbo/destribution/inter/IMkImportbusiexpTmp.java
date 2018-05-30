package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

/**
 * 批量业务导入临时异常表
 * @Create on 2015-7-29 
 * @author: wangdw
 * @Title: IMkImportbusiexpTmp 
 * @Description： 
 * @version 1.0 
 * update_date:      update_author:      update_note:
 */
public interface IMkImportbusiexpTmp {
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
	public void insertMkImportbusiexpTmp(Map inMap);
	/**
	 * 批量插入
	 * @Create on 2015-7-29 
	 * @author: wangdw
	 * @Title: batchInsertMkImportbusiexpTmp 
	 * @Description: 
	 * @param list 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	public void batchInsertMkImportbusiexpTmp(List list);
	
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
	public List<Map> selectMkImportbusiexpTmp(Map inParam);
}
