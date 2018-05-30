package com.sitech.market.dbo.destribution.impl;

import java.util.List;
import java.util.Map;

import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkBusicustgroupRel;

/**
 * 
* Create on 2015-4-2
* @author: dongyh
* @Title: MkBusicustgroupRel
* @Description： 客户群关系
* @version 1.0 
* update_data:      update_author:      update_note:
 */
public class MkBusicustgroupRel extends DBMysqlClass implements IMkBusicustgroupRel {

    /**
     * Create on 2015年5月6日
     * @author:fengjj
     * @Title: insertIMkBusicustgroupRel
     * @param map
     * @version 1.0
     * update_data:     update_author:     update_note:
     */
    @Override
    public void insertIMkBusicustgroupRel(Map<Object,Object> map) {

        baseDao.insert("MkBusicustgroupRel.insertMkBusicustgroupRel", map);
    }
    /**
     * 批量插入
     * Create on 2015-5-22 
     * @author: wangdw
     * @Title: batchInsertIMkBusicustgroupRel 
     * @Description: 
     * @param list 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */
    @Override
    public void batchInsertIMkBusicustgroupRel(List<Map> list) {
        baseDao.batchInsert("MkBusicustgroupRel.insertMkBusicustgroupRel", list);
    }

    /**
     * Create on 2015年5月7日
     * @author:fengjj
     * @Title: selectCustGroup
     * @param inMap
     * @return
     * @version 1.0
     * update_data:     update_author:     update_note:
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Object> selectCustGroup(Map<Object, Object> inMap) {
        List<Object> list = baseDao.queryForList("MkBusicustgroupRel.selectMkCustgroupInfo", inMap);
        return list;
    }

    /**
     * Create on 2015年5月9日
     * @author:fengjj
     * @Title: deleteIMkBusicustgroupRel
     * @Description: TODO 
     * @param inMap
     * @version 1.0
     * update_data:     update_author:     update_note:
     */
    @Override
    public void deleteIMkBusicustgroupRel(String serialId) {
        baseDao.delete("MkBusicustgroupRel.deleteMkBusicustgroupRelById", serialId);
    }
	
    /**
     * 查询业务关系表
     * Create on 2015-5-22 
     * @author: wangdw
     * @Title: selectMkBusicustgroupRel 
     * @Description: 
     * @param inMap
     * @return 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */
    @Override
    public List selectMkBusicustgroupRel(Map inMap) {
    	List list = baseDao.queryForList("MkBusicustgroupRel.selectMkBusicustgroupRel", inMap);
        return list;
    }
	 
    /**
     * 根据busiId更新busiId
     * Create on 2015-5-26 
     * @author: wangdw
     * @Title: updateMkBusicustgroupRelForBusiId 
     * @Description: 
     * @param map 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */
    @Override
    public void updateMkBusicustgroupRelForBusiId(Map map)  {
    	baseDao.update("MkBusicustgroupRel.updateMkBusicustgroupRelForBusiId", map);
    }
    
    /**
     * 根据busiId和busiType删除
     * Create on 2015-5-28 
     * @author: wangdw
     * @Title: deleteMkBusicustgroupRelByBusiId 
     * @Description: 
     * @param map 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */
    @Override
    public void deleteMkBusicustgroupRelByBusiId(Map map) {
    	baseDao.delete("MkBusicustgroupRel.deleteMkBusicustgroupRelByBusiId", map);
    }
    
	/** 
	 * Create on 2015-6-24 
	 * @author: songxj
	 * @Title: updateMkBusicustgroupRelById 
	 * @Description: 根据serialId更新mk_busicustgroup_rel表信息
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note: 
	 */
	@Override
	public void updateMkBusicustgroupRelById(Map map) {
		baseDao.update("MkBusicustgroupRel.updateMkBusicustgroupRelById", map);
	}
	
	/**
     * 根据业务id和业务type更新业务客户群关系表
     * @Create on 2015-7-30 
     * @author: wangdw
     * @Title: updateByBusi 
     * @Description: 
     * @param inParam 
     * @version 1.0 
     * update_date:       update_author:       update_note:
     */
	@Override
	public void updateByBusi(Map inParam) {
		baseDao.update("MkBusicustgroupRel.updateByBusi", inParam);
	}
}
