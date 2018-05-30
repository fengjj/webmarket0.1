package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

/**
 * Create on 2015-5-28 
 * @author: yugl
 * @Title: IMkContentticketInfo 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface IMkContentticketInfo {
	/**
	 * Create on 2015-5-27
	 * @author: yugl
	 * @Title: selectMkContentInfo 
	 * @Description: 查询券内容表
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectMkContentticketInfo(Map map);
	
	/**
	 * Create on 2015-6-4 
	 * @author: yugl
	 * @Title: selectMkContentticketInfoById 
	 * @Description: 根据主键查询
	 * @param serialId
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public Map selectMkContentticketInfoById(String serialId);

	/**
	 * Create on 2015-6-6
	 * @author: zhangchen
	 * @Title: insertMkContentticketInfo 
	 * @Description: 插入数据
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void insertMkContentticketInfo(Map map) ;
	/**
	 * Create on 2015-6-6
	 * @author: zhangchen
	 * @Title: updateMkContentticketInfo 
	 * @Description: 更新数据
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public int updateMkContentticketInfo(Map map) ;
	/**
	 * Create on 2015-6-6
	 * @author: zhangchen
	 * @Title: deleteMkContentticketInfoById 
	 * @Description: 删除数据
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public int delInfoById(Map map) ;
	/**
	 * Create on 2015-8-3
	 * @author: zhangchen
	 * @Title: insertInfo 
	 * @Description: 插入数据
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void insertInfo(Map map) ;
	/**
	 * Create on 2015-8-14
	 * @author: wangpei
	 * @Title: copyInfo 
	 * @Description: 复制数据
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void copyInfo(Map map) ;
}
