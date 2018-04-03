package com.tydic.study.rpc.test;

public class HelloServiceImpl implements HelloService {

	@Override
	public String sayhello(String name) {
		// TODO Auto-generated method stub
	        return "Hello " + name;  	  
	}

}
