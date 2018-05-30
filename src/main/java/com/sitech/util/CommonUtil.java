package com.sitech.util;

import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;




import java.util.Set;
import java.util.UUID;

import com.alibaba.fastjson.JSONObject;
import com.sitech.jcf.core.exception.BusiException;
import com.sitech.jcfx.dt.MBean;

public class CommonUtil {
    
    /**
     * tableId&tableName
     * tableId和tableName对应关系
     */
    private static Map<String,String> tableMap = new HashMap<String,String>();
    static{
        tableMap.put(Const.mk_actRecord_info, "mk_actrecord_info");//订购记录主表
        tableMap.put(Const.mk_actRecordCoin_info, "mk_actrecordcoin_info");//订购记录积分表
        tableMap.put(Const.mk_actRecordFee_info, "mk_actrecordfee_info");//订购记录费用表
        tableMap.put(Const.mk_actRecordGift_info, "mk_actrecordgift_info");//订购记录促销品表
        tableMap.put(Const.mk_actRecordProd_info, "mk_actrecordproduct_info");//订购记录产品表
        tableMap.put(Const.mk_actRecordTermi_info, "mk_actrecordtermi_info");//订购记录终端表
        tableMap.put(Const.mk_actRecordCond_info, "mk_actrecordcond_info");//订购记录业务受限表
    }
   
    /**
     * 根据tableId查对应的tableName
     *  Create on 2015年3月25日
     * @author fengjj
     * @version 1.0
     * @Title: getTableNameByTableId 
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param tableId
     * @param @return
     * @return String
     * @throws
     * 修改日期:     修改人:     修改目的:
     */
    public static String getTableNameByTableId(String tableId){
        return tableMap.get(tableId);
    }
  
    /**
     * 从map里取值，如果是null的话返回空字符串
     *  Create on 2015年3月25日
     * @author fengjj
     * @version 1.0
     * @Title: getStrValue 
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param map
     * @param @param key
     * @param @param defaultValue
     * @param @return
     * @return String
     * @throws
     * 修改日期:     修改人:     修改目的:
     */
    public static String getStrValue(Map map,String key,String defaultValue){
        String ret = defaultValue;
        if(map != null && map.get(key)!=null){
            Object obj = map.get(key);
            if(obj.getClass()==String.class){                
                ret = (String) map.get(key);
            }
        }
        return ret;
    }

    /**
     * 从map里取值，如果是null的话返回空字符串
     *  Create on 2015年3月25日
     * @author fengjj
     * @version 1.0
     * @Title: getStrValue 
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param map
     * @param @param key
     * @param @return
     * @return String
     * @throws
     * 修改日期:     修改人:     修改目的:
     */
    public static String getStrValue(Map map,String key){
       return getStrValue(map,key,"");
    }
    
    /**
     * 判断传入参数不为空
     *  Create on 2015年3月25日
     * @author fengjj
     * @version 1.0
     * @Title: isNotEmpty 
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param obj
     * @param @return
     * @return boolean
     * @throws
     * 修改日期:     修改人:     修改目的:
     */
    public static boolean isNotEmpty(Object obj){
        //return null!=obj&&!"".equals(obj)&&!"null".equals(obj);
        return !isEmpty(obj);
    }
    
    /**
     * 判断传入参数为空
     *  Create on 2015年3月25日
     * @author fengjj
     * @version 1.0
     * @Title: isEmpty 
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param obj
     * @param @return
     * @return boolean
     * @throws
     * 修改日期:     修改人:     修改目的:
     */
     public static boolean isEmpty(Object obj){         
         if(obj == null){
         	return true;
         }else if(obj instanceof String &&(obj.equals("") || "null".equals(obj))){//字符串为空校验
         	return true;
         }else if(obj instanceof Collection &&((Collection)obj).isEmpty()){//集合为空校验
         	return true;
         }else if( obj instanceof Map && ((Map)obj).isEmpty()){//Map为空校验
         	return true;
         }else if(obj instanceof Object[] && ((Object[])obj).length == 0){//数组为空校验
         	return true;
         }
         return false;
     }
   

