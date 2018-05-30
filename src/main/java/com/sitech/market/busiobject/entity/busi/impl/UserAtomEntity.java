package com.sitech.market.busiobject.entity.busi.impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSONObject;
import com.sitech.jcf.core.exception.BaseException;
import com.sitech.jcf.core.exception.BusiException;
import com.sitech.market.busiobject.basicclass.busientity.BusiEntity;
import com.sitech.market.busiobject.entity.busi.inter.IUserAtomEntity;
import com.sitech.market.dbo.common.inter.IMkChngroupDict;
import com.sitech.market.dbo.contact.inter.IMkPhoneInfo;
import com.sitech.market.dbo.contact.inter.IMkUserInfo;
import com.sitech.market.dbo.destribution.inter.IMkBusiordernumInfo;
import com.sitech.market.dbo.trading.inter.IMkActcustInfo;
import com.sitech.market.dbo.trading.inter.IMkActrecordInfo;
import com.sitech.market.dbo.trading.inter.IMkActrecordtermiInfo;
import com.sitech.market.dbo.trading.inter.IMkCustInfo;
import com.sitech.market.dbo.trading.inter.IMkCustPhoneInfo;
import com.sitech.market.dbo.trading.inter.IMkIndextoqueryIdx;
import com.sitech.market.dbo.trading.inter.IMkRulecodeDict;
import com.sitech.market.dbo.trading.inter.IMkUseraccountoutInfo;
import com.sitech.market.dbo.trading.inter.IMkUserdatauseInfo;
import com.sitech.market.dbo.trading.inter.IMkUsergroupmbrInfo;
import com.sitech.market.dbo.trading.inter.IMkUserordernumInfo;
import com.sitech.market.dbo.trading.inter.IMkUserprodInfo;
import com.sitech.util.CommonUtil;
import com.sitech.util.Const;
import com.sitech.util.ParamUtil;

/**用户实体实现
 * create on 2014-11-05
 * @author sunliang
 */
@SuppressWarnings("all")
public class UserAtomEntity extends BusiEntity implements IUserAtomEntity {
    private IMkPhoneInfo mpi;
    private IMkIndextoqueryIdx miqi;
    private IMkUserordernumInfo uoi;
    private IMkUserInfo mkUserInfo;
    private IMkChngroupDict mkChngroupDict;
    private IMkRulecodeDict mkRuleCodeDict;
    private IMkUserprodInfo mkUserprodInfo;
    private IMkActrecordInfo mkActrecordInfo;
    private IMkCustInfo mkCustInfo;
    private IMkBusiordernumInfo mkBusiordernum;
    private IMkUserdatauseInfo  mkUserdatauseInfo;
    private IMkUsergroupmbrInfo mkUsergroupmbrInfo;
    private IMkUseraccountoutInfo mkUseraccountoutInfo;
    private IMkActrecordtermiInfo mkActrecordtermiInfo;
    private IMkActcustInfo mkActcustInfo;
    private IMkCustPhoneInfo mkCustPhoneInfo;
    
