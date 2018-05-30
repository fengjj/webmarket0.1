package com.sitech.util;


/**
 *
 * @Title:Const.java
 * @Description:工程常量类
 * @Author:chenfh
 * @Since:2014-5-25
 * @Version:1.1.0
 */
public class Const {

    public static String serviceFlag = PropertiesUtil.getProperty("CONFIG.properties", "defalut.service.type");
    public static String ROOT_PATH = PropertiesUtil.getProperty("CONFIG.properties", "service.root.path");
    public static String YIXIN_GETURL = PropertiesUtil.getProperty("CONFIG.properties", "YIXIN_GETURL");
    public static String YIXIN_SENDURL = PropertiesUtil.getProperty("CONFIG.properties", "YIXIN_SENDURL");
    public static String YIXIN_HTMLURL = PropertiesUtil.getProperty("CONFIG.properties", "YIXIN_HTMLURL");

    public static String eventsPublishCmd = PropertiesUtil.getProperty("CONFIG.properties", "event.publish.cmd");

    /**
     * 手机支付资费编码
     */
    public final static String prodPrcid = "22CAS54078878";
    /** 调用购物车，主服务ID */
    public final static String mainSvcId = new String("B01001");
    /** 默认日期字符串 */
    public final static String defaultDate = new String("20991231235959");

    /**
     * 默认的省份编码
     */
    public final static String defaultProvinceGroup = "000000";
    /** 吉林省份标识 */
    public final static String province_group_jl = "220000";


    /**
     * @Description:活动状态码表值
     */
    public final static String ActStatusCode_00 = new String("00");// 新建
    public final static String ActStatusCode_01 = new String("01");// 待审批
    public final static String ActStatusCode_02 = new String("02");// 审批中
    public final static String ActStatusCode_03 = new String("03");// 回退
    public final static String ActStatusCode_04 = new String("04");// 执行中
    public final static String ActStatusCode_05 = new String("05");// 暂停
    public final static String ActStatusCode_06 = new String("06");// 非正常终止
    public final static String ActStatusCode_07 = new String("07");// 执行完成
    public final static String ActStatusCode_08 = new String("08");// 归档
    public static final String ActStatusCode_09 = new String("09");//预发布
    public static final String ActStatusCode_10 = new String("10");//待预发布
    public static final String ActStatusCode_11 = new String("11");//预评估


    public final static String BUSI_TYPE_00 = new String("00");//  移动销售终端
    public final static String BUSI_TYPE_11 = new String("11");//  后合约终端

    public final static String PARAMETER_ID_A1123 = new String("A1123");//

    /**
     * @Description:活动类型码表
     */
    public final static String MK_ACTTYPE_DICT = new String("mk_acttype_dict");//活动类型表
    public final static String MK_ACTCLASSTYPE_DICT = new String("mk_actclasstype_dict");//活动大类
    public final static String MK_ACTCLASS_DICT = new String("mk_actclass_dict");//活动小类
    public final static String MK_PRODBRAND_DICT = new String("mk_prodbrand_dict");//用户品牌表

    /**
     * 优先级码表
     */
    public final static String MK_PRIORITY_DICT = new String("mk_priority_dict");
    /**
     * 活动提出部门
     */
    public final static String MK_ACTPROPOSEDEPARTMENT_DICT = new String("mk_actproposedepartment_dict");
    /**
     * 客户群级别
     */
    public final static String MK_CUSTGROUPLEVEL_DICT = new String("mk_custgrouplevel_dict");
    /**
     * 规则大类
     */
    public final static String MK_RULETYPE_DICT = new String("mk_ruletype_dict");
    /**
     * 内容类型表
     */
    public final static String MK_CONTENTTYPE_DICT = new String("mk_contenttype_dict");
    /**
     * 审批状态码表
     */
    public final static String MK_AUDITSTATUS_DICT = new String("mk_auditstatus_dict");
    /**
     * 活动开展渠道码表
     */
    public final static String MK_CHNTYPE_DICT = new String("mk_chntype_dict");

    /**
     * @Description:资源类型
     */
    public final static String ResourceType_H = new String("H");
    public final static String ResourceType_C = new String("C");//促销品
    public final static String ResourceType_D = new String("D");//电子卡
    public final static String ResourceType_S = new String("S");//积分
    public final static String ResourceType_Z = new String("Z");//终端

    //资源退订类型
    public final static String ResourceBackype_0 = new String("0");

    /**
     * @Description:资源占用状态
     */
    public final static String OccupyStatus_00 = new String ("00");//购物车
    public final static String OccupyStatus_02 = new String ("02");//已完成
    public final static String OccupyStatus_03 = new String ("03");//已冲正
    public final static String OccupyStatus_04 = new String ("04");//已退订

    /**
     * @Description:扫描状态
     */
    public final static String ScanStatus_0 = new String ("0");//尚不可扫描
    public final static String ScanStatus_1 = new String ("1");//可以扫描
    public final static String ScanStatus_2 = new String ("2");//扫描成功
    public final static String ScanStatus_3 = new String ("3");//扫描失败


    /**
     * @Description:积分使用状态
     */
    public final static String FreFlag_0 = new String ("0");//积分冻结
    public final static String FreFlag_1 = new String ("1");//积分预占
    public final static String FreFlag_2 = new String ("2");//积分预占释放

    /**
     * @Description:购物车操作类型
     */
    public final static String OperType_A = new String("A");//订购
    public final static String OperType_D = new String("D");//退订

    /**
     * @Description:营销活动类型
     */
    public final static String actType_01 = new String("01");//主动营销
    public final static String actType_02 = new String("02");//触发式营销
    public final static String actType_03 = new String("03");//直接赠费
    public final static String actType_04 = new String("04");//推荐营销
    public final static String ActTypeDict_03 = new String("03");//参与类营销
	/**
     * @Description:是否标志 "Y","N"
     */
    public final static String Flag_Y = new String("Y");// 是
    public final static String Flag_N = new String("N");// 否

