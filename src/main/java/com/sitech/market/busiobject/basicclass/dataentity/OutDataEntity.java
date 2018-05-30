package com.sitech.market.busiobject.basicclass.dataentity;

import com.sitech.market.busiobject.basicclass.dtoclass.StandardOutDTO;
/**输出数据实体基类
 * create on 2014-11-04
 * @author sunliang
 */
public abstract class OutDataEntity extends DataEntity {
	/**将输出实体转化为DTO
	 * create on 2014-11-04
	 * @author sunliang
	 */
	public abstract StandardOutDTO parseOutDTO(Object object);

}


