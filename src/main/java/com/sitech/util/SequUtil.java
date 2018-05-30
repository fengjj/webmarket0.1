package com.sitech.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import edu.emory.mathcs.backport.java.util.LinkedList;

public class SequUtil {
    //配置文件名称
    private static final String fileName = "sequence.properties";
	//默认队列长度
	private static final long m = Long.parseLong( PropertiesUtil.getProperty(fileName, "length").trim());
	//private static final int m = 200000;
	//初始值序列
	//private static final long init = 100000000;
	private static final long init = Long.parseLong( PropertiesUtil.getProperty(fileName, "init").trim());
	//ip地址，机器标识
	private static final String cip =PropertiesUtil.getProperty(fileName, "server_id");
	//当前序列最大值
	private static long curMax = Long.parseLong( PropertiesUtil.getProperty(fileName, "cur_max").trim());
	//当前序列最大值
	private static SimpleDateFormat matter=new SimpleDateFormat("yyMMdd"); ;
	
	
	@SuppressWarnings("unchecked")
	private static List<String> list = Collections.synchronizedList(new LinkedList());
	//private static List<String> list = new LinkedList();
	static{
		System.out.println("启动了");
		//curMax = init;
		addSize();
	}
	/**
	 * 
	 *  Create on 2015年3月25日
	 * @author fengjj
	 * @version 1.0
	 * @Title: getSequ 
	 * @Description: 取序列号
	 * @param @return
	 * @return String
	 * @throws
	 * 修改日期:     修改人:     修改目的:
	 */
	public synchronized static String getSequ(){
		if(list.size()<1){
			addSize();
		}
		Date d = new Date();
		String seq = matter.format(d)+list.remove(0);
		d = null;
		return  seq;
	}
	/**
	 * 
	 *  Create on 2015年3月25日
	 * @author fengjj
	 * @version 1.0
	 * @Title: getSequ 
	 * @Description: 取序列号
	 * @param @return
	 * @return String
	 * @throws
	 * 修改日期:     修改人:     修改目的:
	 */
	public synchronized static String getSequ(int num){
		if(list.size()<1){
			addSize();
		}
		String seq = list.remove(0).substring(num);
		return  seq;
	}
	/**
	 * 步进
	 *  Create on 2015年3月25日
	 * @author fengjj
	 * @version 1.0
	 * @Title: addSize 
	 * @Description: 
	 * @param 
	 * @return void
	 * @throws
	 * 修改日期:     修改人:     修改目的:
	 */
	private static void addSize(){
		for(int i = 0;i<m;i++){
		    long l = curMax+i;
		    if(l>999999999){
		        curMax=init;
		        l=init;
		    }
			list.add(cip+""+l);
		}
		curMax = curMax+m;
		//System.out.println("curMax:"+curMax);
		setFileSequ(curMax+"");
	}
	/**
	 * 
	 *  Create on 2015年3月25日
	 * @author fengjj
	 * @version 1.0
	 * @Title: setFileSequ 
	 * @Description: 
	 * @param @param value
	 * @return void
	 * @throws
	 * 修改日期:     修改人:     修改目的:
	 */
private static void setFileSequ(String value){
    Properties prop = new Properties();
    InputStream in = PropertiesUtil.class.getResourceAsStream("/" + fileName);
    FileOutputStream fos = null;
    try {
        prop.load(in);
        prop.setProperty("cur_max", value);
      //文件输出流 
        fos = new FileOutputStream(SequUtil.class.getResource("/" + fileName).getPath()); 
        //将Properties集合保存到流中 
        prop.store(fos, "最后更新最大序列"); 
        fos.flush();
    } catch (IOException e) {
        e.printStackTrace();
    }finally{
        try {
            if(in!=null)
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if(fos!=null)
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 }
	public static void main(String[] arg){
		System.out.println(getSequ(3));
		System.out.println(getSequ(3));
		System.out.println(getSequ(3));
	}
}
