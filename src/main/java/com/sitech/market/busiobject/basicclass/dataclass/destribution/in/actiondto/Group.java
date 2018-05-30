package com.sitech.market.busiobject.basicclass.dataclass.destribution.in.actiondto;

import java.util.Map;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.market.busiobject.basicclass.dtoclass.Decodeable;
/**
 * 获取基础域组织机构实体类
 * @author tianyy_bj
 *
 */
public class Group implements Decodeable {

	@ParamDesc(path="groupId",cons=ConsType.CT001,type="String",len="40",desc="组织机构id",memo="")
	private String groupId;
	@ParamDesc(path="groupName",cons=ConsType.CT001,type="String",len="40",desc="组织机构名称",memo="")
	private String groupName;
	@ParamDesc(path="regionCode",cons=ConsType.CT001,type="String",len="20",desc="归属地市",memo="")
	private String regionCode;

	@Override
	public void decode(Map bean) {
		this.groupId = (String) bean.get("groupId");
		this.groupName = (String) bean.get("groupName");
		this.regionCode = (String) bean.get("regionCode");
	}

	public String getGroupId() {
		return groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public String getregionCode() {
		return regionCode;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public void setregionCode(String regionCode) {
		this.regionCode = regionCode;
	}
}
