package com.tydic.study.anno.processor;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;


import com.google.auto.service.AutoService;
import com.tydic.study.annokit.annotation.NameScanner;

@SupportedAnnotationTypes("*")
@SupportedSourceVersion(SourceVersion.RELEASE_7)
@AutoService(Processor.class)
public class NameScannerProcessor extends AbstractProcessor {
	

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		// TODO Auto-generated method stub
		if(roundEnv.processingOver()){
			for(Element element:roundEnv.getElementsAnnotatedWith(NameScanner.class)){
				String name = element.getSimpleName().toString();
				processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "----element name: " + name);
			}
		}
		return false;
	}

}
