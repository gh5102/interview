1、Java 基础类型
基本类型    大小      最小值     最大值     包装器类型
boolean     -           -         -         Boolean
char        16-bit   Unicode0   Unicode 2^16-1  Character
byte        8-bit       -128    +127        Byte
short       16-bit      -2^15   +2^15-1     Short
int         32-bit      -2^31   +2^31-1     Integer
long        64-bit      -2^63   +2^63-1     Long
float       32-bit                          Float
double      64-bit                          Double
void        -
2、final的理解

3、Java三大特性
封装：封装就是把一个对象的属性私有化，同时提供一些可以被外界访问的属性的方法，
如果属性不想被外界访问，我们大可不必提供方法给外界访问。但是如果一个类没有提供
给外界访问的方法，那么这个类也就没有什么意义了。
继承：继承是使用已存在的类的定义作为基础建立的新类的技术，新类的定义可以增加新
的数据或新的功能，也可以用父类的功能，但不能选择性的继承父类。通过使用继承我们能
够非常方便的复用以前的代码。
ps：子类拥有父类的所有属性和方法（包含私有的），但无法访问私有的，只是拥有
多态：所谓多态就是程序中定义的引用变量所指向的具体类型和通过该引用变量发出的方法
调用在编程时并不确定，而是在程序运行期间才确定，即一个引用变量到底会指向哪个类的
实例对象，该引用变量发出的方法调用到底是哪个类中实现的方法，必须在由程序运行期间
才能决定。
4、对多态的理解

5、字符型常量和字符串常量的区别?

6、构造器是否可以override（重写）
Constructor不能被override（重写），但是可以overload（重载）

7、String StringBuffer和StringBuilder的区别是什么？String 为什么是不可变的？
可变性：
String类中使用final关键字修饰字符数组来保存字符串，private final char value[],
所以String对象是不可变的。
ps:Java9之后，String类的实现改用byte数组存储
String Builder和String Buffer都继承于Abstract String Builder类，在该类中字符数组
保存字符串 char[] value没有使用final关键字修饰，所以两种对象都是可变的。
线程安全性：
String中对象不可变，也可理解为常量，线程安全。
AbstractStringBuilder 定义了字符串基本操作append、insert、indexOf等。String Buffer对
方法进行了同步锁或者对调用的方法加了同步锁，是线程安全的。StringBuilder并没有对方法进行加
同步锁，是线程不安全的
性能：
String没改变一次，都会生成一个新的String对象，然后将指针指向新的String对象。
String Buffer每次都会对对象本身进行操作，而不是生成新的对象并改变对象引用。
相同情况下使用String Builder相比使用String Buffer仅获得10%-15%的性能提升，但却要冒
多线程不安全的风险
总结：
1、操作少量的数据：适用String
2、单线程操作字符串缓冲区下操作大量数据：适用StringBuilder
3、多线程操作字符串缓冲区下操作大量数据：适用String Buffer

8、自动装箱与拆箱
装箱：将基本类型用它们对应的引用类型包装起来
拆箱：将包装类型转换为基本数据类型

9、接口和抽象类的区别是什么？
：接口的方法默认是public，所有方法在接口中不能有实现（Java8可以默认实现），而抽象类可以
有非抽象的方法
：接口中除了static、final变量，不能有其他变量，而抽象类中则不一定。
：一个类可以实现多个接口，但是只能实现一个抽象类。接口自己本身可以通过extends关键字扩展
多个接口
：接口方法默认修饰符是public，抽象方法可以有public、protected和default这些修饰符（抽象
方法是为了被重新不能使用private关键字修饰）
：从设计层面来说，抽象是对类的抽象，是一种模板设计，而接口时对行为的抽象，是一种行为的规范

10、==和equals
==：它的作用是判断两个对象的地址是不是相等。即，判断两个对象是不是同一个对象（基本数据类型
==比较的是值、引用数据类型==比较的是内存地址）。
equals:它的作用也是判断两个对象是否相等。但它一般有两种使用情况：
情况1：类没有覆盖equal（）方法。则通过equals比较两个对象时，等价于通过“==”比较这两个对象。
情况2：类覆盖了equals方法。一般，我们都覆盖equal方法来比较两个对象的内容是否相等；若他们的
内容相等，则返回true
ps:String 的equals方法时重写过的

11、hashcode和equals