    /**
     * @Description:数据库操作返回标示   "0"：成功,"1"：失败
     */
    public final static String ResultFlag_0 = new String("0");//成功
    public final static String ResultFlag_1 = new String("1");//失败

    /**
     * @Description:element_type "0","1","2"
     */
    public final static String ElementType_0 = new String("0");//element_type "0","1","2"
    public final static String ElementType_1 = new String("1");//element_type "0","1","2"
    public final static String ElementType_2 = new String("2");//element_type "0","1","2"
    /**
     * @Description:数字串常量
     */
    public final static String STATIC_NUM_0  = new String("0");// 0
    public final static String STATIC_NUM_1  = new String("1");// 1
    public final static String STATIC_NUM_2  = new String("2");// 2
    public final static String STATIC_NUM_3  = new String("3");// 3
    public final static String STATIC_NUM_4  = new String("4");// 4
    public final static String STATIC_NUM_5  = new String("5");// 5
    public final static String STATIC_NUM_6  = new String("6");// 6
    public final static String STATIC_NUM_7  = new String("7");// 7
    public final static String STATIC_NUM_8  = new String("8");// 8
    public final static String STATIC_NUM_9  = new String("9");// 9
    public final static String STATIC_NUM_10 = new String("10");//10
    public final static String STATIC_NUM_11 = new String("11");//11
    public final static String STATIC_NUM_12 = new String("12");//12
    public final static String STATIC_NUM_13 = new String("13");//13
    public final static String STATIC_NUM_14 = new String("14");//14
    public final static String STATIC_NUM_15 = new String("15");//15
    public final static String STATIC_NUM_16 = new String("16");//16
    public final static String STATIC_NUM_17 = new String("17");//17
    public final static String STATIC_NUM_18 = new String("18");//18
    public final static String STATIC_NUM_19 = new String("19");//19
    public final static String STATIC_NUM_20 = new String("20");//20
    public final static String STATIC_NUM_21 = new String("21");//21
    public final static String STATIC_NUM_22 = new String("22");//22
    public final static String STATIC_NUM_23 = new String("23");//23
    public final static String STATIC_NUM_24 = new String("24");//24
    public final static String STATIC_NUM_25 = new String("25");//25
    public final static String STATIC_NUM_26 = new String("26");//26
    public final static String STATIC_NUM_27 = new String("27");//27
    public final static String STATIC_NUM_28 = new String("28");//28
    public final static String STATIC_NUM_29 = new String("29");//29
    public final static String STATIC_NUM_30 = new String("30");//30
    public final static String STATIC_NUM_31 = new String("31");//31
    public final static String STATIC_NUM_32 = new String("32");//32

    /*
     * 数字常量 Integer类型
     */
    public final static Integer INT_0 = new Integer(0);
    public final static Integer INT_1 = new Integer(1);
    public final static Integer INT_2 = new Integer(2);
    public final static Integer INT_3 = new Integer(3);
    public final static Integer INT_4 = new Integer(4);
    public final static Integer INT_5 = new Integer(5);
    public final static Integer INT_6 = new Integer(6);
    public final static Integer INT_7 = new Integer(7);
    public final static Integer INT_8 = new Integer(8);
    public final static Integer INT_9 = new Integer(9);
    public final static Integer INT_10 = new Integer(10);
    public final static Integer INT_11 = new Integer(11);
    public final static Integer INT_12 = new Integer(12);
    public final static Integer INT_13 = new Integer(13);
    public final static Integer INT_14 = new Integer(14);
    public final static Integer INT_15 = new Integer(15);
    public final static Integer INT_16 = new Integer(16);
    public final static Integer INT_17 = new Integer(17);
    public final static Integer INT_18 = new Integer(18);
    public final static Integer INT_19 = new Integer(19);
    public final static Integer INT_20 = new Integer(20);
    public final static Integer INT_21 = new Integer(21);
    public final static Integer INT_22 = new Integer(22);
    public final static Integer INT_23 = new Integer(23);
    public final static Integer INT_24 = new Integer(24);
    public final static Integer INT_25 = new Integer(25);
    public final static Integer INT_26 = new Integer(26);
    public final static Integer INT_27 = new Integer(27);
    public final static Integer INT_28 = new Integer(28);
    public final static Integer INT_29 = new Integer(29);

    /**
     * @Description:判断返回值的是真还是假
     */
    public final static String IS_TRUE= new String("true");//返回为真
    public final static String IS_FLASE= new String("false");//返回为假

    /**
     * @Description:审批结果
     */
    public final static String APPROVE_PASS= new String("1");//审批通过
    public final static String APPROVE_NOTPASS= new String("2");//审批不通过

    /**
     * @Description:业务类型busiType
     */
    public final static String PROGRAME = new String("01");  //方案
    public final static String ACTION = new String("02");   //活动
    public final static String ACTION_NAME = new String("活动");   //活动
    public final static String PLAN = new String("03");   //计划
    public final static String EVENT = new String("26");      //事件
    public final static String MEANS_NAME = new String("方式");      // 营销方式
    public final static String MEANS = new String("19");      // 营销方式
    public final static String TERMACT = new String("17");  //终端促销活动
    public final static String ORDER = new String("21");      //工单
    public final static String TERMICONTRACT = new String("20"); //终端合约
    public final static String MEANSCLASS = new String("10"); //营销活动小类方式小类
    public final static String RESOURCE = new String("27");      //终端
    public final static String DICTIONARY = new String("28");      //字典类型
    public final static String MODEL = new String("model");      //营销方式模板
    public final static String ACTION_MODEL = new String("18");      //营销活动模板
    public static final String CUSTGROUP = new String("08");//客户群
    public static final String RULEID = new String("30");//营销规则
    public static final String REL_ID = new String("31");//合约关系
    public static final String BUSICHN_REL = new String("32");//业务渠道关系
    public static final String IMPORTFEETMP = new String("99");//批量送费导入临时表
    /**
     * 活动类型
     */
    public static final String ACTAIM = new String("01");//活动目的
    public static final String ACTBUSITYPE = new String("02");//活动业务类型
    /**
     * 事件
     */
    public final static String ACTION_0 = new String("0"); //动作
    public final static String ACTION_1 = new String("1"); //行为

