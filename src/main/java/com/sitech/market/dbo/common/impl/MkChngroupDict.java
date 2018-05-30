package com.sitech.market.dbo.common.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sitech.jcf.core.exception.BaseException;
import com.sitech.jcf.core.exception.BusiException;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.common.inter.IMkChngroupDict;
import com.sitech.util.MBeanUtil;

public class MkChngroupDict extends DBMysqlClass implements IMkChngroupDict{

    /**
     * 查询mk_chngroup_dict
     * Create on 2015-02-03
     * @author zhouwy
     * @version 1.0 
     * Copyright(c) 北京思特奇信息技术股份有限公司 
     * 功能描述：mk_chngroup_dict
     * 修改日期: 修改人: 修改目的:
     */
	@Override
	public Map queryChngroupDictInfo(Map map) {
		Map resultMap = new HashMap();
    	try{
    		resultMap =(Map) baseDao.queryForObject("MkChngroupDict.selectMkChngroupDictById", map);
    	}catch(Exception e){
    		throw new BusiException("MkChngroupRel.selectMkChngroupRel", e + "报告大王，查询数据的时候出错了！");
    	}
		return resultMap;
	}
	
	/**
     * Create on 2014-07-14
     * @author fengjj
     * @version 1.0
     * Copyright(c) 北京思特奇信息技术股份有限公司
     * 功能描述：根据父节点查询下级组织机构列表
     * 如果parentid为null则查最顶级节点
     * 修改日期:     修改人:     修改目的:
     */
    public List  queryOrgByParentId(Map map){
        return baseDao.queryForList("MkChngroupDict.selectMkChnGroupForChild", map);
    }

    /**
     * Create on 2015-5-30 
     * @author: gengws
     * @Title: selectMkChngroupDict 
     * @Description: 通过Id查询
     * @param inMap
     * @return 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */
	@Override
	public List selectMkChngroupDictById(Map inMap) {
		List list=baseDao.queryForList("MkChngroupDict.selectMkChngroupDictById", inMap);
		return list;
	}
	
	/**
	 * 销售网点统一编码查询
	 * @Description：TODO
	 * @param @param inMap
	 * @param @return
	 * @return List
	 * @throws
	 * @author durui
	 * @date 2015-7-17
	 * @version v1.0
	 * update_date：      update_author：      update_note：
	 */
	@Override
	public Map selectMkChngroupDictByIdFirst(Map inMap) {
		Map resultMap = new HashMap();
    	resultMap =(Map) baseDao.queryForObject("MkChngroupDict.selectMkChngroupDictByIdFirst", inMap);
		return resultMap;
	}
	/**
	 * Create on 2015-8-4 
	 * @author: chihb
	 * @Title: queryMkChngroupDict 
	 * @Description: 查询Mk_chngroup_dict、mk_chngroup_rel、mk_actrecord_info
	 * @param serial_id
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public Map queryMkChngroupDict(String group_id)
	{
		Map inMap = new HashMap();
		inMap.put("group_id", group_id);
		Map resultMap = new HashMap();
		try {
				resultMap =(Map) baseDao.queryForObject("MkChngroupDict.queryMkChngroupDict",inMap);
		 } catch (Exception e) {
	            throw new BusiException("MkChngroupDict.queryMkChngroupDict", e
	                    + "查询数据的时候出错了！");
	        }
		return resultMap;
	}
	
	/**
	 * Create on Aug 29, 2015 
	 * @author: zhaoyue
	 * @Title: queryMkChngroupDict 
	 * @Description: 
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List queryMkChngroupDict(Map map) {
		List resultMap = new ArrayList();
		try {														
			resultMap = baseDao.queryForList("MkChngroupDict.selectMkChngroupDict",map);
	 } catch (Exception e) {
            throw new BusiException("MkChngroupDict.queryMkChngroupDict", e
                    + "查询数据的时候出错了！");
        }
		return resultMap;
	}

}
