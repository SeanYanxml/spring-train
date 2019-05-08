
# 不错的Spring学习笔记(转)

### Spring学习笔记（1）----简单的实例
---------------------------------
 
首先需要准备Spring包，可从官方网站上下载。
 
下载解压后，必须的两个包是spring.jar和commons-logging.jar。此外为了便于测试加入了JUnit包。
 
在Myeclipse中创建Java项目。
 
编写一个接口类，为了简单，只加入了一个方法。
 
```
Java代码  
package com.szy.spring.interfacebean;  
  
public interface PersonBean  
{  
    void show();  
}  
```
 然后写一个类实现这个接口。
  
 
``` 
Java代码  
1.package com.szy.spring.implbean;  
2.import com.szy.spring.interfacebean.PersonBean;  
3.  
4.public class UserBean implements PersonBean  
5.{  
6.  
7.    public void show()  
8.    {  
9.        System.out.println("Hello Kuka");  
10.    }  
11.  
12.}  
```
  
  
  
  
以上的过程我们再熟悉不过了，下面开始加入Spring的内容了。首先从下载的Sping包中找到配置文件，删除不需要的，找到最原始的部分：
  
 
 
Xml代码  
1.<?xml version="1.0" encoding="UTF-8"?>  
2.<beans xmlns="http://www.springframework.org/schema/beans" 
3.    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
4.    xmlns:context="http://www.springframework.org/schema/context" 
5.    xmlns:tx="http://www.springframework.org/schema/tx" 
6.    xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.5.xsd  
7.                http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-2.5.xsd  
8.                http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-2.5.xsd">  
9.  
10.</beans>  
  
  
  
我们在配置文件中加入我们的bean信息
  
 
 
Xml代码  
1.<bean id="userBean" class="com.szy.spring.implbean.UserBean" />  
  
 其中id作为标识符，class为类的包路径。
  
这样我们的配置文件就写好了，完整的配置文件呢如下。
  
 
 
Xml代码  
1.<?xml version="1.0" encoding="UTF-8"?>  
2.<beans xmlns="http://www.springframework.org/schema/beans" 
3.    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
4.    xmlns:context="http://www.springframework.org/schema/context" 
5.    xmlns:tx="http://www.springframework.org/schema/tx" 
6.    xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.5.xsd  
7.                http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-2.5.xsd  
8.                http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-2.5.xsd">  
9.  
10.    <bean id="userBean" class="com.szy.spring.implbean.UserBean" />  
11.</beans>  
  
  
  
  
  
最后我们创建一个测试类测试：
  
 
 
Java代码  
1.package com.szy.spring.test;  
2.  
3.import org.junit.Test;  
4.import org.springframework.context.ApplicationContext;  
5.import org.springframework.context.support.ClassPathXmlApplicationContext;  
6.import com.szy.spring.interfacebean.PersonBean;  
7.  
8.  
9.public class TestClass  
10.{  
11.    @Test 
12.    public void testMethod() throws Exception  
13.    {  
14.        //读取配置文件  
15.        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");  
16.        //获取UserBean的实例  
17.        PersonBean bean=(PersonBean)ctx.getBean("userBean");  
18.        //调用方法  
19.        bean.show();  
20.    }  
21.}  
 
运行，输入如下结果：
  
 
结果代码  
1.Hello Kuka  
 
Ok，我们的第一个Spring程序成功运行。
 
 
 
Sping学习笔记（2）----实例化Bean的三种方式
-------------------------------------------
Spring的实例化Bean有三种方式：
  
 使用类构造器直接实例化
  
 使用静态工厂的方法实例化
  
 使用实例工厂方法实例化
  
  
  
三种方式对应的配置如下
  
 
 
Xml代码  
1.<?xml version="1.0" encoding="UTF-8"?>  
2.<beans xmlns="http://www.springframework.org/schema/beans" 
3.        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
4.        xmlns:context="http://www.springframework.org/schema/context" 
5.        xmlns:tx="http://www.springframework.org/schema/tx" 
6.        xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.5.xsd  
7.                http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-2.5.xsd  
8.                http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-2.5.xsd">  
9.        <!-- 使用类构造器直接实例化 -->    
10.        <bean id="userBean1" class="com.szy.spring.implbean.UserBean" />  
11.        <!-- 使用静态工厂的方法实例化 -->  
12.        <bean id="userBean2" class="com.szy.spring.factory.BeanFactory" factory-method="UserBeanService" />  
13.        <!-- 使用实例工厂方法实例化 -->  
14.        <bean id="factory" class="com.szy.spring.factory.BeanFactory" />  
15.        <bean id="userBean3" factory-bean="factory" factory-method="getUserBeanService" />  
16.</beans>  
  
  
  
  
  
其中BeanFactory类的代码如下
  
 
 
Java代码  
1.package com.szy.spring.factory;  
2.  
3.import com.szy.spring.implbean.UserBean;  
4.import com.szy.spring.interfacebean.PersonBean;  
5.  
6.public class BeanFactory  
7.{  
8.    //使用静态工厂的方法实例化使用  
9.    public static PersonBean UserBeanService()  
10.    {  
11.        return new UserBean();  
12.    }  
13.      
14.    public PersonBean getUserBeanService()  
15.    {  
16.        return new UserBean();  
17.    }  
18.}  
  
  
  
在这三种方式中我们最常用的还是第一种。
 
 
 
 
 
 
 
Spring学习笔记（3）----编码剖析Spring管理Bean的原理
--------------------------------------------------
 
 
Xml代码  
1.<?xml version="1.0" encoding="UTF-8"?>  
2.<beans xmlns="http://www.springframework.org/schema/beans" 
3.        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
4.        xmlns:context="http://www.springframework.org/schema/context" 
5.        xmlns:tx="http://www.springframework.org/schema/tx" 
6.        xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.5.xsd  
7.                http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-2.5.xsd  
8.                http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-2.5.xsd">  
9.        <bean id="userBean" class="com.szy.spring.implbean.UserBean" />  
10.</beans>  
  
  
  
Spring的配置文件中记录了类的包路径，因此我们首先是要读入配置文件。在配置文件中Bean有id和class两个属性，我们首先定义一个Bean类，包含这两个属性：
  
  
  
 
 
Java代码  
1.package com.szy.spring.implbean;  
2.  
3.public class Bean  
4.{  
5.    private String id;  
6.    private String className;  
7.    public String getId()  
8.    {  
9.        return id;  
10.    }  
11.    public void setId(String id)  
12.    {  
13.        this.id = id;  
14.    }  
15.    public String getClassName()  
16.    {  
17.        return className;  
18.    }  
19.    public void setClassName(String className)  
20.    {  
21.        this.className = className;  
22.    }  
23.      
24.}  
25.   
  
由于配置文件是xml文件，在这里使用Jdom包操作xml文件，读入配置文件中的Bean信息。
  
 
 
Java代码  
1./** 
2.     * 读取xml配置文件 
3.     * @param fileName 配置文件名 
4.     */ 
5.    private void readXML(String fileName)  
6.    {  
7.        // 寻找配置文件  
8.        URL xmlPath = this.getClass().getClassLoader().getResource(fileName);  
9.        Document doc = null;  
10.        Element root = null;  
11.        try 
12.        {  
13.            SAXBuilder sb = new SAXBuilder(false);  
14.            doc = sb.build(new FileInputStream(new File(xmlPath.toURI())));  
15.            // 设置命名空间  
16.            Namespace xhtml = Namespace.getNamespace("xhtml",  
17.                    "http://www.springframework.org/schema/beans");  
18.            root = doc.getRootElement(); // 获取根元素  
19.            List<Element> list = root.getChildren("bean", xhtml); //获取全部bean节点  
20.            for (Element element : list)// 遍历节点，取得每个节点的属性  
21.            {  
22.                String id = element.getAttributeValue("id");  
23.                String className = element.getAttributeValue("class");  
24.                Bean bean = new Bean();  
25.                bean.setId(id);  
26.                bean.setClassName(className);  
27.                beanList.add(bean);  
28.            }  
29.        } catch (Exception e)  
30.        {  
31.            e.printStackTrace();  
32.        }  
33.  
34.    }  
  
  
  
 其中beanList是一个List对象，因为在配置文件中存在很多Bean。
  
  
  
得到了所有的Bean对象后，下面就实例化每个Bean对象，结果存放在Map对象中。
  
  
  
 
 
Java代码  
1./** 
2.     * bean的实例化 
3.     */ 
4.    private void instanceBeans()  
5.    {  
6.        for (Bean bean : beanList)  
7.        {  
8.            try 
9.            {  
10.                if (bean.getClassName() != null && !"".equals(bean.getClassName().trim()))  
11.                    beanObject.put(bean.getId(), Class.forName(bean.getClassName()).newInstance());  
12.            } catch (Exception e)  
13.            {  
14.                e.printStackTrace();  
15.            }  
16.        }  
17.  
18.    }  
  
 其中beanObject为Map对象。
  
  
  
最后再加入一个方法，方便外部能获取Map中的对象
  
 
 
Java代码  
1./** 
2.     * 获取bean实例 
3.     * @param beanName 配置文件中bean的Id 
4.     * @return 
5.     */ 
6.    public Object getBean(String beanName)  
7.    {  
8.        return this.beanObject.get(beanName);  
9.    }  
  
 完整的MyClassPathXMLApplicationContext见附件中的代码。
  
  
  
下面测试MyClassPathXMLApplicationContext类。
  
 
 
Java代码  
1.@Test 
2.    public void testMethod() throws Exception  
3.    {  
4.        //读取配置文件  
5.        MyClassPathXMLApplicationContext ctx=new MyClassPathXMLApplicationContext("applicationContext.xml");  
6.        //获取UserBean的实例  
7.        PersonBean bean=(PersonBean)ctx.getBean("userBean");  
8.        //调用方法  
9.        bean.show();  
10.    }  
  
  
  
输出结果
  
 
 
结果代码  
1.Hello Kuka  
  
  
  
成功。
  
