package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.combo;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-7-31
 * 
 * @author:
 * @Title: AtomQueryPrcidAddListInDTO
 * @Description£∫ Ã◊≤Õ≈‰÷√ ˝æ›≤È—ØDTO
 * @version 1.0 update_data: update_author: update_note:
 */
public class AtomQueryPrcidAddListInDTO extends StandardInDTO {
	private static final long serialVersionUID = 1L;
	@ParamDesc(path = "SERIAL_ID", cons = ConsType.CT001, len = "30", type = "String", desc = "–Ú¡–∫≈", memo = "¬‘")
	private String serialId;
	@ParamDesc(path = "REGION_CODE", cons = ConsType.STAR, len = "100", type = "String", desc = "µÿ –±‡¬Î", memo = "¬‘")
	private String regionCode;
	public void decode(MBean bean) {
		setSerialId(bean.getBodyStr("serialId"));
		setRegionCode(bean.getBodyStr("regionCode"));

		System.out.println(bean.getBodyStr("serialId"));
		System.out.println(bean.getBodyStr("regionCode"));
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getRegionCode() {
		return regionCode;
	}
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	public String getSerialId() {
		return serialId;
	}
	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}
	
	
	
}
