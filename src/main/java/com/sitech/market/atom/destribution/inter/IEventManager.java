package com.sitech.market.atom.destribution.inter;

import com.sitech.jcfx.dt.in.InDTO;
import com.sitech.jcfx.dt.out.OutDTO;

/**
 * @author tianyy_bj
 *
 * @date:2014-11-15 下午4:46:04
 * @version :1.0
 *
 */

public interface IEventManager {

    /**
     * 发布事件
     * @author fengjj
     * @param bean
     * @return
     */
    public OutDTO publishEvent(InDTO inparam);
    /**
     * 图形化页面初始化
     * @author yueyue
     * @param bean
     * @return
     */
    public OutDTO saveInit(InDTO inparam);
    /**
     * 保存事件定义
     * @param inparam
     * @return
     */
    public OutDTO saveEventDefine(InDTO inparam);

    /**
     * 保存图形化界面中的数据
     * @author yueyue
     */
    public OutDTO saveImageGraph(InDTO inparam);
    /**
     * 保存图形化界面中的数据
     * @author fengjj
     */
    public OutDTO insertMkEventmonitorInfo(InDTO inparam);
    public OutDTO queryMonitorGBetype(InDTO inparam);
    public OutDTO queryMonitorGBtopic(InDTO inparam);
    public OutDTO queryMonitorGBeventId(InDTO inparam);
    public OutDTO getEventData(InDTO inparam);
    /**
     * 保存图形化界面中的数据
     * @author fengjj
     */
    public OutDTO getUsedData(InDTO inparam);
    
    public OutDTO getUsedDataTrac(InDTO inparam);
    /**
     * 保存推荐活动基本信息
     * @author yangrc
     */
    public OutDTO saveRecommendActInfo(InDTO inparam);
    
    /**
     * 删除事件
     * @author yueyue
     */
    public OutDTO deleteEvent(InDTO inparam);
    
    /**
     * 更新事件状态
     * @author nidw
     */
    public OutDTO updateEvent(InDTO inparam);

    /**
     * 保存提交审批人信息
     * @author yueyue
     */
    public OutDTO saveAudit(InDTO inparam);


    /**
     * 返回事件类型列表
     * @author yueyue
     */
    public OutDTO getEventTypeList(InDTO inparam);

    /**
     * 返回短信类型列表
     * @author yueyue
     */
    public OutDTO getMsgTypeList(InDTO inparam);
    /**
     * 
    	* 
    	*  Create on 2014-11-15 下午5:23:55
    	* @author tianyy_bj
    	* @version 1.0
    	* Copyright(c) 北京思特奇信息技术股份有限公司
    	* 功能描述：
    	* 修改日期:     修改人:     修改目的:
     */
    public OutDTO udateInit(InDTO inparam);
    /**
     * 
    	* 
    	*  Create on 2014-11-15 下午5:24:57
    	* @author tianyy_bj
    	* @version 1.0
    	* Copyright(c) 北京思特奇信息技术股份有限公司
    	* 功能描述：
    	* 修改日期:     修改人:     修改目的:
     */
    public OutDTO showView(InDTO inparam);
    /**
     * 获取资费信息
     * @param inparam
     * @return
     * @author jiaxla  2014-12-29
     */
    public OutDTO getLoadFee(InDTO inparam);
    /**
     * 推荐次数重置
     * @param inparam
     * @return
     * @author jiaxla  2014-12-29
     */
    public OutDTO resetTime(InDTO inparam);
    /**
     * 推荐次数重置
     * @param inparam
     * @return
     * @author jiaxla  2014-12-29
     */
    public OutDTO sendKafkaMsg(InDTO inparam);
    /**
     * 
     * 功能描述：初始化提交审批人
     * @author shangjun
     * Create on 2015-1-28
     * @param inparam
     * @return
     * Copyright(c) 北京思特奇信息技术股份有限公司
     */
    public OutDTO initAudit(InDTO inparam);
    /**
     * 
     * 功能描述：审批中获取事件的下一步审批人
     * @author shangjun
     * Create on 2015-1-29
     * @param inparam
     * @return
     * Copyright(c) 北京思特奇信息技术股份有限公司
     */
    public OutDTO initEventAudit(InDTO inparam);
    /**
     * 设置推荐总次数
     * @param inparam
     * @return
     * @author jiaxla  2014-12-29
     */
    public OutDTO setTotalTime(InDTO inparam);
    /**
     * 查询推荐总次数
     * @param inparam
     * @return
     * @author jiaxla  2014-12-29
     */
    public OutDTO gotoTotalTime(InDTO inparam);
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
    public OutDTO queryEventInfo(InDTO inparam);
	public OutDTO getMaxTargetValue(InDTO inparam);
	public OutDTO saveLaccis(InDTO inparam);
}