上面仅是简单的演示了Spring管理Bean的原理，但是在实际操作中还需要考虑很对其它因素。
 
 
 
 
 
 
 
 
Spring学习笔记（4）----Bean节点信息配置
---------------------------------------
默认情况下，Spring的Ioc容器启动时会初始化bean，但是我们可以指定Bean节点的lazy-init="true"，来延迟初始化bean。这时候，只有第一次获取bean才会初始化bean。如
  
 
 
Xml代码  
1.<bean id="userBean" class="com.szy.spring.implbean.UserBean" lazy-init="true" />  
  
 如果想对所有的bean有应用延迟初始化，可以在跟节点beans设置default-lazy-init="true"，如下：
  
 
 
Xml代码  
1.<beans default-lazy-init="true"....>  
  
 此外，如果我们还想UserBean在实例化是调用初始化方法时，我们可以加入“init-method="init"”属性，其中init为Userbean中的init()方法，与之对应，“destroy-method="destroy"”为销毁属性。
  
在Spring中我们通过getBean(name)方法获得实例，那么我们每次获取的实例化对象是一个还是多个呢？
  
我们可以通过“==”进行测试
  
 
 
Java代码  
1.ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");     
2.PersonBean bean1=(PersonBean)ctx.getBean("userBean");  
3.PersonBean bean2=(PersonBean)ctx.getBean("userBean");  
4.System.out.println(bean1==bean2);  
  
 运行输出结果为：true
  
这说明了Bean交给sping容器管理之后，Bean默认情况下是单实例的。
  
如果我们想每次通过getBean(name)方法获得实例是一个新的实例化对象该怎么办呢？
  
在配置文件中节点bean有一个属性scope，只要我们配置如下即可：
  
 
 
Xml代码  
1.<bean id="userBean" class="com.szy.spring.implbean.UserBean" scope="prototype" />  
  
 在运行测试代码，输出结果为：false
 
 
 
Spring学习笔记（5）----依赖注入的简单实现
-----------------------------------------
Spring的核心机制是依赖注入。依赖注入让bean与bean之间以配置文件组织在一起，而不是以硬编码的方式耦合在一起。依赖注入(Dependency Injection)和控制反转(Inversion of Control)是同一个概念。具体含义是:当某个角色(可能是一个Java实例，调用者)需要另一个角色(另一个Java实例，被调用者)的协助时，在传统的程序设计过程中，通常由调用者来创建被调用者的实例。但在Spring里，创建被调用者的工作不再由调用者来完成，因此称为控制反转;创建被调用者实例的工作通常由Spring容器来完成，然后注入调用者，因此也称为依赖注入。管是依赖注入，还是控制反转，都说明Spring采用动态、灵活的方式来管理各种对象。对象与对象之间的具体实现互相透明。
  
下面通过简单的实例演示依赖注入。
  
项目中主要包含一下一个文件：
 
  
  
UserDAO是一个接口，包含了一个方法：
  
 
 
Java代码  
1.package com.szy.spring.dao;  
2.  
3.public interface UserDAO  
4.{  
5.    void show();  
6.}  
  
  
  
而UserDAO4MySqlImpl和UserDAO4OracleImpl实现了UserDAO中的方法。
  
 
 
Java代码  
1.package com.szy.spring.dao;  
2.public class UserDAO4MySqlImpl implements UserDAO  
3.{  
4.    public void show()  
5.    {  
6.        System.out.println("MySqlDAO Implement");  
7.    }  
8.}  
  
  
  
 
 
Java代码  
1.package com.szy.spring.dao;  
2.public class UserDAO4OracleImpl implements UserDAO  
3.{  
4.    public void show()  
5.    {  
6.        System.out.println("OracleDAO Implement");  
7.    }  
8.}  
  
  
  
UserService是另外一个包中的接口，
  
 
 
Java代码  
1.package com.szy.spring.service;  
2.  
3.public interface UserService  
4.{  
5.    void show();  
6.}  
  
  
  
UserServiceImpl实现了这个接口，
  
 
 
Java代码  
1.package com.szy.spring.service;  
2.  
3.import com.szy.spring.dao.UserDAO;  
4.  
5.public class UserServiceImpl implements UserService  
6.{  
7.    private UserDAO userDAO;  
8.      
9.    public void show()  
10.    {  
11.        userDAO.show();  
12.    }  
13.  
14.    public UserDAO getUserDAO()  
15.    {  
16.        return userDAO;  
17.    }  
18.    public void setUserDAO(UserDAO userDAO)  
19.    {  
20.        this.userDAO = userDAO;  
21.    }  
22.}  
  
 但是在实现这个接口中，调用了UserDAO中的方法。一般情况下我们需要在这里实例化一个UserDAO对象，比如
  
 
 
Java代码  
1.UserDAO userDAO=new UserDAO4MySqlImpl();  
  
 这样的话耦合度就比较高，通过spring我们可以降低耦合度。
  
在Sping的配置文件中，我们需要这样配置
  
 
 
Java代码  
1.<?xml version="1.0" encoding="UTF-8"?>  
2.<beans xmlns="http://www.springframework.org/schema/beans" 
3.    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
4.    xmlns:context="http://www.springframework.org/schema/context" 
5.    xmlns:tx="http://www.springframework.org/schema/tx" 
6.    xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.5.xsd  
7.                http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-2.5.xsd  
8.                http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-2.5.xsd">  
9.    <bean id="mySqlDAO" class="com.szy.spring.dao.UserDAO4MySqlImpl"/>  
10.    <bean id="oracleDAO" class="com.szy.spring.dao.UserDAO4OracleImpl"/>  
11.    <bean id="userService" class="com.szy.spring.service.UserServiceImpl">  
12.        <!--构造方法注入    
13.            <property name="userDAO" ref="mySqlDAO"></property>  
14.        -->  
15.        <property name="userDAO" ref="oracleDAO"></property>  
16.    </bean>  
17.</beans>  
  
  
  
下面我们测试
  
 
 
Java代码  
1.ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");     
2.        UserService service=(UserService)ctx.getBean("userService");  
3.        service.show();  
  
  
  
输入内容为
  
 
 
输出代码  
1.OracleDAO Implement  
  
 如果我们想实用Mysql数据库呢？ 
  
此时我们只要修改配置文件即可，而不需要修改Java文件。
  
 
 
Xml代码  
1.<property name="userDAO" ref="mySqlDAO"></property>  
 
 
 
 
 
 
 
 
Spring学习笔记（6）----编码剖析Spring依赖注入的原理
---------------------------------------------------
在Spring学习笔记（3）中剖析了Spring管理Bean的原理，下面解释下Spring依赖注入的原理
  
在进行依赖注入时，我们的配置文件如下配置：
  
 
 
Xml代码  
1.<?xml version="1.0" encoding="UTF-8"?>  
2.<beans xmlns="http://www.springframework.org/schema/beans" 
3.    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
4.    xmlns:context="http://www.springframework.org/schema/context" 
5.    xmlns:tx="http://www.springframework.org/schema/tx" 
6.    xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.5.xsd  
7.                http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-2.5.xsd  
8.                http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-2.5.xsd">  
9.    <bean id="mySqlDAO" class="com.szy.spring.dao.UserDAO4MySqlImpl"/>  
10.    <bean id="oracleDAO" class="com.szy.spring.dao.UserDAO4OracleImpl"/>  
11.    <bean id="userService" class="com.szy.spring.service.UserServiceImpl">  
12.        <!--构造方法注入    
13.            <property name="userDAO" ref="mySqlDAO"></property>  
14.        -->  
15.        <property name="userDAO" ref="oracleDAO"></property>  
16.    </bean>  
17.</beans>  
  
 根据配置文件信息，我们首先需要建立一个Bean类，用来保存bean节点的信息：
  
 
 
Java代码  
1.package com.szy.spring.bean;  
2.  
3.import java.util.List;  
4.  
5.public class Bean  
6.{  
7.    private String id;     
8.    private String className;   
9.    private List<Property> propertyList;  
10.    public Bean(String id, String className, List<Property> propertyList)  
11.    {  
12.        super();  
13.        this.id = id;  
14.        this.className = className;  
15.        this.propertyList = propertyList;  
16.    }  
17.    public String getId()     
18.    {     
19.        return id;     
20.    }     
21.    public void setId(String id)     
22.    {     
23.        this.id = id;     
24.    }     
25.    public String getClassName()     
26.    {     
27.        return className;     
28.    }     
29.    public void setClassName(String className)     
30.    {     
31.        this.className = className;     
32.    }  
33.    public List<Property> getPropertyList()  
34.    {  
35.        return propertyList;  
36.    }  
37.    public void setPropertyList(List<Property> propertyList)  
38.    {  
39.        this.propertyList = propertyList;  
40.    }     
41.}  
  
 此外，由于bean下存在property信息，因此我们还需要建立property类
  
 
 
Java代码  
1.package com.szy.spring.bean;  
2.  
3.public class Property  
4.{  
5.    private String name;  
6.    private String ref;  
7.      
8.    public Property(String name, String ref)  
9.    {  
10.        super();  
11.        this.name = name;  
12.        this.ref = ref;  
13.    }  
14.    public String getName()  
15.    {  
16.        return name;  
17.    }  
18.    public void setName(String name)  
19.    {  
20.        this.name = name;  
21.    }  
22.    public String getRef()  
23.    {  
24.        return ref;  
25.    }  
26.    public void setRef(String ref)  
27.    {  
28.        this.ref = ref;  
29.    }  
30.      
31.}  
  
  
  
在Spring学习笔记（3）中，我们在读取xml文件时bean节点下面是不存在property节点的，因此在这里我们需要修改readXML()方法：
  
 
 
