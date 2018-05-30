package com.sitech.market.busiobject.basicclass.dtoclass.common.inDTO;

import java.util.List;
import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * 
* Create on 2015-4-2
* @author: dongyh
* @Title: AtomQueryLoginInfoByPositionIdInDTO
* @Description： 自动打印入参参数
* @version 1.0 
* update_data:      update_author:      update_note:
 */
public class AtomQueryLoginInfoByPositionIdInDTO extends StandardInDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="positionIdList",cons=ConsType.STAR,type="String",len="100",desc="审批人岗位",memo="略")
	private List<String> positionIdList;

	public void decode(MBean bean) {
		setPositionIdList((List<String>) bean.getList(getPathByProperName("positionIdList")));
	}

	public List<String> getPositionIdList() {
		return positionIdList;
	}

	public void setPositionIdList(List<String> tionpositionIdListIdList) {
		this.positionIdList = tionpositionIdListIdList;
	}
}
