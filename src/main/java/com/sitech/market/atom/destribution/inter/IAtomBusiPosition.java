package com.sitech.market.atom.destribution.inter;

import com.sitech.jcfx.dt.in.InDTO;
import com.sitech.jcfx.dt.out.OutDTO;

public interface IAtomBusiPosition {

	
	/**
	 * Create on 
	 * @author: 
	 * @Title: getBusiPositionRel 
	 * @Description:获取运营位
	 * @param inparam
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO getBusiPositionRel(InDTO inparam);
	
	/**
	 * Create on 
	 * @author: 
	 * @Title: updateBusiPositionRel
	 * @Description:更新运营位
	 * @param inparam
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO updateBusiPositionRel(InDTO inparam);
	
}
