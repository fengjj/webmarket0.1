package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.ruledto;


import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-4-2
 * @author: dongyh
 * @Title: AtomQueryExeElementsInDTO
 * @Description： 自动打印入参参数
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomDelRuleItemInDTO extends StandardInDTO {
	
	private static final long serialVersionUID = 1L;

	@ParamDesc(path="ITEM_ID",cons=ConsType.CT001,type="string",len="18",desc="规则明细流水",memo="略")
	private String itemId;

	
	public void decode(MBean bean) {
		setItemId(bean.getStr(getPathByProperName("itemId")));
	}

	
	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
}
