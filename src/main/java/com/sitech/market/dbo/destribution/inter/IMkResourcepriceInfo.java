package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

/**       
 * Create on 2015-6-6
 * @author: songxj
 * @Title: IMkResourcepriceInfo
 * @Description：
 * @version 1.0  
 * update_data:     update_author:     update_note:    
 */
public interface IMkResourcepriceInfo {
	
	/** 
	 * Create on 2015-6-6 
	 * @author: songxj
	 * @Title: selectMkContentInfoById 
	 * @Description: 根据主键查询资源价格表
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note: 
	 */
	public Map selectMkResourcepriceInfoById(Map map);
	
	/** 
	 * Create on 2015-6-6 
	 * @author: songxj
	 * @Title: selectMkContentInfo 
	 * @Description: 查询资源价格表
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note: 
	 */
	public List selectMkResourcepriceInfo(Map map);
	
	/**
	 * 批量插入
	 * @Create on 2015-6-29 
	 * @author: wangdw
	 * @Title: insertBatchMkResourcepriceInfo 
	 * @Description: 
	 * @param list 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	public void insertBatchMkResourcepriceInfo(List<Map> list);
	
	/**
	 * Create on 2015-9-11 
	 * @author: dongyh
	 * @Title: insertMkResourcepriceInfo 
	 * @Description: 插入
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void insertMkResourcepriceInfo(Map map);
	
	/**
	 * Create on 2015-9-13 
	 * @author: dongyh
	 * @Title: selectMkResourcepriceInfoByTermi 
	 * @Description: 插查终端品牌和价钱
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public Map selectMkResourcepriceInfoByTermi(Map map);
}
