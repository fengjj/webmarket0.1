/**
 * 
 */
package com.sitech.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/** 
 * Create on 2015年5月11日 
 * @author: fengjj
 * @Title: Springfactory 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note: 
 */
public class Springfactory implements BeanFactoryAware {

    private static BeanFactory beanFactory;  
    /**
     * Create on 2015年5月11日
     * @author:fengjj
     * @Title: setBeanFactory
     * @Description: TODO 
     * @param arg0
     * @throws BeansException
     * @version 1.0
     * update_data:     update_author:     update_note:
     */
    @Override
    public void setBeanFactory(BeanFactory arg0) throws BeansException {
        // TODO Auto-generated method stub
        beanFactory = arg0;
    }

    /** 
     * 根据beanName名字取得bean 
     *  
     * @param beanName 
     * @return 
     */  
    public static <T> T getBean(String beanName) {  
        if (null != beanFactory) {  
            return (T) beanFactory.getBean(beanName);  
        }  
        return null;  
    }  
}
