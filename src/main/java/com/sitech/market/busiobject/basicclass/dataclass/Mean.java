package com.sitech.market.busiobject.basicclass.dataclass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.market.busiobject.basicclass.dtoclass.Decodeable;
import com.sitech.market.busiobject.basicclass.dtoclass.Encodeable;
import com.sitech.util.CommonUtil;

public class Mean implements Decodeable ,Encodeable{
	@ParamDesc(path="MEANS_ID",cons=ConsType.CT001,len="100",desc="方式id",type="String",memo="略")
	private String meansId;
	@ParamDesc(path="MEANS_NAME",cons=ConsType.QUES,len="100",desc="方式名称",type="String",memo="略")
	private String meansName;
	@ParamDesc(path="ACT_ID",cons=ConsType.QUES,len="100",desc="活动id",type="String",memo="略")
	private String actId;
	@ParamDesc(path="ACT_CLASS",cons=ConsType.QUES,len="100",desc="活动小类型",type="String",memo="略")
	private String actClass;
	@ParamDesc(path="RECORD_ID",cons=ConsType.QUES,len="100",desc="订购记录主表ID",type="String",memo="略")
	private String recordId;
	@ParamDesc(path="PREORDER_KEY",cons=ConsType.QUES,len="100",desc="营销预约记录表主键",type="String",memo="略")
	private String preorderKey;
	@ParamDesc(path = "ELEC_INFO", cons = ConsType.QUES, len = "100", desc = "电子卡信息", type = "Compx", memo = "略")
	private ElecInfo elecInfo;
	@ParamDesc(path="CONTENTS.CONTENT",cons=ConsType.STAR,len="100",desc="内容信息",type="Compx",memo="略")
	private List<ContentIn> content;
	@ParamDesc(path="UNIQUE_BUSI_ID",cons=ConsType.QUES,len="100",desc="业务统一编码",type="String",memo="略")
	private String uniqueBusiId;
	@ParamDesc(path="CONTRACT_NO",cons=ConsType.QUES,len="100",desc="账户编号",type="String",memo="略")
	private String contractNo;
	@ParamDesc(path="GOODPHONE_FEE",cons=ConsType.QUES,len="100",desc="优良号码抵扣金额(分)",type="String",memo="略")
	private String goodphoneFee;
	@ParamDesc(path="MKT_TYPE",cons=ConsType.QUES,len="6",desc="计费所需营销类型，A终端、B存送、电子卡",type="String",memo="略")
	private String mktType;
		

	public void decode(final Map in) {
		this.actId        = (String) in.get("ACT_ID");
		this.actClass	  = (String) in.get("ACT_CLASS");
		this.uniqueBusiId = (String) in.get("UNIQUE_BUSI_ID");
		this.meansId      = (String) in.get("MEANS_ID");
		this.meansName    = (String) in.get("MEANS_NAME");
		this.recordId     = (String) in.get("RECORD_ID");
		this.preorderKey  = (String) in.get("PREORDER_KEY");
		this.uniqueBusiId = (String) in.get("UNIQUE_BUSI_ID");
		this.contractNo   = (String) in.get("CONTRACT_NO");
		this.goodphoneFee = (String) in.get("GOODPHONE_FEE");
		this.mktType	  = (String) in.get("MKT_TYPE");
		
		Map elecIn = (Map) in.get("ELEC_INFO");
		if (CommonUtil.isNotEmpty(elecIn)) {
			elecInfo = new ElecInfo();
			elecInfo.decode(elecIn);
		}
		
		Map contentsMap = (Map)in.get("CONTENTS");
		if (CommonUtil.isNotEmpty(contentsMap)) {
			List<Map> content_list = (List<Map>) contentsMap.get("CONTENT");
			if(CommonUtil.isNotEmpty(content_list)){
				content = new ArrayList<ContentIn>();
				for(Map contentIn:content_list){
					System.out.println("........contentIn........"+contentIn);
					ContentIn con = new ContentIn();
					con.decode(contentIn);
					content.add(con);
				}
			}
		}
	}
	
	@Override
	public Map<String, Object> encode() {
		Map<String, Object> outMean = new HashMap<String, Object>();
		outMean.put("ACT_ID",      getActId());
		outMean.put("ACT_CLASS",   getActClass());
		outMean.put("MEANS_ID",    getMeansId());
		outMean.put("MEANS_NAME",  getMeansName());
		outMean.put("RECORD_ID",   getRecordId());
		outMean.put("PREORDER_KEY",   getPreorderKey());
		outMean.put("UNIQUE_BUSI_ID", getUniqueBusiId());
		outMean.put("CONTRACT_NO", getContractNo());
		outMean.put("GOODPHONE_FEE", getGoodphoneFee());
		outMean.put("MKT_TYPE",	   getMktType());
		
		if (CommonUtil.isNotEmpty(elecInfo)) {
			outMean.put("ELEC_INFO", elecInfo.encode());
		}
		
		if(CommonUtil.isNotEmpty(content)){
			List<Map> content_list = new ArrayList<Map>();
			for(ContentIn con:content){
				content_list.add(con.encode());
			}
			Map contentListMap = new HashMap();
			contentListMap.put("CONTENT",   content_list);
			
			outMean.put("CONTENTS", contentListMap);
		}
		
		return outMean;
	}
	
	
 
	public String getMeansName() {
		return meansName;
	}
	public void setMeansName(String meansName) {
		this.meansName = meansName;
	}
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getMeansId() {
		return meansId;
	}
	public void setMeansId(String meansId) {
		this.meansId = meansId;
	}
	public String getActId() {
		return actId;
	}
	public void setActId(String actId) {
		this.actId = actId;
	}
	public ElecInfo getElecInfo() {
		return elecInfo;
	}
	public void setElecInfo(ElecInfo elecInfo) {
		this.elecInfo = elecInfo;
	}
	public List<ContentIn> getContent() {
		return content;
	}
	public void setContent(List<ContentIn> content) {
		this.content = content;
	}
	public String getPreorderKey() {
		return preorderKey;
	}

	public void setPreorderKey(String preorderKey) {
		this.preorderKey = preorderKey;
	}

	public String getActClass() {
		return actClass;
	}
	public void setActClass(String actClass) {
		this.actClass = actClass;
	}

	public String getUniqueBusiId() {
		return uniqueBusiId;
	}

	public void setUniqueBusiId(String uniqueBusiId) {
		this.uniqueBusiId = uniqueBusiId;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getGoodphoneFee() {
		return goodphoneFee;
	}

	public void setGoodphoneFee(String goodphoneFee) {
		this.goodphoneFee = goodphoneFee;
	}

	public String getMktType() {
		return mktType;
	}

	public void setMktType(String mktType) {
		this.mktType = mktType;
	}
	
}
