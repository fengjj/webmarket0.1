package com.sitech.market.atom.destribution.inter;

import com.sitech.jcfx.dt.in.InDTO;
import com.sitech.jcfx.dt.out.OutDTO;

/**
 * Create on 2015-4-25
 * @author: dongyh
 * @Title: IAtomAction
 * @Description： 活动原子服务
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface IAtomAction {
	
	/**
	 * Create on 2015-4-21 
	 * @author: dongyh
	 * @Title: queryAllActType 
	 * @Description: 加载页面活动类型菜单
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO queryAllActType(InDTO inparam);
	
	/**
	 * Create on 2015-4-23 
	 * @author: dongyh
	 * @Title: queryActList 
	 * @Description: 查询活动列表
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO queryActList(InDTO inparam);
	
	/**
	 * Create on 2015-5-5 
	 * @author: dongyh
	 * @Title: removeAct 
	 * @Description: 删除活动
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO removeAct(InDTO inparam);
	
	/**
	 * 保存活动基本信息
	 * Create on 2015-4-21 
	 * @author: wangdw
	 * @Title: saveActBasic 
	 * @Description: 
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO saveActBasic(InDTO inparam);
	
	/**
	 * 修改活动信息
	 * Create on 2015-4-21 
	 * @author: wangdw
	 * @Title: saveActBasic 
	 * @Description: 
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO updateActBasic(InDTO inparam);
	/**
	 * 保存客户群信息
	 * Create on 2015-4-21 
	 * @author: fengjj
	 * @Title: saveCustGroup 
	 * @Description: 
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO operCustGroup(InDTO inparam);
	
	/**
	 * Create on 2015-5-7 
	 * @author: dongyh
	 * @Title: queryActTemplate 
	 * @Description: 策划活动,查询模板
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO queryActTemplate(InDTO inparam);
	
	/**
	 * Create on 2015-5-8 
	 * @author: dongyh
	 * @Title: saveActTemplate 
	 * @Description: 选择模板后，保存活动与模板关联关系
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO saveActTemplate(InDTO inparam);
	
	/**
	 * Create on 2015-5-14 
	 * @author: dongyh
	 * @Title: saveAttach 
	 * @Description: 保存附件和业务关系
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO saveAttach(InDTO inparam);
	
	/**
	 * Create on 2015-6-14 
	 * @author: dongyh
	 * @Title: deleteAttach 
	 * @Description: 删除附件
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO deleteAttach(InDTO inparam);
	
	/**
	 * Create on 2015-6-2 
	 * @author: dongyh
	 * @Title: queryBusiAttach 
	 * @Description: 查询附件
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO queryBusiAttach(InDTO inparam);
	
	/**
	 * Create on 2015-5-18 
	 * @author: dongyh
	 * @Title: queryPhone 
	 * @Description: 查询预发布测试号码
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO queryReleasePhone(InDTO inparam);
	
	/**
	 * Create on 2015-5-19 
	 * @author: dongyh
	 * @Title: updateActInfo 
	 * @Description: 修改活动状态
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO updateActStatusCode(InDTO inparam);
	/**
	 * 修改活动类型
	 * Create on May 20, 2015 
	 * @author: wangdw
	 * @Title: updateActType 
	 * @Description: 大类小类修改
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO updateActType(InDTO inparam);
	/**
	 * 根据busiId查询活动状态
	 * Create on 2015-5-25 
	 * @author: wangdw
	 * @Title: queryActStatusById 
	 * @Description: 
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO queryActStatusById(InDTO inparam);
	
	/**
	 * Create on 2015-5-26 
	 * @author: dongyh
	 * @Title: saveRelease 
	 * @Description: 保存发布
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO saveRelease(InDTO inparam);
	
	/**
	 * 根据活动ID查询活动基本信息及活动附加信息
	 * Create on May 28, 2015 
	 * @author: lixd_bj
	 * @Title: queryActBasicByActId 
	 * @Description: 根据活动ID查询活动基本信息及活动附加信息
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO queryActBasicByActId(InDTO inparam);
	
	/**
	 * 营销渠道区域选择
	 * Create on June 13, 2015 
	 * @author: liuhaoa
	 * @Title: queryOrgs 
	 * @Description: 营销渠道区域选择
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */	
	public OutDTO queryOrgs(InDTO inParam);
	
	/**
	 * 营销渠道区域选择
	 * Create on June 22, 2015 
	 * @author: liuhaoa
	 * @Title: queryGroupName 
	 * @Description: 营销渠道组织区域数据
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */		
	public OutDTO queryGroupName(InDTO inParam);
	/**
	 * 查询营销活动同步信息
	 * Create on 2015-6-21
	 * @author: nidw
	 * @Title: querySyncActInfoByActId 
	 * @Description: 查询营销活动同步信息
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */	
	public OutDTO querySyncActInfoByActId(InDTO inparam);
	/**
	 * 根据活动id获取活动详细信息
	 * Create on 2015-7-6
	 * @author: nidw
	 * @Title: getActInfoById 
	 * @Description: 根据活动id获取活动详细信息
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */	
	public OutDTO getActInfoById(InDTO inParam);
	
	/**
	 * 保存文件客户群
	 * @Create on 2015-7-29 
	 * @author: wangdw
	 * @Title: saveAttachCustGroup 
	 * @Description: 
	 * @param inParam
	 * @return 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	public OutDTO saveAttachCustGroup(InDTO inParam);
	
	/**
	 * 根据活动ID获取活动小类和目标库户群模式
	 * @Create on 2015-8-24 
	 * @author: liuhaoa
	 * @Title: getActClassAndChoiceCodeById 
	 * @Description: 
	 * @param inParam
	 * @return 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	public OutDTO getActClassAndChoiceCodeById(InDTO inParam);
}
