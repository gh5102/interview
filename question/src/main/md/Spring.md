面试问题：
1、Spring是什么？
Spring是一个轻量级的IoC和AOP容器框架。是为Java应用程序提供基础性服务的一套框架，目的是用于简化企业应用程序的开发，
它使得开发者只需要关心业务需求。常见的配置方式有三种：基于XML的配置、基于注解的配置、基于Java的配置。
主要由以下几个模块组成：
Spring Core：核心类库，提供IOC服务；
Spring Context：提供框架式的Bean访问方式，以及企业级功能（JNDI、定时任务等）；
Spring AOP：AOP服务；
Spring DAO：对JDBC的抽象，简化了数据访问异常的处理；
Spring ORM：对现有的ORM框架的支持；
Spring Web：提供了基本的面向Web的综合特性，例如多方文件上传；
Spring MVC：提供面向Web应用的Model-View-Controller实现。
2、Spring 的优点？
（1）spring属于低侵入式设计，代码的污染极低；
（2）spring的DI机制将对象之间的依赖关系交由框架处理，减低组件的耦合性；
（3）Spring提供了AOP技术，支持将一些通用任务，如安全、事务、日志、权限等进行集中式管理，从而提供更好的复用。
（4）spring对于主流的应用框架提供了集成支持。
3、Spring的AOP理解：
OOP面向对象，允许开发者定义纵向的关系，但并适用于定义横向的关系，导致了大量代码的重复，而不利于各个模块的重用。
AOP，一般称为面向切面，作为面向对象的一种补充，用于将那些与业务无关，但却对多个对象产生影响的公共行为和逻辑，抽取并封装为一个可重用的模块，这个模块被命名为“切面”（Aspect），减少系统中的重复代码，降低了模块间的耦合度，同时提高了系统的可维护性。可用于权限认证、日志、事务处理。
AOP实现的关键在于 代理模式，AOP代理主要分为静态代理和动态代理。静态代理的代表为AspectJ；动态代理则以Spring AOP为代表。
（1）AspectJ是静态代理的增强，所谓静态代理，就是AOP框架会在编译阶段生成AOP代理类，因此也称为编译时增强，他会在编译阶段将AspectJ(切面)织入到Java字节码中，运行的时候就是增强之后的AOP对象。
（2）Spring AOP使用的动态代理，所谓的动态代理就是说AOP框架不会去修改字节码，而是每次运行时在内存中临时为方法生成一个AOP对象，这个AOP对象包含了目标对象的全部方法，并且在特定的切点做了增强处理，并回调原对象的方法。
Spring AOP中的动态代理主要有两种方式，JDK动态代理和CGLIB动态代理：
        ①JDK动态代理只提供接口的代理，不支持类的代理。核心InvocationHandler接口和Proxy类，InvocationHandler 通过invoke()方法反射来调用目标类中的代码，动态地将横切逻辑和业务编织在一起；接着，Proxy利用 InvocationHandler动态创建一个符合某一接口的的实例,  生成目标类的代理对象。
        ②如果代理类没有实现 InvocationHandler 接口，那么Spring AOP会选择使用CGLIB来动态代理目标类。CGLIB（Code Generation Library），是一个代码生成的类库，可以在运行时动态的生成指定类的一个子类对象，并覆盖其中特定方法并添加增强代码，从而实现AOP。CGLIB是通过继承的方式做的动态代理，
因此如果某个类被标记为final，那么它是无法使用CGLIB做动态代理的。
（3）静态代理与动态代理区别在于生成AOP代理对象的时机不同，相对来说AspectJ的静态代理方式具有更好的性能，但是AspectJ需要特定的编译器进行处理，而Spring AOP则无需特定的编译器处理。
 InvocationHandler 的 invoke(Object  proxy,Method  method,Object[] args)：proxy是最终生成的代理实例;  method 是被代理目标实例的某个具体方法;  args 是被代理目标实例某个方法的具体入参, 在方法反射调用时使用。
4、Spring的IoC理解：
（1）IOC就是控制反转，是指创建对象的控制权的转移，以前创建对象的主动权和时机是由自己把控的，而现在这种权力转移到Spring容器中，并由容器根据配置文件去创建实例和管理各个实例之间的依赖关系，对象与对象之间松散耦合，也利于功能的复用。DI依赖注入，
和控制反转是同一个概念的不同角度的描述，即 应用程序在运行时依赖IoC容器来动态注入对象需要的外部资源。
（2）最直观的表达就是，IOC让对象的创建不用去new了，可以由spring自动生产，使用java的反射机制，
根据配置文件在运行时动态的去创建对象以及管理对象，并调用对象的方法的。
（3）Spring的IOC有三种注入方式 ：构造器注入、setter方法注入、根据注解注入。
IoC让相互协作的组件保持松散的耦合，而AOP编程允许你把遍布于应用各层的功能分离出来形成可重用的功能组件。




--------------------------------
Spring
1、获取spring的IOC核心容器，并根据id获取对象
ApplicationContext：
    ClassPathXmlApplication:加载类路径下的配置文件，必须在类路径下
    FileSystemXmlApplicationContext:可以加载任意路径配置文件（必须有访问权限）
    AnnotationConfigApplicationContext:读取注解创建容器
核心容器的两个接口：
    ApplicationContext:
        创建对象采用饿汉模式，读取文件时直接创建
    BeanFactory:
        创建对象时采用懒汉模式，使用时加载
