package com.sitech.market.atom.destribution.inter;

import com.sitech.jcfx.dt.in.InDTO;
import com.sitech.jcfx.dt.out.OutDTO;

public interface IAtomChannel {
	
	/**
	 * Create on 2015-5-4 
	 * @author: yugl
	 * @Title: saveChannel 
	 * @Description: 保存渠道信息
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO saveChannel(InDTO inparam);
	/**
	 * Create on 2015-6-1 
	 * @author: yugl
	 * @Title: saveChnRel 
	 * @Description: 单个业务的渠道关系保存
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO saveChnRel(InDTO inparam);
	
	public OutDTO queryChnRule(InDTO inparam);
}
