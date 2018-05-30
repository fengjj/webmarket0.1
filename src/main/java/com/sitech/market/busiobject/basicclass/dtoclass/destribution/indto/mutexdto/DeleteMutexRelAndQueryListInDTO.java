package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.mutexdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * 
 * Create on 2015-3-23 
 * @author: DeleteMutexRelAndQueryListInDTO
 * @Title: ClassName
 * @Description：根据活动ID与互斥活动ID删除活动互斥关系表中的信息，并返回可以参与互斥活动的列表InDTO
 * @version 1.0  
 * update_data:     update_author:     update_note:
 */
public class DeleteMutexRelAndQueryListInDTO extends StandardInDTO{

	@ParamDesc(path="busiId",cons=ConsType.CT001,len="100",desc="略",type="String",memo="略")
	private String busiId;
	@ParamDesc(path="busiIdA",cons=ConsType.CT001,len="100",desc="略",type="String",memo="略")
	private String busiIdA;
	@ParamDesc(path="busiIdB",cons=ConsType.CT001,len="100",desc="略",type="String",memo="略")
	private String busiIdB;
	@ParamDesc(path="busiType",cons=ConsType.CT001,len="100",desc="略",type="String",memo="略")
	private String busiType;
	@ParamDesc(path="busiTypeA",cons=ConsType.CT001,len="100",desc="略",type="String",memo="略")
	private String busiTypeA;
	@ParamDesc(path="busiTypeB",cons=ConsType.CT001,len="100",desc="略",type="String",memo="略")
	private String busiTypeB;
	
	@Override
	public void decode(MBean bean){
		
		this.busiId=(String) bean.getObject(getPathByProperName("busiId"));
		this.busiIdA=(String) bean.getObject(getPathByProperName("busiIdA"));
		this.busiIdB=(String) bean.getObject(getPathByProperName("busiIdB"));
		this.busiType=(String) bean.getObject(getPathByProperName("busiType"));
		this.busiTypeA=(String) bean.getObject(getPathByProperName("busiTypeA"));
		this.busiTypeB=(String) bean.getObject(getPathByProperName("busiTypeB"));
		
	}
	
	
	public String getBusiIdA() {
		return busiIdA;
	}
	public void setBusiIdA(String busiIdA) {
		this.busiIdA = busiIdA;
	}
	public String getBusiIdB() {
		return busiIdB;
	}
	public void setBusiIdB(String busiIdB) {
		this.busiIdB = busiIdB;
	}
	public String getBusiTypeA() {
		return busiTypeA;
	}
	public void setBusiTypeA(String busiTypeA) {
		this.busiTypeA = busiTypeA;
	}
	public String getBusiTypeB() {
		return busiTypeB;
	}
	public void setBusiTypeB(String busiTypeB) {
		this.busiTypeB = busiTypeB;
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
