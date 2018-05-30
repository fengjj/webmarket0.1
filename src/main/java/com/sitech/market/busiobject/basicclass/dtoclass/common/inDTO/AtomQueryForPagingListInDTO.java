package com.sitech.market.busiobject.basicclass.dtoclass.common.inDTO;

import java.util.HashMap;
import java.util.Map;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;
import com.sitech.util.MBeanUtil;
/**
 * ��ǩ��ѯlist
 * Create on 2015-5-6 
 * @author: jiaxla
 * @Title: AtomQueryForPagingListInDTO 
 * @Description�� 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomQueryForPagingListInDTO extends StandardInDTO {
	private static final long serialVersionUID = 1L;
	
	@ParamDesc(path="SQL_ID",cons=ConsType.CT001,len="",desc="��ѯsql",type="String",memo="��")
	private String sqlId;
	@ParamDesc(path="SQL_PARAM",cons=ConsType.QUES,len="",desc="��ѯ����",type="compx",memo="��")
	private Map sqlParam;
	@ParamDesc(path="START_NUM",cons=ConsType.CT001,len="",desc="��ʼҳ��",type="int",memo="��")
	private int startNum;
	@ParamDesc(path="LIMIT_NUM",cons=ConsType.CT001,len="",desc="����ҳ��",type="int",memo="��")
	private int limitNum;
	
	@Override
	public void decode(MBean arg0){
		System.out.println("AtomQueryForPagingListInDTO  ");
		setStartNum(arg0.getInt(getPathByProperName("startNum")));
		setLimitNum(arg0.getInt(getPathByProperName("limitNum")));
		setSqlId(arg0.getStr(getPathByProperName("sqlId")));
		setSqlParam(MBeanUtil.getBodyMap(arg0, "SQL_PARAM"));
//		setSqlParam(arg0.getObject(getPathByProperName("sqlParam")));
		System.out.println("AtomQueryForPagingListInDTO end");
	}

	public String getSqlId() {
		return sqlId;
	}

	public void setSqlId(String sqlId) {
		this.sqlId = sqlId;
	}

	public Map getSqlParam() {
		return sqlParam;
	}

	public void setSqlParam(Map sqlParam) {
		this.sqlParam = sqlParam;
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getLimitNum() {
		return limitNum;
	}

	public void setLimitNum(int limitNum) {
		this.limitNum = limitNum;
	}


}
