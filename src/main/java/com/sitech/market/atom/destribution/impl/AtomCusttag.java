package com.sitech.market.atom.destribution.impl;

import com.sitech.jcfx.anno.ParamType;
import com.sitech.jcfx.anno.ParamTypes;
import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;
import com.sitech.jcfx.dt.out.OutDTO;
import com.sitech.market.atom.destribution.inter.IAtomCusttag;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardOutDTO;
import com.sitech.market.busiobject.entity.busi.inter.ICusttagInfoEntity;

/**
 * Create on 2016-7-21
 * @author: zhenggp
 * @Title: AtomCusttag
 * @Description：客户群标签服务
 * @version 1.0  
 * update_data:     update_author:     update_note:
 */

@ParamTypes({
	@ParamType(c = StandardInDTO.class, m = "queryCusttagByKeyword",oc=StandardOutDTO.class),
	@ParamType(c = StandardInDTO.class, m = "addCusttagCollectionInfo",oc=StandardOutDTO.class),
	@ParamType(c = StandardInDTO.class, m = "queryCusttagCollectionInfoByLoginNoAndCustTagId",oc=StandardOutDTO.class),
	@ParamType(c = StandardInDTO.class, m = "removeCusttagCollectionInfoByLoginNoAndCustTagId",oc=StandardOutDTO.class)
})
public class AtomCusttag implements IAtomCusttag{
	
	private ICusttagInfoEntity custtagInfoEntity;
	
	public void setCusttagInfoEntity(ICusttagInfoEntity custtagInfoEntity) {
		this.custtagInfoEntity = custtagInfoEntity;
	}

	/**
	 * Create on 2016-7-21 
	 * @author: zhenggp
	 * @Title: queryCusttagByKeyword 
	 * @Description: 根据关键字查询客户群二级标签
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public OutDTO queryCusttagByKeyword(InDTO inPara) {
		MBean paraBean=inPara.getMbean();
		MBean resultBean=custtagInfoEntity.queryCusttagByKeyword(paraBean);
		StandardOutDTO ot=new StandardOutDTO();
		ot.setBean(resultBean);
		return ot;
	}

	
	/**
	 * @author: zhenggp
	 * @Title: addCusttagCollectionInfo
	 * @Description:添加工号收藏标签信息
	 * @return 
	 * @version 1.0 
	 * date:2016-7-21
	 */
	@Override
	public OutDTO addCusttagCollectionInfo(InDTO inPara) {
		MBean paraBean=inPara.getMbean();
		MBean resultBean=custtagInfoEntity.addCusttagCollectionInfo(paraBean);
		StandardOutDTO ot=new StandardOutDTO();
		ot.setBean(resultBean);
		return ot;
	}

	/**
	 * @author: zhenggp
	 * @Title: queryCusttagCollectionInfoByLoginNoAndCustTagId
	 * @Description:查询工号是否收藏指定标签
	 * @return 
	 * @version 1.0 
	 * date:2016-7-21
	 */
	@Override
	public OutDTO queryCusttagCollectionInfoByLoginNoAndCustTagId(InDTO inPara) {
		MBean paraBean=inPara.getMbean();
		MBean resultBean=custtagInfoEntity.queryCusttagCollectionInfoByLoginNoAndCustTagId(paraBean);
		StandardOutDTO ot=new StandardOutDTO();
		ot.setBean(resultBean);
		return ot;
	}

	/**
	 * @author: zhenggp
	 * @Title: removeCusttagCollectionInfoByLoginNoAndCustTagId
	 * @Description:删除工号收藏指定标签的记录
	 * @return 
	 * @version 1.0 
	 * date:2016-7-22
	 */
	@Override
	public OutDTO removeCusttagCollectionInfoByLoginNoAndCustTagId(InDTO inPara) {
		MBean paraBean = inPara.getMbean();
		MBean resultBean = custtagInfoEntity.removeCusttagCollectionInfoByLoginNoAndCustTagId(paraBean);
		StandardOutDTO ot=new StandardOutDTO();
		ot.setBean(resultBean);
		return ot;
	}

	
	
	
}
