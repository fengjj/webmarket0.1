package com.sitech.market.busiobject.basicclass.dtoclass;

import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.out.OutDTO;

/**
 * @Description: 标准出参DTO
 * @author: fengjj
 * @version: 
 */

public class StandardOutDTO extends OutDTO
{
	private static final long serialVersionUID = -8512527356609332824L;
	private MBean bean;
	
	@Override
	public MBean encode()
	{
		return getBean();
	}

	public MBean getBean() {
        return bean;
    }


    public void setBean(MBean bean) {
        this.bean = bean;
    }
}
