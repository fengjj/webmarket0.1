package com.sitech.market.dbo.destribution.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sitech.jcf.core.exception.BaseException;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IEvent;
import com.sitech.util.CassandraUtil;
import com.sitech.util.ConfigBeanFactory;
import com.sitech.util.Const;
import com.sitech.util.MBeanUtil;

public class Event extends DBMysqlClass implements IEvent {
	    /**
        	* 
        	*  Create on 2014-11-15 上午11:21:07
        	* @author tianyy_bj
        	* @version 1.0
        	* Copyright(c) 北京思特奇信息技术股份有限公司
        	* 功能描述：
        	* 修改日期:     修改人:     修改目的:
        	*/
	CassandraUtil cassandraDao = (CassandraUtil) ConfigBeanFactory.getBean("cassandraUtil");
//	private Cache cache = CacheHelper.getInstance();

	public List<Map<String,String>> selectConductsById(Map map){
		return baseDao.queryForList("MkEventcontentInfo.selectConductsById", map);
	}
    public boolean insertMkEventInfoList(List<Map> list){
    	boolean flag = false;
    	try{
    	baseDao.batchInsert("MkEventInfo.insertMkEventInfo", list);
    	flag = true;
    	}catch(Exception e){
    		flag = false;
    		throw new BaseException("1113", e+"亲,insertMkEventInfoList出异常了,到后台看看吧");
    	}
    	return flag;
    }
    /**
    	* 
    	*  Create on 2014-11-15 上午11:21:07
    	* @author tianyy_bj
    	* @version 1.0
    	* Copyright(c) 北京思特奇信息技术股份有限公司
    	* 功能描述：
    	* 修改日期:     修改人:     修改目的:
    	*/
    public boolean insertMkEventcontentInfoList(List<Map> list){
    	boolean flag = false;
    	try{
    	baseDao.batchInsert("MkEventcontentInfo.insertMkEventcontentInfo", list);
    	flag = true;
    	}catch(Exception e){
    		flag = false;
    		throw new BaseException("1113", e+"亲,insertMkEventcontentInfoList出异常了,到后台看看吧");
    	}
    	return flag;
    }
    
    
    /**
    	* 
    	*  Create on 2014-11-15 上午11:21:07
    	* @author tianyy_bj
    	* @version 1.0
    	* Copyright(c) 北京思特奇信息技术股份有限公司
    	* 功能描述：
    	* 修改日期:     修改人:     修改目的:
    	*/
    public boolean deleteMkEventcontentInfoByEventid(MBean bean){
    	boolean flag = false;
    	try{
	    	baseDao.delete("MkEventcontentInfo.deleteMkEventcontentInfoById", MBeanUtil.setBodyToMap(bean));
	    	flag = true;
	    	}catch(Exception e){
	    		flag = false;
	    		throw new BaseException("1112", e+"亲,deleteMkEventcontentInfoByEventid出异常了,到后台看看吧");
	    	}
    	return flag;
    }
    
    /**
    	* 
    	*  Create on 2014-11-15 上午11:21:07
    	* @author tianyy_bj
    	* @version 1.0
    	* Copyright(c) 北京思特奇信息技术股份有限公司
    	* 功能描述：
    	* 修改日期:     修改人:     修改目的:
    	*/
    public boolean deleteMkEventInfoByEventid(MBean bean){
    	boolean flag = false;
    	try{
	    	baseDao.delete("MkEventInfo.deleteMkEventInfoById", MBeanUtil.setBodyToMap(bean));
	    	flag = true;
	    	}catch(Exception e){
	    		flag = false;
	    		throw new BaseException("1112", e+"亲,deleteMkEventInfoByEventid出异常了,到后台看看吧");
	    	}
    	return flag;
    }
	    
