package com.tydic.study.rpc.provider;

import com.tydic.study.rpc.service.HelloService;

public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHello(String name) {
		// TODO Auto-generated method stub
		return "Hello "+name;
	}

}
