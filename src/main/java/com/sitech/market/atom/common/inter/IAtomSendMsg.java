package com.sitech.market.atom.common.inter;

import com.sitech.jcfx.dt.in.InDTO;
import com.sitech.jcfx.dt.out.OutDTO;

/** 
 * Create on 2015-9-8 上午10:52:05
 * @author:  yangbao
 * @Title: IAtomSendMsg 
 * @Description：
 * @version 1.0 
 * update_data:      update_author:      update_note: 
 */
public interface IAtomSendMsg {

	/**
	 * 
	* Create on 2015-9-8 上午10:52:59
	* @author: yangbao
	* @Title: sendMessage 
	* @Description: 
	* @param inDTO
	* @return 
	* @version 1.0
	* Copyright(c) 北京思特奇信息技术股份有限公司 
	* update_data:       update_author:       update_note:
	 */
	public OutDTO sendMessage(InDTO inDTO);
	/**
	 * 
	* Create on 2015-9-8 下午07:35:02
	* @author: yangbao
	* @Title: call 
	* @Description: 
	* @param inDTO
	* @return 
	* @version 1.0
	* Copyright(c) 北京思特奇信息技术股份有限公司 
	* update_data:       update_author:       update_note:
	 */
	public OutDTO scanExpMsg(InDTO inDTO);
    /**
     * Create on 2015年9月16日
     * @author:fengjj
     * @Title: sendShortMessage
     * @Description: TODO 
     * @param inDTO
     * @return
     * @version 1.0
     * update_data:     update_author:     update_note:
     */
    OutDTO sendShortMessage(InDTO inDTO);
}