	    /**
      * 
      *  Create on 2014-12-17 下午14:54:07
      * @author nidw
      * @version 1.0
      * Copyright(c) 北京思特奇信息技术股份有限公司
      * 功能描述：
      * 修改日期:     修改人:     修改目的:
      */
    public boolean insertMkEventTracByEventid(MBean bean) {
        boolean flag = false;
        try {
            baseDao.insert("MkEventInfo.insertMkEventTracByEventid", MBeanUtil.setBodyToMap(bean));
            flag = true;
        } catch (Exception e) {
            flag = false;
            throw new BaseException("1113", e + "亲,insertMkEventTracByEventid出异常了,到后台看看吧");
        }
        return flag;
    }
	    
    @Override
	public void deleteMkAuditResultInfo(Map deleteMap) {
		try {
			baseDao.delete("MkAuditresultInfo.deleteMkAuditresultInfo",deleteMap);
		} catch (Exception e) {
			throw new BaseException("1113", e + "亲,deleteMkAuditResultInfo出异常了,到后台看看吧");
		}
		
	}
	/**
    	* 
    	*  Create on 2014-11-15 上午11:21:07
    	* @author tianyy_bj
    	* @version 1.0
    	* Copyright(c) 北京思特奇信息技术股份有限公司
    	* 功能描述：
    	* 修改日期:     修改人:     修改目的:
    	*/
    public boolean deleteMkImgitemInfoByActid(MBean bean){
    	boolean flag = false;
    	try{
	    	baseDao.delete("MkImgitemInfo.deleteMkImgitemInfoByActid", MBeanUtil.setBodyToMap(bean));
	    	flag = true;
	    	}catch(Exception e){
	    		flag = false;
	    		throw new BaseException("1112", e+"亲,deleteMkImgitemInfoByActid出异常了,到后台看看吧");
	    	}
    	return flag;
    }
    
    /**
    	* 
    	*  Create on 2014-11-15 上午11:21:07
    	* @author tianyy_bj
    	* @version 1.0
    	* Copyright(c) 北京思特奇信息技术股份有限公司
    	* 功能描述：
    	* 修改日期:     修改人:     修改目的:
    	*/
    public boolean deleteMkImgconnectionInfoByActid(MBean bean){
    	boolean flag = false;
    	try{
	    	baseDao.delete("MkImgconnectionInfo.MkImgconnectionInfoByid", MBeanUtil.setBodyToMap(bean));
	    	flag = true;
	    	}catch(Exception e){
	    		flag = false;
	    		throw new BaseException("1112", e+"亲,deleteMkImgconnectionInfoByActid出异常了,到后台看看吧");
	    	}
    	return flag;
    }
    
    /**
    	* 
    	*  Create on 2014-11-15 上午11:21:07
    	* @author tianyy_bj
    	* @version 1.0
    	* Copyright(c) 北京思特奇信息技术股份有限公司
    	* 功能描述：
    	* 修改日期:     修改人:     修改目的:
    	*/
    public boolean insertMkImgitermInfoList(List<Map> list){
    	boolean flag = false;
    	try{
    	baseDao.batchInsert("MkImgitemInfo.insertMkImgitemInfo", list);
    	flag = true;
    	}catch(Exception e){
    		flag = false;
    		throw new BaseException("1113", e+"亲,insertMkImgitermInfoList出异常了,到后台看看吧");
    	}
    	return flag;
    }
    
    /**
    	* 
    	*  Create on 2014-11-15 上午11:21:07
    	* @author tianyy_bj
    	* @version 1.0
    	* Copyright(c) 北京思特奇信息技术股份有限公司
    	* 功能描述：
    	* 修改日期:     修改人:     修改目的:
    	*/
    public boolean insertMkImgconnectinInfoList(List<Map> list){
    	boolean flag = false;
    	try{
    	baseDao.batchInsert("MkImgconnectionInfo.insertMkImgconnectionInfo", list);
    	flag = true;
    	}catch(Exception e){
    		flag = false;
    		throw new BaseException("1113", e+"亲,insertMkImgconnectinInfoList出异常了,到后台看看吧");
    	}
    	return flag;
    }
    
