package com.sitech.market.busiobject.basicclass.dbclass;

import com.sitech.market.busiobject.basicclass.BaseClass;
import com.sitech.util.CassandraUtil;
import com.sitech.util.ConfigBeanFactory;

/**
 * 数据处理基类，实现了对cassandraDao的定义
 * Create on 2014-10-25
 * @author sunliang
 */
public class DBNosqlClass extends BaseClass {
	protected CassandraUtil cassandraDao = (CassandraUtil) ConfigBeanFactory.getBean("cassandraUtil");
}
