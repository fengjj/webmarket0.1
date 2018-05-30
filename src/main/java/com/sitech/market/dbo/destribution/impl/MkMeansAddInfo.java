package com.sitech.market.dbo.destribution.impl;

import java.util.List;
import java.util.Map;

import com.sitech.jcf.core.exception.BusiException;
import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkMeansAddInfo;
import com.sitech.util.CommonUtil;

/**
 * 
* Create on 2015-4-2
* @author: dongyh
* @Title: MkMeansInfo
* @Description： 营销方式
* @version 1.0 
* update_data:      update_author:      update_note:
 */
public class MkMeansAddInfo extends DBMysqlClass implements IMkMeansAddInfo {


	/**
     * 根据主键查询营销方式 Create on 2015-07-25
     * 
     * @author quyl
     * @version 1.0 Copyright(c) 北京思特奇信息技术股份有限公司 功能描述：根据主键查询营销方式 修改日期: 修改人:
     *          修改目的:
     */
    public Map selectMeansAddInfoById(Map meansId) {
        Map meansMap = null;
        try {
        	System.out.println("11111111111111111111111111111meansId:"+meansId);
        	List<Map> list = (List<Map>) baseDao.queryForList("MkMeansaddInfo.selectMkMeansaddInfo", meansId);
        	if(CommonUtil.isNotEmpty(list))
        		meansMap = list.get(0);
        	System.out.println("meansMap:"+meansMap);
        } catch (Exception e) {
            throw new BusiException("MkMeansaddInfo.selectMkMeansaddInfo", e+ "报告大王，查询数据的时候出错了！");
        }
        return meansMap;
    }

	/**
	 * Create on 2015-7-27 
	 * @author: liuhaoa
	 * @Title: saveMeansAddInfo 
	 * @Description: 保存营销方式附加表
	 * @param inMap 
	 * @version 1.0 
	 * update_date:20150629       update_author: wangdw      update_note: 重新修改捆绑关系，原业务废弃。
	 */
	@Override
	public void saveMeansAddInfo(Map inMap) {
		baseDao.insert("MkMeansaddInfo.insertMkMeansaddInfo", inMap);
	}

}
