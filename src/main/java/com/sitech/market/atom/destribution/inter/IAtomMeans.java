package com.sitech.market.atom.destribution.inter;

import com.sitech.jcfx.dt.in.InDTO;
import com.sitech.jcfx.dt.out.OutDTO;
/**
 * 
 * Create on 2015-3-24 
 * @author: tianyy_bj
 * @Title: IAtomMeans
 * @Description：档次相关服务接口
 * @version 1.0  
 * update_data:     update_author:     update_note:
 */
public interface IAtomMeans {
	
    /**
     * Create on 2015-5-30 
     * @author: fengjj
     * @Title: getMeanSIdByActId 
     * @Description: 根据busi_id查询内容列表
     * @param inparam
     * update_data:       update_author:       update_note:
     */
    public OutDTO getContentsByBusiId(InDTO inparam);
	/**
	 * Create on 2015-5-30 
	 * @author: gengws
	 * @Title: getMeanSIdByActId 
	 * @Description: 根据ACT_ID查询MEANS_ID
	 * @param inparam
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO getMeansIdByActId(InDTO inparam);
	
	/**
	 * Create on 2015-6-04 
	 * @author: gengws
	 * @Title: saveMeansBasic 
	 * @Description: 保存档次基本信息
	 * @param inparam
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO saveMeansBasic(InDTO inparam);
	
	/**
	 * Create on 2015-6-4 
	 * @author: qijh
	 * @Title: delBusiMeansRuleRel 
	 * @Description: 删除档次信息
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO delBusiMeansRuleRel(InDTO inparam);
	
	/**
	 * Create on 2015-6-4 
	 * @author: qijh
	 * @Title: copyMeansBymeansId 
	 * @Description: 复制档次信息
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO copyMeansBymeansId(InDTO inparam);
	
	/**
	 * Create on 2015-6-4 
	 * @author: qijh
	 * @Title: delBusicontentRel 
	 * @Description: 删除活动和内容关系
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO delBusicontentRel(InDTO inparam);
	/**
	 * Create on 2015-8-11 
	 * @author: zhangchen
	 * @Title: getRuleclassList 
	 * @Description: 获取档次规则大类列表
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO getRuleclassList(InDTO inparam);

}
