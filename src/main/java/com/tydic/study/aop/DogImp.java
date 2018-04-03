package com.tydic.study.aop;

public class DogImp implements AnimalInterface {
	@Seven(value = "Lumia")
	private String name = "С��";

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
		System.out.println("С��:��������.....");
	}

	@Override
	public void getProperty() {
		System.out.println("С����½�ض���,���ǻ���ӾŶ");
	}
}
