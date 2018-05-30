package com.sitech.util;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


public class InParamUtil implements Serializable {

	/**
	 * 
	 *  Create on 2015-3-21
	 * @author tianyy_bj
	 * @version 1.0
	 * @Title: inParamToMap 
	 * @Description: TODO(将dto转化为map，其中key为dto中的域属性名)
	 * @param @param object
	 * @param @return
	 * @return Map<String,Object>
	 * @throws
	 * 修改日期:     修改人:     修改目的:
	 */
	public static Map<String, Object> inDTOToMap(Object object){
    	Class c = object.getClass();//得到class
    	Field[] fields = c.getDeclaredFields();//获取属性
    	Method[] methods = c.getMethods();//获取方法
    	String fieldName = "";
    	Object value = null;
    	Map<String,Object> map = new HashMap<String, Object>();//返回值
    	for(Field field:fields){
    		fieldName = field.getName();
    		for(Method m : methods){
    			String tmp = "get" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
    			if(m.getName().equals(tmp)){
					try {
						value = m.invoke(object, null);
					}  catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
    			}
    		}
    		map.put(fieldName, value);
    		System.out.println(map);
    	}
    	return map;
	}
	
	
//	 //按照分来计算金额，数据库统一金钱单位为分，不需要再转换分，此方法废弃 by wangdw
// 	private static String countMoneyWithFen(String money){
// 		if (CommonUtil.isNotEmpty(money)) {
// 			Double yuan =Double.parseDouble(money);
// 			Double fen  = yuan*100;
// 			money = String.valueOf(fen.intValue());
// 		}
// 		return money;
// 	}
   
   /**
	 * 获得增值税应收金额
	 * @Create on 2015-7-18 
	 * @author: wangdw
	 * @Title: getTaxShould 
	 * @Description: 
	 * @param madePrice
	 * @param busiShould
	 * @return 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	public String getTaxShould(Map elementInfo, String busiShould) {
		Double taxShould = null;
		// 终端成本价 change by wangdw 数据库所有钱的部分全部改为分，不用再转换
		//String madePrice = countMoneyWithFen((String)elementInfo.get("resourceCostPrice"));
		String madePrice = (String)elementInfo.get("resourceCostPrice");
		if (CommonUtil.isNotEmpty(madePrice)) {
			double made = Double.parseDouble(madePrice);
			double busi = Double.parseDouble(busiShould);
			taxShould = ( ( ( ( made-busi) * 17 ) / 100 ) - ( (made-busi) * (0.6/1.11*0.11+0.4/1.06*0.06) ) );
			if (taxShould < 0) taxShould = 0.0;
		}
		return String.valueOf(taxShould);
	}
	
	
}
