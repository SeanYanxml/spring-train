package com.yanxml.spring.train.bean.init.theory.spring;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;

public class MyClassPathXmlApplicationContext {
	private List<Bean>beanList;
	private Map<String,Object> beanObject;

/*	public MyClassPathXmlApplicationContext(){
		beanList=new ArrayList<Bean>();
		beanObject=new HashMap<String, Object>();		
	}*/
	public MyClassPathXmlApplicationContext(String url){
		beanList=new ArrayList<Bean>();
		beanObject=new HashMap<String, Object>();
		this.readXml(url);
		this.instanceBeans();
	}
	/**
	 * 读取xml配置文件 
     * @param fileName 配置文件名 
	 * */
	private void readXml(String fileName){
		//寻找配置文件
		URL xmlPath=this.getClass().getClassLoader().getResource(fileName);
		Document doc=null;
		Element root=null;
		try{
			SAXBuilder sb=new SAXBuilder(false);
			doc=sb.build(new FileInputStream(new File(xmlPath.toURI())));
			//设置命名空间
			Namespace xhtml=Namespace.getNamespace("xhtml","http://www.springframework.org/schema/beans");
			root=doc.getRootElement();//获取根元素
			List<Element> list=root.getChildren("bean",xhtml);
			for(Element element:list){
				String id=element.getAttributeValue("id");
				String className=element.getAttributeValue("class");
				Bean bean=new Bean();
				bean.setId(id);
				bean.setClassName(className);
				beanList.add(bean);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/** 
    * bean的实例化 
    */
	private void instanceBeans(){
		for(Bean bean:beanList){
			try{
				//使用类的反射完成
				//之前后面的!非运算符写错了 导致报错 ，即未加载Bean
				//if(bean.getClassName()!=null && !"".equals(bean.getClassName().trim())){
				if(bean.getClassName()!=null && !"".equals(bean.getClassName().trim())){
					beanObject.put(bean.getId(), Class.forName(bean.getClassName()).newInstance());
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	/** 
     * 获取bean实例 
     * @param beanName 配置文件中bean的Id 
     * @return 
     */ 
	public Object getBean(String beanName){
		return this.beanObject.get(beanName);
	}

}
