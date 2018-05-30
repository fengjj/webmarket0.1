package com.sitech.market.dbo.destribution.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.sitech.crmpd.core.bean.MapBean;
import com.sitech.crmpd.core.service.impl.ServiceUtil;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dbclass.DBServiceClass;
import com.sitech.market.dbo.common.inter.IMkCodenameDict;
import com.sitech.market.dbo.destribution.inter.IQueryGroupDBO;
import com.sitech.util.PropertiesUtil;

public class QueryGroupDBO extends DBServiceClass implements IQueryGroupDBO{
	private IMkCodenameDict codenameDict;
	/**
	 * 拼装调用接口的xml参数
	 * 
	 * @param dynParams
	 * @return
	 */
	private static String carrierId;
	public IMkCodenameDict getCodenameDict() {
		return codenameDict;
	}

	public void setCodenameDict(IMkCodenameDict codenameDict) {
		this.codenameDict = codenameDict;
	}

	static {// 加载类的时候自动加载配置文件
		try {
			//carrierId = PropertiesUtil.getProperty("carrier.properties","carrierId");
			//System.out.println("加载配置文件成功");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			//System.out.println("加载配置文件失败" + e.getMessage());
		}

	}
	
	public String getInputParams(String dynParams) {
		StringBuffer xmlBuffer = new StringBuffer();
		xmlBuffer
				.append("<?xml version=\"1.0\" encoding=\"GBK\" standalone=\"no\" ?>");
		xmlBuffer
				.append("<Root><REQUEST_INFO  type=\"node\"><OPR_INFO  type=\"node\">");
		xmlBuffer
				.append("<REGION_ID type=\"int\"></REGION_ID><CHANNEL_TYPE type=\"string\"></CHANNEL_TYPE>");
		xmlBuffer
				.append("<LOGIN_NO type=\"string\"></LOGIN_NO><LOGIN_PWD type=\"string\"></LOGIN_PWD>");
		xmlBuffer
				.append("<IP_ADDRESS type=\"string\"></IP_ADDRESS><GROUP_ID type=\"string\"></GROUP_ID>");
		xmlBuffer
				.append("<CONTACT_ID type=\"long\"></CONTACT_ID><OP_CODE type=\"string\"></OP_CODE>");
		xmlBuffer
				.append("</OPR_INFO><BUSI_INFO_LIST><BUSI_INFO  type=\"node\">");
		xmlBuffer.append(dynParams);
		xmlBuffer.append("</BUSI_INFO></BUSI_INFO_LIST></REQUEST_INFO></Root>");
		return xmlBuffer.toString();
	}
	
