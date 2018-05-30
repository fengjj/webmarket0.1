package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkActaddInfo;
/**
 * 营销业务订购次数表
 * Create on 2015-7-17
 * @author: qijh
 * @Title: MkBusiordernumInfo 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface IMkBusiordernumInfo {

	/**
	 * 计入营销业务订购次数表
	 * Create on 2015-7-17 
	 * @author: qijh
	 * @Title: MkBusiordernumInfo 
	 * @Description: 
	 * @param inMap 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void insertMkBusiordernumInfo(Map inMap);
	
	/**
	 * Create on 2015-5-17
	 * @author: qijh
	 * @Title: selectMkBusiordernumInfo 
	 * @Description: 查询营销业务订购次数根据业务id和类型
	 * @param actId
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	
	public List selectMkBusiordernumInfo(Map inMap);
	/**
	 * 更新营销业务订购次数
	 * Create on May 21, 2015 
	 * @author: qijh
	 * @Title: updateMkBusiordernumInfo 
	 * @Description: 
	 * @param inMap 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void updateMkBusiordernumInfo(Map inMap);
}
