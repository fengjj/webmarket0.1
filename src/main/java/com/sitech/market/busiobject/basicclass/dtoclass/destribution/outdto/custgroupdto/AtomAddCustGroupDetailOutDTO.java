package com.sitech.market.busiobject.basicclass.dtoclass.destribution.outdto.custgroupdto;

import java.util.Map;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardOutDTO;

/**
 * Create on 2015-6-8
 * @author: liuhaoa
 * @Title: AtomAddCustGroupDetailOutDTO 
 * @Description�� Ŀ��ͻ�Ⱥ��������
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomAddCustGroupDetailOutDTO extends StandardOutDTO {
	
	private static final long serialVersionUID = 1L;
	@ParamDesc(path="SEQ",cons=ConsType.CT001,len="100",desc="����",type="String",memo="��")
	private String seq;

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public MBean encode() {
		MBean resultBean = new MBean();
		resultBean.setBody("seq",getSeq());
		return resultBean;
	}
}
