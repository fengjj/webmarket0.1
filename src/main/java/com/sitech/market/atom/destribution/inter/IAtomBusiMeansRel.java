package com.sitech.market.atom.destribution.inter;

import com.sitech.jcfx.dt.in.InDTO;
import com.sitech.jcfx.dt.out.OutDTO;

/**
 * 
 * Create on 2015-3-24 
 * @author: tianyy_bj
 * @Title: IAtomMeans
 * @Description：档次活动对应关系相关服务接口
 * @version 1.0  
 * update_data:     update_author:     update_note:
 */
public interface IAtomBusiMeansRel {
	
	/**
	 * Create on 2015-6-04 
	 * @author: gengws
	 * @Title: saveMeansBasic 
	 * @Description: 保存档次活动关系信息
	 * @param inparam
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO saveBusiMeansRel(InDTO inparam);
}
