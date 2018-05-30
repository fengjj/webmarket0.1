package com.sitech.cache;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sitech.util.PropertiesUtil;

public class CacheHelper {
	public static Log log = LogFactory.getLog(CacheHelper.class);
	private static Cache cache = init();
	/**
	 * 
	 * Create on 2015年4月6日
	 * @author:fengjj
	 * @Title: getInstance
	 * @Description: 获取缓存对象实例
	 * @return
	 * @version 1.0
	 * update_data:     update_author:     update_note:
	 */
	public static Cache getInstance(){
	    
//	    if(cache instanceof JedisUtil ){
//	        //需要每个对象单独创建
//	        return new JedisUtil() ;
//	    }
		return cache;
		
	}
	/**
	 * 
	 * Create on 2015年4月6日
	 * @author:fengjj
	 * @Title: init
	 * @Description: 根据配置文件配置的类路径初始化一个缓存的实例
	 * @return
	 * @version 1.0
	 * update_data:     update_author:     update_note:
	 */
	private static Cache init(){
		if(cache!=null){
			return cache;
		}
		try {
			String strClass = PropertiesUtil.getProperty("cache.properties", "impl_class");
			Class<?> cla = Class.forName(strClass);
			cache = (Cache)cla.newInstance();	
			log.info(" 创建缓存类成功 :"+cache.getClass());
		} catch (ClassNotFoundException e) {
			log.error("创建缓存实例失败，请检查缓存实现类配置是否存在，或者配置文件impl_class属性是否正确配置");
			e.printStackTrace();
		} catch (InstantiationException e) {
			log.error("创建缓存实例失败");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			log.error("创建缓存实例失败");
			e.printStackTrace();
		}catch (Exception e) {
			log.error("创建缓存实例失败");
			e.printStackTrace();
		}
		return cache;
	}
	/**
	 * 私有构造器
	 */
	private CacheHelper(){
		
	}
}
