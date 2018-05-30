package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.mutexdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * 
 * Create on 2015-3-23 
 * @author: gengws
 * @Title: SaveMutexAndQueryListInDTO
 * @Description：保存互斥活动信息，并返回可以参与互斥活动的列表 InDTO
 * @version 1.0  
 * update_data:     update_author:     update_note:
 */
public class SaveMutexAndQueryListInDTO extends StandardInDTO{
	
	@ParamDesc(path="busiIdA",cons=ConsType.CT001,len="100",desc="略",type="String",memo="略")
	private String busiIdA;
	@ParamDesc(path="busiIdB",cons=ConsType.CT001,len="100",desc="略",type="String",memo="略")
	private String busiIdB;
	@ParamDesc(path="busiTypeA",cons=ConsType.CT001,len="100",desc="略",type="String",memo="略")
	private String busiTypeA;
	@ParamDesc(path="busiTypeB",cons=ConsType.CT001,len="100",desc="略",type="String",memo="略")
	private String busiTypeB;
	@ParamDesc(path="relType",cons=ConsType.CT001,len="100",desc="略",type="String",memo="略")
	private String relType;
	@ParamDesc(path="operNo",cons=ConsType.CT001,len="100",desc="略",type="String",memo="略")
	private String operNo;
	@ParamDesc(path="operName",cons=ConsType.CT001,len="100",desc="略",type="String",memo="略")
	private String operName;
	@ParamDesc(path="operDate",cons=ConsType.CT001,len="100",desc="略",type="String",memo="略")
	private String operDate;
	
	@Override
	public void decode(MBean bean){
		
		this.busiIdA=(String) bean.getObject(getPathByProperName("busiIdA"));
		this.busiIdB=(String) bean.getObject(getPathByProperName("busiIdB"));
		this.busiTypeA=(String) bean.getObject(getPathByProperName("busiTypeA"));
		this.busiTypeB=(String) bean.getObject(getPathByProperName("busiTypeB"));
		this.relType=(String) bean.getObject(getPathByProperName("relType"));
		this.operNo=(String) bean.getObject(getPathByProperName("operNo"));
		this.operName=(String) bean.getObject(getPathByProperName("operName"));
		this.operDate=(String) bean.getObject(getPathByProperName("operDate"));
		
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
	public String getRelType() {
		return relType;
	}
	public void setRelType(String relType) {
		this.relType = relType;
	}
	public String getOperNo() {
		return operNo;
	}
	public void setOperNo(String operNo) {
		this.operNo = operNo;
	}
	public String getOperName() {
		return operName;
	}
	public void setOperName(String operName) {
		this.operName = operName;
	}
	public String getOperDate() {
		return operDate;
	}
	public void setOperDate(String operDate) {
		this.operDate = operDate;
	}
	

}
