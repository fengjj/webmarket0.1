package com.sitech.market.atom.destribution.impl;

import com.sitech.cache.Cache;
import com.sitech.jcfx.anno.ParamType;
import com.sitech.jcfx.anno.ParamTypes;
import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;
import com.sitech.jcfx.dt.out.OutDTO;
import com.sitech.market.atom.destribution.inter.IEventManager;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardOutDTO;
import com.sitech.market.busiobject.entity.busi.inter.IEventEntity;

/**
 * @author tianyy_bj
 *
 * @date:2014-11-15 下午5:09:22
 * @version :1.0
 *
 */
@ParamTypes({ 
    @ParamType(c = StandardInDTO.class, m = "getMaxTargetValue",oc=StandardOutDTO.class),
    @ParamType(c = StandardInDTO.class, m = "saveLaccis",oc=StandardOutDTO.class),
    @ParamType(c = StandardInDTO.class, m = "saveInit",oc=StandardOutDTO.class),
    @ParamType(c = StandardInDTO.class, m = "saveEventDefine",oc=StandardOutDTO.class),
    @ParamType(c = StandardInDTO.class, m = "saveImageGraph"),
    @ParamType(c = StandardInDTO.class, m = "insertMkEventmonitorInfo",oc=StandardOutDTO.class),
    @ParamType(c = StandardInDTO.class, m = "getEventData",oc=StandardOutDTO.class),
    @ParamType(c = StandardInDTO.class, m = "publishEvent",oc=StandardOutDTO.class),
    @ParamType(c = StandardInDTO.class, m = "queryMonitorGBetype",oc=StandardOutDTO.class),
    @ParamType(c = StandardInDTO.class, m = "queryMonitorGBtopic",oc=StandardOutDTO.class),
    @ParamType(c = StandardInDTO.class, m = "queryMonitorGBeventId",oc=StandardOutDTO.class),
    @ParamType(c = StandardInDTO.class, m = "getUsedDataTrac",oc=StandardOutDTO.class),
    @ParamType(c = StandardInDTO.class, m = "getUsedData",oc=StandardOutDTO.class),
    @ParamType(c = StandardInDTO.class, m = "deleteEvent"),
    @ParamType(c = StandardInDTO.class, m = "saveAudit"),
    @ParamType(c = StandardInDTO.class, m = "getEventTypeList"),
    @ParamType(c = StandardInDTO.class, m = "getMsgTypeList"),
    @ParamType(c = StandardInDTO.class, m = "udateInit"),
    @ParamType(c = StandardInDTO.class, m = "delEvent"),
    @ParamType(c = StandardInDTO.class, m = "updateEvent"),
    @ParamType(c = StandardInDTO.class, m = "getLoadFee"),
    @ParamType(c = StandardInDTO.class, m = "resetTime"),
    @ParamType(c = StandardInDTO.class, m = "showView"),
    @ParamType(c = StandardInDTO.class, m = "initAudit"),
    @ParamType(c = StandardInDTO.class, m = "sendKafkaMsg"),
    @ParamType(c = StandardInDTO.class, m = "setTotalTime"),
    @ParamType(c = StandardInDTO.class, m = "gotoTotalTime"),
    @ParamType(c = StandardInDTO.class, m = "initEventAudit"),
    @ParamType(c = StandardInDTO.class, m = "queryEventInfo"),
    @ParamType(c = StandardInDTO.class, m = "saveRecommendActInfo")})
public class EventManager implements IEventManager {
    private IEventEntity eventEntity;
  //TODO 暂时注释掉
    private Cache cache = null;//CacheHelper.getInstance();

    public void setEventEntity(IEventEntity eventEntity) {
        this.eventEntity = eventEntity;
    }

