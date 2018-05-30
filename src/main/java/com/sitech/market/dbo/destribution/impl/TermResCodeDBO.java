package com.sitech.market.dbo.destribution.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sitech.jcf.core.exception.BusiException;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.ITermResCodeDBO;
import com.sitech.util.Const;
import com.sitech.util.MBeanUtil;
import com.sitech.util.SitechClient;

public class TermResCodeDBO extends DBMysqlClass implements ITermResCodeDBO{
    
    /**
     * 调用资源服务，查询终端型号列表
     * Create on 2015-01-28
     * @author dangzh
     * Copyright(c) 北京思特奇信息技术股份有限公司 
     */
    public List<Map> getTermResCodeList(Map bean) {
    	MBean aBean = new MBean();
    	aBean.addBody("OPR_INFO.LOGIN_NO",    "");
    	aBean.addBody("OPR_INFO.OP_CODE",     "4519");
    	aBean.addBody("OPR_INFO.OP_NOTE",     "");
    	aBean.addBody("OPR_INFO.LOGIN_ACCEPT","");
    	
    	aBean.addBody("BUSI_INFO.OP_TYPE",   bean.get("opType"));
    	aBean.addBody("BUSI_INFO.KIND_CODE", bean.get("kindCode"));
    	aBean.addBody("BUSI_INFO.BRAND_CODE",bean.get("brandId"));
    	aBean.addBody("BUSI_INFO.BRAND_NAME",bean.get("brandName"));
    	aBean.addBody("BUSI_INFO.RES_CODE",  bean.get("resCode"));
    	aBean.addBody("BUSI_INFO.RES_NAME",  bean.get("resName"));
    	aBean.addBody("BUSI_INFO.FIT_CODE",  bean.get("fitCode"));
    	aBean.addBody("BUSI_INFO.FIT_NAME",  bean.get("fitName"));
    	
    	
    	
    	log.info("开调调用资源接口查询终端信息！==========================================="+aBean.toString());
        String termResCodeListStr = SitechClient.callService("com_sitech_term_inter_ISQryTermResCodeInfoSvc_sQryTermResCodeInfo", aBean.toString());
        System.out.println("资源接口返回报文termResCodeListStr==============="+termResCodeListStr);
        MBean rbean = new MBean(termResCodeListStr);
        List getTermResCodeList = rbean.getBodyList("OUT_DATA.CODELIST");
        return getTermResCodeList;
    }
    
    /**
     *  
     * 
     * 
     * Copyright(c) 北京思特奇信息技术股份有限公司 
     */
    public Map getTermResCodeInfo(Map bean) {
		Map map = new HashMap();
    	return map;
    }

}
