package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.atominitpagedata;

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
public class AtomGetInitPageDataInDTO extends StandardInDTO {
	
	private static final long serialVersionUID = 1L;
	@ParamDesc(path="SUB_ID",cons=ConsType.CT001,type="string",len="5",desc="Ԫ����������",memo="0���߻����� 1��ִ�н���-��б��ѯ 2��ִ�н���-�����")
	private String subId;
	@ParamDesc(path="ELEMENT_ID",cons=ConsType.QUES,type="string",len="18",desc="Ԫ��ID",memo="��")
	private String elementId;
	@ParamDesc(path="BUSI_STRING",cons=ConsType.QUES,type="string",len="18",desc="ҵ�����ݴ�",memo="��")
	private String busiString;
	@ParamDesc(path="PROVINCE_GROUP",cons=ConsType.CT001,type="string",len="20",desc="ʡ�ݱ�ʶ",memo="��")
	private String provinceGroup;
	@ParamDesc(path="DEL_NULL_ELE",cons=ConsType.QUES,type="string",len="20",desc="�Ƿ�ɾ����Ԫ��",memo="��")
	private String delNullEle;
	
	
	
	public void decode(MBean bean) {
		setSubId(bean.getStr(getPathByProperName("subId")));
		setElementId(bean.getStr(getPathByProperName("elementId")));
		setBusiString(bean.getStr(getPathByProperName("busiString")));
		setProvinceGroup(bean.getStr(getPathByProperName("provinceGroup")));
		setDelNullEle(bean.getStr(getPathByProperName("delNullEle")));
	}
	
	public String getBusiString() {
        return busiString;
    }

    public void setBusiString(String busiString) {
        this.busiString = busiString;
    }

    public String getSubId() {
		return subId;
	}

	public void setSubId(String subId) {
		this.subId = subId;
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


	public String getDelNullEle() {
		return delNullEle;
	}

	public void setDelNullEle(String delNullEle) {
		this.delNullEle = delNullEle;
	}
	
}
