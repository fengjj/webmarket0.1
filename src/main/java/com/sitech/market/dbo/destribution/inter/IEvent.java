package com.sitech.market.dbo.destribution.inter;


import java.util.List;
import java.util.Map;

import com.sitech.jcfx.dt.MBean;

/**
 * @author tianyy_bj
 *
 * @date:2014-11-15 上午11:21:06
 * @version :1.0
 *
 */

public interface IEvent {

	
	
	/**
	 * 查询这个活动下的所有配置的元素
	 * mk_event_info插入多条数据
	 * @author fengjj
	 * @param map eventid
	 * @return
	 */
	public List<Map<String,String>> selectConductsById(Map<String,String> map);
    /**
     * mk_event_info插入多条数据
     * @author yueyue
     * @param list
     * @return
     */
    public boolean insertMkEventInfoList(List<Map> list);

    /**
     * mk_eventcontent_info插入多条数据
     * @author yueyue
     * @param list
     * @return
     */
    public boolean insertMkEventcontentInfoList(List<Map> list);

    /**
     * 删除mk_imgiterm_info中的数据by event_id
     * @author yueyue
     * @param bean
     * @return
     */
    public boolean deleteMkEventcontentInfoByEventid(MBean bean);

    /**
     * 删除mk_imgconnection_info中的数据by event_id
     * @author yueyue
     * @param bean
     * @return 
     */
    public boolean deleteMkEventInfoByEventid(MBean bean);
    
    /**
     * 插入mk_event_trac中的数据by event_id
     * @author nidw
     * @param bean
     * @return 
     */
    public boolean insertMkEventTracByEventid(MBean bean);
    
    /**
     * 更新mk_event_info中的事件状态
     * @author nidw
     * @param bean
     * @return 
     */
    public boolean updateMkEventInfoStatus(MBean bean);

    /**
     * 删除mk_imgiterm_info中的数据by act_id
     * @author yueyue
     * @param bean
     * @return
     */
    public boolean deleteMkImgitemInfoByActid(MBean bean);

    /**
     * 删除mk_imgconnection_info中的数据by act_id
     * @author yueyue
     * @param bean
     * @return
     */
    public boolean deleteMkImgconnectionInfoByActid(MBean bean);

    /**
     * mk_imgiterm_info插入多条数据
     * @author yueyue
     * @param list
     * @return
     */
    public boolean insertMkImgitermInfoList(List<Map> list);

    /**
     * mk_imgconnection_info插入多条数据
     * @author yueyue
     * @param list
     * @return
     */
    public boolean insertMkImgconnectinInfoList(List<Map> list);

    /**
     * 修改活动状态为待审批
     * @author yueyue
     * @param bean
     * @return
     */
    public boolean updateMkEventInfo(MBean bean);

    /**
     * 将提交审批的信息插入审批结果表
     * @author yueyue
     * @param bean
     * @return
     */
    public boolean insertMkAuditInfo(MBean bean);

    /**
     * 查询语句
     * select item.item_id,item.item_type,item.item_aid,item.act_id,item.item_x,item.item_y,item.isfilled,
     * item.isconnected,item.bak1,item.bak2,ele.actconduct_name,ele.image_path 
     * from mk_imgitem_info item, mk_actconduct_dict ele where item.item_aid = ele.actconduct_id(+) and item.item_type = ele.comp_type(+)
     * and item.partent_type = '03' and item.act_id = ? order by item.item_id
     * @author yueyue
     * @param bean
     * @return
     */
    public List<Map> queryImgItemListByActid(MBean bean);

    /**
     *查询语句
     * select act_id,from_id,to_id,orderid from mk_imgconnection_info where partent_type = '03' and act_id = ? order by orderid desc
     * @author yueyue
     * @param bean
     * @return
     */
    public List<Map> queryMkImgconnectionInfoListByActid(MBean bean);

    /**
     * 查询语句
     * select t.actconduct_id,t.actconduct_par_id,b.parameter_name,t.actconduct_par_value,a.event_name,a.start_date,a.end_date,a.busi_type,a.event_desc from mk_eventcontent_info t,mk_actconductpar_dict b,mk_event_info a 
     * where t.actconduct_par_id = b.parameter_id and t.event_id = a.event_id and  t.event_id=? order by t.actconduct_id, t.batch_no
     * @param bean
     * @return
     */
    public List<Map> queryImgContentListActid(MBean bean);

    /**
     * 查询语句
     * select distinct t.action_id,t.conduct_id,t.event_name,t.status_code,t.batch_no  from mk_event_info  t where t.event_id=? order by t.batch_no asc
     * @author yueyue
     * @param bean
     * @return
     */
    public List<Map> queryMkEventInfoList(MBean bean);

    /**
     * 查询语句
     *@author yueyue
     * select actconduct_name from mk_actconduct_dict  where actconduct_id = ?
     * @param bean
     * @return
     */
    public Map queryMkActconductName(MBean bean);

