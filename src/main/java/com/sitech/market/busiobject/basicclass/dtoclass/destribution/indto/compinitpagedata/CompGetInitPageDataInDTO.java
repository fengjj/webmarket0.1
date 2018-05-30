package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.compinitpagedata;

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
public class CompGetInitPageDataInDTO extends StandardInDTO {
	
	private static final long serialVersionUID = 1L;
	@ParamDesc(path="subId",cons=ConsType.CT001,type="string",len="5",desc="Ԫ����������",memo="0���߻����� 1��ִ�н���-��б��ѯ 2��ִ�н���-�����")
	private String subId;
	@ParamDesc(path="actId",cons=ConsType.QUES,type="string",len="18",desc="�ID",memo="��")
	private String actId;
	@ParamDesc(path="elementId",cons=ConsType.QUES,type="string",len="18",desc="Ԫ��ID",memo="��")
	private String elementId;
	@ParamDesc(path="provinceGroup",cons=ConsType.CT001,type="string",len="20",desc="ʡ�ݱ�ʶ",memo="��")
	private String provinceGroup;
	
	public void decode(MBean bean) {
		setSubId(bean.getStr(getPathByProperName("subId")));
		setActId(bean.getStr(getPathByProperName("actId")));
		setElementId(bean.getStr(getPathByProperName("elementId")));
		setProvinceGroup(bean.getStr(getPathByProperName("provinceGroup")));
	}
	
	public String getSubId() {
		return subId;
	}

	public void setSubId(String subId) {
		this.subId = subId;
	}


	public String getActId() {
		return actId;
	}

	public void setActId(String actId) {
		this.actId = actId;
	}

	public String getElementId() {
		return elementId;
	}

	public void setElementId(String elementId) {
		this.elementId = elementId;
	}

	public String getProvinceGroup() {
		return provinceGroup;
	}

	public void setProvinceGroup(String provinceGroup) {
		this.provinceGroup = provinceGroup;
	}
	
}
