package com.sitech.market.busiobject.entity.busi.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.entity.busi.inter.ICusttagInfoEntity;
import com.sitech.market.dbo.destribution.inter.IMkCusttagInfo;
import com.sitech.util.SequUtil;

/**
 * Create on 2016-7-21
 * @author: zhenggp
 * @Title: CusttagInfoEntity
 * @Description：客户群标签实体
 * @version 1.0  
 * update_data:     update_author:     update_note:
 */
public class CusttagInfoEntity implements ICusttagInfoEntity{
	
	private IMkCusttagInfo mkCusttagInfo;

	public void setMkCusttagInfo(IMkCusttagInfo mkCusttagInfo) {
		this.mkCusttagInfo = mkCusttagInfo;
	}

	/**
	 * Create on 2016-7-21 
	 * @author: zhenggp
	 * @Title: queryCusttagByKeyword 
	 * @Description: 根据关键字查询客户群二级标签
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public MBean queryCusttagByKeyword(MBean paraBean) {
		Map<String,String> paraMap=new HashMap<String,String>();
		paraMap.put("custTagNameKeyword", paraBean.getBodyStr("keyword"));
		List<Map<String,String>> resultList=mkCusttagInfo.queryCusttagByKeyword(paraMap);
		MBean resultBean=new MBean();
		resultBean.setBody("custtagInfoByKeyword", resultList);
		return resultBean;
	}

	
	/**
	 * @author: zhenggp
	 * @Title: addCusttagCollectionInfo
	 * @Description:添加工号收藏标签信息
	 * @return 
	 * @version 1.0 
	 * date:2016-7-21
	 */
	@Override
	public MBean addCusttagCollectionInfo(MBean paraBean) {
		Map<String,String> queryParaMap=new HashMap<String,String>();//查询参数map
		queryParaMap.put("loginNo", paraBean.getBodyStr("loginNo"));
		queryParaMap.put("custTagId", paraBean.getBodyStr("custTagId"));
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Map<String,String> addParaMap=new HashMap<String,String>();//添加参数map
		addParaMap.put("loginNo", paraBean.getBodyStr("loginNo"));
		addParaMap.put("custTagId", paraBean.getBodyStr("custTagId"));
		addParaMap.put("regionId", paraBean.getBodyStr("regionId"));
		addParaMap.put("custTagCollectionId", SequUtil.getSequ());
		addParaMap.put("custTagCollectionTime", sdf.format(new Date()));
		MBean resultBean=new MBean();
		try{
			List<Map<String,String>> resultList=mkCusttagInfo.queryCusttagCollectionInfoByLoginNoAndCustTagId(queryParaMap);
			if(resultList.size()==0){//数据库中没有此条收藏记录
				mkCusttagInfo.addCusttagCollectionInfo(addParaMap);
				resultBean.setBody("msg","收藏成功");
			}else if(resultList.size()>0){//数据库中已有此条收藏记录
				resultBean.setBody("msg", "标签已被收藏");
			}
			return resultBean;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("=============添加收藏失败，请检查CusttagInfoEntity.addCusttagCollectionIno()================");
			resultBean.setBody("msg", "收藏失败");
			return resultBean;
		}
	}
	
	/**
	 * @author: zhenggp
	 * @Title: queryCusttagCollectionInfoByLoginNoAndCustTagId
	 * @Description:查询工号是否收藏指定标签
	 * @return 
	 * @version 1.0 
	 * date:2016-7-21
	 */
	public MBean queryCusttagCollectionInfoByLoginNoAndCustTagId(MBean paraBean){
		
		Map<String,String> paraMap = new HashMap<String,String>();
		paraMap.put("loginNo", paraBean.getBodyStr("loginNo"));
		paraMap.put("custTagId", paraBean.getBodyStr("custTagId"));
		List<Map<String,String>> resultList=mkCusttagInfo.queryCusttagCollectionInfoByLoginNoAndCustTagId(paraMap);
		MBean resultBean = new MBean();
		resultBean.setBody("custtagCollectionInfoByLoginNoAndCustTagId", resultList);
		return resultBean;
	}

	/**
	 * @author: zhenggp
	 * @Title: removeCusttagCollectionInfoByLoginNoAndCustTagId
	 * @Description:删除工号收藏指定标签的记录
	 * @return 
	 * @version 1.0 
	 * date:2016-7-22
	 */
	@Override
	public MBean removeCusttagCollectionInfoByLoginNoAndCustTagId(MBean paraBean) {
		Map<String,String> paraMap = new HashMap<String,String>();
		paraMap.put("loginNo", paraBean.getBodyStr("loginNo"));
		paraMap.put("custTagId", paraBean.getBodyStr("custTagId"));
		MBean resultBean= new MBean();
		int effectRows=-1;
		try{
			effectRows = mkCusttagInfo.removeCusttagCollectionInfoByLoginNoAndCustTagId(paraMap);;
			if(effectRows==0){
				resultBean.setBody("msg", "标签未被收藏，不能取消");
			}else{
				resultBean.setBody("msg", "已取消收藏");
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("===============删除收藏记录出错，请检查CusttagInfoEntity.removeCusttagCollectionInfoByLoginNoAndCustTagId()===========");
			resultBean.setBody("msg","取消收藏失败");
		}
		return resultBean;
	}

}