    /**
     * 是否使用唯一编码：0,不使用；1,使用
     */
    public static final String mk_isUnique_0 = new String("0");//不使用
    public static final String mk_isUnique_1 = new String("1");//使用
    /**
     * 轨迹表记录用的操作类型
     */
    public static final String oper_insert = new String("I");//新增
    public static final String oper_delete = new String("D");//删除
    public static final String oper_update = new String("U");//修改
    public static final String oper_noChang = new String("N");//备份
    public static final String oper_exist = new String("E");//存在
    /**
     * 记录操作次数 默认为10，修改一次+1 -1代表还没有从trac表搬到info表
     */
    public static final Object uniqueId_00 = new String("00");//复制时的初始值
    public static final String uniqueId_10 = new String("10");//默认值
    public static final String uniqueId_false = new String("-1");//还没从trac表入正表
    public static final String uniqueId_updated = new String("-2");//已撤销标识
    public static final String uniqueId_deleted = new String("-3");//撤销人操作记录

    /**
     * @Description:多数据库路由选择选择
     */
    public final static String DBFlag_A= new String("MYSQL");//MYSQl数据库
    public final static String DBFlag_B= new String("Ora1");//ORACLE数据库1
    public final static String DBFlag_C= new String("Ora2");//ORACLE数据库2


    /**
     * 资源类型为终端
     */
    public final static String PUB_TYPECODE = new String("Z");
    /*
     * 终端类型 mk_contentterm
     */
    /** 合约机 */
    public static final String resourceFlag1 = new String("1");
    /** 裸机 */
    public static final String resourceFlag2 = new String("2");
    /** 演示机 */
    public static final String resourceFlag3 = new String("3");

	public static final String chnType_society = new String("1");//社会渠道类型
	public static final String chnType_private = new String("0");//自有渠道类型

	public static final String resPriceP = new String("resPriceP");//自有渠道类型查询结果存储标志
	public static final String resPriceS = new String("resPriceS");//社会渠道类型查询结果存储标志

 	/**
     * @Description:服务返回错误标识
     */
 	public final static String ResultServFlag_0 = new String("0");//成功
    public final static String ResultServFlag_1 = new String("-01");//失败
    public final static String ResultServFlag_2 = new String("-02");//失败
    public final static String ResultServFlag_3 = new String("-03");//失败

    /**
     * @Description:服务WsGetActRecordDetail和WsGetActRecordAllDetail返回标识
     */
    public final static String actRecordProdFlag = new String("prod");//资费
    public final static String actRecordLowFlag = new String("low");//保底消费
    public final static String actRecordFavFlag = new String("fav");//优惠
    public final static String actRecordFeeFlag = new String("fee");//费用
    public final static String actRecordMonthFlag = new String("month");//分月返还
    public final static String actRecordAddFlag = new String("add");//附件信息
    public final static String actRecordMarkFlag = new String("mark");//积分
    public final static String actRecordDeduFlag = new String("dedu");//抵扣劵
    public final static String actRecordCoinFlag = new String("coin");//虚拟币
    public final static String actRecordCardFlag = new String("card");//缴费卡
    public final static String actRecordXDFlag = new String("XD");//喜点

    /**
     * nosql关系表索引表分隔符
     * nosql_split_0：
     * nosql_split_1：适用于对nosql查询的数据进行split()处理
     * 说明：当分隔符为“|”时，在进行split()进行操作时，需要转义
     */
    public final static String nosql_split = new String("|");
    public final static String nosql_split_0 = new String("|");
    public final static String nosql_split_1 = new String("\\|");
    //下划线分隔符
    public final static String underline_split = new String("_");

    /**
     * nosql关系表索引表查询类型
     */
    public final static String nosql_index_type_idno = new String("100");
    //public final static String nosql_index_type_idno = new String("100");



    /**
     * 规则代码
     */
    public final static String rule_code_1301 = new String("1301");
    /**
     * 规则代码
     */
    public final static String rule_code_3201 = new String("3201");

    /**
     * @Description:mk_userordernum_info表列标识
     */
    public final static String mk_userordernum_num_flag = new String("0");
    public final static String mk_userordernum_grey_flag = new String("1");

    /**
     * @Description:订购标志
     */
    public final static String ORDER_FLAG_ACTION = new String("0");
    public final static String ORDER_FLAG_PRE = new String("1");
    public final static String ORDER_FLAG_ARPU = new String("3");//活动的ARPU值
    //事件
    public final static String ORDER_FLAG_EVENT = new String("2");

    /**
     * 唯一标识类型，0-用户唯一标识
     */
    public final static String ID_TYPE_USER = new String("0");

    /**
     * 退订OpCode
     */
    public  static String  backOpCode = new String("4612");
    public  static String  backElcOpCode = new String("4611");
    /**
     * @Description:活动订购记录表的标识
     */
    public final static String mk_actRecord_info = new String("001");
    public final static String mk_actRecordTermi_info = new String("002");
    public final static String mk_actRecordFee_info = new String("003");
    public final static String mk_actRecordProd_info = new String("004");
    public final static String mk_actRecordCond_info = new String("005");
    public final static String mk_actRecordGift_info = new String("006");
    public final static String mk_actRecordAdd_info = new String("007");
    public final static String mk_actRecordCoin_info = new String("008");
    public final static String mk_actRecordDedu_info = new String("009");
    public final static String mk_importbusi_info = new String("010");
    public final static String mk_lottery_info = new String("011");
    public final static String mk_recommend_info = new String("012");
    public final static String mk_preorder_info = new String("013");
    public final static String mk_actcust_info = new String("actcust");
    public final static String mk_actrecorddeduction_info = new String("actrecorddeduction");

