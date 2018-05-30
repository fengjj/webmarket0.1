package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.actiondto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;
import com.sitech.market.busiobject.basicclass.dataclass.destribution.in.actiondto.Group;

public class AtomUpdateActBasicInDTO extends InDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ParamDesc(path="actId",cons=ConsType.CT001,type="String",len="20",desc="活动id",memo="")
	private String actId;// 必填项
	public String getActId() {
		return actId;
	}

	public void setActId(String actId) {
		this.actId = actId;
	}

	@ParamDesc(path="actName",cons=ConsType.CT001,type="String",len="40",desc="活动名称",memo="最好是十个以上长度的名称")
	private String actName;// 必填项
	@ParamDesc(path="actOrgCode",cons=ConsType.CT001,type="String",len="2",desc="区分移动铁通标志",memo="")
	private String actOrgCode;
	@ParamDesc(path="regions",cons=ConsType.CT001,type="JSONArray",len="100",desc="针对区域",memo="",cls=JSONArray.class)
	private JSONArray regions;
	@ParamDesc(path="actOrign",cons=ConsType.CT001,type="String",len="255",desc="活动来源",memo="")
	private String actOrign;
	@ParamDesc(path="priorityCode",cons=ConsType.CT001,type="String",len="2",desc="优先级",memo="")
	private String priorityCode;
	@ParamDesc(path="attestFlag",cons=ConsType.CT001,type="String",len="5",desc="身份验证",memo="")
	private String attestFlag;
	@ParamDesc(path="preOrder",cons=ConsType.CT001,type="String",len="2",desc="是否允许预约",memo="")
	private String preOrder;
	@ParamDesc(path="preMaxnum",cons=ConsType.CT001,type="String",len="5",desc="最大预约次数",memo="")
	private String preMaxnum;
	@ParamDesc(path="mixFlag",cons=ConsType.CT001,type="String",len="2",desc="是否兼容所有类型",memo="")
	private String mixFlag;
	@ParamDesc(path="startDate",cons=ConsType.CT001,type="String",len="20",desc="活动开始时间",memo="")
	private String startDate;// 必填项
	@ParamDesc(path="endDate",cons=ConsType.CT001,type="String",len="20",desc="活动结束时间",memo="")
	private String endDate;// 必填项
	@ParamDesc(path="actMaxCount",cons=ConsType.CT001,type="String",len="5",desc="活动参加限制次数",memo="")
	private String actMaxCount;// 必填项
	@ParamDesc(path="actPreinNumber",cons=ConsType.CT001,type="String",len="5",desc="活动预期参与人数",memo="")
	private String actPreinNumber;
	@ParamDesc(path="actDesc",cons=ConsType.CT001,type="String",len="1000",desc="活动描述",memo="")
	private String actDesc;
	@ParamDesc(path="operNo",cons=ConsType.CT001,type="String",len="40",desc="操作工号",memo="")
	private String operNo;// 必填项
	@ParamDesc(path="operName",cons=ConsType.CT001,type="String",len="40",desc="操作人姓名",memo="")
	private String operName;// 必填项
	@ParamDesc(path="updateNo",cons=ConsType.CT001,type="String",len="40",desc="修改人工号",memo="")
	private String updateNo;
	@ParamDesc(path="updateName",cons=ConsType.CT001,type="String",len="40",desc="修改人姓名",memo="")
	private String updateName;
	@ParamDesc(path="provinceCode",cons=ConsType.CT001,type="String",len="40",desc="省份编码",memo="")
	private String provinceCode;
	@ParamDesc(path="groupLevel",cons=ConsType.CT001,type="String",len="2",desc="活动开放区域的组织级别",memo="")
	private String groupLevel;
	@ParamDesc(path="actLevel",cons=ConsType.CT001,type="String",len="2",desc="活动创建等级",memo="")
	private String actLevel;
	@ParamDesc(path="regionCode",cons=ConsType.CT001,type="String",len="20",desc="归属地市",memo="")
	private String regionCode;
	@ParamDesc(path="groupId",cons=ConsType.CT001,type="String",len="20",desc="组织机构ID",memo="")
	private String groupId;
	@ParamDesc(path="groupName",cons=ConsType.CT001,type="String",len="20",desc="组织机构名称",memo="")
	private String groupName;
	@ParamDesc(path="ORDER_ID",cons=ConsType.CT001,type="String",len="20",desc="工单id",memo="")
	private String orderId;
	@ParamDesc(path="actClass",cons=ConsType.CT001,type="String",len="5",desc="活动小类",memo="")
	private String actClass;
	@ParamDesc(path="actType",cons=ConsType.CT001,type="String",len="2",desc="活动类型",memo="")
	private String actType;// 在客户群页面维护，暂时给默认值
	@ParamDesc(path="mainServType",cons=ConsType.CT001,type="String",len="2",desc="主题服务类型",memo="")
	private String mainServType;
	@ParamDesc(path="actAimType",cons=ConsType.CT001,type="String",len="2",desc="活动目的",memo="")
	private String actAimType;
	@ParamDesc(path="oldActBusiType",cons=ConsType.CT001,type="String",len="2",desc="修改之前的业务类型",memo="")
	private String oldActBusiType;
	@ParamDesc(path="actBusiTypeCount",cons=ConsType.CT001,type="String",len="5",desc="活动业务类型的总种类数",memo="")
	private String actBusiTypeCount;
	@ParamDesc(path="oldActAimType",cons=ConsType.CT001,type="String",len="2",desc="修改之前的活动目的",memo="")
	private String oldActAimType;
	@ParamDesc(path="actBusiType",cons=ConsType.CT001,type="String",len="2",desc="业务类型",memo="")
	private String actBusiType;
	@ParamDesc(path="disFlag",cons=ConsType.CT001,type="String",len="2",desc="操作标识",memo="")
	private String disFlag;
	@ParamDesc(path="statusCode",cons=ConsType.CT000,type="String",len="10",desc="活动状态",memo="")
	private String statusCode;
	@ParamDesc(path="groupList",cons=ConsType.CT001,type="compx",len="1",desc="活动业务类型的总种类数",memo="")
	private List<Group> groupList;
	
	public List<Group> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<Group> groupList) {
		this.groupList = groupList;
	}

	public String getActName() {
		return actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

	public String getActOrgCode() {
		return actOrgCode;
	}

	public void setActOrgCode(String actOrgCode) {
		this.actOrgCode = actOrgCode;
	}

	public JSONArray getRegions() {
		return regions;
	}

	public void setRegions(JSONArray regions) {
		this.regions = regions;
	}

	public String getActOrign() {
		return actOrign;
	}

	public void setActOrign(String actOrign) {
		this.actOrign = actOrign;
	}

	public String getPriorityCode() {
		return priorityCode;
	}

	public void setPriorityCode(String priorityCode) {
		this.priorityCode = priorityCode;
	}

	public String getAttestFlag() {
		return attestFlag;
	}

	public void setAttestFlag(String attestFlag) {
		this.attestFlag = attestFlag;
	}

	public String getPreOrder() {
		return preOrder;
	}

	public void setPreOrder(String preOrder) {
		this.preOrder = preOrder;
	}

	public String getPreMaxnum() {
		return preMaxnum;
	}

	public void setPreMaxnum(String preMaxnum) {
		this.preMaxnum = preMaxnum;
	}

	public String getMixFlag() {
		return mixFlag;
	}

	public void setMixFlag(String mixFlag) {
		this.mixFlag = mixFlag;
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

	public String getActMaxCount() {
		return actMaxCount;
	}

	public void setActMaxCount(String actMaxCount) {
		this.actMaxCount = actMaxCount;
	}

	public String getActPreinNumber() {
		return actPreinNumber;
	}

	public void setActPreinNumber(String actPreinNumber) {
		this.actPreinNumber = actPreinNumber;
	}

	public String getActDesc() {
		return actDesc;
	}

	public void setActDesc(String actDesc) {
		this.actDesc = actDesc;
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

	public String getUpdateNo() {
		return updateNo;
	}

	public void setUpdateNo(String updateNo) {
		this.updateNo = updateNo;
	}

	public String getUpdateName() {
		return updateName;
	}

	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getGroupLevel() {
		return groupLevel;
	}

	public void setGroupLevel(String groupLevel) {
		this.groupLevel = groupLevel;
	}

	public String getActLevel() {
		return actLevel;
	}

	public void setActLevel(String actLevel) {
		this.actLevel = actLevel;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getActClass() {
		return actClass;
	}

	public void setActClass(String actClass) {
		this.actClass = actClass;
	}

	public String getActType() {
		return actType;
	}

	public void setActType(String actType) {
		this.actType = actType;
	}

	public String getMainServType() {
		return mainServType;
	}

	public void setMainServType(String mainServType) {
		this.mainServType = mainServType;
	}

	public String getActAimType() {
		return actAimType;
	}

	public void setActAimType(String actAimType) {
		this.actAimType = actAimType;
	}

	public String getOldActBusiType() {
		return oldActBusiType;
	}

	public void setOldActBusiType(String oldActBusiType) {
		this.oldActBusiType = oldActBusiType;
	}

	public String getActBusiTypeCount() {
		return actBusiTypeCount;
	}

	public void setActBusiTypeCount(String actBusiTypeCount) {
		this.actBusiTypeCount = actBusiTypeCount;
	}

	public String getOldActAimType() {
		return oldActAimType;
	}

	public void setOldActAimType(String oldActAimType) {
		this.oldActAimType = oldActAimType;
	}

	public String getActBusiType() {
		return actBusiType;
	}

	public void setActBusiType(String actBusiType) {
		this.actBusiType = actBusiType;
	}

	public String getDisFlag() {
		return disFlag;
	}

	public void setDisFlag(String disFlag) {
		this.disFlag = disFlag;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public void decode(MBean arg0) {
		this.actName = arg0.getStr(getPathByProperName("actName"));// 必填项
		this.actOrgCode = arg0.getStr(getPathByProperName("actOrgCode"));
		this.regions = (JSONArray) arg0.getObject(getPathByProperName("regions"));
		this.actOrign = arg0.getStr(getPathByProperName("actOrign"));
		this.priorityCode = arg0.getStr(getPathByProperName("priorityCode"));
		this.attestFlag = arg0.getStr(getPathByProperName("attestFlag"));
		this.preOrder = arg0.getStr(getPathByProperName("preOrder"));
		this.preMaxnum = arg0.getStr(getPathByProperName("preMaxnum"));
		this.mixFlag = arg0.getStr(getPathByProperName("mixFlag"));
		this.startDate = arg0.getStr(getPathByProperName("startDate"));// 必填项
		this.endDate = arg0.getStr(getPathByProperName("endDate"));// 必填项
		this.actMaxCount = arg0.getStr(getPathByProperName("actMaxCount"));// 必填项
		this.actPreinNumber = arg0.getStr(getPathByProperName("actPreinNumber"));
		this.actDesc = arg0.getStr(getPathByProperName("actDesc"));
		this.operNo = arg0.getStr(getPathByProperName("operNo"));// 必填项
		this.operName = arg0.getStr(getPathByProperName("operName"));// 必填项
		this.updateNo = arg0.getStr(getPathByProperName("updateNo"));
		this.updateName = arg0.getStr(getPathByProperName("updateName"));
		this.provinceCode = arg0.getStr(getPathByProperName("provinceCode"));
		this.groupLevel = arg0.getStr(getPathByProperName("groupLevel"));
		this.actLevel = arg0.getStr(getPathByProperName("actLevel"));
		this.regionCode = arg0.getStr(getPathByProperName("regionCode"));
		this.groupId = arg0.getStr(getPathByProperName("groupId"));
		this.groupName = arg0.getStr(getPathByProperName("groupName"));
		this.orderId = arg0.getStr(getPathByProperName("orderId"));
		this.actClass = arg0.getStr(getPathByProperName("actClass"));
		this.actType = arg0.getStr(getPathByProperName("actType"));// 目前只是主动营销的活动
		this.mainServType = arg0.getStr(getPathByProperName("mainServType"));
		this.actAimType = arg0.getStr(getPathByProperName("actAimType"));
		this.actBusiType = arg0.getStr(getPathByProperName("actBusiType"));
		this.actBusiTypeCount = arg0.getStr(getPathByProperName("actBusiTypeCount"));
		this.oldActAimType = arg0.getStr(getPathByProperName("oldActAimType"));
		this.oldActBusiType = arg0.getStr(getPathByProperName("oldActBusiType"));
		this.disFlag = arg0.getStr(getPathByProperName("disFlag"));
		this.actId = arg0.getStr(getPathByProperName("actId"));
		this.statusCode = arg0.getStr(getPathByProperName("statusCode"));
		List<Map<String, Object>> groupList = (List<Map<String, Object>>) arg0.getList(getPathByProperName("groupList"));//MBeanUtil.getBodyList(arg0, "groupList");
		if (null != groupList && groupList.size() > 0) {
			for (Map<String,Object> groupMap : groupList) {
				Group group = new Group();
				group.decode(groupMap);
				this.getGroupList().add(group);
			}
		}
	}

}
