package com.sitech.market.dbo.destribution.inter;

import java.util.Map;

/**
 * 
* Create on 2015-4-2
* @author: quyl
* @Title: IMkMeansInfo
* @Description： 营销方式
* @version 1.0 
* update_data:      update_author:      update_note:
 */
public interface IMkMeansAddInfo { 
	
	
	/**
	 * 根据主键查询营销方式 Create on 2015-01-5
	 * 
	 * @author yugl
	 * @version 1.0 Copyright(c) 北京思特奇信息技术股份有限公司 功能描述：根据主键查询营销方式 修改日期: 修改人:
	 *          修改目的:
	 */
	public Map selectMeansAddInfoById(Map meansId); 
	
	/**
	 * Create on 2015-7-27 
	 * @author: liuhaoa
	 * @Title: saveMeansAddInfo 
	 * @Description: 保存营销方式附加表
	 * @param inMap 
	 * @version 1.0 
	 * update_date:20150629       update_author: wangdw      update_note: 重新修改捆绑关系，原业务废弃。
	 */
	public void saveMeansAddInfo(Map inMap);
}
