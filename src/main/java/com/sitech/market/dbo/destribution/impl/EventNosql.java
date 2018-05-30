package com.sitech.market.dbo.destribution.impl;


import java.util.Date;

import com.alibaba.fastjson.JSONObject;
import com.sitech.jcf.core.exception.BusiException;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dbclass.DBNosqlClass;
import com.sitech.market.dbo.destribution.inter.IEventNosql;
import com.sitech.util.Const;
import com.sitech.util.SitechDateUtil;

public class EventNosql extends DBNosqlClass implements IEventNosql {

	@Override
	public String setTotalTimeM(MBean m) {
		String totalTimeM = m.getBodyStr("totalTimeM");
		String rowkey ="ALL|26|04";
		String colum_name="order_num";
		cassandraDao.insertSingleColumnAndSingleRow("mk_busiordernum_info", rowkey, colum_name, totalTimeM);
		return "SUCCESS";
	}
	@Override
	public String setTotalTimeD(MBean m) {
		String totalTimeD = m.getBodyStr("totalTimeD");
		String rowkey ="ALL|26|04";
		String colum_name="order_num";
		cassandraDao.insertSingleColumnAndSingleRow("mk_busiordernum_info", rowkey, colum_name, totalTimeD);
		return "SUCCESS";
	}
	  /**
     * 重置推荐次数
     * @param bean
     * @return
     * @author jiaxla  2014-12-17
     */
	@Override
	public String resetTime(String phoneNo, String statusCode) {
		String id_no = cassandraDao.getSingleByKeyAndColumnName("mk_phone_info", phoneNo, "id_no");
		String rowkey = null;
		String colum_name= null;
		String ret = "SUCCESS";
		if(null != id_no && !"".equals(id_no)){
			//短信夹带
			if("00".equals(statusCode)){
				rowkey =id_no+Const.nosql_split+Const.ID_TYPE_USER+Const.nosql_split+Const.ORDER_FLAG_EVENT;
				colum_name ="00"+Const.nosql_split+Const.EVENT+Const.nosql_split+"0";
			//流量提醒	
			}else if ("04".equals(statusCode)){
				rowkey =id_no+Const.nosql_split+Const.ID_TYPE_USER+Const.nosql_split+Const.ORDER_FLAG_EVENT;
				colum_name ="04"+Const.nosql_split+Const.EVENT+Const.nosql_split+"0";
			//签到	
			}else if ("05".equals(statusCode)){
				rowkey =id_no+Const.nosql_split+Const.ID_TYPE_USER+Const.nosql_split+Const.ORDER_FLAG_EVENT;
				colum_name ="05"+Const.nosql_split+Const.EVENT+Const.nosql_split+"0";
			//排行	
			}else if ("06".equals(statusCode)){
				rowkey =id_no+Const.nosql_split+Const.ID_TYPE_USER+Const.nosql_split+Const.ORDER_FLAG_EVENT;
				colum_name ="06"+Const.nosql_split+Const.EVENT+Const.nosql_split+"0";
			//缴费	
			}else if ("07".equals(statusCode)){
				rowkey =id_no+Const.nosql_split+Const.ID_TYPE_USER+Const.nosql_split+Const.ORDER_FLAG_EVENT;
				colum_name ="07"+Const.nosql_split+Const.EVENT+Const.nosql_split+"0";
			//产品订购	
			}else if ("08".equals(statusCode)){
				rowkey =id_no+Const.nosql_split+Const.ID_TYPE_USER+Const.nosql_split+Const.ORDER_FLAG_EVENT;
				colum_name ="08"+Const.nosql_split+Const.EVENT+Const.nosql_split+"0";
			//终端订购
			}else if ("09".equals(statusCode)){	
				rowkey =id_no+Const.nosql_split+Const.ID_TYPE_USER+Const.nosql_split+Const.ORDER_FLAG_EVENT;
				colum_name ="09"+Const.nosql_split+Const.EVENT+Const.nosql_split+"0";
			//精准推荐
			}else if ("10".equals(statusCode)){	
				rowkey =id_no+Const.nosql_split+Const.ID_TYPE_USER+Const.nosql_split+Const.ORDER_FLAG_EVENT;
				colum_name ="10"+Const.nosql_split+Const.EVENT+Const.nosql_split+"0";
			}
			cassandraDao.insertSingleColumnAndSingleRow("mk_userordernum_info",rowkey ,colum_name, "0");
		}else{
			ret= "次数重置失败,手机号对应ID_NO为空";
		}
		return ret;
	}
	@Override
	public String getTotalTimeD(MBean m) {
		String colum_name=SitechDateUtil.getFormatDateString(new Date(), "yyyyMMdd");
		return cassandraDao.getSingleByKeyAndColumnName("mk_busiordernum_info", "ALL|26|04", colum_name);
		
	}
	@Override
	public String getTotalTimeM(MBean m) {
		String colum_name="order_num";
		return cassandraDao.getSingleByKeyAndColumnName("mk_busiordernum_info", "ALL|26|04",colum_name);
	}
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
	@Override
	public String queryEventType(String eventType) {
		String retStr = null;
		try{
			JSONObject json = cassandraDao.queryCounter_by_key("mk_eventcounter_info", eventType.trim());
			if(null != json && json.size() > 0){
				retStr = json.getString(eventType.trim());
			}
		}catch(Exception e){
			e.printStackTrace();
			String returnCode = errorUtil.getErrorCode("4542", Const.errcode_dberr,Const.errtype_systemerror);
			throw new BusiException(returnCode,"数据库操作错误","queryEventType");
		}
		return retStr;
	}
	
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
	@Override
	public String queryActRecordCount(String retEventId) {
		String retStr = null;
		try{
			String key = retEventId+Const.nosql_split_0+Const.EVENT+Const.nosql_split_0+Const.STATIC_NUM_4;
			JSONObject json = cassandraDao.query_by_key("mk_busiordernum_info", key);
			if(null != json && json.size() > 0){
				retStr = json.getString(key);
			}
		}catch(Exception e){
			e.printStackTrace();
			String returnCode = errorUtil.getErrorCode("4542", Const.errcode_dberr,Const.errtype_systemerror);
			throw new BusiException(returnCode,"数据库操作错误","queryActRecordCount");
		}
		return retStr;
	}
}
