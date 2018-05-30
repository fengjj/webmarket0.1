package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

/**
 * Create on 2015-5-28 
 * @author: yugl
 * @Title: IMkContentprodInfo 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface IMkContentprodInfo {
	/**
	 * Create on 2015-5-27
	 * @author: yugl
	 * @Title: selectMkContentInfo 
	 * @Description: 查询产品内容表
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectMkContentprodInfo(Map map);
	
	/**
	 * Create on 2015-6-4 
	 * @author: yugl
	 * @Title: selectMkContentprodInfoById 
	 * @Description: 根据主键查询
	 * @param serialId
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public Map selectMkContentprodInfoById(String serialId);
	/**
	 * Create on 2015-6-6
	 * @author: zhangchen
	 * @Title: insertMkContentprodInfo 
	 * @Description: 插入数据
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void insertMkContentprodInfo(Map map) ;
	/**
	 * Create on 2015-9-9 
	 * @author: dongyh
	 * @Title: insertBatchMkContentprodInfo 
	 * @Description: 批量插入
	 * @param list 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void insertBatchMkContentprodInfo(List<Map> list);
	/**
	 * Create on 2015-6-6
	 * @author: zhangchen
	 * @Title: updateMkContentprodInfo 
	 * @Description: 更新数据
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public int updateMkContentprodInfo(Map map) ;
	
	/**
	 * Create on 2015-6-29
	 * @author: lixd_bj
	 * @Title: updateMkContentprodInfoBySerialId 
	 * @Description: 更新数据
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public int updateMkContentprodInfoBySerialId(Map map) ;
	
	/**
	 * Create on 2015-6-6
	 * @author: zhangchen
	 * @Title: deleteMkContentprodInfoById 
	 * @Description: 删除数据
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public int delInfoById(Map map) ;
	
	/**
	 * Create on 2015-6-6
	 * @author: jiaxla
	 * @Title: deleteMkContentprodInfoByContentSerialId 
	 * @Description: 删除数据
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public int deleteMkContentprodInfoByContentSerialId(String contentSerialId) ;
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