Java代码  
1./** 
2.     * 读取xml配置文件 
3.     * @param fileName 配置文件名 
4.     */ 
5.    private void readXML(String fileName)  
6.    {  
7.        // 寻找配置文件  
8.        URL xmlPath = this.getClass().getClassLoader().getResource(fileName);  
9.        Document doc = null;  
10.        Element root = null;  
11.        try 
12.        {  
13.            SAXBuilder sb = new SAXBuilder(false);  
14.            doc = sb.build(new FileInputStream(new File(xmlPath.toURI())));  
15.            // 设置命名空间     
16.            Namespace xhtml = Namespace.getNamespace("xhtml",  
17.                    "http://www.springframework.org/schema/beans");  
18.            root = doc.getRootElement(); // 获取根元素     
19.            List<Element> bList = root.getChildren("bean", xhtml); //获取全部bean节点     
20.            for (Element beanElement : bList)// 遍历节点，取得每个节点的属性     
21.            {  
22.                String id = beanElement.getAttributeValue("id");  
23.                String className = beanElement.getAttributeValue("class");  
24.                //获得每个bean下面的属性  
25.                List<Element> pList = beanElement  
26.                        .getChildren("property", xhtml);  
27.                List<Property> propertyList = new ArrayList<Property>(); //存储属性信息  
28.                if (pList.size() > 0) //如果存在属性  
29.                {  
30.                    for (Element propertyElement : pList) //遍历属性节点  
31.                    {  
32.                        String name = propertyElement.getAttributeValue("name");  
33.                        String ref = propertyElement.getAttributeValue("ref");  
34.                        Property property = new Property(name, ref);  
35.                        propertyList.add(property); //保存属性节点  
36.                    }  
37.                }  
38.                Bean bean = new Bean(id, className, propertyList);  
39.                beanList.add(bean);  
40.            }  
41.  
42.        } catch (Exception e)  
43.        {  
44.            e.printStackTrace();  
45.        }  
46.    }  
  
 读取完配置文件后我们还是需要对bean进行实例化的，这方法和Spring学习笔记（3）中的instanceBeans()方法一样。下面就是我们需要给bean属性进行注入，实现方法如下：
  
 
 
