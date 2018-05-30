package com.sitech.market.busiobject.basicclass.dataclass;

import java.util.Map;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.market.busiobject.basicclass.dtoclass.Decodeable;

public class ConfirmData implements Decodeable{
	@ParamDesc(path="SERIAL_ID",cons=ConsType.CT001,type="String",len="20",desc="分表序列id",memo="")
	String serialId;
	@ParamDesc(path="TABLE_NAME",cons=ConsType.CT001,type="String",len="20",desc="分表编号",memo="")
	String tableName;
	@Override
	public void decode(Map in) {
		setSerialId(toStr(in.get("SERIAL_ID")));
		setTableName(toStr(in.get("TABLE_NAME")));
	}
	public String getSerialId() {
		return serialId;
	}
	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
    public String toStr(Object obj){
    	if(obj == null){
    		return "";
    	}
    	return obj+"";
    	
    }
	
}
