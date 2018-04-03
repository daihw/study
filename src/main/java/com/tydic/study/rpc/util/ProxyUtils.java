package com.tydic.study.rpc.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;  
import sun.misc.ProxyGenerator;  

public class ProxyUtils {  
	  
    /* 
     * ����������Ϣ ��̬���ɵĶ������ֽ��뱣�浽Ӳ���У� 
     * Ĭ�ϵ���clazzĿ¼�� 
         * params :clazz ��Ҫ���ɶ�̬��������� 
         * proxyName : Ϊ��̬���ɵĴ���������� 
         */  
    public static void generateClassFile(Class clazz,String proxyName)  
    {  
        //��������Ϣ���ṩ�Ĵ��������ƣ������ֽ���  
        byte[] classFile = ProxyGenerator.generateProxyClass(proxyName, clazz.getInterfaces());   
        String paths = clazz.getResource(".").getPath();  
        System.out.println(paths);  
        FileOutputStream out = null;    
          
        try {  
            //������Ӳ����  
            out = new FileOutputStream(paths+proxyName+".class");    
            out.write(classFile);    
            out.flush();    
        } catch (Exception e) {    
            e.printStackTrace();    
        } finally {    
            try {    
                out.close();    
            } catch (IOException e) {    
                e.printStackTrace();    
            }    
        }    
    }  
      
}  