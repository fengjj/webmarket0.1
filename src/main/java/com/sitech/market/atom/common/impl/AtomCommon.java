package com.sitech.market.atom.common.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sitech.jcfx.anno.ParamType;
import com.sitech.jcfx.anno.ParamTypes;
import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;
import com.sitech.jcfx.dt.out.OutDTO;
import com.sitech.market.atom.common.inter.IAtomCommon;
import com.sitech.market.busiobject.basicclass.BaseClass;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardOutDTO;
import com.sitech.market.busiobject.entity.common.inter.ICommonAtomEntity;
import com.sitech.util.MBeanUtil;
/**
 * 公共信息读取原子服务
 * Create on 2015-5-6 
 * @author: wangdw
 * @Title: AtomCommon 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
@ParamTypes({ 
    @ParamType(c = StandardInDTO.class, m = "queryCodeName", oc = StandardOutDTO.class),
    @ParamType(c = StandardInDTO.class, m = "queryForPagingList", oc = StandardOutDTO.class)
    })
public class AtomCommon extends BaseClass implements IAtomCommon {
	

	private ICommonAtomEntity commonAtomEntity;

	/**
	 * 获得mk_codename_dict表信息
	 * Create on 2015-5-6 
	 * @author: wangdw
	 * @Title: queryCodeName 
	 * @Description: 
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public OutDTO queryCodeName(InDTO inDTO) {
		//入参处理
		Map<String,String> inMap = new HashMap<String,String>();
		inMap.put("tableEnName", inDTO.getMbean().getBodyStr("TABLE_EN_NAME"));
		inMap.put("tableCnName", inDTO.getMbean().getBodyStr("TABLE_CN_NAME"));
		inMap.put("fieldEnName", inDTO.getMbean().getBodyStr("FIELD_EN_NAME"));
		inMap.put("fieldCnName", inDTO.getMbean().getBodyStr("FIELD_CN_NAME"));
		inMap.put("fieldValue", inDTO.getMbean().getBodyStr("FIELD_VALUE"));
		inMap.put("fieldDesc", inDTO.getMbean().getBodyStr("FIELD_DESC"));
		inMap.put("fieldUrl", inDTO.getMbean().getBodyStr("FIELD_URL"));
		inMap.put("assiTableenname", inDTO.getMbean().getBodyStr("ASSI_TABLENNAME"));
		inMap.put("assiFieldenname", inDTO.getMbean().getBodyStr("ASSI_FIELDENNAME"));
		inMap.put("assiFieldvalue", inDTO.getMbean().getBodyStr("ASSI_FIELDVALUE"));
		inMap.put("provinceGroup", inDTO.getMbean().getBodyStr("PROVINCE_GROUP"));
		inMap.put("outFieldenname", inDTO.getMbean().getBodyStr("OUT_FIELDENNAME"));
		inMap.put("outFieldcnname", inDTO.getMbean().getBodyStr("OUT_FIELDCNNAME"));
		inMap.put("outSystemType", inDTO.getMbean().getBodyStr("OUT_SYSTEM_TYPE"));
		
		//业务处理
		Map outMapList = commonAtomEntity.queryCodeName(inMap);
		
		//出参处理
		StandardOutDTO outDTO = new StandardOutDTO();
		List<Map> codeMapList = (List<Map>)outMapList.get("codenameList");
		List<Map> resultMapList = new ArrayList<Map>();//返回给前端的list
		//将codeMapList转化为resultMapList
		for(Map in : codeMapList){
			Map out = new HashMap();
			out.put("TABLE_EN_NAME", in.get("tableEnName"));
			out.put("TABLE_CN_NAME", in.get("tableCnName"));
			out.put("FIELD_EN_NAME", in.get("fieldEnName"));
			out.put("FIELD_CN_NAME", in.get("fieldCnName"));
			out.put("FIELD_VALUE", in.get("fieldValue"));
			out.put("FIELD_DESC", in.get("fieldDesc"));
			out.put("FIELD_URL", in.get("fieldUrl"));
			out.put("ASSI_TABLENNAME", in.get("assiTableenname"));
			out.put("ASSI_FIELDENNAME", in.get("assiFieldenname"));
			out.put("ASSI_FIELD_VALUE", in.get("assiFieldValue"));
			out.put("PROVINCE_GROUP", in.get("provinceGroup"));
			out.put("OUT_FIELDENNAME", in.get("outFieldenname"));
			out.put("OUT_FIELDCNNAME", in.get("outFieldcnname"));
			out.put("OUT_SYSTEM_TYPE", in.get("outSystemType"));
			resultMapList.add(out);
		}
		
		MBean bean = new MBean();
		bean.addBody("CODENAME_LIST", resultMapList);
		outDTO.setBean(bean);
		return outDTO;
	}
	/**
	 * Create on 2015-6-16
	 * @author:jiaxla
	 * @Title: 分页标签查询
	 * @Description:
	 * @return
	 * version 1.0
	 * update_date:            update_author:              update_note
	 */
	@Override
	public OutDTO queryForPagingList(InDTO inDTO) {
		//入参处理
		Map inMap = new HashMap();
		inMap.put("sqlId", inDTO.getMbean().getBodyStr("SQL_ID"));
		inMap.put("sqlParam", MBeanUtil.getBodyMap(inDTO.getMbean(), "SQL_PARAM"));
		inMap.put("startNum", inDTO.getMbean().getBodyInt("START_NUM"));
		inMap.put("limitNum", inDTO.getMbean().getBodyInt("LIMIT_NUM"));
		
		//业务处理
		Map outMapList = commonAtomEntity.queryForPagingList(inMap);
		
		//出参处理
		StandardOutDTO outDTO = new StandardOutDTO(); 
		List<Map> result = (List<Map>)outMapList.get("result");
		int sum = (Integer) outMapList.get("sum");
		MBean resultBean = new MBean();
		resultBean.addBody("RESULT_LIST", result);
		resultBean.addBody("SUM", sum);
		outDTO.setBean(resultBean);
		return outDTO;
	}

	
	public void setCommonAtomEntity(ICommonAtomEntity commonAtomEntity) {
		this.commonAtomEntity = commonAtomEntity;
	}

}
