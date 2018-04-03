package com.tydic.study.rpc.test;

import javax.jws.WebParam;  
import javax.jws.WebService;  
import javax.xml.ws.Endpoint;

import org.dom4j.Document; 
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

  
@WebService  
public class JdkWebService {  
  
    public String doSomething(@WebParam(name="systemCode", targetNamespace = "http://test.rpc.study.tydic.com/", mode = WebParam.Mode.IN)String systemCode,@WebParam(name="systemPasswd", targetNamespace = "http://test.rpc.study.tydic.com/", mode = WebParam.Mode.IN)String systemPasswd,@WebParam(name="serviceCode", targetNamespace = "http://test.rpc.study.tydic.com/", mode = WebParam.Mode.IN)String serviceCode,@WebParam(name="requestData", targetNamespace = "http://test.rpc.study.tydic.com/", mode = WebParam.Mode.IN)String requestData) {  
    	System.out.println(systemCode);
    	System.out.println(systemPasswd);
    	System.out.println(serviceCode);
    	System.out.println(requestData);
    	Document document = DocumentHelper.createDocument();
    	Element root = document.addElement("return");
    	String returnStr = "[{\"ACCS_NBR\":\"14912014302\",\"BILLING_DUR\":\"60\",\"CALLED_BILLING_DUR\":\"60\",\"CALLED_CNT\":\"1\",\"CALLED_DUR\":\"26\",\"CALLING_BILLING_DUR\":\"0\",\"CALLING_CNT\":\"0\",\"CALLING_DUR\":\"0\",\"CALL_INT_DUR\":\"0\",\"CNT\":\"1\",\"DUR\":\"26\"}]";
    	root.setText(returnStr);
    	return returnStr;  
    }  
      
    public static void main(String[] args) {  
        Endpoint.publish("http://192.1.16.14:8090/jdkwsdemo/demo.JdkWebService", new JdkWebService());  
    }  
}  