package com.sitech.market.busiobject.basicclass.dtoclass.destribution.outdto.custgroupdto;

import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardOutDTO;

/**
 * 确认或取消批量赠流量，修改活动和客户群关系表状态
 * @Create on 2015-9-12 
 * @author: liuhaoa
 * @Title: AtomUpdateGiveProStatusOutDTO 
 * @Description： 
 * @version 1.0 
 * update_date:      update_author:      update_note:
 */
@SuppressWarnings("serial")
public class AtomUpdateGiveProStatusOutDTO extends StandardOutDTO {

	private static final long serialVersionUID = 1L;
	
	@Override
	public MBean encode(){
		return new MBean();
	}
}
