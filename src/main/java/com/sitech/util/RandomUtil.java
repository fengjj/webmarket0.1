package com.sitech.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import com.sitech.util.RandomUtil;
public class RandomUtil {
        
    /**
     * 产生随机数
     * 
     *  Create on 2014-06-28
     * 
     * @author chenfh
     * 
     * @version 1.0
     * 
     * Copyright(c) 北京思特奇信息技术股份有限公司
     * 
     * 功能描述：产生随机数，系统生成带日期的ns级别的数字串+Random 产生6位随机数字
     *
     * 修改日期:     修改人:     修改目的:
     */
    
    /**
     * 产生随机数
     * 
     *  Create on 2014-06-28
     * 
     * @author chenfh
     * 
     * @version 1.0
     * 
     * Copyright(c) 北京思特奇信息技术股份有限公司
     * 
     * 功能描述： Random 产生7位随机数字
     *
     * 修改日期:     修改人:     修改目的:
     */
    public static int  RandomSeven() {
        Random random = new Random();//指定种子数字- 默认时间
        int size = random.nextInt(899999)+100000;//7位数字随机数
        return size;
    }
    /**
     * 产生随机数
     * 
     *  Create on 2014-06-28
     * 
     * @author chenfh
     * 
     * @version 1.0
     * 
     * Copyright(c) 北京思特奇信息技术股份有限公司
     * 
     * 功能描述：产生随机数，系统生成带日期 +Random 产生7位随机数字
     *
     * 修改日期:     修改人:     修改目的:
     */
    public static String  SysDateRandom() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyMMddHHmmss");//15位系统时间
        return formatter.format(new Date());
    }
    
    
    
    public static void main(String args[]) {
            //SimpleDateFormat formatter = new SimpleDateFormat("yyMMddHHmmssSSS");
            //int size = 0;
            String act_id =  RandomUtil.SysDateRandom()+RandomUtil.RandomSeven();//随机数生成主键 ：日期+随机数
            
            //System.out.println(random.nextInt(999999)+1);
            System.out.println("===========act_id============"+act_id);
            /*long time1 = System.nanoTime();
            System.out.println("====time1======"+time1);
            System.out.println("====currentTimeMillis======"+System.currentTimeMillis());
            long time2 = System.nanoTime();
            System.out.println("========time2==========="+time2);
            long time3 = time2 - time1;
            System.out.println("====time3===time2-time1="+time3);
            
            for (int i = 0; i < 100000; i++) {
                Random random = new Random();//指定种子数字 
                size = random.nextInt(8999999)+1000000;
                System.out.println("==========Date================="+size);
            } 
            
            //System.out.println("==========Date============="+formatter.format(new Date())+size);
            long times[] = new long[100000];
            for (int i = 0; i < 100000; i++) {
                //times[i] = System.currentTimeMillis();
                times[i] = System.nanoTime();
                System.out.println("=====times======="+times[i]);
            } 
            long time = times[0];
            long previousTime = times[0];
            long count = 0;
            HashSet<Long> deltas = new HashSet<Long>();        
            long delta = 0;
            long minDelta = Long.MAX_VALUE;
            long maxDelta = Long.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                if (times[i] > time) {
                    delta = time - previousTime;
                    deltas.add(delta);
                    if (delta > 0 && delta < minDelta) {
                        minDelta = delta;
                    } else if (delta > maxDelta) {
                        maxDelta = delta;
                    }
                    System.out.print("raw=");
                    System.out.print(time);
                    System.out.print(" | formatted=");
                    System.out.print(formatter.format(new Date(time)));
                    System.out.print(" | frequency=");
                    System.out.print(count);
                    System.out.print(" | delta=");
                    System.out.print(delta);
                    System.out.println("ms");

                    previousTime = time;
                    time = times[i];
                    count = 0;
                } else {
                    count++;
                }
            }

            System.out.println("");
            System.out.println("Minimum delta : " + minDelta + "ms");
            System.out.println("Maximum delta : " + maxDelta + "ms");
        }*/
    } 
}
