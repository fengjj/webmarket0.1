package com.sitech.market.busiobject.entity.busi.impl;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.alibaba.fastjson.JSONObject;
import com.sitech.jcf.core.exception.BusiException;
import com.sitech.market.busiobject.basicclass.busientity.BusiEntity;
import com.sitech.market.busiobject.entity.busi.inter.ICustGroupAtomEntity;
import com.sitech.market.busiobject.entity.busi.inter.IUserAtomEntity;
import com.sitech.market.dbo.destribution.inter.IMkActInfo;
import com.sitech.market.dbo.destribution.inter.IMkBusicontentRel;
import com.sitech.market.dbo.destribution.inter.IMkBusicustgroupRel;
import com.sitech.market.dbo.destribution.inter.IMkContentInfo;
import com.sitech.market.dbo.destribution.inter.IMkCustGroupInfo;
import com.sitech.market.dbo.destribution.inter.IMkImportbusiTmp;
import com.sitech.market.dbo.destribution.inter.IMkImportbusiexpTmp;
import com.sitech.util.CommonUtil;
import com.sitech.util.Const;
import com.sitech.util.ParamUtil;
import com.sitech.util.SequUtil;
import com.sitech.util.SitechDateUtil;
import com.sitech.util.SynDealFileUtil;
import com.sitech.util.WebServiceCallUtil;

/**
 * Create on 2015-3-31
 * @author: yugl_bj
 * @Title: CustGroupAtomEntity
 * @Description: 客户群实体
 * @version 1.0  
 * update_data:     update_author:     update_note:
 */
@SuppressWarnings("unchecked")
public class CustGroupAtomEntity extends BusiEntity implements ICustGroupAtomEntity {
	private IMkCustGroupInfo mkCustGroupInfo;
	private IMkBusicustgroupRel mkBusicustgroupRel;
	private IUserAtomEntity userEntity;
	private IMkImportbusiTmp mkImportbusiTmp;
	private IMkImportbusiexpTmp mkImportbusiexpTmp;
	private IMkBusicontentRel mkBusiContentRel;
	private IMkContentInfo mkContentInfo;
	private IMkActInfo mkActInfo;

	public IMkCustGroupInfo getMkCustGroupInfo() {
		return mkCustGroupInfo;
	}

	public void setMkCustGroupInfo(IMkCustGroupInfo mkCustGroupInfo) {
		this.mkCustGroupInfo = mkCustGroupInfo;
	}

	public IMkBusicustgroupRel getMkBusicustgroupRel() {
		return mkBusicustgroupRel;
	}

	public void setMkBusicustgroupRel(IMkBusicustgroupRel mkBusicustgroupRel) {
		this.mkBusicustgroupRel = mkBusicustgroupRel;
	}

	public IUserAtomEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(IUserAtomEntity userEntity) {
		this.userEntity = userEntity;
	}

	public IMkImportbusiTmp getMkImportbusiTmp() {
		return mkImportbusiTmp;
	}

	public void setMkImportbusiTmp(IMkImportbusiTmp mkImportbusiTmp) {
		this.mkImportbusiTmp = mkImportbusiTmp;
	}

	public IMkImportbusiexpTmp getMkImportbusiexpTmp() {
		return mkImportbusiexpTmp;
	}

	public void setMkImportbusiexpTmp(IMkImportbusiexpTmp mkImportbusiexpTmp) {
		this.mkImportbusiexpTmp = mkImportbusiexpTmp;
	}

	public IMkBusicontentRel getMkBusiContentRel() {
		return mkBusiContentRel;
	}

	public void setMkBusiContentRel(IMkBusicontentRel mkBusiContentRel) {
		this.mkBusiContentRel = mkBusiContentRel;
	}

	public IMkContentInfo getMkContentInfo() {
		return mkContentInfo;
	}

	public void setMkContentInfo(IMkContentInfo mkContentInfo) {
		this.mkContentInfo = mkContentInfo;
	}

	public IMkActInfo getMkActInfo() {
		return mkActInfo;
	}

	public void setMkActInfo(IMkActInfo mkActInfo) {
		this.mkActInfo = mkActInfo;
	}

