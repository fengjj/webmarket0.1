package com.sitech.market.busiobject.basicclass.dtoclass.common.outDTO;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardOutDTO;
/**
 * 公共的输出dto，比如保存、删除、以及修改等，往往都是在成功后返回id、name或者一个标识，所以写成一个公共的
 * Create on 2015-4-22 
 * @author: wangdw
 * @Title: CommonFlagOutDTO 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class CommonFlagOutDTO extends StandardOutDTO {
	private static final long serialVersionUID = -4819894405219659836L;
	
	@ParamDesc(path="ID",cons=ConsType.CT001,type="string",len="18",desc="ID",memo="略")
	private String id;
	@ParamDesc(path="NAME",cons=ConsType.CT001,type="string",len="200",desc="名称",memo="略")
	private String name;
	@ParamDesc(path="RESULT_FLAG",cons=ConsType.CT001,type="string",len="10",desc="返回编码",memo="略")
	private String resultFlag;
	@ParamDesc(path="RESULT_MSG",cons=ConsType.CT001,type="string",len="100",desc="返回信息",memo="略")
	private String resultMsg;
	

	@Override
	public MBean encode() {
		MBean resultBean = new MBean();
		resultBean.setBody("ID",getId());
		resultBean.setBody("NAME",getName());
		resultBean.setBody("RESULT_FLAG",getResultFlag());
		resultBean.setBody("RESULT_MSG",getResultMsg());
		return resultBean;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResultFlag() {
		return resultFlag;
	}

	public void setResultFlag(String resultFlag) {
		this.resultFlag = resultFlag;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

}
