package com.sitech.util;

import java.text.DateFormat;
import java.text.ParseException;  
import java.text.SimpleDateFormat;  
import java.util.Calendar;  
import java.util.Date; 

/**       
 * Create on 2015年3月25日
 * @author: fengjj
 * @Title: SitechDateUtil
 * @Description：
 * @version 1.0  
 * update_data:     update_author:     update_note:    
 */
public class SitechDateUtil {

    public static SimpleDateFormat sdtff=new SimpleDateFormat("yyyyMMdd HH:mm:ss");  
    public static SimpleDateFormat sdtf_f=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
    public static SimpleDateFormat sdtf=new SimpleDateFormat("yyyyMMddHHmmss");  
    public static SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");  
    public static SimpleDateFormat stf=new SimpleDateFormat("HHmmss");  
    public static SimpleDateFormat stfM=new SimpleDateFormat("yyyyMM");  
    public static String yMd6 = new String("yyyyMMdd060000");//6点赠费
    public static String yMd18 = new String("yyyyMMdd180000");//18点赠费

    /**
     * 计算两个日期之间相差的天数  
     *  Create on 2015年3月25日
     * @author fengjj
     * @version 1.0
     * @Title: daysBetween 
     * @Description: 
     * @param @param smdate
     * @param @param bdate
     * @param @return
     * @param @throws ParseException
     * @return int
     * @throws
     * 修改日期:     修改人:     修改目的:
     */
  public static int daysBetween(Date smdate,Date bdate) throws ParseException    
  {    
      smdate=sdf.parse(sdf.format(smdate));  
      bdate=sdf.parse(sdf.format(bdate));  
      Calendar cal = Calendar.getInstance();    
      cal.setTime(smdate);    
      long time1 = cal.getTimeInMillis();                 
      cal.setTime(bdate);    
      long time2 = cal.getTimeInMillis();         
      long between_days=(time2-time1)/(1000*3600*24);  
          
     return Integer.parseInt(String.valueOf(between_days));           
  }    
  /**
   * 根据给定的字符串格式，返回格式化时间字符串
   *  Create on 2015年3月25日
   * @author fengjj
   * @version 1.0
   * @Title: getFormatDateString 
   * @Description: 
   * @param @param date
   * @param @param format
   * @param @return
   * @return String
   * @throws
   * 修改日期:     修改人:     修改目的:
   */
  public static String getFormatDateString(Date date,String format){
      SimpleDateFormat sd = new SimpleDateFormat(format);
      return sd.format(date);
  }
  /**
   * 返回日期字符串
   *  Create on 2015年3月25日
   * @author fengjj
   * @version 1.0
   * @Title: getFormatDateString 
   * @Description: 
   * @param @param date
   * @param @return
   * @return String
   * @throws
   * 修改日期:     修改人:     修改目的:
   */
  public static String getFormatDateString(Date date){
      return sdf.format(date);
  }
  /**
   * 返回日期时间字符串
   *  Create on 2015年3月25日
   * @author fengjj
   * @version 1.0
   * @Title: getFormatDateString 
   * @Description: 
   * @param @param date
   * @param @return
   * @return String
   * @throws
   * 修改日期:     修改人:     修改目的:
   */
  public static String getFormatDateTimeString(Date date){
      return sdtf.format(date);
  }
  /**
   * 根据字符串，格式化成日期（yyyymmddHHmiss）
   * @Create on 2015-9-4 
   * @author: wangdw
   * @Title: getFormatDateTimeDate 
   * @Description: 
   * @param dateStr
   * @return 
   * @version 1.0 
   * update_date: update_author: update_note:
   */
  public static Date getFormatDateTimeDate(String dateStr){
	  try {
		  return sdtf.parse(dateStr);
	  } catch (ParseException e) {
		  e.printStackTrace();
	  }
	  return null;
  }
  /**
   * 返回时间字符串
   *  Create on 2015年3月25日
   * @author fengjj
   * @version 1.0
   * @Title: getFormatDateString 
   * @Description: 
   * @param @param date
   * @param @return
   * @return String
   * @throws
   * 修改日期:     修改人:     修改目的:
   */
  public static String getFormatTimeString(Date date){
      return stf.format(date);
  }
  
  /**
   * 返回日期
   *  Create on 2015年3月25日
   * @author fengjj
   * @version 1.0
   * @Title: getFormatDate 
   * @Description: 
   * @param @param dateStr
   * @param @param format
   * @param @return
   * @return Date
   * @throws
   * 修改日期:     修改人:     修改目的:
   */
  public static Date getFormatDate(String dateStr,String format){
      SimpleDateFormat sdf=new SimpleDateFormat(format);  
      try {
        return sdf.parse(dateStr);
    } catch (ParseException e) {
        e.printStackTrace();
    }
      return null;
  }

