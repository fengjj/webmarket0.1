package com.sitech.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.alibaba.fastjson.JSON;
import com.sitech.jcf.core.exception.BusiException;

public class ParamUtil {
//	private static final String UPPER_CASE_REGEX= new String("[A-Z]");
	private static final String LOWER_CASE_REGEX= new String("_[a-z]");
	private static final String LOWER_UPPER_CASE_REGEX= new String("[a-z][A-Z]");
	/**
	 * Create on 2015-4-10 
	 * @author: hanzh_bj
	 * @Title: parseHump2CapitalStr 
	 * @Description: 驼峰字符串转换为大写字母下划线格式
	 * @param inStr
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public static String parseHump2CapitalStr(String inStr){
		if(CommonUtil.isEmpty(inStr)){
			return "";
		}
		String splitedStr[] = inStr.split(LOWER_UPPER_CASE_REGEX);
		Pattern pattern = Pattern.compile(LOWER_UPPER_CASE_REGEX);
		Matcher matcher = pattern.matcher(inStr);
		LinkedHashMap<Integer, String> matchedMap = new LinkedHashMap<Integer, String>();
		int i = 0;
		while (matcher.find()) {
			String g =matcher.group();
			Character c0 = g.charAt(0);
			Character c1 = g.charAt(1);
			matchedMap.put(i, c0+"_"+c1);
			i++;
		}
		Iterator<Entry<Integer, String>> iter = matchedMap.entrySet().iterator();
		StringBuffer rtnStr = new StringBuffer();
		for (int j = 0; j < splitedStr.length; j++) {
			rtnStr.append(splitedStr[j]);
			if (iter.hasNext()) {
				Map.Entry<Integer, String> entry = (Map.Entry<Integer, String>) iter.next();
				if (entry.getKey() == j) {
					rtnStr.append(entry.getValue());
				}
			}
		}
		while(iter.hasNext()){
			Map.Entry<Integer, String> entry = (Map.Entry<Integer, String>) iter.next();
			rtnStr.append(entry.getValue());
		}
		return rtnStr.toString().toUpperCase();
	}
	

	/**
	 * Create on 2015-4-9 
	 * @author: hanzh_bj
	 * @Title: parseUnderLine2UpperStr 
	 * @Description: 把字母下划线的改为驼峰格式的字符串 
	 * @param inStr
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public static String parseCapital2HumpStr(String inStr) {
		if(CommonUtil.isEmpty(inStr)){
			return "";
		}
		inStr = inStr.toLowerCase();
		String splitedStr[] = inStr.split(LOWER_CASE_REGEX);
		Pattern pattern = Pattern.compile(LOWER_CASE_REGEX);
		Matcher matcher = pattern.matcher(inStr);
		LinkedHashMap<Integer, String> matchedMap = new LinkedHashMap<Integer, String>();
		int i = 0;
		while (matcher.find()) {
			matchedMap.put(i, matcher.group().substring(1,2).toUpperCase());
			i++;
		}
		Iterator<Entry<Integer, String>> iter = matchedMap.entrySet().iterator();
		StringBuffer rtnStr = new StringBuffer();
		for (int j = 0; j < splitedStr.length; j++) {
			rtnStr.append(splitedStr[j]);
			if (iter.hasNext()) {
				Map.Entry<Integer, String> entry = (Map.Entry<Integer, String>) iter.next();
				if (entry.getKey() == j) {
					rtnStr.append(entry.getValue());
				}
			}
		}
		while(iter.hasNext()){
			Map.Entry<Integer, String> entry = (Map.Entry<Integer, String>) iter.next();
			rtnStr.append(entry.getValue());
		}
		return rtnStr.toString();
	}

	
	/**
	 * Create on 2015-4-10 
	 * @author: hanzh_bj
	 * @Title: parse2CommonInParam 
	 * @Description: 将入参转换为“驼峰”标准格式
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public static Object parseCapital2Hump(Object obj){
		return parseCapitalHump(obj,"parseCapital2HumpStr");
	}
	
	/**
	 * Create on 2015-4-10 
	 * @author: hanzh_bj
	 * @Title: parse2CommonOutParam 
	 * @Description: 将出参Map转为“大写字母下划线”标准 格式
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public static Object parseHump2Capital(Object obj){
		return parseCapitalHump(obj,"parseHump2CapitalStr");
	}
	
	
	/**
	 * Create on 2015-4-9 
	 * @author: hanzh_bj
	 * @Title: parseCapital2Hump 
	 * @Description: 
	 * @param obj
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	private static Object parseCapitalHump(Object obj,String method){
		 if(obj == null){
			 return obj;
		 }else if(obj instanceof String){//字符串为空校验
			 return obj;
		 }else if(obj instanceof Collection){
			 Collection c = (Collection)obj;
			 Collection r = new ArrayList();
			 Iterator iter = c.iterator();
			 while(iter.hasNext()){
				 Object o = iter.next();
				 r.add(parseCapitalHump(o,method));
			 }
			 return r;
		 }else if(obj instanceof Map){
			 Map m = (Map) obj;
			 Map r = new HashMap();
			 Set s = m.keySet();
			 Iterator it = m.keySet().iterator();
			 while(it.hasNext()){
				Object n = it.next();
				String k = (String) invoke (method,""+n);
				Object v = parseCapitalHump(m.get(n),method);
				r.put(k , v);
			}
			return r;
		 }else if(obj instanceof Object[]){
			 Object[] a = (Object[])obj;
			 Object[] r = new Object[a.length];
			 for(int i=0;i<a.length;i++){
				 r[i]=parseCapitalHump(a[i],method);
			 }
			 return r;
		 }
		 return obj;
	}
//
//	/**
//	 * Create on 2015-4-9 
//	 * @author: hanzh_bj
//	 * @Title: parseHump2U_U 
//	 * @Description: 驼峰转换为大写字母下划线
//	 * @param obj
//	 * @return 
//	 * @version 1.0 
//	 * update_data:       update_author:       update_note:
//	 */
//	private static Object parseHump2Capital(Object obj){
//		 if(obj == null){
//			 return obj;
//		 }else if(obj instanceof String){//字符串为空校验
//			 return obj;
//		 }else if(obj instanceof Collection){
//			 Collection c = (Collection)obj;
//			 Collection r = new ArrayList();
//			 Iterator iter = c.iterator();
//			 while(iter.hasNext()){
//				 Object o = iter.next();
//				 r.add(parseHump2Capital(o));
//			 }
//			 return r;
//		 }else if(obj instanceof Map){
//			 Map o = (Map) obj;
//			 Map r = new HashMap();
//			 Iterator iter = o.entrySet().iterator();
//			 while(iter.hasNext()){
//				Map.Entry entry = (Map.Entry) iter.next();
//				String k = parseHump2CapitalStr(""+entry.getKey());
//				Object v = parseHump2Capital(entry.getValue());
//				r.put(k , v);
//			}
//			return r;
//		 }else if(obj instanceof Object[]){
//			 Object[] a = (Object[])obj;
//			 Object[] r = new Object[a.length];
//			 for(int i=0;i<a.length;i++){
//				 r[i]=parseHump2Capital(a[i]);
//			 }
//			 return r;
//		 }
//		 return obj;
//	}
//	
	public static void main(String[] args) {
//		System.out.println(parseHump2CapitalStr("0aa"));
//		System.out.println(parseHump2CapitalStr("aA00"));
//		System.out.println(parseHump2CapitalStr("aAaAaAaAaaa0A00"));
		
		Map a = new HashMap();
		
		List b = new ArrayList();
		Map c = new HashMap();
		Map d = new HashMap();

		c.put("aa_aa", "aaa");
		c.put("bb_bb", "bbb");
		b.add(c);
		
		d.put("cc_cc", "ccc");
		b.add(d);
		
		a.put("xx_xx", b);
		
		System.out.println(parseCapital2Hump(a));
		System.out.println(new com.alibaba.fastjson.JSONObject(a));
		
//		Map map2 = new HashMap();
//		map2.put("aaAaaAaa3", "aaAaaAaa3");
//		
//		List list = new ArrayList();
//		list.add(map2);
//		list.add("aaAaaAaa1list");
//		
//		Map map1 = new HashMap();
//		map1.put("aaAaaAaa2", "aaAaaAaa2");
//		map1.put("aaAaaAaa1list",  list);
//		
//		Map origon = new HashMap();
//		origon.put("aaAaaAaa0", "aaAaaAaa0");
//		origon.put("aaAaaAaa1",  map1);
//		
//		Map captial = parse2CommonOutParam(origon);
//		Map hump    = parse2CommonInParam(captial);
//		
//		System.out.println("captial ===="+origon);
//		System.out.println("captial ===="+captial);
//		System.out.println("hump ===="+hump);
		
//		System.out.println(parse2LowerStr("aa12222"));
//		System.out.println(parse2LowerStr("AAAAAAAAAAAA"));
//		System.out.println(parse2LowerStr("_#A"));
//		System.out.println(parse2LowerStr("_a_a_a_a"));
//		System.out.println(parse2LowerStr("_#B_#C_#D_a_c_#F###"));
//		
//		
//		System.out.println(parse2UpperStr(""));
//		System.out.println(parse2UpperStr("aaaaaaaaa"));
//		System.out.println(parse2UpperStr("_#a"));
//		System.out.println(parse2UpperStr("_a_a_a_a"));
//		System.out.println(parse2UpperStr("_#B_#C_#D_a_c_#F###"));
//		
//		Map inparam=new HashMap();
//		inparam.put("ss"+3,1);
//		inparam.put("AAAAAAAAAAAA",2);
//		inparam.put("_#B_#C_#D_a_c_#F###",3);
//		System.out.println(parse2LowerStr(inparam));
//		
//		
//		List inStrs=new ArrayList();
//		inStrs.add("AAAAAAAAAAAA");
//		inStrs.add( "_#B_#C_#D_a_c_#F###");
//		System.out.println(parse2LowerStr(inStrs));
	}
	
	

