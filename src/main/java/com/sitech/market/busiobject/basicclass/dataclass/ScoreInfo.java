package com.sitech.market.busiobject.basicclass.dataclass;

import java.util.HashMap;
import java.util.Map;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.market.busiobject.basicclass.dtoclass.Decodeable;
import com.sitech.market.busiobject.basicclass.dtoclass.Encodeable;

public class ScoreInfo implements Decodeable ,Encodeable{
	@ParamDesc(path="CONSUME_TYPE",cons=ConsType.QUES,len="100",desc="消费类型",type="String",memo="略")
	private String consumeType    ;
	@ParamDesc(path="SCORE_VALUE",cons=ConsType.QUES,len="100",desc="积分值",type="String",memo="略")
	private String scoreValue     ;
	@ParamDesc(path="DEDUCTION_MONEY",cons=ConsType.QUES,len="100",desc="抵扣金额",type="String",memo="略")
	private String deductionMoney ;
	@ParamDesc(path="SERIAL_ID",cons=ConsType.QUES,len="100",desc="分表序号",type="String",memo="略")
	private String serialId;
	public void decode(final Map in) {
		consumeType    = (String) in.get("CONSUME_TYPE");   //消费类型
		scoreValue     = (String) in.get("SCORE_VALUE");    //积分值
		deductionMoney = (String) in.get("DEDUCTION_MONEY");//抵扣金额
		serialId = (String)in.get("SERIAL_ID");
	}
	
	@Override
	public Map<String, Object> encode() {
		Map<String, Object> score = new  HashMap<String, Object>();
		score.put("CONSUME_TYPE",   getConsumeType());
		score.put("SCORE_VALUE",    getScoreValue());
		score.put("DEDUCTION_MONEY",getDeductionMoney());
		return score;
	}
	public String getConsumeType() {
		return consumeType;
	}
	public void setConsumeType(String consumeType) {
		this.consumeType = consumeType;
	}
	public String getScoreValue() {
		return scoreValue;
	}
	public void setScoreValue(String scoreValue) {
		this.scoreValue = scoreValue;
	}
	public String getDeductionMoney() {
		return deductionMoney;
	}
	public void setDeductionMoney(String deductionMoney) {
		this.deductionMoney = deductionMoney;
	}

	public String getSerialId() {
		return serialId;
	}

	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}
	
	

}
