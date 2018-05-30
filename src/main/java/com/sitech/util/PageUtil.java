package com.sitech.util;

public class PageUtil {
    /**
     * key分隔符
     */
    public static final String split = ":";
    /**
     * key 内部分隔符
     */
    public static final String splitIn = "_";
   /**
    * 拼缓存key值
    * 返回值类型：String
    * 作者： fengjj
    * 日期： 2015年3月19日
    */
    public static String getKey(String tableName,String[] orderCol,String[] cond){
        StringBuilder key = new StringBuilder();//拼key
        key.append(tableName);
        key.append(split);
        if(orderCol!=null){
            for(String str:orderCol){
                key.append(str).append(splitIn);
            }
            key.deleteCharAt(key.length()-1);
        }
        key.append(split);
        if(cond!=null){
            for(String str:cond){
                key.append(str).append(splitIn);
            }
            key.deleteCharAt(key.length()-1);
        }
        return key.toString();
    }
}
