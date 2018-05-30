package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.actiondto;

import java.util.List;
import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-4-23
 * @author: dongyh
 * @Title: AtomQueryActListInDTO
 * @Description： 打印入参参数
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomQueryActListInDTO extends StandardInDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="ACT_NAME",cons=ConsType.QUES,len="200",type="string",desc="活动名称",memo="略")
	private String actName;
	@ParamDesc(path="ACT_TYPE",cons=ConsType.QUES,len="5",type="string",desc="活动类型",memo="略")
	private String actType;
	@ParamDesc(path="TABLE_EN_NAME_ARR",cons=ConsType.STAR,len="30",type="compx",desc="表名称",memo="略")
	private List<String> tableEnNameArr;
	
	@ParamDesc(path="BEGIN_NUM",cons=ConsType.CT001,len="30",type="string",desc="开始数",memo="略")
	private String beginNum;
	@ParamDesc(path="END_NUM",cons=ConsType.CT001,len="30",type="string",desc="结束数",memo="略")
	private String endNum;
	@ParamDesc(path="OPER_NO",cons=ConsType.QUES,len="200",type="string",desc="工号",memo="略")
	private String operNo;
	@ParamDesc(path="OPER_TIME",cons=ConsType.QUES,len="5",type="string",desc="操作时间",memo="略")
	private String operTime;
	@ParamDesc(path="START_DATE",cons=ConsType.QUES,len="5",type="string",desc="操作时间",memo="略")
	private String startDate;
	@ParamDesc(path="END_DATE",cons=ConsType.QUES,len="5",type="string",desc="操作时间",memo="略")
	private String endDate;
	@ParamDesc(path="STATUS_CODE",cons=ConsType.QUES,len="5",type="string",desc="活动状态",memo="略")
	private String statusCode;
	@ParamDesc(path="PROVINCE_GROUP",cons=ConsType.QUES,len="20",type="string",desc="省份编码",memo="略")
	private String provinceGroup;
	
	public void decode(MBean bean) {
		setActName(bean.getStr(getPathByProperName("actName")));
		setActType(bean.getStr(getPathByProperName("actType")));
		setBeginNum(bean.getStr(getPathByProperName("beginNum")));
		setEndNum(bean.getStr(getPathByProperName("endNum")));
		setOperNo(bean.getStr(getPathByProperName("operNo")));
		setOperTime(bean.getStr(getPathByProperName("operTime")));
		setStatusCode(bean.getStr(getPathByProperName("statusCode")));
		setEndDate(bean.getStr(getPathByProperName("endDate")));
		setStartDate(bean.getStr(getPathByProperName("startDate")));
		setProvinceGroup(bean.getStr(getPathByProperName("provinceGroup")));
		setTableEnNameArr((List<String>) bean.getList(getPathByProperName("tableEnNameArr")));
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



	public String getOperNo() {
		return operNo;
	}

	public void setOperNo(String operNo) {
		this.operNo = operNo;
	}


	public String getOperTime() {
		return operTime;
	}


	public void setOperTime(String operTime) {
		this.operTime = operTime;
	}


	public String getStatusCode() {
		return statusCode;
	}


	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}


	public String getActName() {
		return actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}
	
	public List<String> getTableEnNameArr() {
		return tableEnNameArr;
	}

	public void setTableEnNameArr(List<String> tableEnNameArr) {
		this.tableEnNameArr = tableEnNameArr;
	}

	public String getActType() {
		return actType;
	}

	public void setActType(String actType) {
		this.actType = actType;
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



	public String getProvinceGroup() {
		return provinceGroup;
	}



	public void setProvinceGroup(String provinceGroup) {
		this.provinceGroup = provinceGroup;
	}
	
}
