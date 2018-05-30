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
 * 查询标签出参
 * Create on 2015-5-6 
 * @author: jiaxla
 * @Title: AtomQueryForPagingListOutDTO 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomQueryForPagingListOutDTO extends StandardOutDTO {

	@ParamDesc(path="RESULT_LIST",cons=ConsType.CT001,len="100",type="compx",desc="集合查询结果集",memo="略")
	private List<Map> resultList;
	@ParamDesc(path="SUM",cons=ConsType.CT001,len="100",type="int",desc="总数",memo="略")
	private int sum;
	@Override
	public MBean encode() {
		MBean bean = new MBean();
		List<Map> list = new ArrayList<Map>();
		bean.addBody("RESULT_LIST", getResultList());
		bean.addBody("SUM", getSum());
		return bean;
	}

	public List<Map> getResultList() {
		return resultList;
	}

	public void setResultList(List<Map> resultList) {
		this.resultList = resultList;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
	
}