	public IMkActcustInfo getMkActcustInfo() {
		return mkActcustInfo;
	}
	public void setMkActcustInfo(IMkActcustInfo mkActcustInfo) {
		this.mkActcustInfo = mkActcustInfo;
	}
	public IMkActrecordtermiInfo getMkActrecordtermiInfo() {
		return mkActrecordtermiInfo;
	}
	public void setMkActrecordtermiInfo(IMkActrecordtermiInfo mkActrecordtermiInfo) {
		this.mkActrecordtermiInfo = mkActrecordtermiInfo;
	}
	public IMkUseraccountoutInfo getMkUseraccountoutInfo() {
		return mkUseraccountoutInfo;
	}
	public void setMkUseraccountoutInfo(IMkUseraccountoutInfo mkUseraccountoutInfo) {
		this.mkUseraccountoutInfo = mkUseraccountoutInfo;
	}
	public IMkUsergroupmbrInfo getMkUsergroupmbrInfo() {
		return mkUsergroupmbrInfo;
	}
	public void setMkUsergroupmbrInfo(IMkUsergroupmbrInfo mkUsergroupmbrInfo) {
		this.mkUsergroupmbrInfo = mkUsergroupmbrInfo;
	}
	public IMkUserdatauseInfo getMkUserdatauseInfo() {
		return mkUserdatauseInfo;
	}
	public void setMkUserdatauseInfo(IMkUserdatauseInfo mkUserdatauseInfo) {
		this.mkUserdatauseInfo = mkUserdatauseInfo;
	}
	public void setMpi(IMkPhoneInfo mpi) {
        this.mpi = mpi;
    }
    public void setMiqi(IMkIndextoqueryIdx miqi) {
        this.miqi = miqi;
    }
    public void setUoi(IMkUserordernumInfo uoi) {
		this.uoi = uoi;
	}
	public void setMkUserInfo(IMkUserInfo mkUserInfo) {
		this.mkUserInfo = mkUserInfo;
	}
	public void setMkChngroupDict(IMkChngroupDict mkChngroupDict) {
		this.mkChngroupDict = mkChngroupDict;
	}
	public void setMkRuleCodeDict(IMkRulecodeDict mkRuleCodeDict) {
		this.mkRuleCodeDict = mkRuleCodeDict;
	}
	public void setMkUserprodInfo(IMkUserprodInfo mkUserprodInfo) {
		this.mkUserprodInfo = mkUserprodInfo;
	}
	public void setMkActrecordInfo(IMkActrecordInfo mkActrecordInfo) {
		this.mkActrecordInfo = mkActrecordInfo;
	}
	public void setMkCustInfo(IMkCustInfo mkCustInfo) {
		this.mkCustInfo = mkCustInfo;
	}
	
	public void setMkBusiordernum(IMkBusiordernumInfo mkBusiordernum) {
		this.mkBusiordernum = mkBusiordernum;
	}
	
	public IMkCustPhoneInfo getMkCustPhoneInfo() {
		return mkCustPhoneInfo;
	}
	public void setMkCustPhoneInfo(IMkCustPhoneInfo mkCustPhoneInfo) {
		this.mkCustPhoneInfo = mkCustPhoneInfo;
	}
	/**通过phone_no查出id_no
	 * create on 2014-11-05
	 * @author sunliang
	 */
	@Override
	public String getIdNoByPhoneNo(String phoneNo) {
		String idNo = null;
		idNo = mpi.getIdNoByPhoneNo(phoneNo);
		if(null == idNo || "".equals(idNo)){
  			String returnCode = errorUtil.getErrorCode(Const.opCodeYXZX, Const.errcode_dberr);
			throw new BusiException(returnCode,"亲,查询用户ID出问题了!","UserEntity.getIdNoByPhoneNo错误");
		}
		return idNo;
	}
	
