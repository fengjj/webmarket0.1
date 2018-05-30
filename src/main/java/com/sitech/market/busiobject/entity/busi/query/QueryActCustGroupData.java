package com.sitech.market.busiobject.entity.busi.query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sitech.market.dbo.destribution.inter.IMkBusicustgroupRel;

/** 
 * Create on 2015年5月11日 
 * @author: fengjj
 * @Title: QueryCustGroupData 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note: 
 */
public class QueryActCustGroupData implements IGetBusiData {

    private IMkBusicustgroupRel mkBusicustgroupRel;
    /**
     * Create on 2015年5月11日
     * @author : fengjj
     * @Title: getBusiData
     * @Description: 查询目标客户群业务数据
     * @param inMap
     * @return
     * @version 1.0
     * update_data:     update_author:     update_note:
     */
    @Override
    public Map<String, Object> getBusiData(List<Map<Object,Object>> elementList,Map<Object, Object> inMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("busiId", inMap.get("actId"));
        List<Object> custgroupList = mkBusicustgroupRel.selectCustGroup(inMap);
        map.clear();
        //按照元素id放入map
        map.put("D04", custgroupList);
        return map;
    }
    public IMkBusicustgroupRel getMkBusicustgroupRel() {
        return mkBusicustgroupRel;
    }
    public void setMkBusicustgroupRel(IMkBusicustgroupRel mkBusicustgroupRel) {
        this.mkBusicustgroupRel = mkBusicustgroupRel;
    }

}
