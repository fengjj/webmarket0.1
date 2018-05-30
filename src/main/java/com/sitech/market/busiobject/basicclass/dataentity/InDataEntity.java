package com.sitech.market.busiobject.basicclass.dataentity;

import java.util.Map;
import com.sitech.jcfx.dt.in.InDTO;
/**数据实体抽象类
 * create on 2014-11-04
 * @author sunliang
 */
public abstract class InDataEntity extends DataEntity{
	/**将DTO转化为系统内部使用的数据对象,各子类实现此方法
	 * create on 2014-11-04
	 * @author sunliang
	 */
	public static final String OP_CODE =   new String("opCode");  		//功能代码
	public static final String LOGIN_NO =  new String("loginNo"); 		//营业员工号
	public static final String LOGIN_NAME =new String("loginName");		//营业员工号
	public static final String REGION_ID = new String("regionId");		//地市编码,内部
	public static final String REGION_CODE = new String("regionCode");	//地市编码,外部
	public static final String CHANNEL_TYPE = new String("channelType");//渠道类别
	public static final String GROUP_ID = new String("groupId");//组织机构来自session
	public static final String GROUP_NAME = new String("groupName");//组织机构
	public static final String DISTRICT_CODE = new String("districtCode");//
	public static final String PROVINCE_GROUP = new String("provinceGroup");//省份编码
	
	public static final String ORDER_ID = new String("orderId");//订单ID
	
	public static final  String OPERATE_TYPE =new String("operateType");  // 订购/退订 类型
	public static final  String MASTER_SERV_ID = new String("masterServId"); // 主体服务类型
	public static final  String OP_NOTE = new String("opNote");  //操作备注
	
	public static final String ID_NO = new String("idNo");//用户号
	public static final String CONTRACT_NO = new String ("contractNo");//账户id
	public static final String PHONE_NO = new String("phoneNo");//用户号
	public static final String CUST_GROUP_TYPE = new String("custGroupType");//用户号
	public static final String CUST_ID = new String("custId");//客户标识
	
	public static final String CART_ID = new String("cartId");//购物车id
	public static final String BIZPACK_ID = new String("bizpackId");//业务包id
	public static final String  CUST_ID_VALUE = new String("custIdValue");	
	public static final String  MAIN_SVC_ID = new String("mainSvcId");
	public static final String  ACTION_ID = new String("actionId");
	
	
	public static final String MEANS_ID = new String("meansId");//档次id
	public static final String MEANS_NAME = new String("meansName");//档次名称
	
	public static final String PREORDER_KEY = new String("preorderKey");//营销预约记录表(cassandra)主键key
	
	public static final String ACT_ID = new String("actId");//活动id
	public static final String ACT_NAME = new String("actName");//活动名称
	public static final String ACT_CLASS = new String("actClass");//活动级别
	public static final String ACTCLASS_TYPE = new String("actclassType");//活动中类
	public static final String STATUS_CODE = new String("statusCode");//状态
	
	public static final String START_DATE = new String("startDate");//开始时间
	public static final String END_DATE = new String("endDate");//结束时间
	public static final String OPER_DATE = new String("operDate");//操作时间
	
	public static final String CUR_PAGE = new String("cuPage");//当前页
	public static final String PAGE_SIZE = new String("pageSize");//当前页
	public static final String FLAG = new String("flag");//标志位
	
	
	public static final String REMIND_PHONE   = new String("remindPhone"); //提醒号码
	public static final String OPCODE      = new String("opcode");
	
