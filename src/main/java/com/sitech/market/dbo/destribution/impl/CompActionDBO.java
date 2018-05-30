package com.sitech.market.dbo.destribution.impl;

import java.util.List;
import java.util.Map;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dbclass.DBServiceClass;
import com.sitech.market.dbo.destribution.inter.ICompActionDBO;
import com.sitech.util.MBeanUtil;
import com.sitech.util.ParamUtil;
import com.sitech.util.SitechClient;
import com.sitech.util.SvcConst;

public class CompActionDBO extends DBServiceClass implements ICompActionDBO {

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
	@Override
	public Map getInitPageData(Map map){
		String servName = "com_sitech_market_atom_destribution_inter_IAtomInitPageDataSvc_getInitPageData";
		MBean bean = new MBean();
		MBeanUtil.setMapToBody(bean, map);
		String result = SitechClient.callService(servName,bean.toString());
		bean = new MBean(result);
		return MBeanUtil.setBodyToMap(bean);
	}
	
	/**
	 * Create on 2015-4-25 
	 * @author: dongyh
	 * @Title: queryAllActType 
	 * @Description: 加载页面活动类型菜单
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public Map queryAllActType(Map map){
		MBean bean = new MBean();
		map = (Map)ParamUtil.parseHump2Capital(map);
		MBeanUtil.setMapToBody(bean, map);
		String result = SitechClient.callService(SvcConst.AtomActionSvc_queryAllActType,bean.toString());
		bean = new MBean(result);
		return map = MBeanUtil.setBodyToMap(bean);
	}

	/**
	 * Create on 2015-5-18 
	 * @author: dongyh
	 * @Title: queryApprover 
	 * @Description: 查询审批人
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List<Map> queryApprover(Map inMap){
		MBean bean = new MBean();
		bean.addBody("REGION_CODE", inMap.get("regionCode"));
    	bean.addBody("AUDIT_LEVEL", inMap.get("auditLevel"));
    	bean.addBody("PROVINCE_GROUP", inMap.get("provinceGroup"));
    	bean.addBody("BUSI_TYPE", inMap.get("busiType"));
    	bean.addBody("BUSI_CLASS", inMap.get("busiClass"));
    	bean.addBody("CLASS_VALUE", inMap.get("classValue"));
    	String result = SitechClient.callService(SvcConst.AtomAuditSvc_queryApprover,bean.toString());
    	bean = new MBean(result);
    	List<Map> list = (List<Map>) bean.getBodyList("OUT_DATA.AUDIT_LEVEL_LIST");
		return (List<Map>) ParamUtil.parseCapital2Hump(list);
	}
	
	/**
	 * Create on 2015-5-18 
	 * @author: dongyh
	 * @Title: queryReleasePhone 
	 * @Description: 查询预发布号码
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List<Map> queryReleasePhone(Map inMap){
		MBean bean = new MBean();
		bean.addBody("REGION_CODE", inMap.get("regionCode"));
		bean.addBody("BUSI_TYPE", inMap.get("busiType"));
		String result = SitechClient.callService(SvcConst.AtomActionSvc_queryReleasePhone,bean.toString());
    	bean = new MBean(result);
    	List<Map> list = (List<Map>) bean.getBodyList("OUT_DATA.REGIONMNGR_INFO_LIST");
		return (List<Map>) ParamUtil.parseCapital2Hump(list);
	}
	/**
	 * 保存发布
	 * Create on 2015-6-12 
	 * @author: wangdw
	 * @Title: saveRelease 
	 * @Description: 
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public Map saveRelease(Map inMap) {
		MBean bean = new MBean();
		inMap = (Map)ParamUtil.parseHump2Capital(inMap);
		MBeanUtil.setMapToBody(bean, inMap);
		String result = SitechClient.callService(SvcConst.AtomActionSvc_saveRelease,bean.toString());
		bean = new MBean(result);
		Map outMap = MBeanUtil.setBodyToMap(bean);
		return outMap;
	}
}
