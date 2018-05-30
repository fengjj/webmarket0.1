package com.sitech.market.atom.destribution.inter;

import com.sitech.jcfx.dt.in.InDTO;
import com.sitech.jcfx.dt.out.OutDTO;

/**
 * Create on 2015-5-22 
 * @author: yugl
 * @Title: IAtomContent 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface IAtomContent {
	
	
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
	public OutDTO getContentList(InDTO inparam);
	
	/**
	 * Create on 2015-5-28 
	 * @author: yugl
	 * @Title: getDetailContent 
	 * @Description: 获取某个内容的详细信息
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO getDetailContent(InDTO inparam);
	
	/**
	 * Create on 2015-5-23 
	 * @author: yugl
	 * @Title: saveBusiContent 
	 * @Description: 保存业务与内容关系
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO saveBusiContent(InDTO inparam);
	
	/**
	 * Create on 2015-6-12 
	 * @author: jiaxla
	 * @Title: saveBusiContent 
	 * @Description: 保存业务与内容关系(终端合约捆绑)
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO saveBusiContentTermi(InDTO inparam);
	
	/**
	 * Create on 2015-6-10
	 * @author: zhangchen
	 * @Title: saveContent 
	 * @Description: 保存内容明细
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO saveContent(InDTO inparam) ;
	/**
	 * Create on 2015-6-6
	 * @author: zhangchen
	 * @Title: saveContentDetail 
	 * @Description: 保存内容明细
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 * @throws Exception 
	 */
	public OutDTO saveContentDetail(InDTO inparam) throws Exception ;
	/**
	 * Create on 2015-6-1 
	 * @author: zhangchen
	 * @Title: queryElementByContentType 
	 * @Description: 根据mk_contenttype_dict查询元素列表
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO queryElementByContentType(InDTO inparam);
	/**
	 * Create on 2015-6-22 
	 * @author: jiaxla
	 * @Title: delContentRel 
	 * @Description: 删除营销内容
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO delContentRel(InDTO inparam);

	/**
	 * Create on 2015-6-1 
	 * @author: zhangchen
	 * @Title: initContentId 
	 * @Description: 根据mk_contenttype_dict查询元素列表
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@SuppressWarnings("unchecked")
	public OutDTO initContentId(InDTO inparam);
	
	/**
	 * 查询内容模板列表
	 * @Create on 2015-6-23 
	 * @author: wangdw
	 * @Title: queryContentTemplateList 
	 * @Description: 
	 * @param inDTO
	 * @return 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	public OutDTO queryContentTemplateList(InDTO inDTO);
	
	/**
	 * 终端合约信息列表
	 * @Create on 2015-6-25 
	 * @author: wangdw
	 * @Title: getTerminalContractList 
	 * @Description: 
	 * @param inDTO
	 * @return 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	public OutDTO getTerminalContractList(InDTO inDTO) ;
	
	/**
	 * Create on 2015-7-2 
	 * @author: gengws
	 * @Title: getElecContentSerialId 
	 * @Description: 根据电子卡的活动ID查询内容表的content_serial_id
	 * @param inDTO
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO getElecContentSerialId(InDTO inDTO) ;
	
	/**
	 * Create on 2015-7-2 
	 * @author: gengws
	 * @Title: getBusiContentRelByContentSerialId 
	 * @Description: 根据rel_id查询mk_mk_busicontent_rel
	 * @param inDTO
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO getContentByRelId(InDTO inDTO);
	/**
	 * 根据content_serial_id更新营销内容名称
	 * Create on 2015-7-25
	 * @Author wengpc 
	 * @Title modifyContent
	 * @param inDTO
	 * @return OutDTO
	 * @Throws 
	 * @Version 1.0
	 * update_data:      update_author:      update_note:
	 */
	public OutDTO modifyContent(InDTO inDTO);

	/**
	 * Create on 2015-6-1 
	 * @author: zhangchen
	 * @Title: delContentDetail 
	 * @Description: 删除内容明细
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 * @throws Exception 
	 */
	public OutDTO delContentDetail(InDTO inDTO) throws Exception;

	/**
	 * Create on 2015-8-5 
	 * @author: nidw
	 * @Title: saveNewBusiContent 
	 * @Description: 新增内容保存档次关系
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 * @throws Exception 
	 */
	public OutDTO saveNewBusiContent(InDTO inparam);
	
	/**
	 * Create on 2015-9-6 
	 * @author: dongyh
	 * @Title: queryResourceTicketFee 
	 * @Description: 查询电子券营销包ID和面额
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO queryResourceTicketFee(InDTO inparam);
	
	/**
	 * Create on 2015-9-6 
	 * @author: dongyh
	 * @Title: queryPrcList 
	 * @Description: 查询电子券ID、产品资费
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO queryElementParContent(InDTO inparam);
	
	/**
	 * Create on 2015-9-9 
	 * @author: dongyh
	 * @Title: addTerminalContract 
	 * @Description: 初始化添加终端机型合约的页面
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO addTerminalContract(InDTO inparam);
	
	/**
	 * Create on 2015-9-10 
	 * @author: dongyh
	 * @Title: saveTerminal 
	 * @Description: 保存终端机型和合约信息
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public OutDTO saveTerminal(InDTO inparam);
}