   private static Object invoke(String method,String param){
    	Object result = null;
		try {
			result = ParamUtil.class.getMethod(method,String.class).invoke(ParamUtil.class.newInstance(), param);
		}catch (Exception e) {
            e.printStackTrace();
            throw new BusiException(e);
        }
		return result;
	}
	
	/**
	 * Create on 2015-4-9 
	 * @author: hanzh_bj
	 * @Title: parse2LowerUnderLineStr 
	 * @Description: 把字符串中大写字母转换为下划线加小写字母    如:A ->_a
	 * @param inStr
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	/*
	public static String parse2LowerUnderLineStr(String inStr) {
		if(CommonUtil.isEmpty(inStr)){
			return "";
		}
		String splitedStr[] = inStr.split(UPPER_CASE_REGEX);
		Pattern pattern = Pattern.compile(UPPER_CASE_REGEX);
		Matcher matcher = pattern.matcher(inStr);
		LinkedHashMap<Integer, String> matchedMap = new LinkedHashMap<Integer, String>();
		int i = 0;
		while (matcher.find()) {
			matchedMap.put(i, "_"+matcher.group().toLowerCase());
			i++;
		}
		Iterator<Entry<Integer, String>> iter = matchedMap.entrySet().iterator();
		StringBuffer rtnStr = new StringBuffer();
		for (int j = 0; j < splitedStr.length; j++) {
			if (!inStr.isEmpty()&& (!Character.isDigit(inStr.charAt(0)) || j != 0)) {
				rtnStr.append(splitedStr[j]);
			}
			if (iter.hasNext()) {
				Map.Entry<Integer, String> entry = (Map.Entry<Integer, String>) iter.next();
				if (entry.getKey() == j) {
					rtnStr.append(entry.getValue());
				}
			}
		}
		while(iter.hasNext()){
			Map.Entry<Integer, String> entry = (Map.Entry<Integer, String>) iter.next();
			rtnStr.append(entry.getValue());
		}
		return rtnStr.toString();
	}
	*/
   
