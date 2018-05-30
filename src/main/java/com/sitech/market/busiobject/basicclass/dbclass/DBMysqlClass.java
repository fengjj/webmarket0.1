package com.sitech.market.busiobject.basicclass.dbclass;

import com.sitech.cache.Cache;
import com.sitech.cache.CacheHelper;
import com.sitech.jcf.core.dao.IBaseDao;
import com.sitech.market.busiobject.basicclass.BaseClass;

/**
 * 数据处理基类，实现了对baseDao的定义
 * Create on 2014-10-25
 * @author sunliang
 */
public class DBMysqlClass extends BaseClass {
    protected Cache cache = CacheHelper.getInstance();
    protected IBaseDao baseDao;
	public void setBaseDao(IBaseDao dao){
        this.baseDao = dao;
    }
}
