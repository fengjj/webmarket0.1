package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.contentdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * 查询终端合约列表入参
 * @Create on 2015-6-23 
 * @author: wangdw
 * @Title: AtomGetTerminalContractListInDTO 
 * @Description： 
 * @version 1.0 
 * update_date:      update_author:      update_note:
 */
public class AtomGetTerminalContractListInDTO extends StandardInDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="PROVINCE_GROUP",cons=ConsType.QUES,type="string",len="1000",desc="省份代码",memo="略")
	private String provinceGroup;
	@ParamDesc(path="TERM_CONTENT_IDS",cons=ConsType.QUES,type="string",len="1000",desc="终端内容contentId，多个id以#隔开",memo="略")
	private String termContentIds;
	@ParamDesc(path="CONT_CONTENT_IDS",cons=ConsType.QUES,type="string",len="1000",desc="合约内容contentId，多个id以#隔开",memo="略")
	private String contContentIds;
	@ParamDesc(path="BUSI_ID",cons=ConsType.QUES,type="string",len="1000",desc="业务关系ID",memo="略")
	private String busiId;
	@ParamDesc(path="BUSI_TYPE",cons=ConsType.QUES,type="string",len="1000",desc="业务关系类型",memo="略")
	private String busiType;
	
	public void decode(MBean bean) {
		this.provinceGroup = bean.getStr(getPathByProperName("provinceGroup"));
		this.termContentIds = bean.getStr(getPathByProperName("termContentIds"));
		this.contContentIds = bean.getStr(getPathByProperName("contContentIds"));
		this.busiId = bean.getStr(getPathByProperName("busiId"));
		this.busiType = bean.getStr(getPathByProperName("busiType"));
	}
	
	public String getTermContentIds() {
		return termContentIds;
	}
	public void setTermContentIds(String termContentIds) {
		this.termContentIds = termContentIds;
	}
	public String getContContentIds() {
		return contContentIds;
	}
	public void setContContentIds(String contContentIds) {
		this.contContentIds = contContentIds;
	}

	public String getProvinceGroup() {
		return provinceGroup;
	}

	public void setProvinceGroup(String provinceGroup) {
		this.provinceGroup = provinceGroup;
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
	
}
