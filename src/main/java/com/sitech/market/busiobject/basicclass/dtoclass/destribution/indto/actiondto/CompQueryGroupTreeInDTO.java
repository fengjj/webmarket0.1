package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.actiondto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;

/**
 * Create on 2015-4-7
 * @author: dongyh
 * @Title: CompQueryGroupTreeInDTO
 * @Description�� �Զ���ӡ��β���
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class CompQueryGroupTreeInDTO extends InDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="PARENT_GROUP_ID",cons=ConsType.CT001,type="string",len="5",desc="�����ڵ�,��ѯ��һ��ڵ�",memo="��")
	private String parentGroupId;
	
	public void decode(MBean bean) {
		setParentGroupId(bean.getStr(getPathByProperName("parentGroupId")));
	}

	public String getParentGroupId() {
		return parentGroupId;
	}

	public void setParentGroupId(String parentGroupId) {
		this.parentGroupId = parentGroupId;
	}

}
