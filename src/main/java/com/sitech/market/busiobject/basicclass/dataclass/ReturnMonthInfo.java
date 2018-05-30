package com.sitech.market.busiobject.basicclass.dataclass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.market.busiobject.basicclass.dtoclass.Decodeable;
import com.sitech.market.busiobject.basicclass.dtoclass.Encodeable;

public class ReturnMonthInfo implements Decodeable ,Encodeable{
	@ParamDesc(path="GIVE_PHONE",cons=ConsType.QUES,len="100",desc="分月返还赠费号码",type="String",memo="略")
	private String            givePhone;
	@ParamDesc(path="RETURN_MONTH",cons=ConsType.PLUS,len="100",desc="分月返还月份列表",type="Compx",memo="略")
	private List<ReturnMonth> rtnMonthList;
	
	@Override
	public void decode(final Map in) {
		this.givePhone = (String) in.get("GIVE_PHONE");
		 
        List<Map> return_month_list = (List<Map>)in.get("RETURN_MONTH");  
        rtnMonthList = new ArrayList<ReturnMonth>();
        if(return_month_list!=null){
        	for(Map<String, Object> rtnIn : return_month_list){
        		ReturnMonth rtn = new ReturnMonth();
        		rtn.decode(rtnIn);
        		rtnMonthList.add(rtn);
        	}
        }
	}
	
	@Override
	public Map<String, Object> encode() {
		Map<String, Object> rtn = new HashMap<String, Object>();
		rtn.put("GIVE_PHONE",  getGivePhone());
		
		List<Map> rtn_list =new ArrayList<Map>();
		if(rtnMonthList!=null){
			for(ReturnMonth r:rtnMonthList){
				rtn_list.add(r.encode());
			}
		}
		rtn.put("RETURN_MONTH", rtn_list);
		return null;
	}

	public String getGivePhone() {
		return givePhone;
	}

	public void setGivePhone(String givePhone) {
		this.givePhone = givePhone;
	}

	public List<ReturnMonth> getRtnMonthList() {
		return rtnMonthList;
	}

	public void setRtnMonthList(List<ReturnMonth> rtnMonthList) {
		this.rtnMonthList = rtnMonthList;
	}


}
