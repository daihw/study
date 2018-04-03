package com.tydic.study.rxjava;

import org.apache.log4j.Logger;

import com.tydic.study.spring.bean.People;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class RxJavaMain {
	private static Logger logger = Logger.getLogger(RxJavaMain.class);
	
	public static void main(String[] args){
		/*
		String[] names = new String[]{"s","t","r","i","n","g"};
		Observable.from(names)
		.subscribe(new Action1<String>(){
			
			public void call(String name){
				logger.info("name:"+name);
			}
			
		});
		Observable.just(1,2,3,4)
		.subscribeOn(Schedulers.io())
		.observeOn(Schedulers.immediate())
		.subscribe(new Action1<Integer>(){

			@Override
			public void call(Integer number) {
				// TODO Auto-generated method stub
				logger.info("number:"+number);
			}
			
		});*/
		
		Observable.just("images/logo.png")
		.map(new Func1<String,String>(){

			@Override
			public String call(String input) {
				// TODO Auto-generated method stub
				return input.substring(input.indexOf("/"));
			}
			
		}).subscribe(new Action1<String>(){

			@Override
			public void call(String input) {
				// TODO Auto-generated method stub
				logger.info("substr:"+input);
			}
			
		});
		People people = new People();
		people.setId("212312199201241077");
		people.setAge(28);
		people.setName("leo");
		
		People people1 = new People();
		people1.setId("110101199010245247");
		people1.setAge(28);
		people1.setName("leo");
		
		People people2 = new People();
		people2.setId("212312199201241077");
		people2.setAge(28);
		people2.setName("leo");
		
		People[] peoples = new People[]{};
		People people3 = new People();
		people3.setId("212312199201241077");
		people3.setAge(28);
		people3.setName("leo");
		
	}
	
	

}
