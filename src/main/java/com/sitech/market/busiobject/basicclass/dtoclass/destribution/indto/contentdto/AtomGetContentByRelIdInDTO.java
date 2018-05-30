package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.contentdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;

/**
 * Create on 2015-7-2 
 * @author: gengws
 * @Title: AtomGetContentByRelIdInDTO 
 * @Description： 根据rel_id查询mk_mk_busicontent_rel InDTO
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomGetContentByRelIdInDTO extends InDTO{

	@ParamDesc(path="REL_ID",cons=ConsType.CT001,type="String",len="64",desc="活动ID",memo="略")
	String relId;
	
	@Override
	public void decode(MBean bean) {
		this.relId=(String) bean.getObject(getPathByProperName("relId"));
	}

	public String getRelId() {
		return relId;
	}
	public void setRelId(String relId) {
		this.relId = relId;
	}
	
	
}