Java代码  
1./** 
2.     * 为bean对象的属性注入值 
3.     */ 
4.    public void injectObject()  
5.    {  
6.        for (Bean bean : beanList)  
7.        {  
8.            Object object = beanObject.get(bean.getId()); //获取bean的实例  
9.            if (object != null)  
10.            {  
11.                try 
12.                {  
13.                    PropertyDescriptor[] ps = Introspector.getBeanInfo(  
14.                            object.getClass()).getPropertyDescriptors();  //取得bean的属性描述  
15.                    for (Property property : bean.getPropertyList())  //获取bean节点的属性  
16.                    {  
17.                        for (PropertyDescriptor properdesc : ps)    
18.                        {  
19.                            if (property.getName().equals(properdesc.getName()))  
20.                            {  
21.                                Method setter = properdesc.getWriteMethod();//获取属性的setter方法 ,private  
22.                                if (setter != null)  
23.                                {  
24.                                    Object value = beanObject.get(property.getRef());  //取得值  
25.                                    setter.setAccessible(true);  //设置为允许访问  
26.                                    setter.invoke(object, value);//把引用对象注入到属性  
27.                                }  
28.                                break;  
29.                            }  
30.                        }  
31.                    }  
32.                } catch (Exception e)  
33.                {  
34.                    e.printStackTrace();  
35.                }  
36.            }  
37.        }  
  
  
  
我们进行测试：
  
 
 
Java代码  
1.MyClassPathXMLApplicationContext ctx=new MyClassPathXMLApplicationContext("applicationContext.xml");     
2.        UserService service=(UserService)ctx.getBean("userService");  
3.        service.show();  
  
  
  
运行输出
  
 
 
结果代码  
1.OracleDAO Implement  
  
 上面仅是简单的演示了Spring依赖注入的原理，但是Spring学习笔记（7）----装配各种集合类型的属性在实际操作中还需要考虑很对其它因素，在此就不进行讨论了。
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
Spring学习笔记（7）----装配各种集合类型的属性
---------------------------------------------
前面已经介绍了如何给属性注入对象，下面介绍一下如何装配集合类型的属性 
1.Set类型
  
 
 
Java代码  
1.private Set<String> sets=new HashSet<String>();  
2.//我们需要给它添加set方法  
3.public Set<String> getSets()  
4.    {  
5.        return sets;  
6.    }  
7.    public void setSets(Set<String> sets)  
8.    {  
9.        this.sets = sets;  
10.    }  
11.public Set<String> showSet()  
12.    {  
13.        return sets;  
14.    }  
  
 然后根据属性修改配置文件
  
 
 
Xml代码  
1.<bean id="userService" class="com.szy.spring.service.UserServiceImpl">  
2.        <property name="sets">  
3.            <set>  
4.                <value>Set1</value>  
5.                <value>Set2</value>  
6.                <value>Set3</value>  
7.            </set>      
8.        </property>  
9.  
10.</bean>  
  
 与以前不同的是我们在property下面添加了<set></set>
  
这样就能装配set类型的属性
  
2.List类型
  
List类型的属性和Set类型的方法一样，主要是把配置文件中的set修改成list。
  
 
 
Java代码  
1.private List<String> lists=new ArrayList<String>();  
2.public List<String> getLists()  
3.    {  
4.        return lists;  
5.    }  
6.    public void setLists(List<String> lists)  
7.    {  
8.        this.lists = lists;  
9.    }  
10.public List<String> showList()  
11.    {  
12.        return lists;  
13.    }  
  
 配置文件修改如下
  
 
 
Xml代码  
1.<bean id="userService"  class="com.szy.spring.service.UserServiceImpl">  
2.<property name="lists">  
3.            <list>  
4.                <value>List1</value>  
5.                <value>List2</value>  
6.                <value>List3</value>  
7.            </list>  
8.        </property>  
9.    </bean>  
  
3.Properties类型
  
 
 
Java代码  
1.private Properties properties=new Properties();  
2.public void setProperties(Properties properties)  
3.    {  
4.        this.properties = properties;  
5.    }  
6.public Properties getProperties()  
7.    {  
8.        return properties;  
9.    }  
10.public Properties showProperties()  
11.    {  
12.        return properties;  
13.    }  
  
 配置文件需要如下配置
  
 
 
Xml代码  
1.<bean id="userService" class="com.szy.spring.service.UserServiceImpl">  
2.<property name="properties">  
3.            <props>  
4.                <prop key="key1">Properties1</prop>  
5.                <prop key="key2">Properties2</prop>  
6.                <prop key="key3">Properties3</prop>  
7.            </props>  
8.        </property>  
9.    </bean>  
10.      
  
 4.Map类型
  
 
 
Java代码  
1.private Map<String, String> maps=new HashMap<String, String>();  
2.public List<String> getLists()  
3.    {  
4.        return lists;  
5.    }  
6.    public void setLists(List<String> lists)  
7.    {  
8.        this.lists = lists;  
9.    }  
10.public Map<String, String> showMaps()  
11.    {  
12.        return maps;  
13.    }  
  
 配置文件做相应的配置
  
 
 
Xml代码  
1.<bean id="userService" class="com.szy.spring.service.UserServiceImpl">  
2.lt;property name="maps">  
3.        <map>  
4.            <entry key="key1" value="Map1"></entry>  
5.            <entry key="key2" value="Map2"></entry>  
6.            <entry key="key3" value="Map3"></entry>  
7.        </map>  
8.    </property>  
9.</bean>  
  
  
  
这样就完成了对Map类型的属性进行装配。
 
 
 
 
 
 
 
 
Spring学习笔记（8）----属性注入的方式
--------------------------------------
Spring中属性注入的方式有三种：
  
1.使用属性setter方法注入
  
2.使用构造器注入
  
3.使用注解方式注入
  
  
  
使用属性setter方法注入
  
使用属性setter方法注入就是给属性添加set()方法，在前面都是使用这种方法。
  
 
 
Java代码  
1.package com.szy.spring.service;  
2.  
3.import com.szy.spring.dao.PersonDao;  
4.  
5.public class UserServiceImplBySetter implements UserService  
6.{  
7.    private PersonDao personDao;  
8.      
9.    public void show()  
10.    {  
11.        personDao.show();  
12.    }  
13.    public PersonDao getPersonDao()  
14.    {  
15.        return personDao;  
16.    }  
17.    public void setPersonDao(PersonDao personDao)  
18.    {  
19.        this.personDao = personDao;  
20.    }  
21.}  
  
  
  
然后在配置文件中如下配置
  
 
 
Xml代码  
1.<bean id="personDao" class="com.szy.spring.dao.PersonDaoBean"/>  
2.    <!-- 使用属性Setter方法注入配置 -->  
3.    <bean id="userService1" class="com.szy.spring.service.UserServiceImplBySetter">  
4.        <property name="personDao" ref="personDao"></property>  
5.    </bean>  
  
  
  
使用构造器注入
  
使用构造器注入就是在类中添加含参构造函数
  
 
 
Java代码  
1.package com.szy.spring.service;  
2.  
3.import com.szy.spring.dao.PersonDao;  
4.  
5.public class UserServiceImplConstructor implements UserService  
6.{  
7.    private PersonDao personDao;  
8.    private String name;  
9.      
10.    public UserServiceImplConstructor()  
11.    {  
12.    }  
13.  
14.    public UserServiceImplConstructor(PersonDao personDao, String name)  
15.    {  
16.        this.personDao = personDao;  
17.        this.name = name;  
18.    }  
19.  
20.    public void show()  
21.    {  
22.        personDao.show();  
23.        System.out.println("name属性："+name);  
24.    }  
25.}  
  
  
  
下面就是在配置文件中添加配置信息，给每个参数注入值
  
 
 
Xml代码  
1.<bean id="personDao" class="com.szy.spring.dao.PersonDaoBean"/>  
2.    <!-- 使用构造器参数方法注入配置 -->  
3.    <bean id="userService2" class="com.szy.spring.service.UserServiceImplConstructor">  
4.        <constructor-arg index="0" type="com.szy.spring.dao.PersonDao" ref="personDao"/>  
5.        <constructor-arg index="1" value="Kuka"/>  
6.    </bean>  
  
 注意：constructor-arg index是从0开始的
  
  
  
使用注解方式注入
  
如果使用前面的两种方法，配置文件将会显得很臃肿，因此我们可以使用注解的方式注入，使用注解方式注入有两种方法，第一种使用javax.annotation.Resource中提供的注解方式方法如下：
  
 
 
Java代码  
1.package com.szy.spring.service;  
2.  
3.import javax.annotation.Resource;  
4.  
5.import com.szy.spring.dao.PersonDao;  
6.  
7.public class UserServiceImplByAnnotation4Resource implements UserService  
8.{  
9.    //@Resource默认是按照名称装配，找不到与名称匹配的bean时按类型装配  
10.    @Resource(name="personDao")private PersonDao personDao;  
11.  
12.    public void show()  
13.    {  
14.        personDao.show();  
15.    }  
16.//  下面方法同样可以  
17.//  @Resource  
18.//  public void setPersonDao(PersonDao personDao)  
19.//  {  
20.//      this.personDao = personDao;  
21.//  }  
22.      
23.}  
  
  
  
此时配置文件要做相应的改变
  
 
 
Xml代码  
1.<?xml version="1.0" encoding="UTF-8"?>  
2.<beans xmlns="http://www.springframework.org/schema/beans" 
3.    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
4.    xmlns:context="http://www.springframework.org/schema/context" 
5.    xmlns:tx="http://www.springframework.org/schema/tx" 
6.    xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.5.xsd  
7.                http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-2.5.xsd  
8.                http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-2.5.xsd">  
9.    <context:annotation-config/>  
10.    <bean id="personDao" class="com.szy.spring.dao.PersonDaoBean"/>  
11.    <bean id="userService" class="com.szy.spring.service.UserServiceImplByAnnotation4Autowired">  
12.    </bean>  
13.</beans>  
  
  
  
 注意添加这句配置信息
  
<context:annotation-config/>
 
  
第二中方式就是使用spring提供的注解方式
  
org.springframework.beans.factory.annotation.Autowired;
  
注入使用时需要导入spring目录lib\j2ee\common-annotations.jar这个包
  
使用方法如下：
  
 
 
Java代码  
1.package com.szy.spring.service;  
2.  
3.import org.springframework.beans.factory.annotation.Autowired;  
4.import org.springframework.beans.factory.annotation.Qualifier;  
5.  
6.import com.szy.spring.dao.PersonDao;  
7.  
8.public class UserServiceImplByAnnotation4Autowired implements UserService  
9.{  
10.    //@Autowired默认使用类型进行装配，  
11.    @Autowired private PersonDao personDao;  
12.//  如果使用按名称进行装配，则需要如下  
13.//  @Autowired @Qualifier("personDao")private PersonDao personDao;  
14.    public void show()  
15.    {  
16.        personDao.show();  
17.    }  
18.      
19.}  
  
  
  
配置文件和上面一样。
  
  
  
在使用时建议使用@Resource，因为@Resource不依赖于spring框架。
 
 
 
 
 
 
Spring学习笔记（9）----让Spring自动扫描和管理Bean
-------------------------------------------------
 
 
 
Java代码  
1.package com.szy.spring.service;  
2.  
3.import org.springframework.stereotype.Service;  
4.  
5.import com.szy.spring.dao.PersonDao;  
6.@Service("service")  
7.public class UserServiceImpl implements UserService  
8.{  
9.    private PersonDao personDaoBean;  
10.      
11.    public void show()  
12.    {  
13.        personDaoBean.show();  
14.    }  
15.  
16.    public void setPersonDaoBean(PersonDao personDaoBean)  
17.    {  
18.        this.personDaoBean = personDaoBean;  
19.    }  
20.}  
  
 在前面的例子中，都是使用XML的bean定义来使用组件，在大的项目中，通常会有上百个组件，如果这些组件采用xml的bean定义来配置，显然会使配置文件显得很臃肿，查找和维护起来不方便。Spring2.5为我们引入了组件自动扫描机制，它可以在类路径下寻找标记了@Component、@Service、@Controller、@Repository注解的类，并把这些类纳入到spring容器中管理，它的作用和在xml中使用bean节点配置组件一样。要使用自动扫描机制，我们需要把配置文件如下配置：
  
 
 
Xml代码  
1.<?xml version="1.0" encoding="UTF-8"?>  
2.<beans xmlns="http://www.springframework.org/schema/beans" 
3.    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
4.    xmlns:context="http://www.springframework.org/schema/context" 
5.    xmlns:tx="http://www.springframework.org/schema/tx" 
6.    xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.5.xsd  
7.                http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-2.5.xsd  
8.                http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-2.5.xsd">  
9.    <context:component-scan base-package="com.szy.spring"></context:component-scan>  
10.</beans>  
  
 其中base-package为需要扫描的包（包括子包）
  
@Service用于标注业务层的组件，@Controller用于标注控制层组件（如struts中的action），@Repository用于标注数据访问组件，即DAO组件，而@Component泛指组件，当组件不好归类的时候，我们可以使用这个注解进行标注。但是在目前的spring版本中，这几个注解的作用是一样的，但是在以后可能会进行区分。
  
  
  
下面把先前的例子修改一下：
  
首先是PersonDaoBean类，修改如下
  
 
 
Java代码  
1.package com.szy.spring.dao;  
2.  
3.import org.springframework.stereotype.Repository;  
4.  
5.@Repository 
6.//告诉spring这个类要交给spring管理，  
7.public class PersonDaoBean implements PersonDao  
8.{  
9.    public void show()  
10.    {  
11.        System.out.println("执行PersonDaoBean中的add()方法");  
12.    }  
13.}  
  
  
  
然后是UserServiceImpl类
  
 
 
Java代码  
1.package com.szy.spring.service;  
2.  
3.import org.springframework.stereotype.Service;  
4.  
5.import com.szy.spring.dao.PersonDao;  
6.@Service 
7.//把这个类交给spring管理，作为服务了。  
8.public class UserServiceImpl implements UserService  
9.{  
10.    private PersonDao personDaoBean;  
11.      
12.    public void show()  
13.    {  
14.        personDaoBean.show();  
15.    }  
16.  
17.    public void setPersonDaoBean(PersonDao personDaoBean)  
18.    {  
19.        this.personDaoBean = personDaoBean;  
20.    }  
21.  
22.    public PersonDao getPersonDaoBean()  
23.    {  
24.        return personDaoBean;  
25.    }  
26.}  
  
  
  
  
  
 下面我们进行测试，原来的测试代码是userServiceImpl 
 
 
 
Java代码  
1.ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");  
2.        UserService service=(UserService)ctx.getBean("userService");  
3.        service.show();  
  
  
  
其中userService是我们在配置文件中配置的bean的id。但是如今我们并没有id这个属性，在spring2.5中，默认的id是类的名称，但是开后是小写，也就是userServiceImpl，因此测试代码应修改如下：
  
 
 
Java代码  
1.AbstractApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");  
2.        UserService service=(UserService)ctx.getBean("userServiceImpl");  
3.        System.out.println(service);  
  
  
  
如果我们想自己命名的话，则只需在注解后加上括号，里面写入你希望的名字，如
  
@Service("userService")。
  
  
  
在spring中默认的是之生成一个bean实例，如果我们想每次调用都产生一个实例，则标注需如下配置
  
@Service @Scope("prototype")
  
  
  
在xml中我们还可以配置初始化方法和销毁方法，使用标注后只需如下标注
  
 
 
Java代码  
1.@PostConstruct 
2.    public void init()  
3.    {  
4.        System.out.println("初始化");  
5.    }  
6.    @PreDestroy 
7.    public void destory()  
8.    {  
9.        System.out.println("销毁");  
10.    }  
  
  
  
 使用注解后，我们的xml文件变得十分简单，因此建议Spring学习笔记（10）----公共属性的注入配置大家在以后的开发中使用注解。
 
 
 
 
 
 
 
 
 
 
Spring学习笔记（10）----公共属性的注入配置
-------------------------------------------
假设我们定义了四个bean类，其代码分别如下：
  
 
 
Java代码  
1.package com.szy.spring.bean;  
2.  
3.public class Bean1 {  
4.    private Bean2 bean2;  
5.    private Bean3 bean3;  
6.    private Bean4 bean4;  
7.  
8.    public Bean2 getBean2()  
9.    {  
10.        return bean2;  
11.    }  
12.    public void setBean2(Bean2 bean2)  
13.    {  
14.        this.bean2 = bean2;  
15.    }  
16.    public Bean3 getBean3()  
17.    {  
18.        return bean3;  
19.    }  
20.    public void setBean3(Bean3 bean3)  
21.    {  
22.        this.bean3 = bean3;  
23.    }  
24.    public Bean4 getBean4()  
25.    {  
26.        return bean4;  
27.    }  
28.    public void setBean4(Bean4 bean4)  
29.    {  
30.        this.bean4 = bean4;  
31.    }  
32.}  
  
  
  
  
  
 
 
Java代码  
1.package com.szy.spring.bean;  
2.  
3.public class Bean2  
4.{  
5.    private int id;  
6.    private String name;  
7.    private String password;  
8.  
9.    public int getId()  
10.    {  
11.        return id;  
12.    }  
13.    public void setId(int id)  
14.    {  
15.        this.id = id;  
16.    }  
17.    public String getName()  
18.    {  
19.        return name;  
20.    }  
21.    public void setName(String name)  
22.    {  
23.        this.name = name;  
24.    }  
25.    public String getPassword()  
26.    {  
27.        return password;  
28.    }  
29.    public void setPassword(String password)  
30.    {  
31.        this.password = password;  
32.    }  
33.}  
  
  
  
  
  
 
 
Java代码  
1.package com.szy.spring.bean;  
2.  
3.public class Bean3  
4.{  
5.    private int id;  
6.    private String name;  
7.  
8.    public int getId()  
9.    {  
10.        return id;  
11.    }  
12.    public void setId(int id)  
13.    {  
14.        this.id = id;  
15.    }  
16.    public String getName()  
17.    {  
18.        return name;  
19.    }  
20.    public void setName(String name)  
21.    {  
22.        this.name = name;  
23.    }  
24.}  
  
  
  
  
  
 
 
Java代码  
1.package com.szy.spring.bean;  
2.  
3.public class Bean4  
4.{  
5.    private int age;  
6.  
7.    public int getAge()  
8.    {  
9.        return age;  
10.    }  
11.    public void setAge(int age)  
12.    {  
13.        this.age = age;  
14.    }  
15.}  
  
  
  
按照正常的思路，我们下面就要给每个类进行属性的注入，配置文件如下设置：
  
 
 
Xml代码  
1.<?xml version="1.0" encoding="UTF-8"?>  
2.<beans xmlns="http://www.springframework.org/schema/beans" 
3.    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
4.    xmlns:context="http://www.springframework.org/schema/context" 
5.    xmlns:tx="http://www.springframework.org/schema/tx" 
6.    xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.5.xsd  
7.                http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-2.5.xsd  
8.                http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-2.5.xsd">  
9.    <bean id="bean1" class="com.szy.spring.bean.Bean1">  
10.        <property name="bean2" ref="bean2"/>  
11.        <property name="bean3">  
12.            <ref bean="bean3"/>  
13.        </property>     
14.        <property name="bean4" ref="bean4"/>  
15.    </bean>  
16.      
17.    <bean id="bean2" class="com.szy.spring.bean.Bean2">  
18.        <property name="id" value="100"/>  
19.        <property name="name">  
20.            <value>kuka</value>  
21.        </property>  
22.        <property name="password" value="123"/>  
23.    </bean>  
24.      
25.    <bean id="bean3" class="com.szy.spring.bean.Bean3">  
26.        <property name="id" value="100"/>  
27.        <property name="name" value="kuka"/>  
28.    </bean>  
29.       
30.    <bean id="bean4" class="com.szy.spring.bean.Bean4">  
31.        <property name="age" value="22"/>  
32.    </bean>  
33.</beans>  
  
  
  
我们进行测试：
  
 
 
Java代码  
1.@Test 
2.    public void testMethod() throws Exception  
3.    {  
4.        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");  
5.        Bean1 bean1 = (Bean1)ctx.getBean("bean1");  
6.          
7.        System.out.println("bean1.bean2.id=" + bean1.getBean2().getId());  
8.        System.out.println("bean1.bean2.name=" + bean1.getBean2().getName());  
9.        System.out.println("bean1.bean2.password=" + bean1.getBean2().getPassword());  
10.        System.out.println("bean1.bean3.id=" + bean1.getBean3().getId());  
11.        System.out.println("bean1.bean3.name=" + bean1.getBean3().getName());  
12.        System.out.println("bean1.bean4.age=" + bean1.getBean4().getAge());  
13.    }  
  
  
  
正常输出我们所预期的信息，但是我们观察发现bean2和bean3的部分属性的配置信息是相同的，这仅是两个bean，如果是多个bean的话我们要修改就好修改多处，因此我们可以把这些公共的部分提出出来，进行抽象。这个在Spring中是支持的。我们在建立一个配置文件，命名为：applicationCommon.xml，其内容如下配置
  
 
 
Xml代码  
1.<?xml version="1.0" encoding="UTF-8"?>  
2.<beans xmlns="http://www.springframework.org/schema/beans" 
3.    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
4.    xmlns:context="http://www.springframework.org/schema/context" 
5.    xmlns:tx="http://www.springframework.org/schema/tx" 
6.    xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.5.xsd  
7.                http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-2.5.xsd  
8.                http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-2.5.xsd">  
9.     <bean id="beanAbstract" abstract="true">  
10.        <property name="id" value="100"/>  
11.        <property name="name" value="kuka"/>  
12.   </bean>           
13.     
14.   <bean id="bean2" class="com.szy.spring.bean.Bean2" parent="beanAbstract">  
15.            <property name="password" value="123"/>  
16.   </bean>          
17.     
18.   <bean id="bean3" class="com.szy.spring.bean.Bean3" parent="beanAbstract"/>  
19.      
20.</beans>  
  
 beanAbstract就是我们抽象出来的，设置abstract="true"属性后就不需要指定class属性。
  
我们把原来配置文件里的关于bean2和bean3节点注释掉。
  
下面进行测试，在这里要注意由于我们使用了两个配置文件，因此我们在读取是要写两个配置文件名。我们查看ClassPathXmlApplicationContext源文件发现其有个构造函数参数是string数组，因此我们可以把这个配置文件名放在数组里面。此外我们还有另外一种实现方法，两个配置文件一个叫applicationContext.xml，另一个applicationCommon.xml，公共部分是applicationC*.xml，下面我们就可以这样进行测试：
  
 
 
Java代码  
1.@Test 
2.    public void testMethod() throws Exception  
3.    {  
4.        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationC*.xml");  
5.        Bean1 bean1 = (Bean1)ctx.getBean("bean1");  
6.          
7.        System.out.println("bean1.bean2.id=" + bean1.getBean2().getId());  
8.        System.out.println("bean1.bean2.name=" + bean1.getBean2().getName());  
 
 
9.        System.out.println("bean1.bean2.password=" + bean1.getBean2().getPassword());  
10.        System.out.println("bean1.bean3.id=" + bean1.getBean3().getId());  
11.        System.out.println("bean1.bean3.name=" + bean1.getBean3().getName());  
12.        System.out.println("bean1.bean4.age=" + bean1.getBean4().getAge());  
13.    }  
  
  
  
如果我们bean2的name属性的值不是kuka，那么我们只需在applicationCommon.xml文件的bean2节点下再添加property属性即可
  
 
 
Xml代码  
1.<property name="name" value="coolszy"/>  
 
 
 
 
 
 
 
 
 
 
 
 
Spring学习笔记（11）----自定义属性编辑器
-------------------------------------------
前面我们所定义的属性都是几本的属性，如果我们定义一个属性是Date类型，例如如下类中：
  
 
 
Java代码  
1.package com.szy.spring.bean;  
2.  
3.import java.util.Date;  
4.  
5.public class Bean {  
6.    private Date date;  
7.  
8.    public Date getDate()  
9.    {  
10.        return date;  
11.    }  
12.    public void setDate(Date date)  
13.    {  
14.        this.date = date;  
15.    }  
16.}  
  
 按照我们以前学过的知识我们需要在配置文件中给该属性注入值
  
 
 
Xml代码  
1.<bean id="bean" class="com.szy.spring.bean.Bean">  
2.        <property name="date" value="2009-11-21"/>  
3.    </bean>  
  
 下面我们测试是否成功注入值
  
 
 
Java代码  
1.ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");  
2.        Bean bean = (Bean)ctx.getBean("bean");  
3.        System.out.println(bean.getDate());  
  
 运行包如下异常
  
 
 
Exception代码  
1.org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'bean' defined in class path resource [applicationContext.xml]: Initialization of bean failed; nested exception is org.springframework.beans.TypeMismatchException: Failed to convert property value of type [java.lang.String] to required type [java.util.Date] for property 'date'; nested exception is java.lang.IllegalArgumentException: Cannot convert value of type [java.lang.String] to required type [java.util.Date] for property 'date': no matching editors or conversion strategy found  
  
 通过错误提示信息我们得知spring不能将string转换成date类型，没有匹配的编辑器或者转换机制。
如果想实现string转换成Date，那么我们自己需要写一个属性编辑器
  
我们新建一个类DatePropertyEditor，这个类要继承PropertyEditorSupport类。
我们需要复写这个类中的setAsText方法，其中text参数就是配置文件中的值。我们的任务就是把text转换成date类型的值。
  
 
 
Java代码  
1.package com.szy.spring.util;  
2.  
3.import java.beans.PropertyEditorSupport;  
4.import java.text.SimpleDateFormat;  
5.import java.util.Date;  
6.  
7.public class DatePropertyEditor extends PropertyEditorSupport  
8.{  
9.  
10.    @Override 
11.    public void setAsText(String text) throws IllegalArgumentException  
12.    {  
13.        String format="yyyy-MM-dd";  
14.        SimpleDateFormat sdf=new SimpleDateFormat(format);  
15.        try 
16.        {  
17.            Date date=sdf.parse(text);  
18.            this.setValue(date);  //把转换后的值传过去  
19.        } catch (Exception e)  
20.        {  
21.            e.printStackTrace();  
22.        }  
23.    }  
24.  
25.}  
  
写完编辑器后我们还需要把编辑器注入到spring中。 为了方便管理我们再新建一个配置文件applicationEditor.xml，用来配置属性编辑器
  
 
 
Xml代码  
1.<?xml version="1.0" encoding="UTF-8"?>  
2.<beans xmlns="http://www.springframework.org/schema/beans" 
3.    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
4.    xmlns:context="http://www.springframework.org/schema/context" 
5.    xmlns:tx="http://www.springframework.org/schema/tx" 
6.    xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.5.xsd  
7.                http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-2.5.xsd  
8.                http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-2.5.xsd">  
9.    <bean id="customEditorConfigurer" class="org.springframework.beans.factory.config.CustomEditorConfigurer">  
10.        <!-- 把值注入到CustomEditorConfigurer的 Map类型的customEditors属性-->  
11.        <property name="customEditors">  
12.            <map>  
13.                <entry key="java.util.Date">  
14.                    <!-- 内部bean只供自己使用 -->  
15.                    <bean class="com.szy.spring.util.DatePropertyEditor"/>  
16.                </entry>  
17.            </map>  
18.        </property>  
19.    </bean>  
20.      
21.</beans>  
  
  
  
下面我们修改下测试代码已读取所有的配置文件
  
 
 
Java代码  
1.ApplicationContext ctx=new ClassPathXmlApplicationContext("application*.xml");  
2.        Bean bean = (Bean)ctx.getBean("bean");  
3.        System.out.println(bean.getDate());  
  
  
  
最后测试，成功输出时间。
  
刚才我们在配置文件中时间的格式是2009-11-21，如果我们修改成2009/11/21呢？
  
运行报错:Unparseable date: "2009/11/21"
  
这时我们需要修改属性编辑器类文件的格式了，很麻烦。既然spring支持注入，那么我们为什么不对格式进行注入呢？
  
修改属性编辑器类：
  
 
 
Java代码  
1.package com.szy.spring.util;  
2.  
3.import java.beans.PropertyEditorSupport;  
4.import java.text.SimpleDateFormat;  
5.import java.util.Date;  
6.  
7.public class DatePropertyEditor extends PropertyEditorSupport  
8.{  
9.  
10.    private String format;  
11.    @Override 
12.    public void setAsText(String text) throws IllegalArgumentException  
13.    {  
14.          
15.        SimpleDateFormat sdf=new SimpleDateFormat(format);  
16.        try 
17.        {  
18.            Date date=sdf.parse(text);  
19.            this.setValue(date);  //把转换后的值传过去  
20.        } catch (Exception e)  
21.        {  
22.            e.printStackTrace();  
23.        }  
24.    }  
25.    public String getFormat()  
26.    {  
27.        return format;  
28.    }  
29.    public void setFormat(String format)  
30.    {  
31.        this.format = format;  
32.    }  
33.}  
  
  
  
同时给该类对应的bean添加属性节点
  
 
 
Xml代码  
1.<bean class="com.szy.spring.util.DatePropertyEditor">  
2.                        <property name="format" value="yyyy/MM/dd"></property>  
3.                    </bean>  
  
  
  
下次只要我们修改配置文件即可，灵活性很大。
 
 
 
 
 
 
 
 
Spring学习笔记（12）----静态代理模式分析演示
--------------------------------------------
代理模式分为静态代理和动态代理。静态代理就是我们自己定义的代理类，动态代理是程序在运行时生成的代理类。
  
下面演示下静态代理类。首先我们要定义一个接口：
  
 
 
Java代码  
1.package com.szy.spring;  
2.  
3.public interface UserManager  
4.{  
5.    public void addUser(String username,String password);  
6.    public void deleteUser(int userId);  
7.    public void modifyUser(int userId,String username,String password);  
8.    public void findUser(int userId);  
9.}  
  
 比较常见的对用户进行增删改查。
  
下面我们常见一个实现类，实现这个接口。
  
 
 
Java代码  
1.package com.szy.spring;  
2.  
3.public class UserManagerImpl implements UserManager  
4.{  
5.  
6.    public void addUser(String username, String password)  
7.    {  
8.        System.out.println("--------UserManagerImpl.addUser()----------");  
9.    }  
10.  
11.    public void deleteUser(int userId)  
12.    {  
13.        System.out.println("--------UserManagerImpl.deleteUser()----------");  
14.    }  
15.  
16.    public void findUser(int userId)  
17.    {  
18.        System.out.println("--------UserManagerImpl.findUser()----------");  
19.    }  
20.  
21.    public void modifyUser(int userId, String username, String password)  
22.    {  
23.        System.out.println("--------UserManagerImpl.modifyUser()----------");  
24.    }  
25.}  
  
  
  
每个方法仅仅是输出一句话。
  
下面我们定义一个客户端类来调用这些方法。
  
 
 
Java代码  
1.package com.szy.spring;  
2.  
3.public class Client  
4.{  
5.    public static void main(String[] args)  
6.    {  
7.        UserManager userManager=new UserManagerImpl();  
8.        userManager.addUser("coolszy", "kuka");  
9.    }  
10.}  
  
  
  
运行正常输出我们期望的结果。
  
下面我们需要加入安全性检查，就是调用方法前我们需要进行验证，比较常见的就是权限验证，验证用户是否拥有权限，
  
比较常见的做法就是在UserManagerImpl类中定义一个检查安全性的方法：
  
 
 
Java代码  
1.public void checkSecurity()  
2.    {  
3.        System.out.println("--------UserManagerImpl.checkSecurity()----------");  
4.    }  
  
 然后在每个方法中都要调用这个方法。但是这样不符合开-闭原则（Open-Closed principle,简称OCP）。因此我们可以使用代理类来实现这个功能。代理模式很显著的特征就是和目标对象的接口一致。在代理类中我们可以控制目标对象。要控制目标对象我们必须有一个目标对象的引用。为了灵活我们可以把目标对象传到方法中，而不是在方法中实例化。同时我们把安全性检查的代码也放到代理类中，在调用每个方法之前调用这个检查方法，通过代理对我们以前的类没有破坏。
  
 
 
Java代码  
1.package com.szy.spring;  
2.  
3.public class UserManagerImplProxy implements UserManager  
4.{  
5.    private UserManager userManager;  
6.      
7.    public UserManagerImplProxy(UserManager userManager)  
8.    {  
9.        this.userManager = userManager;  
10.    }  
11.    public void addUser(String username, String password)  
12.    {  
13.        checkSecurity();  
14.        this.userManager.addUser(username, password);  
15.    }  
16.    public void deleteUser(int userId)  
17.    {  
18.        checkSecurity();  
19.        this.userManager.deleteUser(userId);  
20.    }  
21.    public String findUser(int userId)  
22.    {  
23.        checkSecurity();  
24.        return this.userManager.findUser(userId);  
25.    }  
26.    public void modifyUser(int userId, String username, String password)  
27.    {  
28.        checkSecurity();  
29.        this.userManager.modifyUser(userId, username, password);  
30.    }  
31.    public void checkSecurity()  
32.    {  
33.        System.out.println("--------UserManagerImpl.checkSecurity()----------");  
34.    }  
35.}  
  
  
  
下面修改客户端类。
  
 
 
Java代码  
1.UserManager userManager=new UserManagerImplProxy(new UserManagerImpl());  
2.        userManager.addUser("coolszy", "kuka");  
  
  
  
这样总的来说比较灵活。这个依赖关系是我们自己做的，我们完全可以交给spring处理。
  
按照上面的这种做法有一个缺点，如果接口中方法很多，那么我们实现每一个方法都要添加检查方法checkSecurity()，影响了我们的业务处理。采用静态代理模式我们是没法解决的，这时我们需要使用AOP思想。
  
  
 
 
 
 
Spring学习笔记（13）----动态代理模式分析演示
-----------------------------------------------
上一节演示的是静态代理模式，本节演示的是静态代理模式，既然是动态，那么就不存在UserManagerImplProxy类。
  
使用动态代理我们需要声明一个类SecurityHandler，这个类要实现InvocationHandler接口。
  
在类中定义一个产生动态代理的方法newProxy();同时把我们验证的代码放到这个类中。通过SecurityHandler，当我们调用方法时默认会调用SecurityHandler类invoke方法，我们在这个方法中进行安全性检查，检查通过后在调用真实的方法。需要注意的是目标对象接口中的部分方法是存在返回值的。
  
 
 
Java代码  
1.package com.szy.spring;  
2.  
3.import java.lang.reflect.InvocationHandler;  
4.import java.lang.reflect.Method;  
5.import java.lang.reflect.Proxy;  
6.  
7.public class SecurityHandler implements InvocationHandler  
8.{  
9.    private Object targetObject;  
10.      
11.    public Object newProxy(Object targetObject)  
12.    {  
13.        this.targetObject=targetObject;  
14.        //返回动态代理  
15.        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),  
16.                                      targetObject.getClass().getInterfaces(),  
17.                                      this);  
18.    }  
19.    public Object invoke(Object proxy, Method method, Object[] args)  
20.            throws Throwable  
21.    {  
22.        checkSecurity();  
23.        Object ret=null;  
24.        try 
25.        {  
26.            //调用目标对象的真实方法  
27.            ret=method.invoke(this.targetObject, args);  
28.            //ret接受存在的返回值，不存在返回值则为Null  
29.        } catch (Exception e)  
30.        {  
31.            e.printStackTrace();  
32.        }  
33.        return null;  
34.    }  
35.    public void checkSecurity()  
36.    {  
37.        System.out.println("--------UserManagerImpl.checkSecurity()----------");  
38.    }  
39.}  
  
  
  
