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

public class MeansContent  implements Encodeable ,Decodeable{
	@ParamDesc(path="A00",cons=ConsType.STAR,len="100",desc="预存",type="compx",memo="略")
	private List<PreStoreOut>  preStoreList;
	@ParamDesc(path="A04",cons=ConsType.STAR,len="100",desc="促销品",type="compx",memo="略")
	private List<GiftInfoOut>  giftInfoList;
	@ParamDesc(path="A06",cons=ConsType.STAR,len="100",desc="资费",type="compx",memo="略")
	private List<ProcInfoOut>  procInfoList;
	@ParamDesc(path="A09",cons=ConsType.STAR,len="100",desc="积分",type="compx",memo="略")
	private List<ScoreInfoOut> scoreInfoList;
	@ParamDesc(path="A10",cons=ConsType.STAR,len="100",desc="分返",type="compx",memo="略")
	private List<RtnMonthOut>  rtnMonthList;
	@ParamDesc(path="A11",cons=ConsType.STAR,len="100",desc="终端",type="compx",memo="略")
	private List<TermiInfoOut> termiInfoList;
	@ParamDesc(path="A25",cons=ConsType.STAR,len="100",desc="券类",type="compx",memo="略")
	private List<TicketInfoOut> ticketInfoList;
	@ParamDesc(path="R08",cons=ConsType.STAR,len="100",desc="业务受限类",type="compx",memo="略")
	private List<CondInfoOut> condInfoOutList;
	
	@Override
	public void decode(Map in) {
		List<Map> a00_list = (List<Map>)in.get("A00");
		if(CommonUtil.isNotEmpty(a00_list)){
			preStoreList = new ArrayList<PreStoreOut>();
			for(Map<String, Object> a00In : a00_list){
				PreStoreOut ps = new PreStoreOut();
				ps.decode(a00In);
				preStoreList.add(ps);
        	}
		}
		
		List<Map> a04_list = (List<Map>)in.get("A04");
		if(CommonUtil.isNotEmpty(a04_list)){
			giftInfoList = new ArrayList<GiftInfoOut>();
			for(Map<String, Object> a04In : a04_list){
				GiftInfoOut gf = new GiftInfoOut();
				gf.decode(a04In);
				giftInfoList.add(gf);
        	}
		}
		
		List<Map> a06_list = (List<Map>)in.get("A06");
		if(CommonUtil.isNotEmpty(a06_list)){
			procInfoList = new ArrayList<ProcInfoOut>();
			for(Map<String, Object> a06In : a06_list){
				ProcInfoOut pr = new ProcInfoOut();
				pr.decode(a06In);
				procInfoList.add(pr);
        	}
		}
		
		List<Map> a09_list = (List<Map>)in.get("A09");
		if(CommonUtil.isNotEmpty(a09_list)){
			scoreInfoList = new ArrayList<ScoreInfoOut>();
			for(Map<String, Object> a09In : a09_list){
				ScoreInfoOut sc = new ScoreInfoOut();
				sc.decode(a09In);
				scoreInfoList.add(sc);
        	}
		}
		
		List<Map> a10_list = (List<Map>)in.get("A10");
		if(CommonUtil.isNotEmpty(a10_list)){
			rtnMonthList = new ArrayList<RtnMonthOut>();
			for(Map<String, Object> a10In : a10_list){
				RtnMonthOut rt = new RtnMonthOut();
				rt.decode(a10In);
				rtnMonthList.add(rt);
        	}
		}
		
		List<Map> a11_list = (List<Map>)in.get("A11");
		if(CommonUtil.isNotEmpty(a11_list)){
			termiInfoList = new ArrayList<TermiInfoOut>();
			for(Map<String, Object> a11In : a11_list){
				TermiInfoOut tm = new TermiInfoOut();
				tm.decode(a11In);
				termiInfoList.add(tm);
        	}
		}
		
		List<Map> a25_list = (List<Map>)in.get("A25");
		if(CommonUtil.isNotEmpty(a25_list)){
			ticketInfoList = new ArrayList<TicketInfoOut>();
			for(Map<String, Object> a25In : a25_list){
				TicketInfoOut tk = new TicketInfoOut();
				tk.decode(a25In);
				ticketInfoList.add(tk);
        	}
		}

		List<Map> r08_list = (List<Map>)in.get("R08");
		if(CommonUtil.isNotEmpty(r08_list)){
			condInfoOutList = new ArrayList<CondInfoOut>();
			for(Map<String, Object> r08In : r08_list){
				CondInfoOut tk = new CondInfoOut();
				tk.decode(r08In);
				condInfoOutList.add(tk);
        	}
		}
	}
	
	
	@Override
	public Map<String, Object> encode() {
		Map<String, Object> meansContent = new HashMap();
		if(CommonUtil.isNotEmpty(preStoreList)){
			List<Map> a00_list = new ArrayList();
			for(PreStoreOut preStore:preStoreList){
				a00_list.add(preStore.encode());
			}
			meansContent.put("A00", a00_list);
		}
		
		
		if(CommonUtil.isNotEmpty(giftInfoList)){
			List<Map> a04_list = new ArrayList();
			for(GiftInfoOut giftInfo:giftInfoList){
				a04_list.add(giftInfo.encode());
			}
			meansContent.put("A04", a04_list);
		}
		
		if(CommonUtil.isNotEmpty(procInfoList)){
			List<Map> a06_list = new ArrayList();
			for(ProcInfoOut prcInfo:procInfoList){
				a06_list.add(prcInfo.encode());
			}
			meansContent.put("A06", a06_list);
		}
		
		if(CommonUtil.isNotEmpty(scoreInfoList)){
			List<Map> a09_list = new ArrayList();
			for(ScoreInfoOut scoreInfo:scoreInfoList){
				a09_list.add(scoreInfo.encode());
			}
			meansContent.put("A09", a09_list);
		}
		
		if(CommonUtil.isNotEmpty(rtnMonthList)){
			List<Map> a10_list = new ArrayList();
			for(RtnMonthOut rtnMonth:rtnMonthList){
				a10_list.add(rtnMonth.encode());
			}
			meansContent.put("A10", a10_list);
		}
		
		if(CommonUtil.isNotEmpty(termiInfoList)){
			List<Map> a11_list = new ArrayList();
			for(TermiInfoOut termiInfo:termiInfoList){
				a11_list.add(termiInfo.encode());
			}
			meansContent.put("A11", a11_list);
		}
		
		if(CommonUtil.isNotEmpty(ticketInfoList)){
			List<Map> a25_list = new ArrayList();
			for(TicketInfoOut ticketInfo:ticketInfoList){
				a25_list.add(ticketInfo.encode());
			}
			meansContent.put("A25", a25_list);
		}
		
		if(CommonUtil.isNotEmpty(condInfoOutList)){
			List<Map> r08_list = new ArrayList();
			for(CondInfoOut condInfo:condInfoOutList){
				r08_list.add(condInfo.encode());
			}
			meansContent.put("R08", r08_list);
		}
	
		return meansContent;
	}
	
	
	
