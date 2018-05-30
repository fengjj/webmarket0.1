package com.sitech.market.atom.common.inter;

import com.sitech.jcfx.dt.in.InDTO;
import com.sitech.jcfx.dt.out.OutDTO;

/**
 * 公共信息读取原子服务
 * Create on 2015-5-6 
 * @author: wangdw
 * @Title: IAtomCommon 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface IAtomCommon {

	/**
	 * 获得mk_codename_dict表信息
	 * Create on 2015-5-6 
	 * @author: wangdw
	 * @Title: queryCodeName 
	 * @Description: 
	 * @param inDTO
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO queryCodeName(InDTO inDTO);
	/**
	 * Create on 2015-6-16
	 * @author:jiaxla
	 * @Title: 分页标签查询
	 * @Description:
	 * @return
	 * version 1.0
	 * update_date:            update_author:              update_note
	 */
	public OutDTO queryForPagingList(InDTO inDTO);
}
