package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.actiondto;

import java.util.List;
import java.util.Map;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;
import com.sitech.util.ParamUtil;

/**
 * ���渽���ͻ�ȺinDTO
 * @Create on 2015-7-29 
 * @author: wangdw
 * @Title: AtomSaveAttachCustGroupInDTO 
 * @Description�� 
 * @version 1.0 
 * update_date:      update_author:      update_note:
 */
@SuppressWarnings("unchecked")
public class AtomSaveAttachCustGroupInDTO extends StandardInDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="ORIGINAL_NAME",cons=ConsType.CT001,len="255",type="String",desc="����ԭʼ�ļ���",memo="��")
	private String originalName;
	@ParamDesc(path="SYSTEM_NAME",cons=ConsType.CT001,len="255",type="String",desc="����ϵͳ�ļ���",memo="��")
	private String systemName;
	@ParamDesc(path="ATTACH_TYPE",cons=ConsType.CT001,len="5",type="String",desc="��������",memo="��")
	private String attachType;
	@ParamDesc(path="ATTACH_CLASS",cons=ConsType.CT001,len="5",type="String",desc="����С��",memo="��")
	private String attachClass;
	@ParamDesc(path="ATTACH_PATH",cons=ConsType.CT001,len="200",type="String",desc="����·��",memo="��")
	private String attachPath;
	@ParamDesc(path="ATTACH_WIDTH",cons=ConsType.QUES,len="10",type="long",desc="����������",memo="��")
	private long attachWidth;
	@ParamDesc(path="ATTACH_HEIGHT",cons=ConsType.QUES,len="10",type="long",desc="�����ߣ�����",memo="��")
	private long attachHeight;
	@ParamDesc(path="FILE_SIZE",cons=ConsType.CT001,len="10",type="long",desc="������С,�ֽ�",memo="��")
	private long fileSize;
	@ParamDesc(path="ATTACH_NOTE",cons=ConsType.QUES,len="500",type="String",desc="��ע",memo="��")
	private String attachNote;
	@ParamDesc(path="STATUS_CODE",cons=ConsType.CT001,len="5",type="String",desc="��������״̬",memo="��")
	private String statusCode;
	@ParamDesc(path="OPER_NO",cons=ConsType.CT001,len="20",type="String",desc="��������",memo="��")
	private String operNo;
	@ParamDesc(path="OPER_NAME",cons=ConsType.CT001,len="64",type="String",desc="������������",memo="��")
	private String operName;
	@ParamDesc(path="BUSI_ID",cons=ConsType.CT001,len="18",type="string",desc="ҵ��ID",memo="��")
	private String busiId;
	@ParamDesc(path="BUSI_TYPE",cons=ConsType.CT001,len="5",type="string",desc="ҵ������",memo="��")
	private String busiType;
	@ParamDesc(path="IMPORT_BUSI_TYPE",cons=ConsType.QUES,len="5",type="string",desc="������������",memo="��")
	private String importBusiType;
	@ParamDesc(path="CUST_REL_SERIAL_ID",cons=ConsType.QUES,len="18",type="string",desc="ҵ��ͻ�Ⱥ��ϵid",memo="��")
	private String custRelSerialId;
	@ParamDesc(path="CUST_LIST",cons=ConsType.STAR,len="100000",type="compx",desc="�����������ݼ���",memo="��")
	private List<Map> custList;
	@ParamDesc(path="REGION_CODE",cons=ConsType.STAR,len="100",type="string",desc="���б���",memo="��")
	private String regionCode;
	



	public void decode(MBean bean){
		setOriginalName(bean.getStr(getPathByProperName("originalName")));
		setSystemName(bean.getStr(getPathByProperName("systemName")));
		setAttachType(bean.getStr(getPathByProperName("attachType")));
		setAttachClass(bean.getStr(getPathByProperName("attachClass")));
		setAttachPath(bean.getStr(getPathByProperName("attachPath")));
		setAttachWidth(bean.getLong(getPathByProperName("attachWidth")));
		setAttachHeight(bean.getLong(getPathByProperName("attachHeight")));
		setFileSize(bean.getLong(getPathByProperName("fileSize")));
		setAttachNote(bean.getStr(getPathByProperName("attachNote")));
		setStatusCode(bean.getStr(getPathByProperName("statusCode")));
		setOperNo(bean.getStr(getPathByProperName("operNo")));
		setOperName(bean.getStr(getPathByProperName("operName")));
		setBusiId(bean.getStr(getPathByProperName("busiId")));
		setBusiType(bean.getStr(getPathByProperName("busiType")));
		setImportBusiType(bean.getStr(getPathByProperName("importBusiType")));
		setCustRelSerialId(bean.getStr(getPathByProperName("custRelSerialId")));
		setRegionCode(bean.getStr(getPathByProperName("regionCode")));
		List<Map> list = (List<Map>)bean.getList(getPathByProperName("custList"));
		list = (List<Map>)ParamUtil.parseCapital2Hump(list);
		setCustList(list);
	}
	
	public String getOriginalName() {
		return originalName;
	}
	
	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}
	
	public String getSystemName() {
		return systemName;
	}
	
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	
	public String getAttachType() {
		return attachType;
	}
	
	public void setAttachType(String attachType) {
		this.attachType = attachType;
	}
	
	public String getAttachClass() {
		return attachClass;
	}
	
	public void setAttachClass(String attachClass) {
		this.attachClass = attachClass;
	}
	
	public String getAttachPath() {
		return attachPath;
	}
	
	public void setAttachPath(String attachPath) {
		this.attachPath = attachPath;
	}
	
	public long getAttachWidth() {
		return attachWidth;
	}

	public void setAttachWidth(long attachWidth) {
		this.attachWidth = attachWidth;
	}

	public long getAttachHeight() {
		return attachHeight;
	}

	public void setAttachHeight(long attachHeight) {
		this.attachHeight = attachHeight;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getAttachNote() {
		return attachNote;
	}
	
	public void setAttachNote(String attachNote) {
		this.attachNote = attachNote;
	}
	
	public String getStatusCode() {
		return statusCode;
	}
	
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	
	public String getOperNo() {
		return operNo;
	}
	
	public void setOperNo(String operNo) {
		this.operNo = operNo;
	}
	
	public String getOperName() {
		return operName;
	}
	
	public void setOperName(String operName) {
		this.operName = operName;
	}

	public String getBusiId() {
		return busiId;
	}

	public void setBusiId(String busiId) {
		this.busiId = busiId;
	}

	public String getBusiType() {
		return busiType;
	}

	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}
	public String getImportBusiType() {
		return importBusiType;
	}

	public void setImportBusiType(String importBusiType) {
		this.importBusiType = importBusiType;
	}
	public String getCustRelSerialId() {
		return custRelSerialId;
	}

	public void setCustRelSerialId(String custRelSerialId) {
		this.custRelSerialId = custRelSerialId;
	}

	public List<Map> getCustList() {
		return custList;
	}

	public void setCustList(List<Map> ListcustList) {
		this.custList = ListcustList;
	}
	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

}
