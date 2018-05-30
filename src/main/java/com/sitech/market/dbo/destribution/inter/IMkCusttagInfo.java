package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

/**
 * 
 * Create on 2016-7-19
* @author: zhenggp
* @Title: MkCusttagInfo
* @Description： 客户群标签
* @version 1.0 
* update_data:      update_author:      update_note:
 *
 */
public interface IMkCusttagInfo {
	
	/**
	 * @author: zhenggp
	 * @Title: queryCusttagByKeyword
	 * @Description:根据关键字查询客户群二级标签
	 * @return 
	 * @version 1.0 
	 * date:2016-7-21
	 */
	public List<Map<String,String>> queryCusttagByKeyword(Map<String,String> para);
	
	/**
	 * @author: zhenggp
	 * @Title: addCusttagCollectionInfo
	 * @Description:添加工号收藏标签信息
	 * @return 
	 * @version 1.0 
	 * date:2016-7-21
	 */
	public void addCusttagCollectionInfo(Map<String,String> para);

	/**
	 * @author: zhenggp
	 * @Title: queryCusttagCollectionInfoByLoginNoAndCustTagId
	 * @Description:查询工号是否收藏指定标签
	 * @return 
	 * @version 1.0 
	 * date:2016-7-21
	 */
	public List<Map<String,String>> queryCusttagCollectionInfoByLoginNoAndCustTagId(Map<String,String> para);
	
	/**
	 * @author: zhenggp
	 * @Title: removeCusttagCollectionInfoByLoginNoAndCustTagId
	 * @Description:删除工号收藏指定标签的记录
	 * @return 
	 * @version 1.0 
	 * date:2016-7-22
	 */
	public int removeCusttagCollectionInfoByLoginNoAndCustTagId(Map<String,String> para);
}
