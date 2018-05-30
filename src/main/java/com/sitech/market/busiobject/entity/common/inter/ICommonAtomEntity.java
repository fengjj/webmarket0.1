package com.sitech.market.busiobject.entity.common.inter;

import java.util.List;
import java.util.Map;

/**
 * 原子公共实体
 * Create on 2015-5-6 
 * @author: wangdw
 * @Title: ICommonAtomEntity 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface ICommonAtomEntity {

	/**
	 * 查询mk_codename_dict表信息
	 * Create on 2015-5-6 
	 * @author: wangdw
	 * @Title: queryCodeName 
	 * @Description: 
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public Map queryCodeName(Map map);
	
	/**
	 * 查询name值
	 * Create on 2015-5-18 
	 * @author: wangdw
	 * @Title: getCodeName 
	 * @Description: 根据table_en_name和filed_value查询mk_codename_dict表，获取name值。
	 * @param tableEnName
	 * @param filedValue
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public String getCodeName(String tableEnName, String filedValue, String provinceGroup);
	
	/**
	 * 查询业务关联信息
	 * Create on 2015-5-9 
	 * @author: wangdw
	 * @Title: queryBusiInfo 
	 * @Description: 业务关联关系，根据busiId和busiType查询相关业务信息。
	 * 比如：活动id+活动类型=查询活动业务信息。   方式id+方式类型=查询方式业务相关信息。
	 * @param elementId mk_element_dict表的element_id
	 * @param budiInMap 业务入参[busiId 业务id, busiType 业务类型]
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public Map queryBusiInfo(String elementId, Map budiInMap);
	
	/**
	 * Create on 2015-6-16
	 * @author:jiaxla
	 * @Title: pagelist6标签查询sql
	 * @Description:
	 * @return
	 * version 1.0
	 * update_date:            update_author:              update_note
	 */
	public Map queryForPagingList(Map inMap);
}
