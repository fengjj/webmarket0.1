package com.sitech.market.dbo.trading.inter;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface IMkActrecordRel {

	/**
	 * 根据订购记录主表序列号（主键）查询分表序列号（主键）
	 * @param recordId
	 * @author hanzh_bj
	 * Create on 2015-03-09
	 */
	public List selectSerialIdsByRecordId(String recordId);

	/**
     * 批量向MK_ACTRECORDREL_INFO表中插入相关数据
     * Create on 2014-11-26
     * @author hanzh_bj
     * @version 1.0
     * Copyright(c) 北京思特奇信息技术股份有限公司
     * 修改日期:     修改人:     修改目的:
     */
	public void insertBatchActRecordRel(String serialId, Map<String, String> relMap);

	/**
	 * Create on 2015-7-16 
	 * @author: liuhaoa
	 * @Title: selectMkActrecordRel 
	 * @Description: 根据key查询MkActrecordRel成本总表与成本分表关系查询
	 * @param inParam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public JSONObject selectMkActrecordRel(String[] key);
}
