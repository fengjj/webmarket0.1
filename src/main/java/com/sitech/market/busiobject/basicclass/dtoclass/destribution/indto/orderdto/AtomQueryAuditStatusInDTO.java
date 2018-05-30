package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.orderdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * 
* Create on 2015-4-2
* @author: dongyh
* @Title: AtomQueryAuditStatusInDTO
* @Description�� �Զ���ӡ��β���
* @version 1.0 
* update_data:      update_author:      update_note:
 */
public class AtomQueryAuditStatusInDTO extends StandardInDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="actId",cons=ConsType.CT001,type="string",len="22",desc="�ID",memo="��")
	private String actId;
	@ParamDesc(path="orderId",cons=ConsType.CT001,type="string",len="22",desc="����ID",memo="��")
	private String orderId;
	@ParamDesc(path="disFlag",cons=ConsType.CT001,type="string",len="2",desc="������ʶ",memo="0-��������ȫȨ�ޣ�1�����У����в�����ɾ��2ִ���У������޸ģ�")
	private String disFlag;
	
	public void decode(MBean bean) {
		setActId(bean.getStr(getPathByProperName("actId")));
		setOrderId(bean.getStr(getPathByProperName("orderId")));
		setDisFlag(bean.getStr(getPathByProperName("disFlag")));
	}

	public String getActId() {
		return actId;
	}

	public void setActId(String actId) {
		this.actId = actId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getDisFlag() {
		return disFlag;
	}

	public void setDisFlag(String disFlag) {
		this.disFlag = disFlag;
	}
}