  /**
   * 返回值类型：Date
   *  Create on 2015年3月25日
   * @author fengjj
   * @version 1.0
   * @Title: getFormatDate 
   * @Description:
   * @param @param dateStr
   * @param @return
   * @return Date
   * @throws
   * 修改日期:     修改人:     修改目的:
   */
public static Date getFormatDate(String dateStr){
      try {
        return sdf.parse(dateStr);
    } catch (ParseException e) {
        e.printStackTrace();
    }
      return null;
  }

	/**
	 * 把源格式的字符串日期，转为为目标格式的字符串日期
	 * @param s 字符串型日期
	 * @param sourceStyle 源日期格式
	 * @param targetStyle 目标日期格式
	 * @return String 
	 * yugl
	 * 2015年1月27日
	 * 例如：2015-01-27 --》20150127
	 */
	public static String strToStr(String s,String sourceStyle,String targetStyle){
		Date date = getFormatDate(s,sourceStyle);
		String str = getFormatDateString(date,targetStyle);
		return str;
	}


    /**
     * 格式化时间
    	* 
    	*  Create on 2014-12-16 下午7:39:40
    	* @author tianyy_bj
    	* @version 1.0
    	* Copyright(c) 北京思特奇信息技术股份有限公司
    	* 功能描述：
    	* 修改日期:     修改人:     修改目的:
     */
    public static String formatTime(Date date){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(date);
    }
    
    
	/**
	 * 格式化时间
		* 
		*  Create on 2014-12-16 下午7:39:40
		* @author quyl
		* @version 1.0
		* Copyright(c) 北京思特奇信息技术股份有限公司
		* 功能描述：
		* 修改日期:     修改人:     修改目的:
	 */
	public static boolean formatCompareTime(String endDate,String format){
		
		try {
			SimpleDateFormat sdtf=new SimpleDateFormat(format);  
			Date sdate= getFormatDate(endDate,format);
			Date bdate=(Date) sdtf.parse(sdtf.format(new Date()));
			System.out.println("----------------sdate:"+sdate+"-------------------------");
			System.out.println("----------------bdate:"+bdate+"-------------------------");
			if (bdate.before(sdate)) {// 若当前时间小，则返回true
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;  
	}
  
  /**
   * Create on 2015-4-25 
   * @author: hanzh_bj
   * @Title: getNextMonthFirstDate 
   * @Description: 获取下月一号
   * @return 
   * @version 1.0 
   * update_data:       update_author:       update_note:
   */
  public static String getNextMonthFirstDate(){
	  SimpleDateFormat sdf=new SimpleDateFormat(yMd6);  //24进制
	  Calendar c = Calendar.getInstance();
	  Date d = new Date();  
	  int year  = c.get(Calendar.YEAR);  
	  int month = c.get(Calendar.MONTH);  
	  if(month==11){
		  month = 0;
		  year = year +1;
	  }else{
		  month = month+1;
	  }
	  c.set(Calendar.YEAR, year);
	  c.set(Calendar.MONTH, month);
	  c.set(Calendar.DAY_OF_MONTH, 1);
	  d = c.getTime();
	  return sdf.format(d);
  }
  /**
	 * 获得下几个月几号
	 * @Create on 2015-7-23 
	 * @author: wangdw
	 * @Title: getNextMonthDay
	 * @Description: 
	 * @param m 下几个月
	 * @param d 下几个月的几号
	 * @return 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
  	public static Date getNextDayOfMonth(int nextMonth, int nextDay) {
  		Calendar c = Calendar.getInstance();
  		Date d = new Date();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int n = (nextMonth + month) / 12;
		int m = (nextMonth + month) % 12;
		year += n;
		month = m;
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month);
		c.set(Calendar.DAY_OF_MONTH, nextDay);
		d = c.getTime();
		return d;
  	}
  	/**
  	 * 获得下几月几号6点（yyyyMMdd060000）
  	 * @Create on 2015-7-23 
  	 * @author: wangdw
  	 * @Title: getNextMonthDay6String 
  	 * @Description: 
  	 * @param day 下几个月
  	 * @param day 下几个月的几号
  	 * @return 
  	 * @version 1.0 
  	 * update_date:       update_author:       update_note:
  	 */
	 public static String getNextMonthDay6String(int month, int day) {
		 SimpleDateFormat sdf=new SimpleDateFormat(yMd6);  //24进制
		 Date d = getNextDayOfMonth(month, day);
		 return sdf.format(d);
	 }
	 /**
	  * 获得下月的 今天（yyyyMMddHHmmss）
	  * @Create on 2015-7-23 
	  * @author: jiaxla
	  * @Title:  
	  * @Description: 
	  * @param day 下几个月
	  * @param now 下几个月的几号
	  * @return 
	  * @version 1.0 
	  * update_date:       update_author:       update_note:
	  */
	 public static String getNextMonthNow(int month,String now) {
		 Calendar c = Calendar.getInstance();
		 try {
			Date nowDate = sdtf.parse(now);
			c.setTime(nowDate);
			c.add(Calendar.MONTH, month);
		 } catch (ParseException e) {
			 e.printStackTrace();
		 }
		 return sdtf.format(c.getTime());
	 }
  
  /**
	 * 获取后几天的日期（yyyyMMdd000000）
	 * @Create on 2015-7-23 
	 * @author: wangdw
	 * @Title: getNextCountDay 
	 * @Description: 
	 * @param n 后几天，n就填几
	 * @return 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	public static String getNextCountDay(int n) {
		Date date = new Date();
		long nTime = date.getTime() + n * (24 * 60 * 60 * 1000);
		return getFormatDateString(new Date(nTime), yMd6);
	}
	
	/**
	 * 获得今天是几号
	 * @Create on 2015-7-23 
	 * @author: wangdw
	 * @Title: getDayOfMonth 
	 * @Description: 
	 * @return 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	public static int getDayOfMonth() {
		Calendar c = Calendar.getInstance();
		return c.get(Calendar.DAY_OF_MONTH);
	}
	 /**
	   * Create on 2015-4-25 
	   * @author: jiaxla
	   * @Title: getNowDayDate 
	   * @Description: 获取当前时间
	   * @return 
	   * @version 1.0 
	   * update_data:       update_author:       update_note:
	   */
	  public static String getNowDayDate(){
		  SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");  //24禁止
		  Date d = new Date();  
		  return sdf.format(d);
	  }
	  /**
	   * Create on 2015-4-25 
	   * @author: jiaxla
	   * @Title: getNextDayDate 
	   * @Description: 获取明天
	   * @return 
	   * @version 1.0 
	   * update_data:       update_author:       update_note:
	   */
	  public static String getNextDayDate(){
		  SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd060000");  //24禁止
		  Calendar c = Calendar.getInstance();
		  Date d = new Date();  
		  c.add(Calendar.DAY_OF_MONTH, 1);
		  d = c.getTime();
		  return sdf.format(d);
	  }
	  
	  /**
		  * 下几个月最后一天的18点（字符串）
		  * @Create on 2015-9-8 
		  * @author: wangdw
		  * @Title: getLashDayOfMonth18String 
		  * @Description: 
		  * @param nextMonth
		  * @return 
		  * @version 1.0 
		  * update_date: update_author: update_note:
		  */
		 public static String getLashDayOfMonth18String(int nextMonth) {
			 SimpleDateFormat sdf=new SimpleDateFormat(yMd18);  //24进制
			 Date d = getLastDayOfMonth(nextMonth);
			 return sdf.format(d);
		 }
		 /**
		  * 获得下几个月的最后一天18点（日期）
		  * @Create on 2015-9-8 
		  * @author: wangdw
		  * @Title: getLastDayOfMonth 
		  * @Description: 
		  * @param nextMonth
		  * @return 
		  * @version 1.0 
		  * update_date: update_author: update_note:
		  */
		 public static Date getLastDayOfMonth(int nextMonth) {
			 Calendar c = Calendar.getInstance();
	  		 Date d = new Date();
			 int year = c.get(Calendar.YEAR);
			 int month = c.get(Calendar.MONTH);
			 int n = (nextMonth + month) / 12;
			 int m = (nextMonth + month) % 12;
			 year += n;
			 month = m;
			 c.set(Calendar.YEAR, year);
			 c.set(Calendar.MONTH, month);
			 int lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
			 c.set(Calendar.DAY_OF_MONTH, lastDay);
			 d = c.getTime();
			 return d;
		 }
	  
	  public static void main(String[] a){
		  System.out.println(getNextMonthDay6String(2, 6));
		  System.out.println(getLashDayOfMonth18String(0));
	//      System.out.println(new Date());
	//		System.out.println(getFormatDateTimeString(new Date()));
	//	  
	      /*try {
	        int s = SitechDateUtil.daysBetween(new Date(), sdf.parse("2014-10-11"));
	        System.out.println(s);
	    } catch (ParseException e) {
	        // 
	        e.printStackTrace();
	    }*/
		  //System.out.println(getNextCountDay(2));
////		  System.out.println(getNextMonthDayString(0,1));
//		  String ss1 = "2015-08-06";
////		  System.out.println(getDayOfMonth());
//		  System.out.println(formatCompareTime(ss1,"yyyyMMdd"));
////		  System.out.println( getNextDayDate());
//		 String ds =  getNextMonthNow(1, "20150404162510");
//		  System.out.println("ds:"+ds);
	  }
}