	/**
	 * Create on 2015-6-1 
	 * @author: yugl
	 * @Title: screenActionByCustGroup 
	 * @Description: 根据用户的客户群筛选出可办理活动
	 * @param actInfoList
	 * @param inParam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List screenActionByCustGroup(List actInfoList, Map inParam){
		List busiIdList = new ArrayList();
		for(int i=0;i<actInfoList.size();i++){
			Map actMap = (Map)actInfoList.get(i);
			String actId = (String)actMap.get("actId");
			busiIdList.add(actId);
		}
		Map paraMap = new HashMap();
		paraMap.put("busiIdList", busiIdList);
		paraMap.put("busiType", Const.ACTION);
		List busicustRel = mkBusicustgroupRel.selectMkBusicustgroupRel(paraMap);
		
		String idNo = (String) inParam.get("idNo");
		Map userCustgroup = userEntity.getCustGroupIdByUser(idNo);
		
		List retList = getActionByUserCustgroup(actInfoList,busicustRel,userCustgroup);
		return retList;
	}
	
	/**
	 * Create on 2015-6-1 
	 * @author: yugl
	 * @Title: getActionByUserCustgroup 
	 * @Description: 用户所属客户群与活动客户群比较，筛选活动
	 * @param actInfoList
	 * @param busicustRel
	 * @param userCustgroup
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	private List getActionByUserCustgroup(List actInfoList,List busicustRel,Map userCustgroup){
		List retList = new ArrayList();
		for(int i=0;i<actInfoList.size();i++){
			Map actMap = (Map)actInfoList.get(i);
			String actId = (String)actMap.get("actId");
			//活动的客户群与用户客户群比较
			for(int j=0;j<busicustRel.size();j++){
				Map busicustRelMap = (Map)busicustRel.get(j);
				String busiId = (String)busicustRelMap.get("busiId");
				if(actId.equals(busiId)){
					String custgroupId = (String)busicustRelMap.get("custGroupId");
					String choiceCode = (String) busicustRelMap.get("choiceCode");
					if (("0".equals(choiceCode) || "4".equals(choiceCode))) {// 全网活动,不校验
						retList.add(actMap);
						break;
					}else{
						//非全网活动，判断用户的客户群是否包含当前活动客户群
						if(CommonUtil.isNotEmpty(userCustgroup)){
							if(userCustgroup.containsKey(custgroupId)){
								retList.add(actMap);
								break; 
							}
						}
					}
				}
			}
		}
		return retList;
	}
	
	/**
	 * 查询业务客户群信息
	 * Create on 2015-5-9 
	 * @author: wangdw
	 * @Title: selectBusiCustGroup 
	 * @Description: 入参[busiId 业务id,busiType 业务类型]
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List selectBusiCustGroup(Map<Object,Object> inMap){
        return mkBusicustgroupRel.selectCustGroup(inMap);
    }
	
	/**
	 * Create on 2015-6-6 
	 * @author: liuhaoa
	 * @Title: queryList 
	 * @Description: 目标客户群查询
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */	
	@Override
	public List queryList(Map inMap) {
		int beginNum = 0;
		int endNum = 0;
		if(CommonUtil.isNotEmpty(inMap.get("beginNum"))){
			beginNum = Integer.parseInt((String)inMap.get("beginNum"));
		}
		if(CommonUtil.isNotEmpty(inMap.get("endNum"))){
			endNum = Integer.parseInt((String)inMap.get("endNum"));
		}

		List dataList = mkCustGroupInfo.queryList(inMap, beginNum, endNum);
		return dataList;
	}
	
