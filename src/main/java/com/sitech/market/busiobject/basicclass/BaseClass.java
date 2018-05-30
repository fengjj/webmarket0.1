package com.sitech.market.busiobject.basicclass;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sitech.util.ErrorUtil;

/**
 * java基类，实现了对日志打印的变量定义，所有类必须继承
 * 增加了异常处理工具类
 * Create on 2014-10-25
 * @author sunliang
 */
public class BaseClass{
	
	protected Log log = LogFactory.getLog(BaseClass.class);
	protected BaseClass(){
		log = LogFactory.getLog(this.getClass());
    }
	protected ErrorUtil errorUtil = new ErrorUtil();

}