    /**
     * 查询语句
     * select a.actconduct_par_value,b.parameter_name from mk_eventcontent_info a,mk_actconductpar_dict b
     *  where a.actconduct_par_id =b.parameter_id  and  a.event_id=? 
     *  and a.actconduct_id =?   and  b.province_group=?
     * @author yueyue
     * @param bean
     * @return
     */
    public List<Map> queryActConductContentList(MBean bean);

    /**
     * 查询语句
     * @author yueyue
     * select field_value,field_desc from mk_codename_dict where table_en_name='mk_eventtype_dict'  and province_group = ? order by field_value
     * @param bean
     * @return
     */
    public List<Map> queryMkEventtypeDict(MBean bean);

    /**
     * 查询语句
     * @author yueyue
     * select comp_type,permission_type,actconduct_type,data_type,actconduct_id from mk_actconduct_dict order by comp_type,actconduct_id
     * @param bean
     * @return
     */
    public List<Map> queryPermissionForList();

    /**
     * 查询语句
     * @author yueyue
     * select actconduct_id,parameter_id from mk_actconductpar_dict  order by actconduct_id,parameter_id
     * @return
     */
    public List<Map> queryPermissionparList();

    /**
     * 查询语句
     * select field_value,field_desc from mk_codename_dict t where table_en_name='mk_msgtype_dict' and province_group = ? order by field_value
     * @author yueyue
     */
    public List queryMsgType(MBean bean);

    /**
     * 查询动作行为
     * @author yueyue
     * @param bean
     * @return
     */
    public List queryActConductForList(MBean bean);

    /**
     * 查询语句：
     * select b.actconduct_id,b.actconduct_name,a.parameter_id,a.parameter_name,a.classname 
     * from mk_actconductpar_dict a,mk_actconduct_dict b where a.actconduct_id = b.actconduct_id order  by b.actconduct_id,a.parameter_id
     * @author yueyue
     * @param bean
     * @return
     */
    public List queryActConductParForList();

    /**
     * 查询mk_event_info by id
     * @param bean
     * @return
     */
    public Map queryEventInfoByid(MBean bean);

    /**
     * 根据主键ID修改事件基本信息
     *  Create on 2014-07-31
     * @author yugl_bj
     * @version 1.0 
     * Copyright(c) 北京思特奇信息技术股份有限公司 
     * 功能描述：修改事件基本信息 
     * 修改日期: 修改人: 修改目的:
     */
    public MBean updateMkEventInfoById(MBean bean);
    
    /**
     * 查询事件码表数据
     * 
     * @param bean
     * @return List
     * @author jiaxla  2014-12-17
     */
    public List queryType(Map para);
    
    /**
     * 查询资费信息
     * @param para
     * @return
     * @author jiaxla  2014-12-29
     */
    public List queryPrcFeeList(String para);

    /**
     * 查询事件信息
     * @param para
     * @return
     * @author nidw  2014-12-30
     */
    public List queryEvent(String busiId);
    /** 
     * 删除审批结果中待审批的数据
     *  Create on 2014-10-11 上午11:28:54
     * @author tianyy_bj
     * @version 1.0
     * Copyright(c) 北京思特奇信息技术股份有限公司
     * @param deleteMap
     * void
     * 功能描述：
     * 修改日期:     修改人:     修改目的:
     */
	public void deleteMkAuditResultInfo(Map deleteMap);
    /**
     * 查询事件基本信息
     * 
     * @param eventId
     * @return Map
     * @author jiaxla  2014-12-17
     */
    public Map<String,String> queryEventBasicById(String eventId);
    /**
     * 
     * 功能描述：获得某省某地市某个等级的审批人信息
     * @author shangjun
     * Create on 2015-1-28
     * @param province_center
     * @param regionCode
     * @param audit_level
     * @return
     * Copyright(c) 北京思特奇信息技术股份有限公司
     */
	public Map getAuditInfo(String province_center, String regionCode,
			String audit_level);
	/**
	 * 
	 * 功能描述：获取最大序列的审批结果信息
	 * @author shangjun
	 * Create on 2015-1-29
	 * @param busiId
	 * @param busiType
	 * @return
	 * Copyright(c) 北京思特奇信息技术股份有限公司
	 */
	public Map getAuditResultInfo(String busiId, String busiType);
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
	public List queryEventInfo(Map sourceMap);
	/**
     * 
     * @Description: 视图保存推荐活动基本信息
     * @param @param inparam
     * @param @return   
     * @return OutDTO  
     * @throws
     * @author yangrc
     * @date August 12, 2015
     * @version V1.0
     * 修改时间    修改人    实现功能
     */
	public List updateMkEventcontentInfoOfParvalue(MBean bean);
	public List<Map<String,String>> selectMkEventcontentInfoById(Map bean);
	/**
	 * 查询结果总数和实时平均数
	 * @param eventId
	 * @return
	 */
	public String queryDataCount(String eventId);
	public String queryAllDataById(String eventId);
	public String queryPreDataById(String eventId);
	public List<Map> queryUsedDataGroupByPhoneNo(Map map);
	public List<Map> queryUsedDataTrac(Map map);
	public Integer selectMaxTargetValue();
	public void insertTargetValue(Map<String, Object> inMap);
}