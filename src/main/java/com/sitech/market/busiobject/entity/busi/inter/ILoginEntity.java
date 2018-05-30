package com.sitech.market.busiobject.entity.busi.inter;

import java.util.Map;

import com.sitech.jcfx.dt.MBean;

/**
 * 
* Create on 2015-4-2
* @author: dongyh
* @Title: ILoginEntity
* @Description： 登录操作业务实体
* @version 1.0 
* update_data:      update_author:      update_note:
 */
public interface ILoginEntity {

    /**
     * 根据工号查岗位
     * 
     *  Create on 2014-10-29 上午11:09:00
     * @author tianyy_bj
     * @version 1.0
     * Copyright(c) 北京思特奇信息技术股份有限公司
     * 功能描述：根据工号查岗位
     * 修改日期:     修改人:     修改目的:
     */
    public MBean queryPositionIdByLoginNo(MBean bean);
	/**
	 * 
	* Create on 2015-4-2 
	* @author: dongyh
	* @Title: queryLoginInfoByPositionId 
	* @Description: 根据岗位查工号信息
	* @param inMap
	* @return 
	* @version 1.0 
	* update_data:       update_author:       update_note:
	 */
	public Map queryLoginInfoByPositionId(Map inMap);
	/**
	 * 登陆验证
	 *  Create on 2015-3-23
	 * @author tianyy_bj
	 * @version 1.0
	 * @Title: queryLoginInfo 
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param bean
	 * @param @return
	 * @return Map
	 * @throws
	 * 修改日期:     修改人:     修改目的:
	 */
	public Map queryLoginInfo(Map bean);
	
	/**
	 * Create on 2015-5-30 
	 * @author: gengws
	 * @Title: getLoginMsg 
	 * @Description: 根据工号查询基本信息
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public Map getLoginMsg(Map inMap);
}
