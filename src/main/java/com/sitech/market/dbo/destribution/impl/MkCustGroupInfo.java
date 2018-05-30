package com.sitech.market.dbo.destribution.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkCustGroupInfo;
import com.sitech.util.SequUtil;

/**
 * 
* Create on 2015-4-2
* @author: dongyh
* @Title: MkCustGroupInfo
* @Description： 营销客户群
* @version 1.0 
* update_data:      update_author:      update_note:
 */
public class MkCustGroupInfo extends DBMysqlClass implements IMkCustGroupInfo {

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
	public List queryList(Map inMap, int beginNum, int endNum) {
		List dataList = new ArrayList();
		List list = new ArrayList();
		List listAll = baseDao.queryForList("MkCustgroupInfo.selectMkCustGroupInfoCount", inMap);
		list = baseDao.queryForListBeginEnd("MkCustgroupInfo.selectMkCustgroupInfo", inMap, beginNum, endNum);
		dataList.add(list);
		dataList.add(listAll);
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
		baseDao.insert("MkCustgroupInfo.insertMkCustgroupInfo", inMap);
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
		baseDao.delete("MkCustgroupInfo.deleteMkCustgroupInfoById", inMap);
	}

	/**
	 * @author: liuhaoa
	 * @Title: deleteCustGroupInfo
	 * @Description:目标客户群序列生成
	 * @return 
	 * @version 1.0 
	 * date:2015-6-8
	 */
	@Override
	public String addCustGroupDetail() {
		String seq = SequUtil.getSequ();
		return seq;
	}
	
	/**
	 * 根据主键更新客户群
	 * @Create on 2015-7-29 
	 * @author: wangdw
	 * @Title: updateMkCustgroupInfoById 
	 * @Description: 
	 * @param inMap 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	@Override
	public void updateMkCustgroupInfoById(Map inMap) {
		baseDao.update("MkCustgroupInfo.updateMkCustgroupInfoById", inMap);
	}
	 
	 
}
