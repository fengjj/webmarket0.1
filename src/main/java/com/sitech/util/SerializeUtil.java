package com.sitech.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
    /**       
     * Create on 2015年4月3日 
     * @author: 
     * @Title: ClassName
     * @Description：
     * @version 1.0  
     * update_data:     update_author:     update_note:    
     */
    public class SerializeUtil {
        /**
         * 序列化
         * 
         * @param object
         * @return
         */
        public static byte[] serialize(Object object) {
            ObjectOutputStream oos = null;
            ByteArrayOutputStream baos = null;
            try {
                // 序列化
                baos = new ByteArrayOutputStream();
                oos = new ObjectOutputStream(baos);
                oos.writeObject(object);
                byte[] bytes = baos.toByteArray();
                return bytes;
            } catch (Exception e) {

            }
            return null;
        }
        
        /**
         * 反序列化
         * 
         * @param bytes
         * @return
         */
        public static Object unserialize(byte[] bytes) {
            ByteArrayInputStream bais = null;
            try {
                // 反序列化
                bais = new ByteArrayInputStream(bytes);
                ObjectInputStream ois = new ObjectInputStream(bais);
                return ois.readObject();
            } catch (Exception e) {

            }
            return null;
        }
}