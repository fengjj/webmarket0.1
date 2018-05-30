package com.sitech.market.busiobject.basicclass.dataclass;

import java.util.HashMap;
import java.util.Map;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.market.busiobject.basicclass.dtoclass.Decodeable;
import com.sitech.market.busiobject.basicclass.dtoclass.Encodeable;

public class Termi implements Decodeable ,Encodeable{
	@ParamDesc(path="TERMI_RES_CODE",cons=ConsType.QUES,len="100",desc="终端型号",type="String",memo="略")
	private String termiResCode;
	@ParamDesc(path="IMEI_NO",cons=ConsType.QUES,len="100",desc="IMEI码",type="String",memo="略")
	private String imeiNo;
	@ParamDesc(path="SCORE_PRICE",cons=ConsType.QUES,len="100",desc="积分抵扣金额",type="String",memo="略")
	private String scorePrice;
	@ParamDesc(path="SERIAL_ID",cons=ConsType.QUES,len="100",desc="分表序号",type="String",memo="略")
	private String serialId;
	@ParamDesc(path="RESOURCE_NO",cons=ConsType.QUES,len="100",desc="資源串号",type="String",memo="略")
	private String resourceNo;
	@ParamDesc(path="ORDER_LINE_ID",cons=ConsType.QUES,len="100",desc="订单行ID",type="String",memo="略")
	private String orderLineId;
	@ParamDesc(path="TERMINAL_REAL_FEE",cons=ConsType.QUES,len="100",desc="终端实收价",type="long",memo="略")
	private String terminalRealFee;
	@ParamDesc(path="RESOURCE_USE",cons=ConsType.QUES,len="100",desc="终端用途",type="long",memo="略")
	private String resourceUse;
	@Override
	public void decode(Map in) {
		this.termiResCode = toStr(in.get("TERMI_RES_CODE"));
		this.imeiNo    =  toStr(in.get("IMEI_NO"));
		this.scorePrice    =  toStr(in.get("SCORE_PRICE"));
		this.serialId =  toStr(in.get("SERIAL_ID"));
		this.resourceNo = toStr(in.get("RESOURCE_NO"));
		this.orderLineId = toStr(in.get("ORDER_LINE_ID"));
		this.terminalRealFee = toStr(in.get("TERMINAL_REAL_FEE")); //终端退订增加
		this.resourceUse = toStr(in.get("RESOURCE_USE"));
	}
	
	@Override
	public Map<String, Object> encode() {
		Map<String, Object> termi =new HashMap<String, Object>();
		termi.put("TERMI_RES_CODE", getTermiResCode());
		termi.put("IMEI_NO",    getImeiNo());
		termi.put("SCORE_PRICE",    getScorePrice());
		termi.put("SERIAL_ID", this.getSerialId());
		termi.put("RESOURCE_NO", this.getResourceNo());
		termi.put("ORDER_LINE_ID", this.getOrderLineId());
		termi.put("TERMINAL_REAL_FEE",this.getTerminalRealFee());
		termi.put("RESOUCRCE_USE",this.getResourceUse());
		return termi;
	}
	
	public String getResourceUse() {
		return resourceUse;
	}

	public void setResourceUse(String resourceUse) {
		this.resourceUse = resourceUse;
	}

	public String getTermiResCode() {
		return termiResCode;
	}

	public void setTermiResCode(String termiResCode) {
		this.termiResCode = termiResCode;
	}

	public String getImeiNo() {
		return imeiNo;
	}

	public void setImeiNo(String imeiNo) {
		this.imeiNo = imeiNo;
	}

	public String getScorePrice() {
		return scorePrice;
	}

	public void setScorePrice(String scorePrice) {
		this.scorePrice = scorePrice;
	}

	public String getSerialId() {
		return serialId;
	}

	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}

	public String getResourceNo() {
		return resourceNo;
	}

	public void setResourceNo(String resourceNo) {
		this.resourceNo = resourceNo;
	}
	
	
	public String getOrderLineId() {
		return orderLineId;
	}

	public void setOrderLineId(String orderLineId) {
		this.orderLineId = orderLineId;
	}
	
	


	public String getTerminalRealFee() {
		return terminalRealFee;
	}

	public void setTerminalRealFee(String terminalRealFee) {
		this.terminalRealFee = terminalRealFee;
	}

	public String toStr(Object obj){
		if(obj == null){
			return "";
		}else{
		    return obj.toString();
		}
	}
	
	
	
}
