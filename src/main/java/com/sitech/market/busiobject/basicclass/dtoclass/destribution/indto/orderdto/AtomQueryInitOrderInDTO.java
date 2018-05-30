package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.orderdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;

/**
 * 
* Create on 2015-4-2
* @author: dongyh
* @Title: AtomQueryInitOrderInDTO
* @Description�� �Զ���ӡ��β���
* @version 1.0 
* update_data:      update_author:      update_note:
 */
public class AtomQueryInitOrderInDTO extends InDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="orderId",cons=ConsType.CT001,type="string",len="22",desc="������",memo="��")
	private String orderId;
	@ParamDesc(path="disFlag",cons=ConsType.CT001,type="string",len="2",desc="������ʶ",memo="0-��������ȫȨ�ޣ�1�����У����в�����ɾ��2ִ���У������޸ģ�")
	private String disFlag;
	@ParamDesc(path="mk_isUnique",cons=ConsType.CT001,type="string",len="2",desc="�Ƿ�ʹ��Ψһ����",memo="0:��ʹ��,1:ʹ��")
	private String mkIsUnique;

	public void decode(MBean bean) {
		setOrderId(bean.getStr(getPathByProperName("orderId")));
		setDisFlag(bean.getStr(getPathByProperName("disFlag")));
		setMkIsUnique(bean.getStr(getPathByProperName("mkIsUnique")));
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

	public String getMkIsUnique() {
		return mkIsUnique;
	}

	public void setMkIsUnique(String mkIsUnique) {
		this.mkIsUnique = mkIsUnique;
	}
	
}