    /**
    	* 
    	*  Create on 2014-11-15 上午11:21:07
    	* @author tianyy_bj
    	* @version 1.0
    	* Copyright(c) 北京思特奇信息技术股份有限公司
    	* 功能描述：
    	* 修改日期:     修改人:     修改目的:
    	*/
    public boolean updateMkEventInfo(MBean bean){
    	boolean flag = false;
    	try{
    	baseDao.update("MkEventInfo.updateStatusMkEventInfo", MBeanUtil.setBodyToMap(bean));
    	flag = true;
    	}catch(Exception e){
    		flag = false;
    		throw new BaseException("1114", e+"亲,updateMkEventInfo出异常了,到后台看看吧");
    	}
    	return flag;
    }
	    
	    /**
      * 
      *  Create on 2014-12-17 下午15:34:07
      * @author nidw
      * @version 1.0
      * Copyright(c) 北京思特奇信息技术股份有限公司
      * 功能描述：
      * 修改日期:     修改人:     修改目的:
      */
    public boolean updateMkEventInfoStatus(MBean bean) {
        boolean flag = false;
        try {
            baseDao.update("MkEventInfo.updateMkEventInfoStatus", MBeanUtil.setBodyToMap(bean));
            String eventId = bean.getBodyStr("eventId");
//            if(cache!=null){
//            	cache.removeAll();
//            	//removeCache(eventId);
//            }
            flag = true;
        } catch (Exception e) {
            flag = false;
            throw new BaseException("1114", e + "亲,updateMkEventInfoStatus出异常了,到后台看看吧");
        }
        return flag;
    }
	    
    /**
    	* 
    	*  Create on 2014-11-15 上午11:21:07
    	* @author tianyy_bj
    	* @version 1.0
    	* Copyright(c) 北京思特奇信息技术股份有限公司
    	* 功能描述：
    	* 修改日期:     修改人:     修改目的:
    	*/
    public boolean insertMkAuditInfo(MBean bean){
    	boolean flag = false;
    	try{
	    	baseDao.insert("MkAuditresultInfo.insertEventMkAuditInfo", MBeanUtil.setBodyToMap(bean));
	    	String eventId = bean.getBodyStr("eventId");
//            if(cache!=null){
//            	cache.removeAll();
////            	removeCache(eventId);
//            }
	    	flag = true;
	    	}catch(Exception e){
	    		flag = false;
	    		throw new BaseException("1113", e+"亲,insertMkAuditInfo出异常了,到后台看看吧");
	    	}
    	return flag;
    }
    
    /**
    	* 
    	*  Create on 2014-11-15 上午11:21:07
    	* @author tianyy_bj
    	* @version 1.0
    	* Copyright(c) 北京思特奇信息技术股份有限公司
    	* 功能描述：
    	* 修改日期:     修改人:     修改目的:
    	*/
    public List<Map> queryImgItemListByActid(MBean bean){
    	List<Map> list = null;
    	try{
    		list = baseDao.queryForList("MkImgitemInfo.selectMkImgitemInfoByActid", MBeanUtil.setBodyToMap(bean));
    	}catch(Exception e){
    		throw new BaseException("1111", e+"亲,queryImgItemListByActid出异常了,到后台看看吧");
    	}
    	return list;
    }
    
    /**
    	* 
    	*  Create on 2014-11-15 上午11:21:07
    	* @author tianyy_bj
    	* @version 1.0
    	* Copyright(c) 北京思特奇信息技术股份有限公司
    	* 功能描述：
    	* 修改日期:     修改人:     修改目的:
    	*/
    public List<Map> queryMkImgconnectionInfoListByActid(MBean bean){
    	List<Map> list = null;
    	try{
    		list = baseDao.queryForList("MkImgconnectionInfo.selectMkImgconnectionInfoListByActid", MBeanUtil.setBodyToMap(bean));
    	}catch(Exception e){
    		throw new BaseException("1111", e+"亲,queryMkImgconnectionInfoListByActid出异常了,到后台看看吧");
    	}
    	return list;
    }
    
