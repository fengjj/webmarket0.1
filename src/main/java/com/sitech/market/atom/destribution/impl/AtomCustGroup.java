package com.sitech.market.atom.destribution.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sitech.jcfx.anno.ParamType;
import com.sitech.jcfx.anno.ParamTypes;
import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;
import com.sitech.jcfx.dt.out.OutDTO;
import com.sitech.market.atom.destribution.inter.IAtomCustGroup;
import com.sitech.market.busiobject.basicclass.BaseClass;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardOutDTO;
import com.sitech.market.busiobject.entity.busi.inter.ICustGroupAtomEntity;
import com.sitech.util.ParamUtil;
import com.sitech.util.SequUtil;

/**
 * Create on 2015-3-31
 * @author: yugl_bj
 * @Title: AtomCustGroup
 * @Description: 客户群服务
 * @version 1.0  
 * update_data:     update_author:     update_note:
 */

@ParamTypes({
	@ParamType(c = StandardInDTO.class, m = "initCond", oc = StandardOutDTO.class),
	@ParamType(c = StandardInDTO.class, m = "saveCond", oc = StandardOutDTO.class),
	@ParamType(c = StandardInDTO.class, m = "deleteCond", oc = StandardOutDTO.class),
	@ParamType(c = StandardInDTO.class, m = "queryList", oc = StandardOutDTO.class),
	@ParamType(c = StandardInDTO.class, m = "insertCustGroupInfo", oc= StandardOutDTO.class),
	@ParamType(c = StandardInDTO.class, m = "deleteCustGroupInfo", oc= StandardOutDTO.class),
	@ParamType(c = StandardInDTO.class, m = "addCustGroupDetail", oc= StandardOutDTO.class),
	@ParamType(c = StandardInDTO.class, m = "saveFileCustGroup", oc= StandardOutDTO.class),
	@ParamType(c = StandardInDTO.class, m = "updateCustGroupInfo", oc= StandardOutDTO.class),
	@ParamType(c = StandardInDTO.class, m = "preEvaluation", oc= StandardOutDTO.class),
	@ParamType(c = StandardInDTO.class, m = "updateGroupRelStatus", oc= StandardOutDTO.class),
	@ParamType(c = StandardInDTO.class, m = "checkOtherPhoneNo", oc = StandardOutDTO.class),
	@ParamType(c = StandardInDTO.class, m = "updateGiveProStatus", oc = StandardOutDTO.class)
})
public class AtomCustGroup extends BaseClass implements IAtomCustGroup {
	
