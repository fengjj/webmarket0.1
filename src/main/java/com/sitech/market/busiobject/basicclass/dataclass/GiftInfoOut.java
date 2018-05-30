package com.sitech.market.busiobject.basicclass.dataclass;

import java.util.HashMap;
import java.util.Map;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.market.busiobject.basicclass.dtoclass.Decodeable;
import com.sitech.market.busiobject.basicclass.dtoclass.Encodeable;

public class GiftInfoOut implements Encodeable ,Decodeable{
	@ParamDesc(path="SERIAL_ID",cons=ConsType.CT001,len="100",desc="分表流水",type="String",memo="略")
	private String  serialId;
	@ParamDesc(path="ELEMENT_ID",cons=ConsType.CT001,len="100",desc="元素id",type="String",memo="略")
	private String  elementId;
	@ParamDesc(path="ELEMENT_BATCH_NO",cons=ConsType.CT001,len="100",desc="元素批次",type="String",memo="略")
	private String  elementBatchNo;
	@ParamDesc(path="RESOURCE_NAME",cons=ConsType.CT001,len="100",desc="资源名称",type="String",memo="略")
	private String  resourceName;
	@ParamDesc(path="RESOURCE_CODE",cons=ConsType.CT001,len="100",desc="资源编码",type="String",memo="略")
	private String  resourceCode;
	@ParamDesc(path="AMOUNT",cons=ConsType.CT001,len="100",desc="资源数量",type="String",memo="略")
	private String  amount;
	@ParamDesc(path="UNIT",cons=ConsType.CT001,len="100",desc="资源单位",type="String",memo="略")
	private String  unit;
	@ParamDesc(path="PRICE",cons=ConsType.CT001,len="100",desc="资源价格",type="String",memo="略")
	private String  price;

	@Override
	public void decode(Map in) {
		setSerialId((String)in.get("SERIAL_ID"));
		setElementId((String)in.get("ELEMENT_ID"));
		setElementBatchNo((String)in.get("ELEMENT_BATCH_NO"));
		setResourceName((String)in.get("RESOURCE_NAME"));
		setResourceCode((String)in.get("RESOURCE_CODE"));
		setAmount(in.get("AMOUNT").toString());
		setUnit((in.get("UNIT").toString()));
		setPrice(in.get("PRICE").toString());
	}

	@Override
	public Map<String, Object> encode() {
		Map giftInfoOut = new HashMap();
		giftInfoOut.put("SERIAL_ID",getSerialId());
		giftInfoOut.put("ELEMENT_ID",getElementId());
		giftInfoOut.put("ELEMENT_BATCH_NO",getElementBatchNo());
		giftInfoOut.put("RESOURCE_NAME",getResourceName());
		giftInfoOut.put("RESOURCE_CODE",getResourceCode());
		giftInfoOut.put("AMOUNT",getAmount());
		giftInfoOut.put("UNIT",getUnit());
		giftInfoOut.put("PRICE",getPrice());
		return giftInfoOut;
	}

	
	
	
	public String getSerialId() {
		return serialId;
	}
	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}
	public String getElementId() {
		return elementId;
	}
	public void setElementId(String elementId) {
		this.elementId = elementId;
	}
	public String getElementBatchNo() {
		return elementBatchNo;
	}
	public void setElementBatchNo(String elementBatchNo) {
		this.elementBatchNo = elementBatchNo;
	}
	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getResourceCode() {
		return resourceCode;
	}
	public void setResourceCode(String resourceCode) {
		this.resourceCode = resourceCode;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
	

}
