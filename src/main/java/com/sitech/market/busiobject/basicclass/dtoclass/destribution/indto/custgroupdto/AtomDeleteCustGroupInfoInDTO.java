package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.custgroupdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-6-8
 * @author: liuhaoa
 * @Title: AtomDeleteCustGroupInfoInDTO 
 * @Description�� Ŀ��ͻ�Ⱥ��ϸɾ��
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomDeleteCustGroupInfoInDTO extends StandardInDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="CUST_GROUP_ID",cons=ConsType.CT001,len="100",desc="�ͻ�ȺID",type="String",memo="��")
	private String custGroupId;
	
	public String getCustGroupId() {
		return custGroupId;
	}
	public void setCustGroupId(String custGroupId) {
		this.custGroupId = custGroupId;
	}
	
	@Override
	public void decode(MBean bean){
		setCustGroupId(bean.getStr(getPathByProperName("custGroupId")));
	}
}
