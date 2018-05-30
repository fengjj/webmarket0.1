package com.sitech.market.dbo.common.impl;

import java.util.List;
import java.util.Map;

import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.common.inter.ICommonDBO;
import com.sitech.util.CommonUtil;
import com.sitech.util.MBeanUtil;
import com.sitech.util.SitechClient;
import com.sitech.util.SvcConst;

/**
 * Create on 2015-4-29 
 * @author: yugl
 * @Title: CommonDBO 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class CommonDBO extends DBMysqlClass implements ICommonDBO {

	/**
	 * 查询mk_codename_dict表
	 * Create on 2015-5-7 
	 * @author: wangdw
	 * @Title: queryCodeName 
	 * @Description: 
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public Map queryCodeName(Map inMap) {
		MBean bean = new MBean();
		MBeanUtil.setMapToBody(bean, inMap);
		String url = SvcConst.AtomCommonSvc_queryCodeName;
		String result =  SitechClient.callService(url,bean.toString());
		return CommonUtil.getSvcOutDataMap(result);
	}
	/**
	 * Create on 2015-4-29 
	 * @author: yugl
	 * @Title: queryListBySql 
	 * @Description: 
	 * @param sql ibatis的脚本配置xml文件里的namespace+脚本ID
	 * @param map 入参map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List queryListBySql(String sql,Map map) {
		return baseDao.queryForList(sql, map);
	}
	
	/**
	 * 调用公共组件服务
	 * Create on 2015-5-7 
	 * @author: wangdw
	 * @Title: getInitPageData 
	 * @Description: 
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public Map getInitPageData(Map inMap) {
		MBean bean = new MBean();
		MBeanUtil.setMapToBody(bean, inMap);
	   	String url = SvcConst.AtomInitPageDataSvc_getInitPageData;
	   	String result = SitechClient.callService(url, bean.toString());
	   	System.out.println("================result:"+result);
	   	MBean resultBean = new MBean(result);
	   	Map resultMap = (Map)resultBean.getBodyObject("OUT_DATA");
	   	return resultMap;
	}
	
	/**
	 * 标签查询list
	 * Create on 2015-5-7 
	 * @author: jiaxla
	 * @Title: queryForPagingList 
	 * @Description: 
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */	
	public Map queryForPagingList(Map inMap) {
		
		String sqlId = (String) inMap.get("sqlId");
		Map sqlParam = (Map) inMap.get("sqlParam");
		int start = (Integer) inMap.get("startNum");
		int limit = (Integer) inMap.get("limitNum");
		
		Map ret = null;
		try {
			ret =baseDao.queryForPagingList(sqlId, sqlParam, start, limit);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List a = (List) ret.get("result");
		int b = (Integer) ret.get("sum");
		return ret;
	}
}
