package com.sitech.cache.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import com.sitech.cache.Cache;
import com.sitech.cache.CacheHelper;
import com.sitech.util.PropertiesUtil;
import com.sitech.util.SerializeUtil;

/**       
 * Create on 2015年4月1日 
 * @author: fengjj
 * @Title: JedisUtil
 * @Description：
 * @version 1.0  
 * update_data:     update_author:     update_note:    
 */
public class JedisUtil implements Cache{

    private Log log = LogFactory.getLog(JedisUtil.class);
    //默认使用切片客户端连接 使数据平均的分配到多台Redis服务器上
    private ShardedJedis shardedJedis;//切片额客户端连接
    private static JedisCluster jc = null;
    private static ShardedJedisPool shardedJedisPool;//切片连接池
    private static String share = PropertiesUtil.getProperty("cache.properties", "share").trim();
    private static String passWord = PropertiesUtil.getProperty("cache.properties", "passWord").trim();
    // 最大连接超时时间
    private static int timeOut = Integer.parseInt(PropertiesUtil.getProperty("cache.properties", "timeOut").trim());
    static{
    	// 最大连接数
        int maxConn = Integer.parseInt(PropertiesUtil.getProperty("cache.properties", "maxConn").trim());
        // 设置最大空闲数
        int maxIdleConn = Integer.parseInt(PropertiesUtil.getProperty("cache.properties", "maxIdleConn").trim());
        // 最大等待超时时间
        int maxWaitMillis = Integer.parseInt(PropertiesUtil.getProperty("cache.properties", "maxWait").trim());
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxTotal(maxConn);
        config.setMaxIdle(maxIdleConn);
        config.setMaxWaitMillis(maxWaitMillis);
        config.setTestOnBorrow(true);
       	config.setTestOnReturn(true);
        initialShardedPool(config); 
    }
    /**
     * 
     *  Create on 2015年4月1日
     * @author fengjj
     * @version 1.0
     * @Title: getShardedJedis 
     * @Description: 获取切片额客户端连接对象
     * @param @return
     * @return ShardedJedis
     * @throws
     * 修改日期:     修改人:     修改目的:
     */
    public ShardedJedis getShardedJedis(){
        return shardedJedis;
    }
    