	private ICustGroupAtomEntity custGroupAtomEntity;
	
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
	@Override
	public OutDTO queryList(InDTO inDTO) {
		//入参处理
		Map<String,String> inMap = new HashMap<String,String>();
		inMap.put("custGroupName", inDTO.getMbean().getBodyStr("CUST_GROUP_NAME"));
		inMap.put("beginNum", inDTO.getMbean().getBodyStr("BEGIN_NUM"));
		inMap.put("endNum", inDTO.getMbean().getBodyStr("END_NUM")+"");
		
		//业务逻辑处理
		List dataList = custGroupAtomEntity.queryList(inMap);
		
		//出参处理
		List resultList = (List)ParamUtil.parseHump2Capital(dataList);
		StandardOutDTO outDTO = new StandardOutDTO();
		MBean resultBean = new MBean();
		resultBean.setBody("ELEMENTS", resultList);
		outDTO.setBean(resultBean);
		return outDTO;
	}
	
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
	@Override
	public OutDTO insertCustGroupInfo(InDTO inDTO) {
		//入参处理
		MBean inBean = inDTO.getMbean();
		Map<String,String> inMap = new HashMap<String,String>();
		inMap.put("custGroupName", inBean.getBodyStr("CUST_GROUP_NAME"));
		inMap.put("custGroupId", SequUtil.getSequ().substring(9));
		inMap.put("custGroupDesc", inBean.getBodyStr("CUST_GROUP_DESC"));
		inMap.put("choiceCode", inBean.getBodyStr("CHOICE_CODE"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String operTime = sdf.format(new Date());
		inMap.put("operTime", operTime);
		inMap.put("custNum", "0");
		inMap.put("operNo", inBean.getBodyStr("OPER_NO"));
		inMap.put("operName", inBean.getBodyStr("OPER_NAME"));
		inMap.put("custType", inBean.getBodyStr("CUST_TYPE"));
		inMap.put("filePath", inBean.getBodyStr("FILE_PATH"));

		//业务处理
		custGroupAtomEntity.insertCustGroupInfo(inMap);				
		
		//出参处理
		StandardOutDTO outDTO = new StandardOutDTO();
		outDTO.setBean(new MBean());
		return outDTO;
	}
	
	/**
	 * @author: zhaojie
	 * @Title: updateCustGroupInfo
	 * @Description:更新客户群信息
	 * @return 
	 * @version 1.0 
	 * date:2016-5-3
	 */
	@Override
	public OutDTO updateCustGroupInfo(InDTO inDTO) {
		//入参处理
		Map<String,String> inMap = new HashMap<String,String>();
		inMap.put("custGroupId", inDTO.getMbean().getBodyStr("CUST_GROUP_ID"));
		inMap.put("custNum", inDTO.getMbean().getBodyStr("CUST_NUM"));
		
		//业务处理
		custGroupAtomEntity.updateCustGroupInfo(inMap);
		
		//出参处理
		StandardOutDTO outDTO = new StandardOutDTO();
		outDTO.setBean(new MBean());
		return outDTO;
	}
	
	/**
	 * @author: liuhaoa
	 * @Title: deleteCustGroupInfo
	 * @Description:删除目标客户群明细
	 * @return 
	 * @version 1.0 
	 * date:2015-6-8
	 */
	@Override
	public OutDTO deleteCustGroupInfo(InDTO inDTO) {
		MBean inBean = inDTO.getMbean();
		Map<String,String> inMap = new HashMap<String,String>();
		inMap.put("custGroupId", inBean.getBodyStr("CUST_GROUP_ID"));
		
		custGroupAtomEntity.deleteCustGroupInfo(inMap);
		
		StandardOutDTO outDTO = new StandardOutDTO();
		MBean outBean = new MBean();
		outDTO.setBean(outBean);
		return outDTO;
	}
	
	/**
	 * @author: liuhaoa
	 * @Title: addCustGroupDetail
	 * @Description:生成目标客户群ID
	 * @return 
	 * @version 1.0 
	 * date:2015-6-8
	 */
	@Override
	public OutDTO addCustGroupDetail(InDTO inDTO) {
		String seq = custGroupAtomEntity.addCustGroupDetail();
		StandardOutDTO outDTO = new StandardOutDTO();
		if(null != seq && !seq.isEmpty()){
			MBean resultBean = new MBean();
			resultBean.setBody("seq", seq);
			outDTO.setBean(resultBean);
		}
		return outDTO;
	}
	
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
	@Override
	public OutDTO saveFileCustGroup(InDTO inDTO) {
		MBean inBean = inDTO.getMbean();
		Map<String,String> inMap = new HashMap<String,String>();
		inMap.put("busiId", inBean.getBodyStr("BUSI_ID"));
		inMap.put("busiType", inBean.getBodyStr("BUSI_TYPE"));
		inMap.put("custGroupName", inBean.getBodyStr("CUST_GROUP_NAME"));
		inMap.put("startDate", inBean.getBodyStr("START_DATE"));
		inMap.put("choiceCode", inBean.getBodyStr("CHOICE_CODE"));
		inMap.put("custGroupId", inBean.getBodyStr("CUST_GROUP_ID"));
		inMap.put("loginNo", inBean.getBodyStr("LOGIN_NO"));
		inMap.put("loginName", inBean.getBodyStr("LOGIN_NAME"));
		inMap.put("regionCode", inBean.getBodyStr("REGION_CODE"));
		inMap.put("custRelSerialId", inBean.getBodyStr("CUST_REL_SERIAL_ID"));
		
		Map outMap = custGroupAtomEntity.saveFileCustGroup(inMap);
		
		StandardOutDTO outDTO = new StandardOutDTO();
		if(outMap.get("result").equals("0"))
		{
			MBean outBean = new MBean();
			outBean.setBody("CUST_GROUP_ID", outMap.get("custGroupId"));
			outBean.setBody("SERIAL_ID", outMap.get("serialId"));
			outBean.setBody("CONTENT_SERIAL_ID", outMap.get("contentSerialId"));
			outDTO.setBean(outBean);
		}else
		{
			MBean bean = new MBean();
			bean.setBody("RETURN_CODE","-1");
			bean.setBody("RETURN_MSG",outMap.get("message").toString());
			outDTO.setBean(bean);
			outDTO.setReturnCode("-1");
			outDTO.setReturnMsg(outMap.get("message").toString());
		}
		
		return outDTO;
	}
	
	
	public void setCustGroupAtomEntity(ICustGroupAtomEntity custGroupAtomEntity) {
		this.custGroupAtomEntity = custGroupAtomEntity;
	}

}
