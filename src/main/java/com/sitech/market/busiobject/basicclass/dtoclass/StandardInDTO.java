package com.sitech.market.busiobject.basicclass.dtoclass;

import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;

/**
 * @Description: 基础业务类
 * @author: fengjj
 */

public class StandardInDTO extends InDTO
{
	private static final long serialVersionUID = 8011451429059378568L;
	private MBean bean;
	
	@Override
	public void decode(MBean arg0){
		this.bean = arg0;
	}

	public MBean getBean() {
		return bean;
	}

}
