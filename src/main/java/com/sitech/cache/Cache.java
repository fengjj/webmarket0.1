package com.sitech.cache;

import java.util.Map;
/**
 * Create on 2015年4月6日 
 * @author: fengjj
 * @Title: Cache 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface Cache {
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
  public void set(String key, Object value);
  /**
   * 
   * Create on 2015年4月6日
   * @author:fengjj
   * @Title: set
   * @Description: 设置缓存，无论key是否存在，设置缓存过期时间 
   * @param key
   * @param value
   * @param milliseconds
   * @version 1.0
   * update_data:     update_author:     update_note:
   */
public void set(String key, Object value, int milliseconds);
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
public void remove(String key);
/**
 * 
 * Create on 2015年4月6日
 * @author:fengjj
 * @Title: removeAll
 * @Description: 清空所有缓存数据 
 * @version 1.0
 * update_data:     update_author:     update_note:
 */
public void removeAll();
/**
 * 替换，如果不存在则不操作，存在即用新的值替换
 * Create on 2015年4月6日
 * @author:fengjj
 * @Title: update
 * @Description: 替换，如果不存在则不操作，存在即用新的值替换 
 * @param key
 * @param value
 * @version 1.0
 * update_data:     update_author:     update_note:
 */
public void update(String key, Object value);
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
public Object get(String key);
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
public Map<String,Object> get(String[] keys);
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
public Map<String,Object> getAll();
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
public void set(Map<String,Object> map);
}
