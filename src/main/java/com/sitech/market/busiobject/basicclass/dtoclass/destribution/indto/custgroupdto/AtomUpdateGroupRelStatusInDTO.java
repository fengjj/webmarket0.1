package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.custgroupdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * ����ҵ��ͻ�Ⱥ״̬
 * @Create on 2015-7-30 
 * @author: wangdw
 * @Title: AtomPreEvaluationInDTO 
 * @Description�� 
 * @version 1.0 
 * update_date:      update_author:      update_note:
 */
@SuppressWarnings("serial")
public class AtomUpdateGroupRelStatusInDTO extends StandardInDTO {
	
	@ParamDesc(path="BUSI_ID",cons=ConsType.CT001,len="100",desc="ҵ��ID",type="String",memo="��")
	private String busiId;
	@ParamDesc(path="BUSI_TYPE",cons=ConsType.CT001,len="6",desc="ҵ������",type="String",memo="��")
	private String busiType;
	@ParamDesc(path="GROUP_STATUS_CODE",cons=ConsType.CT001,len="10",desc="�ͻ�Ⱥ��ϵrel״̬",type="String",memo="��")
	private String groupStatusCode;
	@ParamDesc(path="ACT_STATUS_CODE",cons=ConsType.CT001,len="10",desc="�״̬",type="String",memo="��")
	private String actStatusCode;
	@ParamDesc(path="UPDATE_NO",cons=ConsType.CT001,len="10",desc="�����˹���",type="String",memo="��")
	private String updateNo;
	@ParamDesc(path="UPDATE_NAME",cons=ConsType.CT001,len="10",desc="����������",type="String",memo="��")
	private String updateName;
	
	
	@Override
	public void decode(MBean bean){
		this.busiId = bean.getStr(getPathByProperName("busiId"));
		this.busiType = bean.getStr(getPathByProperName("busiType"));
		this.groupStatusCode = bean.getStr(getPathByProperName("groupStatusCode"));
		this.actStatusCode = bean.getStr(getPathByProperName("actStatusCode"));
		this.updateNo = bean.getStr(getPathByProperName("updateNo"));
		this.updateName = bean.getStr(getPathByProperName("updateName"));
	}

	public String getBusiId() {
		return busiId;
	}

	public void setBusiId(String busiId) {
		this.busiId = busiId;
	}

	public String getBusiType() {
		return busiType;
	}

	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}

	public String getGroupStatusCode() {
		return groupStatusCode;
	}

	public void setGroupStatusCode(String groupStatusCode) {
		this.groupStatusCode = groupStatusCode;
	}

	public String getActStatusCode() {
		return actStatusCode;
	}

	public void setActStatusCode(String actStatusCode) {
		this.actStatusCode = actStatusCode;
	}

	public String getUpdateNo() {
		return updateNo;
	}

	public void setUpdateNo(String updateNo) {
		this.updateNo = updateNo;
	}

	public String getUpdateName() {
		return updateName;
	}

	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}
	

}