    @Override
    public OutDTO saveLaccis(InDTO inparam) {
    	StandardOutDTO ot = new StandardOutDTO();
    	MBean resultBean = new MBean();
    	Boolean o = eventEntity.insertMkMylacciInfo(inparam.getMbean());
    	resultBean.setBody("returnCode", o);
    	ot.setBean(resultBean);
    	return ot;
    }
    public OutDTO getMaxTargetValue(InDTO inparam) {
    	StandardOutDTO ot = new StandardOutDTO();
    	MBean resultBean = new MBean();
    	String o = eventEntity.getMaxTargetValue();
    	resultBean.setBody("targetValue", o);
    	ot.setBean(resultBean);
    	return ot;
    }
    public OutDTO insertMkEventmonitorInfo(InDTO inparam) {
    	StandardOutDTO ot = new StandardOutDTO();
    	MBean bean = inparam.getMbean();
    	MBean resultBean = new MBean();
    	Object o = eventEntity.insertMkEventmonitorInfo(bean);
    	resultBean.setBody("obj", o);
    	ot.setBean(resultBean);
    	return ot;
    }
    public OutDTO queryMonitorGBetype(InDTO inparam) {
    	StandardOutDTO ot = new StandardOutDTO();
    	MBean bean = inparam.getMbean();
    	MBean resultBean = eventEntity.queryMonitorGBetype(bean);
    	ot.setBean(resultBean);
    	return ot;
    }
    public OutDTO queryMonitorGBtopic(InDTO inparam) {
    	StandardOutDTO ot = new StandardOutDTO();
    	MBean bean = inparam.getMbean();
    	MBean resultBean = eventEntity.queryMonitorGBtopic(bean);
    	ot.setBean(resultBean);
    	return ot;
    }
    public OutDTO queryMonitorGBeventId(InDTO inparam) {
    	StandardOutDTO ot = new StandardOutDTO();
    	MBean bean = inparam.getMbean();
    	MBean resultBean = eventEntity.queryMonitorGBeventId(bean);
    	ot.setBean(resultBean);
    	return ot;
    }
    public OutDTO getUsedData(InDTO inparam) {
    	StandardOutDTO ot = new StandardOutDTO();
    	MBean bean = inparam.getMbean();
    	MBean resultBean = eventEntity.getUsedData(bean);
    	ot.setBean(resultBean);
    	return ot;
    }
    public OutDTO publishEvent(InDTO inparam) {
    	StandardOutDTO ot = new StandardOutDTO();
    	MBean bean = inparam.getMbean();
    	MBean resultBean = eventEntity.publishEvent(bean);
    	ot.setBean(resultBean);
    	return ot;
    }
    public OutDTO getUsedDataTrac(InDTO inparam) {
    	StandardOutDTO ot = new StandardOutDTO();
    	MBean bean = inparam.getMbean();
    	MBean resultBean = eventEntity.getUsedDataTrac(bean);
    	ot.setBean(resultBean);
    	return ot;
    }
    public OutDTO saveInit(InDTO inparam) {
    	StandardOutDTO ot = new StandardOutDTO();
    	MBean bean = inparam.getMbean();
    	MBean resultBean = eventEntity.saveInit(bean);
    	ot.setBean(resultBean);
    	return ot;
    }
    
	@Override
	public OutDTO saveEventDefine(InDTO inparam) {
    	StandardOutDTO ot = new StandardOutDTO();
    	MBean bean = inparam.getMbean();
    	MBean resultBean = eventEntity.saveEventDefine(bean);
    	ot.setBean(resultBean);
    	return ot;
	}
	
    public OutDTO getEventData(InDTO inparam) {
    	StandardOutDTO ot = new StandardOutDTO();
    	MBean bean = inparam.getMbean();
    	MBean resultBean = eventEntity.getEventData(bean);
    	ot.setBean(resultBean);
    	return ot;
    }

    public OutDTO saveImageGraph(InDTO inparam) {
        StandardOutDTO ot = new StandardOutDTO();
        MBean bean = inparam.getMbean();
        MBean resultBean = eventEntity.saveImageGraph(bean);
        ot.setBean(resultBean);
        return ot;
    }
    
    public OutDTO saveRecommendActInfo(InDTO inparam) {
        StandardOutDTO ot = new StandardOutDTO();
        MBean bean = inparam.getMbean();
        MBean resultBean = eventEntity.saveRecommendActInfo(bean);
        ot.setBean(resultBean);
        return ot;
    }