    /**
     *  普通构造函数
     */
    public JedisUtil() 
    { 
        // shardedJedis = shardedJedisPool.getResource();  
    } 
    /**
     * 
     * Create on 2015年4月6日
     * @author:fengjj
     * @Title: initialShardedPool
     * @Description: 初始化切片池  
     * @version 1.0
     * update_data:     update_author:     update_note:
     */
    private static void initialShardedPool(GenericObjectPoolConfig config){
        String cachedPath = PropertiesUtil.getProperty("cache.properties", "cachedPath").trim();
        String[] servers = cachedPath.split(",");
        if(servers.length>0){
        	if("server".equals(share))
        	{
        		Set<HostAndPort> set = new HashSet<HostAndPort>();
                for(int i=0;i<servers.length;i++){
                    String[] path = servers[i].split(":");
                    HostAndPort hap = new HostAndPort(path[0], Integer.parseInt(path[1]));
                    set.add(hap);
                }
                jc = new JedisCluster(set, timeOut, config);
        	}
        	else
        	{
        		List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
                //设置缓存服务器地址，可以设置多个实现分布式缓存 
                if(servers.length > 0)
                {
                    for(int i=0; i<servers.length; i++){
                        String[] path = servers[i].split(":");
                        JedisShardInfo si = new JedisShardInfo(path[0], Integer.parseInt(path[1]));
                        //设置统一密码
                        if(passWord != null && !"".equals(passWord))
                        {
                            si.setPassword(passWord);
                        }
                        si.setTimeout(timeOut);
                        shards.add(si);
                    }
                }
                // 池对象
                shardedJedisPool = new ShardedJedisPool(config, shards);
        	}

        }
    }

    
    /**
     * 
     * Create on 2015年4月6日
     * @author:fengjj
     * @Title: initialShardedPool
     * @Description: 初始化切片池  
     * @version 1.0
     * update_data:     update_author:     update_note:
     */
    private static void initialShardedPool() 
    { 
        List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
      //设置缓存服务器地址，可以设置多个实现分布式缓存  
        String cachedPath = PropertiesUtil.getProperty("cache.properties", "cachedPath").trim();
        String passWord = PropertiesUtil.getProperty("cache.properties", "passWord").trim();
        String[] servers = cachedPath.split(",");
        if(servers.length>0){
            for(int i=0;i<servers.length;i++){
                String[] path = servers[i].split(":");
                JedisShardInfo si = new JedisShardInfo(path[0], Integer.parseInt(path[1]));
                //设置统一密码
                if(passWord!=null&&!"".equals(passWord)){
                    si.setPassword(passWord);
                }
                //si.setTimeout(timeout);
                shards.add(si);
            }
       }

        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        //TODO 需要设置连接池信息
        // 池对象  
        shardedJedisPool = new ShardedJedisPool(config, shards);
    }

    
    /**
     * 
     * Create on 2015年4月1日
     * @author: fengjj
     * @Title: set
     * @Description: 根据key放值
     * @param key
     * @param value
     * @version 1.0
     * update_data:     update_author:     update_note:
     */
    @Override
    public void set(String key, Object value) {
        if(jc!=null){
            jc.set(key,value.toString());
        }else{
            shardedJedis = shardedJedisPool.getResource();
            shardedJedis.set(key.getBytes(), SerializeUtil.serialize(value));
            shardedJedisPool.returnResource(shardedJedis);
        }
    }
    /**
     * 
     * Create on 2015年4月1日
     * @author: fengjj
     * @Title: set
     * @Description: 批量操作
     * @param map<key,value>
     * @param value
     * @version 1.0
     * update_data:     update_author:     update_note:
     */
    @Override
    public void set(Map<String,Object> map) {
        if(map==null||map.isEmpty()){
            return;
        }
        shardedJedis = shardedJedisPool.getResource();
        Set<String> set = map.keySet();
        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            String key = it.next();
            shardedJedis.set(key.getBytes(), SerializeUtil.serialize(map.get(key)));
        }
        shardedJedisPool.returnResource(shardedJedis);
    }

    /**
     * 
     * Create on 2015年4月1日
     * @author: fengjj
     * @Title: set
     * @Description: 设置过期时间
     * @param key
     * @param value
     * @param milliseconds
     * @version 1.0
     * update_data:     update_author:     update_note:
     */
    @Override
    public void set(String key, Object value, int milliseconds) {
        shardedJedis = shardedJedisPool.getResource();
        shardedJedis.set(key.getBytes(), SerializeUtil.serialize(value));
        shardedJedis.expire(key.getBytes(), milliseconds/1000);
        shardedJedisPool.returnResource(shardedJedis);
    }

    /**
     * 
     * Create on 2015年4月1日
     * @author: fengjj
     * @Title: remove
     * @Description: 根据key删除键值对映射
     * @param key
     * @version 1.0
     * update_data:     update_author:     update_note:
     */
    @Override
    public void remove(String key) {
        shardedJedis = shardedJedisPool.getResource();
        shardedJedis.del(key.getBytes());
        shardedJedisPool.returnResource(shardedJedis);
    }

    /**
     * 
     * Create on 2015年4月1日
     * @author: fengjj
     * @Title: removeAll
     * @Description: 删除所有数据库内所有映射
     * @version 1.0
     * update_data:     update_author:     update_note:
     */
    @Override
    public void removeAll() {
        log.info("********执行了清空所有库方法********");
        shardedJedis = shardedJedisPool.getResource();
        Collection<Jedis> cjs = shardedJedis.getAllShards();
        Iterator<Jedis> it = cjs.iterator();
        while(it.hasNext()){
            Jedis jedis = it.next();
            //jedis.flushDB();
            jedis.flushAll();
        }
        shardedJedisPool.returnResource(shardedJedis);
    }

    /**
     * 
     * Create on 2015年4月1日
     * @author: fengjj
     * @Title: update
     * @Description: 替换，如果不存在则不操作，存在即用新的值替换
     * @param key
     * @param value
     * @version 1.0
     * update_data:     update_author:     update_note:
     */
    @Override
    public void update(String key, Object value) {
        shardedJedis = shardedJedisPool.getResource();
        if(shardedJedis.exists(key.getBytes())){
            shardedJedis.set(key.getBytes(), SerializeUtil.serialize(value));
        }
        shardedJedisPool.returnResource(shardedJedis);
    }

    /**
     * 
     * Create on 2015年4月1日
     * @author: fengjj
     * @Title: get
     * @Description: 根据key获取值
     * @param key
     * @return
     * @version 1.0
     * update_data:     update_author:     update_note:
     */
    @Override
    public Object get(String key) {
        if(jc!=null){
            return jc.get(key);
        }else{
        shardedJedis = shardedJedisPool.getResource();
        Object str = SerializeUtil.unserialize(shardedJedis.get(key.getBytes()));
        shardedJedisPool.returnResource(shardedJedis);
        return str;
        }
    }

    /**
     * 
     * Create on 2015年4月1日
     * @author: fengjj
     * @Title: get
     * @Description: 批量获取key value 对应
     * @param keys
     * @return
     * @version 1.0
     * update_data:     update_author:     update_note:
     */
    @Override
    public Map<String, Object> get(String[] keys) {
        shardedJedis = shardedJedisPool.getResource();
        Map<String, Object> rmap = null;
        if(keys!=null){
            rmap = new HashMap<String, Object>();
            for(String key:keys){
                rmap.put(key, SerializeUtil.unserialize(shardedJedis.get(key.getBytes())));
            }
        }
        shardedJedisPool.returnResource(shardedJedis);
        return rmap;
    }

    /**
     * 
     * Create on 2015年4月1日
     * @author: fengjj
     * @Title: getAll
     * @Description: 此方法暂时不用
     * @return
     * @version 1.0
     * update_data:     update_author:     update_note:
     */
    @Override
    public Map<String, Object> getAll() {
        log.info("getAll 方法不给用~~~");
        return null;
    }
   
    ///////////////////////////////////////////////
    public static void main(String[] args) {
//        JedisUtil j = new JedisUtil();
//        j.shardedJedis = shardedJedisPool.getResource();
//        List list = new ArrayList();
//        list.add("hello");
//        j.shardedJedis.set("list".getBytes(), SerializeUtil.serialize(list));
//        byte[] b = j.shardedJedis.get("list".getBytes());
//        List o = (List)SerializeUtil.unserialize(b);
//        System.out.println(o.get(0));
        long l0 = new Date().getTime();
        Cache c1 =  CacheHelper.getInstance();
        System.out.println(c1.get("102400000|18600102891"));
        System.out.println(c1.get("102600000|18719410275"));
        System.out.println(c1.get("102600000|13000000000"));
        System.out.println(c1.get("102600000|18719410276"));
        for(int i = 1000;i>0;i--){
            //c1.set("abv:"+i, "abvvv"+i*5);
           // System.out.println(i+"abv1:::"+c1.get("abv:"+i));
            
        }
        long l1 = new Date().getTime();
        
        System.out.println("abv:::"+(l1-l0));
     }
}
