package com.sitech.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.sitech.jcf.core.dao.IBaseDao;
import com.sitech.jcf.core.exception.BusiException;
import com.sitech.jcfx.context.JCFContext;
import com.sitech.jcfx.dt.DtKit;
import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;
import com.sitech.jcfx.dt.out.OutDTO;
import com.sitech.jcfx.util.HttpUtil;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

public class SitechClient {
    
    public static String RESFUL = "resful";
    public static String HSF = "hsf";
    public static String ESB = "esb";
    public static String WEBSERVICE = "webservice";
    public static String LOCAL = "local";
    public static String split = "_";
    //private static String rootPath = PropertiesUtil.getProperty("CONFIG.properties", "service.root.path");
    
    private static Map<String,String> serviceMap = new HashMap<String,String>();
    /**
     * 
     *  Create on 2015年3月25日
     * @author fengjj
     * @version 1.0
     * @Title: callService 
     * @Description: 服务调用
     * @param @param serName
     * @param @param par
     * @param @param callServiceType
     * @param @return
     * @return String
     * @throws
     * 修改日期:     修改人:     修改目的:
     */
    @Deprecated
    public static String callService(String serName,String par,String callServiceType){
        String result = null;
        System.out.println("*******************start call service 【"+serName+"】****************");
        System.out.println("【callServiceType】:"+callServiceType+"    【serFlag】:"+Const.serviceFlag);
        System.out.println("【************Param************】:"+par);
        try {
        if(RESFUL.equals(callServiceType) || (callServiceType == null &&RESFUL.equals(Const.serviceFlag))){
            result = HttpUtil.invoke(Const.ROOT_PATH+serName, par);
        }else if(HSF.equals(callServiceType) || (callServiceType == null &&HSF.equals(Const.serviceFlag))){
            result = com.sitech.jcfx.service.client.ServiceUtil.callService(serName, par);
        }else if(ESB.equals(callServiceType) || (callServiceType == null &&ESB.equals(Const.serviceFlag))){
            Map<String, Object> map = com.sitech.crmpd.core.service.impl.ServiceUtil.callService(serName, par.toString());
            MBean bean = new MBean();
            bean.setBody(map);
            result = bean.toString();
        }else if(LOCAL.equals(callServiceType) || ( callServiceType== null &&LOCAL.equals(Const.serviceFlag))){
            result = callLocal(serName,par);
        }else if(WEBSERVICE.equals(callServiceType) || (callServiceType == null &&WEBSERVICE.equals(Const.serviceFlag))){
            String[] tems = serName.split(split);
            int len = tems.length;
            if(len>2){
                serName = "Ws"+tems[len-2].substring(1);  
            }
            MBean parBean = new MBean(par);
            parBean.setBody("Method",tems[len-1]);
            Map<String, Object> map = com.sitech.crmpd.core.service.impl.ServiceUtil.callService(serName, parBean.toString());
            MBean bean = new MBean();
            bean.setBody(map);
            result = bean.toString();
        }else{
            result = HttpUtil.invoke(Const.ROOT_PATH+serName, par);
        }
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusiException(e);
        }
        System.out.println("【************Result************】:"+result);
        System.out.println("*******************end call service 【"+serName+"】****************");
        return result;
    }
    
    /**
     * 
     *  Create on 2015年3月25日
     * @author fengjj
     * @version 1.0
     * @Title: callService 
     * @Description: 服务调用同一方法
     * @param @param serName
     * @param @param par
     * @param @return
     * @return String
     * @throws
     * 修改日期:     修改人:     修改目的:
     */
    public static String callService(String serName,String par){
      //读取数据库配置
        //TODO String st = getServiceType(serName);
        String st = null;
        return callService(serName,par,st);
    }
    /**
     * 调用本地
     *  Create on 2015年3月25日
     * @author fengjj
     * @version 1.0
     * @Title: callLocal 
     * @Description: 调用本地
     * @param @param serName
     * @param @param par
     * @param @return
     * @return String
     * @throws
     * 修改日期:     修改人:     修改目的:
     */
    private static String callLocal(String serName,String par){
        String result = null;
        String[] tems = serName.split(split);
        String beanId = null;
        int len = tems.length;
        if(len>2){
            beanId = tems[len-2].substring(1,2).toLowerCase()+tems[len-2].substring(2,tems[len-2].length());  
        }
        System.out.println("beanId:::"+beanId);
        System.out.println("serName:::"+serName);
        serName = serName.substring(0,serName.lastIndexOf(split));
        String calssName = serName.replaceAll(split, ".").substring(0,serName.length()-3);
        String method = tems[len-1];
        System.out.println("calssName::"+calssName+"       method::"+method);
        
        
        MBean bean = new MBean(par);
        OutDTO out = null;
        Object obj = (Object)JCFContext.getBean(beanId);
        try {
            Class calzz = Class.forName(calssName);
            StandardInDTO dto = (StandardInDTO) DtKit.toDTO(bean,StandardInDTO.class);
            Method m = calzz.getMethod(method, InDTO.class);
            Object ret = m.invoke(obj, dto);
            System.out.println("ret:::::::::::"+ret.toString());
            out = (OutDTO)ret;
            //OutDTO out = (OutDTO)res.queryResBrand(dto);
            bean =out.encode();
            result = bean.toString();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                throw new BusiException(e);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                throw new BusiException(e);
            } catch (InvocationTargetException e) {
               e.printStackTrace();
               throw new BusiException(e);
            } catch (SecurityException e) {
                e.printStackTrace();
                throw new BusiException(e);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                throw new BusiException(e);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                throw new BusiException(e);
            }
        return result;
    }
    /**
     * 查询数据库配置，先取本地缓存
     * 返回值类型：String
     * 作者： fengjj
     * 日期： 2014年12月10日
     */
   private static String getServiceType(String serviceName){
       String serviceType = null;
       if(serviceMap.get(serviceName)!=null){
           serviceType = serviceMap.get(serviceName).toString();
       }else{
           Object obj = null;
           try{
               //取数据库配置
               IBaseDao baseDao = (IBaseDao) JCFContext.getBean("baseDao");
               Map map = new HashMap();
               map.put("fieldValue", serviceName);
               map.put("provinceGroup", Const.defaultProvinceGroup);
               obj = baseDao.queryForObject("MkCodenameDict.selectServiceTypeValue", map);
           }catch(Exception e){
               e.printStackTrace();
               throw new BusiException("0000","YXGL system config error,please check");
           }
           
           if(obj!=null){
               serviceType = (String) obj;
               serviceMap.put(serviceName, serviceType);
           }else{
               serviceType = Const.serviceFlag;
               
           }
           System.out.println("serviceType:"+serviceType);
       }
       return serviceType;
   }
   public static void cleanServiceMap(){
       serviceMap.clear();
   }
   
   

}
