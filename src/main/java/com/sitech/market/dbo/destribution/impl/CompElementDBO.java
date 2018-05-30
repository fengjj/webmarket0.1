package com.sitech.market.dbo.destribution.impl;

import java.util.Map;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dbclass.DBServiceClass;
import com.sitech.market.dbo.destribution.inter.ICompElementDBO;
import com.sitech.util.MBeanUtil;
import com.sitech.util.SitechClient;

public class CompElementDBO extends DBServiceClass implements ICompElementDBO {
	
	/**
	 * Create on 2015-4-23 
	 * @author: yugl
	 * @Title: initDestributionPage 
	 * @Description: 初始化活动策划页面
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public Map queryElements(Map map){
		String servName = "com_sitech_market_atom_trading_inter_IAtomShowInfoSvc_queryExeElements";
		MBean bean = new MBean();
		MBeanUtil.setMapToBody(bean, map);
		String result = SitechClient.callService(servName,bean.toString());
		bean = new MBean(result);
		return MBeanUtil.setBodyToMap(bean);
	}

}