    /**
    	* 
    	*  Create on 2014-11-15 上午11:21:07
    	* @author tianyy_bj
    	* @version 1.0
    	* Copyright(c) 北京思特奇信息技术股份有限公司
    	* 功能描述：
    	* 修改日期:     修改人:     修改目的:
    	*/
    public List<Map> queryImgContentListActid(MBean bean){
    	List<Map> list = null;
    	try{
    		list = baseDao.queryForList("MkEventcontentInfo.selectImgContentListActid", MBeanUtil.setBodyToMap(bean));
    	}catch(Exception e){
    		throw new BaseException("1111", e+"亲,queryImgContentListActid出异常了,到后台看看吧");
    	}
    	return list;
    }
    
    /**
    	* 
    	*  Create on 2014-11-15 上午11:21:07
    	* @author tianyy_bj
    	* @version 1.0
    	* Copyright(c) 北京思特奇信息技术股份有限公司
    	* 功能描述：
    	* 修改日期:     修改人:     修改目的:
    	*/
    public List<Map> queryMkEventInfoList(MBean bean){
    	List<Map> list = null;
    	try{
    		list = baseDao.queryForList("MkEventInfo.selectActconduct", MBeanUtil.setBodyToMap(bean));
    	}catch(Exception e){
    		throw new BaseException("1111", e+"亲,queryMkEventInfoList出异常了,到后台看看吧");
    	}
    	return list;
    }
    
    /**
    	* 
    	*  Create on 2014-11-15 上午11:21:07
    	* @author tianyy_bj
    	* @version 1.0
    	* Copyright(c) 北京思特奇信息技术股份有限公司
    	* 功能描述：
    	* 修改日期:     修改人:     修改目的:
    	*/
    public Map queryMkActconductName(MBean bean){
    	Map map = null;
    	try{
    		map = (Map) baseDao.queryForObject("MkActconductDict.selectActconductName", MBeanUtil.setBodyToMap(bean));
    	}catch(Exception e){
    		throw new BaseException("1111", e+"亲,queryMkActconductName出异常了,到后台看看吧");
    	}
    	return map;
    }
    
    /**
    	* 
    	*  Create on 2014-11-15 上午11:21:07
    	* @author tianyy_bj
    	* @version 1.0
    	* Copyright(c) 北京思特奇信息技术股份有限公司
    	* 功能描述：
    	* 修改日期:     修改人:     修改目的:
    	*/
    public List<Map> queryActConductContentList(MBean bean){
    	List<Map> list = null;
    	try{
    		list = baseDao.queryForList("MkActconductparDict.selectActConductContentList", MBeanUtil.setBodyToMap(bean));
    	}catch(Exception e){
    		throw new BaseException("1111", e+"亲,queryActConductContentList出异常了,到后台看看吧");
    	}
    	return list;
    }
    
    /**
    	* 
    	*  Create on 2014-11-15 上午11:21:07
    	* @author tianyy_bj
    	* @version 1.0
    	* Copyright(c) 北京思特奇信息技术股份有限公司
    	* 功能描述：
    	* 修改日期:     修改人:     修改目的:
    	*/
    public List<Map> queryMkEventtypeDict(MBean bean){
    	List<Map> list = null;
    	try{
    		list = baseDao.queryForList("MkCodenameDict.selectMkEventtypeDict");
    	}catch(Exception e){
    		throw new BaseException("1111", e+"亲,queryMkEventtypeDict出异常了,到后台看看吧");
    	}
    	return list;
    }
    /**
    	* 
    	*  Create on 2014-11-15 上午11:21:07
    	* @author tianyy_bj
    	* @version 1.0
    	* Copyright(c) 北京思特奇信息技术股份有限公司
    	* 功能描述：
    	* 修改日期:     修改人:     修改目的:
    	*/
    public List<Map> queryPermissionForList(){
    	List<Map> list = null;
    	try{
    		list = baseDao.queryForList("MkActconductDict.selectPermissionList");
    	}catch(Exception e){
    		throw new BaseException("1111", e+"亲,queryPermissionForList出异常了,到后台看看吧");
    	}
    	return list;
    }
    
