package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

public interface IMkBusipositionInfo {
	/**
	 * Create on 2015-7-22 
	 * @author: 
	 * @Title: batchInsertBusipositionInfo 
	 * @Description: 批量保存档次与运营位关系信息
	 * @param paramMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void batchInsertMkBusipositionInfo(List<Map> list);
	/**
	 * Create on 2015-7-22
	 * @author: 
	 * @Title: deleteBusichnRel 
	 * @Description: 删除渠道关系表数据
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void deleteMkBusipositionInfo(Map map);
	
	public List selectBusipositionInfo(Map paraMap);
}
