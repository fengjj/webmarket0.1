package com.sitech.market.dbo.destribution.impl;

import java.util.List;
import java.util.Map;

import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkCusttagInfo;

/**
 * 
 * Create on 2016-7-21
* @author: zhenggp
* @Title: MkCusttagInfo
* @Description： 客户群标签DBO
* @version 1.0 
* update_data:      update_author:      update_note:
 *
 */
public class MkCusttagInfo extends DBMysqlClass implements IMkCusttagInfo{

	/**
	 * @author: zhenggp
	 * @Title: queryCusttagByKeyword
	 * @Description:根据关键字查询客户群二级标签
	 * @return 
	 * @version 1.0 
	 * date:2016-7-21
	 */
	public List<Map<String, String>> queryCusttagByKeyword(Map<String,String> para){
		return baseDao.queryForList("MkCusttagInfo.selectMkCusttagInfoByKeyword", para);
	}

	/**
	 * @author: zhenggp
	 * @Title: addCusttagCollectionInfo
	 * @Description:添加工号收藏标签信息
	 * @return 
	 * @version 1.0 
	 * date:2016-7-21
	 */
	@Override
	public void addCusttagCollectionInfo(Map<String, String> para) {
		baseDao.insert("MkCusttagCollectionInfo.insertMkCusttagCollectionInfo", para);
	}
	
	/**
	 * @author: zhenggp
	 * @Title: queryCusttagCollectionInfoByLoginNoAndCustTagId
	 * @Description:查询工号是否收藏指定标签
	 * @return 
	 * @version 1.0 
	 * date:2016-7-21
	 */
	public List<Map<String,String>> queryCusttagCollectionInfoByLoginNoAndCustTagId(Map<String,String> para){
		return baseDao.queryForList("MkCusttagCollectionInfo.selectCusttagCollectionInfoByLoginNoAndCustTagId", para);
	}

	/**
	 * @author: zhenggp
	 * @Title: removeCusttagCollectionInfoByLoginNoAndCustTagId
	 * @Description:删除工号收藏指定标签的记录
	 * @return 
	 * @version 1.0 
	 * date:2016-7-22
	 */
	@Override
	public int removeCusttagCollectionInfoByLoginNoAndCustTagId(
			Map<String, String> para) {
		return baseDao.delete("MkCusttagCollectionInfo.deleteMkCusttagCollectionInfoByLoginNoAndCustTagId", para);
	}
}