   /**
	 * 业务无实际返回值时，返回一个成功标识map
	 * Create on 2015-4-10 
	 * @author: wangdw
	 * @Title: terminalOutStorage
	 * @Description:  
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
   @SuppressWarnings("unchecked")
   public static Map getSuccessMap() {
	   Map map = new HashMap();
	   map.put("RESULT_FLAG", "0");
	   map.put("RESULT_MSG", "操作成功！");
	   return map;
   }
   /**
    * 返回成功
    * Create on 2015-5-23 
    * @author: wangdw
    * @Title: getSuccessMapLower 
    * @Description: 
    * @return 
    * @version 1.0 
    * update_data:       update_author:       update_note:
    */
   @SuppressWarnings("unchecked")
   public static Map getSuccessMapLower(){
	   Map map = new HashMap();
	   map.put("resultFlag", "0");
	   map.put("resultMsg", "操作成功！");
	   return map;
   }
   /**
    * 返回一个成功标识map，附带id和name
    * Create on 2015-5-21 
    * @author: wangdw
    * @Title: getSuccessMap 
    * @Description: 
    * @return 
    * @version 1.0 
    * update_data:       update_author:       update_note:
    */
   @SuppressWarnings("unchecked")
   public static Map getSuccessMap(String id, String name) {
	   Map map = getSuccessMapLower();
	   map.put("id", id);
	   map.put("name", name);
	   return map;
   }
   
