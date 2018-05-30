package com.sitech.market.busiobject.basicclass.dtoclass.common.inDTO.atomlogin;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;

/**
 * Create on 2015-5-30 
 * @author: gengws
 * @Title: AtomGetLoginMsgInDTO 
 * @Description： 根据工号查询基本信息的InDTO
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomGetLoginMsgInDTO  extends InDTO{

	@ParamDesc(path="LOGIN_NO",cons=ConsType.CT001,type="String",len="20",desc="登陆工号",memo="略")
	private String loginNo;
	
	@Override
	public void decode(MBean bean) {
		this.loginNo=(String) bean.getObject(getPathByProperName("loginNo"));
		
	}

	public String getLoginNo() {
		return loginNo;
	}
	public void setLoginNo(String loginNo) {
		this.loginNo = loginNo;
	}
	
	

}