使用这种方式维护起来相对比较好，我想进行安全性检查就进行，不想就不进行，很方便。
  
下面进行客户端调用
  
 
 
Java代码  
1.package com.szy.spring;  
2.  
3.public class Client  
4.{  
5.    public static void main(String[] args)  
6.    {  
7.        SecurityHandler handler=new SecurityHandler();  
8.        //创建代理对象  
9.        UserManager userManager=(UserManager)handler.newProxy(new UserManagerImpl());  
10.        userManager.addUser("coolszy", "kuka");  
11.    }  
12.}  
 
 
 
 
 
Spring学习笔记（14）----使用CGLIB实现AOP功能
-----------------------------------------------
 
接着这上面的例子，在上面的例子中我们的UserManagerImpl类是实现了UserManager接口，如果UserManagerImpl没有实现任何接口要怎么办呢？应为创建代理对象时我们需要指定接口的。
  
 
 
Java代码  
1.Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),  
2.                                      targetObject.getClass().getInterfaces(),  
3.                                      this);  
  
  
  
由于没有时间接口，因此我们是不能这样创建代理接口的，这是我们需要借助第三方包来实现。在spring中提供了cglib-nodep-2.1_3.jar包。我们通过cglib创建代理对象。
  
下面就通过实例演示通过cglib创建代理对象。
  
  
  
