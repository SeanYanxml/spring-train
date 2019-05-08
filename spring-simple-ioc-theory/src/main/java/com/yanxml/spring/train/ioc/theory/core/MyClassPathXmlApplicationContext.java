package com.yanxml.spring.train.ioc.theory.core;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
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
	private List<Bean> beanList;
	private Map<String,Object> beanObject;
	
	public MyClassPathXmlApplicationContext(String url){
		beanList=new ArrayList<Bean>();
		beanObject=new HashMap<String, Object>();
		//调用默认函数
		//将其中的东西进行加载 到Spring容器中
		readXml(url);
		instanceBeans();
		injectObject();
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
			//URL and URI
			doc=(Document) sb.build(new FileInputStream(new File(xmlPath.toURI())));
			Namespace xhtml=Namespace.getNamespace("xhtml", "http://www.springframework.org/schema/beans");
			root=doc.getRootElement();//获取根元素
			List<Element> bList=root.getChildren("bean",xhtml);//获取全部bean节点
			for(Element beanElement :bList){//遍历节点 获取每个节点的属性
				String id=beanElement.getAttributeValue("id");
				String className=beanElement.getAttributeValue("class");
				//获取每个bean的属性
				List<Element> pList=beanElement.getChildren("property",xhtml);
				List<Property> propertyList=new ArrayList<Property>();//存储属性信息
				if(pList.size()>0){//如果存在属性
					for(Element propertyElement :pList){
						String name=propertyElement.getAttributeValue("name");
						String ref=propertyElement.getAttributeValue("ref");
						Property property=new Property(name,ref);
						propertyList.add(property);
					}
				}
				Bean bean =new Bean(id,className,propertyList);
				beanList.add(bean);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/** 
	 *为bean对象的属性注入值 
     */ 
	public void injectObject(){
		for(Bean bean:beanList){
			Object object=beanObject.get(bean.getId());//获取bean实例
			if(object !=null){
				try{
					//取得bean的属性描述
					PropertyDescriptor []ps=Introspector.getBeanInfo(object.getClass()).getPropertyDescriptors();
					for(Property property:bean.getPropertyList()){//获取bean节点的属性
						for(PropertyDescriptor properdesc :ps){
							if(property.getName().equals(properdesc.getName())){
								Method setter=properdesc.getWriteMethod();//获取属性Setter方法
								if(setter !=null){
									Object value=beanObject.get(property.getRef());//取得值
									setter.setAccessible(true);//设置允许访问
									setter.invoke(object, value);//把对象引入到属性
								}
							}
						}
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			
					
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
