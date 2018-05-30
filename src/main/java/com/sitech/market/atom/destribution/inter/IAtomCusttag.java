package com.sitech.market.atom.destribution.inter;

import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;
import com.sitech.jcfx.dt.out.OutDTO;

/**
 * Create on 2016-7-21
 * @author: zhenggp
 * @Title: AtomCusttag
 * @Description：客户群标签服务
 * @version 1.0  
 * update_data:     update_author:     update_note:
 */
public interface IAtomCusttag {

	/**
	 * Create on 2016-7-21 
	 * @author: zhenggp
	 * @Title: queryCusttagByKeyword 
	 * @Description: 根据关键字查询客户群二级标签
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO queryCusttagByKeyword(InDTO inPara);
	
	/**
	 * @author: zhenggp
	 * @Title: addCusttagCollectionInfo
	 * @Description:添加工号收藏标签信息
	 * @return 
	 * @version 1.0 
	 * date:2016-7-21
	 */
	public OutDTO addCusttagCollectionInfo(InDTO inPara); 
	
	/**
	 * @author: zhenggp
	 * @Title: queryCusttagCollectionInfoByLoginNoAndCustTagId
	 * @Description:查询工号是否收藏指定标签
	 * @return 
	 * @version 1.0 
	 * date:2016-7-21
	 */
	public OutDTO queryCusttagCollectionInfoByLoginNoAndCustTagId(InDTO inPara);
	
	/**
	 * @author: zhenggp
	 * @Title: removeCusttagCollectionInfoByLoginNoAndCustTagId
	 * @Description:删除工号收藏指定标签的记录
	 * @return 
	 * @version 1.0 
	 * date:2016-7-22
	 */
	public OutDTO removeCusttagCollectionInfoByLoginNoAndCustTagId(InDTO inPara);
	
	
	
}