    /**
    	* 
    	*  Create on 2014-11-15 上午11:21:07
    	* @author tianyy_bj
    	* @version 1.0
    	* Copyright(c) 北京思特奇信息技术股份有限公司
    	* 功能描述：
    	* 修改日期:     修改人:     修改目的:
    	*/
    public List<Map> queryPermissionparList(){
    	
    	List<Map> list = null;
    	try{
    		list = baseDao.queryForList("MkActconductparDict.selectPermissionParList");
    	}catch(Exception e){
    		throw new BaseException("1111", e+"亲,queryPermissionparList出异常了,到后台看看吧");
    	}
    	return list;
    }
    
    
    /**
    	* 
    	*  Create on 2014-11-15 上午11:21:07
    	* @author tianyy_bj
    	* @version 1.0
    	* Copyright(c) 北京思特奇信息技术股份有限公司
    	* 功能描述：
    	* 修改日期:     修改人:     修改目的:
    	*/
    public List<Map> queryMsgType(MBean bean){
    	List<Map> list = null;
    	try{
    	 list = baseDao.queryForList("MkCodenameDict.selectMkmsgtypeDict",MBeanUtil.setBodyToMap(bean));
    	}catch(Exception e){
    		throw new BaseException("2323", e+"亲,queryMsgType出异常了,到后台看看吧");
    	}
    	return list;
    }
    
    
    /**
    	* 
    	*  Create on 2014-11-15 上午11:21:07
    	* @author tianyy_bj
    	* @version 1.0
    	* Copyright(c) 北京思特奇信息技术股份有限公司
    	* 功能描述：
    	* 修改日期:     修改人:     修改目的:
    	*/
    public List<Map> queryActConductForList(MBean bean){
    	System.out.println("........."+bean);
    	List<Map> list = null;
    	try{
    		list = baseDao.queryForList("MkActconductDict.selectMkActcondutDictType",MBeanUtil.setBodyToMap(bean));
    	}catch(Exception e){
    		throw new BaseException("1111", e+"亲,query出异常了,到后台看看吧");
    	}
    	return list;
    }
    
    
    /**
    	* 
    	*  Create on 2014-11-15 上午11:21:07
    	* @author tianyy_bj
    	* @version 1.0
    	* Copyright(c) 北京思特奇信息技术股份有限公司
    	* 功能描述：
    	* 修改日期:     修改人:     修改目的:
    	*/
    public List<Map> queryActConductParForList(){
    	List<Map> list = null;
    	try{
    		list = baseDao.queryForList("MkActconductDict.selectMkActconductparDict");
    	}catch(Exception e){
    		throw new BaseException("1111", e+"亲,query出异常了,到后台看看吧");
    	}
    	return list;
    }
    
    /**
    	* 
    	*  Create on 2014-11-15 上午11:21:07
    	* @author tianyy_bj
    	* @version 1.0
    	* Copyright(c) 北京思特奇信息技术股份有限公司
    	* 功能描述：
    	* 修改日期:     修改人:     修改目的:
    	*/
    public Map queryEventInfoByid(MBean bean){
    	Map map = null;
    	try{
    		map = (Map) baseDao.queryForObject("MkEventInfo.selectEventInfoByid", MBeanUtil.setBodyToMap(bean));
    	}catch(Exception e){
    		throw new BaseException("1111", e+"亲,queryEventInfoByid出异常了,到后台看看吧");
    	}
    	return map;
    }    
	    
