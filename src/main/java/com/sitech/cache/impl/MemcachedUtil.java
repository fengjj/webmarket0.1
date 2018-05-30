package com.sitech.cache.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;
import com.sitech.cache.Cache;
import com.sitech.cache.CacheHelper;
import com.sitech.util.PropertiesUtil;
/**
 * 
 * Create on 2015年4月6日 
 * @author: fengjj
 * @Title: MemcachedUtil 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class MemcachedUtil implements Cache,Serializable{

    private static final long serialVersionUID = 1L;

    public static Log log = LogFactory.getLog(MemcachedUtil.class);
	
	// 构建缓存客户端  
    private static MemCachedClient  cachedClient;  
    // 单例模式实现客户端管理类  
    //private static MemcachedUtil INSTANCE = new MemcachedUtil();  
    // 默认过期时间2小时 单位秒
    private static  long  expire = 7200000;
  
    public MemcachedUtil() {  
        cachedClient = new MemCachedClient();  
        cachedClient.setPrimitiveAsString(true);
       // cachedClient.setSanitizeKeys(arg0)
        //获取连接池实例  
        SockIOPool pool = SockIOPool.getInstance();  
        //设置缓存服务器地址，可以设置多个实现分布式缓存  
        String memcachedPath = PropertiesUtil.getProperty("cache.properties", "cachedPath");
        String priority= PropertiesUtil.getProperty("cache.properties", "priority");
        String[] servers=memcachedPath.trim().split(",");
        Integer[]  weights =new Integer[servers.length]  ; // 指定memcached服务器负载量
        if(servers.length>0){
        	 for(int i=0;i<servers.length;i++){
        		 String [] row=priority.trim().split(",");
        		 if(i<row.length&&!"".equals(row[i])){
        			 weights[i]=Integer.parseInt(row[i]);
        		 }else{
        			 weights[i]=0;
        		 }
             }
        	
        }
        // 设置服务器和服务器负载量
        pool.setServers( servers );
        pool.setWeights( weights );
        //设置初始连接5  
        pool.setInitConn(Integer.parseInt(PropertiesUtil.getProperty("cache.properties", "initConn")));   
        //设置最小连接5  
        pool.setMinConn(Integer.parseInt(PropertiesUtil.getProperty("cache.properties", "minConn")));  
        //设置最大连接250  
        pool.setMaxConn(Integer.parseInt(PropertiesUtil.getProperty("cache.properties", "maxConn")));  
        //设置每个连接最大空闲时间3个小时  
        pool.setMaxIdle(1000 * 60 * 60 * 3);  
  
        pool.setMaintSleep(30);  
  
        pool.setNagle(false);  
        pool.setSocketTO(Integer.parseInt(PropertiesUtil.getProperty("cache.properties", "socketTO")));  
        pool.setSocketConnectTO(0);  
        pool.initialize(); 
        try {
        	expire = Long.parseLong(PropertiesUtil.getProperty("cache.properties", "expireTime"));
        	log.info("expire:"+expire);
        } catch(Exception e) {
        }
    }  
      
    /** 
     * 获取缓存管理器唯一实例 
     * @return 
     */  
   /* public static MemcachedUtil getInstance() {  
        return INSTANCE;  
    } */ 
  
      /**
       * 
       * Create on 2015年4月6日
       * @author:fengjj
       * @Title: set
       * @Description: 设置缓存，无论key是否存在 
       * @param key
       * @param value
       * @version 1.0
       * update_data:     update_author:     update_note:
       */
    public void set(String key, Object value) { 
    	Date date=new Date(new Date().getTime()+expire);
    	log.info("key:"+key+"  expiretime:"+date);
    	cachedClient.set(key, value,date); 
    }  
  
      /**
       * 
       * Create on 2015年4月6日
       * @author: fengjj
       * @Title: set
       * @Description: 设置缓存，无论key是否存在，设置缓存过期时间 
       * @param key
       * @param value
       * @param milliseconds
       * @version 1.0
       * update_data:     update_author:     update_note:
       */
    public void set(String key, Object value, int milliseconds) {  
        cachedClient.set(key, value, milliseconds);  
    }  
    
    /**
     * 
     * Create on 2015年4月6日
     * @author:fengjj
     * @Title: add
     * @Description: 如果不存在则添加，存在不变 
     * @param key
     * @param value
     * @param milliseconds
     * @version 1.0
     * update_data:     update_author:     update_note:
     */
    public void add(String key, Object value, int milliseconds) {  
        cachedClient.add(key, value, milliseconds);  
    }
    
    /**
     * 
     * Create on 2015年4月6日
     * @author:fengjj
     * @Title: add
     * @Description: 如果不存在则添加，存在不变 
     * @param key
     * @param value
     * @version 1.0
     * update_data:     update_author:     update_note:
     */
    public void add(String key, Object value) {  
    	Date date=new Date(new Date().getTime()+expire);
    	cachedClient.add(key, value, date);  
    }
    
    /**
     * 
     * Create on 2015年4月6日
     * @author:fengjj
     * @Title: remove
     * @Description: 根据key删除缓存 
     * @param key
     * @version 1.0
     * update_data:     update_author:     update_note:
     */
    public void remove(String key) {  
        cachedClient.delete(key);  
    }
    
    /**
     * 
     * Create on 2015年4月6日
     * @author:fengjj
     * @Title: removeAll
     * @Description: 清空所有缓存 
     * @version 1.0
     * update_data:     update_author:     update_note:
     */
    public void removeAll(){
    	 cachedClient.flushAll();
    } 
    
    /**
     * 
     * Create on 2015年4月6日
     * @author:fengjj
     * @Title: remove
     * @Description: 在缓存中删除key以及对应的值， 
     * @param key
     * @param milliseconds
     * @version 1.0
     * update_data:     update_author:     update_note:
     */
	public void remove(String key, int milliseconds) {  
        cachedClient.delete(key);  
        //cachedClient.flushAll();
    }  
  
      
    /**
     * 
     * Create on 2015年4月6日
     * @author:fengjj
     * @Title: update
     * @Description: 替换键为key的值，并设置过期时长 
     * @param key
     * @param value
     * @param milliseconds
     * @version 1.0
     * update_data:     update_author:     update_note:
     */
    public void update(String key, Object value, int milliseconds) {  
        cachedClient.replace(key, value, milliseconds);  
    }  
  
    /**
     * 
     * Create on 2015年4月6日
     * @author:fengjj
     * @Title: update
     * @Description: 替换，如果不存在则不操作，存在即用新的值替换 
     * @param key
     * @param value
     * @version 1.0
     * update_data:     update_author:     update_note:
     */
    public void update(String key, Object value) {  
        cachedClient.replace(key, value,new Date(new Date().getTime()+expire));  
    }  
      
      
    /**
     * 
     * Create on 2015年4月6日
     * @author:fengjj
     * @Title: get
     * @Description: 根据key获取缓存数据，如果没有返回null 
     * @param key
     * @return
     * @version 1.0
     * update_data:     update_author:     update_note:
     */
    public Object get(String key) {  
        return cachedClient.get(key);  
    }  
    
    /**
     * 
     * Create on 2015年4月6日
     * @author:fengjj
     * @Title: get
     * @Description: 异步的获取多个键值 
     * @param keys
     * @return
     * @version 1.0
     * update_data:     update_author:     update_note:
     */
    public Map<String,Object> get(String[] keys){

        return cachedClient.getMulti(keys);

   }

    /**
     * 
     * Create on 2015年4月6日
     * @author:fengjj
     * @Title: getAll
     * @Description: 获取所有缓存的键值对 
     * @return
     * @version 1.0
     * update_data:     update_author:     update_note:
     */
    public Map<String,Object> getAll(){
    	return cachedClient.getMulti(new String[]{""});
    }
  
    
	public static void main(String[] args) throws Exception{
		Cache memcached = CacheHelper.getInstance();
		//memcached.set("sss", "111");
		//System.out.println(memcached.get("sss"));
		//MemcachedUtil memcached = MemcachedUtil.getInstance();
		
		System.out.println("开始----------");
		int x = 10;
		long time0 = new Date().getTime();
		for(int i = 0 ;i<x;i++){
			memcached.set("act"+i, "string value"+i);
		}
		long time1 = new Date().getTime();
		System.out.println(x+"存入数据用时："+(time1-time0));
		for(int i = 0 ;i<x;i++){
			Object o = memcached.get("act"+i);
			System.out.println(o);
		}
		long time2 = new Date().getTime();
		System.out.println(x+"读取数据用时："+(time2-time1));
		System.out.println("结束----------");
		memcached.set("act", new Date());
		System.out.println(memcached.get("act"));
		/*memcached.set("memcached", memcached);
		MemcachedUtil mb = (MemcachedUtil)memcached.get("memcached");
		*/
		
		
		/*
	     * window 32位 服务端
		 * 100000存入数据用时：8596
			100000存入数据用时：8097*/
		//System.out.println(cachedClient.stats());
	    //对象
	   // String serialValue = memcached.objToString(u);
	   // System.out.println(serialValue);
	   // memcached.add("user", serialValue);
	   // WsGetSaleMeansContentReq student =  memcached.strToObj((String)memcached.get("user"), WsGetSaleMeansContentReq.class);
	   // System.out.println(student.getAct_id());
		//MemCachedUtil u = MemCachedUtil.getInstance();
		//u.add("vincent", "1234545667");
		//System.out.println(u.get("tag1"));
		//u.remove("Artist3");
		//System.out.println(u.get("Artist3"));
		//u.add("foo", 12345);
		//System.out.println(u.get("foo"));
		//System.out.println(u.get("vincent"));
		//u.getAll();
		//memcached.remove("A03");
		//memcached.remove("201308101004445844mobile");
		
		
	}

    @Override
    public void set(Map<String, Object> map) {
        // TODO Auto-generated method stub
        
    }




}
