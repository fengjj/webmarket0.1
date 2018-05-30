package com.sitech.market.busiobject.entity.busi.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.busientity.BusiEntity;
import com.sitech.market.busiobject.entity.busi.inter.ILoginEntity;
import com.sitech.market.dbo.common.inter.IMkLoginmsgDict;
import com.sitech.market.dbo.common.inter.IMkLoginpositionRel;
import com.sitech.util.CommonUtil;

/**
 * 
* Create on 2015-4-2
* @author: dongyh
* @Title: LoginEntity
* @Description： 登录操作业务实体
* @version 1.0 
* update_data:      update_author:      update_note:
 */
public class LoginEntity extends BusiEntity implements ILoginEntity {

	private IMkLoginpositionRel mkLoginpositionRel;
	private IMkLoginmsgDict mkLoginmsgDict;

	/**
	 * 
	* Create on 2015-4-2 
	* @author: dongyh
	* @Title: queryLoginInfoByPositionId 
	* @Description: 根据岗位查工号信息
	* @param inMap
	* @return 
	* @version 1.0 
	* update_data:       update_author:       update_note:
	 */
	public Map queryLoginInfoByPositionId(Map inMap) {
		List<String> positionIdList = (List<String>) inMap.get("positionIdList");
		Map result = new HashMap();// 存放返回结果
		List<Map> loginList = new ArrayList<Map>();
		if (CommonUtil.isNotEmpty(positionIdList)) {
			for (int i = 0; i < positionIdList.size(); i++) {
				String positionId = positionIdList.get(i);
				List<Map> list = mkLoginpositionRel.queryLoginInfoByPositionId(positionId);
				loginList.addAll(list);
			}
		}
		result.put("loginList", loginList);
		return result;
	}

	/**
	 * 根据工号查询登录信息
	 * 
	 * Create on 2014-11-10 下午3:21:45
	 * 
	 * @author tianyy_bj
	 * @version 1.0 Copyright(c) 北京思特奇信息技术股份有限公司 功能描述：根据工号查询登录信息 修改日期: 修改人:
	 *          修改目的:
	 */
	@Override
	public Map queryLoginInfo(Map bean) {
		Map resultBean = new HashMap();
		resultBean.put("positions",
				mkLoginpositionRel.queryPositionIdByLoginNo(bean));
		resultBean.put("resultBean",
				mkLoginmsgDict.queryLoginInfoByLoginNo(bean));
		return resultBean;
	}

	public void setMkLoginpositionRel(IMkLoginpositionRel mkLoginpositionRel) {
		this.mkLoginpositionRel = mkLoginpositionRel;
	}
	
	public void setMkLoginmsgDict(IMkLoginmsgDict mkLoginmsgDict) {
		this.mkLoginmsgDict = mkLoginmsgDict;
	}

    /**
     * Create on 2015年4月2日
     * @author:fengjj
     * @Title: queryPositionIdByLoginNo
     * @Description: TODO 
     * @param bean
     * @return
     * @version 1.0
     * update_data:     update_author:     update_note:
     */
    @Override
    public MBean queryPositionIdByLoginNo(MBean bean) {
        
        bean.setBody("resultBean",mkLoginpositionRel.queryPositionIdByLoginNo(bean));
        return bean;
    }

    /**
     * Create on 2015-5-30 
     * @author: gengws
     * @Title: getLoginMsg 
     * @Description: 根据工号查询基本信息
     * @param inMap
     * @return 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */
	@Override
	public Map getLoginMsg(Map inMap) {
		List list=mkLoginmsgDict.selectMkLoginmsg_dict(inMap);
		Map reMap=null;
		if(CommonUtil.isNotEmpty(list)){
			reMap=(Map) list.get(0);
		}
		log.info("reMap=="+reMap.toString());
		return reMap;
	}
	
}
