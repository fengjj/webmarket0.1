package com.sitech.market.atom.destribution.inter;

import com.sitech.jcfx.dt.in.InDTO;
import com.sitech.jcfx.dt.out.OutDTO;

public interface IAtomAudit {

    
    
    /**
     * 审批结果提交
     * Create on 2015-3-23
     * @author: hanzh_bj
     * @Title: submitAudit
     * @Description: TODO 
     * @param inDTO
     * @return
     * @return OutDTO
     * @version 1.0
     * update_data:     update_author:     update_note:
     */
    public OutDTO submitAudit(InDTO inDTO);
    
    /**
     * Create on 2015-5-11 
     * @author: dongyh
     * @Title: queryApprover 
     * @Description: 查询审批人
     * @param inDTO
     * @return 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */
    public OutDTO queryApprover(InDTO inDTO);
    
    /**
     * Create on 2015-5-11 
     * @author: dongyh
     * @Title: saveAudit 
     * @Description: 选择审批人，提交审批
     * @param inDTO
     * @return 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */
    public OutDTO saveAudit(InDTO inDTO);
    
    /**
     * Create on 2015-6-1 
     * @author: dongyh
     * @Title: queryAuditName 
     * @Description: 执行中活动查询审批人名称
     * @param inDTO
     * @return 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */
    public OutDTO queryAuditName(InDTO inDTO);

    /**
     * Create on 2015-6-26 
     * @author: liuhaoa
     * @Title: auditList 
     * @Description: 审批列表
     * @param inDTO
     * @return 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */
    public OutDTO auditList(InDTO inDTO);
    
    /**
     * Create on 2015-6-26 
     * @author: liuhaoa
     * @Title: auditResultCount 
     * @Description: 审批列表总条数
     * @param inDTO
     * @return 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */    
    public OutDTO auditResultCount(InDTO inDTO);
    
    /**
     * Create on 2015-7-7 
     * @author: liuhaoa
     * @Title: auditLevelByClassValue 
     * @Description: 获取下一级审批人
     * @param inDTO
     * @return 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */
    public OutDTO auditLevelByClassValue(InDTO inDTO);
    
    /**
     * Create on 2015-7-8
     * @author: liuhaoa
     * @Title: auditStatusCode 
     * @Description: 提交至待预发布状态
     * @param inDTO
     * @return 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */
    public OutDTO auditStatusCode(InDTO inDTO);
}
