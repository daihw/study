package com.tydic.study.agent;

import java.lang.instrument.Instrumentation;

public class MyAgent {

	public static void premain(String agentOps,Instrumentation inst){
		System.out.println("====premain·½·¨Ö´ÐÐ");
		System.out.println(agentOps);
		inst.addTransformer(new Transformer());
	}
}
