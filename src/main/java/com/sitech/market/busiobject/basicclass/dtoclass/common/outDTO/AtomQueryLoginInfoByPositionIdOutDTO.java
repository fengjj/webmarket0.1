package com.sitech.market.busiobject.basicclass.dtoclass.common.outDTO;

import java.util.List;
import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardOutDTO;

/**
 * 
* Create on 2015-4-2
* @author: dongyh
* @Title: AtomQueryLoginInfoByPositionIdOutDTO
* @Description： 自动打印出参参数
* @version 1.0 
* update_data:      update_author:      update_note:
 */
public class AtomQueryLoginInfoByPositionIdOutDTO extends StandardOutDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="LOGIN_LIST",cons=ConsType.STAR,type="List",len="",desc="工号信息",memo="略")
	private List loginList;

	public MBean encode() {
		MBean bean = new MBean();
		bean.addBody("loginList", getLoginList());
		return bean;
	}

	public List getLoginList() {
		return loginList;
	}

	public void setLoginList(List loginList) {
		this.loginList = loginList;
	}
}
