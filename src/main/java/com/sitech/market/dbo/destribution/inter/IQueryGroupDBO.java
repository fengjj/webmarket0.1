package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

import com.sitech.crmpd.core.bean.MapBean;
import com.sitech.jcfx.anno.ServiceName;
import com.sitech.jcfx.dt.MBean;

public interface IQueryGroupDBO {
	/**
	 * 传入报文ROOT_DISTANCE和group_id  查询组织机构相应深度下的组织机构
	 */
	MBean getGroupByDistance(MBean bean) throws Exception;
	/**
	 * 获取个业务主表的group_id
	 */
	MBean getSubmitSource(MBean bean) throws Exception;
	
	/**
	 * 获取当前组织的营业厅列表
	 * @param groupId
	 * @return
	 */
	public List<Map<String, String>>  getGroupTree(String groupId);
	/**
	 * 获取当前组织的下级组织机构列表
	 * @param groupId
	 * @return
	 */
	public List getSubGroups(String groupId,String province_center);
	/**
	 * 获取组织机构本身的信息
	 * @param groupId
	 * @return
	 */
	public Map getGroupInfo(String groupId);
	
	
	/**
	 * 获取当前组织的下级组织机构列表 isAgent 为true的话查询代办点(代理) isTown 为true的话查询营业厅 两个都为true的话 都查询，两个都为false的话，不区分
	 * @param groupId
	 * @param isAgent 
	 * @author 服务 张萌  Java 林小应
	 * @throws Exception 
	 */
	public List getGroupTown_Agent(String groupId,boolean isAgent,boolean isTown) throws Exception;
	
	/**
	 * hlj获取当前组织的下级组织机构列表 isAgent 为true的话查询代办点(代理) isTown 为true的话查询营业厅 两个都为true的话 都查询，两个都为false的话，不区分
	 * @param groupId
	 * @param isAgent 
	 * @author 服务 张萌  Java 林小应
	 * @throws Exception 
	 */
	public List getGroupTown_Agents(String groupId,boolean isAgent,boolean isTown,String selectIds) throws Exception;
	
	/**
	 * 获取当前组织的下的客户经理
	 * @param groupId
	 * @author 林小应
	 * @throws Exception 
	 */
	public List getManager(String groupId,String positionCode) throws Exception;
	
	/**
	 * 获取当前操作员角色
	 * @param groupId
	 * @author 林小应
	 * @throws Exception 
	 */
	public List getRoleList(String login_no) throws Exception;
	/**
	 * 查询某个组织机构所属地市
	 * @param groupId
	 * @return
	 * @throws Exception
	 */
	public Map getRegion(String groupId) throws Exception;
	
	/**
	 * 查询组织机构下拥有指定角色的工号信息 
	 * @param groupId
	 * @param roleCode
	 * @author 林小应
	 * @throws Exception 
	 */
	public List getSpecialRoleList(String groupId,String roleCode) throws Exception;
	
	/**
	 * 查询组织机构下一级的组织结构
	 * @param groupId
	 * @param roleCode
	 * @author 林小应
	 * @throws Exception 
	 */
	public List getNextGroup(String groupId) throws Exception;
	
	/**
	 * 传入报文ROOT_DISTANCE和group_id  查询组织机构相应深度下的组织机构
	 */
	public Map getGroupByDistance(String group_id,String root_distance) throws Exception;
	/**
	 * 获取当前组织所属地市的region_id
	 * @param groupId
	 * @return
	 */
	public List getRegionId(String groupId,String province_center)throws Exception;
	/**
	 * 
	 * @param group_id
	 * @param region_id
	 * @return List<BeanMap>  key==>value
	 */
	public List getGroupMsg(String group_id,String region_id);
	/**
	 * 
	 * @param login_no
	 * @param region_id
	 * @return List<BeanMap>  key==>value
	 */
	public List getLoginMsg(String login_no,String region_id);
	/**
	 * @param oa_login_no
	 * @return List<BeanMap>  key==>value
	 */
	public MapBean getLoginMsg(String oa_login_no);
	/**
	 * @description 采用基础域加、解密码算法
	 * @param 加密1 解码0
	 * @param 待加、解密的字符串
	 * @return ret_code ret_msg, ret_value
	 */
	public Map getEncrypt(String oper_type,String oa_login_no);
}
