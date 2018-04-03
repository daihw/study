package com.tydic.study.rpc.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class ExcuteShell {
	
	public static void main(String[] args) throws Exception{
		
		Map<String, String> ipMap = new HashMap<String,String>();
		ipMap.put("192.168.129.133", "20888");
		ipMap.put("192.168.129.134", "20888");
		for(Map.Entry<String, String> entry : ipMap.entrySet()){
			//����shell�ű�·��
			String commandStr = "sh /home/work/daihw/dubbo.sh "+entry.getKey()+" "+entry.getValue();
			Thread.sleep(3000);
			Process process = Runtime.getRuntime().exec(commandStr);
			parseResultFile(entry.getKey(),entry.getValue());
		}
		
		//String result = null;
		// ��ȡshell������  
        //BufferedInputStream in = new BufferedInputStream(process.getInputStream());  
        // �ַ���ת���ֽ���  
        //BufferedReader br = new BufferedReader(new InputStreamReader(in));  
        // ����Ҳ��������ı���־  
  
        //String lineStr;  
        //while ((lineStr = br.readLine()) != null) {  
            //result = lineStr;  
        //}  
        // �ر�������  
        //br.close();  
        //in.close();  
        
	}
	
	public static void parseResultFile(String key,String value){
		String max =null,core=null,largest=null,active = null;
        //String[] arguments = 
        File resultFile = new File("/home/work/daihw/a.out."+key+"."+value);
        BufferedReader reader = null;
        try {
            System.out.println("����Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���У�");
            reader = new BufferedReader(new FileReader(resultFile));
            String tempString = null;
            int line = 1;
            // һ�ζ���һ�У�ֱ������nullΪ�ļ�����
            while ((tempString = reader.readLine()) != null) {
                // ��ʾ�к�
            	if(tempString.contains("max:")){
            		String[] arguments = tempString.split(",");
            		for(int i=0;i<arguments.length;i++){
            			if(arguments[i].contains("max:")){
            				max = arguments[i].substring(arguments[i].indexOf(":"),arguments[i].length());
            				
            			}
            			if(arguments[i].contains("core:")){
            				core = arguments[i].substring(arguments[i].indexOf(":"),arguments[i].length());
            				
            			}
            			if(arguments[i].contains("largest:")){
            				largest = arguments[i].substring(arguments[i].indexOf(":"),arguments[i].length());
            				
            			}
            			if(arguments[i].contains("active:")){
            				active = arguments[i].substring(arguments[i].indexOf(":"),arguments[i].length());
            				
            			}
            		}
            		break;
            	}                
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
  
        System.out.println("=============================="+"max:"+max);
        System.out.println("=============================="+"core:"+core);
        System.out.println("=============================="+"largest:"+largest);
        System.out.println("=============================="+"active:"+active);
	}

}
