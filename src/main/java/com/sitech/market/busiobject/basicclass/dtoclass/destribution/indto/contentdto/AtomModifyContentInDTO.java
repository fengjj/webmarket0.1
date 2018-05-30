package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.contentdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;
/**
 * 
 * Create on 2015-7-25
 * @Author wengpc   
 * @Title AtomModifyContentInDTO
 * @Version 1.0
 * update_data:      update_author:      update_note:
 *
 */
public class AtomModifyContentInDTO extends StandardInDTO {

	private static final long serialVersionUID = 1L;
	
	@ParamDesc(path="CONTENT_NAME",cons=ConsType.CT001,type="string",len="200",desc="营销内容名称",memo="略")
	private String contentName;
	@ParamDesc(path="CONTENT_SERIAL_ID",cons=ConsType.CT001,type="string",len="18",desc="营销内容流水ID",memo="略")
	private String contentSerialId;
	@ParamDesc(path="START_DATE",cons=ConsType.QUES,type="string",len="20",desc="开始时间",memo="略")
	private String startDate;
	@ParamDesc(path="END_DATE",cons=ConsType.QUES,type="string",len="20",desc="结束时间",memo="略")
	private String endDate;

	public void decode(MBean bean) {
		setContentName(bean.getStr((getPathByProperName("contentName"))));
		setContentSerialId(bean.getStr((getPathByProperName("contentSerialId"))));
		setStartDate(bean.getStr(getPathByProperName("startDate")));
		setEndDate(bean.getStr(getPathByProperName("endDate")));
	
	}

	public String getContentName() {
		return contentName;
	}

	public void setContentName(String contentName) {
		this.contentName = contentName;
	}


	public String getContentSerialId() {
		return contentSerialId;
	}

	public void setContentSerialId(String contentSerialId) {
		this.contentSerialId = contentSerialId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
}
