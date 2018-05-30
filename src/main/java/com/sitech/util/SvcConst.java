package com.sitech.util;






/**
 * Create on 2015-4-9 
 * @author: hanzh_bj
 * @Title: SvcConst 
 * @Description： 框架标准格式的服务名称
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class SvcConst {
	
	// ***************************组合服务 Start*************************
	//订购记录详情
	public static final String CompGetActRecordsSvc_getActRecordDetail = new String("com_sitech_market_comp_trading_inter_ICompGetActRecordsSvc_getActRecordDetail");

	//购物车订购
	public static final String CompMarketCarSvc_createMarketCar=new String("com_sitech_market_comp_trading_inter_ICompMarketCarSvc_createMarketCar");
	
	//营销规则引擎
	public static final String ICompMarketRuleSvc_checkMarketRule=new String("com_sitech_market_comp_trading_inter_ICompMarketRuleSvc_checkMarketRule");
	
	//订单行落地
	public static final String CompMarketOrderSvc_confirmOrderLine=new String("com_sitech_market_comp_trading_inter_ICompMarketOrderSvc_confirmOrderLine");

	public static final String CompMarketOrderSvc_finishOrder=new String("com_sitech_market_comp_trading_inter_ICompMarketOrderSvc_finishOrder");
	//购物车退订
	public static final String CompMarketCarSvc_backMarketCar=new String("com_sitech_market_comp_trading_inter_ICompMarketCarSvc_backMarketCar");
	
	public static final String CompMarketOrderSvc_confirmBackOrderLine=new String("com_sitech_market_comp_trading_inter_ICompMarketOrderSvc_confirmBackOrderLine");
	
	
	public static final String CompMarketOrderSvc_finishBackOrder=new String("com_sitech_market_comp_trading_inter_ICompMarketOrderSvc_finishBackOrder");

	
	//电子券出库（发放）
	public static final String CompOutstorageSvc_elecVoucherOutStorage=new String("com_sitech_market_comp_trading_inter.ICompOutStorageSvc_elecVoucherOutStorage");
	//电子券出库(回收)
	public static final String CompOutstorageSvc_elecVoucherOutStorageBack = new String("com_sitech_market_comp_trading_inter.ICompOutStorageSvc_elecVoucherOutStorageBack");
	//电子卡出库
	public static final String CompOutstorageSvc_elecCardOutStorageBack  = new String("com_sitech_market_comp_trading_inter.ICompOutStorageSvc_elecCardOutStorageBack");
	
	
	public static final String CompOutstorageSvc_queryReSourceRecord  = new String("com_sitech_market_comp_trading_inter.ICompOutStorageSvc_queryReSourceRecord");
	
	//终端出库（发放）
	public static final String CompOutstorageSvc_terminalOutStorage=new String("com_sitech_market_comp_trading_inter.ICompOutStorageSvc_terminalOutStorage");
	//终端出库(回收)
	public static final String CompOutstorageSvc_terminalOutStorageBack  = new String("com_sitech_market_comp_trading_inter.ICompOutStorageSvc_terminalOutStorageBack");
	//积分出库（发放）
	public static final String CompOutstorageSvc_scoreOutStorage=new String("com_sitech_market_comp_trading_inter.ICompOutStorageSvc_scoreOutStorage");
	
	//促销品出库（发放）
	public static final String CompOutstorageSvc_giftOutStorage=new String("com_sitech_market_comp_trading_inter.ICompOutStorageSvc_giftOutStorage");
	//退订终端同步资源
	public static final String CompInputstorageSvc_termiInputStorage = new String("com_sitech_market_comp_trading_inter.ICompInputStorageSvc_termiInputStorage");
	
	//终端上报SCM（生成文件
	public static final String CompSendTermiToOneBossSvc_terminalSendToOneBossSCM = new String("com_sitech_market_comp_trading_inter.ICompSendTermiToOneBossSvc_terminalSendToOneBossSCM");
	
	public static final String CompELecCardSvc_elecCardSyn=new String("com_sitech_market_comp_trading_inter_ICompElecCardSvc_elecCardSyn");
	//获取终端机型列表
	public static final String CompTermiSvc_getTermiList=new String("com_sitech_market_comp_trading_inter_ICompTermiSvc_getTermiList");
	//获取终端合约列表
	public static final String CompTermiSvc_getTermiContractList=new String("com_sitech_market_comp_trading_inter_ICompTermiSvc_getTermiContractList");
	
	/** 动漫调用华为接口：抽奖资格查询（组合服务） */
	public static final String CompPaeSvc_queryUserLotteryInfo=new String("com_sitech_market_comp_trading_inter_ICompPaeSvc_queryUserLotteryInfo");
	/** 动漫调用华为接口：中奖结果查询（组合服务） */
	public static final String CompPaeSvc_queryLotteryWinningInfo=new String("com_sitech_market_comp_trading_inter_ICompPaeSvc_queryLotteryWinningInfo");
	/** 动漫调用华为接口：规则执行接口（营销活动执行接口）（组合服务） */
	public static final String CompPaeSvc_executeCampaign=new String("com_sitech_market_comp_trading_inter_ICompPaeSvc_executeCampaign");
	/** 动漫调用华为接口：奖品未领取接口（更新中奖订单接口） */
	public static final String CompPaeSvc_setLotteryInfo=new String("com_sitech_market_comp_trading_inter_ICompPaeSvc_setLotteryInfo");
	/** 动漫调用华为接口：奖品赠送接口(漫币充值接口) */
	public static final String CompPaeSvc_rechargeGamePoints=new String("com_sitech_market_comp_trading_inter_ICompPaeSvc_rechargeGamePoints");
	/** 动漫调用华为接口：更新支付状态 */
	public static final String CompPaeSvc_changePaymentStatus = new String("com_sitech_market_comp_trading_inter_ICompPaeSvc_changePaymentStatus");

	// ***************************原子服务 Start*************************
	/** 公共方法，查询mk_codename_dict表信息 */
	public static final String AtomCommonSvc_queryCodeName = new String("com_sitech_market_atom_common_inter_IAtomCommonSvc_queryCodeName");
	/** 初始化页面组件信息参数 */
	public static final String AtomInitPageDataSvc_getInitPageData= new String("com_sitech_market_atom_destribution_inter_IAtomInitPageDataSvc_getInitPageData");
	/** 优惠生命周期查询 */
	public static final String AtomProductRecordInfoSvc_getActReqRecordList = new String("com_sitech_market_atom_trading_inter_IAtomProductRecordInfoSvc_dfavbsearchByPhoneNo");
	
	public static final String AtomMarketOrderSvc_confirmOrderLine =  new String("com_sitech_market_atom_trading_inter_IAtomMarketOrderSvc_confirmOrderLine");
	//退订落地
	public static final String AtomMarketOrderSvc_confirmBackOrderLine =  new String("com_sitech_market_atom_trading_inter_IAtomMarketOrderSvc_confirmBackOrderLine");
	/** 订单竣工 */
	public static final String AtomMarketOrderSvc_finishOrder =  new String("com_sitech_market_atom_trading_inter_IAtomMarketOrderSvc_finishOrder");
	/** 删除购物车 */
	public static final String AtomMarketOrderSvc_cancelOrder =  new String("com_sitech_market_atom_trading_inter_IAtomMarketOrderSvc_cancelOrder");
	//退订竣工
	public static final String AtomMarketOrderSvc_finishBackOrder =  new String("com_sitech_market_atom_trading_inter_IAtomMarketOrderSvc_finishBackOrder");
	//活动分类
	public static final String AtomActionSvc_queryAllActType = new String("com_sitech_market_atom_destribution_inter_IAtomActionSvc_queryAllActType");
	//活动列表查询
	public static final String AtomActionSvc_queryActList = new String("com_sitech_market_atom_destribution_inter_IAtomActionSvc_queryActList");
	//删除活动
	public static final String AtomActionSvc_removeAct = new String("com_sitech_market_atom_destribution_inter_IAtomActionSvc_removeAct");
	//保存互动
	public static final String AtomActionSvc_saveActBasic = new String("com_sitech_market_atom_destribution_inter_IAtomActionSvc_saveActBasic");
	//修改活动
	public static final String AtomActionSvc_updateActBasic = new String("com_sitech_market_atom_destribution_inter_IAtomActionSvc_updateActBasic");
	/** 根据活动ID，查询活动详细 */
	public static final String AtomActionSvc_queryActBasicByActId = new String("com_sitech_market_atom_destribution_inter_IAtomActionSvc_queryActBasicByActId");
	/** 为审批前查询详细信息业务信息 */
	public static final String AtomAuditSvc_queryDetailForAudit=new String("com_sitech_market_atom_destribution_inter_IAtomAuditSvc_queryDetailForAudit");
	/** 提交审批结果 */
	public static final String AtomAuditSvc_submitAudit = new String("com_sitech_market_atom_destribution_inter_IAtomAuditSvc_submitAudit");
    //初始化提交审批页面，查询审批人
    public final static String AtomAuditSvc_queryApprover = new String("com_sitech_market_atom_destribution_inter_IAtomAuditSvc_queryApprover");
    //查询预发布测试号码
    public final static String AtomActionSvc_queryReleasePhone = new String("com_sitech_market_atom_destribution_inter_IAtomActionSvc_queryReleasePhone");
    /** 提交发布 */
    public final static String AtomActionSvc_saveRelease = new String("com_sitech_market_atom_destribution_inter_IAtomActionSvc_saveRelease");
    //档次详情
	public static final String AtomSaleMeansContentSvc_getSaleMeansContent= new String("com_sitech_market_atom_trading_inter_IAtomSaleMeansContentSvc_getSaleMeansContent");
	//规则引擎原子服务
	public static final String AtomMarketRuleSvc_checkMarketRule = new String("com_sitech_market_atom_trading_inter_IAtomMarketRuleSvc_checkMarketRule");
	//展示费用信息
	public static final String AtomFeeInfoSvc_showFeeInfo = new String("com_sitech_market_atom_trading_inter_IAtomFeeInfoSvc_showFeeInfo");
	
	//获取费用订单行入参报文
	public static final String AtomFeeInfoSvc_getCreateMarketFeeDatagram = new String("com_sitech_market_atom_trading_inter_IAtomFeeInfoSvc_getCreateMarketFeeDatagram");
	
	//获取订单退订费用入参报文
	public static final String AtomFeeInfoSvc_getBackMarketFeeDatagram = new String("com_sitech_market_atom_trading_inter_IAtomFeeInfoSvc_getBackMarketFeeDatagram");
	
	//获取终端订单行入参报文
	public static final String AtomTermiInfoSvc_getCreateMarketTermiDatagram = new String("com_sitech_market_atom_trading_inter_IAtomTermiInfoSvc_getCreateMarketTermiDatagram");
	
	//积分抵扣计算
	public static final String AtomScoreInfoSvc_calScoreValue = new String("com_sitech_market_atom_trading_inter_IAtomScoreInfoSvc_calScoreValue");
	
	//获取积分订单行入参报文
	public static final String AtomScoreInfoSvc_getCreateMarketScoreDatagram = new String("com_sitech_market_atom_trading_inter_IAtomScoreInfoSvc_getCreateMarketScoreDatagram");
	
	//营销订购数据查询
	public static final String AtomMarketDataSvc_queryMarketData= new String("com_sitech_market_atom_trading_inter_IAtomMarketDataSvc_queryMarketData");
	
	//营销订购数据落地
	public static final String AtomMarketOrderSvc_confirmCreateMarketData= new String("com_sitech_market_atom_trading_inter_IAtomMarketOrderSvc_confirmCreateMarketData");
	//营销订购数据落地
	public static final String AtomMarketOrderSvc_confirmBackMarketData = new String("com_sitech_market_atom_trading_inter_IAtomMarketOrderSvc_confirmBackMarketData");
	//营销竣工
	public static final String AtomMarketOrderSvc_finish= new String("com_sitech_market_atom_trading_inter_IAtomMarketOrderSvc_finish");
	
	//订购记录详情
	public static final String AtomGetActRecordsSvc_getActRecordDetail = new String("com_sitech_market_atom_trading_inter_IAtomGetActRecordsSvc_getActRecordDetail");
	
	//查询用户可办理活动列表
	public static final String AtomGetSaleActionSvc_getSaleActionByContent= new String("com_sitech_market_atom_trading_inter_IAtomGetSaleActionSvc_getSaleActionByContent");

	//根据IdNo查询订购记录
	public static final String AtomGetActRecordsSvc_getActRecordsByIdNo= new String("com_sitech_market_atom_trading_inter_IAtomGetActRecordsSvc_getActRecordsByIdNo");

	//根据IMEI_NO查询订购记录
	public static final String AtomGetActRecordsSvc_getActRecordsByImei= new String("com_sitech_market_atom_trading_inter_IAtomGetActRecordsSvc_getActRecordsByImei");
	// 根据imei_no查询订购记录集合，上面的不好用
	public static final String AtomGetActRecordsSvc_getActRecordListByImei = new String("com_sitech_market_atom_trading_inter_IAtomGetActRecordsSvc_getActRecordListByImei");
	
	//更新IMEI信息
	public static final String AtomTermiRecordInfoSvc_updateImei=new String("com_sitech_market_atom_trading_inter_IAtomTermiRecordInfoSvc_updateImei");

	//查询活动信息（新建，执行，发布）
	public static final String AtomGetSaleActionSvc_getActionList=new String("com_sitech_market_atom_trading_inter_IAtomGetSaleActionSvc_getActionList");

	//查询电子券出库信息
	public static final String AtomOutStorageSvc_getElecVoucherOutStorageInfo = new String("com_sitech_market_atom_trading_inter_IAtomOutStorageSvc_getElecVoucherOutStorageInfo");
	//查询电子券退订出库信息
	public static final String AtomOutStorageSvc_getElecVoucherOutStorageInfoBack = new String("com_sitech_market_atom_trading_inter_IAtomOutStorageSvc_getElecVoucherOutStorageInfoBack");
	//查询终端出库信息
	public static final String AtomOutStorageSvc_getTerminalOutStorageInfo = new String("com_sitech_market_atom_trading_inter_IAtomOutStorageSvc_getTerminalOutStorageInfo");
	
	//终端上报SCM查询上报数据信息
	public static final String AtomTermiSendToOneBossSvc_getTermiToOneBossSCMInfo = new String("com_sitech_market_atom_trading_inter_IAtomTermiSendToOneBossSvc_getTermiToOneBossSCMInfo");
	
	//查询终端退订出库信息 
	public static final String AtomOutStorageSvc_getTermiBackOutStorageInfo = new String("com_sitech_market_atom_trading_inter_IAtomOutStorageSvc_getTermiBackOutStorageInfo");
	
	public static final String AtomOutStorageSvc_getEleCardBackOutStorageInfo = new String("com_sitech_market_atom_trading_inter_IAtomOutStorageSvc_getEleCardBackOutStorageInfo");
	//查询积分出库信息
	public static final String AtomOutStorageSvc_getScoreOutStorageInfo = new String("com_sitech_market_atom_trading_inter_IAtomOutStorageSvc_getScoreOutStorageInfo");

	//查询促销品出库信息
	public static final String AtomOutStorageSvc_getGiftOutStorageInfo = new String("com_sitech_market_atom_trading_inter_IAtomOutStorageSvc_getGiftOutStorageInfo");

	//出库结果处理
	public static final String AtomOutStorageSvc_addOutStorageResult = new String("com_sitech_market_atom_trading_inter_IAtomOutStorageSvc_addOutStorageResult");
	
	//终端退订出库
	public static final String AtomOutStorageSvc_addOutStorageResultBack = new String("com_sitech_market_atom_trading_inter_IAtomOutStorageSvc_addOutStorageResultBack");
	
	//查询终端内容信息
	public static final String AtomTermiContractSeparateSvc_getTermiContentInfo = new String("com_sitech_market_atom_trading_inter_IAtomTermiContractSeparateSvc_getTermiContentInfo");
																																																									
	//查询合约计划内容信息
	public static final String AtomTermiContractSeparateSvc_getContractContentInfo = new String("com_sitech_market_atom_trading_inter_IAtomTermiContractSeparateSvc_getContractContentInfo");
	
	//电子卡同步到资源
	public static final String AtomElecCardSvc_elecCardSyn=new String("com_sitech_market_atom_trading_inter_IAtomElecCardSvc_elecCardSyn");
	
	//预约超时处理进程
	public static final String AtomDealPreorderTimeOutSvc_dealPreorderTimeOut=new String("com_sitech_market_atom_trading_inter_IAtomDealPreorderTimeOutSvc_dealPreorderTimeOut");
	/** 获得返费接口表数据 */
	public static final String AtomDealBatchBusiSvc_getGivefeeIntf = new String("com.sitech.market.atom.trading.impl.IAtomDealBatchBusiSvc_getGivefeeIntf");
	// ***************************外系统服务 Start*************************
	
	//电子卡预占并返回营销活动编码
	public static final String ISUpdCardByOprSvc_updCardStatus=new String("com_sitech_res_inter_outinter_ISUpdCardByOprSvc_updCardStatus");
	
	//查询促销品出库信息
	public static final String IQryJFLRESSvc_sQryJFLRES = new String("com_sitech_res_inter_outinter_IQryJFLRESSvc_sQryJFLRES");
	
	//串码校验
	public static final String ISTermImeiCheckSvc_sTermImeiCheck = new String("com_sitech_term_inter_ISTermImeiCheckSvc_sTermImeiCheck");
	//串码查看
	public static final String ISTermImeiCheckSvc_sQryTermImeiInfo = new String("com_sitech_term_inter_ISQryTermImeiInfoSvc_sQryTermImeiInfo");
	//串码查看
	public static final String IQryPrcEffExpDateAoSvc_qryDate = new String("com_sitech_prodmng_atom_inter_outinter_IQryPrcEffExpDateAoSvc_qryDate");
	
	//查询积分出库信息
	public static final String IDeductScoreCoSvc_submit = new String("com_sitech_score_comp_inter_external_IDeductScoreCoSvc_submit");

	//查询终端出库信息
	public static final String ISTermSaleOutSvc_sTermSaleOut = new String("com_sitech_term_inter_ISTermSaleOutSvc_sTermSaleOut");
	
	//调用终端退订信息
	public static final String ISTermSaleOutBackSvc_sTermSaleOutBack = new String("com_sitech_term_inter_ISTermSaleOutBackSvc_sTermSaleOutBack");
	//终端上报调用一级BOSS服务
	public static final String ISPublicSnd1Svc_pubCall = new String("com_sitech_oneboss_common_service_ISPublicSnd1_pubCall");

	//根据inNo查询用户是否有手机支付功能
	public static final String IQryUserPrcInfoByIdNoAndPrcIdAoSvc_qryUserPrcInfoByIdNoAndPrcId=new String("com_sitech_ordersvc_person_atom_inter_s1104_IQryUserPrcInfoByIdNoAndPrcIdAoSvc_qryUserPrcInfoByIdNoAndPrcId");
	
	//生个购物车
	public static final String  CartInfoService_createCartInfoService = new String("com_sitech_crm_order_inter_service_CartInfoService_createCartInfoService");

	//public static final String  DeductScoreCo_submit = "com_sitech_score_external_inter_IDeductScoreCoSvc_submit";
	
	//调用规则校验服务查询业务受限规则明细
	public static final String CompMarketRuleSvc_checkMarketRule = new String("com_sitech_market_comp_trading_inter_ICompMarketRuleSvc_checkMarketRule");
	
	//(调用外系统服务)获取购物车订单退订资费
	public static final String GetProdBusiCoSvc_getProdOrderLineInfo = new String("com_sitech_ordersvc_person_comp_inter_s1104_IGetProdBusiCoSvc_getProdOrderLineInfo");
	
	//(调用外系统服务)获取购物车订单退订计费
	public static final String IBalanceSvc_qryRestPay = new String("com_sitech_acctmgr_inter_feeqry_IBalanceSvc_qryRestPay");
   
	//调用外系统服务，根据登陆信息获取上级工号
	public static final String ILoginGroupSvc_getUpLoginByGroup = new String("com_sitech_basemng_atom_inter_s2904_ILoginGroupSvc_getUpLoginByGroup");
	
	//调用外系统服务，根据登陆信息获取上级工号
	public static final String IConUserQrySvc_qryConUserByExp = new String("com_sitech_custsvc_atom_inter_IConUserQrySvc_qryConUserByExp");
	//调用外系统服务，根据登陆信息获取上级工号
	public static final String IAConInfoSvc_qryAconInfoListByCond = new String("com_sitech_custmng_atom_inter_IAConInfoSvc_qryAconInfoListByCond");
	//调用外系统服务，查询优质号码
	public static final String ISChkGoodPhoneSvc_checkGoodPhone = new String("com_sitech_res_inter_outinter_ISChkGoodPhoneSvc_checkGoodPhone");
	//调用外系统服务，查询账务
	public static final String I8148Svc_query = new String("com_sitech_acctmgr_inter_feeqry_I8148Svc_query");
	//调用外系统服务，查询账务详情
	public static final String IQryNoDetInfoSvc_sQryNoDetInfo = new String("com_sitech_res_inter_outinter_IQryNoDetInfoSvc_sQryNoDetInfo");

	//业务收藏
    public static final String AtomBusiFavorite_addBusiFavorite = new String("com_sitech_market_atom_trading_inter_IAtomBusiFavoriteSvc_addBusiFavorite");
    public static final String AtomBusiFavorite_delBusiFavorite = new String("com_sitech_market_atom_trading_inter_IAtomBusiFavoriteSvc_delBusiFavorite");
    public static final String AtomBusiFavorite_queryBusiFavorit = new String("com_sitech_market_atom_trading_inter_IAtomBusiFavoriteSvc_queryBusiFavorite");

    /** 获得用户办理电子券信息 */
    public static final String AtomElecVoucherSvc_getUserAcceptInfo = new String("com_sitech_market_atom_trading_inter_IAtomElecVoucherSvc_getUserAcceptInfo");
    
	
	//调用外系统服务，根据登录工号组织id获取组织树结构
	public static final String IGroupMngSvc_getGroupTree = new String("com_sitech_basemng_atom_inter_s2973_IGroupMngSvc_getGroupTree");
	
	// 调用外系统，资费模糊搜索
	public static final String IMarketPrcCataQryAoSvc_qryMarketPrcCata = new String("com_sitech_prodmng_atom_inter_outinter_IMarketPrcCataQryAoSvc_qryMarketPrcCata");

	
	// 积分预占
	public static final String IScorePreMarkCoSvc_scorePreMark = new String("com_sitech_score_comp_inter_external_IScorePreMarkCoSvc_scorePreMark");

	//终端预占及预占释放
	public static final String ISTermImeiCampReleaseSvc_sTermImeiCampRelease = new String("com_sitech_term_inter_ISTermImeiCampReleaseSvc_sTermImeiCampRelease");

	public static final String IAtomPreOrderSvc_addTermiPreOrder=new String("com_sitech_market_atom_trading_inter_IAtomPreOrderSvc_addTermiPreOrder");
	
	//电子卡做销售校验并返回营销活动编码
	public static final String ISChkCardResInfoSvc_checkCardStatus=new String("com_sitech_res_inter_outinter_ISChkCardResInfoSvc_checkCardStatus");
	
	//根据活动Id查询meansId
	public static final String IAtomMeansSvc_getMeansIdByActId=new String("com_sitech_market_atom_destribution_inter_IAtomMeansSvc_getMeansIdByActId");

	//根据登录工号查询group_id
	public static final String IAtomLoginSvc_getLoginMsg=new String("com_sitech_market_atom_common_inter_IAtomLoginSvc_getLoginMsg");

	//根据手机号查询用户基本信息
	public static final String IAtomUserInfoSvc_queryUserByPhoneNo=new String("com_sitech_market_atom_trading_inter_IAtomUserInfoSvc_queryUserByPhoneNo");
	
	/** 根据手机号查询用户基本信息 */
	public static final String IAtomUserInfoSvc_queryMarketLabelById = new String("com_sitech_market_atom_trading_inter_IAtomUserInfoSvc_queryMarketLabelById");
	
	//电子券校验
	public static final String IAtomBusiCheckSvc_checkElecVoucher=new String("com_sitech_market_atom_trading_inter_IAtomBusiCheckSvc_checkElecVoucher");

	//电子券额度校验
	public static final String IAtomBusiCheckSvc_checkElecVoucherAmount = new String("com_sitech_market_atom_trading_inter_IAtomBusiCheckSvc_checkElecVoucherAmount");
	
	//电子券额度扣减
	public static final String IAtomBusiCheckSvc_elecVoucherDeduction = new String("com_sitech_market_atom_trading_inter_IAtomBusiCheckSvc_elecVoucherDeduction");
	//电子券额度扣减
	public static final String IUpdRevokeSvc_updRevoke = new String(" com_sitech_res_inter_outinter_IUpdRevokeSvc_updRevoke");
	
	//是否可办理终端业务
	public static final String IAtomTermiRecordInfoSvc_isSaleTermi=new String("com_sitech_market_atom_trading_inter_IAtomTermiRecordInfoSvc_isSaleTermi");

	//裸机办理合约机申请
	public static final String IAtomBackContractSvc_addBackContract=new String("com_sitech_market_atom_trading_inter_IAtomBackContractSvc_addBackContract");

	//合约包预约申请二次确认
	public static final String  IAtomBackContractSvc_reAddBackContract =new String("com_sitech_market_atom_trading_inter_IAtomBackContractSvc_reAddBackContract");

	//裸机办理合约机取消 
	public static final String IAtomBackContractSvc_cancelBackContract=new String("com_sitech_market_atom_trading_inter_IAtomBackContractSvc_cancelBackContract");

	//营销包合约申请取消二次确认
	public static final String IAtomBackContractSvc_reCancelBackContract=new String("com_sitech_market_atom_trading_inter_IAtomBackContractSvc_reCancelBackContract");
	
	//生成预约接口表数据的文件给经分
	public static final String IAtomBackContractSvc_sendPreOrderIntf=new String("com_sitech_market_atom_trading_inter_IAtomBackContractSvc_sendPreOrderIntf");
	
	//接收行业部消息，同步mk_user_info run_code
	public static final String IAtomParseContactDataSvc_updateRunCode=new String("com_sitech_market_atom_contact_inter_IAtomParseContactDataSvc_updateRunCode");
	
	//获取经分返回的带有imei号的文件
	public static final String IAtomBackContractSvc_getPreOrderImeiMessage = new String("com_sitech_market_atom_trading_inter_IAtomBackContractSvc_getPreOrderImeiMessage");
	
	//同步活动信息
	public static final String AtomActionSvc_querySyncActInfoByActId = new String("com_sitech_market_atom_destribution_inter_IAtomActionSvc_querySyncActInfoByActId");

	//电子卡内容查询（根据活动ID查询内容ID）
	public static final String IAtomContentSvc_getElecContentSerialId=new String("com_sitech_market_atom_destribution_inter_IAtomContentSvc_getElecContentSerialId");

	//获得预约接口表中已经获取IMEI的信息
	public static final String IAtomBackContractSvc_getPreOrderIntf=new String("com_sitech_market_atom_trading_inter_IAtomBackContractSvc_getPreOrderIntf");

	//终端库存预占释放
	public static final String sTermStockCampRelease=new String("com_sitech_term_inter_ISTermStockCampReleaseSvc_sTermStockCampRelease");
	
	//后台复杂赠费
	public static final String ICompGiveFeeSvc_complexGiveFee=new String("com_sitech_market_comp_trading_inter_ICompGiveFeeSvc_complexGiveFee");

	//后台复杂修改赠费月份
	public static final String ICompGiveFeeSvc_updateComplexFee=new String("com_sitech_market_comp_trading_inter_ICompGiveFeeSvc_updateComplexFee");

	//获取免填单订单行入参报文
	public static final String IAtomFreeBillInfoSvc_getCreateFreeBillDatagram = new String("com_sitech_market_atom_trading_inter_IAtomFreeBillInfoSvc_getCreateFreeBillDatagram");

	//积分兑换电子券
	public static final String ICompElecVoucherSvc_sendElecVoucheByInter=new String("com_sitech_market_comp_trading_inter_ICompElecVoucherSvc_sendElecVoucheByInter");

	//
	public static final String ICompOutStorageSvc_cardOutStorage=new String("com_sitech_res_inter_outinter_IUpdCardResInfoSvc_updCardStatus");
	/**
	 * 终端审批结束
	 */
	public static final String IApplyPdomSvc_mdfAppStatus = new String("com_sitech_basemng_atom_inter_apply_IApplyPdomSvc_mdfAppStatus");

	//电子券对账
	public static final String ICompElecVoucherSvc_confirmElecVoucher=new String("com_sitech_market_comp_trading_inter_ICompElecVoucherSvc_confirmElecVoucher");
	//运营位
	public static final String AtomBusiPositionSvc_getBusiPositionRel=new String("com.sitech.market.atom.destribution_inter_IAtomBusiPositionSvc_getBusiPositionRel");
	/**
	 * 校验手机号，并返回账户id
	 */
	public static final String IAtomUserInfoSvc_queryUserInfoByPhoneNo = new String("com_sitech_market_atom_trading_inter_IAtomUserInfoSvc_queryUserInfoByPhoneNo");
	//网厅预约接口
	public static final String ICompMallOrderSvc_createMallOrder=new String("com_sitech_market_comp_trading_inter_ICompMallOrderSvc_createMallOrder");
	//将数据插入预约表
	public static final String AtomMarketDataSvc_insertPreOrder=new String("com_sitech_market_atom_trading_inter_IAtomMarketDataSvc_insertPreOrder");
	//网厅预约公共校验接口
	public static final String ICompUserActInfoChkSvc_userActInfoChk=new String("com_sitech_market_comp_trading_inter_ICompUserActInfoChkSvc_userActInfoChk");
	//预约公共校验接口实现
	public static final String AtomMarketDataSvc_selectMeansActIdByRelId=new String("com_sitech_market_atom_trading_inter_IAtomMarketDataSvc_selectMeansActIdByRelId");
	//黑名单校验接口
	public static final String IBlackListSvc_qryBlackListForMng=new String("com_sitech_custmng_atom_inter_IBlackListSvc_QryBlackListForMng");
	//查询终端机型和授权审批标志
	public static final String AtomMarketDataSvc_queryResCodePowerflagByRelId=new String("com_sitech_market_atom_trading_inter_IAtomMarketDataSvc_queryResCodePowerflagByRelId");
	/**
	 * 终端审批验证
	 */
	public static final String ApplyPdomSvc_pubAppQry = new String("com_sitech_basemng_atom_inter_apply_IApplyPdomSvc_pubAppQry");
	//调用消息中间件服务
	public static final String AtomSendMsgSvc_sendMessage = new String("com_sitech_market_atom_common_inter_IAtomSendMsgSvc_sendMessage");
	public static final String ICompMarketGiveFeeSvc_updateGiveIntf = new String("com_sitech_market_comp_trading_inter_ICompMarketGiveFeeSvc_updateGiveIntf");
	/**
	 * 目标客户群信息更新
	 */
	public static final String AtomCustGroupSvc_updateCustGroupInfo = new String("com_sitech_market_atom_destribution_inter_IAtomCustGroupSvc_updateCustGroupInfo");

	public final static String EventSvc_publishEvent =  new String("com_sitech_market_atom_destribution_inter_IEventManagerSvc_publishEvent");
}
