package com.sitech.market.busiobject.basicclass.dtoclass.common.outDTO;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardOutDTO;
/**
 * ���������dto�����籣�桢ɾ�����Լ��޸ĵȣ����������ڳɹ��󷵻�id��name����һ����ʶ������д��һ��������
 * Create on 2015-4-22 
 * @author: wangdw
 * @Title: CommonFlagOutDTO 
 * @Description�� 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class CommonFlagOutDTO extends StandardOutDTO {
	private static final long serialVersionUID = -4819894405219659836L;
	
	@ParamDesc(path="ID",cons=ConsType.CT001,type="string",len="18",desc="ID",memo="��")
	private String id;
	@ParamDesc(path="NAME",cons=ConsType.CT001,type="string",len="200",desc="����",memo="��")
	private String name;
	@ParamDesc(path="RESULT_FLAG",cons=ConsType.CT001,type="string",len="10",desc="���ر���",memo="��")
	private String resultFlag;
	@ParamDesc(path="RESULT_MSG",cons=ConsType.CT001,type="string",len="100",desc="������Ϣ",memo="��")
	private String resultMsg;
	

	@Override
	public MBean encode() {
		MBean resultBean = new MBean();
		resultBean.setBody("ID",getId());
		resultBean.setBody("NAME",getName());
		resultBean.setBody("RESULT_FLAG",getResultFlag());
		resultBean.setBody("RESULT_MSG",getResultMsg());
		return resultBean;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResultFlag() {
		return resultFlag;
	}

	public void setResultFlag(String resultFlag) {
		this.resultFlag = resultFlag;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

}
