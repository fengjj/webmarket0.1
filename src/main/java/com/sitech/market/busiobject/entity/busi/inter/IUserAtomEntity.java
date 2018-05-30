package com.sitech.market.busiobject.entity.busi.inter;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
/**用户实体抽象类
 * create on 2014-11-05
 * @author sunliang
 */
public interface IUserAtomEntity {
	/**通过phone_no查出id_no
	 * create on 2014-11-05
	 * @author sunliang
	 */
	public String getIdNoByPhoneNo(String phoneNo);
	
	/**查出用户参加活动的订购信息（已定购次数、灰名单标识）
	 * create on 2014-11-05
	 * @author sunliang
	 */
	public List<Map> getOrderCountByUser(Map inParam);
	
	/**查出用户所属的客户群
	 * create on 2014-11-05
	 * @author lixd_bj
	 */
	public Map getCustGroupIdByUser(String idNo);

	
	/**
     * 根据主键查询用户参加活动的数量
     * Create on 2014-11-24
     * @author zhaiwt
     * @version 1.0
     * Copyright(c) 北京思特奇信息技术股份有限公司
     * 修改日期:     修改人:     修改目的:
     */
	public JSONObject getUserOrderNum(Map inMap);

	/** 
	  * 向MK_USERORDERNUM_INFO表中增加营销业务订购次数
	  * Create on 2014-10-22 
	  * @author zhaiwt
	  * @version 1.0
	  * Copyright(c) 北京思特奇信息技术股份有限公司
	  * 修改日期:     修改人:     修改目的:
	  */
	public boolean insertUserOrderNum(Map inMap)throws Exception;

	/** 
	  * 回滚MK_USERORDERNUM_INFO表中营销业务订购次数
	  * Create on 2014-11-25 
	  * @author zhaiwt
	  * @version 1.0
	  * Copyright(c) 北京思特奇信息技术股份有限公司
	  * 修改日期:     修改人:     修改目的:
	  */
	public void rollbackUserOrderNum(Map inMap);
	
	/**
	 * 查询用户订购记录，返回Map，方便查询活动列表时数据处理
	 * 
	 * @param inParam
	 * @return returnMap
	 */
	public Map getUserOrderInfo(Map inParamMap);
	
	public void isPhoneNoExist(List phoneList);
	
	/**
	 * Create on 2015-5-30 
	 * @author: gengws
	 * @Title: queryUserByPhoneNo 
	 * @Description: 查询mk_phone_info,mk_user_info,mk_chngroup_dict,mk_codename_dict等所有数据
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public Map queryUserByPhoneNo(Map inMap);
	
	/**
	 * Create on 2015-7-8 
	 * @author:zhaoyue
	 * @Title: queryUserInfoByPhoneNo 
	 * @Description: 根据phoneNo查询用户标签
	 * @param phoneNo
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public Map queryLabelInfoByIdNo(Map inMap);
	
	/**
	 * Create on Aug 3, 2015 
	 * @author:zhaoyue
	 * @Title: queryLabelInfo 
	 * @Description: 查询用户标签数据，返回结果全为驼峰式。
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public Map queryLabelInfo(Map inMap);
	
	/**
	 * Create on 2015-8-11 
	 * @author:jiaxla
	 * @Title: queryUserContractByPhoneNo 
	 * @Description: 根据手机号查询用户账户
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public Map queryUserContractByPhoneNo(Map inMap);
	
}
