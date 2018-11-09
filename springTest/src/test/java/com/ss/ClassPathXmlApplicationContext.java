package com.ss;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class ClassPathXmlApplicationContext {

	Map<String, Object> map = new HashMap<>();

	public ClassPathXmlApplicationContext(String path) {
		// 获取流对象
		InputStream stream = ClassPathXmlApplicationContext.class.getClassLoader().getResourceAsStream(path);
		SAXBuilder builder = new SAXBuilder();
		Document document = null;
		Object obj = null;
		try {
			document = builder.build(stream);
			//获取根目录
			Element beans = document.getRootElement();
			//bean集合
			List<Element> beanlist = beans.getChildren();
			for (Element bean : beanlist) {
				String id = bean.getAttributeValue("id");
				String clazz = bean.getAttributeValue("class");			
				System.out.println(clazz);		
				obj = Class.forName(clazz).newInstance();
				//property集合
				List<Element> propertylist = bean.getChildren();
				for (Element property : propertylist) {
					
				}
			}

		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("container.xml");
	}

}
