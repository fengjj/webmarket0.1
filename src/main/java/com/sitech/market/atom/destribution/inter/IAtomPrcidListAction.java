package com.sitech.market.atom.destribution.inter;

import com.sitech.jcfx.dt.in.InDTO;
import com.sitech.jcfx.dt.out.OutDTO;

/**
 * Create on 2015-7-23
 * @author: 
 * @Title: IAtomPrcidListAction
 * @Description：套餐列表查询原子服务
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface IAtomPrcidListAction {
	
	/**
	 * Create on 2015-7-23 
	 * @author: 
	 * @Title: queryPrcidList 
	 * @Description: 查询套餐列表
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO queryPrcidList(InDTO inparam);
	/**
	 * Create on 2015-7-31
	 * @author: 
	 * @Title: addPrcidInfo 
	 * @Description: 按地市配置套餐
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO addPrcidInfo(InDTO inparam);
	
	/**
	 * Create on 2015-8-1
	 * @author: 
	 * @Title: savePrcidInfo 
	 * @Description: 按地市配置套餐
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO savePrcidInfo(InDTO inparam);
	/**
	 * Create on 2015-8-1
	 * @author: 
	 * @Title: delPrcidInfo 
	 * @Description: 删除套餐
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO delPrcidInfo(InDTO inparam);
}