   /**
    * Map的key全部转换为小写，递归调用，map下的value值有map或者list<Map>也可转换。
    * Create on 2015-4-18
    * @author: wangdw
    * @Title: mapKeyToLowerMore 
    * @Description: 
    * @param obj
    * @return 
    * @version 1.0 
    * update_data:       update_author:       update_note:
    */
   @SuppressWarnings("unchecked")
   public static Object mapKeyToLowerMore(Object obj) {
		if (obj == null) {
			return obj;
		} else if (obj instanceof String) {// 字符串为空校验
			return obj;
		} else if (obj instanceof Collection) {
			Collection c = (Collection) obj;
			Collection r = new ArrayList();
			Iterator iter = c.iterator();
			while (iter.hasNext()) {
				Object o = iter.next();
				r.add(mapKeyToLowerMore(o));
			}
			return r;
		} else if (obj instanceof Map) {
			Map m = (Map) obj;
			Map r = new HashMap();
			Iterator<String> it = m.keySet().iterator();
			while (it.hasNext()) {
				String n = it.next();
				Object v = mapKeyToLowerMore(m.get(n));
				r.put(n.toLowerCase(), v);
			}
			return r;
		} else if (obj instanceof Object[]) {
			Object[] a = (Object[]) obj;
			Object[] r = new Object[a.length];
			for (int i = 0; i < a.length; i++) {
				r[i] = mapKeyToLowerMore(a[i]);
			}
			return r;
		}
		return obj;
	}
   
   /**
    * Map的key全部转换为大写（map的value类型无后续的list和map，只是string或者int基本数据类型）。
    * nosql表出参时，表字段区分大小写，建表字段都为小写，出参的key需要转为大写。
    * Create on 2015-4-18 
    * @author: wangdw
    * @Title: mapKeyToUpper 
    * @Description: 
    * @param inMap
    * @return 
    * @version 1.0 
    * update_data:       update_author:       update_note:
    */
   @SuppressWarnings("unchecked")
   public static Map mapKeyToUpper(Map inMap) {
	   Map map = null;
		if (!CommonUtil.isEmpty(inMap)) {
			map = new HashMap();
			Set set = inMap.keySet();
			Iterator it = set.iterator();
			while (it.hasNext()) {
				String key = (String)it.next();
				Object obj = inMap.get(key);
				
				map.put(key.toUpperCase(), obj);
			}
		}
		return map;
   }
   
   /**
    * Map的key全部转换为小写（map的value类型无后续的list和map，只是string或者int基本数据类型）。
    * nosql入表时，表字段区分大小写，建表字段都为小写，所以入库的key也为小写，
    * 入表字段大小写如果不是和建表字段一致，则使用cqlsh查询nosql无记录。
    * Create on 2015-4-18 
    * @author: wangdw
    * @Title: mapKeyToLower 
    * @Description: 
    * @param inMap
    * @return 
    * @version 1.0 
    * update_data:       update_author:       update_note:
    */
   @SuppressWarnings("unchecked")
   public static Map mapKeyToLower(Map inMap) {
	   Map map = null;
		if (!CommonUtil.isEmpty(inMap)) {
			map = new HashMap();
			Set set = inMap.keySet();
			Iterator it = set.iterator();
			while (it.hasNext()) {
				String key = (String)it.next();
				Object obj = inMap.get(key);
				
				map.put(key.toLowerCase(), obj);
			}
		}
		return map;
   }
   
