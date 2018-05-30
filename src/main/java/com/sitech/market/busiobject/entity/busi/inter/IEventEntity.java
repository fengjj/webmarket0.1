package com.sitech.market.busiobject.entity.busi.inter;


import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sitech.jcfx.dt.MBean;

/**
 * @author tianyy_bj
 *
 * @date:2014-11-15 下午4:52:16
 * @version :1.0
 *
 */

public interface IEventEntity {

    /**
     * 图形化页面初始化
     * @author yueyue
     * @param bean
     * @return
     */
    public  MBean saveInit(MBean bean);
    /**
     * 保存定义事件--合并saveInit+SaveImageGraph
     * @author Jon
     * @param bean
     * @return
     */
    public  MBean saveEventDefine(MBean bean);
    /**
     * 保存地址信息
     * @param bean
     * @return
     */
    public Boolean insertMkMylacciInfo(MBean bean);
    public  Object insertMkEventmonitorInfo(MBean bean);
    public  MBean queryMonitorGBetype(MBean bean);
    public  MBean queryMonitorGBtopic(MBean bean);
    public  MBean queryMonitorGBeventId(MBean bean);
    public  MBean getEventData(MBean bean);
    public  MBean getUsedData(MBean bean);

    /**
     * 图形化页面修改
     * (事件状态编码为00（新建）、03（退回）可修改)
     * @author yueyue
     * @param bean
     * @return
     */
    public  MBean udateInit(MBean bean);

    /**
     * 展示事件基本信息
     *（ 事件状态编码不为00或03不可修改）
     * @param bean
     * @return
     */
    public  MBean showView(MBean bean);

    /**
     * 保存图形化界面中的数据
     * @author yueyue
     */
    public  MBean saveImageGraph(MBean bean);
    
    /**
     * 保存推荐活动基本信息
     * @author yangrc
     */
    public  MBean saveRecommendActInfo(MBean bean);

    /**
     * 删除事件
     * @author yueyue
     */
    public  MBean deleteEvent(MBean bean);
    
    /**
     * 更新事件状态
     * @author nidw
     */
    public  MBean updateEvent(MBean bean);

    /**
     * 保存节点和连线
     * @author yueyue
     */
    public  void saveImgContent(MBean bean);

    /**
     * 保存提交审批人信息
     * @author yueyue
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
    public  MBean saveAudit(MBean bean);

    /**
     * 获得指定活动的图形化信息
     * @author yueyue
     * @param actId
     * @return
     */
    public  List[] queryImgContent(String serialNo);

    /**
     * 活动动作行为List
     * @author yueyue
     */
    public  List queryActConduct(String busiId);

    /**
     * 获得行为属性
     * @author yueyue
     */
    public  List queryActConductContent(String busiId,
            String actioncondId, String batchNo, String provinceCode);

    /**
     * 返回行为名称
     * @author yueyue
     * @param actconductId
     * @return
     */
    public  String queryActConductName(String actconductId);

    /**
     * 活动事件类型
     * @author yueyue
     */
    public  List queryEventType(String provinceCode);

    /**
     * 返回事件类型列表
     * @author yueyue
     */
    public  MBean getEventTypeList(MBean bean);

    /**
     * 获得短信类型
     * @author yueyue
     */
    public  List queryMsgType(String provinceCode);

    /**
     * 返回短信类型列表
     * @author yueyue
     */
    public  MBean getMsgTypeList(MBean bean);

    /**
     * 查询动作行为
     * @author yueyue
     * @param type
     * @return
     */
    public  List<Map> queryActConductList(String type);

    /**
     * 查询动作行为属性
     * @author yueyue
     * @return
     */
    public  List queryActConductParList();

    /**
     * 查询限制类型
     * @author yueyue
     * @param 
     * @return
     */
    public  List<Map> queryPermissionList();
    
    /**
     *	查询资费信息
     *
     * @return
     * @author jiaxla  2014-12-29
     */
    public  MBean getLoadFee(MBean bean);
    /**
     *	重置推荐次数
     *
     * @return
     * @author jiaxla  2014-12-29
     */
    public  MBean resetTime(MBean bean);
    /**
     * 功能描述：初始化事件提交审批的审批人
     * @author shangjun
     * Create on 2015-1-28
     * @param bean
     * @return
     * Copyright(c) 北京思特奇信息技术股份有限公司
     */
    public  MBean initAudit(MBean bean);
    /**
     * 
     * 功能描述：审批中获取事件的下一步审批人
     * @author shangjun
     * Create on 2015-1-29
     * @param bean
     * @return
     * Copyright(c) 北京思特奇信息技术股份有限公司
     */
	public  MBean initEventAudit(MBean bean);
    /**
     *	事件测试 发送消息
     *
     * @return
     * @author jiaxla  2014-12-29
     */
	public  MBean sendKafkaMsg(MBean bean);
	/**
	 *	设置事件推荐总次数
	 *
	 * @return
	 * @author jiaxla  2014-12-29
	 */
	public  MBean setTotalTime(MBean bean);
	/**
	 *	查询推荐总次数
	 *
	 * @return
	 * @author jiaxla  2014-12-29
	 */
	public  MBean gotoTotalTime(MBean bean);
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
	public  MBean queryEventInfo(MBean bean);
	public MBean getUsedDataTrac(MBean bean);

	/**
	 * 发布活动后返回活动类型和目标客户群
	 * @param bean
	 * @return
	 */
	public MBean publishEvent(MBean bean);

	String getMaxTargetValue();

}