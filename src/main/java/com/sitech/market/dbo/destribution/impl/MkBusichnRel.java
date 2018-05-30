package com.sitech.market.dbo.destribution.impl;

import java.util.List;
import java.util.Map;

import com.sitech.jcf.core.exception.BaseException;
import com.sitech.jcf.core.exception.BusiException;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkBusichnRel;
import com.sitech.util.MBeanUtil;

public class MkBusichnRel extends DBMysqlClass implements IMkBusichnRel {

	/**
	 * Create on 2015-4-21 
	 * @author: yugl
	 * @Title: queryBusiIdByChnType 
	 * @Description: 查询业务的渠道
	 * @param paramMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List<Map> queryBusiIdByChnType(Map paramMap) {
		return baseDao.queryForList("MkBusichnRel.selectBusiIdByChnType", paramMap);
	}

	@Override
	public List<Map> selectBusiIdWithoutChn(Map paramMap) {
	    return baseDao.queryForList("MkBusichnRel.selectBusiIdWithoutChn", paramMap);
	}
	
	/**
	 * Create on 2015-4-21 
	 * @author: yugl
	 * @Title: queryChnByMeansId 
	 * @Description: 查询营销方式所属渠道
	 * @param paramMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List<Map> selectChnByBusiId(Map paramMap) {
		return baseDao.queryForList("MkBusichnRel.selectChnByBusiId",paramMap);
	}
	
	/**
	 * Create on 2015-5-4 
	 * @author: yugl
	 * @Title: deleteBusichnRel 
	 * @Description: 删除渠道关系表数据
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void deleteMkBusichnRelByBusiId(Map map) {
	    baseDao.delete("MkBusichnRel.deleteMkBusichnRelByBusiId", map);
	}
	
	/**
	 * Create on 2015-5-4 
	 * @author: yugl
	 * @Title: batchInsertMkBusichnRel 
	 * @Description: 批量保存业务区域信息
	 * @param list 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void batchInsertMkBusichnRel(List<Map> list) {
		baseDao.batchInsert("MkBusichnRel.insertMkBusichnRel", list);
	}
	
	/**
	 * Create on 2015-5-8 
	 * @author: yugl
	 * @Title: selectBusiChnTypeName 
	 * @Description: 查询业务渠道名称
	 * @param paramMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List<Map> selectBusiChnTypeName(Map paramMap) {
		return baseDao.queryForList("MkBusichnRel.selectBusiChnTypeName",paramMap);
	}
	
	/**
	 * 查询业务关系表
	 * Create on 2015-5-22 
	 * @author: wangdw
	 * @Title: selectMkBusichnRel 
	 * @Description: 
	 * @param paramMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List selectMkBusichnRel(Map paramMap) {
		return baseDao.queryForList("MkBusichnRel.selectMkBusichnRel",paramMap);
	}
	
	/**
	 * 根据busiId更新busiId
	 * Create on 2015-5-26 
	 * @author: wangdw
	 * @Title: updateMkBusichnRelForBusiId 
	 * @Description: 
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void updateMkBusichnRelForBusiId(Map map) {
		baseDao.update("MkBusichnRel.updateMkBusichnRelForBusiId", map);
	}
	
	/**
	 * 根据busiId更新chnStatus
	 * Create on 2015-6-8 
	 * @author: wangdw
	 * @Title: updateStatusByBusiId 
	 * @Description: 
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void updateStatusByBusiId(Map map) {
		baseDao.update("MkBusichnRel.updateStatusByBusiId", map);
	}
}
