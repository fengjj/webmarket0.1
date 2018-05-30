package com.sitech.market.dbo.destribution.impl;

import java.util.Map;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dbclass.DBServiceClass;
import com.sitech.market.dbo.destribution.inter.ICompGroupTreeDBO;
import com.sitech.util.CommonUtil;
import com.sitech.util.MBeanUtil;
import com.sitech.util.SitechClient;
import com.sitech.util.SvcConst;

/**
 * Create on 2015-4-7
 * @author: dongyh
 * @Title: ICompGroupTreeDBO
 * @Description： 查询组织树
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class CompGroupTreeDBO extends DBServiceClass implements
		ICompGroupTreeDBO {

	/**
	 * Create on 2015-4-7 
	 * @author: dongyh
	 * @Title: queryGroupTree 
	 * @Description: 获取工号组织结构查询组织树
	 * @param inParam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public Map queryGroupTree(Map inParam) {
		MBean bean = new MBean();
		MBeanUtil.setMapToBody(bean, inParam);
		
		String url = SvcConst.IGroupMngSvc_getGroupTree;
		String result =  SitechClient.callService(url,bean.toString());
		return CommonUtil.getSvcOutDataMap(result);
	}

}
