package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

/**
 * 内容dbo
 * Create on 2015-5-11 
 * @author: wangdw
 * @Title: IMkContentInfo 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface IMkContentfeeInfo {
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
	public List selectMkContentfeeInfo(Map map);
	
	/**
	 * Create on 2015-5-30 
	 * @author: yugl
	 * @Title: selectMkContentfeeInfoById 
	 * @Description: 
	 * @param serialId
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public Map selectMkContentfeeInfoById(String serialId);

	/**
	 * Create on 2015-6-6
	 * @author: zhangchen
	 * @Title: insertMkContentfeeInfo 
	 * @Description: 插入数据
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void insertMkContentfeeInfo(Map map) ;
	/**
	 * Create on 2015-6-6
	 * @author: zhangchen
	 * @Title: updateMkContentfeeInfo 
	 * @Description: 更新数据
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public int updateMkContentfeeInfo(Map map) ;
	/**
	 * Create on 2015-6-6
	 * @author: zhangchen
	 * @Title: deleteMkContentfeeInfoById 
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
	 * @Title: deleteMkContentfeeInfoByContentSerialId 
	 * @Description: 根据contentSerialId删除数据
	 * @param contentSerialId
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public int deleteMkContentfeeInfoByContentSerialId(String contentSerialId) ;
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
	public void insertInfo(Map map);
	/**
	 * Create on 2015-8-10
	 * @author: wangpei
	 * @Title: copyInfo 
	 * @Description: 复制数据
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void copyInfo(Map map);

}
