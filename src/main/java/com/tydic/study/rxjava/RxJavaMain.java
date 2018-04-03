package com.tydic.study.rxjava;

import org.apache.log4j.Logger;

import rx.Observable;
import rx.functions.Action1;
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
			
		});*/
		Observable.just(1,2,3,4)
		.subscribeOn(Schedulers.io())
		.observeOn(Schedulers.immediate())
		.subscribe(new Action1<Integer>(){

			@Override
			public void call(Integer number) {
				// TODO Auto-generated method stub
				logger.info("number:"+number);
			}
			
		});

	}
	
	

}
