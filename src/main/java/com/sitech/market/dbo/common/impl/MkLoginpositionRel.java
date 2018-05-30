package com.sitech.market.dbo.common.impl;

import java.util.List;
import java.util.Map;
import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.common.inter.IMkLoginpositionRel;

/**
 * 
* Create on 2015-4-2
* @author: dongyh
* @Title: MkLoginpositionRel
* @Description： 工号信息
* @version 1.0 
* update_data:      update_author:      update_note:
 */
public class MkLoginpositionRel extends DBMysqlClass implements
		IMkLoginpositionRel {

	/**
	 * 
	* Create on 2015-4-2 
	* @author: dongyh
	* @Title: queryLoginInfoByPositionId 
	* @Description: 查询工号信息
	* @param positionId
	* @return 
	* @version 1.0 
	* update_data:       update_author:       update_note:
	 */
	public List<Map> queryLoginInfoByPositionId(
			String positionId) {
		List<Map> loginList = baseDao.queryForList("MkLoginpositionRel.selectLoginInfoByPositionId",positionId);
		return loginList;
	}
	
	/**
	* 根据工号查岗位
	*  Create on 2014-11-13 下午5:12:38
	* @author tianyy_bj
	* @version 1.0
	* Copyright(c) 北京思特奇信息技术股份有限公司
	* 功能描述：
	* 修改日期:     修改人:     修改目的:
	*/
	@Override
	public List<Map> queryPositionIdByLoginNo(Map bean) {
        return baseDao.queryForList("MkLoginpositionRel.selectPositionIdByLginNo",bean);
}

}
