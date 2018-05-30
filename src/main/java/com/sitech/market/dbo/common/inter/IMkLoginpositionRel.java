package com.sitech.market.dbo.common.inter;

import java.util.List;
import java.util.Map;

/**
 * 
* Create on 2015-4-2
* @author: dongyh
* @Title: IMkLoginpositionRel
* @Description： 工号信息
* @version 1.0 
* update_data:      update_author:      update_note:
 */
public interface IMkLoginpositionRel {

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
	public List<Map> queryLoginInfoByPositionId(String positionId);

	public List<Map> queryPositionIdByLoginNo(Map bean);
}
