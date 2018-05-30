package com.sitech.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sitech.crmpd.core.util.ProtocolUtil;
import com.sitech.jcf.core.exception.BusiException;
import com.sitech.jcfx.dt.DtKit;
import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;
import com.sitech.jcfx.dt.out.OutDTO;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/*
 * MBean操作工具类
 *@Title:MBean操作工具类
 *@Description:
 *@Author:liucs
 *@Since:Jun 30, 2014
 *@Version:1.1.0
 */
public class MBeanUtil extends MBean {
    /**
     * 接受APP端传回的List<Map>类型，转换成List<String>
     * 
     * @author liucs
     * @param listMap
     *            APP端传回的List<Map>类型
     * @param args
     *            可变数组，可以放多个Map中的Key值
     * @return
     * @Description: 2014-6-30
     */
    @SuppressWarnings("unchecked")
    public static List MapToList(List<Map> listMap, String... args) {
        List resultList = new ArrayList();
        if (null != listMap) {
            for (int i = 0; i < listMap.size(); i++) {
                String[] results = new String[args.length];
                for (int j = 0; j < args.length; j++) {
                    results[j] = (String) listMap.get(i)
                            .get(args[j].toString());
                }
                resultList.add(results);
            }
        }
        return resultList;
    }

    /**
     * 在result节点中获取所有Key值
     * 
     * @Author:yueyue
     * @param path
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List getAllResultKey(MBean bean, String resultBean) {
        Map map = (Map) bean.get("ROOT");
        Map result = (Map) map.get("RESULT." + resultBean);
        Set keySet = result.keySet();
        Iterator it = keySet.iterator();
        List res = new ArrayList();
        while (it.hasNext()) {
            Object key = (Object) it.next();
            res.add(key);
        }
        return res;
    }

    /**
     * 在result节点中获取所有Value值
     * 
     * @Author:yueyue
     * @param path
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List getAllResultValue(MBean bean, String resultBean) {
        Map map = (Map) bean.get("ROOT");
        Map result = (Map) map.get("RESULT." + resultBean);
        Set keySet = result.keySet();
        Iterator it = keySet.iterator();
        List res = new ArrayList();
        while (it.hasNext()) {
            Object key = (Object) it.next();
            Object value = result.get(key);
            res.add(value);
        }
        return res;
    }

    /**
     * 功能：把result中的值统一执行request.setAttribute
     * MBean.setResultAttributes(bean,request,"setAttribute");
     * 
     * @Author:yueyue
     * @param bean
     * @param obj
     * @param methodName
     */
    @SuppressWarnings("unchecked")
    public static void setResultAttributes(MBean bean, Object obj,
            String methodName) {
        Class ownerClass = obj.getClass();
        Map result1 = (Map) bean.get("ROOT");
        Map result = (Map) result1.get("RESULT");
        System.out.println(result);
        Set keySet = result.keySet();
        Iterator it = keySet.iterator();
        while (it.hasNext()) {
            Object key = (Object) it.next();
            Object value = (Object) result.get(key);
            // Class keyClass = key.getClass();
            // Class valueClass = value.getClass();
            try {
                Method method = ownerClass.getMethod(methodName, Object.class,
                        Object.class);
                method.invoke(obj, key, value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 功能：把Map中的key和value统一放到result中
     * 
     * @Author:yueyue
     * @param bean
     * @param map
     */
    @SuppressWarnings("unchecked")
    public static void setResultMap(MBean bean, Map<String, Object> map) {
        Set keySet = map.keySet();
        Iterator it = keySet.iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            Object value = (Object) map.get(key);
            bean.setResult(key, value);
        }

    }

    /**
     * 功能：把Map中的key和value统一放到body中
     * 
     * @Author:yueyue
     * @param bean
     * @param map
     */
    @SuppressWarnings("unchecked")
    public static void setBodyMap(MBean bean, Map<String, Object> map) {
        Set keySet = map.keySet();
        Iterator it = keySet.iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            Object value = (Object) map.get(key);
            bean.setBody(key, value);
        }

    }

    /**
     * 功能：Body返回数组类型
     * 
     * @Author:yueyue
     * @param bean
     * @param path
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Object[] getBodyArray(MBean bean, String path) {
        Object[] o = null;
        try {
            Class clazz = Class.forName("com.sitech.jcfx.dt.MBean");
            Field f = clazz.getDeclaredField("BODY");
            f.setAccessible(true);
            o = (Object[]) ReflectUtil.invoke(bean, "getObject", new Class[] {
                    Map.class, String.class },
                    new Object[] { f.get(bean), path });

        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }

    /**
     * 功能：Result返回数组类型
     * 
     * @Author:yueyue
     * @param bean
     * @param path
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Object[] getResultArray(MBean bean, String path) {
        Object[] o = null;
        try {
            Class clazz = Class.forName("com.sitech.jcfx.dt.MBean");
            Field f = clazz.getDeclaredField("RESULT");
            f.setAccessible(true);
            o = (Object[]) ReflectUtil.invoke(bean, "getObject", new Class[] {
                    Map.class, String.class },
                    new Object[] { f.get(bean), path });

        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }

    /**
     * 功能：Body返回List类型
     * 
     * @Author:yueyue
     * @param bean
     * @param path
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List getBodyList(MBean bean, String path) {
        List l = null;
        try {
            Class clazz = Class.forName("com.sitech.jcfx.dt.MBean");
            Field f = clazz.getDeclaredField("BODY");
            f.setAccessible(true);
            l = (List) ReflectUtil.invoke(bean, "getObject", new Class[] {
                    Map.class, String.class },
                    new Object[] { f.get(bean), path });

        } catch (Exception e) {
            e.printStackTrace();
        }
        return l;
    }

    /**
     * 功能：Result返回List类型
     * 
     * @Author:yueyue
     * @param bean
     * @param path
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List getResultList(MBean bean, String path) {
        List l = null;
        try {
            Class clazz = Class.forName("com.sitech.jcfx.dt.MBean");
            Field f = clazz.getDeclaredField("RESULT");
            f.setAccessible(true);
            l = (List) ReflectUtil.invoke(bean, "getObject", new Class[] {
                    Map.class, String.class },
                    new Object[] { f.get(bean), path });

        } catch (Exception e) {
            e.printStackTrace();
        }
        return l;
    }

    /**
     * 功能：Body返回Map类型
     * 
     * @param bean
     * @param path
     * @return
     */
    public static Map getBodyMap(MBean bean, String path) {
        Map m = null;
        try {
            Class clazz = Class.forName("com.sitech.jcfx.dt.MBean");
            Field f = clazz.getDeclaredField("BODY");
            f.setAccessible(true);
            m = (Map) ReflectUtil.invoke(bean, "getObject", new Class[] {
                    Map.class, String.class },
                    new Object[] { f.get(bean), path });

        } catch (Exception e) {
            e.printStackTrace();
        }
        return m;
    }

    /**
     * 功能：Result返回Map类型
     * 
     * @param bean
     * @param path
     * @return
     */
    public static Map getResultMap(MBean bean, String path) {
        Map m = null;
        try {
            Class clazz = Class.forName("com.sitech.jcfx.dt.MBean");
            Field f = clazz.getDeclaredField("RESULT");
            f.setAccessible(true);
            m = (Map) ReflectUtil.invoke(bean, "getObject", new Class[] {
                    Map.class, String.class },
                    new Object[] { f.get(bean), path });

        } catch (Exception e) {
            e.printStackTrace();
        }
        return m;
    }

    public static Object[] getBodyArrayObj(MBean bean, String path) {
        Object str[] = null;
        JSONArray jsonArr = null;
        try {
            Class clazz = Class.forName("com.sitech.jcfx.dt.MBean");
            Field f = clazz.getDeclaredField("BODY");
            f.setAccessible(true);
            jsonArr = (JSONArray) ReflectUtil.invoke(bean, "getObject",
                    new Class[] { Map.class, String.class },
                    new Object[] { f.get(bean), path });
            str = jsonArr.toArray();
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
    /**
     * 取出查询结果list
    	* 
    	*  Create on 2014-7-14 上午11:05:37
    	* @author tianyy_bj
    	* @version 1.0
    	* Copyright(c) 北京思特奇信息技术股份有限公司
    	* 功能描述：取出查询结果list
    	* 修改日期:     修改人:     修改目的:
     */
    public static List getQueryDataForList(MBean bean, String resultBean) {
        Map map = (Map) bean.get("ROOT");
        map = (Map) map.get("BODY");
        List resultList = (List) map.get(resultBean);
        return resultList;
    }
    /**
     * 将查询结果list用反射封装成对象（目前只是针对元素，参数，限定范围三个实体类）
    	* 
    	*  Create on 2014-7-14 上午11:06:37
    	* @author tianyy_bj
    	* @version 1.0
    	* Copyright(c) 北京思特奇信息技术股份有限公司
    	* 功能描述：将查询结果list用反射封装成对象
    	* 修改日期:     修改人:     修改目的:
     */
    public static List<Object> instanceObject(List list, Class objType) {
        List resultList = null;
        if (list != null && list.size() > 0) {
            resultList = new ArrayList();
            try {
                for (Iterator iterator = (Iterator) list.iterator(); iterator
                        .hasNext();) {
                    Map map = (Map) iterator.next();
                    Set keySet = map.keySet();
                    Object obj = objType.newInstance();
                    Iterator it = keySet.iterator();
                    while (it.hasNext()) {
                        String key = (String) it.next();
                        String value = map.get(key).toString();
                        String first = key.substring(0, 1).toUpperCase();
                        String rest = key.substring(1, key.length());
                        String methodName = "set" + first + rest;
                        Method method = obj.getClass().getMethod(methodName,
                                String.class);
                        method.invoke(obj, value);
                    }
                    resultList.add(obj);
                }

            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
        return resultList;
    }
    
    /**
     * 检查对象mbean中是否存在字段excepts
     * @param mbean 要检查的mbean对象
     * @param excepts 要检查的字段，可以传字符串数组，多个字符串作为要检查的字段名称
     * @return 如果不为空 返回Const.IS_TRUE true 如果为空则返回为空的字段名称
     * @author fengjj
     * @throws
     * 修改日期:     修改人:     修改目的:
     * Create on 2015年3月25日
     */
    public static String isBodyNotEmpty(MBean mbean,String... excepts ){
        String retMsg = Const.IS_TRUE;
        if(excepts == null || mbean == null){
            return "oh ~~~~ param bean or excepts is null ! please check them first ";
        }
       Map<String,Object> map = mbean.getBody();
       StringBuilder temp = new StringBuilder("param ");
        for(String str:excepts){
            if(!"".equals(str)&&!map.containsKey(str)){
                temp.append(str).append(" , ");
            }
        }
        if(!"param ".equals(temp.toString())){
            return temp.append(" is null , please check").toString();
        }
        return retMsg;
    }
    
    /**
     * 清理bmean对象的body里的值,如果传进来的是null的免费给你造个空的
     * 除了resultBean,return_code,return_msg,return_detail 这几个值
     *  Create on 2015年3月25日
     * @author fengjj
     * @version 1.0
     * @Title: clean 
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param mbean
     * @param @return
     * @return MBean
     * @throws
     * 修改日期:     修改人:     修改目的:
     */
    public static MBean clean(MBean mbean){
        return clean(mbean,null);
    }

    /**
     * 清理bmean对象,如果传进来的是null的免费给你造个空的
     *  Create on 2015年3月25日
     * @author fengjj
     * @version 1.0
     * @Title: clean 
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param mbean
     * @param @param excepts
     * @param @return
     * @return MBean
     * @throws
     * 修改日期:     修改人:     修改目的:
     */
    public static MBean clean(MBean mbean,String... excepts){
    	if(null==mbean){
    		return new MBean();
    	}
    	Map map = (Map)mbean.get("ROOT");
		Map body = (Map)map.get("BODY");
		Set s = body.keySet();
		Iterator it = s.iterator();
		List list = new ArrayList();
		while(it.hasNext()){
			Object o = it.next();
			if("result".equals(o)||"resultBean".equals(o)||"return_code".equals(o)||"return_msg".equals(o)||"return_detail".equals(o)){
				continue;
			}
			if(excepts!=null){
				for(int i = 0;i<excepts.length;i++){
					if(o.equals(excepts[i])){
						continue;
					}else{
						list.add(o);
						//body.remove(o);
					}
				}
			}else{
				list.add(o);
				//body.remove(o);
			}
		}
		//执行删除操作
		int num = list.size();
		if(list!=null&&num>0){
			for(int i = 0;i<num;i++){
				body.remove(list.get(i));
			}
		}
		   mbean.setBody(body);
    	return mbean;
    }

    /**
     * 功能：将JSONObject类型转换成Map类型
     * 
     * @Author:zhaiwt
     * @return Map
     */
    public static Map getMap(Map map,String key){
    	Object object = map.get(key);
    	Map tempMap = new HashMap();
    	if(object instanceof JSONObject){
    		JSONObject json = (JSONObject)object;
    		if(null != json && json.size() > 0){
    			Set set = json.keySet();
    			if(set != null && set.size() > 0){
    				Iterator it = set.iterator();
    				while (it.hasNext()) {
						String rowKey = (String)it.next();
						if(null != rowKey && !"".equals(rowKey)){
							Object object2 = json.get(rowKey);
							//System.out.println("rowKey======="+rowKey+"=======object2===:"+object2+"=====object2====:"+object2.getClass());
							if(object2 instanceof JSONObject){
								JSONObject jsonObject = JSONObject.parseObject(json.getString(rowKey));
								if(null != jsonObject && jsonObject.size() > 0){
									Set setSub = jsonObject.keySet();
									if(setSub != null && setSub.size() > 0){
										Iterator iterator = setSub.iterator();
										Map temMap = new HashMap();
										while(iterator.hasNext()){
											String keyString = (String)iterator.next();
											Object object3 = jsonObject.get(keyString);
											//System.out.println("keyString======="+keyString+"=======object3===:"+object3+"=====object3====:"+object3.getClass());
											if(object3 instanceof String){
												String valueString = (String)jsonObject.getString(keyString);
												temMap.put(keyString, valueString);
											}else if(object3 instanceof JSONArray){
												List list = new ArrayList();
												JSONArray jsonArray = (JSONArray)object3;
												if(null != jsonArray && jsonArray.size() > 0){
													for(int j = 0;j < jsonArray.size();j++){
														Object object4 = jsonArray.get(j);
														//System.out.println("object4====="+object4+"=====object4====:"+object4.getClass());
														if(object4 instanceof JSONObject){
															JSONObject  object5= (JSONObject)object4;
															Set set2 = object5.keySet();
															if(null != set2 && set2.size() > 0){
																Iterator iterator2 = set2.iterator();
																while(iterator2.hasNext()){
																	String keyString2 = (String)iterator2.next();
																	Object object6 = object5.get(keyString2);
																	//System.out.println("keyString2======="+keyString2+"=======object6===:"+object6+"=====object6====:"+object6.getClass());
																	if(object6 instanceof String){
																		String valueString = (String)object6;
																		Map map2 = new HashMap();
																		map2.put(keyString2, valueString);
																		list.add(map2);
																	}else if(object6 instanceof JSONObject){
																		JSONObject jsObject = (JSONObject)object6;
																		if(null != jsObject && jsObject.size() > 0){
																			Set set3 = jsObject.keySet();
																			Map map2 = new HashMap();
																			if(null != set3 && set3.size() > 0){
																				Iterator iterator3 = set3.iterator();
																				while(iterator3.hasNext()){
																					String keyString3 = (String)iterator3.next();
																					if(null != keyString3 && !"".equals(keyString3)){
																						Object valueObject = jsObject.get(keyString3);
																						//System.out.println("keyString3======="+keyString3+"=======valueObject===:"+valueObject+"=====valueObject====:"+valueObject.getClass());
																						if(valueObject instanceof String){
																							String valueString = (String)valueObject;
																							map2.put(keyString3,valueString);
																						}else if(valueObject instanceof JSONArray){
																							List list2 = new ArrayList();
																							JSONArray jsonArray2 = (JSONArray)valueObject;
																							if(null != jsonArray2 && jsonArray2.size() > 0){
																								for(int k = 0; k < jsonArray2.size();k++){
																									Object object7 = jsonArray2.get(k);
																									//System.out.println("object7====="+object7+"=====object7====:"+object7.getClass());
																									if(object7 instanceof JSONObject){
																										JSONObject  object8 = (JSONObject)object7;
																										Set set4 = object8.keySet();
																										if(null != set4 && set4.size() > 0){
																											Iterator iterator4 = set4.iterator();
																											while(iterator4.hasNext()){
																												String keyString4 = (String)iterator4.next();
																												Object object9 = object8.get(keyString4);
																												//System.out.println("keyString4======="+keyString4+"=======object9===:"+object9+"=====object9====:"+object9.getClass());
																												if(object9 instanceof String){
																													String valueString2 = (String)object9;
																													Map map3 = new HashMap();
																													map3.put(keyString4, valueString2);
																													list2.add(map3);
																												}else if(object9 instanceof JSONObject){
																													JSONObject jsObject2 = (JSONObject)object9;
																													if(null != jsObject2 && jsObject2.size() > 0){
																														Set set5 = jsObject2.keySet();
																														Map map3 = new HashMap();
																														List list3 = new ArrayList();
																														if(null != set5 && set5.size() > 0){
																															Iterator iterator5 = set5.iterator();
																															while(iterator5.hasNext()){
																																String keyString5 = (String)iterator5.next();
																																if(null != keyString5 && !"".equals(keyString5)){
																																	Object valueObject2 = jsObject2.get(keyString5);
																																	//System.out.println("keyString5======="+keyString5+"=======valueObject2===:"+valueObject2+"=====valueObject2====:"+valueObject2.getClass());
																																	if(valueObject2 instanceof String){
																																		String valueString = (String)valueObject2;
																																		map3.put(keyString5,valueString);
																																	}
																																}
																															}
																															Map map4 = new HashMap();
																															map4.put(keyString4, map3);
																															list2.add(map4);
																														}
																													}
																												}
																											}
																										}
																										
																									}
																								}
																							}
																							map2.put(keyString3,list2);
																						}else if(valueObject instanceof JSONObject){
																							JSONObject jsonobject = (JSONObject)valueObject;
																							if(null != jsonobject && jsonobject.size() > 0){
																								Set set4 = jsonobject.keySet();
																								Map map3 = new HashMap();
																								if(null != set4 && set4.size() > 0){
																									Iterator iterator4 = set4.iterator();
																									while(iterator4.hasNext()){
																										String keyString4 = (String)iterator4.next();
																										Object object9 = jsonobject.get(keyString4);
																										//System.out.println("keyString4======="+keyString4+"=======object9===:"+object9+"=====object9====:"+object9.getClass());
																										if(object9 instanceof String){
																											String valueString2 = (String)object9;
																											map3.put(keyString4, valueString2);
																										}
																									}
																								}
																								map2.put(keyString3,map3);
																							}
																						}
																					}
																				}
																				Map map3 = new HashMap();
																				map3.put(keyString2,map2);
																				list.add(map3);
																			}
																		}
																	}
																}
															}
														}
													}
												}
												temMap.put(keyString, list);
											}else if(object3 instanceof JSONObject){
												JSONObject object4 = JSONObject.parseObject(jsonObject.getString(keyString));
												if(null != object4 && object4.size() > 0){
													Set setSub2 = object4.keySet();
													if(setSub2 != null && setSub2.size() > 0){
														Iterator iterator2 = setSub2.iterator();
														Map temMap2 = new HashMap();
														while(iterator2.hasNext()){
															String keyString2 = (String)iterator2.next();
															Object valueString2 = object4.get(keyString2);
															if(valueString2 instanceof String){
																temMap2.put(keyString2, valueString2);
																//System.out.println("keyString2======="+keyString2+"==valueString2==="+valueString2);
															}else if(valueString2 instanceof JSONObject){
																JSONObject object5 = JSONObject.parseObject(object4.getString(keyString2));
																//System.out.println("object5======="+object5);
																if(null != object5 && object5.size() > 0){
																	Set setSub3 = object5.keySet();
																	if(setSub3 != null && setSub3.size() > 0){
																		Iterator iterator3 = setSub3.iterator();
																		Map temMap3 = new HashMap();
																		while(iterator3.hasNext()){
																			String keyString3 = (String)iterator3.next();
																			String valueString3 = (String)object5.get(keyString3);
																			temMap3.put(keyString3, valueString3);
																		}
																		temMap2.put(keyString2, temMap3);
																	}
																}
															}else if(valueString2 instanceof JSONArray){
																List list = new ArrayList();
																JSONArray jsonArray = (JSONArray)valueString2;
																if(null != jsonArray && jsonArray.size() > 0){
																	for(int j = 0;j < jsonArray.size();j++){
																		Object object5 = jsonArray.get(j);
																		//System.out.println("=======object5===:"+object5+"=====object5====:"+object5.getClass());
																		if(object5 instanceof JSONObject){
																			JSONObject object6 = (JSONObject)object5;
																			if(null != object6 && object6.size() > 0){
																				Set set2 = object6.keySet();
																				if(set2 != null && set2.size() > 0){
																					Iterator iterator3 = set2.iterator();
																					Map temMap3 = new HashMap();
																					while(iterator3.hasNext()){
																						String keyString3 = (String)iterator3.next();
																						String valueString3 = (String)object6.get(keyString3);
																						temMap3.put(keyString3, valueString3);
																					}
																					list.add(temMap3);
																				}
																			}
																		}
																	}
																}
																temMap2.put(keyString2, list);
															}
														}
														temMap.put(keyString, temMap2);
													}
												}
											}
										}
										tempMap.put(rowKey, temMap);
									}
								}	
							}else if(object2 instanceof String){
								String string = (String)object2;
								tempMap.put(rowKey, string);
							}else if(object2 instanceof JSONArray){
								List list = new ArrayList();
								JSONArray jsonArray = (JSONArray)object2;
								if(null != jsonArray && jsonArray.size() > 0){
									for(int j = 0;j < jsonArray.size();j++){
										Object object3 = jsonArray.get(j);
										//System.out.println("=======object3===:"+object3+"=====object3====:"+object3.getClass());
										if(object3 instanceof JSONObject){
											JSONObject object4 = (JSONObject)object3;
											if(null != object4 && object4.size() > 0){
												Set set2 = object4.keySet();
												if(set2 != null && set2.size() > 0){
													Iterator iterator2 = set2.iterator();
													Map temMap2 = new HashMap();
													while(iterator2.hasNext()){
												          String key2 = (String)iterator2.next();
												          Object value2 = object4.get(key2);
												          //System.out.println("key2======="+key2+"=======value2===:"+value2+"=====value2====:"+value2.getClass());
												          if(value2 instanceof String){
												        	  temMap2.put(key2,value2);
												          }else if(value2 instanceof JSONObject){
												        	  JSONObject object5 = (JSONObject)value2;
																if(null != object5 && object5.size() > 0){
																	Set set3 = object5.keySet();
																	if(set3 != null && set3.size() > 0){
																		Iterator iterator3 = set3.iterator();
																		Map temMap22 = new HashMap();
																		while(iterator3.hasNext()){
																			String key3 = (String)iterator3.next();
																	        Object value3 = object5.get(key3);
																	        if(value3 instanceof String){
																	        	temMap22.put(key3,value3);
																	        }
																		}
																		temMap2.put(key2,temMap22);
																	}
																}
												          }
													}
													list.add(temMap2);
												}
											}
										}
									}
								}
								tempMap.put(rowKey, list);
							}
						}
					}
    			}
    		}
    	}
    	return tempMap;
    }


    /**
     * 将一个map的内容放到body里边去
     *  Create on 2014-10-11 上午11:28:54
     * @author tianyy_bj
     * @version 1.0
     * Copyright(c) 北京思特奇信息技术股份有限公司
     * @param bean
     * @param map
     * @return void
     * 功能描述：将一个map的内容放到body里边去
     * 修改日期:     修改人:     修改目的:
     */
	public static void setMapToBody(MBean bean,Map map) {
		Set keySet = map.keySet();
        Iterator it = keySet.iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            Object value = (Object) map.get(key);
            bean.setBody(key, value);
        }
	}
	
	/**
	 * 把入参xml报文转为系统应用的MBean对象
     * 把root下的东西放入body下
	 *  Create on 2015年3月25日
	 * @author fengjj
	 * @version 1.0
	 * @Title: xml2mbean 
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param xml
	 * @param @return
	 * @return MBean
	 * @throws
	 * 修改日期:     修改人:     修改目的:
	 */
    public static MBean xml2mbean(String xml){
        Document documentXML;
        MBean bean;
        try {
            documentXML = DocumentHelper.parseText(xml);
            Element root = documentXML.getRootElement();
            Document mXml = DocumentHelper.parseText("<ROOT><BODY></BODY></ROOT>");
            Element mRoot = mXml.getRootElement();
            Element body = mRoot.element("BODY");
            body.appendContent(root);
            bean = new MBean(ProtocolUtil.xml2json(mXml.asXML()));
            Map map = new HashMap();
            Map map0 = new HashMap();
            map0.put("ROUTE_KEY", "");
            map0.put("ROUTE_VALUE", "");
            map.put("ROUTING", map0);
            bean.setHeader(map);
        } catch (DocumentException e) {
            e.printStackTrace();
            throw new BusiException("-1","报文解析异常");
        }
        return bean;
    }

    /**
     * 把MBean对象转为xml字符串
     * 就是把body里的东西放到root下
     *  Create on 2015年3月25日
     * @author fengjj
     * @version 1.0
     * @Title: mbean2xml 
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param bean
     * @param @return
     * @return String
     * @throws
     * 修改日期:     修改人:     修改目的:
     */
    public static String mbean2xml(MBean bean){
        Document documentXML;
        try {
            documentXML = DocumentHelper.parseText("<ROOT></ROOT>");
            Element root = documentXML.getRootElement();
            if(null == bean){
                bean = new MBean();
            }
            String xmlStr = ProtocolUtil.json2xml(bean.toString());
            Document beanXml = DocumentHelper.parseText(xmlStr);
            Element beanRoot = beanXml.getRootElement();
            Element body = beanRoot.element("BODY");
            root.appendContent(body);
        } catch (DocumentException e) {
            e.printStackTrace();
            throw new BusiException("-1","报文解析异常");
        } 
        return documentXML.asXML();       
    }

    /**
     * 把Java对象转为MBean对象
     * 注意：递归调用，大量应用了反射，性能比较捉急，复杂对象请勿使用此方法，需自行实现转换方法
     *  Create on 2015年3月25日
     * @author fengjj
     * @version 1.0
     * @Title: object2mbean 
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param obj
     * @param @return
     * @return MBean
     * @throws
     * 修改日期:     修改人:     修改目的:
     */
    public static MBean object2mbean(Object obj){
        Map map=  object2map(new HashMap(),obj);
        MBean bean = new MBean();
        bean.setBody(map);
        return bean; 
    }

    /**
     * 内部方法：实现递归调用，对象转map
     *  Create on 2015年3月25日
     * @author fengjj
     * @version 1.0
     * @Title: object2map 
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param bean
     * @param @param obj
     * @param @return
     * @return Map
     * @throws
     * 修改日期:     修改人:     修改目的:
     */
    private static Map object2map(Map bean,Object obj){
        //Map bean = new HashMap();
        if(obj==null){
            return bean;
        }
        try{
            Class c = obj.getClass();
            if(c.equals(Map.class)||c.equals(HashMap.class)){
                return (Map)obj;
            }
            Field[] fields = c.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                String fname = field.getName();
                Class fClass = field.getType();
                String mname = "get" + fname.substring(0, 1).toUpperCase() + fname.substring(1, fname.length());
                System.out.println("field:" + fname + "     field type:"+ fClass.getName()+"    "+mname);
                Method m = null;
                try{
                    m = c.getMethod(mname);
                }catch(NoSuchMethodException e){
                    //e.printStackTrace();
                }
                if(m!=null){
                    Object fvalue = m.invoke(obj);
                    if(fvalue==null){
                        fvalue="";
                    }
                    //基本数据类型直接放到bean中
                    if (fClass.equals(String.class)
                            ||fClass.equals(Integer.class)||fClass.equals(int.class)
                            ||fClass.equals(Double.class)||fClass.equals(double.class)
                            ||fClass.equals(Float.class)||fClass.equals(float.class)
                            ||fClass.equals(Long.class)||fClass.equals(long.class)
                            ||fClass.equals(Boolean.class)||fClass.equals(boolean.class)) {
                        bean.put(fname, fvalue+"");    
                    }else if(fClass.equals(List.class)){
                        List list = (List)fvalue;
                        List listMap = new ArrayList();
                        for(int j = 0;list!=null && j< list.size();j++){
                            Object o = list.get(j);
                            System.out.println("list--------"+o);
                            listMap.add(object2map(new HashMap(),o));
                        } 
                        bean.put(fname, listMap);
                    }else if(fClass.equals(Map.class)||fClass.equals(HashMap.class)){
                        System.out.println(fname+"::::"+fvalue);
                        /*Map map = (Map) fvalue;
                        Set set = map.keySet();
                        Iterator it = set.iterator();
                        while(it.hasNext()){
                            bean = object2map(bean,it.next());  
                        }*/
                        bean.put(fname, fvalue);
                    }else if(fClass.equals(Object.class)){
                        bean = object2map(bean,fvalue);
                    }
                    
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return bean; 
    }
    /**
     * 功能：测试
     * 
     * @param args
     */
    public static void main(String[] args) {
        String string = "{\"ROOT\":{\"BODY\":{\"OUT_DATA\":{\"RULE_LIST\":[{\"OPER_NAME\":\"admin\",\"OPER_NO\":\"admin\",\"OPER_TIME\":\"20150522 164803\",\"REGION_CODE\":\"2201\",\"RULE_DESC\":\"1、活动规则活动规则活动规则活动规则活动规则动规则活动规则。|2、活动规则活动规则活动规则活动规则活动规则活动规则。|3、活动规则活动规则活动规则活动规则活动规则活活动规则活动规则活动规则。\",\"RULE_ID\":\"10001\",\"RULE_NAME\":\"砸蛋抽奖\",\"RULE_TYPE\":\"08\",\"SERIAL_ID\":\"1000001\",\"STATUS_CODE\":\"04\"},{\"OPER_NAME\":\"admin\",\"OPER_NO\":\"admin\",\"OPER_TIME\":\"20150528 143005\",\"REGION_CODE\":\"2201\",\"RULE_DESC\":\"1、活动规则活动规则活动规则活动规则活动规则动规则活动规则。|2、活动规则活动规则活动规则活动规则活动规则活动规则。|3、活动规则活动规则活动规则活动规则活动规则活活动规则活动规则活动规则。\",\"RULE_ID\":\"10002\",\"RULE_NAME\":\"转盘抽奖\",\"RULE_TYPE\":\"08\",\"SERIAL_ID\":\"1000002\",\"STATUS_CODE\":\"04\"},{\"OPER_NAME\":\"admin\",\"OPER_NO\":\"admin\",\"OPER_TIME\":\"20150512 093129\",\"REGION_CODE\":\"2201\",\"RULE_DESC\":\"五一大抽奖\",\"RULE_ID\":\"00001\",\"RULE_NAME\":\"五一大抽奖\",\"RULE_TYPE\":\"08\",\"SERIAL_ID\":\"123112121212121\",\"STATUS_CODE\":\"04\"},{\"OPER_NAME\":\"admin\",\"OPER_NO\":\"admin\",\"OPER_TIME\":\"20150515 093458\",\"REGION_CODE\":\"2201\",\"RULE_DESC\":\"\",\"RULE_ID\":\"00002\",\"RULE_NAME\":\"国庆大抽奖\",\"RULE_TYPE\":\"08\",\"SERIAL_ID\":\"123112121212122\",\"STATUS_CODE\":\"04\"}]},\"RETURN_CODE\":\"0\",\"RETURN_MSG\":\"OK\",\"USER_MSG\":\"OK\",\"DETAIL_MSG\":\"OK\",\"PROMPT_MSG\":\"OK\"}}}";
        System.out.println(mbean2xml(new MBean(string)));
    }

    /**
     * 将body层拷贝给一个map
     *  Create on 2014-11-21 下午4:38:30
     * @author tianyy_bj
     * @version 1.0
     * Copyright(c) 北京思特奇信息技术股份有限公司
     * 功能描述：将body层拷贝给一个map
     * 修改日期:     修改人:     修改目的:
     */
    public static Map setBodyToMap(MBean codeBean) {
        return (Map)((Map)codeBean.get("ROOT")).get("BODY");
    }
    
    /**
     * 反射调用方法
    	* 
    	*  Create on 2014-12-3 上午11:38:38
    	* @author tianyy_bj
    	* @version 1.0
    	* Copyright(c) 北京思特奇信息技术股份有限公司
    	* 功能描述：反射调用方法
    	* 修改日期:     修改人:     修改目的:
     */
    public static Object invokeMehtod(Object owner,String pin){
        MBean bean = new MBean(pin);
        MBean result = null;
        String method = bean.getBodyStr("Method");
        OutDTO out = null;
        try {
               StandardInDTO dto = (StandardInDTO) DtKit.toDTO(bean,StandardInDTO.class);
               Method m = owner.getClass().getMethod(method, InDTO.class);
               Object ret = m.invoke(owner, dto);
               out = (OutDTO)ret;
               if(null != out){
                   result = out.encode();
               }
                   
               } catch (IllegalArgumentException e) {
                   e.printStackTrace();
               } catch (IllegalAccessException e) {
                   e.printStackTrace();
               } catch (InvocationTargetException e) {
                   e.printStackTrace();
               } catch (SecurityException e) {
                   e.printStackTrace();
               } catch (NoSuchMethodException e) {
                   e.printStackTrace();
               }

        System.out.println(method);
        return mbean2xml(result);
    }
    /**
     * 格式化时间
    	* 
    	*  Create on 2014-12-16 下午7:39:40
    	* @author tianyy_bj
    	* @version 1.0
    	* Copyright(c) 北京思特奇信息技术股份有限公司
    	* 功能描述：
    	* 修改日期:     修改人:     修改目的:
     */
    public static String formatTime(Date date){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(date);
    }
}