	/**
	 * Create on 2015-6-8
	 * @author: liuhaoa
	 * @Title: insertCustGroupInfo 
	 * @Description: 目标客户群生成
	 * @param inDTO
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void insertCustGroupInfo(Map inMap) {
		String groupId = (String) inMap.get("custGroupId");
		System.out.println(inMap.get("choiceCode")+"    "+inMap.get("filePath"));
		if(inMap.get("custGroupDesc")!=null&&"1".equals(inMap.get("choiceCode"))){
			//String groupId = SequUtil.getSequ(3);
			String desc = (String) inMap.get("custGroupDesc");
			String cond = desc.split(":::")[1];
			callService( cond , groupId);
			mkCustGroupInfo.insertCustGroupInfo(inMap);
		}else if(inMap.get("filePath")!=null&&"2".equals(inMap.get("choiceCode"))){
			//TODO 文件导入模式，启动独立线程处理导入到redis
			SynDealFileUtil sdfu = new SynDealFileUtil();
			sdfu.setFile(new File((String) inMap.get("filePath")));
			sdfu.setBusiId(groupId);
			sdfu.start();
			mkCustGroupInfo.insertCustGroupInfo(inMap);
		}
	}

	/**
	 * @author: liuhaoa
	 * @Title: deleteCustGroupInfo
	 * @Description:删除目标客户群明细
	 * @return 
	 * @version 1.0 
	 * date:2015-6-8
	 */
	@Override
	public void deleteCustGroupInfo(Map inMap) {
		
		mkCustGroupInfo.deleteCustGroupInfo(inMap);
	}
	//TODO 
	public static void main(String[] s){
/*		String s1 = "1 %{AND} 2";
		String[] a = s1.split("%\\{AND\\}");
		System.out.println(a.length);*/
		CustGroupAtomEntity ca = new CustGroupAtomEntity();
		ca.callService("${40018} %{IN} (#{18666093071},#{18688893496},#{15603058637},#{18566234280},#{18665836199},#{18666388088},#{18666608899},#{18688661086},#{18688796200},#{18688800727},#{13048182051},#{13060585183},#{13076984583},#{13113962227},#{13202320677},#{13265548458},#{18503018621},#{18565593840},#{18602049986},#{18620067642},#{18675974230},#{13018461107},#{13076982128},#{13202328102},#{13242425432},#{15602222008},#{17602010479},#{18502053660},#{18507558808},#{18566763033},#{18575022838},#{18588608529},#{18588896802},#{18664099160},#{18664299332},#{18664646936},#{18664993992},#{18665611651},#{18666203016},#{18666507550},#{18666903200},#{18680171880},#{18688854914})", "20180314001");
		/*ca.callService("${30010} %{<} #{45} %{AND} ${30010} %{/>} #{18} %{AND} ${I53037} %{/<} #{800} %{AND} ${I53037} %{>} #{80} %{AND} ${20012} %{IN} (#{3G},#{2G})",
				"2000004");*/
		//ca.callService("${20006} %{IN} (#{16163042},#{16163054},#{16163118},#{16163194},#{16163196},#{16163198},#{16164356},#{16169646},#{16169648},#{21010040},#{50020014}) %{AND} ${20012} %{IN} (#{3G},#{2G})", "201609301");
	}
	/**
	 * 服务调用
	 * @param cond
	 */
	private void callService(String cond, String groupId){
		String url = "http://132.121.85.7:8901/dataService/services/DataInfoImpl?wsdl";
		String wsdl = "http://webservice.dataservice.dic.tydic.com/";
		String filePath = "";
		String username = "uif_realsale";
		String password = "60A25A73D20D77D89CF0AA6507097AF6";
		String name = "getDataInfo";
		try {
			Document doc = DocumentHelper.createDocument(DocumentHelper.createElement("USERINFOREQUEST"));
			Element msgHead = doc.getRootElement().addElement("MSGHEADER");
			Element msgBody = doc.getRootElement().addElement("MSGBODY");
			msgHead.addElement("SESSIONID").addText(groupId);//唯一标示
			msgHead.addElement("USERNAME").addText(username);
			msgHead.addElement("PASSWORD").addText(password);
			msgHead.addElement("MSGTYPE").addText("3");//返回文件
			msgHead.addElement("VERSION").addText("10");
			msgHead.addElement("TRANSMISSION").addText("2");//异步
			msgHead.addElement("FETCHTYPE").addText("6");
			msgHead.addElement("NOTICE").addText("1");
			msgBody.addElement("TYPE").addText("0");
			msgBody.addElement("DATALIST").addText("${40018},${B515001},${I515002},${I515003},${I515001},${I514006},"
					+ "${I514001},${I514003},${B514001},${E1012003},${E1012002},${I664001},${I664002},"
					+ "${B451002},${B451007},${I777003},${10072},${10071},${I263102},${I263097},${I1232006},"
					+ "${I1232009},${I263002},${I1232005},${I263087},${I1232023},${10020},${I1232045},${I503001},"
					+ "${I503004},${I503003},${I471001},${I469001},${I470001},${I486001},${30013},${30012},${F446004},"
					+ "${30015},${30009},${30016},${30010},${10666},${10241},${10664},${10675},${I73009},${10607},${10665}");
			//msgBody.addElement("DATALIST").addText("${40018}");//手机号码
			//13002001303 0 16163267 10706.85059 
			//13002000183 2001085554017 0020 440102195511084051 1 3G-46元基本套餐C 0 1
			//msgBody.addElement("DATALIST").addText("${40088}");//手机号码
			Element condList = msgBody.addElement("CONDITIONLIST");
			String[] temp = cond.split("%\\{AND\\}");
			for(int i = 0;i<temp.length;i++){
				condList.addElement("CONDITION").addText(temp[i]);//查询条件
			}
			/*Element fileInfo = condList.addElement("FILECONDITION").addElement("FILEINFO");//文件信息
			fileInfo.addElement("DATATYPE").addText("2");
			fileInfo.addElement("FILEPATH").addText(filePath);
			fileInfo.addElement("DATATYPE").addText("2");*/
			WebServiceCallUtil.call(url, wsdl, name, doc.asXML());
		} catch (Exception e) {
			e.printStackTrace();
			new BusiException("webservice 服务调用报错");
		}
	}
	/**
	 * @author: liuhaoa
	 * @Title: addCustGroupDetail
	 * @Description:目标客户群序列生成
	 * @return 
	 * @version 1.0 
	 * date:2015-6-9
	 */
	@Override
	public String addCustGroupDetail(){
		return SequUtil.getSequ(3);
	}
	