    /**
     *  @Description:订购记录表status_code的值
     */
    public final static String beginStatusCode = new String("00");   //开始状态
    public final static String cancelStatusCode = new String("01");   //已撤单状态
    public final static String successStatusCode = new String("02"); //订购成功
    public final static String backStatusCode = new String("03");
    public final static String unsubscribedStatusCode = new String("04");  //已退订
    public final static String failStatusCode = new String("05");	//失败
    public final static String unsubscribingStatusCode = new String("07"); //退订中
    public final static String changeStatusCode = new String("08"); //换机

    /**
     *  @Description:终端预约订购记录表MK_PREORDER_INFO的status_code
     */
    public final static String statusCode = new String("00");  //预约完成

    /**
     *  @Description:营销元素标识
     */
    public final static String elementIdA00 = new String("A00");
    public final static String elementIdA01 = new String("A01");
    public final static String elementIdA02 = new String("A02");
    public final static String elementIdB02 = new String("B02");
    public final static String elementIdA03 = new String("A03");
    public final static String elementIdA04 = new String("A04");
    public final static String elementIdA05 = new String("A05");
    public final static String elementIdA06 = new String("A06");
    public final static String elementIdB06 = new String("B06");
    public final static String elementIdA07 = new String("A07");
    public final static String elementIdA08 = new String("A08");
    public final static String elementIdA09 = new String("A09");
    public final static String elementIdA10 = new String("A10");
    public final static String elementIdB10 = new String("B10");
    public final static String elementIdA11 = new String("A11");
    public final static String elementIdA12 = new String("A12");
    public final static String elementIdA14 = new String("A14");
    public final static String elementIdA15 = new String("A15");
    public final static String elementIdA16 = new String("A16");
    public final static String elementIdA17 = new String("A17");
    public final static String elementIdA18 = new String("A18");
    public final static String elementIdA19 = new String("A19");
    public final static String elementIdA20 = new String("A20");
    public final static String elementIdA23 = new String("A23");
    public final static String elementIdA24 = new String("A24");
    public final static String elementIdA25 = new String("A25");
    public final static String elementIdB25 = new String("B25");
    public final static String elementIdA26 = new String("A26");
    public final static String elementIdA28 = new String("A28");
    public final static String elementIdA30 = new String("A30");
    public final static String elementIdA33 = new String("A33");
    public final static String elementIdA34 = new String("A34");
    public final static String elementIdA35 = new String("A35");
    public final static String elementIdA36 = new String("A36");
    public final static String elementIdA37 = new String("A37");
    public final static String elementIdA38 = new String("A38");
    public final static String elementIdA41 = new String("A41");
    public final static String elementIdA42 = new String("A42");
    /** 业务受限element_id */
    public static final String elementIdR08 = new String("R08");
    /** 活动基本信息element_id */
    public static final String elementIdD47 = new String("D47");
    /** 活动基本信息element_id */
    public static final String elementIdD02 = new String("D02");
    /** 活动附加信息element_id */
    public static final String elementIdD02_01 = new String("D02_01");
    /** 活动基本信息详情element_id */
    public static final String elementIdD16 = new String("D16");
    /** 业务区域信息element_id */
    public static final String elementIdD17 = new String("D17");
    /** 业务评估信息element_id */
    public static final String elementIdD18 = new String("D18");
    /** 业务客户群信息element_id */
    public static final String elementIdD19 = new String("D19");
    /** 业务模板信息element_id */
    public static final String elementIdD20 = new String("D20");
    /** 业务附件信息element_id */
    public static final String elementIdD21 = new String("D21");
    /** 业务渠道信息element_id */
    public static final String elementIdD22 = new String("D22");
    /** 业务营销方式element_id */
    public static final String elementIdD23 = new String("D23");
    /** 业务内容信息element_id */
    public static final String elementIdD24 = new String("D24");
    /** 业务规则信息element_id */
    public static final String elementIdD25 = new String("D25");
    /** 业务审批记录信息element_id */
    public static final String elementIdD26 = new String("D26");
    /** 附件客户群配置element_id */
    public static final String elementIdD56 = new String("D56");
    /** 预评估配置element_id */
    public static final String elementIdD58 = new String("D58");

    /********************元素参数信息 start***************************/
    /*
     * A10
     */
    // 费用模式
    /** 费用模式A1043 0预存 */
    public final static String A10_showType0 = new String("0");
    /** 费用模式A1043 1赠送 */
    public final static String A10_showType1 = new String("1");
    // 失效类型
    /** 失效类型A1047 0：指定日期，使用failureDate值 */
    public final static String A10_offsetType0 = new String("0");
    /** 失效类型A1047 1：有效月数，使用failureMonth值 */
    public final static String A10_offsetType1 = new String("1");
    /** 失效类型A1047 2：年底失效 */
    public final static String A10_offsetType2 = new String("2");
    // 生效方式
    /** 生效方式  0 次月生效 */
    public final static String A10_effType0 = new String("0");
    /** 生效方式  3 立即生效 */
    public final static String A10_effType3 = new String("3");
    /** 生效方式  4 当月月末生效 */
    public final static String A10_effType4 = new String("4");



    /*
     * A11
     */
    /** 成本 */
    public final static String parameterIdA1103 = new String("A1103");
    /** 每月返费 */
    public final static String parameterIdA1071 = new String("A1071");

    /** 购机款 */
    public final static String parameterIdA1104 = new String("A1104");
    /** 补贴款 */
    public final static String parameterIdA1129 = new String("A1129");
    /** 缴费方式 */
    public final static String parameterIdA1043 = new String("A1043");
    /** 总共补贴款 */
    public final static String parameterIdA1001 = new String("A1001");
    /*
     * engName
     */
    /** 费用代码英文名称 */
    public final static String feeCode = new String("feeCode");


    /*
     * A06
     */
    /** 资费可选标识：必选 */
    public final static String A06_chooseType0 = new String("0");
    /** 资费可选标识：可选 */
    public final static String A06_chooseType1 = new String("1");

