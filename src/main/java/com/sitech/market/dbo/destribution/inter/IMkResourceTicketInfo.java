package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;
/**
 * Create on 2015-7-12
 * @author: zhangxfa
 * @Title: IMkResourceTicketInfo 
 * @Description： 资源记录表
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface IMkResourceTicketInfo{
	
	/**
	 * Create on 2015-7-11
	 * @author: zhangxfa	
	 * @Title: insertMkResourceTicketInfo
	 * @Description: 保存资源信息
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void insertMkResourceTicketInfo(Map map);
	
	/**
	 * 
	 * @param resource_id
	 * @return
	 */
	public Map selectResourceInfoById(String resource_id);
	
	/**
	 * Create on 2015-7-13
	 * @author: zhangxfa	
	 * @Title: updateMkResourceTicketInfo
	 * @Description: 更新资源信息
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void updateMkResourceTicketInfo(Map map);
	
	/**
	 * Create on 2015-7-13
	 * @author zhangxfa
	 * @Description 删除资源信息
	 * @param resource_id
	 * @return
	 */
	public void deleteResourceInfoById(Map map);
}