	/**
	 * 传入报文ROOT_DISTANCE和group_id  查询组织机构相应深度下的组织机构
	 * CURRENT_LEVEL：group_id与查询结果中组织的距离
	 */
	public MBean getGroupByDistance(MBean bean) throws Exception{
		System.out.println("+++++++++++++++++++getGroupByDistance+++++++++++++++++++++++");
		String group_id = bean.getBodyStr("groupId");
		String root_distance = bean.getBodyStr("rootDistance");
		
		MBean groupBean = new MBean();
		if ("mobile".equals(carrierId)) {
			String dynParam = "<GROUP_ID type=\"string\">"
					+ group_id
					+ "</GROUP_ID ><ROOT_DISTANCE type=\"string\">"+root_distance+"</ROOT_DISTANCE><IS_ACTIVE type=\"string\">Y</IS_ACTIVE>"
					+ "<IS_AGENT></IS_AGENT><IS_TOWN></IS_TOWN><CLASS_CODE></CLASS_CODE><CLASS_KIND></CLASS_KIND>";
			String xmlParam = getInputParams(dynParam);
			System.out.println("**************xmlParam:"+xmlParam);
			try {
				Map map = ServiceUtil.callService("sGroupTree", xmlParam);
				MapBean mapBean = new MapBean(map);
				List list = mapBean.getList("OUT_DATA.BUSI_INFO");
				if (list != null && list.size() > 0) {
					Map resultMap = (Map) list.get(0);
					//group.setGroupId((String) resultMap.get("GROUP_ID"));
					//group.setParentGroupId((String) resultMap.get("PARENT_GROUP_ID")==null?"":(String) resultMap.get("PARENT_GROUP_ID"));
					//group.setGroupName((String) resultMap.get("GROUP_NAME"));
					// 距离
					//group.setCurrentLevel((String) resultMap.get("CURRENT_LEVEL"));
					groupBean.setBody("groupId", (String) resultMap.get("PARENT_GROUP_ID")==null?"":(String) resultMap.get("PARENT_GROUP_ID"));
					groupBean.setBody("parentGroupId", (String) resultMap.get("PARENT_GROUP_ID")==null?"":(String) resultMap.get("PARENT_GROUP_ID"));
					groupBean.setBody("groupName", (String) resultMap.get("GROUP_NAME"));
					groupBean.setBody("currentLevel", (String) resultMap.get("CURRENT_LEVEL"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return groupBean;
	}
	
	
	public MBean getSubmitSource(MBean bean)throws Exception{
		return null;
	}

	public List getSubGroups(String groupId,String province_center) {
		List groupList = new ArrayList();
		if ("mobile".equals(carrierId)) {// 判断版本
			if("10014".equals(province_center)){
				String dynParam = "<GROUP_ID type=\"string\">"
						+ groupId
						+ "</GROUP_ID ><ROOT_DISTANCE type=\"string\">B</ROOT_DISTANCE><IS_ACTIVE type=\"string\">Y</IS_ACTIVE>"
						+ "<IS_AGENT type=\"string\"></IS_AGENT><IS_TOWN type=\"string\"></IS_TOWN><CLASS_CODE type=\"string\"></CLASS_CODE><CLASS_KIND type=\"string\"></CLASS_KIND>";
				String xmlParam = getInputParams(dynParam);
				System.out.println("InputXML=" + xmlParam);
				try {
					Map map = ServiceUtil.callService("sGroupCity", xmlParam);
					MapBean bean = new MapBean(map);
					List list = bean.getList("OUT_DATA.BUSI_INFO");
					Map resultMap = new HashMap();
					for (Iterator it = list.iterator(); it.hasNext();) {
						resultMap = (HashMap) it.next();
						String childId = (String) resultMap.get("GROUP_ID");
						String childName = (String) resultMap.get("GROUP_NAME");
						Map group = new HashMap();
						//group.setGroupId("10031");
						//group.setGroupName("哈尔滨");					
						group.put("groupId",childId);
						group.put("groupName",childName);
						groupList.add(group);
						resultMap = null;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				String dynParam = "<GROUP_ID type=\"string\">"
					+ groupId
					+ "</GROUP_ID ><ROOT_DISTANCE type=\"string\">B</ROOT_DISTANCE><IS_ACTIVE type=\"string\">Y</IS_ACTIVE>"
					+ "<IS_AGENT type=\"string\"></IS_AGENT><IS_TOWN type=\"string\"></IS_TOWN><CLASS_CODE type=\"string\"></CLASS_CODE><CLASS_KIND type=\"string\"></CLASS_KIND>";
				String xmlParam = getInputParams(dynParam);
				System.out.println("InputXML=" + xmlParam);
				try {
					Map map = ServiceUtil.callService("sGroupCity", xmlParam);
				//	String xmlString="<?xml version=\"1.0\" encoding=\"GBK\"?><ROOT><RETURN_CODE type=\"long\">0</RETURN_CODE><RETURN_MSG type=\"string\">ok!</RETURN_MSG><USER_MSG type=\"string\">ok!</USER_MSG><DETAIL_MSG type=\"string\">OK!</DETAIL_MSG><PROMPT_MSG type=\"string\"/><OUT_DATA><BUSI_INFO><GROUP_ID type=\"string\">122000001</GROUP_ID><PARENT_GROUP_ID type=\"string\">122000000</PARENT_GROUP_ID><DENORM_LEVEL type=\"int\">1</DENORM_LEVEL><PARENT_LEVEL type=\"long\">2</PARENT_LEVEL><CURRENT_LEVEL type=\"long\">3</CURRENT_LEVEL><GROUP_NAME type=\"string\">滁州市</GROUP_NAME><ROOT_DISTANCE type=\"int\">3</ROOT_DISTANCE><HAS_CHILD type=\"string\">Y</HAS_CHILD><QUERY_INDEX type=\"int\">-1</QUERY_INDEX><BUREAU_CODE type=\"string\">X</BUREAU_CODE><BOSS_ORG_CODE type=\"string\">NULL</BOSS_ORG_CODE><FIRST_CLASS_CODE type=\"string\">NULL</FIRST_CLASS_CODE><CLASS_CODE type=\"string\">431</CLASS_CODE><IS_ACTIVE type=\"string\">Y</IS_ACTIVE><CITY_GRADE_CODE type=\"string\">1</CITY_GRADE_CODE><CREATE_TIME type=\"string\">20010722105655</CREATE_TIME><GRADE_CODE type=\"string\">01</GRADE_CODE><DESCRIBE type=\"string\">SYS</DESCRIBE><CREDIT type=\"string\">0</CREDIT><BAIL type=\"double\">0.000000</BAIL><BUSINESS_HOURS type=\"string\">NULL</BUSINESS_HOURS><OPEN_DATE type=\"string\">19000101000000</OPEN_DATE><PHONE type=\"string\">NULL</PHONE><FAX type=\"string\">NULL</FAX><LAYER_CODE type=\"string\">3</LAYER_CODE><MAP type=\"string\">NULL</MAP><ACTIVE_TIME type=\"string\">20010722105655</ACTIVE_TIME><INVALID_TIME type=\"string\">20991231235959</INVALID_TIME><AUDIT_FLAG type=\"string\">Y</AUDIT_FLAG><AUDIT_STATUS type=\"string\">1</AUDIT_STATUS><AUDIT_TIME type=\"string\">20010722105655</AUDIT_TIME><ERP_CODE type=\"string\">NULL</ERP_CODE><REGION_ID type=\"int\">22</REGION_ID><LOGIN_PREFIX type=\"string\">M0</LOGIN_PREFIX><TOWN_ADDRESS type=\"string\"/><SERVICE_CONTENT type=\"string\"/><CREATE_LOGIN type=\"string\">ADMIN0</CREATE_LOGIN><TWO_DIMENSIONAL_CODE type=\"string\"/><GIVEOUT_FLAG type=\"string\">Y</GIVEOUT_FLAG></BUSI_INFO><BUSI_INFO><GROUP_ID type=\"string\">122000002</GROUP_ID><PARENT_GROUP_ID type=\"string\">122000000</PARENT_GROUP_ID><DENORM_LEVEL type=\"int\">1</DENORM_LEVEL><PARENT_LEVEL type=\"long\">2</PARENT_LEVEL><CURRENT_LEVEL type=\"long\">3</CURRENT_LEVEL><GROUP_NAME type=\"string\">来安县</GROUP_NAME><ROOT_DISTANCE type=\"int\">3</ROOT_DISTANCE><HAS_CHILD type=\"string\">Y</HAS_CHILD><QUERY_INDEX type=\"int\">-1</QUERY_INDEX><BUREAU_CODE type=\"string\">X</BUREAU_CODE><BOSS_ORG_CODE type=\"string\">NULL</BOSS_ORG_CODE><FIRST_CLASS_CODE type=\"string\">NULL</FIRST_CLASS_CODE><CLASS_CODE type=\"string\">431</CLASS_CODE><IS_ACTIVE type=\"string\">Y</IS_ACTIVE><CITY_GRADE_CODE type=\"string\">1</CITY_GRADE_CODE><CREATE_TIME type=\"string\">20010722105655</CREATE_TIME><GRADE_CODE type=\"string\">01</GRADE_CODE><DESCRIBE type=\"string\">SYS</DESCRIBE><CREDIT type=\"string\">0</CREDIT><BAIL type=\"double\">0.000000</BAIL><BUSINESS_HOURS type=\"string\">NULL</BUSINESS_HOURS><OPEN_DATE type=\"string\">19000101000000</OPEN_DATE><PHONE type=\"string\">NULL</PHONE><FAX type=\"string\">NULL</FAX><LAYER_CODE type=\"string\">3</LAYER_CODE><MAP type=\"string\">NULL</MAP><ACTIVE_TIME type=\"string\">20010722105655</ACTIVE_TIME><INVALID_TIME type=\"string\">20991231235959</INVALID_TIME><AUDIT_FLAG type=\"string\">Y</AUDIT_FLAG><AUDIT_STATUS type=\"string\">1</AUDIT_STATUS><AUDIT_TIME type=\"string\">20010722105655</AUDIT_TIME><ERP_CODE type=\"string\">NULL</ERP_CODE><REGION_ID type=\"int\">22</REGION_ID><LOGIN_PREFIX type=\"string\">M1</LOGIN_PREFIX><TOWN_ADDRESS type=\"string\"/><SERVICE_CONTENT type=\"string\"/><CREATE_LOGIN type=\"string\">ADMIN0</CREATE_LOGIN><TWO_DIMENSIONAL_CODE type=\"string\"/><GIVEOUT_FLAG type=\"string\">Y</GIVEOUT_FLAG></BUSI_INFO><BUSI_INFO><GROUP_ID type=\"string\">122000003</GROUP_ID><PARENT_GROUP_ID type=\"string\">122000000</PARENT_GROUP_ID><DENORM_LEVEL type=\"int\">1</DENORM_LEVEL><PARENT_LEVEL type=\"long\">2</PARENT_LEVEL><CURRENT_LEVEL type=\"long\">3</CURRENT_LEVEL><GROUP_NAME type=\"string\">全椒县</GROUP_NAME><ROOT_DISTANCE type=\"int\">3</ROOT_DISTANCE><HAS_CHILD type=\"string\">Y</HAS_CHILD><QUERY_INDEX type=\"int\">-1</QUERY_INDEX><BUREAU_CODE type=\"string\">X</BUREAU_CODE><BOSS_ORG_CODE type=\"string\">NULL</BOSS_ORG_CODE><FIRST_CLASS_CODE type=\"string\">NULL</FIRST_CLASS_CODE><CLASS_CODE type=\"string\">431</CLASS_CODE><IS_ACTIVE type=\"string\">Y</IS_ACTIVE><CITY_GRADE_CODE type=\"string\">1</CITY_GRADE_CODE><CREATE_TIME type=\"string\">20010722105655</CREATE_TIME><GRADE_CODE type=\"string\">01</GRADE_CODE><DESCRIBE type=\"string\">SYS</DESCRIBE><CREDIT type=\"string\">0</CREDIT><BAIL type=\"double\">0.000000</BAIL><BUSINESS_HOURS type=\"string\">NULL</BUSINESS_HOURS><OPEN_DATE type=\"string\">19000101000000</OPEN_DATE><PHONE type=\"string\">NULL</PHONE><FAX type=\"string\">NULL</FAX><LAYER_CODE type=\"string\">3</LAYER_CODE><MAP type=\"string\">NULL</MAP><ACTIVE_TIME type=\"string\">20010722105655</ACTIVE_TIME><INVALID_TIME type=\"string\">20991231235959</INVALID_TIME><AUDIT_FLAG type=\"string\">Y</AUDIT_FLAG><AUDIT_STATUS type=\"string\">1</AUDIT_STATUS><AUDIT_TIME type=\"string\">20010722105655</AUDIT_TIME><ERP_CODE type=\"string\">NULL</ERP_CODE><REGION_ID type=\"int\">22</REGION_ID><LOGIN_PREFIX type=\"string\">M2</LOGIN_PREFIX><TOWN_ADDRESS type=\"string\"/><SERVICE_CONTENT type=\"string\"/><CREATE_LOGIN type=\"string\">ADMIN0</CREATE_LOGIN><TWO_DIMENSIONAL_CODE type=\"string\"/><GIVEOUT_FLAG type=\"string\">Y</GIVEOUT_FLAG></BUSI_INFO><BUSI_INFO><GROUP_ID type=\"string\">122000004</GROUP_ID><PARENT_GROUP_ID type=\"string\">122000000</PARENT_GROUP_ID><DENORM_LEVEL type=\"int\">1</DENORM_LEVEL><PARENT_LEVEL type=\"long\">2</PARENT_LEVEL><CURRENT_LEVEL type=\"long\">3</CURRENT_LEVEL><GROUP_NAME type=\"string\">定远县</GROUP_NAME><ROOT_DISTANCE type=\"int\">3</ROOT_DISTANCE><HAS_CHILD type=\"string\">Y</HAS_CHILD><QUERY_INDEX type=\"int\">-1</QUERY_INDEX><BUREAU_CODE type=\"string\">X</BUREAU_CODE><BOSS_ORG_CODE type=\"string\">NULL</BOSS_ORG_CODE><FIRST_CLASS_CODE type=\"string\">NULL</FIRST_CLASS_CODE><CLASS_CODE type=\"string\">431</CLASS_CODE><IS_ACTIVE type=\"string\">Y</IS_ACTIVE><CITY_GRADE_CODE type=\"string\">1</CITY_GRADE_CODE><CREATE_TIME type=\"string\">20010722105655</CREATE_TIME><GRADE_CODE type=\"string\">01</GRADE_CODE><DESCRIBE type=\"string\">SYS</DESCRIBE><CREDIT type=\"string\">0</CREDIT><BAIL type=\"double\">0.000000</BAIL><BUSINESS_HOURS type=\"string\">NULL</BUSINESS_HOURS><OPEN_DATE type=\"string\">19000101000000</OPEN_DATE><PHONE type=\"string\">NULL</PHONE><FAX type=\"string\">NULL</FAX><LAYER_CODE type=\"string\">3</LAYER_CODE><MAP type=\"string\">NULL</MAP><ACTIVE_TIME type=\"string\">20010722105655</ACTIVE_TIME><INVALID_TIME type=\"string\">20991231235959</INVALID_TIME><AUDIT_FLAG type=\"string\">Y</AUDIT_FLAG><AUDIT_STATUS type=\"string\">1</AUDIT_STATUS><AUDIT_TIME type=\"string\">20010722105655</AUDIT_TIME><ERP_CODE type=\"string\">NULL</ERP_CODE><REGION_ID type=\"int\">22</REGION_ID><LOGIN_PREFIX type=\"string\">M3</LOGIN_PREFIX><TOWN_ADDRESS type=\"string\"/><SERVICE_CONTENT type=\"string\"/><CREATE_LOGIN type=\"string\">ADMIN0</CREATE_LOGIN><TWO_DIMENSIONAL_CODE type=\"string\"/><GIVEOUT_FLAG type=\"string\">Y</GIVEOUT_FLAG></BUSI_INFO><BUSI_INFO><GROUP_ID type=\"string\">122000005</GROUP_ID><PARENT_GROUP_ID type=\"string\">122000000</PARENT_GROUP_ID><DENORM_LEVEL type=\"int\">1</DENORM_LEVEL><PARENT_LEVEL type=\"long\">2</PARENT_LEVEL><CURRENT_LEVEL type=\"long\">3</CURRENT_LEVEL><GROUP_NAME type=\"string\">凤阳县</GROUP_NAME><ROOT_DISTANCE type=\"int\">3</ROOT_DISTANCE><HAS_CHILD type=\"string\">Y</HAS_CHILD><QUERY_INDEX type=\"int\">-1</QUERY_INDEX><BUREAU_CODE type=\"string\">X</BUREAU_CODE><BOSS_ORG_CODE type=\"string\">NULL</BOSS_ORG_CODE><FIRST_CLASS_CODE type=\"string\">NULL</FIRST_CLASS_CODE><CLASS_CODE type=\"string\">431</CLASS_CODE><IS_ACTIVE type=\"string\">Y</IS_ACTIVE><CITY_GRADE_CODE type=\"string\">1</CITY_GRADE_CODE><CREATE_TIME type=\"string\">20010722105655</CREATE_TIME><GRADE_CODE type=\"string\">01</GRADE_CODE><DESCRIBE type=\"string\">SYS</DESCRIBE><CREDIT type=\"string\">0</CREDIT><BAIL type=\"double\">0.000000</BAIL><BUSINESS_HOURS type=\"string\">NULL</BUSINESS_HOURS><OPEN_DATE type=\"string\">19000101000000</OPEN_DATE><PHONE type=\"string\">NULL</PHONE><FAX type=\"string\">NULL</FAX><LAYER_CODE type=\"string\">3</LAYER_CODE><MAP type=\"string\">NULL</MAP><ACTIVE_TIME type=\"string\">20010722105655</ACTIVE_TIME><INVALID_TIME type=\"string\">20991231235959</INVALID_TIME><AUDIT_FLAG type=\"string\">Y</AUDIT_FLAG><AUDIT_STATUS type=\"string\">1</AUDIT_STATUS><AUDIT_TIME type=\"string\">20010722105655</AUDIT_TIME><ERP_CODE type=\"string\">NULL</ERP_CODE><REGION_ID type=\"int\">22</REGION_ID><LOGIN_PREFIX type=\"string\">M4</LOGIN_PREFIX><TOWN_ADDRESS type=\"string\"/><SERVICE_CONTENT type=\"string\"/><CREATE_LOGIN type=\"string\">ADMIN0</CREATE_LOGIN><TWO_DIMENSIONAL_CODE type=\"string\"/><GIVEOUT_FLAG type=\"string\">Y</GIVEOUT_FLAG></BUSI_INFO><BUSI_INFO><GROUP_ID type=\"string\">122000006</GROUP_ID><PARENT_GROUP_ID type=\"string\">122000000</PARENT_GROUP_ID><DENORM_LEVEL type=\"int\">1</DENORM_LEVEL><PARENT_LEVEL type=\"long\">2</PARENT_LEVEL><CURRENT_LEVEL type=\"long\">3</CURRENT_LEVEL><GROUP_NAME type=\"string\">明光市</GROUP_NAME><ROOT_DISTANCE type=\"int\">3</ROOT_DISTANCE><HAS_CHILD type=\"string\">Y</HAS_CHILD><QUERY_INDEX type=\"int\">-1</QUERY_INDEX><BUREAU_CODE type=\"string\">X</BUREAU_CODE><BOSS_ORG_CODE type=\"string\">NULL</BOSS_ORG_CODE><FIRST_CLASS_CODE type=\"string\">NULL</FIRST_CLASS_CODE><CLASS_CODE type=\"string\">431</CLASS_CODE><IS_ACTIVE type=\"string\">Y</IS_ACTIVE><CITY_GRADE_CODE type=\"string\">1</CITY_GRADE_CODE><CREATE_TIME type=\"string\">20021225173629</CREATE_TIME><GRADE_CODE type=\"string\">01</GRADE_CODE><DESCRIBE type=\"string\">SYS</DESCRIBE><CREDIT type=\"string\">0</CREDIT><BAIL type=\"double\">0.000000</BAIL><BUSINESS_HOURS type=\"string\">NULL</BUSINESS_HOURS><OPEN_DATE type=\"string\">19000101000000</OPEN_DATE><PHONE type=\"string\">NULL</PHONE><FAX type=\"string\">NULL</FAX><LAYER_CODE type=\"string\">3</LAYER_CODE><MAP type=\"string\">NULL</MAP><ACTIVE_TIME type=\"string\">20021225173629</ACTIVE_TIME><INVALID_TIME type=\"string\">20991231235959</INVALID_TIME><AUDIT_FLAG type=\"string\">Y</AUDIT_FLAG><AUDIT_STATUS type=\"string\">1</AUDIT_STATUS><AUDIT_TIME type=\"string\">20021225173629</AUDIT_TIME><ERP_CODE type=\"string\">NULL</ERP_CODE><REGION_ID type=\"int\">22</REGION_ID><LOGIN_PREFIX type=\"string\">M5</LOGIN_PREFIX><TOWN_ADDRESS type=\"string\"/><SERVICE_CONTENT type=\"string\"/><CREATE_LOGIN type=\"string\">MZZZZ0012</CREATE_LOGIN><TWO_DIMENSIONAL_CODE type=\"string\"/><GIVEOUT_FLAG type=\"string\">Y</GIVEOUT_FLAG></BUSI_INFO><BUSI_INFO><GROUP_ID type=\"string\">122000007</GROUP_ID><PARENT_GROUP_ID type=\"string\">122000000</PARENT_GROUP_ID><DENORM_LEVEL type=\"int\">1</DENORM_LEVEL><PARENT_LEVEL type=\"long\">2</PARENT_LEVEL><CURRENT_LEVEL type=\"long\">3</CURRENT_LEVEL><GROUP_NAME type=\"string\">天长市</GROUP_NAME><ROOT_DISTANCE type=\"int\">3</ROOT_DISTANCE><HAS_CHILD type=\"string\">Y</HAS_CHILD><QUERY_INDEX type=\"int\">-1</QUERY_INDEX><BUREAU_CODE type=\"string\">X</BUREAU_CODE><BOSS_ORG_CODE type=\"string\">NULL</BOSS_ORG_CODE><FIRST_CLASS_CODE type=\"string\">NULL</FIRST_CLASS_CODE><CLASS_CODE type=\"string\">431</CLASS_CODE><IS_ACTIVE type=\"string\">Y</IS_ACTIVE><CITY_GRADE_CODE type=\"string\">1</CITY_GRADE_CODE><CREATE_TIME type=\"string\">20021225173643</CREATE_TIME><GRADE_CODE type=\"string\">01</GRADE_CODE><DESCRIBE type=\"string\">SYS</DESCRIBE><CREDIT type=\"string\">0</CREDIT><BAIL type=\"double\">0.000000</BAIL><BUSINESS_HOURS type=\"string\">NULL</BUSINESS_HOURS><OPEN_DATE type=\"string\">19000101000000</OPEN_DATE><PHONE type=\"string\">NULL</PHONE><FAX type=\"string\">NULL</FAX><LAYER_CODE type=\"string\">3</LAYER_CODE><MAP type=\"string\">NULL</MAP><ACTIVE_TIME type=\"string\">20021225173643</ACTIVE_TIME><INVALID_TIME type=\"string\">20991231235959</INVALID_TIME><AUDIT_FLAG type=\"string\">Y</AUDIT_FLAG><AUDIT_STATUS type=\"string\">1</AUDIT_STATUS><AUDIT_TIME type=\"string\">20021225173643</AUDIT_TIME><ERP_CODE type=\"string\">NULL</ERP_CODE><REGION_ID type=\"int\">22</REGION_ID><LOGIN_PREFIX type=\"string\">M6</LOGIN_PREFIX><TOWN_ADDRESS type=\"string\"/><SERVICE_CONTENT type=\"string\"/><CREATE_LOGIN type=\"string\">MZZZZ0012</CREATE_LOGIN><TWO_DIMENSIONAL_CODE type=\"string\"/><GIVEOUT_FLAG type=\"string\">Y</GIVEOUT_FLAG></BUSI_INFO></OUT_DATA></ROOT>";
				//	MapBean bean=ServiceUtil1.getMapBeanFromXml(xmlString, true);
					MapBean bean = new MapBean(map);
					List list = bean.getList("OUT_DATA.BUSI_INFO");
					Map resultMap = new HashMap();
					for (Iterator it = list.iterator(); it.hasNext();) {
						resultMap = (HashMap) it.next();
						String childId = (String) resultMap.get("GROUP_ID");
						String childName = (String) resultMap.get("GROUP_NAME");
						String regionCode = getRegionPartitionRel((String) resultMap.get("REGION_ID"),province_center);
						// 查询地市时region_id可以作为地市region_code存在
						Map group = new HashMap();
						group.put("groupId",childId);
						group.put("groupName",childName);
						group.put("regionCode",regionCode);
						groupList.add(group);
						resultMap = null;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} 
		//山西目前只是移动的没有电信的
		/*else if ("teleCom".equals(carrierId)) {
			List sqllist = new ArrayList();
			String sql = "";
			if (com.sitech.util.CityUtil.isAllCity(groupId)) {
				sql = "Select region_code,region_name from mk_regioncode_dict where region_code <> '000'";
			} else {
				sql = "Select org_id,org_name,Case When org_no='551' Then '0' Else  org_no End As sqe From t_bp_acl_org Where parent_orgid = "
						+ groupId + " Order By sqe  ";
			}
			sqllist = DBUtil.getStrsList(sql);
			int len = sqllist.size();
			if (len == 0) {
				sql = "Select org_id,org_name,Case When org_no='551' Then '0' Else  org_no End As sqe From t_bp_acl_org Where org_id = "
						+ groupId + " Order By sqe  ";
				sqllist = DBUtil.getStrsList(sql);
				len = sqllist.size();
			}
			for (int i = 0; i < len; i++) {
				String[] str = (String[]) sqllist.get(i);
				Map group = new HashMap();
				group.put("groupId",str[0]);
				group.put("groupName",str[1]);
				groupList.add(group);
			}
		}*/
		return groupList;
	}


	

	@SuppressWarnings("unchecked")
	public List getGroupTown_Agent(String groupId, boolean isAgent,
			boolean isTown) throws Exception{
		String townFlag = "Y";
		String agentFlag = "";
		if (isAgent && isTown) {
			agentFlag = "A";
		} else if (!isAgent && isTown) {
			agentFlag = "N";
		} else if (isAgent && !isTown) {
			agentFlag = "Y";
		} else {
			agentFlag = "A";
		}

		String dynParam = "<GROUP_ID type=\"string\">" + groupId
				+ "</GROUP_ID ><IS_ACTIVE type=\"string\">Y</IS_ACTIVE>"
				+ "<IS_AGENT type=\"string\">" + agentFlag
				+ "</IS_AGENT><IS_TOWN type=\"string\">" + townFlag
				+ "</IS_TOWN>";
		String xmlParam = getInputParams(dynParam);
		System.out.println(xmlParam);
		List groupList = new ArrayList();
		try{
			// Map map = ServiceUtil.callService("sGroupTown", xmlParam);
		    // 铁通融合项目，能查询到移动和铁通的营业厅，修改服务sGroupTown——> sAllGroupTown
			 Map map = ServiceUtil.callService("sAllGroupTown", xmlParam);
			MapBean bean = new MapBean(map);
			List list = bean.getList("OUT_DATA.BUSI_INFO");
			Map resultMap = new HashMap();
			for (Iterator it = list.iterator(); it.hasNext();) {
				resultMap = (HashMap) it.next();
				String is_town = (String) resultMap.get("IS_TOWN");
				String is_agent = (String) resultMap.get("IS_AGENT");
				String childId = (String) resultMap.get("GROUP_ID");
				String childName = (String) resultMap.get("GROUP_NAME");
				if("Y".equalsIgnoreCase(is_town)){
					Map group = new HashMap();
					group.put("groupId",childId);
					group.put("groupName",childName);
					group.put("flag",is_agent);
					groupList.add(group);
				}
				resultMap = null;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return groupList;
	}
	
	@SuppressWarnings("unchecked")
	public List getGroupTown_Agents(String groupId, boolean isAgent,
			boolean isTown,String selectIds) throws Exception{
		String townFlag = "Y";
		String agentFlag = "";
		if (isAgent && isTown) {
			agentFlag = "A";
		} else if (!isAgent && isTown) {
			agentFlag = "N";
		} else if (isAgent && !isTown) {
			agentFlag = "Y";
		} else {
			agentFlag = "A";
		}

		String dynParam = "<GROUP_ID type=\"string\">" + groupId
				+ "</GROUP_ID ><IS_ACTIVE type=\"string\">Y</IS_ACTIVE>"
				+ "<IS_AGENT type=\"string\">" + agentFlag
				+ "</IS_AGENT><IS_TOWN type=\"string\">" + townFlag
				+ "</IS_TOWN><CHN_IDS type=\"string\">"+selectIds+"</CHN_IDS>";
		String xmlParam = getInputParams(dynParam);
		System.out.println("@@sMarkGroupNew "+xmlParam);
		List groupList = new ArrayList();
		try{
			//String str = "<?xml version=\"1.0\" encoding=\"GBK\"?><ROOT><RETURN_CODE type=\"long\">0</RETURN_CODE><RETURN_MSG type=\"string\">操作成功</RETURN_MSG><DETAIL_MSG type=\"string\">◎阿城区四海通讯营业厅</DETAIL_MSG><OUT_DATA><BUSI_INFO><GROUP_ID type=\"string\">355434</GROUP_ID><GROUP_NAME type=\"string\">◎哈尔滨市阿城区玉泉中国移动天枢指定专营店</GROUP_NAME></BUSI_INFO><BUSI_INFO><GROUP_ID type=\"string\">354477</GROUP_ID><GROUP_NAME type=\"string\">◎哈尔滨市阿城鑫民权通讯便利店</GROUP_NAME></BUSI_INFO><BUSI_INFO><GROUP_ID type=\"string\">361935</GROUP_ID><GROUP_NAME type=\"string\">◎哈尔滨市阿城区交界镇亚芝通讯服务部</GROUP_NAME></BUSI_INFO></OUT_DATA></ROOT>";
			//MapBean bean =ServiceUtil1.getMapBeanFromXml(str,true);
		
			Map map = ServiceUtil.callService("sMarkGroupNew", xmlParam);
			MapBean bean = new MapBean(map);
			List list = bean.getList("OUT_DATA.BUSI_INFO");
			Map resultMap = new HashMap();
			for (Iterator it = list.iterator(); it.hasNext();) {
				resultMap = (HashMap) it.next();
				String is_town = (String) resultMap.get("IS_TOWN");
				String is_agent = (String) resultMap.get("IS_AGENT");
				String childId = (String) resultMap.get("GROUP_ID");
				String childName = (String) resultMap.get("GROUP_NAME");
				//if("Y".equalsIgnoreCase(is_town)){
					Map group = new HashMap();
					group.put("groupId",childId);
					group.put("groupName",childName);
				//	group.setFlag(is_agent);
					groupList.add(group);
				//}
				resultMap = null;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return groupList;
	}


	//Add By Linxy20100109
	@SuppressWarnings("unchecked")
	public List getManager(String groupId,String positionCode) throws Exception{
		String dynParam = "<GROUP_ID type=\"string\">" + groupId +"</GROUP_ID>" +
				"<LOGIN_NO type=\"string\"></LOGIN_NO>" +
				"<LOGIN_NAME type=\"string\"></LOGIN_NAME>" +
				"<VALID_FLAG type=\"string\">Y</VALID_FLAG>" +
				"<PAGE_NUM type=\"int\">0</PAGE_NUM>" +
				"<PAGE_AMOUNT type=\"int\">1</PAGE_AMOUNT>" +
				"<BOSS_POSITION_CODE type=\"string\">" + positionCode + "</BOSS_POSITION_CODE>";
		String xmlParam = getInputParams(dynParam);
		System.out.println("linxy_xmlParam=" + xmlParam);
		List groupList = new ArrayList();
		Map map = ServiceUtil.callService("sGrpLoginQry", xmlParam);
		MapBean bean = new MapBean(map);
		//String str = "<?xml version=\"1.0\" encoding=\"GBK\"?><ROOT><RETURN_CODE type=\"long\">0</RETURN_CODE><RETURN_MSG type=\"string\">ok!</RETURN_MSG><USER_MSG type=\"string\">ok!</USER_MSG><DETAIL_MSG type=\"string\">OK!</DETAIL_MSG><PROMPT_MSG type=\"string\"/><OUT_DATA><COUNT_NUM type=\"int\">8</COUNT_NUM><PAGE_COUNT type=\"int\">1</PAGE_COUNT><PAGE_NUM type=\"int\">1</PAGE_NUM><PAGE_AMOUNT type=\"int\">20</PAGE_AMOUNT><DATA_LIST><DATA><ROW_NUM type=\"int\">1</ROW_NUM><LOGIN_NO type=\"string\">MZZZZZ061</LOGIN_NO><STAFF_ID type=\"string\">34504057</STAFF_ID><LOGIN_NAME type=\"string\">骆媛</LOGIN_NAME><LOGIN_FLAG type=\"string\">0</LOGIN_FLAG><DEPT_CODE type=\"string\">null</DEPT_CODE><GROUP_ID type=\"string\">122000000</GROUP_ID><ORG_GROUP type=\"string\">null</ORG_GROUP><OP_TIME type=\"string\">20100315103603</OP_TIME><RELOGIN_FLAG type=\"string\">Y</RELOGIN_FLAG><ALLOW_BEGIN type=\"string\">000000</ALLOW_BEGIN><ALLOW_END type=\"string\">235959</ALLOW_END><PASS_TIME type=\"string\">20130422111702</PASS_TIME><EXPIRE_TIME type=\"string\">20991219000000</EXPIRE_TIME><MODIFY_PASSWD_INTERVAL type=\"int\">9000</MODIFY_PASSWD_INTERVAL><TRY_TIMES type=\"int\">0</TRY_TIMES><VALID_FLAG type=\"string\">Y</VALID_FLAG><MAINTAIN_FLAG type=\"string\">0</MAINTAIN_FLAG><LOGIN_STATUS type=\"string\">0</LOGIN_STATUS><CONTACT_PHONE type=\"string\">13866522161</CONTACT_PHONE><SENDPWD_FLAG type=\"string\">N</SENDPWD_FLAG><MAX_ERRNUM type=\"int\">5</MAX_ERRNUM><LOGIN_TYPE type=\"string\">0</LOGIN_TYPE><POWER_RIGHT type=\"int\">22</POWER_RIGHT><GROUP_NAME type=\"string\">滁州</GROUP_NAME><MAC_ADDRESS type=\"string\"/><CREATE_TIME type=\"string\">20060402000000</CREATE_TIME><DESTROY_TIME type=\"string\">20131119150004</DESTROY_TIME><BOSS_POSITION_CODE type=\"string\">1011</BOSS_POSITION_CODE><POSITION_CODE type=\"string\">1011</POSITION_CODE><POSITION_NAME type=\"string\">营业员</POSITION_NAME></DATA><DATA><ROW_NUM type=\"int\">2</ROW_NUM><LOGIN_NO type=\"string\">MZZZZZ061</LOGIN_NO><STAFF_ID type=\"string\">34504057</STAFF_ID><LOGIN_NAME type=\"string\">骆媛</LOGIN_NAME><LOGIN_FLAG type=\"string\">0</LOGIN_FLAG><DEPT_CODE type=\"string\">null</DEPT_CODE><GROUP_ID type=\"string\">122000000</GROUP_ID><ORG_GROUP type=\"string\">null</ORG_GROUP><OP_TIME type=\"string\">20100315103603</OP_TIME><RELOGIN_FLAG type=\"string\">Y</RELOGIN_FLAG><ALLOW_BEGIN type=\"string\">000000</ALLOW_BEGIN><ALLOW_END type=\"string\">235959</ALLOW_END><PASS_TIME type=\"string\">20130422111702</PASS_TIME><EXPIRE_TIME type=\"string\">20991219000000</EXPIRE_TIME><MODIFY_PASSWD_INTERVAL type=\"int\">9000</MODIFY_PASSWD_INTERVAL><TRY_TIMES type=\"int\">0</TRY_TIMES><VALID_FLAG type=\"string\">Y</VALID_FLAG><MAINTAIN_FLAG type=\"string\">0</MAINTAIN_FLAG><LOGIN_STATUS type=\"string\">0</LOGIN_STATUS><CONTACT_PHONE type=\"string\">13866522161</CONTACT_PHONE><SENDPWD_FLAG type=\"string\">N</SENDPWD_FLAG><MAX_ERRNUM type=\"int\">5</MAX_ERRNUM><LOGIN_TYPE type=\"string\">0</LOGIN_TYPE><POWER_RIGHT type=\"int\">22</POWER_RIGHT><GROUP_NAME type=\"string\">滁州</GROUP_NAME><MAC_ADDRESS type=\"string\"/><CREATE_TIME type=\"string\">20060402000000</CREATE_TIME><DESTROY_TIME type=\"string\">20131119150004</DESTROY_TIME><BOSS_POSITION_CODE type=\"string\">1011</BOSS_POSITION_CODE><POSITION_CODE type=\"string\">1011</POSITION_CODE><POSITION_NAME type=\"string\">营业员</POSITION_NAME></DATA></DATA_LIST></OUT_DATA></ROOT>";
		//MapBean bean =ServiceUtil1.getMapBeanFromXml(str,true);
		String returnCode = bean.getString("RETURN_CODE");
		if (!"0".equals(returnCode)) {
			String returnMsg = bean.getString("RETURN_MSG");
			String detailMsg = bean.getString("DETAIL_MSG");
			String errorMsg = "【" + returnCode + "】" + returnMsg + "（" + detailMsg + "）";
			System.err.println("取客户经理错误信息：" + errorMsg);
			throw new Exception(detailMsg);
		}
		List list = bean.getList("OUT_DATA.DATA_LIST.DATA");
		Map resultMap = new HashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			resultMap = (HashMap) it.next();
			String login_no = (String) resultMap.get("LOGIN_NO");
			String login_name = (String) resultMap.get("LOGIN_NAME");
			String valid_flag_S = (String) resultMap.get("VALID_FLAG");
			Map operator = new HashMap();
			operator.put("operNo", login_no);
			operator.put("operName", login_name);
			operator.put("validFlag", valid_flag_S);
			//Operator operator = new Operator(login_no, login_name, valid_flag_S.equals("Y") ? true : false);
			groupList.add(operator);
			resultMap = null;
		}

		return groupList;
	}

	@Override
	public List getRoleList(String login_no) throws Exception {
		String xmlParam = "<?xml version=\"1.0\" encoding=\"GBK\" standalone=\"no\" ?><Root><REQUEST_INFO  type=\"node\"><BUSI_INFO_LIST type=\"node\"><BUSI_INFO type=\"node\"><LOGIN_NO type=\"string\">" + login_no + "</LOGIN_NO></BUSI_INFO></BUSI_INFO_LIST></REQUEST_INFO></Root>";
		System.out.println(xmlParam);
		Map map = ServiceUtil.callService("sLoginRolQry", xmlParam);
		MapBean bean = new MapBean(map);
		String returnCode = bean.getString("RETURN_CODE");
		if (!"0".equals(returnCode)) {
			String returnMsg = bean.getString("RETURN_MSG");
			String detailMsg = bean.getString("DETAIL_MSG");
			String errorMsg = "【" + returnCode + "】" + returnMsg + "（" + detailMsg + "）";
			System.err.println("取角色错误信息：" + errorMsg);
			throw new Exception(detailMsg);
		}
		List roleList = new ArrayList();
		List list = bean.getList("OUT_DATA.DATA");
		Map resultMap = new HashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			resultMap = (HashMap) it.next();
			String role_code = (String) resultMap.get("ROLE_CODE");
			String role_name = (String) resultMap.get("ROLE_NAME");
			String begin_date = (String) resultMap.get("BEGIN_DATE");
			String end_date = (String) resultMap.get("END_DATE");
			Map role = new HashMap();
			role.put("operNo", login_no);
			role.put("roleCode",role_code );
			role.put("roleName", role_name);
			role.put("startDate", begin_date);
			role.put("endDate", end_date);
			//Role(login_no,role_code,role_name,begin_date,end_date);
			System.out.println(role);
			roleList.add(role);
		}
		return roleList;
	}
	/**
	 * 传入报文ROOT_DISTANCE为2  查询组织机构所属地市
	 */
	public Map getRegion(String groupId) throws Exception{
		Map group = new HashMap();
		if ("mobile".equals(carrierId)) {
			String dynParam = "<GROUP_ID type=\"string\">"
					+ groupId
					+ "</GROUP_ID ><ROOT_DISTANCE type=\"string\">2</ROOT_DISTANCE><IS_ACTIVE type=\"string\">Y</IS_ACTIVE>"
					+ "<IS_AGENT></IS_AGENT><IS_TOWN></IS_TOWN><CLASS_CODE></CLASS_CODE><CLASS_KIND></CLASS_KIND>";
			String xmlParam = getInputParams(dynParam);
			try {
				Map map = ServiceUtil.callService("sGroupTree", xmlParam);
				MapBean bean = new MapBean(map);
				List list = bean.getList("OUT_DATA.BUSI_INFO");
				if (list != null && list.size() > 0) {
					Map resultMap = (HashMap) list.get(0);
					if((String) resultMap.get("PARENT_GROUP_ID")==null){
						group.put("groupId",(String) resultMap.get("GROUP_ID"));
					}else{
						group.put("groupId",(String) resultMap.get("PARENT_GROUP_ID"));
					}
					group.put("groupName",(String) resultMap.get("GROUP_NAME"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return group;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List getSpecialRoleList(String groupId, String roleCode)
			throws Exception {
		int numPerPage = 100000;
		String dynParam = "<GROUP_ID type=\"string\">" + groupId + "</GROUP_ID>"
				+ "<LOGIN_NO type=\"string\"></LOGIN_NO>"
				+ "<LOGIN_NAME type=\"string\"></LOGIN_NAME>"
				+ "<VALID_FLAG type=\"string\">Y</VALID_FLAG>"
				+ "<PAGE_NUM type=\"int\">1</PAGE_NUM>"
				+ "<PAGE_AMOUNT type=\"int\">" + numPerPage + "</PAGE_AMOUNT>"
				+ "<ROLE_CODE type=\"string\">" + roleCode + "</ROLE_CODE>";
		String xmlParam = getInputParams(dynParam);
		System.out.println(xmlParam);
		Map map = ServiceUtil.callService("sLogGrpRole", xmlParam);
		MapBean bean = new MapBean(map);
		String returnCode = bean.getString("RETURN_CODE");
		if (!"0".equals(returnCode)) {
			String returnMsg = bean.getString("RETURN_MSG");
			String detailMsg = bean.getString("DETAIL_MSG");
			String errorMsg = "【" + returnCode + "】" + returnMsg + "（" + detailMsg + "）";
			System.err.println("取客户经理错误信息：" + errorMsg);
			throw new Exception(detailMsg);
		}
		List specialRoleList = new ArrayList();
		List list = bean.getList("OUT_DATA.DATA_LIST.DATA");
		Map resultMap = new HashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Object obj = it.next();
			if(null == obj || "".equals(obj)){
				continue;
			}
			resultMap = (HashMap)obj;
			String login_no = (String) resultMap.get("LOGIN_NO");
			String login_name = (String) resultMap.get("LOGIN_NAME");
			String valid_flag_S = (String) resultMap.get("VALID_FLAG");
			Map operator = new HashMap();
			operator.put("operNo", login_no);
			operator.put("operName", login_name);
			operator.put("validFlag", valid_flag_S);
			//operator(login_no, login_name, valid_flag_S.equals("Y") ? true : false);
			specialRoleList.add(operator);
			resultMap = null;
		}
		//test
//		System.out.println(specialRoleList);
		return specialRoleList;
	}

	//Linxy 20100313
	@Override
	public List getNextGroup(String groupId) throws Exception {
		List groupList = new ArrayList();
		String dynParam = "<GROUP_ID type=\"string\">"
					+ groupId
					+ "</GROUP_ID ><ROOT_DISTANCE type=\"string\">B</ROOT_DISTANCE><IS_ACTIVE type=\"string\">Y</IS_ACTIVE>"
					+ "<IS_AGENT type=\"string\"></IS_AGENT><IS_TOWN type=\"string\"></IS_TOWN><CLASS_CODE type=\"string\"></CLASS_CODE><CLASS_KIND type=\"string\"></CLASS_KIND>";
		String xmlParam = getInputParams(dynParam);
			System.out.println("InputXML=" + xmlParam);
			try {
				Map map = ServiceUtil.callService("sGroupTree", xmlParam);
				MapBean bean = new MapBean(map);
				List list = bean.getList("OUT_DATA.BUSI_INFO");
				Map resultMap = new HashMap();
				for (Iterator it = list.iterator(); it.hasNext();) {
					resultMap = (HashMap) it.next();
					String childId = (String) resultMap.get("GROUP_ID");
					String childName = (String) resultMap.get("GROUP_NAME");
					Map group = new HashMap();
					group.put("groupId",childId);
					group.put("groupName",childName);
					groupList.add(group);
					resultMap = null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return groupList;
	}
	/**
	 * 传入报文ROOT_DISTANCE和group_id  查询组织机构相应深度下的组织机构
	 * CURRENT_LEVEL：group_id与查询结果中组织的距离
	 */
	public Map getGroupByDistance(String group_id,String root_distance) throws Exception{
		Map group = new HashMap();
		if ("mobile".equals(carrierId)) {
			String dynParam = "<GROUP_ID type=\"string\">"
					+ group_id
					+ "</GROUP_ID ><ROOT_DISTANCE type=\"string\">"+root_distance+"</ROOT_DISTANCE><IS_ACTIVE type=\"string\">Y</IS_ACTIVE>"
					+ "<IS_AGENT></IS_AGENT><IS_TOWN></IS_TOWN><CLASS_CODE></CLASS_CODE><CLASS_KIND></CLASS_KIND>";
			String xmlParam = getInputParams(dynParam);
			try {
				Map map = ServiceUtil.callService("sGroupTree", xmlParam);
				MapBean bean = new MapBean(map);
				//String str = "<?xml version=\"1.0\" encoding=\"GBK\"?><ROOT><RETURN_CODE type=\"long\">0</RETURN_CODE><RETURN_MSG type=\"string\">ok!</RETURN_MSG><USER_MSG type=\"string\">ok!</USER_MSG><DETAIL_MSG type=\"string\">OK!</DETAIL_MSG><PROMPT_MSG type=\"string\"/><OUT_DATA><BUSI_INFO><PARENT_GROUP_ID type=\"string\">10017</PARENT_GROUP_ID><DENORM_LEVEL type=\"int\">1</DENORM_LEVEL><PARENT_LEVEL type=\"long\">1</PARENT_LEVEL><CURRENT_LEVEL type=\"long\">2</CURRENT_LEVEL><GROUP_NAME type=\"string\">安徽省</GROUP_NAME><ROOT_DISTANCE type=\"int\">1</ROOT_DISTANCE><HAS_CHILD type=\"string\">Y</HAS_CHILD><QUERY_INDEX type=\"int\">-1</QUERY_INDEX><CLASS_CODE type=\"string\">431</CLASS_CODE><IS_ACTIVE type=\"string\">Y</IS_ACTIVE><OPER_DATE type=\"string\">19000101000000</OPER_DATE><BUSINESS_HOURS type=\"string\">NULL</BUSINESS_HOURS><PHONE type=\"string\">NULL</PHONE><FAX type=\"string\">NULL</FAX><INVALID_TIME type=\"string\">20991231235959</INVALID_TIME><AUDIT_FLAG type=\"string\">Y</AUDIT_FLAG><LOGIN_PREFIX type=\"string\">Y</LOGIN_PREFIX><P_REGION_NAME type=\"string\">安徽</P_REGION_NAME><TOWN_ADDRESS type=\"string\"/><SERVICE_CONTENT type=\"string\"/><CREATE_LOGIN type=\"string\">admin0</CREATE_LOGIN><TWO_DIMENSIONAL_CODE type=\"string\"/><GIVEOUT_FLAG type=\"string\">Y</GIVEOUT_FLAG></BUSI_INFO></OUT_DATA></ROOT>";
				//MapBean bean =ServiceUtil1.getMapBeanFromXml(str,true);
				List list = bean.getList("OUT_DATA.BUSI_INFO");
				if (list != null && list.size() > 0) {
					Map resultMap = (HashMap) list.get(0);
					group.put("groupId",(String) resultMap.get("GROUP_ID"));
					group.put("parentGroupId",(String) resultMap.get("PARENT_GROUP_ID")==null?"":(String) resultMap.get("PARENT_GROUP_ID"));
					group.put("groupName",(String) resultMap.get("GROUP_NAME"));
					// 距离
					group.put("currentLevel",(String) resultMap.get("CURRENT_LEVEL"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return group;
	}
	/**
	 * 获取当前组织所属地市的region_id
	 * @param groupId
	 * @return
	 */
	public List getRegionId(String groupId,String province_center)throws Exception {
		String xmlParam = "<Root><GROUP_ID type=\"string\">" + groupId + "</GROUP_ID><ROOT_DISTANCE type=\"int\">" + 0 + "</ROOT_DISTANCE></Root>";
		System.out.println(xmlParam);
		Map map = ServiceUtil.callService("sGetGrpRegion", xmlParam);
		MapBean bean = new MapBean(map);
		String returnCode = bean.getString("RETURN_CODE");
		if (!"0".equals(returnCode)) {
			String returnMsg = bean.getString("RETURN_MSG");
			String detailMsg = bean.getString("DETAIL_MSG");
			String errorMsg = "【" + returnCode + "】" + returnMsg + "（" + detailMsg + "）";
			System.err.println("取当前组织所属地市的region_id错误信息：" + errorMsg);
			throw new Exception(detailMsg);
		}
		List roleList = new ArrayList();
		List list = bean.getList("OUT_DATA");
		Map resultMap = new HashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			resultMap = (HashMap) it.next();
			String region_id =  (String) resultMap.get("REGION_ID");
			roleList.add(region_id);
		}
		roleList = getRegionPartitionRel(roleList,province_center);
		return roleList;
	}	
	
	private List<String> getRegionPartitionRel(List<String> list, String province_code){
		Map<String,String> map = getRegionPartitionRel(province_code);
		List<String> rs = new ArrayList<String>();
		if(null == list ){
			return rs;
		}
		for(int i=0;i<list.size();i++){
		  String temp = list.get(i);
		  rs.add(map.get(temp));
		}
		return rs;
	}
	
	private  Map<String,String> getRegionPartitionRel(String province_group){
    	Map conditionMap = new HashMap();
    	conditionMap.put("provinceGroup", province_group);
		conditionMap.put("tableEnName", "mk_regionpartition_dict");
    	List rs = codenameDict.queryCodeNameList(conditionMap);
		Map<String,String> map = new HashMap<String,String>();
		map.put("100", "100");
		if( null != rs && rs.size()>0){
			 for(int i=0;i<rs.size();i++){
				 String part = ((String[])rs.get(i))[0];
				 String region = ((String[])rs.get(i))[1];
				 map.put(region,part);
			 }
		}
		return map;
	}
	/**
	 * 
	 * @param login_no
	 * @param region_id
	 * @return List<HashMap> key---value
	 */
	public List getLoginMsg(String login_no,String region_id){
		// TODO Auto-generated method stub
		/** input xml
		 *<?xml version="1.0" encoding="GBK" standalone="no" ?>
			<Root>
				<REQUEST_INFO>
					<OPR_INFO>
						<REGION_ID type="int" value="11" />
						<CHANNEL_TYPE type="string" value="" />
						<LOGIN_NO type="string" value="MZZZZZ061" />
						<GROUP_ID type="string" value="" />
						<IP_ADDRESS type="string" value="" />
						<CONTACT_ID type="string" value="" />
						<OP_CODE type="string" value="4773" />
					</OPR_INFO>
					<BUSI_INFO_LIST>
						<BUSI_INFO>
							<GROUP_ID type="string"></GROUP_ID>
							<LOGIN_NO type="string">MZZZZZ061</LOGIN_NO> 
							<VALID_FLAG type="string">Y</VALID_FLAG>
							<PAGE_NUM type="int">1</PAGE_NUM>
							<PAGE_AMOUNT type="int">20</PAGE_AMOUNT>
						</BUSI_INFO>
					</BUSI_INFO_LIST>
				</REQUEST_INFO>
			</Root>
		 */
		Map map =  null;
		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\" standalone=\"no\" ?>");
	    xml.append("<Root>");
		  xml.append("<REQUEST_INFO>");
			xml.append("<OPR_INFO>");
				xml.append("<REGION_ID type=\"int\">"+region_id+"</REGION_ID>");
				xml.append("<CHANNEL_TYPE type=\"string\"></CHANNEL_TYPE>");
				xml.append("<LOGIN_NO type=\"string\">"+login_no+"</LOGIN_NO>");
				xml.append("<GROUP_ID type=\"string\"></GROUP_ID>");
				xml.append("<IP_ADDRESS type=\"string\"></IP_ADDRESS>");
				xml.append("<CONTACT_ID type=\"string\"></CONTACT_ID>");
				xml.append("<OP_CODE type=\"string\">4773</OP_CODE>");
			xml.append("</OPR_INFO>");
			xml.append("<BUSI_INFO_LIST>");
				xml.append("<BUSI_INFO>");
				    xml.append("<GROUP_ID type=\"string\"></GROUP_ID>");
					xml.append("<LOGIN_NO type=\"string\">"+login_no+"</LOGIN_NO>");
				    xml.append("<LOGIN_NAME type=\"string\"></LOGIN_NAME>");
				    xml.append("<VALID_FLAG type=\"string\">Y</VALID_FLAG>");
				    xml.append("<PAGE_NUM type=\"int\">1</PAGE_NUM>");
				    xml.append("<PAGE_AMOUNT type=\"int\">20</PAGE_AMOUNT>");
				xml.append("</BUSI_INFO>");
			xml.append("</BUSI_INFO_LIST>");
		  xml.append("</REQUEST_INFO>");
	    xml.append("</Root>");
		log.info("sGrpLoginQry input parameter:\n"+xml.toString());
		try{
			 map = ServiceUtil.callService("sGrpLoginQry", xml.toString());
	}catch (Exception e){
			log.info("sGrpLoginQry error:\n"+e.getMessage()+xml.toString());
		}
		MapBean bean = new MapBean(map);
		List<MapBean> list = bean.getList("OUT_DATA.DATA_LIST.DATA");
		return list;
	}
	/**
	 * 
	 * @param group_id
	 * @param region_id
	 * @return List<HashMap> key---value
	 */
	public List getGroupMsg(String group_id,String region_id){
		// TODO Auto-generated method stub
		Map map =  null;
		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\" standalone=\"no\" ?>");
	    xml.append("<Root>");
		  xml.append("<REQUEST_INFO>");
			xml.append("<OPR_INFO>");
				xml.append("<REGION_ID type=\"int\">"+region_id+"</REGION_ID>");
				xml.append("<CHANNEL_TYPE type=\"string\"></CHANNEL_TYPE>");
				xml.append("<LOGIN_NO type=\"string\"></LOGIN_NO>");
				xml.append("<LOGIN_NAME type=\"string\"></LOGIN_NAME>");
				xml.append("<LOGIN_PWD type=\"string\"></LOGIN_PWD>");
				xml.append("<GROUP_ID type=\"string\"></GROUP_ID>");
				xml.append("<IP_ADDRESS type=\"string\"></IP_ADDRESS>");
				xml.append("<CONTACT_ID type=\"string\">-1</CONTACT_ID>");
				xml.append("<OP_CODE type=\"string\">4773</OP_CODE>");
			xml.append("</OPR_INFO>");
			xml.append("<BUSI_INFO_LIST>");
				xml.append("<BUSI_INFO>");
				    xml.append("<GROUP_ID type=\"string\">"+group_id+"</GROUP_ID>");
				    xml.append("<ROOT_DISTANCE type=\"string\">A</ROOT_DISTANCE>");
				    xml.append("<IS_ACTIVE type=\"string\">Y</IS_ACTIVE>");
					xml.append("<IS_AGENT type=\"string\"></IS_AGENT>");
				    xml.append("<IS_TOWN type=\"string\"></IS_TOWN>");
				    xml.append("<CLASS_CODE type=\"string\"></CLASS_CODE>");
				    xml.append("<CLASS_KIND type=\"string\"></CLASS_KIND>");
				xml.append("</BUSI_INFO>");
			xml.append("</BUSI_INFO_LIST>");
		  xml.append("</REQUEST_INFO>");
	    xml.append("</Root>");
		log.info("sGroupTree input parameter:\n"+xml.toString());
		try{
			 map = ServiceUtil.callService("sGroupTree", xml.toString());
		}catch (Exception e){
			log.info("sGroupTree error:\n"+e.getMessage()+xml.toString());
		}
		MapBean bean = new MapBean(map);
		List list = bean.getList("OUT_DATA.BUSI_INFO");
		return list;
	}
	/**
	 * 根据OA工号查询
	 */
	public MapBean getLoginMsg(String oa_login_no){
		log.info("加密前："+oa_login_no);
		Map encrypt = this.getEncrypt("1", oa_login_no);
		if(null!=encrypt && "0".equals(encrypt.get("ret_code"))){
			String encrypt_login_no = (String)encrypt.get("ret_value");
			StringBuffer dynParam = new StringBuffer(); 
			dynParam.append("<?xml version=\"1.0\" encoding=\"GBK\" standalone=\"no\" ?>");
			dynParam.append("<Root>");  
			dynParam.append("<CHECK_TYPE type=\"string\">0</CHECK_TYPE>" ); 
			dynParam.append("<STAFF_ID type=\"string\">").append(encrypt_login_no).append("</STAFF_ID>" );
			dynParam.append("</Root>" );
			log.info("sEnDePasswd:"+dynParam.toString());
			log.info("加密后："+encrypt_login_no);
			try{
				Map map = ServiceUtil.callService("sYXLoginChk", dynParam.toString());
				if(null!=map){
					MapBean mapbean = new MapBean(map);
					String ret_code = mapbean.getString("RETURN_CODE");
					String detail_msg = mapbean.getString("DETAIL_MSG");
					if("0".equals(ret_code)){
						return mapbean;
					}else{
						log.info("服务返回错误"+detail_msg);
						return null;
					}
				}
			}catch(Exception e){
				log.info("调用服务sYXLoginChk错误"+e.getMessage());
			}

		}
		return null;
	}
	/**
	 * @description 采用基础域加、解密码算法
	 * @param 加密1 解码0
	 * @param 待加、解密的字符串
	 * @return ret_code ret_msg, ret_value
	 */
	public Map getEncrypt(String oper_type,String oa_login_no){
        Map ret = new HashMap();
		StringBuffer dynParam = new StringBuffer(); 
		dynParam.append("<?xml version=\"1.0\" encoding=\"GBK\" standalone=\"no\" ?>");
		dynParam.append("<Root>");  
		dynParam.append("<OP_TYPE type=\"string\">").append(oper_type).append("</OP_TYPE>" ); 
		dynParam.append("<SRC_PASS type=\"string\">").append(oa_login_no).append("</SRC_PASS>" );
		dynParam.append("</Root>" );
		log.info("sEnDePasswd:"+dynParam.toString());
		List groupList = new ArrayList();
		try{
			Map map = ServiceUtil.callService("sEnDePasswd", dynParam.toString());
			// Map map = ServiceUtil.callService("sAllGroupTown", xmlParam);
			MapBean bean = new MapBean(map);
			String ret_code = bean.getString("RETURN_CODE");
			String detail_msg = bean.getString("DETAIL_MSG");
			if("0".equals(ret_code)){
				String retMsg = bean.getString("OUT_DATA.DEST_PASS"); 
				if(null != retMsg && !"".equals(retMsg)){
					ret.put("ret_code", "0");
					ret.put("ret_msg", "操作成功"+detail_msg);
					ret.put("ret_value",retMsg );
				}else{
					ret.put("ret_code", "1");
					ret.put("ret_msg", "无效操作"+detail_msg);
				}
			}else{
				ret.put("ret_code", "1");
				ret.put("ret_msg", "操作失败:"+detail_msg);
			}
			
		}catch(Exception e){
			ret.put("ret_code", "1");
			ret.put("ret_msg", "调用服务出错"+e.getMessage());
		}
		return ret;
	}

	@Override
	public List<Map<String, String>> getGroupTree(String groupId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map getGroupInfo(String groupId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
     * 根据条件查询地市编码
     *  Create on 2014-10-11 上午11:28:54
     * @author tianyy_bj
     * @version 1.0
     * Copyright(c) 北京思特奇信息技术股份有限公司
     * @param regionCode
     * @param province_center
     * @return
     * String
     * 功能描述：
     * 修改日期:     修改人:     修改目的:
     */
    public  String getRegionPartitionRel(String regionCode,String province_center){
//		if("100".equals(regionCode)){
//			return "100";
//		}
//		Map conditionMap = new HashMap();
//		conditionMap.put("fieldValue", regionCode);
//		conditionMap.put("provinceGroup", province_center);
//		conditionMap.put("tableEnName", "mk_regionpartition_dict");
//		String temps = codenameDict.getRegionCode(conditionMap);
//		if( null != temps){
//		     return  temps;
//		}
		return "-1";
	}
    
}
