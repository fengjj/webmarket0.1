package com.sitech.market.dbo.common.inter;

import java.util.List;
import java.util.Map;

/**
 * 营销执行前台界面配置,元素内容表接口
 * Create on 2015-1-14
 * @author dongyh
 */
public interface IMkParcontentDict {
	
	public List<Map> selectMkParcontentDictByContentId(Map map);
	
	public List selectParContentInfo(Map inParam);

	/**
	 * 
	 * Create on 2015-3-25
	 * @author:tianyy_bj
	 * @Title: queryParContent
	 * @Description: 查询元素参数限定范围
	 * @param contentBean
	 * @return
	 * @return List
	 * @version 1.0
	 * update_data:     update_author:     update_note:
	 */
	public List queryParContent(Map contentBean);
	
	/**
	 * 
	 * Create on 2015-3-25
	 * @author:tianyy_bj
	 * @Title: queryParContentTrac
	 * @Description: TODO 
	 * @param contentBean
	 * @return
	 * @return List
	 * @version 1.0
	 * update_data:     update_author:     update_note:
	 */
	public List queryParContentTrac(Map contentBean);
}
