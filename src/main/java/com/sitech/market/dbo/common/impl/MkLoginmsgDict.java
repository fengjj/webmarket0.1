package com.sitech.market.dbo.common.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sitech.jcf.core.exception.BaseException;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.common.inter.IMkLoginmsgDict;
import com.sitech.util.MBeanUtil;

/**
 * @author tianyy_bj
 *
 * @date:2014-11-10 下午3:16:37
 * @version :1.0
 *
 */

public class MkLoginmsgDict extends DBMysqlClass implements IMkLoginmsgDict {
    
	/**
	 *  根据工号查询mk_loginmsg_dict
	 * Create on 2015-03-06
	 * @author yugl
	 * @version 1.0
	 * Copyright(c) 北京思特奇信息技术股份有限公司
	 * 修改日期:     修改人:     修改目的:
	 */
    public  Map queryLoginInfoByLoginNo(Map<String,String> map){
        Map resultMap = new HashMap();
    	try {
    		resultMap = (Map) baseDao.queryForObject("MkLoginmsgDict.selectMkLoginmsgDictById",map);
        } catch (Exception e) {
            throw new BaseException("queryLoginInfoByLoginNo", "亲,queryLoginInfoByLoginNo出异常了,到后台看看吧" + e);
        }
        return resultMap;
    }

    /**
     * Create on 2015-5-30 
     * @author: gengws
     * @Title: selectMkLoginmsg_dict 
     * @Description: 所有调减查询mk_loginmsg_dict
     * @param inMap
     * @return 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */
	@Override
	public List selectMkLoginmsg_dict(Map inMap) {
		List list=baseDao.queryForList("MkLoginmsgDict.selectMkLoginmsgDict",inMap);
		return list;
	}

}
