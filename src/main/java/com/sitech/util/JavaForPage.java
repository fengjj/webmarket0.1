package com.sitech.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * ClassName: JavaForPage 
 * @Description: 使用java代码生成换页展示功能
 * @author zhaiwt
 * @date Mar 31, 2015
 */
public class JavaForPage {
	
	private static int page = 1; // 当前页
    public static int totalPages = 0; // 总页数
    private static int pageRecorders = 10;// 每页5条数据
    private static int totalRows = 0; // 总数据数
    private static int pageStartRow = 0;// 每页的起始数
    private static int pageEndRow = 0; // 每页显示数据的终止数
    private static boolean hasNextPage = false; // 是否有下一页
    private static boolean hasPreviousPage = false; // 是否有前一页
    
	public int getPage() {
		return page;
	}



	public void setPage(int page) {
		this.page = page;
	}



	public static int getTotalPages() {
		return totalPages;
	}



	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}



	public void setPageRecorders(int pageRecorders) {
		this.pageRecorders = pageRecorders;
	}



	public static int getTotalRows() {
		return totalRows;
	}



	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}



	public int getPageStartRow() {
		return pageStartRow;
	}



	public void setPageStartRow(int pageStartRow) {
		this.pageStartRow = pageStartRow;
	}



	public int getPageEndRow() {
		return pageEndRow;
	}



	public void setPageEndRow(int pageEndRow) {
		this.pageEndRow = pageEndRow;
	}



	public static boolean isHasNextPage() {
		return hasNextPage;
	}



	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}



	public static boolean isHasPreviousPage() {
		return hasPreviousPage;
	}



	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}

   /**
    * 初始化list，并告之该list每页的记录数
    * 
    * @param list
    * @param pageRecorders
    */
   private static void init(List list) {
       totalRows = list.size();
       hasPreviousPage = false;

       if ((totalRows % pageRecorders) == 0) {
           totalPages = totalRows / pageRecorders;
       } else {
           totalPages = totalRows / pageRecorders + 1;
       }

       if (page >= totalPages) {
           hasNextPage = false;
       } else {
           hasNextPage = true;
       }

       if (totalRows < pageRecorders) {
           pageStartRow = 0;
           pageEndRow = totalRows;
       } else {
           pageStartRow = 0;
           pageEndRow = pageRecorders;
       }
   }
   
   /**
    * 获取第几页的内容
    * 
    * @param page
    * @return
    */
   private static List getObjects(int pageInt,List list) {
	   if (pageInt <= 0) {
           page = 1;
       }else if(pageInt > totalPages){
    	   page = totalPages;
       }else{
    	   page = pageInt;
       }
       if ((pageInt - 1) > 0) {
           hasPreviousPage = true;
       } else {
           hasPreviousPage = false;
       }

       if (page >= totalPages) {
           hasNextPage = false;
       } else {
           hasNextPage = true;
       }

       if (page * pageRecorders < totalRows) {// 判断是否为最后一页
           pageEndRow = page * pageRecorders;
           pageStartRow = pageEndRow - pageRecorders;
       } else {
           pageEndRow = totalRows;
           pageStartRow = pageRecorders * (totalPages - 1);
       }
       List objects = null;
       if (!list.isEmpty()) {
           objects = list.subList(pageStartRow, pageEndRow);
       }
       return objects;
   }
   
   /**
	 * 
	 * @Description: 展示对应的页的内容
	 * @param @param list  总的结果集
	 * @param @param page  要展示的页数
	 * @param @param method 点击下一页的方法
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author zhaiwt
	 * @date Mar 31, 2015
	 * @version V1.0
	 * 修改时间    修改人    实现功能
	 */
  public static Map displayForPage(List list,int pageInt,String method){
	   init(list);
	   List retList = getObjects(pageInt,list);
	   StringBuffer sb = new StringBuffer();
      sb.append("<div class=\"next\" style=\"margin:0px\">");
      //判断是否有上一页
      if (isHasPreviousPage()) {
          sb.append("<div class=\"first\"><a href=\"#this\" onclick=\""+method+"('1')\"></a></div>");
          sb.append("<div class=\"previous\"><a href=\"#this\" onclick=\""+method+"('"+String.valueOf(page - 1)+"')\"></a></div>");
      } else {
   	   sb.append("<div class=\"first_no\"><a href=\"#this\"></a></div>");
   	   sb.append("<div class=\"previous_no\"><a href=\"#this\"></a></div>");
      }
      //当前页
      if(getTotalRows() == 0){
    	 sb.append("<span class=\"current\"><input type=\"text\" size=\"3\" value=\"0\" id=\"currentPage\">");
      }else{
         sb.append("<span class=\"current\"><input type=\"text\" size=\"3\" value=\""+page+"\" id=\"currentPage\">");
      }
      sb.append("<input type=\"button\" class=\"b_foot\" value=\"确定\" onclick=\""+method+"(this.parentNode.childNodes[0].value)\"></span>");
      sb.append("<span class=\"pages\" style=\"float:left;\">共<label style=\"padding:0 5px\" id=\"totalPage\">"+getTotalPages()+"</label>页</span>");
      //判断是否有下一页
      if (isHasNextPage()) {
          sb.append("<div class=\"forward\"><a href=\"#this\" onclick=\""+method+"('"+(1+page)+"')\"></a></div>");
          sb.append("<div class=\"last\"><a href=\"#this\" onclick=\""+method+"('"+getTotalPages()+"')\"></a></div>");
      } else {
          sb.append("<div class=\"forward_no\"><a href=\"#this\"></a></div>");
          sb.append("<div class=\"last_no\"><a href=\"#this\"></a></div>");
      }
      //展示的行数和总共的条数
      sb.append("<span class=\"pages\"><label style=\"padding:0 5px\">共 "+getTotalRows()+" 条</label></span>");
      if(isHasNextPage()){
         sb.append("<span class=\"pages\"><label style=\"padding:0 5px\">"+(pageStartRow+1)+" - "+pageEndRow+"</label></span>");
      }else{
    	  if(getTotalRows() == 0){
    		  sb.append("<span class=\"pages\"><label style=\"padding:0 5px\">"+getTotalRows()+" - "+getTotalRows()+"</label></span>"); 
    	  }else{
    	      sb.append("<span class=\"pages\"><label style=\"padding:0 5px\">"+((page-1)*pageRecorders+1)+" - "+getTotalRows()+"</label></span>"); 
    	  }
      }
      sb.append("</div>");
      System.out.println("sb==============:"+sb.toString());
      String retStr = sb.toString();
      Map retMap = new HashMap();
      retMap.put("html", retStr);
      retMap.put("subList",retList);
      return retMap;
  }
  public static void main(String[] args) {
	List<String> list = new ArrayList<String>();
//    list.add("1");
//    list.add("2");
//    list.add("3");
//    list.add("4");
//    list.add("5");
//    list.add("6");
//    list.add("7");
//    list.add("8");
//    list.add("9");
//    list.add("10");
//    list.add("11");
//    list.add("12");
//    list.add("13");
//    list.add("14");
//    list.add("15");
//    list.add("16");
//    list.add("17");
//    list.add("18");
//    list.add("19");
//    list.add("20");
//    list.add("21");
//    list.add("22");
//    list.add("23");
//    list.add("24");
//    list.add("25");
//    list.add("26");
//    list.add("27");
//    list.add("28");
//    list.add("29");
//    list.add("30");
//    list.add("31");
    Map retMap = displayForPage(list, 2, "find");
    String html = (String)retMap.get("html");
    List retList = (List)retMap.get("subList");
    System.out.println("retList===========:"+retList.size());
  }
}