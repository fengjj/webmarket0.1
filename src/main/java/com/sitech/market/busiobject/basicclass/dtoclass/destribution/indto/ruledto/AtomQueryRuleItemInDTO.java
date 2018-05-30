package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.ruledto;


import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-4-2
 * @author: dongyh
 * @Title: AtomQueryExeElementsInDTO
 * @Description�� �Զ���ӡ��β���
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomQueryRuleItemInDTO extends StandardInDTO {
	
	private static final long serialVersionUID = 1L;
	@ParamDesc(path="ITEM_ID",cons=ConsType.QUES,type="string",len="18",desc="������ϸid",memo="��")
	private String itemId;
	@ParamDesc(path="PROVINCE_GROUP",cons=ConsType.QUES,type="string",len="18",desc="ʡ�ݱ���",memo="��")
	private String provinceGroup;
	@ParamDesc(path="TEMPLATE_FLAG",cons=ConsType.QUES,type="string",len="18",desc="ģ���ʶ",memo="��")
	private String templateFlag;
	
	public void decode(MBean bean) {
		setProvinceGroup(bean.getStr(getPathByProperName("provinceGroup")));
		setItemId(bean.getStr(getPathByProperName("itemId")));
		setTemplateFlag(bean.getStr(getPathByProperName("templateFlag")));
	}



	public String getItemId() {
		return itemId;
	}



	public void setItemId(String itemId) {
		this.itemId = itemId;
	}



	public String getTemplateFlag() {
		return templateFlag;
	}



	public void setTemplateFlag(String templateFlag) {
		this.templateFlag = templateFlag;
	}



	public String getProvinceGroup() {
		return provinceGroup;
	}


	public void setProvinceGroup(String provinceGroup) {
		this.provinceGroup = provinceGroup;
	}

	
	
}