    //是否发送短信
    public final static String A0616 = new String("A0616");
    //捆绑月数
    public final static String A0604 = new String("A0604");
    /********************元素参数信息 end***************************/


    /********************* 规则信息 start ***************************/
    /*
     * 规则小类
     */
    /** 规则小类 09：使用优惠中受限规则 */
    public final static String ruleClass09 = new String("09");
    /********************* 规则信息 end ***************************/

    /** 内容或规则模板标识：mk_content_info和mk_rule_info的template_flag字段。 为Y表示是模板；不为Y则是实例数据。 */
    public final static String templateFlagY = new String("Y");

    /**
     * @description:省份标识province_group
     */
    public final static String province_group_sx = new String("10011"); //山西省份标识
    public final static String province_group_ah = new String("10017"); //安徽省份标识
    public final static String province_group_sc = new String("10008"); //四川省份标识

    /**
     * @description:MK_ACTRECORDFEE_INFO表FEE_CODE字段的值
     */
    public final static String stagesFeeCode = new String("300");//分月返还抵款
    public final static String saveYCFeeCode = new String("301");//保留预存抵款
    public final static String yCFeeCode = new String("302");//预存款抵款
    public final static String termiFeeCode = new String("303");//终端抵款
    public final static String openYCFeeCode = new String("304");//开户预存抵款


    /**
     * @description:MK_PREORDER_INFO表、MK_ACTRECORDTERMI_INFO表、MK_RECOMMEND_INFO表和
     *              MK_ACTRECORDDEDUCTION_INFO中的BUSI_TYPE字段标识
     */
    public final static String webPreBusiType = new String("05");//网约厅取
    public final static String deDuBusiType = new String("06");//优惠券类型
    public final static String redBusiType = new String("07");//红包优惠券类型
    public final static String telFeeBusiType = new String("08");//话费优惠券类型
    public final static String bigSellBusiType = new String("01");//大卖场类型
    public final static String marketBusiType = new String("0");//营销活动推荐业务类型
    public final static String prodBusiType = new String("1");//产品推荐业务类型
    public final static String recOtherBusiType = new String("2");//推荐他人推荐业务类型
    public final static String actBusiType = new String("02");//业务类型
    public final static String actMeanType = new String("19");//档次类型
    /**
     * @description:MK_ACTCONDCLASS_DICT表中的COND_cLASS字段标识
     */
    public final static String isDifferentCondClass = new String("5253");//判断使用号码是异网用户
    public final static String checkCheckCodeCondClass = new String("0178");//抽奖校验码校验

    /**
     * @description:MK_CHNTYPE_DICT表中的CHN_TYPE 字段标识
     */
    public final static String busiChnType = new String("0");//判断使用号码是异网用户

    /**
     * @description:REGION_CODE字段的值标识
     */
    public final static String pronviceRegionCode = new String("100");//全省

    /**
     * @description:PRIZE_TYPE字段的值标识
     */
    public final static String defaultPrizeType = new String("-1");

    /**
     * @description:MK_ACTRECORDCOIN_INFO表的COIN_TYPE字段的值标识
     */
    public final static String xDCoinType = new String("XD");//喜点
    public final static String jFCoinType = new String("JF");//积分
    public final static String lLBCoinType = new String("LLB");//啦啦包
    public final static String dDCoinType = new String("DD");//抵扣劵
    public final static String jFKCoinType = new String("JFK");//缴费卡
    public final static String b2KCoinType = new String("B2");//e币
    public final static String b4KCoinType = new String("B4");//玩乐币
    public final static String b1KCoinType = new String("B1");//金币
    public final static String dZKCoinType = new String("DZK");//电子卡

    /**
     * @description:MK_INDEXTOQUERY_IDX表的查询类型标识
     */
    public final static String idNoFlag = new String("100");
    public final static String imeiNoFlag = new String("101");
    public final static String deductionNoFlag = new String("102");
    public final static String otherPhone = new String("103");

    /**
     * @description:MK_USERORDERNUM_INFO表的ATTR_TYPE类型标识
     */
    public final static String orderNumType = new String("0");


    /**
     * @description:OPCODE
     */
    /** 营销执行opcode */
    public final static String opCodeYXZX = new String("4602");
    /** 营销退订opcode */
    public final static String opCodeYXTD = new String("4612");
    public final static String opCodeDGCX = new String("4961");

    /**
     * @description:OPCODE
     */
    public final static String errcode_dberr = new String("00001");
    /**
     * @description:错误类型
     */
    public final static String errtype_systemerror = new String("10");
    public final static String errtype_busierror = new String("11");
    public final static String errtype_promptinfo = new String("12");

    /**
     * 联合活动标识
     */
    public final static String act_org_code_2 = new String("2");
    /**
     * 业务小类元素关联类型
     */
    public static final String BusiClassType_0 = new String("0");//活动小类
    public static final String BusiClassType_1 = new String("1");//档次小类
    public static final String BusiClassType_11 = new String("11");//
    public static final String BusiClassType_33 = new String("33");//电子卡

    /**
     * 活动目的类型
     * @return
     */
    public static final String ACTAIM_DEV = new String("01");//发展新增
    public static final String ACTAIM_RETAIN = new String("02");//存量保有
    public static final String ACTAIM_ADVANCE = new String("03");//价值提升

    /**
     * @Description:图形化功能部分disFlag标示   //0-新增，完全权限；1审批中，所有不可增删；2执行中（规则修改）
     */
    public final static String ActDisFlag_0 = new String("0");//element_type "0","1","2"
    public final static String ActDisFlag_1 = new String("1");//element_type "0","1","2"
    public final static String ActDisFlag_2 = new String("2");//element_type "0","1","2"
    /**
     * 查询活动权限标识
     * Create on 2015-5-28
     * @author: wangdw
     * @Title: getDisFlag
     * @Description:
     * @param actStatusCode
     * @return
     * @version 1.0
     * update_data:       update_author:       update_note:
     */
    public static String getDisFlag(String actStatusCode) {
    	// 查询disFlag标识信息
		String disFlag = ActDisFlag_0;
		if (!ActStatusCode_00.equals(actStatusCode) && !ActStatusCode_03.equals(actStatusCode)) {
			if (ActStatusCode_04.equals(actStatusCode)) {
				disFlag = ActDisFlag_2;
			} else {
				disFlag = ActDisFlag_1;
			}
		}
		return disFlag;
    }

