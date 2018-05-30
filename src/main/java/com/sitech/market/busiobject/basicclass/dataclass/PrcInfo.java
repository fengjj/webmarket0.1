package com.sitech.market.busiobject.basicclass.dataclass;

import java.util.HashMap;
import java.util.Map;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.market.busiobject.basicclass.dtoclass.Decodeable;
import com.sitech.market.busiobject.basicclass.dtoclass.Encodeable;

public class PrcInfo implements Decodeable ,Encodeable {
	@ParamDesc(path="BATCH_NO",cons=ConsType.QUES,len="100",desc="元素批次号",type="String",memo="略")
	private String elementBatchNo;
	@ParamDesc(path="PROD_PRCID",cons=ConsType.QUES,len="100",desc="资费id",type="String",memo="略")
	private String prodPrcid;
	@ParamDesc(path="EFF_DATE",cons=ConsType.QUES,len="100",desc="资费生效时间",type="String",memo="略")
	private String effDate;
	@ParamDesc(path="EXP_DATE",cons=ConsType.QUES,len="100",desc="资费失效时间",type="String",memo="略")
	private String expDate;
	@ParamDesc(path="SERIAL_ID",cons=ConsType.QUES,len="100",desc="分表序号",type="String",memo="略")
	private String serialId;
	@ParamDesc(path="PRC_ID",cons=ConsType.QUES,len="100",desc="资费ID",type="String",memo="略")
	private String prcId;
	@ParamDesc(path="PRC_NAME",cons=ConsType.QUES,len="100",desc="资费名称",type="String",memo="略")
	private String prcName;
	@ParamDesc(path="CHOOSE_TYPE",cons=ConsType.QUES,len="100",desc="可选类型，0是必须，1是可选",type="String",memo="略")
	private String chooseType;
	public void decode(final Map in) {
		this.elementBatchNo =   (String) in.get("BATCH_NO");
		this.prodPrcid      =   (String) in.get("PROD_PRCID");
		this.effDate        =   (String) in.get("EFF_DATE");
		this.expDate        =   (String) in.get("EXP_DATE");
		 serialId = (String)in.get("SERIAL_ID");
		 System.out.println(".........PRC_ID........."+in.get("PRC_ID"));
		 prcId = (String)in.get("PRC_ID");
		 prcName = (String)in.get("PRC_NAME");
		 chooseType = (String)in.get("CHOOSE_TYPE");
	}
	@Override
	public Map<String, Object> encode() {
		Map<String, Object> prcInfo = new HashMap<String, Object>();
		prcInfo.put("BATCH_NO",  getElementBatchNo());
		prcInfo.put("PROD_PRCID",getProdPrcid());
		prcInfo.put("EFF_DATE",  getEffDate());
		prcInfo.put("EXP_DATE",  getExpDate());
		prcInfo.put("PRC_ID", 	 getPrcId());
		prcInfo.put("PRC_NAME",  getPrcName());
		prcInfo.put("CHOOSE_TYPE", getChooseType());
		return prcInfo;
	}
	
	public String getElementBatchNo() {
		return elementBatchNo;
	}
	public void setElementBatchNo(String elementBatchNo) {
		this.elementBatchNo = elementBatchNo;
	}
	public String getProdPrcid() {
		return prodPrcid;
	}
	public void setProdPrcid(String prodPrcid) {
		this.prodPrcid = prodPrcid;
	}
	public String getEffDate() {
		return effDate;
	}
	public void setEffDate(String effDate) {
		this.effDate = effDate;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public String getSerialId() {
		return serialId;
	}
	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}
	public String getPrcId() {
		return prcId;
	}
	public void setPrcId(String prcId) {
		this.prcId = prcId;
	}
	public String getPrcName() {
		return prcName;
	}
	public void setPrcName(String prcName) {
		this.prcName = prcName;
	}
	public String getChooseType() {
		return chooseType;
	}
	public void setChooseType(String chooseType) {
		this.chooseType = chooseType;
	}
	
	

}
