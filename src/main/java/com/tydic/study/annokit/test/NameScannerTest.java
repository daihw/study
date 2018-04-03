package com.tydic.study.annokit.test;

import com.tydic.study.annokit.annotation.NameScanner;

@NameScanner
public class NameScannerTest {
	@NameScanner
	private String name ;
	@NameScanner
	private int age;
	
	@NameScanner
	public String getName() {
		return name;
	}
	@NameScanner
	public void setName(String name) {
		this.name = name;
	}
	@NameScanner
	public int getAge() {
		return age;
	}
	@NameScanner
	public void setAge(int age) {
		this.age = age;
	}
	
	public static void main(String[] args){
		NameScannerTest nst = new NameScannerTest();
		nst.setName("daihongwei");
		nst.setAge(30);
		System.out.println("--starting--");
        System.out.println(nst.getName());
        System.out.println(nst.getAge());
        System.out.println("--finished--");
		
	}

}