	public List<PreStoreOut> getPreStoreList() {
		return preStoreList;
	}
	public void setPreStoreList(List<PreStoreOut> preStoreList) {
		this.preStoreList = preStoreList;
	}
	public List<GiftInfoOut> getGiftInfoList() {
		return giftInfoList;
	}
	public void setGiftInfoList(List<GiftInfoOut> giftInfoList) {
		this.giftInfoList = giftInfoList;
	}
	public List<ProcInfoOut> getProcInfoList() {
		return procInfoList;
	}
	public void setProcInfoList(List<ProcInfoOut> procInfoList) {
		this.procInfoList = procInfoList;
	}
	public List<ScoreInfoOut> getScoreInfoList() {
		return scoreInfoList;
	}
	public void setScoreInfoList(List<ScoreInfoOut> scoreInfoList) {
		this.scoreInfoList = scoreInfoList;
	}
	public List<RtnMonthOut> getRtnMonthList() {
		return rtnMonthList;
	}
	public void setRtnMonthList(List<RtnMonthOut> rtnMonthList) {
		this.rtnMonthList = rtnMonthList;
	}
	public List<TermiInfoOut> getTermiInfoList() {
		return termiInfoList;
	}
	public void setTermiInfoList(List<TermiInfoOut> termiInfoList) {
		this.termiInfoList = termiInfoList;
	}


	public List<TicketInfoOut> getTicketInfoList() {
		return ticketInfoList;
	}


	public void setTicketInfoList(List<TicketInfoOut> ticketInfoList) {
		this.ticketInfoList = ticketInfoList;
	}


	public List<CondInfoOut> getCondInfoOutList() {
		return condInfoOutList;
	}


	public void setCondInfoOutList(List<CondInfoOut> condInfoOutList) {
		this.condInfoOutList = condInfoOutList;
	}

	
	
}