    /**
     * 校验原子服务或组合服务返回的json格式结果是否正确
     * @author hanzh_bj
     * @param svcRtnStr
     * @return
     */
    public static void checkSvcResult(String svcRtnStr){
    	if(null==svcRtnStr||"".equals(svcRtnStr)){
    		throw new BusiException("-1","服务返回错误", "服务的返回结果为空 svcRtnStr：："+svcRtnStr);
    	}
    	MBean checkBean = null;
    	try{
    		checkBean = new MBean(svcRtnStr);
    	}catch(Exception ex){
    		throw new BusiException("-1","服务返回错误", "服务调用异常返回结果不正确 svcRtnStr：："+svcRtnStr);
    	}
    	String rtnCode = checkBean.getBodyStr("RETURN_CODE");
		if(null!=rtnCode&&!"0".equals(rtnCode)){//原子服务异常返回值
			throw new BusiException(rtnCode,checkBean.getBodyStr("RETURN_MSG"),checkBean.getBodyStr("DETAIL_MSG"));
		}
    }
    /**
     * 检验是否为空，如果为空，抛出异常
     * @Create on 2015-6-19 
     * @author: wangdw
     * @Title: checkEmpty 
     * @Description: 
     * @param o 校验内容
     * @param emsg 简单信息
     * @param omsg 详细信息
     * @version 1.0 
     * update_date:       update_author:       update_note:
     */
    public static void checkEmpty(Object o, String emsg, String omsg) {
    	if (isEmpty(o)) {
    		throw new BusiException("-1", emsg, omsg);
    	}
    }
    /**
     * 检验是否为空，如果为空，抛出异常
     * @Create on 2015-6-19 
     * @author: wangdw
     * @Title: checkEmpty 
     * @Description: 
     * @param o
     * @param emsg 
     * @version 1.0 
     * update_date:       update_author:       update_note:
     */
    public static void checkEmpty(Object o, String emsg) {
    	if (isEmpty(o)) {
    		throw new BusiException("-1", emsg);
    	}
    }
    
	/**
	 * Create on 2015-4-25
	 * @author: zhoayue
	 * @Title: getInterSerialArray 
	 * @Description: 拼装流水id数组
	 * @param interList
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public static String[] getInterSerialArray(List interList) {
		String[] returnStrs = new String[interList.size()];
		for (int i = 0; i < interList.size(); i++) {
			Map interMap = (Map)interList.get(i);
			returnStrs[i] = (String)interMap.get("serialId");
		}
		return returnStrs;
	}
    
    /**
     * 获取服务返回值中OUT_DATA节点
     * @author hanzh_bj
     * @param svcRtnStr
     * @return
     */
    public static MBean getSvcOutData(String svcRtnStr){
    	checkSvcResult(svcRtnStr);
    	MBean rtnBean = new MBean(svcRtnStr);
    	Map outData = MBeanUtil.getBodyMap(rtnBean, "OUT_DATA");
    	rtnBean.setBody(outData);
    	return rtnBean;
    }
    
    /**
     * 获取服务返回值中OUT_DATA节点
     * @author hanzh_bj
     * @param svcRtnStr
     * @return
     */
    public static Map getSvcOutDataMap(String svcRtnStr){
    	checkSvcResult(svcRtnStr);
    	MBean  rtnBean = new MBean(svcRtnStr);
    	Map    outMap = MBeanUtil.getBodyMap(rtnBean, "OUT_DATA");
    	return outMap;
    }
     
    /**
     * 反射调用方法
     * Create on 2014-08-18
     * @author yugl
     * @version 1.0
     * Copyright(c) 北京思特奇信息技术股份有限公司
     * 功能描述：反射调用方法
     * 修改日期:     修改人:     修改目的:
	 * @throws  
	 * @throws SecurityException 
     */
	public static Object invokeMehtod(Object owner,String methodName,Object[] args) throws Exception{
		//根据methodName获得owner里面的方法。args是对应方案参数。
		Class wnerClass=owner.getClass();
		Class[] argsClass=new Class[args.length];
		for(int i=0,j=args.length;i<j;i++){
			argsClass[i] = args[i].getClass();
		}
		Method method = wnerClass.getMethod(methodName, argsClass); 
		return method.invoke(owner, args);
	}

	/**
	 * 根据key返回json内的JSONObject对象
	 *  Create on 2015年3月25日
	 * @author fengjj
	 * @version 1.0
	 * @Title: getJsonObjContext 
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param json
	 * @param @param key
	 * @param @return
	 * @return JSONObject
	 * @throws
	 * 修改日期:     修改人:     修改目的:
	 */
    public static JSONObject getJsonObjContext(JSONObject json,String key){
        JSONObject jsonContext = null;
        if (null != json && 0 != json.size()) {
            jsonContext = JSONObject.parseObject(json.getString(key));
        }
        return jsonContext;
    }

