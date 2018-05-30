package com.sitech.market.dbo.destribution.inter;


import com.sitech.jcfx.dt.MBean;

/**
 * @author tianyy_bj
 *
 * @date:2014-11-15 上午11:21:06
 * @version :1.0
 *
 */

public interface IEventNosql {

    /**
     * 设置月最大次数限制
     * @author jiaxla
     * @param MBean
     * @return
     */
    public String setTotalTimeM(MBean m);
    /**
     * 设置日最大次数限制
     * @author jiaxla
     * @param MBean
     * @return
     */
    public String setTotalTimeD(MBean m);
    /**
     * 事件重置次数
     * 
     * @param bean
     * @return List
     * @author jiaxla  2014-12-17
     */
    public String resetTime(String phoneNo,String statusCode);
    /**
     * 查询日最大限制
     * 
     * @param bean
     * @return List
     * @author jiaxla  2014-12-17
     */
    public String getTotalTimeD(MBean m);
    /**
     * 查询月最大限制
     * 
     * @param bean
     * @return List
     * @author jiaxla  2014-12-17
     */
    public String getTotalTimeM(MBean m);
    /**
     * 
     * @Description: 查询类型对应的事件推荐信息
     * @param @param eventType
     * @param @return   
     * @return String  
     * @throws
     * @author zhaiwt
     * @date Mar 31, 2015
     * @version V1.0
     * 修改时间    修改人    实现功能
     */
    public String queryEventType(String eventType);
    /**
     * 
     * @Description: 获取事件推荐的活动的办理量
     * @param @param retEventId
     * @param @return   
     * @return String  
     * @throws
     * @author zhaiwt
     * @date Jun 17, 2015
     * @version V1.0
     * 修改时间    修改人    实现功能   涉及起始代码行数   涉及结束代码行数
     */
	public String queryActRecordCount(String retEventId);
}