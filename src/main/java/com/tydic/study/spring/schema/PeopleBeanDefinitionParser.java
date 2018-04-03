package com.tydic.study.spring.schema;

import org.w3c.dom.Element;

import org.springframework.util.StringUtils; 
import com.tydic.study.spring.bean.People;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;

public class PeopleBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

	protected Class getBeanClass(Element element) {
		return People.class;
	}
	
	protected void doParse(Element element,BeanDefinitionBuilder builder) {
		String name = element.getAttribute("name");
		String id = element.getAttribute("id");
		String age = element.getAttribute("age");
		if(StringUtils.hasText(id)){
			builder.addPropertyValue("id", id);		
		}
		if(StringUtils.hasText(name)){
			builder.addPropertyValue("name", name);
		}
		if(StringUtils.hasText(age)){
			builder.addPropertyValue("age", age);
		}
	}
}
