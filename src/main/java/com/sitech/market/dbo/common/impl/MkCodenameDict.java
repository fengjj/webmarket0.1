package com.sitech.market.dbo.common.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sitech.cache.Cache;
import com.sitech.cache.CacheHelper;
import com.sitech.jcf.core.exception.BaseException;
import com.sitech.jcf.core.exception.BusiException;
import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.common.inter.IMkCodenameDict;

/**
 * Create on 2015-4-6 
 * @author: gengws
 * @Title: MkCodenameDict 
 * @Description： MkCodenameDict表dbo
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class MkCodenameDict extends DBMysqlClass implements IMkCodenameDict {
	public static final String GetRegion = "GetRegion";
	public static final String regionpartition = "mk_regionpartition_dict";
	public static final String region_part = "region_part";
	private Cache cache = CacheHelper.getInstance();

	/**
	 * Create on 2014-08-8
	 * 
	 * @author fengjj
	 * @version 1.0 Copyright(c) 北京思特奇信息技术股份有限公司 根据业务类型将数据重新压入缓存数据 修改日期:
	 *          2014-07-17 修改人:fengjj 修改目的:
	 */
	public Map<String, Object> queryCodeName(Map<String, String> map) {
		Map<String, Object> retmap = new HashMap<String, Object>();
		try {
			retmap.put("resultBean", baseDao.queryForList(
					"MkCodenameDict.selectMkCodenameDict", map));
		} catch (Exception e) {
			throw new BusiException("queryCodeName", "亲,query出异常了,到后台看看吧" + e);
		}
		return retmap;
	}

	/**
	 * 查询编码表
	 * 
	 * @param
	 * @author lixd_bj Create on 2014-11-11
	 */
	public List<Map> queryCodeNameList(Map map) {
		log.info(">>>>>>>>>>queryCodeNameList.map>>>>>>>>>>::::::::::"+map.toString());
		return baseDao.queryForList("MkCodenameDict.selectMkCodenameDict", map);
	}

	/**
	 * Create on 2015-01-04
	 * 
	 * @author lixd_bj
	 * @version 1.0 Copyright(c) 北京思特奇信息技术股份有限公司 查询codeinfo最大值 修改日期: 2015-01-04
	 *          修改人:lixd_bj 修改目的:
	 */
	public List queryCodenameMaxInfo(Map<String, String> map) {
		List list = new ArrayList();
		try {
			list = (List) baseDao.queryForList(
					"MkCodenameDict.selectMaxCommonInfo", map);
		} catch (Exception e) {
			throw new BaseException("MkCodenameDict.selectMaxCommonInfo",
					"亲,query出异常了,到后台看看吧");
		}
		return list;
	}

	
	/**
     * 查询fieldValue和fieldDesc
     * Create on 2015-6-8 
     * @author: wangdw
     * @Title: selectParContent 
     * @Description: 
     * @param map
     * @return 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */
	public List<Map> selectParContent(Map map) {
		log.info(">>>>>>>>>>MkCodenameDict.selectParContent>>>>>>>>>>::::::::::"+map.toString());
		return baseDao.queryForList("MkCodenameDict.selectParContent", map);
	}
	
	/**
     * 查询fieldValue和fieldDesc，并根据fieldValue排序
     * Create on 2015-6-8 
     * @author: lixd_bj
     * @Title: selectMkCodenameDictOrderByValue 
     * @Description: 
     * @param map
     * @return 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */
	public List<Map> selectMkCodenameDictOrderByValue(Map map) {
		log.info(">>>>>>>>>>MkCodenameDict.selectMkCodenameDictOrderByValue>>>>>>>>>>::::::::::"+map.toString());
		return baseDao.queryForList("MkCodenameDict.selectMkCodenameDictOrderByValue", map);
	}
	/**
	 * 
	* Create on Sep 5, 2015 
	* @author: qijh 
	* @Title: selectRuleClassFromMkCodenameDict 
	* @Description: 
	* @param codeMap
	* @return 
	* @version 1.0 
	* update_data: update_author: update_note:
	 */
	@Override
	public List<Map> selectRuleClassFromMkCodenameDict(Map codeMap) {
		// TODO Auto-generated method stub
		log.info(">>>>>>>>>>MkCodenameDict.selectRuleClassFromMkCodenameDict>>>>>>>>>>::::::::::"+codeMap.toString());
		return baseDao.queryForList("MkCodenameDict.selectRuleClassFromMkCodenameDict", codeMap);
	}
	
	/**
	 * Create on 2015-8-4 
	 * @author: chihb
	 * @Title: queryMkCodenameDictKindName 
	 * @Description: 查询Mk_resource_dict
	 * @param resource_code
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public Map queryMkCodenameDictKindName(String resource_code)
	{
		Map inMap = new HashMap();
		inMap.put("resource_code", resource_code);
		Map resultMap = new HashMap();
		try {
				resultMap =(Map) baseDao.queryForObject("MkCodenameDict.queryMkCodenameDictKindName",inMap);
		 } catch (Exception e) {
	            throw new BusiException("MkCodenameDict.queryMkCodenameDictKindName", e
	                    + "查询数据的时候出错了！");
	        }
		return resultMap;
	}

	/**
	 * Create on 2015-8-4 
	 * @author: chihb
	 * @Title: queryMkCodenameDictSupplyName 
	 * @Description: 查询Mk_codename_dict
	 * @param supply_id
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public Map queryMkCodenameDictSupplyName(String supply_id)
	{
		Map inMap = new HashMap();
		inMap.put("supply_id", supply_id);
		Map resultMap = new HashMap();
		try {
				resultMap =(Map) baseDao.queryForObject("MkCodenameDict.queryMkCodenameDictSupplyName",inMap);
		 } catch (Exception e) {
	            throw new BusiException("MkCodenameDict.queryMkCodenameDictSupplyName", e
	                    + "查询数据的时候出错了！");
	        }
		return resultMap;
	}
	
	/**
	 * Create on 2015-8-4 
	 * @author: chihb
	 * @Title: queryMkCodenameDictChnName 
	 * @Description: 查询Mk_codename_dict
	 * @param chn_type
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public Map queryMkCodenameDictChnName(String chn_type)
	{
		Map inMap = new HashMap();
		inMap.put("chn_type", chn_type);
		Map resultMap = new HashMap();
		try {
				resultMap =(Map) baseDao.queryForObject("MkCodenameDict.queryMkCodenameDictChnName",inMap);
		 } catch (Exception e) {
	            throw new BusiException("MkCodenameDict.queryMkCodenameDictChnName", e
	                    + "查询数据的时候出错了！");
	        }
		return resultMap;
	}
	
}
