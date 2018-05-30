package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.meansdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;

public class AtomGetContentsByBusiIdInDTO extends InDTO{

	/**
     * ������
     * fengjj
     * 2015��6��22��
     */
    private static final long serialVersionUID = 1175472965908870836L;
    @ParamDesc(path="BUSI_ID",cons=ConsType.CT001,len="20",type="String",desc="ҵ��ID",memo="")
	private String busiId;
    @ParamDesc(path="BUSI_TYPE",cons=ConsType.CT001,len="20",type="String",desc="ҵ������",memo="")
    private String busiType;
    @ParamDesc(path="TEMPLATE_FLAG",cons=ConsType.CT001,len="20",type="String",desc="ģ���ʶ",memo="")
    private String templateFlag;
    @ParamDesc(path="CLASS_VALUE",cons=ConsType.CT001,len="20",type="String",desc="ģ���ʶ",memo="")
    private String actClass;
	@Override
	public void decode(MBean bean) {
	    setBusiId(bean.getStr(getPathByProperName("busiId")));
	    setBusiType(bean.getStr(getPathByProperName("busiType")));
	    setTemplateFlag(bean.getStr(getPathByProperName("templateFlag")));
	    setActClass(bean.getStr(getPathByProperName("actClass")));
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
	public String getTemplateFlag() {
		return templateFlag;
	}
	public void setTemplateFlag(String templateFlag) {
		this.templateFlag = templateFlag;
	}
	public String getActClass() {
		return actClass;
	}
	public void setActClass(String actClass) {
		this.actClass = actClass;
	}
	

}
