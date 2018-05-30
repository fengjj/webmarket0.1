package com.sitech.market.busiobject.entity.busi.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import org.eclipse.jetty.util.log.Log;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.sitech.jcf.core.exception.BaseException;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.entity.busi.inter.IEventEntity;
import com.sitech.market.dbo.destribution.inter.IEvent;
import com.sitech.market.dbo.destribution.inter.IEventNosql;
import com.sitech.market.dbo.destribution.inter.IMkMonitorInfo;
import com.sitech.market.dbo.destribution.inter.IMkMylacciInfo;
import com.sitech.util.Const;
import com.sitech.util.ESPUtil;
import com.sitech.util.JavaForPage;
import com.sitech.util.MBeanUtil;
import com.sitech.util.PropertiesUtil;
import com.sitech.util.RandomUtil;
import com.sitech.util.SequUtil;

public class EventEntity implements IEventEntity {

    private IEvent event;
    private IMkMonitorInfo mkMonitorInfo;
    private IMkMylacciInfo mkMylacciInfo;
    private IEventNosql eventNosql;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
    
    ////////////////////
    public Boolean insertMkMylacciInfo(MBean bean){
    	Map<String,Object> map = new HashMap<>();
    	map.put("serialId", SequUtil.getSequ());
    	map.put("name", bean.getBodyStr("name"));
    	map.put("lacciGroup", bean.getBodyStr("lacciGroup"));
    	map.put("imgUrl", bean.getBodyStr("imgUrl"));
    	map.put("operNo", bean.getBodyStr("operNo"));
    	map.put("operTime", new Date());
    	map.put("regionId", bean.getBodyStr("regionId"));
    	return mkMylacciInfo.add(map);
    }
    
    
    /**
     * 返回最大的指标值，并入库
     * 同步此方法，不可以并发调用
     * @return
     */
    @Override
    public synchronized String getMaxTargetValue(){
    	String targetStart = "L";
    	Map<String,Object> inMap = new HashMap<String,Object>();
    	Integer maxValue = event.selectMaxTargetValue();
    	maxValue++;
    	inMap.put("targetStart",targetStart);
    	inMap.put("targetEnd",maxValue);
    	inMap.put("createTime",new Date());
    	event.insertTargetValue(inMap);
    	return targetStart+maxValue;
    }
    