2、把对象的创建交给spring管理
    spring对bean的管理细节
    创建bean的三种方式
        ①使用默认构造函数创建
            在spring的配置文件中使用bean标签，配id和class属性
            采用默认构造函数创建bean对象
        ②使用普通工厂中的方法创建对象（使用某个类的方法创建并放入容器）
        ③使用静态工厂的静态方法创建对象（使用某个类中的静态方法创建对象）
    bean对象的作用范围
        bean标签的scope属性
            作用：指定bean的作用范围
            取值：single：单例（默认）
                  prototype:多例
                  request：作用于web应用的请求范围
                  session：作用于web的会话范围
                  global-session：作用于集群环境的会话范围（全局会话范围），不是集群时，=session
    bean对象的生命周期
        单例对象
            出生：当容器创建时对象创建
            活着：容器存在，一直存活
            死忙：容器销毁，对象消失
            总结：单例对象的生命周期和容器相等
        多例对象
            出生：当使用时创建
            活着：对象只要使用中一直存活
            死忙：当对象长时间不用，由Java垃圾回收器回收
3、spring的依赖注入
    依赖注入：
    IOC的作用：
        降低程序间的耦合（依赖关系）
    依赖关系的管理：
        交给spring来维护
    在当前需要其他类的对象，由spring为我们提供，只需在配置文件中说明
    依赖注入：
        能注入的数据：三类
            基本类型和String
            bean类型（在配置文件中或注释配置过的bean）
            复杂类型/集合类型
        注入方式：
            使用构造函数注入
            使用set方法注入
            使用注解注入  
4、注解
需配置包扫描：
    标签在context名称空间和约束中
spring
①用于创建对象的
    他们的作用等价于XML配置里的bean标签
    Component:Controller、Service、Repository
        作用：把当前类对象存入spring容器中
        属性：
            value:指定bean标签中id，不写时，默认是当前类名，首字母小写
②用于注入数据的
    等价于xml配置文件里bean标签下的property
    Autowired:
        作用：自动按照类型注入，只要容器中有唯一的一个bean对象类型和注入类型匹配
        如果ioc容器中无任何bean与该类型匹配，报错
        如果多个类型匹配时：
    出现位置：
        可以是变量上，也可以是方法上
    细节：
        在使用注解注入时，set方法就不是必须的了。
    Qualifier：
        作用：在按照类型注入的基础之上再按照名称注入。它在给类成员注入时不能单独使用。
              但是在给方法参数注入
        属性：
            value：用于指定bean的id
    Resource：
        作用：直接按照bean的id注入，它可以独立使用
        属性：
            name:用于指定bean的id
     以上三种只能注入其他bean类型的数据，基本类型和string类型无法使用以上注解
     ps:集合类型的注入只能通过xml来实现
     Value：
        作用：用于注入基本类型和String类型的数据
        属性：
            value：用于指定数据的值，它可以使用spring的SpELl（也就是spring的el表达式）
                SpEL的写法：${表达式}
③用于改变作用范围的
    等价与xml里bean标签中scope属性实现的功能是一样的
    Scope
        作用：指定bean的作用范围
        属性：
            value 常用 singleton prototype
④和生命周期相关
    他们的作用就是和bean标签的init-method和destroy-method的作用
    PreDestroy
        作用：指定销毁方法
    PostConstruct:
        作用：用于指定初始化方法
    ·       
              
⑤配置类
    @Configuration
        作用：指定当前类是一个配置类
        细节：当配置类作为AnnotationConfigApplicationContext时可以不写
    @Component Scans
        作用：用于通过注解指定要扫描的包
        属性：
            value：它和basePackage的作用一样，指定创建容器时要扫描的包0000
    @Bean
        作用：把当前方法的返回值作为bean对象放入spring的ioc容器中
        属性：
            name:用于指定bean的id。当不写时，默认是当前方法的名称
        细节：
            使用注解配置时，如果方法有参数，spring框架会去容器中查找有没有
            可用的bean对象，查找方式等价于auto wired注解的查找
    @Import
        作用：用于导入其他的配置类
        属性：
            value：用于指定其他配置类的字节码
                   使用import注解，有import注解类为父配置类，导入的为子配置类           
    @PropertySource
        作用：用于指定properties文件的路径
        属性
            value：指定文件的名称和路径
                classpath:类路径
                
5、spring整合junit
使用junit单元测试，测试配置
Spring整合junit的配置
    1、导入spring整合junit的jar
    2、使用Junit提供的一个注解   把原来的main方法替换了，替换成spring提供的
        @RunWith
    3、告知spring的运行器，spring和ioc创建是基于xml还是基于注解的，并且说明位置
        @ContextConfiguration
            location:指定xml文件所在的位置，加上classpath关键字，表示在类路径下
            classes：指定注解类所在的位置
6、spring事务
7、spring动态代理
动态代理：
    特点：字节码随用随创建，随用随加载
    作用：不修改源码的基础上对方法增强
    分类：
        基于接口的动态代理
        基于子类的动态代理
    基于接口的动态代理：
        涉及的类：Proxy
        提供者：JDK官网
    如何创建代理对象：
        使用Proxy类中的newProxyInstance方法
    创建代理对象的要求：
        被代理类至少实现一个接口，如果没有不能用
    newProxyInstance方法的参数：
        Class Loader：类加载器
            它是用于加载代理对象字节码的。和被代理对象使用相同的加载器。固定写法
        Class[]:字节码数组
            她是用于让动态代理对象和被代理对象有相同方法。固定写法
        InvocationHandler:用于提供增强的代码
            它让我们如何写代理。我们一般都是写一个该接口的实现类。通常情况下都是匿名内部类，
            但不是必须的。此接口的实现类都是谁用谁写
    