    public final static String PhoneType_0 = new String("0");//  操作号码（主号码）
    public final static String PhoneType_1 = new String("1");//  赠费号码

    public final static String ShowType_0 = new String("0");// 分月模式:预存
    public final static String ShowType_1 = new String("1");// 分月模式:赠费返还类型
    public final static String ShowType_2 = new String("2");// 抵扣

    public final static String ConsumeType_0 = new String("0");// 扣减
    public final static String ConsumeType_1 = new String("1");// 抵扣


    public final static String ChooseType_0 = new String("0");// 必选
    public final static String ChooseType_1 = new String("1");// 可选

    /*
     * 描述：写缓存，key=flag|ID,此处常量就是flag的值
     * key = cache_flag_actMeans | actId，value=该活动下所有的mk_means_Info表的list
     * key = cache_flag_meansContent | meansId，value=该档次下配置的的档次内容列表contentList
     * key = cache_flag_actArea | actId，value=该活动下所有的mk_busiarea_Info表的list
     * add by ygl
     */
    public final static String cache_flag_actMeans = new String("01");
    public final static String cache_flag_meansContent = new String("02");
    public final static String cache_flag_actArea = new String("03");
    public final static String cache_flag_meansElement = new String("04");

    //档次下的费用内容缓存标志。key=fee_16_meangId,value=费用内容分表的数据
    public final static String cache_flag_meansFeeContent = new String("fee_16");
  //档次下的中断内容缓存标志。key=termi_16_meangId,value=终端内容分表的数据
    public final static String cache_flag_meansTermiContent = new String("termi_16");
  //档次下的产品内容缓存标志。key=prod_16_meangId,value=产品内容分表的数据
    public final static String cache_flag_meansProdContent = new String("prod_16");
    //TODO lixd_bj
    //codeName缓存标识
    public final static String cache_flag_codeName = new String("00");

    /*
     * 活动中类型 actclass_type
     */
    /** 活动中类型 actclass_type：01存送类 */
    public final static String actclassType01 = new String("01");
    /** 活动中类型 actclass_type：02业务受限类 */
    public final static String actclassType02 = new String("02");
    /** 活动中类型 actclass_type：04终端类 */
    public final static String actclassType04 = new String("04");

    /*
     * 活动小类型 act_class
     */
    /** 活动小类型 act_class：温暖工程 */
    public final static String actClass02 = new String("02");
    /** 活动小类型 act_class：终端合约绑定 */
    public final static String actClass07 = new String("07");
    /** 活动小类型 act_class：裸机合约绑定（后合约） */
    public final static String actClass09 = new String("09");
    /** 活动小类型 act_class：抽奖 */
    public final static String actClass20 = new String("20");
    /** 活动小类型 act_class：分享送漫币 */
    public final static String actClass21 = new String("21");
    /** 活动小类型 act_class：网约厅取 */
    public final static String actClass25 = new String("25");
    /** 活动小类型 act_class：送积分 */
    public final static String actClass31 = new String("31");
    /** 活动小类型 act_class：电子卡 */
    public final static String actClass33 = new String("33");
    /** 活动小类型 act_class：产品办理 */
    public final static String actClass35 = new String("35");
    /** 活动小类型 act_class：送费 */
    public final static String actClass36 = new String("36");


    /*
     * 内容类型 content_type
     */
    /** 内容类型contentType：01终端信息 */
    public final static String contentType01 = new String("01");
    /** 内容类型contentType：02合约计划 */
    public final static String contentType02 = new String("02");
    /** 内容类型contentType：03费用类 */
    public final static String contentType03 = new String("03");
    /** 内容类型contentType：04套餐推广类 */
    public final static String contentType04 = new String("04");
    /** 内容类型contentType：06券类 */
    public final static String contentType06 = new String("06");

    /*
     * mk_contentcontract_info.allowance_type字段
     */
    /** 0:合约计划(预存话费送手机) */
    public final static String allowanceType0 = new String("0");
    /** 1：合约计划(购手机送话费) */
    public final static String allowanceType1 = new String("1");

    /*
     * 内容分表标识
     */
    /** 内容分表标识：合约分表 */
    public final static String subContentTypeContract = new String("contract");
    /** 内容分表标识：费用分表 */
    public final static String subContentTypeFee = new String("fee");


    /*
     * 终端办理类型
     */
    /** 合约机 */
    public final static String buyType1 = new String("1");
    /** 裸机 */
    public final static String buyType2 = new String("2");
    /** 逻辑合约 */
    public final static String buyType3 = new String("3");

    /*
     * 客户群状态
     */
    /** 客户群状态 【0】待审批 */
    public static final String custGroupStatus0 = new String("0");
    /** 客户群状态 【1】待扫描下发 */
    public static final String custGroupStatus1 = new String("1");
    /** 客户群状态 【2】下发完成 */
    public static final String custGroupStatus2 = new String("2");

    /*
     * 批量赠送导入标识
     */
    /** 赠送话费 */
    public static final String importBusiType0 = new String("0");
    /** 赠送产品 */
    public static final String importBusiType1 = new String("1");
    /** 赠送积分 */
    public static final String importBusiType2 = new String("2");
    /** 赠送档次 */
    public static final String importBusiType3 = new String("3");
    /** 赠送活动 */
    public static final String importBusiType4 = new String("4");


    /*
     * 客户标识
     */
    /** 客户标识 预销 */
    public static final String runCodeI = new String("I");
    /** 客户标识 预拆 */
    public static final String runCodeJ = new String("J");
    /** 客户标识 申请销号*/
    public static final String runCodea = new String("a");
    /** 客户标识 欠费销号 */
    public static final String runCodeb = new String("b");
    /** 客户标识 核销 */
    public static final String runCodec = new String("c");

