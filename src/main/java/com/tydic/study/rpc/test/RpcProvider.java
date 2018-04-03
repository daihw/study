package com.tydic.study.rpc.test;

import com.tydic.study.rpc.framework.RpcFramework;

public class RpcProvider {
	
	public static void main(String[] args) throws Exception{
		HelloService helloService = new HelloServiceImpl();
		RpcFramework.export(helloService, 1024);
	}

}
