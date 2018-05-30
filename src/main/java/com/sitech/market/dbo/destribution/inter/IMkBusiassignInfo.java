package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

import com.sitech.jcfx.dt.MBean;

public interface IMkBusiassignInfo {

	/**
	 * 批量插入
	 *  Create on 2014-10-11 上午11:28:54
	 * @author tianyy_bj
	 * @version 1.0
	 * Copyright(c) 北京思特奇信息技术股份有限公司
	 * @param bean
	 * void
	 * 功能描述：
	 * 修改日期:     修改人:     修改目的:
	 */
	public void insertMkBusiassignInfo(List<Map> bean);
	/**
	 * 根据id删除
	 *  Create on 2014-10-11 上午11:28:54
	 * @author tianyy_bj
	 * @version 1.0
	 * Copyright(c) 北京思特奇信息技术股份有限公司
	 * @param bean
	 * void
	 * 功能描述：
	 * 修改日期:     修改人:     修改目的:
	 */
	public void deleteBusiassignByBusiId(Map map);
}
