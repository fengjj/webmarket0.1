package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.actiondto;

import java.util.List;
import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-4-21
 * @author: dongyh
 * @Title: AtomQueryAllActTypeInDTO
 * @Description�� ��ӡ��β���
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomQueryAllActTypeInDTO extends StandardInDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="TABLE_EN_NAME_ARR",cons=ConsType.CT001,len="30",type="compx",desc="������",memo="��")
	private List<String> tableEnNameArr;
	@ParamDesc(path="PROVINCE_GROUP",cons=ConsType.CT001,len="20",type="String",desc="ʡ�ݱ�ʶ",memo="��")
	private String provinceGroup;
	
	public void decode(MBean bean) {
		setTableEnNameArr((List<String>) bean.getList(getPathByProperName("tableEnNameArr")));
		setProvinceGroup(bean.getStr(getPathByProperName("provinceGroup")));
	}
	
	public String getProvinceGroup() {
		return provinceGroup;
	}
	
	public void setProvinceGroup(String provinceGroup) {
		this.provinceGroup = provinceGroup;
	}

	public List<String> getTableEnNameArr() {
		return tableEnNameArr;
	}

	public void setTableEnNameArr(List<String> eEnNtableEnNameArrameArr) {
		this.tableEnNameArr = eEnNtableEnNameArrameArr;
	}
	
}
