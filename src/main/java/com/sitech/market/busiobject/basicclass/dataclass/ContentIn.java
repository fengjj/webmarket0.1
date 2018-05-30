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

public class ContentIn implements Decodeable, Encodeable {
	@ParamDesc(path = "RELATION_ID", cons = ConsType.CT001, len = "100", desc = "业务与内容关系ID", type = "String", memo = "略")
	private String relationId;
	@ParamDesc(path = "PHONE_NO", cons = ConsType.CT001, len = "100", desc = "内容需要输入的办理号码", type = "String", memo = "略")
	private String phoneNo;
	// A06 add by wangdw 20150814 合约机和后合约，可选资费，选中的资费
	@ParamDesc(path = "A06", cons = ConsType.STAR, len = "100", desc = "可选资费信息", type = "Compx", memo = "略")
	private List<PrcInfo> prcInfos;
	@ParamDesc(path = "A09", cons = ConsType.CT001, len = "100", desc = "积分信息", type = "Compx", memo = "略")
	private ScoreInfo scoreInfo;
	@ParamDesc(path = "A11", cons = ConsType.PLUS, len = "100", desc = "终端信息列表", type = "Compx", memo = "略")
	private Termi termi;
	@ParamDesc(path = "CONTRACT_NO", cons = ConsType.QUES, len = "100", desc = "账户号码", type = "String", memo = "略")
	private String contractNo;
	@ParamDesc(path = "PHONE_TYPE", cons = ConsType.QUES, len = "100", desc = "手机号类型", type = "String", memo = "略")
	private String phoneType;
	
	@Override
	public void decode(Map in) {
		relationId    		= (String) in.get("RELATION_ID");
		phoneNo       		= (String) in.get("PHONE_NO");
		contractNo    		= (String) in.get("CONTRACT_NO"); 
		phoneType    		= (String) in.get("PHONE_TYPE"); 
		// A06 add by wangdw 20150814 合约机和后合约，可选资费，选中的资费
		List<Map> prcInList = (List<Map>) in.get("A06");
		if (CommonUtil.isNotEmpty(prcInList)) {
			prcInfos = new ArrayList<PrcInfo>();
			for (Map prcIn : prcInList) {
				PrcInfo prcInfo = new PrcInfo();
				System.out.println("===============prcIn==============="+prcIn);
				prcInfo.decode(prcIn);
				prcInfos.add(prcInfo);
			}
		}
		
		Map scoreIn = (Map) in.get("A09");
		if (CommonUtil.isNotEmpty(scoreIn)) {
			scoreInfo = new ScoreInfo();
			scoreInfo.decode(scoreIn);
		}

		Map termi_in = (Map)in.get("A11");
		if (CommonUtil.isNotEmpty(termi_in)) {
			termi = new Termi();
			termi.decode(termi_in);
		}
		
	}

	@Override
	public Map<String, Object> encode() {
		Map<String, Object> outContent = new HashMap<String, Object>();
		outContent.put("RELATION_ID", this.relationId);
		outContent.put("PHONE_NO", this.phoneNo);
		outContent.put("CONTRACT_NO", getContractNo());
		outContent.put("PHONE_TYPE", getPhoneType());
		
		// A06 add by wangdw 20150814 合约机和后合约，可选资费，选中的资费
		if (CommonUtil.isNotEmpty(prcInfos)) {
			List<Map> prcInList = new ArrayList<Map>();
			for (PrcInfo prcInfo : prcInfos) {
				prcInList.add(prcInfo.encode());
			}
			outContent.put("A06", prcInList);
		}
		
		if (CommonUtil.isNotEmpty(scoreInfo)) {
			outContent.put("A09", scoreInfo.encode());
		}

		if (CommonUtil.isNotEmpty(termi)) {
			System.out.println("termi.encode():" + termi.encode());
			outContent.put("A11", termi.encode());
		}
		
		return outContent;
	}

	public String getRelationId() {
		return relationId;
	}

	public void setRelationId(String relationId) {
		this.relationId = relationId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public ScoreInfo getScoreInfo() {
		return scoreInfo;
	}

	public void setScoreInfo(ScoreInfo scoreInfo) {
		this.scoreInfo = scoreInfo;
	}

	public Termi getTermi() {
		return termi;
	}

	public void setTermi(Termi termi) {
		this.termi = termi;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public List<PrcInfo> getPrcInfos() {
		return prcInfos;
	}

	public void setPrcInfos(List<PrcInfo> prcInfos) {
		this.prcInfos = prcInfos;
	}

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}


}
