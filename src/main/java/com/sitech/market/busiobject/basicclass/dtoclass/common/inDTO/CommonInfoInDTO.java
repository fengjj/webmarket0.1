package com.sitech.market.busiobject.basicclass.dtoclass.common.inDTO;

import java.util.Map;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.market.busiobject.basicclass.dtoclass.Decodeable;
import com.sitech.market.busiobject.basicclass.dtoclass.Encodeable;

public class CommonInfoInDTO implements Decodeable,Encodeable{

    @ParamDesc(path="PROVINCE_GROUP",cons=ConsType.CT001,len="100",desc="Ê¡·Ý±àÂë",type="String",memo="ÂÔ")
    private String provinceGroup;
    
    @Override
    public void decode(Map in) {
        this.provinceGroup = (String) in.get("PROVINCE_GROUP");
    }

    public String getProvinceGroup() {
        return provinceGroup;
    }

    public void setProvinceGroup(String provinceGroup) {
        this.provinceGroup = provinceGroup;
    }

    @Override
    public Map<String, Object> encode() {
        // TODO Auto-generated method stub
        return null;
    }

    
}