    /**
     * 记录表添加记录
     */
    public  Object insertMkEventmonitorInfo(MBean bean){
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("monitorId", SequUtil.getSequ());
    	map.put("eventId", bean.getBodyStr("eventId"));
    	map.put("statusCode", bean.getBodyStr("statusCode"));
    	map.put("moniTimetype", bean.getBodyStr("moniTimetype"));
    	map.put("moniTimeval", bean.getBodyStr("moniTimeval"));
    	map.put("operNo", bean.getBodyStr("operNo"));
    	map.put("operName", bean.getBodyStr("operName"));
    	map.put("operTime", bean.getBodyStr("operTime"));
    	Object obj = mkMonitorInfo.insertMkEventmonitorInfo(map);
    	return obj;
    }
    /**
     * 发布活动后返回活动类型和目标客户群
     */
    //TODO 
    public  MBean publishEvent(MBean bean){
    	MBean rbean = new MBean();
        String eventId = bean.getBodyStr("eventId");
        String loginNo = bean.getBodyStr("operNo");
        String loginName = bean.getBodyStr("operName");
        String statusCode = bean.getBodyStr("statuscode");
        bean.setBody("serialNo",eventId);
        Map map = event.queryEventInfoByid(bean);
        if(map==null){
        	rbean.setBody("returnCode", "-1");
        	return rbean;
        }
     // 插入历史表
        String trac_id = SequUtil.getSequ();// 随机数生成主键
        bean.setBody("trac_id", trac_id);
        bean.setBody("update_type", "U");
        bean.setBody("login_no", loginNo);
        bean.setBody("login_name",loginName);
        event.insertMkEventTracByEventid(bean);
        event.updateMkEventInfoStatus(bean);
        
    	
    	rbean.setBody("returnCode", "0");
    	rbean.setBody("eventType", map.get("busiType"));
    	rbean.setBody("custGroupId", map.get("custGroupId"));
    	return rbean;
    }
    /**
     * 按照活动类型来查询活动触发消息数year，month
     */
    public  MBean queryMonitorGBetype(MBean bean){
    	MBean rbean = new MBean();
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("year", bean.getBodyStr("year"));
    	map.put("month", bean.getBodyStr("month"));
    	List<Map> list = mkMonitorInfo.queryMonitorGBetype(map);
    	rbean.setBody("list", list);
    	return rbean;
    }
    /**
     * 按照主题来查询触发数量year，month
     */
    public  MBean queryMonitorGBtopic(MBean bean){
    	MBean rbean = new MBean();
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("year", bean.getBodyStr("year"));
    	map.put("month", bean.getBodyStr("month"));
    	List<Map> list = mkMonitorInfo.queryMonitorGBetype(map);
    	rbean.setBody("list", list);
    	return rbean;
    }
    /**
     * 按照活动来查，指定时间的变化默认当天的，自由参数
     */
    public  MBean queryMonitorGBeventId(MBean bean){
    	MBean rbean = new MBean();
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("eventId", bean.getBodyStr("eventId"));
    	map.put("year", bean.getBodyStr("year"));
    	map.put("month", bean.getBodyStr("month"));
    	map.put("day", bean.getBodyStr("day"));
    	List<Map> list = mkMonitorInfo.queryMonitorGBeventId(map);
    	String count = "0";
    	if(list!=null){
    		count = String.valueOf(list.get(0).get("count"));
    	}
    	rbean.setBody("count", count);
    	return rbean;
    }
    /////////////////////
    @Override
	public MBean getEventData(MBean bean) {
    	String eventId = bean.getBodyStr("eventId");
    	String eventName = bean.getBodyStr("eventName");
    	String type = bean.getBodyStr("type");
    	MBean rbean = new MBean();
    	if("0".equals(type)){
    		//查流量数据
    		String alldata = event.queryDataCount(eventId);
    		rbean.setBody("allData", alldata);
    		rbean.setBody("preData", "0");
    	}else{
    		//查位置营销数据
    		String alldata = event.queryAllDataById(eventId);
        	String predata = event.queryPreDataById(eventId);
        	rbean.setBody("allData", alldata);
        	rbean.setBody("preData", predata);
    	}
    	
    	return rbean;
    }
    /**
     * 查询用户的流量累计轨迹
     */
    @Override
    public MBean getUsedDataTrac(MBean bean) {
    	List<Map> dataList = event.queryUsedDataTrac(bean.getBody());
    	Log.info("dataList:"+dataList.size());
    	//先放到一个map里
    	Map<Long,Object> tempMap = new HashMap<Long,Object>();
    	for(Map map :dataList){
    		String time = (String)map.get("hour");
    		try {
    			System.out.println("time::::::::::::;"+sdf.parse(time+"").getTime());
				tempMap.put(sdf.parse(time+"").getTime(),map.get("data"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
    	}
    	List<Object> rList = new ArrayList<Object>();
    	//临时变量 记录时间和使用量
    	Object td = "0";
    	String startTime="",endTime = "";
    	if(dataList!=null){
    		startTime = (String)dataList.get(0).get("hour");
    		endTime = (String)dataList.get(dataList.size()-1).get("hour");
    		Log.info("startTime:"+startTime+"  endTime:"+endTime);
    		try{
    			Date d1 = sdf.parse(startTime);
    			Date d2 = sdf.parse(endTime);
    			long l = d2.getTime()-d1.getTime();
    			l = l/1000/3600+1;
    			System.out.println("lllllllllllllllllll:"+l);
	    		for(int i = 0;i<l;i++){
	    			System.out.println(d1.getTime()+i*1000*3600);
	    			int d = 0;
	    			try{
	    				d =  Integer.parseInt(tempMap.get(d1.getTime()+i*1000*3600).toString());
	    				td = d/1024/1024;
	    			}catch(Exception e){
	    			}
	    			rList.add(td);
	    			d1 = sdf.parse(startTime+"");
	    		}
    		}catch(Exception e){
    		}
    		Log.info("rList:"+rList.size());
    	}
    	
    	//
    	MBean rbean = new MBean();
    	rbean.setBody("dataList",rList);
    	rbean.setBody("startTime",startTime);
    	return rbean;
    }
    @Override
    public MBean getUsedData(MBean bean) {
    	String eventId = bean.getBodyStr("eventId");
    	String phoneNo = bean.getBodyStr("phoneNo");
    	Map map = new HashMap();
    	map.put("phoneNo", phoneNo);
    	List<Map> dataList = event.queryUsedDataGroupByPhoneNo(map);
    	
    	String[] usedDatas = new String[]{"0","0","0","0"};
    	//暂时放剩余流量 totalDatas
    	String[] totalDatas = new String[]{"0","0","0","0"};
    	for(Map usedMap:dataList){
    		String dataType = (String)usedMap.get("dataType");
			String usedData = (String)usedMap.get("usedData");
			String leftData = (String)usedMap.get("leftData");
    		//转换
        	if("0".equals(dataType)){
    			usedDatas[0] = usedData;
    			totalDatas[0] = leftData;
    		}else if("1".equals(dataType)){
    			usedDatas[1] = usedData;
    			totalDatas[1] = leftData;
    			
    		}else if("4".equals(dataType)){
    			usedDatas[2] = usedData;
    			totalDatas[2] = leftData;
    			
    		}else if("6".equals(dataType)){
    			usedDatas[3] = usedData;
    			totalDatas[3] = leftData;
    		}
    	}
    	
    	//
    	MBean rbean = new MBean();
    	rbean.setBody("usedDatas", usedDatas);
    	rbean.setBody("totalDatas", totalDatas);
    	return rbean;
    }

    /**
     *
     * Create on 2014-11-15 下午4:52:17
     *
     * @author tianyy_bj
     * @version 1.0 Copyright(c) 北京思特奇信息技术股份有限公司 功能描述： 修改日期: 修改人: 修改目的:
     */
    @Override
	public MBean saveInit(MBean bean) {
        MBean rbean = new MBean();
        String provinceCode = bean.getBodyStr("provinceCode");
        rbean.setBody("actionList", queryActConductList("0"));// 动作
        rbean.setBody("conductList", queryActConductList("1"));// 行为
        rbean.setBody("actionParList", queryActConductParList());// 动作
        rbean.setBody("conductParList", queryActConductParList());// 行为
        rbean.setBody("permissionList", queryPermissionList());// 限制类型
        rbean.setBody("eventTypeList", queryEventType(provinceCode));// 业务类型
        rbean.setBody("msgTypeList", queryMsgType(provinceCode));// 短信类型

        /*rbean.setBody("msgSendTypeList", queryType("mk_msgsendtype_dict"));//短信发送类型
        rbean.setBody("dateLimitTypeList", queryType("mk_datelimittype_dict"));//短信类型
        rbean.setBody("fippingFrequencyList", queryType("mk_fippingfrequency_dict"));//触发频率
        rbean.setBody("cycleTimeList", queryType("mk_cycletime_dict"));//周期时长
        rbean.setBody("blaclFlagList", queryType("mk_blackflag_dict"));//短信类型
        rbean.setBody("statusCodeList", queryType("mk_statuscode_dict"));//短信类型
        rbean.setBody("userActionList", queryType("mk_useraction_dict"));//短信类型
*/
        return rbean;
    }

    /**
     *
     * Create on 2014-11-15 下午4:52:17
     *
     * @author tianyy_bj
     * @version 1.0 Copyright(c) 北京思特奇信息技术股份有限公司 功能描述： 修改日期: 修改人: 修改目的:
     * update by fengjj
     * bak:简化一下，不读取图形配置表
     */
    //TODO 
    @Override
	public MBean udateInit(MBean bean) {
        MBean rbean = new MBean();
        String eventId = bean.getBodyStr("eventId");
        String provinceCode = bean.getBodyStr("provinceCode");
        MBean tbean = new MBean();
        tbean.setBody("actId", eventId);
        Map<String,String> map = new HashMap<String,String>();
        map.put("eventId", eventId);
        //List[] imgContent = queryImgContent(eventId);
        List<Map> imgConnList = event.queryImgContentListActid(tbean);
        rbean.setBody("serialNo", eventId);// 事件id
        rbean.setBody("itemList",event.selectConductsById(map));// 节点信息列表
        //rbean.setBody("contentList", imgContent[1]);// 动作行为信息
        //rbean.setBody("connList", imgContent[2]);// 连线信息
        rbean.setBody("contentList", imgConnList);// 动作行为信息
        rbean.setBody("actionList", queryActConductList(Const.ACTION_0));// 动作
        rbean.setBody("conductList", queryActConductList(Const.ACTION_1));// 行为
        /*rbean.setBody("actionParList", queryActConductParList());// 动作
        rbean.setBody("conductParList", queryActConductParList());// 行为
        rbean.setBody("permissionList", queryPermissionList());// 限制类型
*/        
        return rbean;
    }

    /**
     *
     * Create on 2014-11-15 下午4:52:17
     *
     * @author tianyy_bj
     * @version 1.0 Copyright(c) 北京思特奇信息技术股份有限公司 功能描述： 修改日期: 修改人: 修改目的:
     */
    @Override
	public MBean showView(MBean bean) {
        MBean rbean = new MBean();
        String eventId = bean.getBodyStr("eventId");
        String provinceCode = bean.getBodyStr("provinceCode");
        List actconductList = queryActConduct(eventId);// 动作行为列表
//        List actconList = new ArrayList();
//        for (int i = 0; i < actconductList.size(); i++) {
//            Map row = (Map) actconductList.get(i);
//            String actionName = queryActConductName((String) row.get("actionId"));
//            List acttionList = queryActConductContent(eventId, (String) row.get("actionId"), (String) row.get("batchNo"), provinceCode);
//            Map map = new HashMap();
//            map.put("actionName", actionName);
//            map.put("acttionList", acttionList);
//            actconList.add(map);
//        }
        String statusCode = (String) ((Map) actconductList.get(0)).get("batchNo");
        // 获取动作
        String actionId= (String) ((Map) actconductList.get(0)).get("actionId");
        String actionName = queryActConductName(actionId);
        List actionList = queryActConductContent(eventId, actionId,statusCode, provinceCode);
        // 获取行为
        String conductId =(String) ((Map) actconductList.get(0)).get("conductId");
        String conductName = queryActConductName(conductId);// 行为名称
        List conductList = queryActConductContent(eventId, conductId,statusCode, provinceCode);
        //获取事件基本信息
        Map eventBasicMap = getEventBasicById(eventId);
        rbean.setBody("actionId", actionId);
        rbean.setBody("actionName", actionName);
        rbean.setBody("actionList", actionList);
        rbean.setBody("conductList", conductList);
        rbean.setBody("conductId", conductId);
        rbean.setBody("conductName", conductName);
        rbean.setBody("eventBasicMap", eventBasicMap);
        return rbean;
    }

    private Map getEventBasicById(String eventId) {
		Map eventMap=event.queryEventBasicById(eventId);
		return eventMap;
	}

	public void setEvent(IEvent event) {
        this.event = event;
    }

    public void setEventNosql(IEventNosql eventNosql) {
		this.eventNosql = eventNosql;
	}
    
    /**
     * 保存事件定义--合并saveInit+saveImageGraph
     * @author Jon
     */
	@Override
	public MBean saveEventDefine(MBean bean) {
		MBean rbean = new MBean();
		String provinceCode = bean.getBodyStr("provinceCode");
        rbean.setBody("actionList", queryActConductList("0"));// 动作
        rbean.setBody("conductList", queryActConductList("1"));// 行为
        rbean.setBody("actionParList", queryActConductParList());// 动作
        rbean.setBody("conductParList", queryActConductParList());// 行为
        rbean.setBody("permissionList", queryPermissionList());// 限制类型
        rbean.setBody("eventTypeList", queryEventType(provinceCode));// 业务类型
        rbean.setBody("msgTypeList", queryMsgType(provinceCode));// 短信类型
        //--以上saveInit--以下saveGraph--
        String operNo = bean.getBodyStr("operNo");
        String operName = bean.getBodyStr("operNme");
        String regionCode = bean.getBodyStr("regionCode");
        String eventId = bean.getBodyStr("eventId");
        String eventType = bean.getBodyStr("eventType");
        //String endVertex = bean.getBodyStr("endVertex");
        
        String serialId = "";
        if(!"-1".equals(eventId)){
        	ESPUtil.publishToESPWindow(eventType,eventId,"DELETE");
        }
        if (!"".equals(eventId) && !"-1".equals(eventId)) {
            serialId = eventId;
        } else {
            serialId = SequUtil.getSequ(3);
        }
        //SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        List<Map> eventInfo = new ArrayList<Map>();
        List<Map> eventContent = new ArrayList<Map>();
        List<String> actionIds = new ArrayList<String>();
        List<String> conductIds = new ArrayList<String>();
        String conductId = "";
        Map<String,Object> tbean = new HashMap<String, Object>();
        
        String eventName = "";
        String startDate = "";
        String endDate = "";
        String eventDesc = "";
        
        String basicValue = "";
        String elementKey = "";
        String elementvalue = "";
        String[] basicValues = {};
        String[] actValues = {};
        String parmId = "";
        String parmValue = "";
        String[] positions = {};
        
        String track = bean.getBodyStr("track");
        String[] trackSplit = track.split(";");
        for(String ts:trackSplit){
        	System.out.println("track---:"+ts);
        	int num = 0;
            String[] elements = ts.split("@");
            for(String element:elements){      //1032_0=_103205:|_103203:1645        1032_0=_103205:|_103203:1645  ...
            	System.out.println("element---:"+element);
            	if(element.startsWith("basic{")){ //基础信息
        			basicValue = element.substring(element.indexOf("{")+1, element.indexOf("}"));
        			if(basicValue.indexOf(":") == -1) continue;
                    basicValues = basicValue.split("\\|");
                    for(String bv:basicValues){ //获取基本信息里的参数
                    	switch(bv.substring(0, bv.indexOf(":"))){
                    	case "eventName":
                    		eventName = bv.substring(bv.indexOf(":")+1);break;
                    	case "startDate":
                    		startDate = bv.substring(bv.indexOf(":")+1);break;
                    	case "endDate":
                    		endDate = bv.substring(bv.indexOf(":")+1);break;
                    	case "eventDesc":
                    		eventDesc = bv.substring(bv.indexOf(":")+1);break;
                    	}
                    }
        		}else if(element.indexOf("=") != -1){
            		elementKey = element.substring(0, element.indexOf("=")); //1025_0    1032_0  ...
            		if("1".equals(elementKey.substring(elementKey.indexOf("_")+1, elementKey.length()))){
            			conductIds.add(elementKey.substring(0, elementKey.indexOf("_"))); //1002,1003,...
                	}else if("0".equals(elementKey.substring(elementKey.indexOf("_")+1, elementKey.length()))){
                		actionIds.add(elementKey.substring(0, elementKey.indexOf("_"))); //1002,1003,...
                	}
            		elementvalue = element.substring(element.indexOf("=")+1);
            		actValues = elementvalue.split("\\|"); //_10251:250E3C01D9,A5119F05,5173F32C,|_10255:|_10256:|_10252:4
               		for(String av:actValues){
            			parmId = av.substring(1, av.indexOf(":")); //10251
            			conductId = parmId.substring(0,parmId.length()-1);
            			parmValue = av.substring(av.indexOf(":")+1); //250E3C01D9,A5119F05,5173F32C,
		    			 if("10251".equals(parmId)){  //位置要拆分添加
		    				 positions = parmValue.split(",");
		    				 for(String p:positions){
		    					 tbean = new HashMap<String, Object>();
		                 		 tbean.put("eventId", serialId);
		                         tbean.put("actconductParId", parmId);
		                         tbean.put("actconductId", conductId);
		                         tbean.put("actconductParValue", p);
		                         tbean.put("batchNo", num + "");
		                         eventContent.add(tbean);
		    				 }
		    			 }else{ //非10251  key:value  |_10255:|_10256:|_10252:4|_10258:60|_10259:1
		    				 tbean = new HashMap<String, Object>();
		                     tbean.put("eventId", serialId);
		                     tbean.put("actconductParId", parmId);
		                     tbean.put("actconductId", conductId);
		                     tbean.put("actconductParValue", parmValue);
		                     tbean.put("batchNo", num + "");
		                     eventContent.add(tbean); //每add一个数据裤记录添加一条
		    			 }
		    		}
            	}
            }
            // 拆分事件信息
            //for (int n = 0; n < actionIds.size(); n++) {
            	tbean = new HashMap<String, Object>();
                tbean.put("eventId", serialId);
                tbean.put("actionId", actionIds.get(0));
                tbean.put("conductId", conductIds.get(0));
                tbean.put("operNo", operNo);
                tbean.put("operName", operName);
                tbean.put("operDate", new Date());
                tbean.put("content", "");
                tbean.put("statusCode", Const.ActStatusCode_00);
                tbean.put("regionCode", regionCode);
                //tbean.put("batchNo", "" + n + "");
                tbean.put("eventName", eventName);
                if(!"".equals(startDate)){
                	tbean.put("startDate", startDate);
                }
                if(!"".equals(endDate)){
                	tbean.put("endDate", endDate);
                }
                tbean.put("eventType", eventType+"");
                tbean.put("eventDesc", eventDesc.equals("null")?"":eventDesc);
                //tbean.put("priorityCode", priorityCode);
                //tbean.put("eventMaxCount", eventMaxCount);
                eventInfo.add(tbean);
            //} 
            try {
				// 入数据库
				// 删除旧数据
				if (!"".equals(eventId) && !"-1".equals(eventId)) {
				    deleteEvent(bean);
				}
				event.insertMkEventcontentInfoList(eventContent);
				event.insertMkEventInfoList(eventInfo);
				rbean.setBody("message", "操作成功！");
				rbean.setBody("eventId", serialId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        System.out.println("新建事件 事件id："+serialId);
        if(!"".equals(serialId)){
        	Map<String,String> im = new HashMap<String,String>();
            im.put("eventId", serialId);
            
            List<Map<String,String>> list = event.selectMkEventcontentInfoById(im);
            rbean.setBody("eventInfo",event.queryEventBasicById(serialId));
            rbean.setBody("eventContentInfo",list);
        }
        return rbean;
	}

	/**
     *
     * Create on 2014-11-15 下午4:52:17
     *
     * @author tianyy_bj
     * @version 1.0 Copyright(c) 北京思特奇信息技术股份有限公司 功能描述： 修改日期: 修改人: 修改目的:
     */
    @Override
	public MBean saveImageGraph(MBean bean) {
        MBean rbean = new MBean();
        String operNo = bean.getBodyStr("operNo");
        String operName = bean.getBodyStr("operNme");
        String regionCode = bean.getBodyStr("regionCode");
        String eventId = bean.getBodyStr("eventId");
        String eventType = bean.getBodyStr("eventType");
        String endVertex = bean.getBodyStr("endVertex");
        if(!"-1".equals(eventId)){
        	ESPUtil.publishToESPWindow(eventType,eventId,"DELETE");
        }
        //SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String actionValue = "";
        String track = bean.getBodyStr("track");
        String[] arr = track.split(";");
        String serialId = "";
        for (int i = 0; i < arr.length; i++) {
            List<Map> eventInfo = new ArrayList<Map>();
            List<Map> eventContent = new ArrayList<Map>();
            if (!"".equals(eventId) && !"-1".equals(eventId)) {
                serialId = eventId;
            } else {
                serialId = SequUtil.getSequ(3);
            }
            String[] ele = arr[i].split("@");
            String basicVal = ele[0].substring(ele[0].indexOf("basic{") + 6, ele[0].length() - 1);
            String[] basciVals = basicVal.split("\\|");
            String name = basciVals[0].substring(basciVals[0].indexOf(":")+1);
            String startDate = basciVals[1].substring(basciVals[1].indexOf(":")+1);
            String endDate = basciVals[2].substring(basciVals[2].indexOf(":")+1);
            String eventDesc = basciVals[3].substring(basciVals[3].indexOf(":")+1);
            String busiType = basciVals[4].substring(basciVals[4].indexOf(":")+1);
            String conductId = "";
            int num = 0;
            List<String> actionIds = new ArrayList<String>();
            // 拆分动作行为信息
            for (int k = 1; k < ele.length; k++) {
            	String[] temp = ele[k].split("=");
                String actConductStr = temp[0];
                actionValue = temp[1];
                String actConductId = actConductStr.split("_")[0];
                String actConductType = actConductStr.split("_")[1];
                if ("0".equals(actConductType)) {// 动作
                    actionIds.add(actConductId);
                    // 插入动作属性值
                    String[] actValues = null;
                    if (actionValue.indexOf("|") != -1) {
                        actValues = actionValue.split("\\|");
                    } else {
                        actValues = new String[1];
                        actValues[0] = actionValue;
                    }
                    for (int j = 0; j < actValues.length; j++) {
                        Map tbean = new HashMap();
                        String parId = actValues[j].split(":")[0];
                        parId = parId.substring(parId.indexOf("_") + 1);
                        String parVal = null;
                        try{
                        	parVal = actValues[j].split(":")[1];
                        }catch(Exception e){
                        	System.out.println(e.getMessage()+":"+actValues[j]);
                        	continue;
                        }
                        if (parVal.equals("null")) {
                            continue;
                        }
                        //基站信息分开存储
                        if("10251".equals(parId)){
                        	String[] position = parVal.split(",");
                        	for(int p = 0;p<position.length;p++){
                        		if(position[p]==null)continue;
                        		tbean = new HashMap();
                        		tbean.put("eventId", serialId);
                                tbean.put("actconductParId", parId);
                                tbean.put("actconductId", actConductId);
                                tbean.put("actconductParValue", position[p]);
                                tbean.put("batchNo", num + "");
                                eventContent.add(tbean);
                        	}
                        }else{
                        	tbean.put("eventId", serialId);
                            tbean.put("actconductParId", parId);
                            tbean.put("actconductId", actConductId);
                            tbean.put("actconductParValue", parVal);
                            tbean.put("batchNo", num + "");
                            eventContent.add(tbean);
                        }
                        
                    }
                    //TODO 先不做不同批次，后面做同一个元素的时候做不同批次
                    //num++;
                    continue;
                }
                if ("1".equals(actConductType)) {// 行为
                    conductId = actConductId;
                    // 插入行为属性值
                    String[] conValues = null;
                    if (actionValue.indexOf("|") != -1) {
                        conValues = actionValue.split("\\|");
                    } else {
                        conValues = new String[1];
                        conValues[0] = actionValue;
                    }
                    for (int z = 0; z < conValues.length; z++) {
                        Map tbean = new HashMap();
                        String[] conVL = conValues[z].split(":");
                        if(conVL.length==2){
                        	String parId = conVL[0];
                            parId = parId.substring(parId.indexOf("_") + 1);
                            String parVal = conVL[1];
                            for(int l =0;l<conVL.length && conVL.length>2;l++){
                            	if(l==0 ||l == 1){
                            		continue;
                            	}
                            	parVal +=":"+conVL[l];
                            }
                            
                            if (parVal.equals("null")) {
                                continue;
                            }

                            tbean.put("eventId", serialId);
                            tbean.put("actconductParId", parId);
                            tbean.put("actconductId", actConductId);
                            tbean.put("actconductParValue", parVal);
                            tbean.put("batchNo", "0");
                            eventContent.add(tbean);
                        }
                        
                        
                    }
                    continue;
                }
            }
            // 拆分事件信息
            //for (int n = 0; n < actionIds.size(); n++) {
                String actiontId = actionIds.get(0);
                Map tbean = new HashMap();
                tbean.put("eventId", serialId);
                tbean.put("actionId", actiontId);
                tbean.put("conductId", conductId);
                tbean.put("operNo", operNo);
                tbean.put("operName", operName);
                tbean.put("operDate", new Date());
                tbean.put("content", "");
                tbean.put("statusCode", Const.ActStatusCode_00);
                tbean.put("regionCode", regionCode);
                //tbean.put("batchNo", "" + n + "");
                tbean.put("eventName", name);
                tbean.put("startDate", startDate);
                tbean.put("endDate", endDate);
                tbean.put("busiType", busiType);
                tbean.put("eventDesc", eventDesc.equals("null")?"":eventDesc);
                //tbean.put("priorityCode", priorityCode);
                //tbean.put("eventMaxCount", eventMaxCount);

                eventInfo.add(tbean);
            //}
            // 入数据库
            try {
                // 删除旧数据
                if (!"".equals(eventId) && !"-1".equals(eventId)) {
                    deleteEvent(bean);
                }
                event.insertMkEventcontentInfoList(eventContent);
                event.insertMkEventInfoList(eventInfo);
                rbean.setBody("message", "操作成功！");
                rbean.setBody("eventId", serialId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("新建事件 事件id："+serialId);
        if(!"".equals(serialId)){
        	Map<String,String> im = new HashMap<String,String>();
            im.put("eventId", serialId);
            
            List<Map<String,String>> list = event.selectMkEventcontentInfoById(im);
            rbean.setBody("eventInfo",event.queryEventBasicById(serialId));
            rbean.setBody("eventContentInfo",list);
        }
        
        
        return rbean;
    }

    /**
     *
     * Create on 2014-11-15 下午4:52:17
     *
     * @author tianyy_bj
     * @version 1.0 Copyright(c) 北京思特奇信息技术股份有限公司 功能描述： 修改日期: 修改人: 修改目的:
     */
    @Override
	public MBean deleteEvent(MBean bean) {
        MBean rbean = new MBean();
        try {
            // 删除动作行为关系表中流水对应的数据
            event.deleteMkEventInfoByEventid(bean);
            // 删除动作行为内容表中流水对应的数据
            event.deleteMkEventcontentInfoByEventid(bean);
            // 删除图形节点表中流水对应的数据
            event.deleteMkImgitemInfoByActid(bean);
            // 删除图形连接表中流水对应的数据
            event.deleteMkImgconnectionInfoByActid(bean);
            rbean.setBody("message", "操作成功！");
        } catch (Exception e) {
            e.printStackTrace();
            rbean.setBody("message", "操作失败！");
        }
        return rbean;
    }


    /**
     *
     * Create on 2014-12-17 下午14:33:17
     *
     * @author nidw
     * @version 1.0 Copyright(c) 北京思特奇信息技术股份有限公司 功能描述： 修改日期: 修改人: 修改目的:
     */
    @Override
	public MBean updateEvent(MBean bean) {
        MBean rbean = new MBean();
        //取参数
        String eventId = bean.getBodyStr("eventId");
        String operNo = bean.getBodyStr("operNo");
        String statusCode = bean.getBodyStr("statuscode");
        try {
            // 插入历史表
            String trac_id = SequUtil.getSequ();// 随机数生成主键
            bean.setBody("trac_id", trac_id);
            bean.setBody("update_type", "U");
            //如果是重置操作，先删除审批结果表里待审批状态的数据
            if(null != statusCode && Const.ActStatusCode_00.equals(statusCode)){
            	Map deleteMap = new HashMap();
            	deleteMap.put("busiId", eventId);
            	deleteMap.put("busiType", Const.EVENT);
            	deleteMap.put("statusCode", Const.STATIC_NUM_0);
            	event.deleteMkAuditResultInfo(deleteMap);
            }
            //如果是发布操作，还要调用规则反转的python处理程序
            else if( null != statusCode && Const.ActStatusCode_04.equals(statusCode) ){
            	/*Process proc = Runtime.getRuntime().exec(Const.eventsPublishCmd);
            	int exitVal = proc.waitFor();
            	System.out.println("Process exitValue: " + exitVal);*/
            }


            event.insertMkEventTracByEventid(bean);
            event.updateMkEventInfoStatus(bean);
            rbean.setBody("message", "操作成功！");
        } catch (Exception e) {
            e.printStackTrace();
            rbean.setBody("message", "操作失败！");
//            String returnCode = errorUtil.getErrorCode(Const.opCodeYXZX,Const.errcode_dberr);
//			throw new BusiException(returnCode, "updateEvent操作错误!", "操作数据库失败!");
        }
        return rbean;
    }


	/**
     *
     * Create on 2014-11-15 下午4:52:17
     *
     * @author tianyy_bj
     * @version 1.0 Copyright(c) 北京思特奇信息技术股份有限公司 功能描述： 修改日期: 修改人: 修改目的:
     */
    @Override
	public void saveImgContent(MBean bean) {
        String serial = bean.getBodyStr("eventId");
        String vertexes = bean.getBodyStr("vertexes");
        String edges = bean.getBodyStr("edges");

        List<Map> beanList = new ArrayList<Map>();

        String[] vertexArr = vertexes.split(";");
        // 拆分节点数据
        for (int i = 0; i < vertexArr.length; i++) {
            Map tbean = new HashMap();
            String[] vertex = vertexArr[i].split("\\|");
            tbean.put("itemId", vertex[1]);
            tbean.put("itemType", vertex[0]);
            tbean.put("itemAid", (vertex[5].equals("undefined") || vertex[5].equals("null")) ? "" : vertex[5]);
            tbean.put("actId", serial);
            tbean.put("itemX", vertex[2]);
            tbean.put("itemY", vertex[3]);
            tbean.put("isconnected", vertex[7]);
            tbean.put("partentType", "03");
            tbean.put("bak1", (vertex[4].equals("undefined") || vertex[4].equals("null")) ? "" : vertex[4]);// cell.name
            tbean.put("bak2", (vertex[6].equals("undefined") || vertex[6].equals("null")) ? "" : vertex[6]);// cell.actconduct_type
            beanList.add(tbean);
        }
        event.insertMkImgitermInfoList(beanList); // 保存节点数据
        beanList.clear();
        // 拆分连线数据
        String[] edgeArr = edges.split(";");
        for (int i = 0; i < edgeArr.length; i++) {
            Map tbean = new HashMap();
            String[] edge = edgeArr[i].split("\\|");
            if (edge.length == 3) {
                tbean.put("actId", serial);
                tbean.put("fromId", edge[0]);
                tbean.put("toId", edge[1]);
                tbean.put("partentType", "03");
                tbean.put("orderid", edge[2]);
                beanList.add(tbean);
            } else if (edge.length != 1) {
                try {
                    throw new Exception("连线属性参数错误！");
                } catch (Exception e) {

                    e.printStackTrace();
                }
            }
        }
        event.insertMkImgconnectinInfoList(beanList);// 保存连线数据
    }

    /**
     *
     * Create on 2014-11-15 下午4:52:17
     *
     * @author tianyy_bj
     * @version 1.0 Copyright(c) 北京思特奇信息技术股份有限公司 功能描述： 修改日期: 修改人: 修改目的:
     */
    @Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
    public MBean saveAudit(MBean bean) {
        MBean rbean = new MBean();
        try {
            Map map = event.queryEventInfoByid(bean);
            bean.setBody("eventName", map.get("eventName"));
            bean.setBody("busiType", Const.EVENT);
            bean.setBody("operNo", map.get("operNo"));
            bean.setBody("busiOperDate", map.get("operDate"));
            // 修改活动状态为待审批
            event.updateMkEventInfo(bean);
            int auditOrder = 1;
            String serialId = RandomUtil.SysDateRandom() + RandomUtil.RandomSeven();
            bean.setBody("auditOrder", auditOrder);
            bean.setBody("serialId", serialId);
            bean.setBody("auditDate", new Date());
            // 将提交审批的信息插入审批结果表
            event.insertMkAuditInfo(bean);
            rbean.setBody("message", "操作成功！");
        } catch (Exception e) {
            e.printStackTrace();
            rbean.setBody("message", e + "操作失败！");
        }
        return rbean;
    }

    /**
     *
     * Create on 2014-11-15 下午4:52:17
     *
     * @author tianyy_bj
     * @version 1.0 Copyright(c) 北京思特奇信息技术股份有限公司 功能描述： 修改日期: 修改人: 修改目的:
     */
    @Override
	public List[] queryImgContent(String serialNo) {
        MBean tbean = new MBean();
        tbean.setBody("actId", serialNo);
        List<Map> itemList = event.queryImgItemListByActid(tbean);
        List<Map> imgConnList = event.queryImgContentListActid(tbean);
        List<Map> imgContentList = event.queryMkImgconnectionInfoListByActid(tbean);
        return new List[] { itemList, imgConnList, imgContentList };
    }

    /**
     *
     * Create on 2014-11-15 下午4:52:17
     *
     * @author tianyy_bj
     * @version 1.0 Copyright(c) 北京思特奇信息技术股份有限公司 功能描述： 修改日期: 修改人: 修改目的:
     */
    @Override
	public List queryActConduct(String busiId) {
        MBean tbean = new MBean();
        tbean.setBody("eventId", busiId);
        List<Map> list = event.queryMkEventInfoList(tbean);
        return list;
    }

    /**
     *
     * Create on 2014-11-15 下午4:52:17
     *
     * @author tianyy_bj
     * @version 1.0 Copyright(c) 北京思特奇信息技术股份有限公司 功能描述： 修改日期: 修改人: 修改目的:
     */
    @Override
	public List queryActConductContent(String busiId, String actioncondId, String batchNo, String provinceCode) {
        MBean tbean = new MBean();
        tbean.setBody("busiId", busiId);
        tbean.setBody("actioncondId", actioncondId);
        tbean.setBody("batchNo", batchNo);
        tbean.setBody("provinceCode", provinceCode);
        List list = event.queryActConductContentList(tbean);
        return list;
    }

    /**
     *
     * Create on 2014-11-15 下午4:52:17
     *
     * @author tianyy_bj
     * @version 1.0 Copyright(c) 北京思特奇信息技术股份有限公司 功能描述： 修改日期: 修改人: 修改目的:
     */
    @Override
	public String queryActConductName(String actconductId) {
        MBean tbean = new MBean();
        tbean.setBody("actconductId", actconductId);
        Map map = event.queryMkActconductName(tbean);
        return (String) map.get("actconductName");
    }

    /**
     *
     * Create on 2014-11-15 下午4:52:17
     *
     * @author tianyy_bj
     * @version 1.0 Copyright(c) 北京思特奇信息技术股份有限公司 功能描述： 修改日期: 修改人: 修改目的:
     */
    @Override
	public List queryEventType(String provinceCode) {
        MBean bean = new MBean();
        bean.setBody("provinceCode", provinceCode);
        return event.queryMkEventtypeDict(bean);
    }

    /**
     *
     * Create on 2014-11-15 下午4:52:17
     *
     * @author tianyy_bj
     * @version 1.0 Copyright(c) 北京思特奇信息技术股份有限公司 功能描述： 修改日期: 修改人: 修改目的:
     */
    @Override
	public MBean getEventTypeList(MBean bean) {
        String provinceCode = bean.getBodyStr("provinceCode");
        MBean rbean = new MBean();
        rbean.setBody("eventTypeList", queryEventType(provinceCode));
        rbean.setBody("priorityCodeList",queryType("mk_priority_dict"));
        return rbean;
    }

    /**
     *
     * Create on 2014-11-15 下午4:52:17
     *
     * @author tianyy_bj
     * @version 1.0 Copyright(c) 北京思特奇信息技术股份有限公司 功能描述： 修改日期: 修改人: 修改目的:
     */
    @Override
	public List queryMsgType(String provinceCode) {
        MBean bean = new MBean();
        bean.setBody("provinceCode", provinceCode);
        return event.queryMsgType(bean);
    }

    /**
     *
     * Create on 2014-11-15 下午4:52:17
     *
     * @author tianyy_bj
     * @version 1.0 Copyright(c) 北京思特奇信息技术股份有限公司 功能描述： 修改日期: 修改人: 修改目的:
     */
    @Override
	public MBean getMsgTypeList(MBean bean) {
        String provinceCode = bean.getBodyStr("provinceCode");
        MBean rbean = new MBean();
        rbean.setBody("msgTypeList", queryMsgType(provinceCode));
        return rbean;
    }

    /**
     *
     * Create on 2014-11-15 下午4:52:17
     *
     * @author tianyy_bj
     * @version 1.0 Copyright(c) 北京思特奇信息技术股份有限公司 功能描述： 修改日期: 修改人: 修改目的:
     */
    @Override
	public List<Map> queryActConductList(String type) {
        MBean bean = new MBean();
        bean.setBody("actconductType", type);
        return event.queryActConductForList(bean);
    }

    /**
     *
     * Create on 2014-11-15 下午4:52:17
     *
     * @author tianyy_bj
     * @version 1.0 Copyright(c) 北京思特奇信息技术股份有限公司 功能描述： 修改日期: 修改人: 修改目的:
     */
    @Override
	public List queryActConductParList() {
        return event.queryActConductParForList();
    }

    /**
     *
     * Create on 2014-11-15 下午4:52:17
     *
     * @author tianyy_bj
     * @version 1.0 Copyright(c) 北京思特奇信息技术股份有限公司 功能描述： 修改日期: 修改人: 修改目的:
     */
    @Override
	public List<Map> queryPermissionList() {
        List<Map> permissionList = new ArrayList<Map>();
        List<Map> rs = event.queryPermissionForList();
        List<Map> parList = event.queryPermissionparList();
        Map<String, String> map = new HashMap<String, String>();
        Map rt0 = parList.get(0);
        String key = (String) rt0.get("actconductId");
        String parIds = "";
        for (int i = 0; i < parList.size(); i++) {
            Map map1 = parList.get(i);
            String actconductId = (String) map1.get("actconductId");
            if (actconductId.equals(key)) {
                parIds += map1.get("parameterId") + ",";
            } else {
                map.put(key, parIds);
                key = actconductId;
                parIds = "";
                parIds += map1.get("parameterId") + ",";
            }
        }
        map.put(key, parIds);
        for (int i = 0; i < rs.size(); i++) {
            Map ac = new HashMap();
            ac.put("compType", rs.get(i).get("compType"));
            ac.put("permissionType", rs.get(i).get("permissionType"));
            ac.put("actconductType", rs.get(i).get("actconductType"));
            ac.put("dataType", rs.get(i).get("dataType"));
            for (Iterator it = map.keySet().iterator(); it.hasNext();) {
                String id = (String) it.next();
                if (id.equals(rs.get(i).get("actconductId"))) {
                    String pars = map.get(id);
                    ac.put("parameterId", pars.substring(0, pars.length() - 1));
                    break;
                }
            }
            permissionList.add(ac);
        }
        return permissionList;
    }

    /**
     * 查询码表值
     *
     * @return
     * @author jiaxla  2014-12-17
     */
    private List queryType(String tablename) {
     Map<String,String> para = new HashMap<String, String>();
     para.put("tableEnName",tablename);
     List rList = event.queryType(para);
     if(null != rList && rList.size()>0){
     }
     return rList;
    }
    /**
     * 查询资费信息
     *
     * @return
     * @author jiaxla  2014-12-17
     */
    @Override
	public MBean getLoadFee(MBean bean) {
    	MBean rbean = new MBean();
        String province_center = bean.getBodyStr("province_center");

        List list = event.queryPrcFeeList(province_center);
        if(null != list && list.size()>0){
        	Map map = (Map) list.get(0);
        	String release_flag = (String) map.get("fieldValue");
        }

        rbean.addBody("release_flag", list);
        return rbean;
    }

	@Override
	public MBean resetTime(MBean bean) {
		MBean rbean = new MBean();
		String province_center = bean.getBodyStr("province_center");
		String statusCode = bean.getBodyStr("statusCode");
		String phoneNo = bean.getBodyStr("phoneNo");
		String ret =eventNosql.resetTime(phoneNo,statusCode);
		rbean.addBody("ret", ret);
		return rbean;
	}

	@Override
	public MBean initAudit(MBean bean) {
		MBean rbean = new MBean();
		String province_center = bean.getBodyStr("province_center");
		String regionCode = bean.getBodyStr("regionCode");
		String audit_level = bean.getBodyStr("audit_level");
		Map retMap = event.getAuditInfo(province_center, regionCode, audit_level);
		String auditNo = "";
		String auditName = "";
		String auditLevel = "";
		if(retMap != null && retMap.size() > 0){
			auditNo = (String)retMap.get("auditNo");
			auditName = (String)retMap.get("auditName");
			auditLevel = String.valueOf(retMap.get("auditLevel"));
		}
		rbean.addBody("auditNo", auditNo);
		rbean.addBody("auditName", auditName);
		rbean.addBody("auditLevel", auditLevel);
		return rbean;
	}

	@Override
	public MBean initEventAudit(MBean bean) {
		MBean rbean = new MBean();
		String auditNo = "";
		String auditName = "";
		String auditLevel = "";
		String busiId = bean.getBodyStr("busiId");
		String busiType = bean.getBodyStr("busiType");
		String province_center = bean.getBodyStr("province_center");
		String regionCode = bean.getBodyStr("regionCode");
		Map retMap = event.getAuditResultInfo(busiId, busiType);
		if(retMap != null && retMap.size() > 0){
			String auditOrder = (String)retMap.get("auditOrder");
			Map auditMap = event.getAuditInfo(province_center, regionCode, auditOrder);
			if(auditMap != null && auditMap.size() > 0){
				auditNo = (String)auditMap.get("auditNo");
				auditName = (String)auditMap.get("auditName");
				auditLevel = String.valueOf(auditMap.get("auditLevel"));
			}
		}
		rbean.addBody("auditNo", auditNo);
		rbean.addBody("auditName", auditName);
		rbean.addBody("auditLevel", auditLevel);
		return rbean;
	}

	@Override
	public MBean sendKafkaMsg(MBean bean) {
		String topic ="";
		String eventType = (String) MBeanUtil.setBodyToMap(bean).get("eventType");
		if("00".equals(eventType)){
			topic = PropertiesUtil.getProperty("kafka.properties", "topic_mess_attach");//mk_msg_mess_attach
		}else if("04".equals(eventType)){
			topic = PropertiesUtil.getProperty("kafka.properties", "topic_flux_remind");//mk_msg_flux_remind
		}else if("07".equals(eventType)){
			topic = PropertiesUtil.getProperty("kafka.properties", "topic_pay_fee");//mk_msg_pay_fee
		}else if("08".equals(eventType)){
			topic = PropertiesUtil.getProperty("kafka.properties", "topic_prod");//mk_msg_prod
		}else if("09".equals(eventType)){
			topic = PropertiesUtil.getProperty("kafka.properties", "topic_terminal");//mk_msg_terminal
		}else if("11".equals(eventType)){
			topic = PropertiesUtil.getProperty("kafka.properties", "topic_position");//mk_msg_position
		}else if("12".equals(eventType)){
			topic = PropertiesUtil.getProperty("kafka.properties", "topic_usersim");//topic_usersim
		}
		String message = (String) MBeanUtil.setBodyToMap(bean).get("message");
		if("00".equals(eventType)||"04".equals(eventType)||"07".equals(eventType)||"08".equals(eventType)||"09".equals(eventType)||"11".equals(eventType)||"12".equals(eventType)){
			if((null != message) && (null != topic) && !"".equals(message) && !"".equals(topic)){
				try {
					Producer producer = new kafka.javaapi.producer.Producer<Integer, String>(new ProducerConfig(createProducerConfig()));
					producer.send(new KeyedMessage<Integer, String>(topic, message));
					producer.close();
					updateEvent(bean);
					bean.addBody("ret", "success");
				} catch (Exception e) {
					bean.addBody("ret", "发送消息失败!");
					e.printStackTrace();
				}
			}else{
				bean.addBody("ret", "主题或消息内容为空!");
			}
		}
		return bean;
	}
	private static Properties createProducerConfig() {
		String serializer = PropertiesUtil.getProperty("kafka.properties", "serializer.class");
		String broker = PropertiesUtil.getProperty("kafka.properties", "metadata.broker.list");
		Properties props = new Properties();
		props.put("serializer.class", serializer);
		props.put("metadata.broker.list", broker);

		return props;
	}

	@Override
	public MBean setTotalTime(MBean bean) {
		MBean rbean = new MBean();
		String ret =eventNosql.setTotalTimeM(bean);
//		String ret1 =eventNosql.setTotalTimeD(bean);
		//rbean.addBody("ret", ret.equals("SUCCESS")&&ret1.equals("SUCCESS")?"SUCCESS":"FAIL");
		rbean.addBody("ret", ret.equals("SUCCESS")?"SUCCESS":"FAIL");
		return rbean;
	}
	@Override
	public MBean gotoTotalTime(MBean bean) {
		MBean rbean = new MBean();
		//String totalTimeD =eventNosql.getTotalTimeD(bean);
		String totalTimeM =eventNosql.getTotalTimeM(bean);
		//rbean.addBody("totalTimeD", totalTimeD);
		rbean.addBody("totalTimeM", totalTimeM);
		System.out.println("rbean="+rbean);
		return rbean;
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
	public MBean queryEventInfo(MBean bean) {
		String eventName = bean.getBodyStr("eventName");
		String statusCode = bean.getBodyStr("statusCode");
		String eventType = bean.getBodyStr("eventType");
		String eventId = bean.getBodyStr("eventId");
		String operNo = bean.getBodyStr("operNo");
		String regionCode = bean.getBodyStr("regionCode");
		String page = bean.getBodyStr("page")==null?"1":(String)bean.getBodyStr("page");
		MBean retBean = new MBean();
		List retList = new ArrayList();
		try{
			//查询对应的事件
			Map sourceMap = new HashMap();
			sourceMap.put("eventName", eventName);
			sourceMap.put("statusCode", statusCode);
			sourceMap.put("busiType", eventType);
			sourceMap.put("eventId", eventId);
			sourceMap.put("operNo", operNo);
			sourceMap.put("regionCode", regionCode);
			List eventList = event.queryEventInfo(sourceMap);
			System.out.println("sourceMap======================:"+sourceMap);
			//查询类型对应的事件推荐信息
			if(null != eventType && !"".equals(eventType)){
				String eventTypeJson = eventNosql.queryEventType(eventType);
				if(null != eventTypeJson && !"".equals(eventTypeJson)){
					if(eventList != null && eventList.size() > 0){
						for(int i = 0 ; i < eventList.size();i++){
							Map eventMap = (HashMap)eventList.get(i);
							if(eventMap != null && eventMap.size() > 0){
								String retEventId = (String)eventMap.get("eventId");
								if(null != retEventId && !"".equals(retEventId)){
									JSONObject jsonObject = JSONObject.parseObject(eventTypeJson);
									String numStr = jsonObject.getString(retEventId);
									if(null != numStr && !"0".equals(numStr) && !"".equals(numStr)){
										eventMap.put("sendCount", numStr);
									}else{
										eventMap.put("sendCount", "0");
									}
									//获取事件推荐的活动的办理量
									String actRecordJson = eventNosql.queryActRecordCount(retEventId);
									if(null != actRecordJson && !"".equals(actRecordJson)){
										JSONObject json = JSONObject.parseObject(actRecordJson);
										String actRecordCount = json.getString("order_num");
										if(null != actRecordCount && !"".equals(actRecordCount)){
											eventMap.put("orderNumber", actRecordCount);
										}else{
											eventMap.put("orderNumber", "0");
										}
									}else{
										eventMap.put("orderNumber", "0");
									}
									retList.add(eventMap);
								}
							}
						}
					}
				}
			}else{
				if(eventList != null && eventList.size() > 0){
					for(int i = 0 ; i < eventList.size();i++){
						Map eventMap = (HashMap)eventList.get(i);
						if(eventMap != null && eventMap.size() > 0){
							String retEventId = (String)eventMap.get("eventId");
							String retEventType = (String)eventMap.get("eventType");
							if(null != retEventType && !"".equals(retEventType)){
								String eventTypeJson = eventNosql.queryEventType(retEventType);
								if(null != eventTypeJson && !"".equals(eventTypeJson)){
									if(null != retEventId && !"".equals(retEventId)){
										JSONObject jsonObject = JSONObject.parseObject(eventTypeJson);
										String numStr = jsonObject.getString(retEventId);
										if(null != numStr && !"0".equals(numStr) && !"".equals(numStr)){
											eventMap.put("sendCount", numStr);
										}else{
											eventMap.put("sendCount", "0");
										}
										//获取事件推荐的活动的办理量
										String actRecordJson = eventNosql.queryActRecordCount(retEventId);
										if(null != actRecordJson && !"".equals(actRecordJson)){
											JSONObject json = JSONObject.parseObject(actRecordJson);
											String actRecordCount = json.getString("order_num");
											if(null != actRecordCount && !"".equals(actRecordCount)){
												eventMap.put("orderNumber", actRecordCount);
											}else{
												eventMap.put("orderNumber", "0");
											}
										}else{
											eventMap.put("orderNumber", "0");
										}
										retList.add(eventMap);
									}
								}
							}
						}
					}
				}
			}
			//组装list
			//if(null != retList && retList.size() > 0){
				String method = "find";
				Map retMap = JavaForPage.displayForPage(retList,Integer.parseInt(page),method);
				String html = (String)retMap.get("html");
				List subList = (List)retMap.get("subList");
				retBean.addBody("html", html);
				retBean.addBody("subList",subList);
			//}
		}catch(Exception e){
			e.printStackTrace();
			throw new BaseException("1111", "亲,queryEventInfo出异常了,到后台看看吧");
		}
		return retBean;
	}
	/**
	 *
	 * Create on 2015-08-12
	 * 功能描述：保存推荐活动基本信息
	 * @author yangrc
	 * @version 1.0 Copyright(c) 北京思特奇信息技术股份有限公司  修改日期: 修改人: 修改目的:
	 */
	@Override
	public MBean saveRecommendActInfo(MBean bean) {
		MBean rbean = new MBean();
	    try {
	        event.updateMkEventcontentInfoOfParvalue(bean);
	    } catch (Exception e) {
	        e.printStackTrace();
	        rbean.setBody("message", "操作失败！");
	    }
	    return rbean;
	}
	public IMkMonitorInfo getMkMonitorInfo() {
		return mkMonitorInfo;
	}
	public void setMkMonitorInfo(IMkMonitorInfo mkMonitorInfo) {
		this.mkMonitorInfo = mkMonitorInfo;
	}

	public void setMkMylacciInfo(IMkMylacciInfo mkMylacciInfo) {
		this.mkMylacciInfo = mkMylacciInfo;
	}
	
}