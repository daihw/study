package com.tydic.study.rpc.test;

import com.tydic.study.rpc.framework.RpcFramework;

public class RpcConsumer {
	public static void main(String[] args) throws Exception{
		HelloService service = RpcFramework.refer(HelloService.class, "127.0.0.1", 1024);
		for(int i=0;i<Integer.MAX_VALUE;i++){
			String hello = service.sayhello("World"+i);
			System.out.println(hello);
			Thread.sleep(1000);
		}
	}

}