	    /**
      * 
      *  Create on 2014-12-30 上午11:21:07
      * @author nidw
      * @version 1.0
      * Copyright(c) 北京思特奇信息技术股份有限公司
      * 功能描述：
      * 修改日期:     修改人:     修改目的:
      */
    public List queryEvent(String eventId) {
        List list = null;
        try {
            list = baseDao.queryForList("MkEventInfo.selectEvent", eventId);
        } catch (Exception e) {
            throw new BaseException("1111", e + "亲,queryEvent出异常了,到后台看看吧");
        }
        return list;
    }
	    
    /**
    	* 
    	*  Create on 2014-11-15 上午11:21:07
    	* @author tianyy_bj
    	* @version 1.0
    	* Copyright(c) 北京思特奇信息技术股份有限公司
    	* 功能描述：
    	* 修改日期:     修改人:     修改目的:
    	*/
    public MBean updateMkEventInfoById(MBean bean) {
        try {
            bean.setBody("resultBean",baseDao.update("MkEventInfo.updateMkEventInfoById", MBeanUtil.setBodyToMap(bean)));
            String eventId = bean.getBodyStr("eventId");
//            if(cache!=null){
//            	cache.removeAll();
//            	//removeCache(eventId);
//            }
       } catch (Exception e) {
            throw new BaseException("1112", "亲,updateMkEventInfoById出异常了,到后台看看吧");
        }
        return bean;
    }
	    
	  /**
      * 查询码表信息
      * @param bean
      * @return
      * @author jiaxla  2014-12-17
      */
     public List<Map> queryType(Map para){
      List<Map> list = null;
      try {
       list=baseDao.queryForList("MkCodenameDict.selectMkTypeDict", para);
         } catch (Exception e) {
             throw new BaseException("1112", "亲,selectMkTypeDict出异常了,到后台看看吧");
         }
      return list;
     }
	  /**
      * 查询优先级信息
      * @param bean
      * @return
      * @author jiaxla  2014-12-17
      */
     public List<Map> queryPriorityList(){
    	List<Map> list = null;
    	try {
    		list=baseDao.queryForList("MkCodenameDict.selectMkProiorityDict");
        } catch (Exception e) {
            throw new BaseException("1112", "亲,selectMkProiorityDict出异常了,到后台看看吧");
        }
    	return list;	    	
     }
     
	  /**
      * 查询资费信息
      * @param bean
      * @return
      * @author jiaxla  2014-12-17
      */
	public List<Map> queryPrcFeeList(String para) {
		List<Map> list = null;
    	try {
    		list=baseDao.queryForList("MkCodenameDict.selectMkPrcFeeDict",para);
        } catch (Exception e) {
            throw new BaseException("1112", "亲,selectMkProiorityDict出异常了,到后台看看吧");
        }
    	return list;
	}
	

