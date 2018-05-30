package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.actiondto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-5-14
 * @author: dongyh
 * @Title: AtomSaveAttachInDTO
 * @Description： 打印入参参数
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomSaveAttachInDTO extends StandardInDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="ORIGINAL_NAME",cons=ConsType.CT001,len="255",type="String",desc="附件原始文件名",memo="略")
	private String originalName;
	@ParamDesc(path="SYSTEM_NAME",cons=ConsType.CT001,len="255",type="String",desc="附件系统文件名",memo="略")
	private String systemName;
	@ParamDesc(path="ATTACH_TYPE",cons=ConsType.CT001,len="5",type="String",desc="附件类型",memo="略")
	private String attachType;
	@ParamDesc(path="ATTACH_CLASS",cons=ConsType.CT001,len="5",type="String",desc="附件小类",memo="略")
	private String attachClass;
	@ParamDesc(path="ATTACH_PATH",cons=ConsType.CT001,len="200",type="String",desc="附件路径",memo="略")
	private String attachPath;
	@ParamDesc(path="ATTACH_WIDTH",cons=ConsType.QUES,len="10",type="long",desc="附件宽，像素",memo="略")
	private long attachWidth;
	@ParamDesc(path="ATTACH_HEIGHT",cons=ConsType.QUES,len="10",type="long",desc="附件高，像素",memo="略")
	private long attachHeight;
	@ParamDesc(path="FILE_SIZE",cons=ConsType.CT001,len="10",type="long",desc="附件大小,字节",memo="略")
	private long fileSize;
	@ParamDesc(path="ATTACH_NOTE",cons=ConsType.QUES,len="500",type="String",desc="备注",memo="略")
	private String attachNote;
	@ParamDesc(path="STATUS_CODE",cons=ConsType.CT001,len="5",type="String",desc="附件处理状态",memo="略")
	private String statusCode;
	@ParamDesc(path="OPER_NO",cons=ConsType.CT001,len="20",type="String",desc="操作工号",memo="略")
	private String operNo;
	@ParamDesc(path="OPER_NAME",cons=ConsType.CT001,len="64",type="String",desc="操作工号姓名",memo="略")
	private String operName;
	@ParamDesc(path="BUSI_ID",cons=ConsType.CT001,len="18",type="string",desc="业务ID",memo="略")
	private String busiId;
	@ParamDesc(path="BUSI_TYPE",cons=ConsType.CT001,len="5",type="string",desc="业务类型",memo="略")
	private String busiType;
	
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

}