首先创建CGlibProxyFactory，实现MethodInterceptor接口，接口中有一个intercept方法，当代理对象的方法被调用时会调用这个方法。
  
 
 
Java代码  
1.package com.szy.spring;  
2.  
3.import java.lang.reflect.Method;  
4.import net.sf.cglib.proxy.Enhancer;  
5.import net.sf.cglib.proxy.MethodInterceptor;  
6.import net.sf.cglib.proxy.MethodProxy;  
7.  
8.  
9.public class CGlibProxyFactory implements MethodInterceptor  
10.{  
11.    private Object targetObject;  
12.      
13.    public Object newProxy(Object targetObject)  
14.    {  
15.        this.targetObject=targetObject;  
16.        Enhancer enhancer=new Enhancer();  
17.        enhancer.setSuperclass(this.targetObject.getClass());  
18.        enhancer.setCallback(this);  
19.        //返回代理对象  
20.        return enhancer.create();  
21.    }  
22.  
23.    /** 
24.     * proxy        带来对象本身 
25.     * method       被拦截到的方法 
26.     * args          方法的参数 
27.     * methodProxy  方法的代理对象 
28.     */ 
29.    public Object intercept(Object proxy, Method method, Object[] args,  
30.            MethodProxy methodProxy) throws Throwable  
31.    {  
32.        checkSecurity();  
33.        Object ret=null;  
34.        try 
35.        {  
36.            //调用目标对象的真实方法  
37.            ret=method.invoke(this.targetObject, args);  
38.            //ret接受存在的返回值，不存在返回值则为Null  
39.        } catch (Exception e)  
40.        {  
41.            e.printStackTrace();  
42.        }  
43.        return ret;  
44.    }  
45.    public void checkSecurity()  
46.    {  
47.        System.out.println("--------UserManagerImpl.checkSecurity()----------");  
48.    }  
49.}  
  
  
  
