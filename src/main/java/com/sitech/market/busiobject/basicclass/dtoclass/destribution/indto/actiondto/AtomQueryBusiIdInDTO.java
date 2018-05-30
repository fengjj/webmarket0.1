package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.actiondto;

import java.util.Map;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;
import com.sitech.market.busiobject.basicclass.dataentity.InDataEntity;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * 根据业务id查询
 * Create on 2015-5-25 
 * @author: wangdw
 * @Title: AtomQueryBusiIdInDTO 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomQueryBusiIdInDTO extends InDTO {

	private static final long serialVersionUID = -6599404861174711725L;
	@ParamDesc(path="BUSI_ID",cons=ConsType.CT001,len="20",type="String",desc="业务ID",memo="略")
	private String busiId;
	@ParamDesc(path="BUSI_TYPE",cons=ConsType.QUES,len="20",type="String",desc="业务类型",memo="略")
	private String busiType;
	
	@Override
	public void decode(MBean arg0) {
		this.busiId = arg0.getStr(getPathByProperName("busiId"));
		this.busiType = arg0.getStr(getPathByProperName("busiType"));
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
