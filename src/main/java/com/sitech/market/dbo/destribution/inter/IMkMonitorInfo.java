package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

/**
 * 营销活动消息监控表
 * Create on 2016-5-1 
 * @author: fengjj
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface IMkMonitorInfo {

	public Object insertMkEventmonitorInfo(Map inMap);
	public List<Map> queryMonitorGBetype(Map inMap);
	public List<Map> queryMonitorGBtopic(Map inMap);
	public List<Map> queryMonitorGBeventId(Map inMap);
}
