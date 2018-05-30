package com.sitech.market.busiobject.basicclass.dataclass;

import java.util.HashMap;
import java.util.Map;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.market.busiobject.basicclass.dtoclass.Decodeable;
import com.sitech.market.busiobject.basicclass.dtoclass.Encodeable;

public class ElecInfo implements Decodeable ,Encodeable{
	@ParamDesc(path="ELEC_CARD",cons=ConsType.CT001,type="String",len="20",desc="元素ID",memo="")
	private String elecCard;
	@ParamDesc(path="CARD_FEE",cons=ConsType.CT001,type="String",len="20",desc="元素ID",memo="")
	private String cardFee;
	@ParamDesc(path="SERIAL_ID",cons=ConsType.QUES,type="String",len="20",desc="元素ID",memo="")
	private String serialId;

	
	@Override
	public Map<String, Object> encode() {
		Map<String, Object> electInfo = new HashMap<String, Object>();
		electInfo.put("ELEC_CARD", getElecCard());
		electInfo.put("CARD_FEE",  getCardFee());
		electInfo.put("SERIAL_ID", getSerialId());
		return electInfo;
	}

	@Override
	public void decode(final Map in) {
		elecCard    = (String) in.get("ELEC_CARD");   //电子卡号
		cardFee     = (String) in.get("CARD_FEE");    //电子卡金额
		serialId	= (String) in.get("SERIAL_ID");   //分表序列id
	}

	public String getElecCard() {
		return elecCard;
	}
	public void setElecCard(String elecCard) {
		this.elecCard = elecCard;
	}
	public String getCardFee() {
		return cardFee;
	}
	public void setCardFee(String cardFee) {
		this.cardFee = cardFee;
	}
	public String getSerialId() {
		return serialId;
	}
	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}
}