其实整个代码很前面的很相似，只是创建代理对象的方法不一样。
  
测试代码：
  
 
 
Java代码  
1.CGlibProxyFactory factory=new CGlibProxyFactory();  
2.        //创建代理对象，这是这个代理对象是UserManagerImpl的子类  
3.        UserManagerImpl userManager=(UserManagerImpl)factory.newProxy(new UserManagerImpl());  
4.        userManager.addUser("coolszy", "kuka");  
  
  
  
上面演示的几个事例是不借助与任何框架的情况下实现AOP的方法。 
 
 
 
 
 
 
 
Spring学习笔记（15）----使用Spring的注解方式实现AOP
-----------------------------------------------------
下面介绍使用Spring框架进行AOP编程。
  
首先我们需要导入需要的jar包:
  
1.aspectjrt.jar
  
2.aspectjweaver.jar
  
3.cglib-nodep-2.1_3.jar
  
  
  
在spring中有两种方式实现面向切面编程，一种是基于XML配置，另一种是使用注解份额方式，在实际开放中我们可以任选其中的一种即可。
  
  
  
首先介绍下使用注解方式进行AOP开发。
  
要使用注解方式，我们需要打开注解处理器
  
 
 
Xml代码  
1.<aop:aspectj-autoproxy/>  
  
我们还是使用前面介绍的接口：
  
  
  
 
 
Java代码  
1.package com.szy.spring;  
2.  
3.public interface UserManager  
4.{  
5.  
6.    public abstract void addUser(String username, String password);  
7.  
8.    public abstract void deleteUser(int userId);  
9.  
10.    public abstract String findUser(int userId);  
11.  
12.    public abstract void modifyUser(int userId, String username, String password);  
13.  
14.}  
  
  
  
实现这个接口:
  
 
 
Java代码  
1.package com.szy.spring;  
2.  
3.public class UserManagerImpl implements UserManager   
4.{  
5.  
6.    public void addUser(String username, String password)  
7.    {  
8.        System.out.println("--------UserManagerImpl.addUser()----------");  
9.    }  
10.  
11.    public void deleteUser(int userId)  
12.    {  
13.        System.out.println("--------UserManagerImpl.deleteUser()----------");  
14.    }  
15.  
16.    public String findUser(int userId)  
17.    {  
18.        System.out.println("--------UserManagerImpl.findUser()----------");  
19.        return null;  
20.    }  
21.  
22.    public void modifyUser(int userId, String username, String password)  
23.    {  
24.        System.out.println("--------UserManagerImpl.modifyUser()----------");  
25.    }  
26.}  
  
  
  
下面我们定义一个切面类，由于我们使用的是注解方式，因此我们使用@Aspect来标识它是切面类。在切面类中我们要定义切入点，切入点是用来定义我们要拦截的方法。在切入点定义中使用了AOP表达式语言，下面通过实例简单解释一下：
  
  
  
 
 
表达式解释代码  
1.@Pointcut("execution (* com.szy.spring..*.*(..))")  
2.execution:代表执行  
3.第一个*:代表返回值类型，使用*代表任何类型的返回值  
4.com.szy.spring:代表包名  
5...:代表其底下的子包也进行拦截  
6.第二个*:代表对哪个类进行拦截，*代表所有类  
7.第三个*:代表方法  
8.(..):代表方法的蚕食有无都可以  
  
  
  
现在我们要对UserManagerImpl类下的所有方法进行拦截，则切入点如下表示：
  
 
 
Java代码  
1.@Pointcut("execution (* com.szy.spring.UserManagerImpl.*(..))")  
2.  
3.private void anyMethod()  //定义切入点  
4. {  
5. }  
  
  
  
其中切入点的名称是下面方法的名称aynMethod()，包括括号。
  
  
  
下面我们定义通知，通知分为前置通知、后置通知、意外通知、等。通知分为前置通知、后置通知、意外通知、最终通知和环绕通知等。
  
演示前置通知，
  
 
 
Java代码  
1.@Before("anyMethod()") //括号内为切入点名称  
2.  public void doBefore()  
3.  {  
4.   System.out.println("----------------执行前置通知-----------------");  
5.  }  
6.   
7.  @AfterReturning("anyMethod()")  
8.  public void doAfterReturning()  
9.  {  
10.   System.out.println("----------------执行后置通知-----------------");  
11.  }  
  
 
 
Java代码  
1. @After("anyMethod()")  
2. public void doAfter()  
3. {  
4.  System.out.println("----------------执行最终通知-----------------");  
5. }  
6.   
7.  @AfterThrowing("anyMethod()")  
8.  public void doAfterThrowing()  
9.  {  
10.   System.out.println("----------------执行意外通知-----------------");  
11.  }  
12.    
13. @Around("anyMethod()")  
14. public Object doAround(ProceedingJoinPoint pjp) throws Throwable  
15. {  
16.  System.out.println("----------------进入判断方法-----------------");  
17.  Object result=pjp.proceed();  //该方法必须被执行  
18.  System.out.println("----------------退出判断方法-----------------");  
19.  return result;  
20. }  
  
  
  
 我们把切面交给spring管理，要交给spring管理我们可以在配置文件同进行bean配置，或者使用扫描的方式。
  
 
 
Xml代码  
1.<bean id="interceptor" class="com.szy.spring.Interceptor"/>  
  
 下面我们进行测试
  
 
 
Java代码  
1.ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");  
2.        UserManager manager=(UserManager)context.getBean("userManager");  
3.        manager.addUser("coolszy", "kuka");  
  
  
  
按照我们的设计，输入的结果应为
  
----------------执行前置通知-----------------
----------------进入判断方法-----------------
--------UserManagerImpl.addUser()----------
----------------执行后置通知-----------------
----------------执行最终通知-----------------
----------------退出判断方法-----------------
 
 
 
 
 
 
Spring学习笔记(16)----使用Spring配置文件实现AOP
----------------------------------------------
 
前面介绍了使用注解的方式，下面介绍使用配置文件的方式实现AOP。
  
使用配置方式，Interceptor类中不包含任何注解。
  
 
 
Java代码  
1.package com.szy.spring;  
2.  
3.import org.aspectj.lang.ProceedingJoinPoint;  
4.  
5.public class Interceptor  
6.{  
7.    public void doBefore()  
8.    {  
9.        System.out.println("----------------执行前置通知-----------------");  
10.    }  
11.      
12.    public void doAfterReturning()  
13.    {  
14.        System.out.println("----------------执行后置通知-----------------");  
15.    }  
16.      
17.    public void doAfter()  
18.    {  
19.        System.out.println("----------------执行最终通知-----------------");  
20.    }  
21.      
22.    public void doAfterThrowing()  
23.    {  
24.        System.out.println("----------------执行意外通知-----------------");  
25.    }  
26.      
27.    public Object doAround(ProceedingJoinPoint pjp) throws Throwable  
28.    {  
29.        System.out.println("----------------进入判断方法-----------------");  
30.        Object result=pjp.proceed();  //该方法必须被执行  
31.        System.out.println("----------------退出判断方法-----------------");  
32.        return result;  
33.    }  
34.}  
  
 紧着这我们在配置文件中配置切面、切入点、通知等：
  
 
 
Xml代码  
1.<bean id="aspetbean" class="com.szy.spring.Interceptor"/>  
2.    <aop:config>  
3.        <aop:aspect id="aspet" ref="aspetbean">  
4.            <aop:pointcut id="cut" expression="execution (* com.szy.spring.UserManagerImpl.*(..))"/>  
5.            <aop:before pointcut-ref="cut" method="doBefore"/>  
6.            <aop:after-returning pointcut-ref="cut" method="doAfterReturning"/>  
7.            <aop:after pointcut-ref="cut" method="doAfter"/>  
8.            <aop:after-throwing pointcut-ref="cut" method="doAfterThrowing"/>  
9.            <aop:around pointcut-ref="cut" method="doAround"/>  
10.        </aop:aspect>  
11.    </aop:config>  
  
 运行测试代码输入正常结果。
  
在实际开发中AOP一般用于权限设置等。
  
  
 
 
 
 
Spring学习笔记(17)----使用Spring注解方式管理事务
--------------------------------------------------
使用Spring+JDBC集成步骤如下：
  
 *配置数据源，例如：
  
 
 
Xml代码  
1.<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">  
2.            <property name="driverClassName" value="com.mysql.jdbc.Driver"/>  
3.            <property name="url" value="jdbc:mysql://localhost:3306/test"/>  
4.            <property name="username" value="root"/>  
5.            <property name="password" value="123456"/>  
6.            <!-- 连接池启动时的初始值 -->  
7.            <property name="initialSize" value="1"/>  
8.            <!-- 连接池的最大值 -->  
9.            <property name="maxActive" value="100"/>  
10.            <!-- 最大空闲值.当经过一个高峰时间后，连接池可以慢慢将已经用不到的连接慢慢释放一部分，一直减少到maxIdle为止 -->  
11.            <property name="maxIdle" value="2"/>  
12.            <!--  最小空闲值.当空闲的连接数少于阀值时，连接池就会预申请去一些连接，以免洪峰来时来不及申请 -->  
13.            <property name="minIdle" value="1"/>  
14.        </bean>  
  
 *配置事务，配置事务时，需要在xml配置文件中引入用于声明事务的tx命名空间，事务的配置有两种方式：注解方式和基于XML配置的方式
  
  
  
下面演示下使用Spring注解方式管理事务
  
首先在配置文件中配置Spring提供的事务管理器
  
 
 
Xml代码  
1.<bean id="txManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">  
2.            <!-- 指定数据源 -->  
3.            <property name="dataSource" ref="dataSource"/>  
4.        </bean>  
  
 由于会使用注解方式，因此我们要打开注解处理器，对注解进行解析
  
 
 
Xml代码  
1.<tx:annotation-driven transaction-manager="txManager"/>  
  
  
  
