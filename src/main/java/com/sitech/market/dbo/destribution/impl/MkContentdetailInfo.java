package com.sitech.market.dbo.destribution.impl;

import java.util.List;
import java.util.Map;

import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkContentInfo;
import com.sitech.market.dbo.destribution.inter.IMkContentdetailInfo;
import com.sitech.market.dbo.destribution.inter.IMkContentfeeInfo;

/**
 * Create on 2015-5-30 
 * @author: yugl
 * @Title: MkContentdetailInfo 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
@SuppressWarnings("unchecked")
public class MkContentdetailInfo extends DBMysqlClass implements IMkContentdetailInfo {
	
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
	@Override
	public List selectMkContentdetailInfo(Map map) {
		return baseDao.queryForList("MkContentdetailInfo.selectMkContentdetailInfo", map);
	}
	
	/**
	 * Create on 2015-5-30 
	 * @author: yugl
	 * @Title: selectElementIdBySubContentId 
	 * @Description: 根据分表流水查询elementId
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List selectElementIdBySubContentId(Map map) {
		return baseDao.queryForList("MkContentdetailInfo.selectElementIdBySubContentId", map);
	}
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
	@Override
	public List selectContentDetailBybusiId(Map map){
		return baseDao.queryForList("MkContentdetailInfo.selectContentDetailBybusiId",map);
	}
	/**
	 * Create on 2015-5-30 
	 * @author: jiaxla
	 * @Title: selectContentDetailBySubContentId 
	 * @Description: 根据subId查询contentdetail
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List selectContentDetailBySubContentId(Map map) {
		return baseDao.queryForList("MkContentdetailInfo.selectContentDetailBySubContentId", map);
	}
	
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
	@Override
	public List selectContentParameter(Map map) {
		return baseDao.queryForList("MkContentdetailInfo.selectContentParameter", map);
	}
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
	@Override
	public void insertMkContentdetailInfo(List list) {
		baseDao.batchInsert("MkContentdetailInfo.insertMkContentdetailInfo", list);
	}
	
	/**
	 * Create on 2015-6-6
	 * @author: jiaxla
	 * @Title: updateBatchMkContentdetailInfo 
	 * @Description: 批量更新表数据
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void updateBatchMkContentdetailInfo(List list) {
		baseDao.batchUpdate("MkContentdetailInfo.updateMkContentdetailInfoById", list);
	}
	
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
	@Override
	public int updateMkContentdetailInfo(Map map) {
		return baseDao.update("MkContentdetailInfo.updateMkContentdetailInfo", map);
	}
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
	@Override
	public int deleteMkContentdetailInfo(Map map) {
		return baseDao.delete("MkContentdetailInfo.deleteMkContentdetailInfo", map);
	}
	/**
	 * Create on 2015-6-22
	 * @author: jiaxla
	 * @Title: deleteMkContentdetailInfoByCotentSerialId 
	 * @Description: 根据contentSerialId删除数据
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public int deleteMkContentdetailInfoByCotentSerialId(String contentSerialId) {
		return baseDao.delete("MkContentdetailInfo.deleteMkContentdetailInfoByCotentSerialId", contentSerialId);
	}
	
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
	@Override
	public List selectParameterFee(Map map) {
		return baseDao.queryForList("MkContentdetailInfo.selectParameterFee", map);
	}

	
}
