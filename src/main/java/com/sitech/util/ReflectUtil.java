package com.sitech.util;
/**
 * 反射工具类
 * @Author:yueyue
 */

import java.lang.reflect.Method;  
  

public class ReflectUtil {  
	/**
	 * 功能：得到父类方法
	 * @param clazz
	 * @param methodName
	 * @param classes
	 * @return
	 * @throws Exception
	 */
    @SuppressWarnings("unchecked")
	public static Method getMethod(Class clazz, String methodName,  
            final Class[] classes) throws Exception {  
        Method method = null;  
        try {  
            method = clazz.getDeclaredMethod(methodName, classes);  
        } catch (NoSuchMethodException e) {  
            try {  
                method = clazz.getMethod(methodName, classes);  
            } catch (NoSuchMethodException ex) {  
                if (clazz.getSuperclass() == null) {  
                    return method;  
                } else {  
                    method = getMethod(clazz.getSuperclass(), methodName,  
                            classes);  
                }  
            }  
        }  
        return method;  
    }  
  
    /**
     * 功能：调用父类方法
     * @param obj
     * @param methodName
     * @param classes
     * @param objects
     * @return
     */

    @SuppressWarnings("unchecked")
	public static Object invoke(final Object obj, final String methodName,  
            final Class[] classes, final Object[] objects) {  
        try {  
            Method method = getMethod(obj.getClass(), methodName, classes);  
            method.setAccessible(true);// 调用private方法的关键一句话  
            return method.invoke(obj, objects);  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
    }  
  
    /**
     * 功能：调用父类方法
     * @param obj
     * @param methodName
     * @param classes
     * @return
     */
    public static Object invoke(final Object obj, final String methodName, final Class[] classes)
    {  
        return invoke(obj, methodName, classes, new Object[] {});  
    }  
  
    /**
     * 功能：调用父类方法（参数为空）
     * @param obj
     * @param methodName
     * @return
     */
    public static Object invoke(final Object obj, final String methodName) {  
        return invoke(obj, methodName, new Class[] {}, new Object[] {});  
    }  
  

    /**
     * 测试
     * @param args
     */
   public static void main(String[] args) {  
        ReflectUtil.invoke(new B(), "printlnA", new Class[] { String.class },  
                new Object[] { "test" });  
        ReflectUtil.invoke(new B(), "printlnB");  
    }  
}  
  
class A {  
    private void printlnA(String s) {  
        System.out.println(s);  
    }  
}  

class B extends A {  
    private void printlnB() {  
        System.out.println("b");  
    }  
}  

