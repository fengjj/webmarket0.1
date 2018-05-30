package com.sitech.market.busiobject.basicclass.dtoclass;

import java.util.Map;

public interface Decodeable {
	/**
	 * InDTO层中的类必须实现的接口
	 * @author: fengjj
	 * @version: 2015-3-4
	 */
	public void decode(Map in);
}
