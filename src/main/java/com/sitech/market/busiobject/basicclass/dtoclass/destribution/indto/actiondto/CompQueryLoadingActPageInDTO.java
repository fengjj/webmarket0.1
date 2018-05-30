package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.actiondto;

import java.util.List;
import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-4-25
 * @author: dongyh
 * @Title: CompQueryLoadingActPageInDTO
 * @Description： 打印入参参数
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class CompQueryLoadingActPageInDTO extends StandardInDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="SUB_ID",cons=ConsType.CT001,type="string",len="5",desc="元素配置类型",memo="0：策划界面 1：执行界面-活动列表查询 2：执行界面-活动办理")
	private String subId;
	@ParamDesc(path="PROVINCE_GROUP",cons=ConsType.CT001,type="string",len="20",desc="省份标识",memo="略")
	private String provinceGroup;
	@ParamDesc(path="TABLE_EN_NAME_ARR",cons=ConsType.PLUS,len="30",type="compx",desc="表名称",memo="略")
	private List<String> tableEnNameArr;
	
	public void decode(MBean bean){
		System.out.println("..................bean:"+bean);
		setSubId(bean.getStr(getPathByProperName("subId")));
		setProvinceGroup(bean.getStr(getPathByProperName("provinceGroup")));
		setTableEnNameArr((List<String>) bean.getList(getPathByProperName("tableEnNameArr")));
	}
	
	public String getSubId() {
		return subId;
	}
	
	public void setSubId(String subId) {
		this.subId = subId;
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

	public void setTableEnNameArr(List<String> tableEnNameArr) {
		this.tableEnNameArr = tableEnNameArr;
	}
	
}