	public void isPhoneNoExist(List phoneList){
		mpi.getIdNoByPhoneNos(phoneList);
	}
	
	
	/**
     * 查询某个用户所属的所有目标客户群
     * Create on 2014-10-29
     * @author yugl_bj 
     * @version 1.0
     * Copyright(c) 北京思特奇信息技术股份有限公司
     * 修改日期:     修改人:     修改目的:
     */
	@Override
	public Map getCustGroupIdByUser(String idNo) {
		
		Map<String,String> returnMap = new HashMap<String,String>();
		if(idNo==null || "".equals(idNo.trim())){
			throw new BusiException("-2","亲,查询用户ID出问题了!","UserEntity.getCustGroupIdByUser错误");
		}
		String queryType = Const.nosql_index_type_idno;
		String tableId = Const.mk_actcust_info;
		String queryValue = idNo;
	//	JSONObject custGroupIdObj = miqi.queryIndexByRowkey(queryType, tableId, queryValue);
	//	Set set = custGroupIdObj.keySet();
		String custGroupId = null;
	//	for(Object object:set){
	//		custGroupId = (String)object;
	//		if(!returnMap.containsKey(custGroupId)){
	//			returnMap.put(custGroupId, custGroupId);
	//		}
	//	}
		JSONObject json = mkActcustInfo.queryMkActcustInfo(idNo);
		JSONObject record = json.getJSONObject(idNo);
		if(record != null && record.size() > 0){
			Iterator iterator = record.keySet().iterator();
			while(iterator.hasNext()){
				custGroupId = iterator.next() + "";
				returnMap.put(custGroupId, custGroupId);
			}
		}
		log.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~returnMap~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+returnMap);
		return returnMap;
	}
	
	/**
	 * Create on 2015-4-13 
	 * @author: yugl
	 * @Title: getOrderInfoByUser 
	 * @Description: 查询某个用户的活动订购属性（已订购次数、灰名单标识等信息）
	 * @param rowKey:idno|idtype|orderflag
	 * @param busiType
	 * @param attrFlag
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List getOrderInfoByUser(String rowKey,String busiType) {
		//attrFlag=0查询订购次数，1查询灰名单，all两种属性都查
		JSONObject tableJson = null;
		List attrList = new ArrayList();
		List retList = new ArrayList();
		try{
			//查询bp
			tableJson = uoi.queryUserordernumByIdNo(rowKey);
			//获取rowkey下级的json
			JSONObject rowKeyJson = JSONObject.parseObject(tableJson.getString(rowKey));
			long t1 = System.currentTimeMillis();
			if(null != rowKeyJson){
				//对json里的key进行遍历
				Set set = rowKeyJson.keySet();
				for(Object columnNameObj:set){
					String columnName = (String) columnNameObj;//columnName字符串格式：busiId|busiType|attrFlag
					String columnValue = rowKeyJson.getString(columnName);
					String[] keyArr = columnName.split(Const.nosql_split_1);
					if(keyArr==null || keyArr.length==0){
						continue;
					}
					Map map = new HashMap();
					String keyName = "attrValue";
					/*if(Const.mk_userordernum_num_flag.equals(keyArr[2]) && Const.mk_userordernum_num_flag.equals(attrFlag)){
						keyName = "orderNum";
					}else if(Const.mk_userordernum_grey_flag.equals(keyArr[2]) && Const.mk_userordernum_grey_flag.equals(attrFlag)){
						keyName = "greyFlag";
					}*/
					map.put("busiId", keyArr[0]);
					map.put("busiType", keyArr[1]);
					map.put("attrFlag", keyArr[2]);
					map.put(keyName, columnValue);
					attrList.add(map);
				}
				//对attrList进行遍历，订购数和灰名单标识进行组装为一个map
				for(int i=0;i<attrList.size();i++){
					Map attrMap1 = (Map)attrList.get(i);
					String busiId1= (String)attrMap1.get("busiId");
					String attrFlag1 = (String)attrMap1.get("attrFlag");
					String attrValue1 = (String)attrMap1.get("attrValue");
					Map retMap = new HashMap();
					retMap.put("busiId", busiId1);
					retMap.put("busiType", busiType);
					retMap.put("greyFlag", "N");//初始化灰名单为N
					if("0".equals(attrFlag1)){
						//retMap.put("attrFlag", "0");
						retMap.put("orderNum", attrValue1);
					}else if("1".equals(attrFlag1)){
						//retMap.put("attrFlag", "1");
						retMap.put("greyFlag", attrValue1);
					}
					for(int j=i+1;j<attrList.size();j++){
						Map attrMap2 = (Map)attrList.get(j);
						String busiId2= (String)attrMap2.get("busiId");
						String attrFlag2 = (String)attrMap2.get("attrFlag");
						String attrValue2 = (String)attrMap2.get("attrValue");
						if(busiId1.equals(busiId2)){
							if(Const.mk_userordernum_num_flag.equals(attrFlag2)){
								//retMap.put("attrFlag", "0");
								retMap.put("orderNum", attrValue2);
							}else if(Const.mk_userordernum_grey_flag.equals(attrFlag2)){
								//retMap.put("attrFlag", "1");
								retMap.put("greyFlag", attrValue2);
							}
							if(!retList.contains(retMap)){
								retList.add(retMap);
							}
						}
					}
				}
			}
			System.out.println("运行时间-----------------"+(System.currentTimeMillis()-t1));
		}catch(Exception e){
			e.printStackTrace();
			throw new BaseException("queryBusiOrderNum","亲,queryBusiOrderNum出异常了,到后台看看吧");
		}
		return retList;
		
	}
	@Override
	public List<Map> getOrderCountByUser(Map inParam) {
		String idNo = (String)inParam.get("idNo");
		if(idNo==null || "".equals(idNo.trim())){
			throw new BusiException("-2","亲,查询用户ID出问题了!","UserEntity.getCustGroupIdByUser错误");
		}
		String rowKey = idNo+Const.nosql_split+ "0"+Const.nosql_split+"0";
		String busiType = Const.ACTION;//活动
		List<Map> list = getOrderInfoByUser(rowKey, busiType);
		return list;
	}
	
	/**
	 * Create on 2015-4-13 
	 * @author: yugl
	 * @Title: getUserOrderInfo 
	 * @Description: 查出用户参加活动的订购信息（定购次数、灰名单标识）
	 * @param inParamMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Map getUserOrderInfo(Map inParamMap) {
		//入参校验
		if(inParamMap==null || inParamMap.size()==0){
			log.info("UserEntity.getUserOrderInfo");
			throw new BusiException("-2","亲,入参出问题了!","UserEntity.getUserOrderInfo错误");
		}
		String idNo = (String)inParamMap.get("idNo");
		if(idNo==null || "".equals(idNo.trim())){
			log.info("UserEntity.getUserOrderInfo");
			throw new BusiException("-2","亲,查询用户ID出问题了!","UserEntity.getUserOrderInfo错误");
		}
		//返回值
		Map returnMap = new HashMap();
		//查询活动订购信息
		String rowKey = idNo+Const.nosql_split+Const.ID_TYPE_USER+Const.nosql_split+Const.ORDER_FLAG_ACTION;
		String busiType = Const.ACTION;//活动
		List<Map> orderInfolist = getOrderInfoByUser(rowKey, busiType);
		if(orderInfolist==null || orderInfolist.size()==0){
			return returnMap;
		}
		//定义变量
		String orderActId = null;//用户订购信息中活动ID
		for(Map m:orderInfolist){
			if(m!=null && m.size()>0){
				orderActId = (String)m.get("busiId");
				if(orderActId==null || "".equals(orderActId.trim())){
					continue;
				}
				returnMap.put(orderActId, m);
			}
		}
		return returnMap;
	}
	
	/**
     * 根据主键查询用户参加活动的数量
     * Create on 2014-11-24
     * @author zhaiwt
     * @version 1.0
     * Copyright(c) 北京思特奇信息技术股份有限公司
     * 修改日期:     修改人:     修改目的:
     */
	@Override
	public JSONObject getUserOrderNum(Map inMap) {
		JSONObject userOrderNumJson = null;
		String idNo = (String)inMap.get("idNo");
		String rowKey = idNo + Const.nosql_split + Const.ID_TYPE_USER + Const.nosql_split + Const.ORDER_FLAG_ACTION;
		JSONObject json = uoi.queryUserordernumByIdNo(rowKey);
		if(null != json && json.size() > 0){
			userOrderNumJson = JSONObject.parseObject(json.getString(rowKey));
		}
		return userOrderNumJson;
	}
	
	/** 
	  * 向MK_USERORDERNUM_INFO表中增加营销业务订购次数
	  * Create on 2014-10-22 
	  * @author zhaiwt
	  * @version 1.0
	  * Copyright(c) 北京思特奇信息技术股份有限公司
	  * 修改日期:     修改人:     修改目的:
	  */
	@Override
	public boolean insertUserOrderNum(Map inMap) throws Exception{
		String idNo = (String)inMap.get("idNo");
		String actId = (String)inMap.get("actId");
		String key = idNo + Const.nosql_split + Const.ID_TYPE_USER + Const.nosql_split + Const.ORDER_FLAG_ACTION;
		String columnName = actId + Const.nosql_split + Const.actBusiType + Const.nosql_split + Const.orderNumType;
		boolean bool = uoi.insertUserOrderNum(key,columnName);
		return bool;
	}
	/** 
	  * 回滚MK_USERORDERNUM_INFO表中营销业务订购次数
	  * Create on 2014-11-25 
	  * @author zhaiwt
	  * @version 1.0
	  * Copyright(c) 北京思特奇信息技术股份有限公司
	  * 修改日期:     修改人:     修改目的:
	  */
	@Override
	public void rollbackUserOrderNum(Map inMap){
		String idNo = (String)inMap.get("idNo");
		String actId = (String)inMap.get("actId");
		String key = idNo + Const.nosql_split + Const.ID_TYPE_USER + Const.nosql_split + Const.ORDER_FLAG_ACTION;
		String columnName = actId + Const.nosql_split + Const.actBusiType + Const.nosql_split + Const.orderNumType;
		uoi.rollbackUserOrderNum(key,columnName);
	}
	
	/**
	 * Create on 2015-5-30 
	 * @author: gengws
	 * @Title: queryUserByPhoneNo 
	 * @Description: 查询mk_phone_info,mk_user_info,mk_chngroup_dict,mk_codename_dict等所有数据
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public Map queryUserByPhoneNo(Map inMap) {
		
		//查询ID_NO
		String phoneNo=(String) inMap.get("phoneNo");
		String idNo=mpi.getIdNoByPhoneNo(phoneNo);
		
		String groupId=mkUserInfo.geGroupIdByIdNo(idNo);

		//查询用户groupId,regionCode
		String regionId=null;//使用regionId去查询regionCode
		Map chngroup=new HashMap();
		chngroup.put("groupId",groupId );
		List chnList=mkChngroupDict.selectMkChngroupDictById(chngroup);
		
		if(CommonUtil.isNotEmpty(chnList)){
			Map regionMap=(Map) chnList.get(0);
			regionId=(String) regionMap.get("regionId");
		}else{
  			throw new BusiException("-1","groupId无法查到数据无法得到regionId");
		}
		log.info("regionId=="+regionId);
		Map reMap=new HashMap();
		reMap.put("idNo",idNo );
		reMap.put("regionCode",regionId );
		
		return reMap;
	}
	/**
	 * Create on 2015-7-8 
	 * @author: zhaoyue
	 * @Title: queryUserInfoByPhoneNo 
	 * @Description: 根据phoneNo查询用户标签数据
	 * @param phoneNo
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public Map queryLabelInfoByIdNo(Map inMap) {
		String idNo = "";
		//如果入参idNo为空，则根据phoneNo查询idNo
		if(CommonUtil.isEmpty(inMap.get("idNo"))){
			//根据phoneNo查询ID_NO
			String phoneNo=(String) inMap.get("phoneNo");
			idNo=mpi.getIdNoByPhoneNo(phoneNo);
			inMap.put("idNo", idNo);
		}
	
		//取mk_user_info表的用户标签数据，获取用户基本信息
		idNo = (String)inMap.get("idNo");
		inMap.put("ID_NO", idNo);
        JSONObject userJson = mkUserInfo.getUserInfo(inMap);
        userJson=userJson.getJSONObject(idNo);
        List userList = new ArrayList();
        if(CommonUtil.isNotEmpty(userJson)){
        	userList.add(userJson);
        }
			
		//取mk_userProdInfo表的用户数据，获取用户办理过的产品信息
		JSONObject userProdJson = mkUserprodInfo.selectMkUserProdInfoByRowKye(idNo);
		userProdJson=userProdJson.getJSONObject(idNo);
		List list = new ArrayList();
		if(CommonUtil.isNotEmpty(userProdJson)){
			list = getUserProd(userProdJson);
		}
		//取mk_actRecordInfo表数据，获取该用户的活动订购信息
		List orderActs = mkActrecordInfo.getActRecordsByIdNo(inMap);
		
		//取mk_cust_info表数据，获取客户标签数据
		String custId = userJson.getString("cust_id");
		JSONObject custJson = mkCustInfo.getCustInfoByCustId(custId);
		custJson=custJson.getJSONObject(custId);
		List custList = new ArrayList();
		if(CommonUtil.isNotEmpty(custJson)){
			custList.add(custJson);
		}

		//获取mk_busiordernum_info数据，获取用户的活动订购次数信息
		List busiList = (List)inMap.get("BUSI_LIST");
		List busiorderList = null;
		if (CommonUtil.isNotEmpty(busiList)) {
			List busiIdList = getBusiIdList(busiList);
			Map map = new HashMap();
			map.put("busiIdList", busiIdList);
			busiorderList = mkBusiordernum.selectMkBusiordernumInfo(map);
		}
		
		//获取mk_usergroupmbr_info 数据
		JSONObject userGroupmbr = mkUsergroupmbrInfo.selectMkUsergroupInfoByRowKye(idNo);
		userGroupmbr = userGroupmbr.getJSONObject(idNo);
		List userGroup = new ArrayList();
		if(CommonUtil.isNotEmpty(userGroupmbr)){
			userGroup = getUserGroup(userGroupmbr);
		}
		
		//获取mk_useraccountout_info数据
		JSONObject userAccountout = mkUseraccountoutInfo.selectMkUseraccountoutInfoByRowKye(idNo);
		userAccountout = userAccountout.getJSONObject(idNo);
		List userAccountList = new ArrayList();
		if(CommonUtil.isNotEmpty(userAccountout)){
			//userAccountList = getUseraccountOut(list,userAccountout);
			userAccountList.add(userAccountout);
		}
		
		//获取mk_userdatause_info 数据
		String phoneNo = (String)userJson.get("phone_no");
		JSONObject userDatause = mkUserdatauseInfo.selectMkUserdataUseInfoByRowKye(phoneNo);
		userDatause=userDatause.getJSONObject(phoneNo);
		List userData = new ArrayList();
		if(CommonUtil.isNotEmpty(userDatause)){
			userData.add(userDatause);
		}
		
		//获取mk_actrecordtermi_info表数据
		List termiRecord = mkActrecordtermiInfo.queryActrecordTermiInfoByIdNo(idNo);
		
		//获取mk_actcust_info 数据
		//String key = idNo+"|"+"10000";
		String key = idNo;
		JSONObject actCust = mkActcustInfo.queryMkActcustInfo(key);
		actCust = actCust.getJSONObject(key);
		List actCustList = new ArrayList();
		if(CommonUtil.isNotEmpty(actCust)){
			actCustList.add(actCust);
		}
		
		//获取mk_custphone_info 数据，校验新开户的用户目标客户群规则
		String key2 = "";
		if(CommonUtil.isNotEmpty((String)inMap.get("phoneNo"))){
			key2 = (String)inMap.get("phoneNo");
		}else{
			for(int i=0;i<userList.size();i++){
				Map map = (Map)userList.get(i);
				key2 = (String)map.get("phoneNo");
			}
		}
		JSONObject custPhone = mkCustPhoneInfo.selectMkCustPhoneInfo(key2);
		custPhone = custPhone.getJSONObject(key2);
		List actPhoneList = new ArrayList();
		if(CommonUtil.isNotEmpty(custPhone)){
			actPhoneList.add(custPhone);
		}
		
		Map userMap = new HashMap();
		userMap.put("mk_user_info",userList);
		userMap.put("mk_userprod_info", list);
		userMap.put("mk_actrecord_info", orderActs);
		userMap.put("mk_cust_info", custList);
		userMap.put("mk_busiordernum_info", busiorderList);
		userMap.put("mk_userdatause_info", userData);
		userMap.put("mk_usergroupmbr_info", userGroup);
		userMap.put("mk_useraccountout_info", userAccountList);
		userMap.put("mk_actrecordtermi_info",termiRecord);
		userMap.put("mk_actcust_info", actCustList);
		userMap.put("mk_custphone_info", actPhoneList);
		return userMap;
	}
	/**
	 * Create on 2015-7-15 
	 * @author:zhaoyue
	 * @Title: getUserProd 
	 * @Description: 拆分mk_userprod_info数据，组装一个新的map
	 * @param userProdJson
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	private List getUserProd(JSONObject userProdJson){
		Map map = (Map)userProdJson;
		List list = new ArrayList();
		if(CommonUtil.isNotEmpty(map)){
			Set set = map.keySet();
			Iterator iter = set.iterator();
			while(iter.hasNext()){
				   Map map2 = new HashMap();
				   String key = (String)iter.next();
				   String values =(String)map.get(key);
				   String[] arrays = values.split("\\|");
				   String prodId = arrays[0];
				   String opTime = arrays[1];
				   String chnType = arrays[2];
				   String effTime = arrays[3];
				   String expTime = arrays[4];
				   String prodMainFlag = arrays[5];
				   map2.put("prc_id", key);
				   map2.put("prod_id", prodId);
				   map2.put("op_time", opTime);
				   map2.put("chn_type", chnType);
				   map2.put("eff_time", effTime);
				   map2.put("exp_time", expTime);
				   map2.put("prod_main_flag", prodMainFlag);
				   list.add(map2);
			   }
		}else{
			throw new BusiException("-1","出错了！查询mk_userprod_info数据为空！","查询mk_userprod_info数据为空！");
		}
		return list;
	}
	
	/**
	 * Create on 2015-7-18 
	 * @author:zhaoyue
	 * @Title: getBusiIdList 
	 * @Description:获取busiIdList 
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	private List getBusiIdList(List list){
		List busiIdList = new ArrayList();
		for(int i=0;i<list.size();i++){
			Map busiInfo = (Map)list.get(i);
			List busiList = (List)busiInfo.get("BUSI_INFO");
			for(int j=0;j<busiList.size();j++){
				Map map = (Map)busiList.get(j);
				String busiId = (String)map.get("BUSI_ID");
				busiIdList.add(busiId);
			}
		}
		return busiIdList;
	}
	
	private List getUseruse(JSONObject userProdJson){
		Map map = (Map)userProdJson;
		Map keyMap = new HashMap();
		List list = new ArrayList();
	    String values =(String)map.get("gprs_use");
	    String[] arrays = values.split("\\|");
	    String lastMonth = arrays[0];
	    String gprsUse = arrays[1];
	    map.put("gprs_use", gprsUse);
	    map.put("last_month", lastMonth);
	    keyMap.put("gprs_use", map);
	    list.add(keyMap);
		return list;
	}
	
	private List getUserGroup(JSONObject userProdJson){
		Map map = (Map)userProdJson;
		List list = new ArrayList();
		if(CommonUtil.isNotEmpty(map)){
			Set set = map.keySet();
			Iterator iter = set.iterator();
			while(iter.hasNext()){
				   Map map2 = new HashMap();
				   String key = (String)iter.next();
				   String values =(String)map.get(key);
				   String[] arrays = values.split("\\|");
				   String memberRoleId = arrays[0];
				   String groupId = arrays[1];
				   String groupType = arrays[2];
				   String objectType = arrays[3];
				   String opTime = arrays[4];
				   String effTime = arrays[5];
				   String expTime = arrays[6];
				   map2.put("member_role_id", memberRoleId);
				   map2.put("group_id", groupId);
				   map2.put("group_type", groupType);
				   map2.put("object_type", objectType);
				   map2.put("op_time", opTime);
				   map2.put("eff_time", effTime);
				   map2.put("exp_time", expTime);
				   list.add(map2);
			   }
		}else{
			throw new BusiException("-1","出错了！查询mk_userprod_info数据为空！","查询mk_userprod_info数据为空！");
		}
		return list;
	}
	
	private List getUseraccountOut(List userProd,JSONObject useraccountOut){
		List list = new ArrayList();
		Map userAccountMap = (Map)useraccountOut;
		if(CommonUtil.isNotEmpty(userProd)){
			for(int i=0;i<userProd.size();i++){
				Map map = (Map)userProd.get(i);
				String prcId = (String)map.get("prc_id");
				String key = prcId+"|"+"static_fee";
				String result = (String)userAccountMap.get(key);
				if(CommonUtil.isNotEmpty(result)){
					userAccountMap.put("static_fee",key);
					userAccountMap.put(key,result);
				}
			}
		list.add(userAccountMap);
		}
		return list;
	}
	/**
	 * Create on Aug 3, 2015 
	 * @author: zhaoyue
	 * @Title: queryLabelInfo 
	 * @Description: 查询用户标签数据，返回结果全为驼峰式。
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public Map queryLabelInfo(Map inMap) {
		
		Map map = (Map)queryLabelInfoByIdNo(inMap);

		List userList = (List)map.get("mk_user_info");
		userList = (List)ParamUtil.parseCapital2Hump(userList);
		map.put("mk_user_info", userList);
		
		List userProd = (List)map.get("mk_userprod_info");
		userProd = (List)ParamUtil.parseCapital2Hump(userProd);
		map.put("mk_userprod_info", userProd);
		
		List custList = (List)map.get("mk_cust_info");
		custList = (List)ParamUtil.parseCapital2Hump(custList);
		map.put("mk_cust_info", custList);
		
		List termiRecord = (List)map.get("mk_actrecordtermi_info");
		termiRecord = (List)ParamUtil.parseCapital2Hump(termiRecord);
		map.put("mk_actrecordtermi_info", termiRecord);
		
		List orderActs = (List)map.get("mk_actrecord_info");
		orderActs = (List)ParamUtil.parseCapital2Hump(orderActs);
		map.put("mk_actrecord_info", orderActs);
		
		List userUseData = (List)map.get("mk_userdatause_info");
		userUseData = (List)ParamUtil.parseCapital2Hump(userUseData);
		map.put("mk_userdatause_info", userUseData);
		
		List useraccount = (List)map.get("mk_useraccountout_info");
		useraccount = (List)ParamUtil.parseCapital2Hump(useraccount);
		map.put("mk_useraccountout_info", useraccount);
		
		List actCust = (List)map.get("mk_actcust_info");
		actCust = (List)ParamUtil.parseCapital2Hump(actCust);  
		map.put("mk_actcust_info", actCust);
		
		List userGroup= (List)map.get("mk_usergroupmbr_info");
		userGroup = (List)ParamUtil.parseCapital2Hump(userGroup);
		map.put("mk_usergroupmbr_info", userGroup);
		return map;
	}
	
	/**
	 * Create on 2015-8-11 
	 * @author:jiaxla
	 * @Title: queryUserContractByPhoneNo 
	 * @Description: 根据手机号查询用户账户
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public Map queryUserContractByPhoneNo(Map inMap) {
		Map retMap = new HashMap();
		//如果入参idNo为空，则根据phoneNo查询idNo
		if(CommonUtil.isEmpty(inMap.get("phoneNo"))){
			throw new BusiException("-1", "PHONE_NO不能为空！", "PHONE_NO不能为空！");
		}
		//根据phoneNo查询ID_NO
		String phoneNo=(String) inMap.get("phoneNo");
		String idNo = mpi.getIdNoByPhoneNo(phoneNo);
		
		if(CommonUtil.isEmpty(idNo)){
			throw new BusiException("-1", "没有查到ID_NO信息，请确认输入信息！", "没有查到ID_NO信息，请确认输入信息！");
		}
		//取mk_user_info表的用户标签数据，获取用户基本信息
		inMap.put("ID_NO", idNo);
        JSONObject userJson = mkUserInfo.getUserInfo(inMap);
        userJson=userJson.getJSONObject(idNo);
        Set<String> keys = userJson.keySet();
        for (String key : keys) {
        	String val = (String) userJson.get(key);
        	retMap.put(key,val);
		}
		return retMap;
	}
	
	}
   
