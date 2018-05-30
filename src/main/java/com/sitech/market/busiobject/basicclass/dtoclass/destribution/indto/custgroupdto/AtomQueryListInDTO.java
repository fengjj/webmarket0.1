package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.custgroupdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-6-6
 * @author: liuhaoa
 * @Title: AtomQueryListInDTO 
 * @Description： 目标客户群管理
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomQueryListInDTO extends StandardInDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="CUST_GROUP_NAME",cons=ConsType.CT001,len="100",desc="客户群名称",type="String",memo="略")
	private String custGroupName;
	@ParamDesc(path="BEGIN_NUM",cons=ConsType.CT001,len="100",desc="页数",type="String",memo="略")
	private String beginNum;
	@ParamDesc(path="END_NUM",cons=ConsType.CT001,len="100",desc="每页显示的行数",type="String",memo="略")
	private String endNum;
	
	
	public String getCustGroupName() {
		return custGroupName;
	}


	public void setCustGroupName(String custGroupName) {
		this.custGroupName = custGroupName;
	}


	public String getBeginNum() {
		return beginNum;
	}


	public void setBeginNum(String beginNum) {
		this.beginNum = beginNum;
	}


	public String getEndNum() {
		return endNum;
	}


	public void setEndNum(String endNum) {
		this.endNum = endNum;
	}


	@Override
	public void decode(MBean bean){
		setCustGroupName(bean.getStr(getPathByProperName("custGroupName")));
		setBeginNum(bean.getStr(getPathByProperName("beginNum")));
		setEndNum(bean.getStr(getPathByProperName("endNum")));
	}
}