	public static final String RECORD_ID   = new String("recordId");      //主表序列
	
	
	public static final String PHONE_TYPE  = new String("phoneType");
	public static final String PAY_MONEY   = new String("payMoney");
	public static final String MASTER_SVC_ID  = new String("masterSvcId");
	public static final String MAINSVC_ID  = new String("mainSvcId");
	public static final String GIVE_PHONE  = new String("givePhone");//赠费号码
	public static final String PRC_ID    = new String("prcId");
	
	
	public static final String CONSUME_TYPE= new String("consumeType");
	public static final String SCORE_VALUE = new String("scoreValue");
	public static final String DEDUCATION_MONEY = new String("deductionMoney");
	public static final String UNIQUE_ACT_ID    = new String("uniqueActId");
	public static final String CONTACT_ID       = new String("contactId");
	
	public static final String FEE_SUM      = new String("feeSum");      //终端
	
	//终端
	public static final String RESOURCE_NO    = new String("resourceNo");    //终端imei号码
	public static final String RESOURCE_MODEL = new String("resourceModel"); //终端型号
	public static final String MARK_FEE       = new String("markFee");       //积分抵扣款
	
	public static final String TERMI_RES_CODE    = new String("termiResCode");//终端型号
	public static final String IMEI_NO    		 = new String("imeiNo");      //IMEI码
	//public static final String SCORE_PRICE       = new String("scoreFrice");  // 积分抵扣款
	public static final String RESOURCE_FEE    		 = new String("resourceFee");  //购机款
	
	
	//资费
	public static final String PROD_PRCID   = new String("prodPrcid"); //资费id
	public static final String EFF_DATE     = new String("effDate");   //生效时间
	public static final String EXP_DATE     = new String("expDate");   //失效时间
	
	public static final String CHOOSE_TYPE  = new String("chooseType");//资费类型（0：必选  1：可选）
	
	
	//电子卡
	public static final String ELEC_CARD	= new String("elecCard");	   //电子卡
	public static final String CARD_FEE		= new String("cardFee");
	public static final String ELEC_INFO	= new String("elecInfo");
	
	//元素
	public static final String SERIAL_ID  		 = new String("serialId");         //分表序列
	public static final String ELEMENT_ID        = new String("elementId");        //元素id
	public static final String ELEMENT_BATCH_NO  = new String("elementBatchNo");   //元素批次
	public static final String BATCH_NO  		 = new String("batchNo");  		   //元素批次
	public static final String ENG_NAME          = new String("engName");          //元素英文名称
	public static final String ELEMENT_PAR_VALUE = new String("elementParValue");  //元素值
	
	public static final String MEAN_LIST 	= new String("meanList");//档次id
	public static final String CONTENT_LIST = new String("contentList");
	public static final String MEANS_CONTENT     = new String("meansContent");     //营销方式内容
	public static final String MEANS 	= new String("means");//档次
	public static final String MEAN 	= new String("mean");//档次
	public static final String CONTENTS = new String("contents");
	public static final String CONTENT = new String("content");
	public static final String USER_INFO	= new String("userInfo");				// 用户信息
	
	
	public static final String RELATION_ID  = new String ("relationId");
	
	public static final String SUB_ID = new String("subId");//元素配置类型（0：策划界面 1：执行界面-活动列表查询 2：执行界面-活动办理）
	public static final String RETURN_MONTH		 = new String("returnMonth");
	
	public static final String UNIQUE_BUSI_ID = new String("uniqueBusiId");		//业务统一编码
	
	public static final String SUB_ORDER_ID = new String("subOrderId");				//子订单ID
	
	public static final String RECOMMEND_OPERNO = new String("recommendOperno");				//推荐人员
	
	public static final String NOTE = new String("note");				//用户备注
	/** 分返类型 0-预存 1-赠送 2-抵扣，为空则不区分 */
	public static final String MONTH_TYPE = new String("monthType"); 
	/** 优良号码抵扣款（分） */
	public static final String GOODPHONE_FEE = new String("goodphoneFee"); 
	public static final String OTHER_PHONE = new String("otherPhone");	//它网号码
	
	public static final String MKT_TYPE = new String("mktType"); // boss计费所需营销类型 A终端，B存送
	
	public abstract Map<Object,Object> parseInParam(InDTO inDTO);

}
