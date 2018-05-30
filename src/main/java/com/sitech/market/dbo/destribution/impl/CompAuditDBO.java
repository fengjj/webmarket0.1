package com.sitech.market.dbo.destribution.impl;

import java.util.List;
import java.util.Map;

import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dbclass.DBServiceClass;
import com.sitech.market.dbo.destribution.inter.ICompAuditDBO;
import com.sitech.util.CommonUtil;
import com.sitech.util.MBeanUtil;
import com.sitech.util.SitechClient;
import com.sitech.util.SvcConst;
/**
 * 
 * Create on 2015-4-1 
 * @author: tianyy_bj
 * @Title: CompAuditDBO
 * @Description：服务调用dbo实现层
 * @version 1.0  
 * update_data:     update_author:     update_note:
 */
public class CompAuditDBO extends DBServiceClass implements ICompAuditDBO {

	
	@Override
	public Map getUpLoginByGroup(Map inParam) {
		//将参数封装成服务需要的形式，即bean.toString()
		MBean bean = new MBean();
		MBeanUtil.setMapToBody(bean, inParam);
		//服务url
		String url = SvcConst.ILoginGroupSvc_getUpLoginByGroup;
		String result =  SitechClient.callService(url,bean.toString());
		return CommonUtil.getSvcOutDataMap(result);
	}

}
