package com.sitech.market.busiobject.basicclass.dtoclass.common.outDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dataclass.common.out.atom.CodeName;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardOutDTO;
/**
 * 查询mk_codename_dict信息outDTO
 * Create on 2015-5-6 
 * @author: wangdw
 * @Title: AtomQueryCodeNameOutDTO 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomQueryCodeNameOutDTO extends StandardOutDTO {

	@ParamDesc(path="CODENAME_LIST",cons=ConsType.STAR,len="100",type="compx",desc="codename集合",memo="略")
	private List<CodeName> codenameList;
	
	@Override
	public MBean encode() {
		MBean bean = new MBean();
		List<Map> list = new ArrayList<Map>();
		for (CodeName codeName : getCodenameList()) {
			list.add(codeName.encode());
		}
		bean.addBody("CODENAME_LIST", list);
		return bean;
	}

	public List<CodeName> getCodenameList() {
		return codenameList;
	}

	public void setCodenameList(List<CodeName> codenameList) {
		this.codenameList = codenameList;
	}

	
}