    /*
     * 批量业务，临时异常表的code值
     */
    /** 批量业务，临时异常表code值：不正确记录，如非移动号码等 */
    public static final String impExpCode4 = new String("4");
    /** 批量业务，临时异常表code值：重复记录 */
    public static final String impExpCode5 = new String("5");
    /** 批量业务，临时异常表code值：预销记录 */
    public static final String impExpCodeI = new String("I");
    /** 批量业务，临时异常表code值：预拆记录 */
    public static final String impExpCodeJ = new String("J");
    /** 非本地市号码过滤值 */
    public static final String impExpCodeK = new String("K");
    /*
     * 电子券校验，入参opType类型
     */
    /** 订购校验操作0 */
    public static final String checkElecVoucherOpType_create = new String("0");
    /** 退订校验操作1 */
    public static final String checkElecVoucherOpType_back = new String("1");

    /*
     * 批量赠费业务，扫描状态
     */
    /** 0待审核 */
    public static final String giveFeeStatus0 = new String("0");
    /** 1待扫描 */
    public static final String giveFeeStatus1 = new String("1");
    /** 2待回滚 */
    public static final String giveFeeStatus2 = new String("2");
    /** 3扫描成功 */
    public static final String giveFeeStatus3 = new String("3");


    /************************出库信息  wangdw start*********************************/
    /*
     * MK_USERRESINTER_INTF，MK_USERRESINTER_TRAC，MK_USERRESINTER_HIS营销资源接口表，RESOURCE_TYPE资源类型
     */
    /** MK_USERRESINTER_INTF.RESOURCE_TYPE 终端 */
    public final static String interResourceTypeZ = new String("Z");
    /**MK_USERRESINTER_INTF.RESOURCE_TYPE 积分 */
    public final static String interResourceTypeJ = new String("J");
    /** MK_USERRESINTER_INTF.RESOURCE_TYPE 电子卡，电子券 */
    public final static String interResourceTypeD = new String("D");
    /** MK_USERRESINTER_INTF.RESOURCE_TYPE 促销品 */
    public final static String interResourceTypeC = new String("C");

    /*
     * 服务集成平台调用名称，eaiServiceDate.properties和tmpServiceData.properties中的eai名称
     */
    /** 电子券发放EAI自定义名称 */
    public final static String EAI_elecVoucherSend = new String("EAI_elecVoucherSend");

    /*
     * 电子券接口平台侧功能代码
     */
    /** 发放电子券功能码 */
    public final static String elecVoucherSendMCode = PropertiesUtil.getProperty("CONFIG.properties", "MCODE_elecVoucherSend");

    /*
     * 渠道类型
     */
    /** 渠道类型 */
    public final static String MER_ID = new String("BOSS");
    /*
     * 应用集成平台返回编码
     */
    /** 应用集成平台返回成功编码 */
    public final static String CROSS_RETURN_SUCCESS = new String("000000");

    /*
     * 是否需要开通手机支付功能
     */
    /** 不需要开通手机支付功能 */
    public final static String openPhonePay0 = new String("0");
    /** 需要开通手机支付功能 */
    public final static String openPhonePay1 = new String("1");

    /*
     * 资源接口表状态，MK_USERRESINTER_INTF表的status
     */
    /** 资源接口表状态，尚不可扫描 */
    public final static String userresinterStatus0 = new String("0");
    /** 资源接口表状态，可以扫描 */
    public final static String userresinterStatus1 = new String("1");
    /** 资源接口表状态，扫描成功 */
    public final static String userresinterStatus2 = new String("2");
    /** 资源接口表状态，扫描失败 */
    public final static String userresinterStatus3 = new String("3");

    /************************出库信息  wangdw end*********************************/



    /************************************** 针对订单传递参数常量 by wangdw 开始 ********************************************/
    /*
     * 收费方式
     */
    /** 收费方式，1前台收取 */
    public final static String receiveFeeType1 = new String("1");
    /** 收费方式，E后台收取 */
    public final static String receiveFeeTypeE = new String("E");

    /*
     * 缴费方式
     */
    /** 缴费方式0：现金 */
    public final static String payMode0 = new String("0");
    /** 缴费方式1：银行 */
    public final static String payMode1 = new String("1");
    /** 缴费方式2：信用卡 */
    public final static String payMode2 = new String("2");
    /** 缴费方式9：支票 */
    public final static String payMode9 = new String("9");
    /** 缴费方式v：积分 */
    public final static String payModev = new String("v");

    /*
     * BOSS账务营销类型
     */
    /** BOSS账务营销类型：A终端 */
    public final static String mktTypeA = new String("A");
    /** BOSS账务营销类型：B存送 */
    public final static String mktTypeB = new String("B");

    /*
     * BOSS计费返费类型
     */
    /** 0：所有都是有条件返费（第一笔 + 后面所有笔） */
    public final static String bossActType0 = new String("0");
    /** 1：第一笔无条件返费，后面几笔有条件返费 */
    public final static String bossActType1 = new String("1");
    /** 2：所有都是无条件返费 */
    public final static String bossActType2 = new String("2");

    /*
     * 返费生效时间规则
     */
    /** 01: 存送类立即生效：第一笔：办理时间 第二笔：下月月初  */
    public final static String bossRuleId01 = new String("01");
    /** 02: 存送类月末生效：每月26号6点 */
    public final static String bossRuleId02 = new String("02");
    /** 03: 存送类月初生效：每月1号6点 */
    public final static String bossRuleId03 = new String("03");
    /** 04: 存送类月初生效-赠送（温暖工程）：5号经分给数据，每月6号到账（6点） */
    public final static String bossRuleId04 = new String("04");
    /** 05: 批量赠费：第一笔：第二天6点 第二笔：4号6点 */
    public final static String bossRuleId05 = new String("05");
    /** 06: 终端类月末生效：每月最后一天18点 每月2号 （再补赠） */
    public final static String bossRuleId06 = new String("06");
    /** 07: 终端类立即生效：第一笔：办理时间 第二笔：当月月末依次（18点） */
    public final static String bossRuleId07 = new String("07");
    /** 08: 存送类立即生效-赠送（温暖工程）：第一笔：第二天6点每月6号到账（6点） */
    public final static String bossRuleId08 = new String("08");