    public OutDTO deleteEvent(InDTO inparam) {
        StandardOutDTO ot = new StandardOutDTO();
        MBean bean = inparam.getMbean();
        MBean resultBean = eventEntity.deleteEvent(bean);
        if(null != cache){
        	cache.removeAll();
        }
        ot.setBean(resultBean);
        return ot;
    }
    
    public OutDTO updateEvent(InDTO inparam) {
        StandardOutDTO ot = new StandardOutDTO();
        MBean bean = inparam.getMbean();
//        UUID uuid = UUID.randomUUID();
//        System.out.println("====MEMCACHED START "+uuid.toString()+" "+new Date());
        if(null != cache){
        	cache.removeAll();
        }
//        System.out.println("====MEMCACHED END "+uuid.toString()+" "+new Date());
        MBean resultBean = eventEntity.updateEvent(bean);
//        System.out.println("====MEMCACHED MYSQL END "+uuid.toString()+" "+new Date());        
        ot.setBean(resultBean);
        return ot;
    }

    public OutDTO saveAudit(InDTO inparam) {
        StandardOutDTO ot = new StandardOutDTO();
        MBean bean = inparam.getMbean();
        MBean resultBean = eventEntity.saveAudit(bean);
        if(null != cache){
        	cache.removeAll();
        }
        ot.setBean(resultBean);
        return ot;
    }


    public OutDTO getEventTypeList(InDTO inparam) {
        StandardOutDTO ot = new StandardOutDTO();
        MBean bean = inparam.getMbean();
        MBean resultBean = eventEntity.getEventTypeList(bean);
        ot.setBean(resultBean);
        return ot;
    }

    public OutDTO getMsgTypeList(InDTO inparam) {
        StandardOutDTO ot = new StandardOutDTO();
        MBean bean = inparam.getMbean();
        MBean resultBean = eventEntity.getMsgTypeList(bean);
        ot.setBean(resultBean);
        return ot;
    }
    
    public OutDTO udateInit(InDTO inparam){
        StandardOutDTO ot = new StandardOutDTO();
        MBean bean = inparam.getMbean();
        MBean resultBean = eventEntity.udateInit(bean);
        ot.setBean(resultBean);
        return ot;
    }

    public OutDTO showView(InDTO inparam) {
        StandardOutDTO ot = new StandardOutDTO();
        MBean bean = inparam.getMbean();
        MBean resultBean = eventEntity.showView(bean);
        ot.setBean(resultBean);
        return ot;
    }
    public OutDTO getLoadFee(InDTO inparam) {
    	StandardOutDTO ot = new StandardOutDTO();
    	MBean bean = inparam.getMbean();
    	MBean resultBean = eventEntity.getLoadFee(bean);
    	ot.setBean(resultBean);
    	return ot;
    }
    public OutDTO resetTime(InDTO inparam) {
    	StandardOutDTO ot = new StandardOutDTO();
    	MBean bean = inparam.getMbean();
    	MBean resultBean = eventEntity.resetTime(bean);
    	ot.setBean(resultBean);
    	return ot;
    }
	public OutDTO initAudit(InDTO inparam) {
		StandardOutDTO ot = new StandardOutDTO();
    	MBean bean = inparam.getMbean();
    	MBean resultBean = eventEntity.initAudit(bean);
    	ot.setBean(resultBean);
		return ot;
	}
	public OutDTO initEventAudit(InDTO inparam) {
		StandardOutDTO ot = new StandardOutDTO();
    	MBean bean = inparam.getMbean();
    	MBean resultBean = eventEntity.initEventAudit(bean);
    	ot.setBean(resultBean);
		return ot;
	}

	public OutDTO sendKafkaMsg(InDTO inparam) {
		StandardOutDTO ot = new StandardOutDTO();
    	MBean bean = inparam.getMbean();
    	MBean resultBean = eventEntity.sendKafkaMsg(bean);
    	ot.setBean(resultBean);
		return ot;
	}
	public OutDTO setTotalTime(InDTO inparam) {
		StandardOutDTO ot = new StandardOutDTO();
		MBean bean = inparam.getMbean();
		MBean resultBean = eventEntity.setTotalTime(bean);
		ot.setBean(resultBean);
		return ot;
	}
	public OutDTO gotoTotalTime(InDTO inparam) {
		StandardOutDTO ot = new StandardOutDTO();
		MBean bean = inparam.getMbean();
		MBean resultBean = eventEntity.gotoTotalTime(bean);
		ot.setBean(resultBean);
		return ot;
	}
	
