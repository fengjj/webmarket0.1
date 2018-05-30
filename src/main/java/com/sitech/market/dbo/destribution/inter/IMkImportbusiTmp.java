package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

public interface IMkImportbusiTmp {

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
	public List selectMkImportbusiTmp(Map inMap);
	
	/** 
	 * Create on 2015-7-2 
	 * @author: songxj
	 * @Title: insertMkImportbusiTmp 
	 * @Description: 插入mk_importbusi_tmp
	 * @param inMap 
	 * @version 1.0 
	 * update_data:       update_author:       update_note: 
	 */
	public void insertMkImportbusiTmp(Map inMap);
	
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
	public void batchInsertMkImportbusiTmp(List<Map> inList);
	
	/** 
	 * Create on 2015-7-2 
	 * @author: songxj
	 * @Title: updateMkImportbusiTmp 
	 * @Description: 更新mk_importbusi_tmp
	 * @param inMap 
	 * @version 1.0 
	 * update_data:       update_author:       update_note: 
	 */
	public void updateMkImportbusiTmp(Map inMap);
	
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
	public List queryOneThousandMkImportbusiTmpBySeqNo(Map inMap);
	
	/** 
	 * Create on 2015-7-22 
	 * @author: songxj
	 * @Title: deleteMkImportbusiTmp 
	 * @Description: 删除MkImportbusiTmp临时表数据
	 * @param inMap 
	 * @version 1.0 
	 * update_data:       update_author:       update_note: 
	 */
	public void deletedeleteMkImportbusiTmpById(Map inMap);
}
