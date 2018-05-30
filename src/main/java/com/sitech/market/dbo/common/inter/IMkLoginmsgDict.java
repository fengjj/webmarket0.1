package com.sitech.market.dbo.common.inter;


import java.util.List;
import java.util.Map;

import com.sitech.jcfx.dt.MBean;

/**
 * @author tianyy_bj
 * @date:2014-11-10 下午3:15:13
 * @version :1.0
 *
 */

public interface IMkLoginmsgDict {
    
    public Map queryLoginInfoByLoginNo(Map<String,String> map);
    
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
    public List selectMkLoginmsg_dict(Map inMap);
}
