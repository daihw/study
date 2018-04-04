package com.tydic.study.rxjava;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.tydic.study.spring.bean.Course;
import com.tydic.study.spring.bean.People;
import com.tydic.study.spring.bean.Student;

import rx.Observable;
import rx.Subscriber;
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
		
		testMapMethod("images/logo.png");
		Course course1 = new Course();
		course1.setClassName("高等数学");
		course1.setClassHour(50);
		
		Course course2 = new Course();
		course2.setClassName("数学分析");
		course2.setClassHour(80);
		
		Course course3 = new Course();
		course3.setClassName("偏微分方程");
		course3.setClassHour(40);
		
		Course course4 = new Course();
		course4.setClassName("概率论");
		course4.setClassHour(50);
		List<Course> courseList1 = new ArrayList<Course>();
		courseList1.add(course1);
		courseList1.add(course2);
		courseList1.add(course4);
		
		List<Course> courseList2 = new ArrayList<Course>();
		courseList2.add(course1);
		courseList2.add(course2);
		courseList2.add(course3);
		
		Student student1 = new Student();
		student1.setAge(20);
		student1.setName("韩梅梅");
		student1.setId(05207010207);
		student1.setSex("女");
		student1.setCourses(courseList1);
		
		Student student2 = new Student();
		student2.setAge(22);
		student2.setName("李雷");
		student2.setId(03207010207);
		student2.setSex("男");
		student2.setCourses(courseList2);
		
		Student[] students = new Student[]{student1,student2};
		//testMapMethod(students);
		//testMapMethod1(students);
		testFlatMap(students);
		
		
	}
	
	
	public static void testMapMethod(String s){
		Observable.just(s)
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
	}
	
	public static void testMapMethod(Student[] students){
		Subscriber<String> subscriber = new Subscriber<String>(){

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onError(Throwable e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onNext(String t) {
				// TODO Auto-generated method stub
				logger.info("name:"+t);;
				
				
			}
			
		};
		Observable.from(students)
		.map(new Func1<Student,String>(){

			@Override
			public String call(Student t) {
				// TODO Auto-generated method stub
				return t.getName();
			}
			
		}).subscribe(subscriber);
	}
	
	public static void testMapMethod1(Student[] students){
		Subscriber<Student> subscriber = new Subscriber<Student>(){

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onError(Throwable e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onNext(Student student) {
				// TODO Auto-generated method stub
				List<Course> courses = student.getCourses();
				for(Course course:courses){
					logger.info("name:"+course.getClassName());
				}	
				
			}
			
		};
		Observable.from(students)
		.subscribe(subscriber);
	}

	
	public static void testFlatMap(Student[] students){
		Subscriber<Course> subscriber = new Subscriber<Course>(){

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onError(Throwable e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onNext(Course course) {
				// TODO Auto-generated method stub
				logger.info("name:"+course.getClassName());
			}
			
		};
		Observable.from(students)
		.flatMap(new Func1<Student,Observable<Course>>(){

			@Override
			public Observable<Course> call(Student student) {
				// TODO Auto-generated method stub
				return Observable.from(student.getCourses());
			}
			
		}).subscribe(subscriber);
	}
}
