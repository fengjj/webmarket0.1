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
public interface IAtomRule { 
	
	/**
	 * Create on 2015-5-11 
	 * @author: yugl
	 * @Title: getRuleitem 
	 * @Description: 查询获取规则明细和明细的内容
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO getRuleitem(InDTO inparam);
	
	/**
	 * Create on 2015-5-19 
	 * @author: yugl
	 * @Title: getRuleByType 
	 * @Description: 根据规则大类，小类查询规则
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO getRuleByType(InDTO inparam);
	
	/**
	 * Create on 2015-5-23
	 * @author: yugl
	 * @Title: saveBusiRule 
	 * @Description: 保存营销规则业务关系表
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO saveBusiRule(InDTO inparam);
	
	/**
	 * Create on 2015-6-4
	 * @author: qijh
	 * @Title: delBusiRuleRel 
	 * @Description: 删除营销规则业务关系表
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO delBusiRuleRel(InDTO inparam);

	
	/**
	 * Create on 2015-6-17
	 * @author: xiongxin
	 * @Title:  queryBusiRuleContent
	 * @Description: 查询规则内容信息表
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO queryBusiRuleContent(InDTO inparam);
	
	/**
	 * Create on 2015-6-16 
	 * @author: yugl
	 * @Title: saveRule 
	 * @Description: 保存规则信息
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO saveRule(InDTO inparam);
	
	/**
	 * Create on 2015-6-17 
	 * @author: yugl
	 * @Title: delRuleItem 
	 * @Description: 根据itemId删除规则明细
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO delRuleItem(InDTO inparam);


	/**
	 * Create on 2015-6-18 
	 * @author: lixd_bj
	 * @Title: delRuleInfo 
	 * @Description: 根据关系流水及规则流水删除规则关系信息、规则信息及明细
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO delRuleInfo(InDTO inparam);

	/**
	 * Create on 2015-7-25 
	 * @author: nidw
	 * @Title: saveBasicRuleInfo 
	 * @Description: 保存规则基本信息
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO saveBasicRuleInfo(InDTO inparam);

	/**
	 * Create on 2015-7-25 
	 * @author: nidw
	 * @Title: delBasicRuleInfo 
	 * @Description: 删除规则信息
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO delBasicRuleInfo(InDTO inparam);
	
	/**
	 * Create on 2015-7-25 
	 * @author: nidw
	 * @Title: modifyBasicRuleInfo 
	 * @Description: 修改规则信息-规则名称
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO modifyBasicRuleInfo(InDTO inparam);

	/**
	 * Create on 2015-7-25 
	 * @author: nidw
	 * @Title: queryRuleItem 
	 * @Description: 规则明细新增初始化查询
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO queryRuleItem(InDTO inparam);

	/**
	 * Create on 2015-7-27
	 * @author: nidw
	 * @Title: saveRuleItem 
	 * @Description: 规则明细保存
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO saveRuleItem(InDTO inparam);
}
