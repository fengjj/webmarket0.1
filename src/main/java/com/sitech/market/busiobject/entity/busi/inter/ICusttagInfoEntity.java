package com.sitech.market.busiobject.entity.busi.inter;

import com.sitech.jcfx.dt.MBean;

/**
 * Create on 2016-7-21
 * @author: zhenggp
 * @Title: CusttagInfoEntity
 * @Description：客户群标签实体
 * @version 1.0  
 * update_data:     update_author:     update_note:
 */
public interface ICusttagInfoEntity {

	/**
	 * Create on 2016-7-21 
	 * @author: zhenggp
	 * @Title: queryCusttagByKeyword 
	 * @Description: 根据关键字查询客户群二级标签
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public MBean queryCusttagByKeyword(MBean paraBean);
	
	/**
	 * @author: zhenggp
	 * @Title: addCusttagCollectionInfo
	 * @Description:添加工号收藏标签信息
	 * @return 
	 * @version 1.0 
	 * date:2016-7-21
	 */
	public MBean addCusttagCollectionInfo(MBean paraBean);
	
	/**
	 * @author: zhenggp
	 * @Title: queryCusttagCollectionInfoByLoginNoAndCustTagId
	 * @Description:查询工号是否收藏指定标签
	 * @return 
	 * @version 1.0 
	 * date:2016-7-21
	 */
	public MBean queryCusttagCollectionInfoByLoginNoAndCustTagId(MBean paraBean);
	
	/**
	 * @author: zhenggp
	 * @Title: removeCusttagCollectionInfoByLoginNoAndCustTagId
	 * @Description:删除工号收藏指定标签的记录
	 * @return 
	 * @version 1.0 
	 * date:2016-7-22
	 */
	public MBean removeCusttagCollectionInfoByLoginNoAndCustTagId(MBean paraBean);
}