	public Map<String, String> queryEventBasicById(String eventId) {
		List retList= null;
		Map<String, String> ret = null;
		Map<String,String> para = new HashMap<String, String>();
		para.put("eventId", eventId);
    	try {
    		retList=baseDao.queryForList("MkEventInfo.selectMkEventInfoById",para);
    		ret =(Map<String, String>) retList.get(0);
        } catch (Exception e) {
            throw new BaseException("1112", "亲,MkEventInfo.selectMkEventInfoById 出异常了,到后台看看吧");
        }
    	return ret;
	}
	/**
     * 
     * 功能描述：获得某省某地市某个等级的审批人信息
     * @author shangjun
     * Create on 2015-1-28
     * @param province_center
     * @param regionCode
     * @param audit_level
     * @return
     * Copyright(c) 北京思特奇信息技术股份有限公司
     */
	public Map getAuditInfo(String province_center, String regionCode,
			String audit_level) {
		Map<String, String> auditMap = null;
		List<Map<String, String>> auditList = null;
		Map<String,String> para = new HashMap<String, String>();
		audit_level = String.valueOf(Integer.valueOf(audit_level) + 1);
		para.put("provinceGroup", province_center);
		para.put("regionCode", regionCode);
		para.put("auditLevel", audit_level);
		try{
			auditList = baseDao.queryForList("MkAuditlevelDict.selectMkAuditlevelDict", para);
			if(auditList != null && auditList.size() > 0){
				auditMap = auditList.get(0);
			}
		} catch (Exception e){
			throw new BaseException("2222", "亲,MkAuditlevelDict.selectMkAuditlevelDict出异常了,到后台看看吧");
		}
		return auditMap;
	}
	/**
	 * 
	 * 功能描述：获取最大序列的审批结果信息
	 * @author shangjun
	 * Create on 2015-1-29
	 * @param busiId
	 * @param busiType
	 * @return
	 * Copyright(c) 北京思特奇信息技术股份有限公司
	 */
	public Map getAuditResultInfo(String busiId, String busiType) {
		Map<String, String> auditResultMap = null;
		List<Map<String, String>> auditResultList = null;
		Map<String,String> para = new HashMap<String, String>();
		para.put("busiId", busiId);
		para.put("busiType", busiType);
		para.put("statusCode", "0");
		try{
			auditResultList = baseDao.queryForList("MkAuditresultInfo.selectMaxAuditresultByBusiId",para);
			if(auditResultList != null && auditResultList.size() > 0){
				auditResultMap = auditResultList.get(0);
			}
		} catch (Exception e){
			throw new BaseException("2222", "亲,MkAuditresultInfo.selectMaxAuditresultByBusiId出异常了,到后台看看吧");
		}
		return auditResultMap;
	}
    /**
     * 清除缓存
     * 
     * @param eventId
     */
    private void removeCache(String eventId) {
    	List list =queryEvent(eventId);
        if(cache!=null){
	    	if (null !=list && list.size()>0) {
	    		String eventType =(String) ((Map) list.get(0)).get("busiType");
	    		//短信夹带
	    		if("00".equals(eventType)){
	    			cache.remove("messattach_eventid");
	    			cache.remove("messattach_custgroup_"+eventId);
	    			cache.remove("messattach_warntype_"+eventId);
	    			cache.remove("messattach_sms_"+eventId);
	    			System.out.println("Memcache Clear:messattach");
	    		//流量提醒	
	    		}else if("04".equals(eventType)){
	    			cache.remove("fluxremind_eventid");
	    			cache.remove("fluxremind_black");
	    			cache.remove("fluxremind_userstatus");
	    			cache.remove("fluxremind_limit");
	    			cache.remove("fluxremind_nolimitnofirst");
	    			cache.remove("fluxremind_nolimitfirst");
	    			cache.remove("fluxremind_iscust");
	    			System.out.println("Memcache Clear:fluxremind");
	    		//签到抽奖
	    		}else if("05".equals(eventType)){
	    			//暂无
	    		//排行榜
	    		}else if("06".equals(eventType)){
	    			//暂无
	    		//缴费
	    		}else if("07".equals(eventType)){
	    			cache.remove("payfee_eventid");
	    			cache.remove("payfee_custgroup_"+eventId);
	    			cache.remove("payfee_paymenttype_"+eventId);
	    			cache.remove("payfee_limit_"+eventId);
	    			cache.remove("payfee_times_"+eventId);
	    			cache.remove("recommended_chntype_"+eventId);
	    			cache.remove("recommended_sendmsg_"+eventId);
	    			cache.remove("recommended_act_"+eventId);
	    			//cache.remove("recommended_phoneno_"+eventId);//不删
	    			System.out.println("Memcache Clear: payfee");
	    		//产品订购
	    		}else if("08".equals(eventType)){
	    			cache.remove("productorder_eventid");
	    			cache.remove("productorder_custgroup_"+eventId);
	    			cache.remove("productorder_prcid_"+eventId);
	    			cache.remove("productorder_times_"+eventId);
	    			cache.remove("recommended_chntype_"+eventId);
	    			cache.remove("recommended_sendmsg_"+eventId);
	    			cache.remove("recommended_act_"+eventId);
	    			System.out.println("Memcache Clear: productorder");
	    		//终端订购
	    		}else if("09".equals(eventType)){
	    			cache.remove("terminalorder_eventid");
	    			cache.remove("terminalorder_custgroup_"+eventId);
	    			cache.remove("terminalorder_times_"+eventId);
	    			cache.remove("terminalorder_tmplid_"+eventId);
//	    			cache.remove("recommended_phoneno_"+idno);//不删
	    			System.out.println("Memcache Clear: terminalorder");
	    		//精准推荐
	    		}else if("10".equals(eventType)){
	    			//暂无
	    		}
			}
        }
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
	public List queryEventInfo(Map sourceMap) {
		List list = null;
		try{
			list = baseDao.queryForList("MkEventInfo.selectMkEventInfoBySome", sourceMap);
		}catch(Exception e){
			e.printStackTrace();
			throw new BaseException("2222", "亲,queryEventInfo出异常了,到后台看看吧");
		}
		return list;
	}
	/**
     * 
     * @Description: 视图保存推荐活动基本信息
     * @param @param inparam
     * @param @return   
     * @return OutDTO  
     * @throws
     * @author yangrc
     * @date August 12, 2015
     * @version V1.0
     * 修改时间    修改人    实现功能
     */
	public List updateMkEventcontentInfoOfParvalue(MBean bean){
		List list = null;
		try{
			baseDao.update("MkEventcontentInfo.updateMkEventcontentInfoOfParvalue", MBeanUtil.setBodyToMap(bean));
		}catch(Exception e){
			e.printStackTrace();
			throw new BaseException("2222", "亲,updateMkEventcontentInfoOfParvalue出异常了,到后台看看吧");
		}
		return list;
	}
	/**
     * 
     * @Description: 视图保存推荐活动基本信息
     * @param @param inparam
     * @param @return   
     * @return OutDTO  
     * @throws
     * @author fengjj
     * @date 12 14, 2015
     * @version V1.0
     * 修改时间    修改人    实现功能
     */
	@Override
	public List<Map<String,String>> selectMkEventcontentInfoById(Map bean){
		List<Map<String,String>> map = null;
		try{
			map = baseDao.queryForList("MkEventcontentInfo.selectMkEventcontentInfoById", bean);
		}catch(Exception e){
			e.printStackTrace();
			throw new BaseException("2222", "亲,selectMkEventcontentInfoById出异常了,到后台看看吧");
		}
		return map;
	}
	
	/**
	 * 
	 */
	@Override
	public String queryDataCount(String eventId) {
		Map map = (Map)baseDao.queryForObject("MkEventresultInfo.selectMkEventresultInfoCount",eventId);
		return map.get("allCount").toString();
	}
	/**
	 * 
	 */
	@Override
	public String queryAllDataById(String eventId) {
		Map map = (Map)baseDao.queryForObject("MkMsgsendInfo.selectAllCountById",eventId);
		return map.get("allCount").toString();
	}
	@Override
	public String queryPreDataById(String eventId) {
		Map map = (Map)baseDao.queryForObject("MkMsgsendInfo.selectPreCountById",eventId);
		return map.get("preCount").toString();
	}
	@Override
	public List<Map> queryUsedDataGroupByPhoneNo(Map inMap){
		return (List<Map>)baseDao.queryForList("MkEventresultInfo.selectMkEventresultInfoGroupByPhoneNo",inMap);
	}
	@Override
	public List<Map> queryUsedDataTrac(Map inMap){
		return (List<Map>)baseDao.queryForList("MkEventresultInfo.selectUsedDataTrac",inMap);
	}
	
	@Override
	public Integer selectMaxTargetValue(){
		return (Integer)baseDao.queryForObject("MkTargetValueInfo.selectMaxTargetValue");
	}
	@Override
	public void insertTargetValue(Map<String,Object> inMap){
		baseDao.insert("MkTargetValueInfo.insertTargetValue",inMap);
	}
}