	/**
     * 
     * @Description: 根据条件查询营销事件的信息
     * @param @param inparam
     * @param @return   
     * @return OutDTO  
     * @throws
     * @author zhaiwt
     * @date Mar 31, 2015
     * @version V1.0
     * 修改时间    修改人    实现功能
     */
	@Override
	public OutDTO queryEventInfo(InDTO inparam) {
		StandardOutDTO ot = new StandardOutDTO();
		MBean bean = inparam.getMbean();
		MBean resultBean = eventEntity.queryEventInfo(bean);
		ot.setBean(resultBean);
		return ot;
	}
//    /**
//     * 清除缓存
//     * 
//     * @param eventId
//     */
//    private void removeCache(String eventId) {
//    	List list =queryEvent(eventId);
//        if(cache!=null){
//	    	if (null !=list && list.size()>0) {
//	    		String eventType =(String) ((Map) list.get(0)).get("busiType");
//	    		//短信夹带
//	    		if("00".equals(eventType)){
//	    			cache.remove("messattach_eventid");
//	    			cache.remove("messattach_custgroup_"+eventId);
//	    			cache.remove("messattach_warntype_"+eventId);
//	    			cache.remove("messattach_sms_"+eventId);
//	    			System.out.println("Memcache Clear:messattach");
//	    		//流量提醒	
//	    		}else if("04".equals(eventType)){
//	    			cache.remove("fluxremind_eventid");
//	    			cache.remove("fluxremind_black");
//	    			cache.remove("fluxremind_userstatus");
//	    			cache.remove("fluxremind_limit");
//	    			cache.remove("fluxremind_nolimitnofirst");
//	    			cache.remove("fluxremind_nolimitfirst");
//	    			cache.remove("fluxremind_iscust");
//	    			System.out.println("Memcache Clear:fluxremind");
//	    		//签到抽奖
//	    		}else if("05".equals(eventType)){
//	    			//暂无
//	    		//排行榜
//	    		}else if("06".equals(eventType)){
//	    			//暂无
//	    		//缴费
//	    		}else if("07".equals(eventType)){
//	    			cache.remove("payfee_eventid");
//	    			cache.remove("payfee_custgroup_"+eventId);
//	    			cache.remove("payfee_paymenttype_"+eventId);
//	    			cache.remove("payfee_limit_"+eventId);
//	    			cache.remove("payfee_times_"+eventId);
//	    			cache.remove("recommended_chntype_"+eventId);
//	    			cache.remove("recommended_sendmsg_"+eventId);
//	    			cache.remove("recommended_act_"+eventId);
//	    			//cache.remove("recommended_phoneno_"+eventId);//不删
//	    			System.out.println("Memcache Clear: payfee");
//	    		//产品订购
//	    		}else if("08".equals(eventType)){
//	    			cache.remove("productorder_eventid");
//	    			cache.remove("productorder_custgroup_"+eventId);
//	    			cache.remove("productorder_prcid_"+eventId);
//	    			cache.remove("productorder_times_"+eventId);
//	    			cache.remove("recommended_chntype_"+eventId);
//	    			cache.remove("recommended_sendmsg_"+eventId);
//	    			cache.remove("recommended_act_"+eventId);
//	    			System.out.println("Memcache Clear: productorder");
//	    		//终端订购
//	    		}else if("09".equals(eventType)){
//	    			cache.remove("terminalorder_eventid");
//	    			cache.remove("terminalorder_custgroup_"+eventId);
//	    			cache.remove("terminalorder_times_"+eventId);
//	    			cache.remove("terminalorder_tmplid_"+eventId);
////	    			cache.remove("recommended_phoneno_"+idno);//不删
//	    			System.out.println("Memcache Clear: terminalorder");
//	    		//精准推荐
//	    		}else if("10".equals(eventType)){
//	    			//暂无
//	    		}
//			}
//        }
//	}

}