这样我们的配置文件配置完成，下面我们在Mysql中建立一张表，
  
 
 
Sql代码  
1.create table users  
2.(                     
3. id int(11) not null auto_increment,    
4. username varchar(20) not null,         
5. primary key (id)                     
6.)   
  
  
  
根据数据库，我们创建javabean
  
 
 
Java代码  
1.package com.szy.spring.bean;  
2./** 
3. * @author  coolszy 
4. * @time    Dec 6, 2009 2:13:33 PM 
5. */ 
6.public class User  
7.{  
8.    private int id;  
9.    private String username;  
10.    public int getId()  
11.    {  
12.        return id;  
13.    }  
14.    public void setId(int id)  
15.    {  
16.        this.id = id;  
17.    }  
18.    public String getUsername()  
19.    {  
20.        return username;  
21.    }  
22.    public void setUsername(String username)  
23.    {  
24.        this.username = username;  
25.    }  
26.}     
  
  
  
然后创建DAO接口，在DAO中提供几个方法：
  
 
 
Java代码  
1.package com.szy.spring.dao;  
2.  
3.import java.util.List;  
4.  
5.import com.szy.spring.bean.User;  
6.  
7.public interface UserDAO  
8.{  
9.    public void save(User user);  
10.    public void update(User user);  
11.    Public User  getUser(int id);  
12.    public void delete(int id);  
13.    public List<User> getAllUsers();  
14.}     
  
  
  
实现这个接口
  
  
  
 
 
Java代码  
1.package com.szy.spring.dao.impl;  
2.  
3.import java.util.List;  
4.  
5.import com.szy.spring.bean.User;  
6.import com.szy.spring.service.UserService;  
7.  
8./** 
9. * @author  coolszy 
10. * @time    Dec 6, 2009 2:19:22 PM 
11. */ 
12.public class UserDAOImpl implements UserDAO  
13.{  
14.  
15.    public void delete(int id)  
16.    {  
17.  
18.    }  
19.  
20.    public List<User> getAllUsers()  
21.    {  
22.        return null;  
23.    }  
24.  
25.    public User getUser(int id)  
26.    {  
27.  
28.    }  
29.  
30.    public void save(User user)  
31.    {  
32.  
33.    }  
34.  
35.    public void update(User user)  
36.    {  
37.  
38.    }  
39.  
40.}     
  
  
  
下面把这个类交给Spring管理
  
 
 
Xml代码  
1.<bean id="userDAO" class="com.szy.spring.dao.impl.UserDAOImpl"/>    
  
 由于要通过数据源对表进行操作，因此在DAO中添加数据源。
  
 
 
Java代码  
1.private DataSource dataSource;  
2.  
3.    public void setDataSource(DataSource dataSource)  
4.    {  
5.        this.dataSource = dataSource;  
6.    }     
  
  
  
然后在配置文件中进行配置
  
 
 
Xml代码  
1.<bean id="userDAO" class="com.szy.spring.service.impl.UserDAOImpl">  
2.            <property name="dataSource" ref="dataSource"/>  
3.        </bean>     
  
  
  
这样我们就把数据源注入到类中。
  
在UserDAOImpl类中我们提供了dataSource，这样我们就可以对数据库进行操作，但是不推荐直接使用dataSource，建议使用JdbcTemplate
  
 
 
Java代码  
1.private JdbcTemplate jdbcTemplate;  
2.    public void setDataSource(DataSource dataSource)  
3.    {  
4.        //this.dataSource = dataSource;  
5.        this.jdbcTemplate=new JdbcTemplate(dataSource);  
6.    }     
  
 下面我们使用jdbcTemplate对数据库进行增删改查，详细代码见附件。
  
 
 
Java代码  
1.package com.szy.spring.dao.impl;  
2.  
3.import java.util.List;  
4.  
5.import javax.sql.DataSource;  
6.  
7.import org.springframework.jdbc.core.JdbcTemplate;  
8.  
9.import com.szy.spring.bean.User;  
10.import com.szy.spring.dao.UserDAO;  
11.  
12./** 
13. * @author  coolszy 
14. * @time    Dec 6, 2009 2:19:22 PM 
15. */ 
16.public class UserDAOImpl implements UserDAO  
17.{  
18.    //private DataSource dataSource;  
19.    private JdbcTemplate jdbcTemplate;  
20.    public void setDataSource(DataSource dataSource)  
21.    {  
22.        //this.dataSource = dataSource;  
23.        this.jdbcTemplate=new JdbcTemplate(dataSource);  
24.    }  
25.  
26.    public void delete(int id)  
27.    {  
28.        jdbcTemplate.update("delete from users where id=?", new Object[]{id},  
29.                new int[]{java.sql.Types.INTEGER});  
30.    }  
31.  
32.    public List<User> getAllUsers()  
33.    {  
34.        return (List<User>)jdbcTemplate.query("select * from users", new UserRowMapper());  
35.    }  
36.  
37.    public User getUser(int id)  
38.    {  
39.        return (User)jdbcTemplate.queryForObject("select * from users where id=?", new Object[]{id},   
40.                new int[]{java.sql.Types.INTEGER}, new UserRowMapper());  
41.  
42.    }  
43.  
44.    public void save(User user)  
45.    {   
46.        jdbcTemplate.update("insert into users(username) values(?)", new Object[]{user.getUsername()},  
47.                new int[]{java.sql.Types.VARCHAR});  
48.  
49.    }  
50.  
51.    public void update(User user)  
52.    {  
53.        jdbcTemplate.update("update users set username=? where id=?", new Object[]{user.getUsername(),user.getId()},  
54.                new int[]{java.sql.Types.VARCHAR, java.sql.Types.INTEGER});  
55.  
56.    }  
57.  
58.}     
  
 编写测试代码，代码运行正常。
  
在我们实现的每个方法中如delete()方法，如果delete方法是这样
  
 
 
Java代码  
1.public void delete(int id)  
2.    {  
3.        jdbcTemplate.update("delete from users where id=?", new Object[]{id},  
4.                new int[]{java.sql.Types.INTEGER});  
5.jdbcTemplate.update("delete from users where id=?", new Object[]{id},  
6.                new int[]{java.sql.Types.INTEGER});  
7.  
8.    }  
9.      
  
 这样每条语句都会在各自的事务中执行，并不能保证在同一使用中执行，为了保证在同一事务中执行，我们应使用Spring容器提供的声明事务，我们在UserDAOImpl 类上加入@Transactional，表示该类受Spring事务管理。如果该类中每个方法不需要事务管理，如getUser方法，则在该方法前加入
  
 
 
Java代码  
1.@Transactional(propagation=Propagation.NOT_SUPPORTED)  
  
  
  
  
  
PS：在上面的配置文件中我们在配置文件中指明了驱动类等信息，如果我们想写在配置文件中要怎么配置能，首先我们编写配置文件，
  
 
 
Jdbc.properties代码  
1.driverClassName=com.mysql.jdbc.Driver  
2.url=jdbc\:mysql\://localhost\:3306/test  
3.username=root  
4.password=123456 
5.initialSize=1 
6.maxActive=100 
7.maxIdle=2 
8.minIdle=1    
  
 然后Spring的配置文件需进行如下配置：
  
 
 
Xml代码  
1.<context:property-placeholder location="classpath:jdbc.properties"/>  
2.        <bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">  
3.            <property name="driverClassName" value="${driverClassName}"/>  
4.            <property name="url" value="${url}"/>  
5.            <property name="username" value="${username}"/>  
6.            <property name="password" value="${password}"/>  
7.            <property name="initialSize" value="${initialSize}"/>  
8.            <property name="maxActive" value="${maxActive}"/>  
9.            <property name="maxIdle" value="${maxIdle}"/>  
10.            <property name="minIdle" value="${minIdle}"/>  
11.        </bean>     
  
  这样就可以从属性文件中读取到配置信息。
  
  
 
 
 
 
 
Spring学习笔记(18)----使用Spring配置文件实现事务管理
-------------------------------------------------------
由于我们要拦截UserDAOImpl中的方法，因此我们需要在配置文件中配置信息，在配置文件中使用了AOP技术来拦截方法。
  
 
 
Xml代码  
1.<aop:config>  
2.    <aop:pointcut id="transactionPointcut" expression="execution(* com.szy.spring.dao.impl..*.*(..))"/>  
3.    <aop:advisor advice-ref="txAdvice" pointcut-ref="transactionPointcut"/>  
4.  </aop:config>   
5.  <tx:advice id="txAdvice" transaction-manager="txManager">  
6.     <tx:attributes>  
7.      <!-- 如果连接的方法是以get开头的方法，则不使用事务 -->  
8.       <tx:method name="get*" read-only="true" propagation="NOT_SUPPORTED"/>  
9.       <tx:method name="*"/>  
10.     </tx:attributes>  
11.  </tx:advice>  
  
   
  
这样Spring就能对这个类进行事务管理。
  
  
  
下面我们测试下数据库操作是否在同一事务中执行。
  
假设我们的delete方法如下：
  
 
 
Java代码  
1.public void delete(int id)  
2. {  
3.  jdbcTemplate.update("delete from users where id=?", new Object[]{id},  
4.    new int[]{java.sql.Types.INTEGER});  
5.  jdbcTemplate.update("delete from users1 where id=10");  
6. }  
  
  
  
  
  
在第二条删除语句中，users1表是不存在的，如果两次update语句是在两个事务中执行，则第一条能成功执行，并且数据库中该id的记录已经被删除，而第二条由于不存在该表不能正常删除。如果在同一事务中执行，由于第二条update出错，数据库中不能删除任何记录。
  
测试代码：
  
 
 
Java代码  
1.@Test 
2. public void testDelete()  
3. {  
4.  userDAO.delete(5);  
5. }  
  
  
 程序报错，同时id=5的记录没有被删除。如果我们把配置文件中关于事务配置的信息给注释掉，再次测试，程序同样报错，但是id=5的记录被成功删除掉，这说明这两条update语句是在两个不同的事务中运行。
  
  
  
PS：在平时开发中，Spring团队建议使用注解的方式进行配置，这样配置文件显得精简，同时也会做到精确控制。
