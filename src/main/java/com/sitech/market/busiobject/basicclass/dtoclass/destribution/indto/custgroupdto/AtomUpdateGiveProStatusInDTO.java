package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.custgroupdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * ȷ�ϻ�ȡ���������������޸Ļ�Ϳͻ�Ⱥ��ϵ��״̬
 * @Create on 2015-9-12 
 * @author: liuhaoa
 * @Title: AtomUpdateGiveProStatusInDTO 
 * @Description�� 
 * @version 1.0 
 * update_date:      update_author:      update_note:
 */
@SuppressWarnings("serial")
public class AtomUpdateGiveProStatusInDTO extends StandardInDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="BUSI_ID",cons=ConsType.CT001,len="100",desc="�id",type="String",memo="��")
	private String busiId;
	@ParamDesc(path="STATUS_CODE",cons=ConsType.CT001,len="100",desc="״̬",type="String",memo="��")
	private String statusCode;
	
	public String getBusiId() {
		return busiId;
	}
	public void setBusiId(String busiId) {
		this.busiId = busiId;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	
	@Override
	public void decode(MBean bean){
		setBusiId(bean.getStr(getPathByProperName("busiId")));
		setStatusCode(bean.getStr(getPathByProperName("statusCode")));
	}
}