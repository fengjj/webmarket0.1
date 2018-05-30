package com.sitech.market.dbo.destribution.impl;

import java.util.Map;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dbclass.DBServiceClass;
import com.sitech.market.dbo.destribution.inter.ICompSearchDBO;
import com.sitech.util.CommonUtil;
import com.sitech.util.MBeanUtil;
import com.sitech.util.SitechClient;
import com.sitech.util.SvcConst;

/**
 * Create on 2015-4-8 
 * @author: wangdw
 * @Title: CompSearchDBO 
 * @Description： 查询DBO
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class CompSearchDBO extends DBServiceClass implements ICompSearchDBO {

	/**
	 * Create on 2015-4-8 
	 * @author: wangdw
	 * @Title: searchVagueFee 
	 * @Description: 资费模糊查询DBO
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public Map searchVagueFee(Map inMap) {
		MBean bean = new MBean();
		MBeanUtil.setMapToBody(bean, inMap);
		String url = SvcConst.IMarketPrcCataQryAoSvc_qryMarketPrcCata;
		String result = SitechClient.callService(url, bean.toString());
		return CommonUtil.getSvcOutDataMap(result);
	}

}