    /**
     * 从json中取出单条json对象
     *  Create on 2015年3月25日
     * @author fengjj
     * @version 1.0
     * @Title: getSingleJson 
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param json
     * @param @return
     * @return JSONObject
     * @throws
     * 修改日期:     修改人:     修改目的:
     */
    public static JSONObject getSingleJson(JSONObject json){
        String key = null;
        Set<String> set = json.keySet();
        if(set.size()==1){
            key = set.iterator().next();
        }
        return getJsonObjContext(json,key);
    }
    
    /**
     * 把查出来的json对象转成Map,key大写
     *  Create on 2015年3月25日
     * @author fengjj
     * @version 1.0
     * @Title: turn2Map 
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param json
     * @param @return
     * @return Map<String,Object>
     * @throws
     * 修改日期:     修改人:     修改目的:
     */
    public static Map<String,Object> turn2Map(JSONObject json){
        Map<String,Object> map = null;
        if(json!=null && json.size()!=0){
           map = new HashMap<String,Object>();
           Set<String> set = json.keySet();
           Iterator<String> it = set.iterator();
           while(it.hasNext()){
               String key = it.next();
               map.put(key.toUpperCase(), json.getString(key));
           }
        }
        return map;
    }
    
    /**
     * Create on 2015-4-14 
     * @author: yugl
     * @Title: getSortedHashtableByValue 
     * @Description: Map 按值（value）降序排序 
     * @param map
     * @return 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */
    public static Map.Entry[] getDescSortByValue(Map map) {
		Set set = map.entrySet();
		Map.Entry[] entries = (Map.Entry[]) set.toArray(new Map.Entry[set.size()]);
		Arrays.sort(entries, new Comparator() {
			public int compare(Object arg0, Object arg1) {
				Long key1 = Long.valueOf(((Map.Entry) arg0).getValue().toString());
				Long key2 = Long.valueOf(((Map.Entry) arg1).getValue().toString());
				return key2.compareTo(key1);
			}
		});
		return entries;
	}
    
    /**
     * Create on 2015-4-14 
     * @author: yugl
     * @Title: getSortedHashtableByValue 
     * @Description: Map 按值（value）升序排序 
     * @param map
     * @return 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */
    public static Map.Entry[] getAscSortByValue(Map map) {
		Set set = map.entrySet();
		Map.Entry[] entries = (Map.Entry[]) set.toArray(new Map.Entry[set.size()]);
		Arrays.sort(entries, new Comparator() {
			public int compare(Object arg0, Object arg1) {
				Long key1 = Long.valueOf(((Map.Entry) arg0).getValue().toString());
				Long key2 = Long.valueOf(((Map.Entry) arg1).getValue().toString());
				return key1.compareTo(key2);
			}
		});
		return entries;
	}
    
    /**
	 * 打印JSON日志
	 * @Create on 2015-8-4 
	 * @author: wangdw
	 * @Title: printLog 
	 * @Description: 
	 * @param o 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	@SuppressWarnings("unchecked")
	public static String getJSONLog(Object o) {
		Map logMap = new HashMap();
		if (o instanceof Map) {
			logMap.putAll((Map)o);
		} else {
			logMap.put("LOG_MAP", o);
		}
		return new JSONObject(logMap).toString();
	}
	
	/**
	 * @Description: 博饼中奖公示信息过期判断
	 * @param oldDate
	 * @param newDate
	 * @return boolean
	 * @author qiuzk  
	 * @date 2015年9月12日 下午5:53:05
	 */
	public static boolean lotteryWinningInfoOverdue(Date oldDate,Date newDate){
		long oldTime = oldDate.getTime();
		long newTime = newDate.getTime();
		long interval = (newTime-oldTime)/1000;
		if(interval < 3600){
			return false;
		}
		else{
			return true;
		}
	}
	
	public static String createId18(){
		String id = UUID.randomUUID().toString();
		id = id.replace("-", "");
		id = id.substring(0, 18);
		return id;
	}
	
	public static Date strToDateDefault(String formateStr){
		 SimpleDateFormat sdf =   new SimpleDateFormat("yyyyMMdd HHmmss");
		try {
			return sdf.parse(formateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
