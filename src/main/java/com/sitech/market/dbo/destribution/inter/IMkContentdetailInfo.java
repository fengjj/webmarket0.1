package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

/**
 * Create on 2015-5-30 
 * @author: yugl
 * @Title: IMkContentdetailInfo 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface IMkContentdetailInfo {
	
	/**
	 * Create on 2015-5-30 
	 * @author: yugl
	 * @Title: selectMkContentdetailInfo 
	 * @Description: 查询内容明细表
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectMkContentdetailInfo(Map map);
	
	/**
	 * Create on 2015-5-27
	 * @author: yugl
	 * @Title: selectMkContentInfo 
	 * @Description: 查询费用内容表
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectElementIdBySubContentId(Map map);
	
	/**
	 * Create on 2015-5-27
	 * @author: jiaxla
	 * @Title: selectContentDetailBySubContentId 
	 * @Description: 根据subId查询contentdetail表
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectContentDetailBySubContentId(Map map);
	
	/**
	 * Create on 2015-5-30 
	 * @author: yugl
	 * @Title: selectContentParameter 
	 * @Description: 查询明细表元素参数属性信息
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectContentParameter(Map map);

	/**
	 * Create on 2015-6-6
	 * @author: zhangchen
	 * @Title: insertMkContentdetailInfo 
	 * @Description: 插入数据
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void insertMkContentdetailInfo(List lsit) ;
	
	/**
	 * Create on 2015-6-6
	 * @author: jiaxla
	 * @Title: updateBatchMkContentdetailInfo 
	 * @Description: 插入数据
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void updateBatchMkContentdetailInfo(List lsit) ;
	
	/**
	 * Create on 2015-6-6
	 * @author: zhangchen
	 * @Title: updateMkContentdetailInfo 
	 * @Description: 更新数据
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public int updateMkContentdetailInfo(Map map);
	/**
	 * Create on 2015-6-6
	 * @author: zhangchen
	 * @Title: deleteMkContentdetailInfoById 
	 * @Description: 删除数据
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public int deleteMkContentdetailInfo(Map map) ;
	
	/**
	 * Create on 2015-6-22
	 * @author: jiaxla
	 * @Title: deleteMkContentdetailInfoByCotentSerialId 
	 * @Description: 根据contentSerialId删除数据
	 * @param contentSerialId
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public int deleteMkContentdetailInfoByCotentSerialId(String contentSerialId);

	/**
	 * Create on 2015-6-8 
	 * @author: yugl
	 * @Title: selectParameterFee 
	 * @Description: 查询内容明细表的费用数据
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectParameterFee(Map map);
	
	/**
	 * Create on 2015-6-8 
	 * @author: wenzt
	 * @Title: selectContentDetailBybusiId 
	 * @Description: 查询内容详情
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectContentDetailBybusiId(Map map);

}
