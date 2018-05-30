package com.sitech.market.atom.destribution.inter;

import com.sitech.jcfx.dt.in.InDTO;
import com.sitech.jcfx.dt.out.OutDTO;

/**
 * 
 * Create on 2015-6-6 
 * @author: liuhaoa
 * @Title: IAtomCustGroup 
 * @Description
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface IAtomCustGroup {
	
	/**
	 * Create on 2015-6-6 
	 * @author: liuhaoa
	 * @Title: queryList 
	 * @Description: 目标客户群查询
	 * @param inDTO
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */	
	public OutDTO queryList(final InDTO inDTO);
	
	/**
	 * Create on 2015-6-8
	 * @author: liuhaoa
	 * @Title: insertCustGroupInfo 
	 * @Description: 目标客户群生成
	 * @param inDTO
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */	
	public OutDTO insertCustGroupInfo(final InDTO inDTO);
	
	/**
	 * @author: liuhaoa
	 * @Title: deleteCustGroupInfo
	 * @Description:删除目标客户群明细
	 * @return 
	 * @version 1.0 
	 * date:2015-6-8
	 */
	public OutDTO deleteCustGroupInfo(final InDTO inDTO);
	
	/**
	 * @author: liuhaoa
	 * @Title: addCustGroupDetail
	 * @Description:生成目标客户群ID
	 * @return 
	 * @version 1.0 
	 * date:2015-6-8
	 */
	public OutDTO addCustGroupDetail(final InDTO inDTO);

	/**
	 * 保存附件客户群
	 * @Create on 2015-7-28 
	 * @author: wangdw
	 * @Title: saveFileCustGroup 
	 * @Description: 
	 * @param inDTO
	 * @return 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	public OutDTO saveFileCustGroup(InDTO inDTO) ;
	
	
    /**
     * @Create on 2016-5-3
     * @author: zhaojie
     * @Title: updateCustGroupInfo
     * @Description: 
     * @return 
     * @version 1.0 
     * update_date:       update_author:       update_note:
     */
	public OutDTO updateCustGroupInfo(InDTO inDTO);
}
