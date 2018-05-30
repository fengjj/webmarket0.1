package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.mutexdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * 
 * Create on 2015-3-23 
 * @author: gengws
 * @Title: QueryMutexListInDTO
 * @Description：通过活动ID，获取互斥活动列表 InDTO
 * @version 1.0  
 * update_data:     update_author:     update_note:
 */
public class QueryMutexListInDTO extends StandardInDTO{
	
	@ParamDesc(path="busiId",cons=ConsType.CT001,len="100",desc="略",type="String",memo="略")
	private String busiId;
	@ParamDesc(path="busiType",cons=ConsType.CT001,len="100",desc="略",type="String",memo="略")
	private String busiType;
	
	@Override
	public void decode(MBean bean){
		this.busiId=(String) bean.getObject(getPathByProperName("busiId"));
		this.busiType=(String) bean.getObject(getPathByProperName("busiType"));
	}
	
	
	public String getBusiType() {
		return busiType;
	}
	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}
	public String getBusiId() {
		return busiId;
	}
	public void setBusiId(String busiId) {
		this.busiId = busiId;
	}
	
	

}