   /**
    * map的value值强转string类型，nosql入表时其他类型的不能使用。
    * （map的value类型无后续的list和map，只是string或者int基本数据类型）
    * Create on 2015-4-18 
    * @author: wangdw
    * @Title: mapValueToString 
    * @Description: 
    * @return 
    * @version 1.0 
    * update_data:       update_author:       update_note:
    */
   @SuppressWarnings("unchecked")
   public static Map<String, String> mapValueToString(Map inMap) {
		Map<String, String> map = null;
		if (!CommonUtil.isEmpty(inMap)) {
			map = new HashMap<String, String>();
			Set<String> set = inMap.keySet();
			Iterator<String> it = set.iterator();
			while (it.hasNext()) {
				String key = it.next();
				Object obj = inMap.get(key);
				String value = "";
				if (obj instanceof String) { // string类型直接强转
					value = (String) inMap.get(key);
				} else if (!CommonUtil.isEmpty(obj)) {// 不是string类型，并且不为空，直接toString
					value = obj.toString();
				}
				value = value == null ? value : value.trim();
				// 即不是string类型，并且还为空，则value直接为空
				map.put(key, value);
			}
		}
		return map;
	}
   
   /**
    * map的key转小写，value值强转string类型。
    * （map的value类型无后续的list和map，只是string或者int基本数据类型）
    * key：nosql入表时，表字段区分大小写，建表字段都为小写，所以入库的key也为小写，入表字段大小写如果不是和建表字段一致，则使用cqlsh查询nosql无记录。
    * value：nosql入表时其他类型的不能使用，只能使用string类型。
    * Create on 2015-4-18 
    * @author: wangdw
    * @Title: mapKeyToLowerValueToString 
    * @Description: 
    * @param inMap
    * @return 
    * @version 1.0 
    * update_data:       update_author:       update_note:
    */
   @SuppressWarnings("unchecked")
   public static Map mapKeyToLowerValueToString(Map inMap) {
	   Map<String, String> map = null;
		if (!CommonUtil.isEmpty(inMap)) {
			map = new HashMap<String, String>();
			Set<String> set = inMap.keySet();
			Iterator<String> it = set.iterator();
			while (it.hasNext()) {
				String key = it.next();
				Object obj = inMap.get(key);
				String value = "";
				if (obj instanceof String) { // string类型直接强转
					value = (String) inMap.get(key);
				} else if (!CommonUtil.isEmpty(obj)) {// 不是string类型，并且不为空，直接toString
					value = obj.toString();
				}
				value = value == null ? value : value.trim();
				// 即不是string类型，并且还为空，则value直接为空
				map.put(key.toLowerCase(), value);
			}
		}
		return map;
   }
   
   /**
    * json转map
    * Create on 2015-6-11 
    * @author: wangdw
    * @Title: parseJSON2Map 
    * @Description: 
    * @param jsonStr
    * @return 
    * @version 1.0 
    * update_data:       update_author:       update_note:
    */
   public static Map<String, Object> parseJSON2Map(String jsonStr){  
       Map<String, Object> map = new HashMap<String, Object>();  
       //最外层解析  
       JSONObject json = JSONObject.fromObject(jsonStr);  
       for(Object k : json.keySet()){  
           Object v = json.get(k);   
           //如果内层还是数组的话，继续解析  
           if(v instanceof JSONArray){  
               List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();  
               Iterator<JSONObject> it = ((JSONArray)v).iterator();  
               while(it.hasNext()){  
                   JSONObject json2 = it.next();  
                   list.add(parseJSON2Map(json2.toString()));  
               }  
               map.put(k.toString(), list);  
           } else {  
               map.put(k.toString(), v);  
           }  
       }  
       return map;  
   }  
   
   /**
    * 金额格式化
    * @Create on 2015-8-4 
    * @author: wangdw
    * @Title: formatFee 
    * @Description: 
    * @param fee
    * @return 
    * @version 1.0 
    * update_date:       update_author:       update_note:
    */
   public static String formatFee(String fee) {
	   double feeD = Double.parseDouble(fee);
	   long feeL = Math.round(feeD);
	   return String.valueOf(feeL);
   }
   
   /**
	 * list转换成string数组
	 * @Create on 2015-8-25 
	 * @author: wangdw
	 * @Title: listToArray 
	 * @Description: 一般用于批量查询nosql的key拼装
	 * @param list
	 * @return 
	 * @version 1.0 
	 * update_date: update_author: update_note:
	 */
	public static String[] listToArray(List<String> list) {
		String[] result = null;
		if (CommonUtil.isEmpty(list)) return result;
		
		result = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			String s = (String)list.get(i);
			result[i] = s;
		}
		return result;
	}
}
