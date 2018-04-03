package com.tydic.study.aop;

public class DogImp implements AnimalInterface {
	@Seven(value = "Lumia")
	private String name = "小黑";

	public DogImp() {
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void say() {
		System.out.println("小狗:汪汪汪汪.....");
	}

	@Override
	public void getProperty() {
		System.out.println("小狗是陆地动物,但是会游泳哦");
	}
}
