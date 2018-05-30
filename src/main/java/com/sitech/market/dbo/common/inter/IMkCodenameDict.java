package com.sitech.market.dbo.common.inter;

import java.util.List;
import java.util.Map;

/**
 * Create on 2015-4-6 
 * @author: gengws
 * @Title: IMkCodenameDict 
 * @Description： MkCodenameDict表dbo
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface IMkCodenameDict {

	/**
     * Create on 2014-08-8
     * @author fengjj
     * @version 1.0
     * Copyright(c) 北京思特奇信息技术股份有限公司
     * 根据业务类型将数据重新压入缓存数据
     *修改日期: 2014-07-17	修改人:fengjj  修改目的:
     */
    public Map<String,Object> queryCodeName(Map<String,String> map);
    
 
    /**
     * Create on 2015-01-04
     * @author lixd_bj
     * @version 1.0
     * Copyright(c) 北京思特奇信息技术股份有限公司
     * 查询codeinfo最大值
     *修改日期: 2015-01-04	修改人:lixd_bj  修改目的:
     */
    public List queryCodenameMaxInfo(Map<String,String> map);
    
    /**
     * 查询编码表
     * @param
     * @author lixd_bj
     * Create on 2014-11-11
     */
    public List<Map> queryCodeNameList(Map map);
    
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
	public List<Map> selectParContent(Map map);
	
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
	public List<Map> selectMkCodenameDictOrderByValue(Map map);

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
	public List<Map> selectRuleClassFromMkCodenameDict(Map codeMap);
	
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
	public Map queryMkCodenameDictKindName(String inParam);
	
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
	public Map queryMkCodenameDictSupplyName(String inParam);
	
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
	public Map queryMkCodenameDictChnName(String inParam);
}
