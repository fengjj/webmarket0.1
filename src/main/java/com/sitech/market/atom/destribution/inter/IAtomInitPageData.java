package com.sitech.market.atom.destribution.inter;

import com.sitech.jcfx.dt.in.InDTO;
import com.sitech.jcfx.dt.out.OutDTO;

/**
 * Create on 2015-4-22 
 * @author: yugl
 * @Title: IAtomInitPage 
 * @Description： 策划活动页面初始化服务
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface IAtomInitPageData {
	
	/**
	 * Create on 2015-4-22 
	 * @author: yugl
	 * @Title: initPage 
	 * @Description: 
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO getInitPageData(final InDTO inparam);
	
}
