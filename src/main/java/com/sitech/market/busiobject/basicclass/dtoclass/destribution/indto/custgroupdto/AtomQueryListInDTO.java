package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.custgroupdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-6-6
 * @author: liuhaoa
 * @Title: AtomQueryListInDTO 
 * @Description�� Ŀ��ͻ�Ⱥ����
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomQueryListInDTO extends StandardInDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="CUST_GROUP_NAME",cons=ConsType.CT001,len="100",desc="�ͻ�Ⱥ����",type="String",memo="��")
	private String custGroupName;
	@ParamDesc(path="BEGIN_NUM",cons=ConsType.CT001,len="100",desc="ҳ��",type="String",memo="��")
	private String beginNum;
	@ParamDesc(path="END_NUM",cons=ConsType.CT001,len="100",desc="ÿҳ��ʾ������",type="String",memo="��")
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
