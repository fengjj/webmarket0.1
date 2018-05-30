package com.sitech.market.dbo.common.inter;


import java.util.List;
import java.util.Map;

public interface IMkChngroupDict{
    @SuppressWarnings("unchecked")
	public Map queryChngroupDictInfo(Map map);
    public List  queryOrgByParentId(Map map);
    
    /**
     * Create on 2015-5-30 
     * @author: gengws
     * @Title: selectMkChngroupDict 
     * @Description:通过Id查询
     * @param inMap
     * @return 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */
    public List selectMkChngroupDictById(Map inMap);
	
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
	public Map selectMkChngroupDictByIdFirst(Map inMap);
	/**
	 * Create on 2015-8-4 
	 * @author: chihb
	 * @Title: queryMkChngroupDict 
	 * @Description: 查询Mk_chngroup_dict、mk_chngroup_rel、mk_actrecord_info
	 * @param 
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public Map queryMkChngroupDict(String group_id);
	
	/**
	 * Create on Aug 29, 2015 
	 * @author:zhaoyue
	 * @Title: queryMkChngroupDict 
	 * @Description: 
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List queryMkChngroupDict(Map map);
}
