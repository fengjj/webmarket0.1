package com.sitech.market.dbo.destribution.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.sitech.jcf.transaction.JCFTransactionInterceptor;
import com.sitech.jcfx.context.JCFContext;
import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkImportbusiTmp;

public class MkImportbusiTmp extends DBMysqlClass implements IMkImportbusiTmp {

	/** 
	 * Create on 2015-7-2 
	 * @author: songxj
	 * @Title: selectMkImportbusiTmp 
	 * @Description: 查询mk_importbusi_tmp
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note: 
	 */
	@Override
	public List selectMkImportbusiTmp(Map inMap) {
		return baseDao.queryForList("MkImportbusiTmp.selectMkImportbusiTmp", inMap);
	}

	/** 
	 * Create on 2015-7-2 
	 * @author: songxj
	 * @Title: insertMkImportbusiTmp 
	 * @Description: 插入mk_importbusi_tmp
	 * @param inMap 
	 * @version 1.0 
	 * update_data:       update_author:       update_note: 
	 */
	@Override
	public void insertMkImportbusiTmp(Map inMap) {
		baseDao.insert("MkImportbusiTmp.insertMkImportbusiTmp", inMap);
	}
	
	/**
	 * 批量插入
	 * @Create on 2015-7-29 
	 * @author: wangdw
	 * @Title: batchInsertMkImportbusiTmp 
	 * @Description: 
	 * @param inMap 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	@Override
	public void batchInsertMkImportbusiTmp(List<Map> inList) {
		baseDao.batchInsert("MkImportbusiTmp.insertMkImportbusiTmp", inList);
	}

	/** 
	 * Create on 2015-7-2 
	 * @author: songxj
	 * @Title: updateMkImportbusiTmp 
	 * @Description: 更新mk_importbusi_tmp
	 * @param inMap 
	 * @version 1.0 
	 * update_data:       update_author:       update_note: 
	 */
	@Override
	public void updateMkImportbusiTmp(Map inMap) {
		baseDao.update("MkImportbusiTmp.updateMkImportbusiTmp", inMap);
		try {
			this.baseDao.getConnection().commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (baseDao.getConnection() != null) {
				try {
					baseDao.getConnection().close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/** 
	 * Create on 2015-7-2 
	 * @author: songxj
	 * @Title: queryOneThousandMkImportbusiTmpBySeqNo 
	 * @Description: 通过seq_no一次性最多查询mk_importbusi_tmp 1000条数据
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note: 
	 */
	@Override
	public List queryOneThousandMkImportbusiTmpBySeqNo(Map inMap) {
		return baseDao.queryForList("MkImportbusiTmp.queryOneThousandMkImportbusiTmpBySeqNo", inMap);
	}

	/** 
	 * Create on 2015-7-22 
	 * @author: songxj
	 * @Title: deletedeleteMkImportbusiTmpById 
	 * @Description: 删除操作
	 * @param inMap 
	 * @version 1.0 
	 * update_data:       update_author:       update_note: 
	 */
	@Override
	public void deletedeleteMkImportbusiTmpById(Map inMap) {
		baseDao.delete("MkImportbusiTmp.deleteMkImportbusiTmpById", inMap);
		try {
			this.baseDao.getConnection().commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (baseDao.getConnection() != null) {
				try {
					baseDao.getConnection().close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		/*JCFTransactionInterceptor aaa = (JCFTransactionInterceptor) JCFContext.getBean("proxyTemplate");
		PlatformTransactionManager bb = aaa.getTransactionManager(); 
		DefaultTransactionDefinition dt = new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED);
		dt.setReadOnly(true);
		TransactionStatus  status = bb.getTransaction(dt);
		bb.commit(status);*/
	}
	
}
