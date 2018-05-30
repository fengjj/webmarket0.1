package com.sitech.market.busiobject.basicclass.dataentity;

import com.sitech.market.busiobject.basicclass.BaseClass;
import com.sitech.market.busiobject.entity.busi.inter.IUserAtomEntity;
/**数据实体基类
 * create on 2014-11-05
 * @author sunliang
 */

public class DataEntity extends BaseClass {
	//注入UserEntity实体
    protected IUserAtomEntity userEntity;
	public void setUserEntity(IUserAtomEntity userAtomEntity) {
        this.userEntity = userAtomEntity;
        
    }
}
