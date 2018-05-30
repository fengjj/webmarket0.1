package com.sitech.util;

import com.sitech.common.AppErrorConstants;
import com.sitech.jcfx.error.AppError;
/**异常工具类
 * create on 2014-11-05
 * @author sunliang
 */
public class ErrorUtil {
	public static String getErrorCode(String opCode,String seq){
		return AppError.getErrorCode(AppErrorConstants.ChannelType.CRM,
				AppErrorConstants.ErrorType.BUSI_ERROR,
				AppErrorConstants.SystemCode.MARKET,
				opCode,
				seq);
	}

	public static String getErrorCode(String opCode,String seq,String errorType){
		return AppError.getErrorCode(AppErrorConstants.ChannelType.CRM,
				errorType,
				AppErrorConstants.SystemCode.MARKET,
				opCode,
				seq);
	}
}