	/**
	 * 保存附件客户群
	 * @Create on 2015-7-28 
	 * @author: wangdw
	 * @Title: saveFileCustGroup 
	 * @Description: 
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	@Override
	public Map saveFileCustGroup(Map inMap) {
		String custGroupId = (String)inMap.get("custGroupId");
		String custRelSerialId = (String)inMap.get("custRelSerialId");
		String contentSerialId = (String)inMap.get("contentSerialId");
		Map actMap = mkActInfo.queryMkActInfoById((String)inMap.get("busiId")+"");
		String actClass = actMap.get("actClass").toString();
		String date = inMap.get("startDate")+" 00:00:00";
		//35需要判断是否在活动有效期间
		if(actClass.equals("35"))
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String start = actMap.get("startDate")+" 00:00:00";
			String end = actMap.get("endDate")+" 00:00:00";
			
				try {
					Date start_date = sdf.parse(start);
					Date end_date = sdf.parse(end);
					Date group_date = sdf.parse(date);
					if(start_date.getTime()>group_date.getTime())
					{
						Map<String, String> returnMap = new HashMap<String, String>();
						returnMap.put("result", "-1");
						returnMap.put("message", "不能小于活动开始时间"+actMap.get("startDate"));
						return returnMap;
					}
//					if(end_date.getTime()<group_date.getTime())
//					{
//						Map<String, String> returnMap = new HashMap<String, String>();
//						returnMap.put("result", "-1");
//						returnMap.put("message", "不能大于活动结束时间"+actMap.get("endDate"));
//						return returnMap;
//					}
					
					
				} catch (ParseException e) {
					e.printStackTrace();
				}
		}
		Map inParam = new HashMap();
		
		// 如果已经保存过，就直接更新
		if (CommonUtil.isNotEmpty(custGroupId) && CommonUtil.isNotEmpty(custRelSerialId)) {
			inParam.clear();
			inParam.put("custGroupId", custGroupId);
			inParam.put("custGroupName", (String)inMap.get("custGroupName"));
			inParam.put("custGroupDesc", (String)inMap.get("custGroupName"));
			inParam.put("startDate", (String)inMap.get("startDate"));
			inParam.put("choiceCode", (String)inMap.get("choiceCode"));
			mkCustGroupInfo.updateMkCustgroupInfoById(inParam);
			
			inParam.clear();
			inParam.put("serialId", custRelSerialId);
			inParam.put("startDate", (String)inMap.get("startDate"));
			inParam.put("choiceCode", (String)inMap.get("choiceCode"));
			mkBusicustgroupRel.updateMkBusicustgroupRelById(inParam);
			
		} else { // 否则重新创建
			custGroupId = SequUtil.getSequ();
			inParam.clear();
			inParam.put("custGroupId", custGroupId);
			inParam.put("custGroupName", (String)inMap.get("custGroupName"));
			inParam.put("custGroupDesc", (String)inMap.get("custGroupName"));
			inParam.put("custNum", Const.INT_0);
			inParam.put("startDate", (String)inMap.get("startDate"));
			inParam.put("operNo", (String)inMap.get("loginNo"));
			inParam.put("operName", (String)inMap.get("loginName"));
			inParam.put("operTime", SitechDateUtil.getFormatDateTimeString(new Date()));
			inParam.put("choiceCode", (String)inMap.get("choiceCode"));
			mkCustGroupInfo.insertCustGroupInfo(inParam);
			
			
			inParam.clear();
			custRelSerialId = SequUtil.getSequ();
			inParam.put("serialId", custRelSerialId);
			inParam.put("busiId", (String)inMap.get("busiId"));
			inParam.put("busiType", (String)inMap.get("busiType"));
			inParam.put("custGroupId", custGroupId);
			inParam.put("startDate", (String)inMap.get("startDate"));
			inParam.put("operNo", (String)inMap.get("loginNo"));
			inParam.put("operName", (String)inMap.get("loginName"));
			inParam.put("statusCode", Const.custGroupStatus0);
			inParam.put("operTime", SitechDateUtil.getFormatDateTimeString(new Date()));
			inParam.put("choiceCode", (String)inMap.get("choiceCode"));
			mkBusicustgroupRel.insertIMkBusicustgroupRel(inParam);
			
			inParam.clear();
			contentSerialId = SequUtil.getSequ();
			inParam.put("relId", contentSerialId);
			inParam.put("busiId", custGroupId);
			inParam.put("busiType", "08");
			inParam.put("contentSerialId", contentSerialId);
			mkBusiContentRel.insertMkBusicontentRel(inParam);
			
			Map dataMap = mkActInfo.queryMkActInfoById(inMap.get("busiId") + "");
			inParam.clear();
			inParam.put("contentSerialId", contentSerialId);
			inParam.put("contentId", SequUtil.getSequ());
			inParam.put("contentName", dataMap.get("actName") + "");
			inParam.put("contentType", "04");
			inParam.put("startDate", dataMap.get("startDate") + "");
			inParam.put("endDate", dataMap.get("endDate") + "");
			inParam.put("regionCode", dataMap.get("regionCode") + "");
			inParam.put("operNo", dataMap.get("operNo") + "");
			inParam.put("operName", dataMap.get("operName") + "");
			inParam.put("operTime", dataMap.get("operTime") + "");
			mkContentInfo.insertMkContentInfo(inParam);
			
		}
		
		Map<String, String> returnMap = new HashMap<String, String>();
		returnMap.put("custGroupId", custGroupId);
		returnMap.put("serialId", custRelSerialId);
		returnMap.put("contentSerialId", contentSerialId);
		//加个返回类型判断
		returnMap.put("result", "0");
		return returnMap;
	}
	
	
	/**
	 * 获得mk_busicustgroup_rel的serialId集合
	 * @Create on 2015-7-30 
	 * @author: wangdw
	 * @Title: getSerialIds 
	 * @Description: 
	 * @param custGroupList
	 * @return 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	private List<String> getSerialIds(List<Object> custGroupList) {
		List<String> serialIds = null;
		if (CommonUtil.isNotEmpty(custGroupList)) {
			serialIds = new ArrayList<String>();
			for (Object custGroup : custGroupList) {
				Map cgMap = (Map)custGroup;
				serialIds.add((String)cgMap.get("serialId"));
			}
		}
		return serialIds;
	}
	/**
	 * 根据客户群，查询导入正表记录信息
	 * @Create on 2015-7-30 
	 * @author: wangdw
	 * @Title: getImpList 
	 * @Description: 
	 * @param serialIds
	 * @return 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	private List<Map> getImpList(List<String> serialIds) {
		List<Map> resultList = new ArrayList<Map>();
		if (CommonUtil.isNotEmpty(serialIds)) {
			Map inParam = new HashMap();
			inParam.put("relIds", serialIds);
			resultList = mkImportbusiTmp.selectMkImportbusiTmp(inParam);
		}
		return resultList;
	}
	
	/**
	 * 根据客户群，查询导入异常表记录信息
	 * @Create on 2015-7-30 
	 * @author: wangdw
	 * @Title: getImpExpList 
	 * @Description: 
	 * @param custGroupList
	 * @return 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	private List<Map> getImpExpList(List<String> serialIds) {
		List<Map> resultList = new ArrayList<Map>();
		if (CommonUtil.isNotEmpty(serialIds)) {
			Map inParam = new HashMap();
			inParam.put("relIds", serialIds);
			resultList = mkImportbusiexpTmp.selectMkImportbusiexpTmp(inParam);
		}
		return resultList;
	} 
	
	
	/**
	 * 处理预评估信息
	 * @Create on 2015-7-30 
	 * @author: wangdw
	 * @Title: processPreEvaluation 
	 * @Description: 
	 * @param custGroupList
	 * @param impExpList
	 * @return 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	private Map processPreEvaluation(Map actInfo, List<Object> custGroupList, List<Map> impList, List<Map> impExpList) {
		log.info("********actInfo:"+actInfo);
		log.info("********custGroupList:"+custGroupList);
		log.info("********impList:"+impList);
		log.info("********impExpList:"+impExpList);
		String actId = (String) actInfo.get("actId");				// 活动id
		String actName = (String) actInfo.get("actName");			// 活动名称
		String actDesc = (String) actInfo.get("actDesc");			// 活动描述
		String actClass = (String) actInfo.get("actClass");			// 活动小类
		String actClassName = (String) actInfo.get("actClassName");	// 活动小类名称
		String applyPhone = (String) actInfo.get("applyPhone");		// 联系人手机号
		String startDate = "";										// 赠费日期
		int sumNum = 0;												// 总记录数
		int inNum = 0;												// 入库记录数
		int successNum = 0;											// 正常记录数
		int preNum = 0;												// 预拆预销数
		int expNum = 0;												// 不正常记录数
		int phoneNum = 0;											// 预计赠送号码数
		double inMoney = 0.0;										// 入库总金额
		double sendMoney = 0.0;										// 预计赠送总金额
		double expMoney = 0.0;										// 异常总金额
		
		// 获取赠费开始时间，成功记录数，总记录数，入库记录数
		if (CommonUtil.isNotEmpty(custGroupList)) {
			Map custGroup = (Map)custGroupList.get(0);
			startDate = (String)custGroup.get("startDateStr");
			successNum = (Integer)custGroup.get("custNum");
			int expSize = CommonUtil.isEmpty(impExpList) ? 0 : impExpList.size();
			sumNum = successNum + expSize;
			inNum = sumNum; // 入库记录数 = 总记录数
			phoneNum = successNum; // 预计赠送号码数 = 正常记录数
		}
		
		// 异常表处理
		if (CommonUtil.isNotEmpty(impExpList)) {
			for (Map impExp : impExpList) {
				String returnCode = (String)impExp.get("returnCode");	// 异常代码
				// 预拆和预销总数累加
				if (Const.impExpCodeI.equals(returnCode) || Const.impExpCodeJ.equals(returnCode)) {
					preNum++;
				} 
				// 其他类异常总数累加
				else {
					expNum++;
				}
				
				// 送积分和送费，累加异常金额
				if (Const.actClass31.equals(actClass) || Const.actClass36.equals(actClass)) {
					String busiValue = (String)impExp.get("busiValue");		// 业务值
					double value = Double.parseDouble(busiValue);
					expMoney += value; // 异常总额累加。
				}
			}
		}
		
		// 正常表处理（送积分和费用，累加金额）
		if (Const.actClass31.equals(actClass) || Const.actClass36.equals(actClass)) {
			if (CommonUtil.isNotEmpty(impList)) {
				for (Map imp : impList) {
					// 送积分和送费，累加异常金额
					String busiValue = (String)imp.get("busiValue");		// 业务值
					double value = Double.parseDouble(busiValue);
					sendMoney += value; // 发送总额累加。
				}
			}
		}
		// 入库总金额=异常总金额+预发送总金额
		inMoney = expMoney + sendMoney; 
		
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("actId", actId);
		resultMap.put("actName", actName);
		resultMap.put("applyPhone", applyPhone);
		resultMap.put("startDate", startDate);
		resultMap.put("sendModel", actClassName);
		resultMap.put("actDesc", actDesc);
		resultMap.put("sumNum", String.valueOf(sumNum));
		resultMap.put("inNum", String.valueOf(inNum));
		resultMap.put("successNum", String.valueOf(successNum));
		resultMap.put("preNum", String.valueOf(preNum));
		resultMap.put("expNum", String.valueOf(expNum));
		resultMap.put("phoneNum", String.valueOf(phoneNum));
		resultMap.put("inMoney", String.valueOf(inMoney));
		resultMap.put("sendMoney", String.valueOf(sendMoney));
		return resultMap;
	}
	
	

    /**
     * @Create on 2016-5-3 
     * @author: zhaojie
     * @Title: updateCustGroupInfo 
     * @Description: 更新客户群信息
     * @return 
     * @version 1.0 
     * update_date:       update_author:       update_note:
     */
	@Override
	public void updateCustGroupInfo(Map inMap) {
		// TODO Auto-generated method stub
		System.out.println("CustGroupAtomEntity updateCustGroupInfo inMap="+inMap.toString());
		mkCustGroupInfo.updateMkCustgroupInfoById(inMap);
	}

}