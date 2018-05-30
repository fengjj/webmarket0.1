package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

public interface IMkBusiopenareaInfo {
	
	/**
	 * 根据actids查询活动开发区域
	 * 返回值类型：List<Map>
	 * 作者： fengjj
	 * 日期： 2014年11月20日
	 */

	public List<Map> queryOpenAreaCode(Map map);

	/**
     * 用于营销活动查询
     * lixd_bj
     * 2015-01-12
     */
	public List<Map> queryOpenAreaInfo(Map paramMap);
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
	public void insertMkBusiopenareaInfo(List<Map> bean);
	/**
	 * 删除活动针对区域
	 *  Create on 2014-10-11 上午11:28:54
	 * @author tianyy_bj
	 * @version 1.0
	 * Copyright(c) 北京思特奇信息技术股份有限公司
	 * @param bean
	 * void
	 * 功能描述：
	 * 修改日期:     修改人:     修改目的:
	 */
	public boolean deleteBusiopenareaByBusiId(Map bean);


    /**
     * 根据活动id查询针对区域
     *  Create on 2014-11-25 下午2:21:59
     * @author tianyy_bj
     * @version 1.0
     * Copyright(c) 北京思特奇信息技术股份有限公司
     * 功能描述：根据活动id查询针对区域
     * 修改日期:     修改人:     修改目的:
     */
	public List queryBusiOpenAreaByActId(String actId);
}
