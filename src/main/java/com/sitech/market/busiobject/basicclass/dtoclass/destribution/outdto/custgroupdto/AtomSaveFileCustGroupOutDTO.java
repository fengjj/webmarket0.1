package com.sitech.market.busiobject.basicclass.dtoclass.destribution.outdto.custgroupdto;

import java.util.Map;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardOutDTO;

/**
 * Create on 2015-6-8
 * @author: liuhaoa
 * @Title: AtomAddCustGroupDetailOutDTO 
 * @Description： 目标客户群生成序列
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomSaveFileCustGroupOutDTO extends StandardOutDTO {
	
	private static final long serialVersionUID = 1L;
	@ParamDesc(path="CUST_GROUP_ID",cons=ConsType.CT001,len="100",desc="客户群ID",type="String",memo="略")
	private String custGroupId;
	@ParamDesc(path="SERIAL_ID",cons=ConsType.CT001,len="100",desc="mk_busicustgroup_rel的serialId",type="String",memo="略")
	private String serialId;
	@ParamDesc(path="CONTENT_SERIAL_ID",cons=ConsType.CT001,len="100",desc="营销内容流水ID",type="String",memo="略")
	private String contentSerialId;
	
	
	public MBean encode() {
		MBean resultBean = new MBean();
		resultBean.setBody("CUST_GROUP_ID", getCustGroupId());
		resultBean.setBody("SERIAL_ID", getSerialId());
		resultBean.setBody("CONTENT_SERIAL_ID", getContentSerialId());
		return resultBean;
	}

	public String getCustGroupId() {
		return custGroupId;
	}
	public void setCustGroupId(String custGroupId) {
		this.custGroupId = custGroupId;
	}
	public String getSerialId() {
		return serialId;
	}
	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}
	public String getContentSerialId() {
		return contentSerialId;
	}
	public void setContentSerialId(String contentSerialId) {
		this.contentSerialId = contentSerialId;
	}

}
