package com.tydic.study.agent;

import java.lang.instrument.Instrumentation;

public class MyAgent {

	public static void premain(String agentOps,Instrumentation inst){
		System.out.println("====premain����ִ��");
		System.out.println(agentOps);
		inst.addTransformer(new Transformer());
	}
}
