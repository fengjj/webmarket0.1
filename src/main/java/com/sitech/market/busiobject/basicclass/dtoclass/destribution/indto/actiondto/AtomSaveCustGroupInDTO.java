package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.actiondto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-4-21
 * @author: fengjj
 * @Title: AtomSaveCustGroupInDTO
 * @Description： 打印入参参数
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomSaveCustGroupInDTO extends StandardInDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="SERIAL_ID",cons=ConsType.QUES,len="30",type="String",desc="序列号",memo="略")
	private String serialId;
	@ParamDesc(path="CUST_GROUP_ID",cons=ConsType.QUES,len="30",type="String",desc="客户群id",memo="略")
	private String custGroupId;
	@ParamDesc(path="BUSI_ID",cons=ConsType.QUES,len="20",type="String",desc="业务id",memo="略")
	private String busiId;
	@ParamDesc(path="BUSI_TYPE",cons=ConsType.QUES,len="20",type="String",desc="业务类型",memo="略")
	private String busiType;
	@ParamDesc(path="CHOICE_CODE",cons=ConsType.QUES,len="20",type="String",desc="客户群类型",memo="略")
	private String choiceCode;
	@ParamDesc(path="LOGIN_NO",cons=ConsType.QUES,len="20",type="String",desc="工号",memo="略")
	private String loginNo;
	@ParamDesc(path="LOGIN_NAME",cons=ConsType.QUES,len="50",type="String",desc="工号名称",memo="略")
	private String loginName;
	
	public void decode(MBean bean) {
	    setSerialId(bean.getStr(getPathByProperName("serialId")));
		setCustGroupId(bean.getStr(getPathByProperName("custGroupId")));
		setBusiId(bean.getStr(getPathByProperName("busiId")));
		setBusiType(bean.getStr(getPathByProperName("busiType")));
		setChoiceCode(bean.getStr(getPathByProperName("choiceCode")));
		setLoginNo(bean.getStr(getPathByProperName("loginNo")));
		setLoginName(bean.getStr(getPathByProperName("loginName")));
	}

    public String getChoiceCode() {
        return choiceCode;
    }

    public void setChoiceCode(String choiceCode) {
        this.choiceCode = choiceCode;
    }

    public String getSerialId() {
        return serialId;
    }

    public void setSerialId(String serialId) {
        this.serialId = serialId;
    }

    public String getCustGroupId() {
        return custGroupId;
    }

    public void setCustGroupId(String custGroupId) {
        this.custGroupId = custGroupId;
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

    public String getLoginNo() {
        return loginNo;
    }

    public void setLoginNo(String loginNo) {
        this.loginNo = loginNo;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
	
	
}
