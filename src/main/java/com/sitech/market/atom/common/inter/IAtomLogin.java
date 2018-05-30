package com.sitech.market.atom.common.inter;

import com.sitech.jcfx.dt.in.InDTO;
import com.sitech.jcfx.dt.out.OutDTO;


/**
 * 
* Create on 2015-4-2
* @author: dongyh
* @Title: IAtomLogin
* @Description： 登录信息原子服务
* @version 1.0 
* update_data:      update_author:      update_note:
 */
public interface IAtomLogin {

    
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
    public  OutDTO queryPositionIdByLoginNo(final InDTO inparam);
	/**
	 * 
	* Create on 2015-4-2 
	* @author: dongyh
	* @Title: queryLoginInfoByPositionId 
	* @Description: 根据岗位查工号信息
	* @param inparam
	* @return 
	* @version 1.0 
	* update_data:       update_author:       update_note:
	 */
	public OutDTO queryLoginInfoByPositionId(final InDTO inparam);

	/**
	 * 登陆验证
	 *  Create on 2015-3-23
	 * @author tianyy_bj
	 * @version 1.0
	 * @Title: loginIn 
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param inParam
	 * @param @return
	 * @return OutDTO
	 * @throws
	 * 修改日期:     修改人:     修改目的:
	 */
	public OutDTO loginIn(InDTO inParam);
	
	/**
	 * Create on 2015-5-30 
	 * @author: gengws
	 * @Title: getLoginMsg 
	 * @Description: 根据工号查询基本信息
	 * @param inDTO
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO getLoginMsg(InDTO inDTO);
}
