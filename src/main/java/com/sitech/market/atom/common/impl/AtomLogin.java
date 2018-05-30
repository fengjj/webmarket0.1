package com.sitech.market.atom.common.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sitech.jcfx.anno.ParamType;
import com.sitech.jcfx.anno.ParamTypes;
import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;
import com.sitech.jcfx.dt.out.OutDTO;
import com.sitech.market.atom.common.inter.IAtomLogin;
import com.sitech.market.busiobject.basicclass.BaseClass;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardOutDTO;
import com.sitech.market.busiobject.entity.busi.inter.ILoginEntity;

/**
 * 
* Create on 2015-4-2
* @author: dongyh
* @Title: AtomLogin
* @Description： 登录信息原子服务
* @version 1.0 
* update_data:      update_author:      update_note:
 */
@ParamTypes({
	@ParamType(c = StandardInDTO.class, m = "queryPositionIdByLoginNo", oc = StandardOutDTO.class),
	@ParamType(c = StandardInDTO.class, m = "queryLoginInfoByPositionId", oc = StandardOutDTO.class),
	@ParamType(c = StandardInDTO.class, m = "loginIn", oc = StandardOutDTO.class),
	@ParamType(c = StandardInDTO.class, m = "getLoginMsg", oc = StandardOutDTO.class)
})
public class AtomLogin extends BaseClass implements IAtomLogin {
	
	private ILoginEntity loginEntity;
	
	 public OutDTO queryPositionIdByLoginNo(InDTO inparam) {
	        StandardOutDTO ot = new StandardOutDTO();
	        MBean bean = inparam.getMbean();
	        MBean resultBean = loginEntity.queryPositionIdByLoginNo(bean);
	        ot.setBean(resultBean);
	        return ot;
	    }
	/**
	 * 
	* Create on 2015-4-2 
	* @author: dongyh
	* @Title: queryLoginInfoByPositionId 
	* @Description: 根据岗位查工号信息
	* @param inparam
	* @return 
	* @version 1.0 
	* update_data:       update_author:       update_note:
	 */
	public OutDTO queryLoginInfoByPositionId(InDTO inparam) {
		//入参处理
		Map<String,List> paramMap = new HashMap<String,List>();
		paramMap.put("positionIdList", inparam.getMbean().getBodyList("positionIdList"));
		
		//逻辑处理,根据岗位查工号信息
		Map result = loginEntity.queryLoginInfoByPositionId(paramMap);

		//出参处理
		MBean bean = new MBean();
		bean.setBody("loginList", result.get("loginList"));
		StandardOutDTO outDto = new StandardOutDTO();
		outDto.setBean(bean);
		return outDto;
	}
	
	/**
     * 登录验证
    	* 
    	*  Create on 2014-11-10 下午2:59:39
    	* @author tianyy_bj
    	* @version 1.0
    	* Copyright(c) 北京思特奇信息技术股份有限公司
    	* 功能描述：登录验证
    	* 修改日期:     修改人:     修改目的:
     */
	@Override 
    public OutDTO loginIn(final InDTO inParam) {
        log.info("loginIn  start!");
        MBean paramBean = inParam.getMbean();
        Map<String,String> paramMap = new HashMap<String,String>();
        paramMap.put("loginNo",paramBean.getBodyStr("loginNo"));
        paramMap.put("password", paramBean.getBodyStr("password"));
        
        //通过用户名获取登录信息
        Map resultMap = loginEntity.queryLoginInfo(paramMap);
        
        MBean resultBean = new MBean();
        resultBean.setBody("resultBean",(Map)resultMap.get("resultBean"));
        resultBean.setBody("positions", (List)resultMap.get("positions"));
        StandardOutDTO ot = new StandardOutDTO();
        ot.setBean(resultBean);
        return ot;
    }
	
	/**
	 * Create on 2015-5-30 
	 * @author: gengws
	 * @Title: getLoginMsg 
	 * @Description: 根据工号查询基本信息
	 * @param inDTO
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public OutDTO getLoginMsg(InDTO inDTO) {
		
		StandardOutDTO outDTO=null;
		try {
			//入参处理
			Map<String,String> inMap = new HashMap<String,String>();
			inMap.put("loginNo",(String)inDTO.getMbean().getObject("LOGIN_NO"));
			
			//逻辑处理
			Map reMap=loginEntity.getLoginMsg(inMap);
			
			//出参处理
			MBean resultBean = new MBean();
			resultBean.setBody("GROUP_ID", (String)reMap.get("groupId"));
			resultBean.setBody("REGION_ID",(String)reMap.get("regionId"));
			outDTO.setBean(resultBean);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return outDTO;
	}
	
	public void setLoginEntity(ILoginEntity loginEntity) {
		this.loginEntity = loginEntity;
	}
	
}