    /************************************** 针对订单传递参数常量 by wangdw 结束 ********************************************/



    /*****************************针对厦门动漫基地与华为对接的接口使用常量 by wangdw 开始**************************************/
    /*
     * 优先级类型
     */
    /** 优先级类型 叠加型：不区分优先级，只规则适配成功及反回 */
    public final static Integer pae_priorityType1 = new Integer(1);
    /** 优先级类型 互斥型：如果营销活动为互斥型这需要设置优先级，多个互斥型活动取优先级最大的返回 */
    public final static Integer pae_priorityType2 = new Integer(2);
    /** 优先级类型 串型：根据优先级又高到低依次执行，部分失败将中断全部流程 */
    public final static Integer pae_priorityType3 = new Integer(3);


    /*
     * 活动状态
     */
    /** 活动状态 草稿 */
    public final static Integer pae_actStatus0 = new Integer(0);
    /** 活动状态 待修改 */
    public final static Integer pae_actStatus1 = new Integer(1);
    /** 活动状态 修改失败 */
    public final static Integer pae_actStatus2 = new Integer(2);
    /** 活动状态 待审核 */
    public final static Integer pae_actStatus3 = new Integer(3);
    /** 活动状态 待上线 */
    public final static Integer pae_actStatus4 = new Integer(4);
    /** 活动状态 上线失败 */
    public final static Integer pae_actStatus5 = new Integer(5);
    /** 活动状态 已上线 */
    public final static Integer pae_actStatus6 = new Integer(6);
    /** 活动状态 待下线 */
    public final static Integer pae_actStatus7 = new Integer(7);
    /** 活动状态 下线失败 */
    public final static Integer pae_actStatus8 = new Integer(8);
    /** 活动状态 已下线 */
    public final static Integer pae_actStatus9 = new Integer(9);
    /** 活动状态 待暂停 */
    public final static Integer pae_actStatus10 = new Integer(10);
    /** 活动状态 暂停失败 */
    public final static Integer pae_actStatus11 = new Integer(11);
    /** 活动状态 已暂停 */
    public final static Integer pae_actStatus12 = new Integer(12);


    /*
     * 活动类型
     */
    /** 活动类型 抽奖活动 */
    public final static Integer pae_actType1 = new Integer(1);
    /** 活动类型 分享赠送漫币活动 */
    public final static Integer pae_actType2 = new Integer(2);

    /*
     * 模板类型
     */
    /** 模板类型：活动模板 */
    public final static Integer pae_templateType1 = new Integer(1);
    /** 模板类型：动作模板 */
    public final static Integer pae_templateType2 = new Integer(2);
    /** 模板类型：资源模板 */
    public final static Integer pae_templateType3 = new Integer(3);

    /*
     * 触发事件
     */
    /** 触发事件：登录事件 */
    public final static Integer pae_triggerEvent1 = new Integer(1);
    /** 触发事件：即使抽奖事件 */
    public final static Integer pae_triggerEvent2 = new Integer(2);
    /** 触发事件：分享事件 */
    public final static Integer pae_triggerEvent3 = new Integer(3);


	/*
     * 动作类型
     */
    /** 动作类型：抽奖动作 */
    public final static Integer pae_actionType201 = new Integer(201);
    /** 动作类型：赠送动作 */
    public final static Integer pae_actionType202 = new Integer(202);

    /*
     * 模板id
     */
    /** 抽奖活动模板 */
    public final static String pae_templateid9000000001101 = new String("9000000001101");
    /** 即时抽奖动作模板 */
    public final static String pae_templateid9000000001201 = new String("9000000001201");
    /** 奖品资源模板 */
    public final static String pae_templateid9000000001301 = new String("9000000001301");
    /** 赠送资源模板 */
    public final static String pae_templateid9000000000301 = new String("9000000000301");
    /** 赠送动作模板 */
    public final static String pae_templateid9000000000201 = new String("9000000000201");
    /** 分享赠送漫币活动模板 */
    public final static String pae_templateid9000000002101 = new String("9000000002101");

    /*
     * 终端制式
     */
    /**2G*/
    public final static String termiType_2G = new String("101");
    /**3G*/
    public final static String termiType_3G = new String("201");
    /**4G*/
    public final static String termiType_4G = new String("301");

    /*
     * 奖品资源类型
     */
    /** 实物奖品 */
    public final static Integer pae_prizeResource1 = new Integer(1);
    /** 支付券 */
    public final static Integer pae_prizeResource2 = new Integer(2);
    /** 话费充值卡 */
    public final static Integer pae_prizeResource3 = new Integer(3);
    /** 流量包 */
    public final static Integer pae_prizeResource4 = new Integer(4);
    /** 漫币 */
    public final static Integer pae_prizeResource5 = new Integer(5);
    /** 积分 */
    public final static Integer pae_prizeResource6 = new Integer(6);
    /** 动漫业务包 */
    public final static Integer pae_prizeResource7 = new Integer(7);

    /*
     * 赠送资源类型
     */
    /** 漫币 */
    public final static Integer pae_handselType1 = new Integer(1);
    /** 抽奖机会 */
    public final static Integer pae_handselType2 = new Integer(2);


    /*****************************针对厦门动漫基地与华为对接的接口使用常量 by wangdw 结束**************************************/

    /** A大区，B大区 */
    public final static String A1 = new String("2201,2207,2208");
    public final static String B1 = new String("2202,2203,2204,2205,2206,2209");

    public final static String wx_verify_code = new String("次元英雄");
    public final static String client_verify_code = new String("次元英雄");

    public final static long userdatause_2M = new Long(2);

}
