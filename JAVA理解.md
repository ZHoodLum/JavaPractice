#### 此处的部分资源来源于各个网站的博客，加上了一些自己的理解，希望一起交流！

[盐 ](#盐 )

[JVM内存溢出、垃圾回收分代收集算法介绍](#JVM内存溢出垃圾回收分代收集算法介绍)

[静态代理与动态代理](#静态代理与动态代理)

[单例模式](#单例模式)

[数据库连接池的好处](#数据库连接池的好处)

[分页功能的实现](#分页功能的实现)

[JDK1.8中](#JDK1.8中)

[Java的四种引用方式](#Java的四种引用方式)

[为什么使用抽象类？有什么好处？](#为什么使用抽象类有什么好处)

[Interface口extends口implement的区别](#Interface口extends口implement的区别)

[引用类型的强制类型转换](#引用类型的强制类型转换)

[序列化与反序列化](#序列化与反序列化)

[接口和抽象类该什么时候用](#接口和抽象类该什么时候用)

[线程状态](#线程状态)

[继承](#继承)

---

### 盐  
(密码学)维基百科，自由的百科全书


请协助改善这篇条目，更进一步的信息可能会在讨论页或扩充请求中找到。请在扩展条目后将此模板移除。

盐（Salt），在密码学中，是指在散列之前将散列内容（例如：密码）的任意固定位置插入特定的字符串。这个在散列中加入字符串的方式称为“加盐”。其作用是让加盐后的散列结果和没有加盐的结果不相同，在不同的应用情景中，这个处理可以增加额外的安全性。
在大部分情况，盐是不需要保密的。盐可以是随机产生的字符串，其插入的位置可以也是随意而定。如果这个散列结果在将来需要进行验证（例如：验证用户输入的密码），则需要将已使用的盐记录下来。

### 参考文献安全因素[编辑]
通常情况下，当字段经过散列处理（如MD5），会生成一段散列值，而散列后的值一般是无法通过特定算法得到原始字段的。但是某些情况，比如一个大型的彩虹表，通过在表中搜索该MD5值，很有可能在极短的时间内找到该散列值对应的真实字段内容。
加盐后的散列值，可以极大的降低由于用户数据被盗而带来的密码泄漏风险，即使通过彩虹表寻找到了散列后的数值所对应的原始内容，但是由于经过了加盐，插入的字符串扰乱了真正的密码，使得获得真实密码的概率大大降低。实现原理[编辑]

加盐的实现过程通常是在需要散列的字段的特定位置增加特定的字符，打乱原始的字符串，使其生成的散列结果产生变化。比如，用户使用了一个密码：
```
x7faqgjw
```

经过SHA散列后，可以得出结果：
```
58ecbf2b3136ceda7fddfd986ba8bd8d59b2d73779691e839f3f176ce2c04b84
```

但是由于用户密码位数不足，短密码的散列结果很容易被彩虹表破解，因此，在用户的密码末尾添加特定字符串（绿色字体为加盐的字段）：
```
x7faqgjwabcdefghijklmnopqrstuvwxyz
```

因此，加盐后的密码位数更长了，散列的结果也发生了变化：
```
7b5001a5a8bcdcfa1b64d41f6339cfa7a5c0eca04cca6ff6a6c1d6aad17794cc
```

以上就是加盐过程的简单描述，在实际使用过程中，还需要通过特定位数插入、倒序或多种方法对原始密码进行固定的加盐处理，使得散列的结果更加不容易被破解或轻易得到原始密码，比如（绿色字体为加盐字符串）：
```
x7afabqgcjw代码样本[编辑]PHP[编辑]
```

//这是一个简单的、在输入内容之後加入“WIKIPEDIA“并进行散列的PHP代码。
```
<?phpfunction hash($a) {
$salt="WIKIPEDIA"; //定义一个加盐字段(WIKIPEDIA)，一旦设定并使用，将不可更动。
$b=$a.$salt; //把密码和加盐字段连接。
$b=sha($b); //执行MD5散列。
return $b; //返回散列。}?>
```

---
### JVM内存溢出垃圾回收分代收集算法介绍
JVM管理两种类型的内存，堆和非堆

### (1). 堆内存分配 
JVM初始分配的内存由-Xms指定，默认是物理内存的1/64；JVM最大分配的内存由-Xmx指 定，默认是物理内存的1/4。默认空余堆内存小于 40%时，JVM就会增大堆直到-Xmx的最大限制；空余堆内存大于70%时，JVM会减少堆直到-Xms的最小限制。因此服务器一般设置-Xms、 -Xmx相等以避免在每次GC 后调整堆的大小。可以利用JVM提供的-Xmn -Xms -Xmx等选项可进行堆内存设置，一般的要将-Xms和-Xmx选项设置为相同，而-Xmn为1/4的-Xmx值，建议堆的最大值设置为可用内存的最大值的80%。
初始化堆的大小是JVM在启动时向系统申请的内存的大小。一般而言，这个参数不重要。但是有的应用程序在大负载的情况下会急剧地占用更多的内存，此时这个参数就是显得非常重要，如果JVM启动时设置使用的内存比较小而在这种情况下有许多对象进行初始化，JVM就必须重复地增加内存来满足使用。由于这种原因，我们一般把-Xms和-Xmx设为一样大，而堆的最大值受限于系统使用的物理内存。一般使用数据量较大的应用程序会使用持久对象，内存使用有可能迅速地增长。当应用程序需要的内存超出堆的最大值时JVM就会提示内存溢出，并且导致应用服务崩溃。所以，如果Xms超过了Xmx值，或者堆最大值和非堆最大值的总和超过了物理内存或者操作系统的最大限制都会引起服务器启动不起来。

### (2). 非堆内存分配 
也叫永久保存的区域，用于存放Class和Meta信息,Class在被Load的时候被放入该区域。它和存放类实例(Instance)的Heap区域不同,GC(Garbage Collection)不会在主程序运行期对PermGen space进行清理。JVM使用-XX:PermSize设置非堆内存初始值，默认是物理内存的1/64；由XX:MaxPermSize设置最大非堆内存的大小，默认是物理内存的1/4。 GC不会对PermGen space进行清理，所以如果你的APP会LOAD很多CLASS的话,就很可能出现PermGen space错误。

### 三种内存溢出异常介绍
1. OutOfMemoryError： Java heap space  堆溢出

内存溢出主要存在问题就是出现在这个情况中。当在JVM中如果98％的时间是用于GC且可用的 Heap size 不足2％的时候将抛出此异常信息。

 2. OutOfMemoryError： PermGen space   非堆溢出（永久保存区域溢出）
 
这种错误常见在web服务器对JSP进行pre compile的时候。如果你的WEB APP下都用了大量的第三方jar, 其大小超过了jvm默认的大小(4M)那么就会产生此错误信息了。如果web app用了大量的第三方jar或者应用有太多的class文件而恰好MaxPermSize设置较小，超出了也会导致这块内存的占用过多造成溢出，或者tomcat热部署时侯不会清理前面加载的环境，只会将context更改为新部署的，非堆存的内容就会越来越多。

3. OutOfMemoryError： unable to create new native thread.   无法创建新的线程

这种现象比较少见，也比较奇怪，主要是和jvm与系统内存的比例有关。这种怪事是因为JVM已经被系统分配了大量的内存（比如1.5G），并且它至少要占用可用内存的一半。

### 分代收集算法
　　对于一个大型的系统，当创建的对象和方法变量比较多时，堆内存中的对象也会比较多，如果逐一分析对象是否该回收，那么势必造成效率低下。分代收集算法是基于这样一个事实：不同的对象的生命周期(存活情况)是不一样的，而不同生命周期的对象位于堆中不同的区域，因此对堆内存不同区域采用不同的策略进行回收可以提高 JVM 的执行效率。当代商用虚拟机使用的都是分代收集算法：新生代对象存活率低，就采用复制算法；老年代存活率高，就用标记清除算法或者标记整理算法。
  
Java Heap分为3个区：
* 1.Young Generation
>* 　新生代的目标就是尽可能快速的收集掉那些生命周期短的对象，一般情况下，所有新生成的对象首先都是放在新生代的。新生代内存按照 8:1:1 的比例分为一个eden区和两个survivor(survivor0，survivor1)区，大部分对象在Eden区中生成。在进行垃圾回收时，先将eden区存活对象复制到survivor0区，然后清空eden区，当这个survivor0区也满了时，则将eden区和survivor0区存活对象复制到survivor1区，然后清空eden和这个survivor0区，此时survivor0区是空的，然后交换survivor0区和survivor1区的角色（即下次垃圾回收时会扫描Eden区和survivor1区），即保持survivor0区为空，如此往复。特别地，当survivor1区也不足以存放eden区和survivor0区的存活对象时，就将存活对象直接存放到老年代。如果老年代也满了，就会触发一次FullGC，也就是新生代、老年代都进行回收。注意，新生代发生的GC也叫做MinorGC，MinorGC发生频率比较高，不一定等 Eden区满了才触发。

* 2.Old Generation
>* 年代存放的都是一些生命周期较长的对象，就像上面所叙述的那样，在新生代中经历了N次垃圾回收后仍然存活的对象就会被放到老年代中。此外，老年代的内存也比新生代大很多(大概比例是1:2)，当老年代满时会触发Major GC(Full GC)，老年代对象存活时间比较长，因此FullGC发生的频率比较低。

* 3.Permanent Generation
>* 永久代主要用于存放静态文件，如Java类、方法等。永久代对垃圾回收没有显著影响，但是有些应用可能动态生成或者调用一些class，例如使用反射、动态代理、CGLib等bytecode框架时，在这种时候需要设置一个比较大的永久代空间来存放这些运行过程中新增的类

### JVM有2个GC线程： 
* 第一个线程负责回收Heap的Young区； 
* 第二个线程在Heap不足时，遍历Heap，将Young 区升级为Older区，Older区的大小等于-Xmx减去-Xmn，不能将-Xms的值设的过大，因为第二个线程被迫运行会降低JVM的性能。

### 为什么一些程序频繁发生GC？有如下原因： 
* 1. 程序内调用了System.gc()或Runtime.gc()。 
* 2. 一些中间件软件调用自己的GC方法，此时需要设置参数禁止这些GC。 
* 3. Java的Heap太小，一般默认的Heap值都很小。 
* 4. 频繁实例化对象，Release对象 此时尽量保存并重用对象，例如使用StringBuffer()和String()。
如果你发现每次GC后，Heap的剩余空间会是总空间的50%，这表示你的Heap处于健康状态许多Server端的Java程序每次GC后最好能有65%的剩余空间。

 
* 1．Server端JVM最好将-Xms和-Xmx设为相同值。为了优化GC，最好让-Xmn值约等于-Xmx的1/3。 
* 2．一个GUI程序最好是每10到20秒间运行一次GC，每次在半秒之内完成。


---


### 静态代理与动态代理
Proxy代理模式是一种结构型设计模式，主要解决的问题是：在直接访问对象时带来的问题

**代理是一种常用的设计模式，其目的就是为其他对象提供一个代理以控制对某个对象的访问。代理类负责为委托类预处理消息，过滤消息并转发消息，以及进行消息被委托类执行后的后续处理。**

---
比如你要买或卖房子，找个中介来帮你进行买卖，中介如何操作你并不关心，而你关心的是最终的结果，房子是否买卖成功，中间过程有中介来处理。这里的中介就像我们理解的代理模式一样。我们不直接进行买卖，而是通过中介买卖。我们不直接访问某个对象，而是访问其代理对象。
---
为了保持行为的一致性，代理类和委托类通常会实现相同的接口，所以在访问者看来两者没有丝毫的区别。通过代理类这中间一层，能有效控制对委托类对象的直接访问，也可以很好地隐藏和保护委托类对象，同时也为实施不同控制策略预留了空间，从而在设计上获得了更大的灵活性。更通俗的说，代理解决的问题当两个类需要通信时，引入第三方代理类，将两个类的关系解耦，让我们只了解代理类即可，而且代理的出现还可以让我们完成与另一个类之间的关系的统一管理，但是切记，**代理类和委托类要实现相同的接口，因为代理真正调用的还是委托类的方法。**
---
使用场合举例：如果需要委托类处理某一业务，那么我们就可以先在代理类中统一处理然后再调用具体实现类按照代理的创建时期，代理类可以分为两种： 

* 静态：由程序员创建代理类或特定工具自动生成源代码再对其编译。在程序运行前代理类的.class文件就已经存在了
* 动态：在程序运行时运用反射机制动态创建而成。

---

### 静态代理：
#### 静态代理UML类图：


静态代理类图
 
---

#### 模式中包含的角色及其职责
* Subject：抽象主题角色，抽象主题类可以是抽象类，也可以是接口，是一个最普通的业务类型定义，无特殊要求。
* RealSubject：具体主题角色，也叫被委托角色、被代理角色。是业务逻辑的具体执行者。
* Proxy：代理主题角色，也叫委托类、代理类。它把所有抽象主题类定义的方法给具体主题角色实现，并且在具体主题角色处理完毕前后做预处理和善后工作。（最简单的比如打印日志）：
>*  定义接口

>* 实现接口的实现类

>*  实现接口的静态代理对象



>* 客户端测试



>* 测试结果


---


#### 静态代理类优缺点
* 优点：
>* 代理使客户端不需要知道实现类怎么做的（不知道方法），而客户端只需知道代理的方法即可（解耦合）
* 缺点：
>* 1）代理类和委托类实现了相同的接口，代理类通过委托类实现了相同的方法。这样就出现了大量的代码重复。如果接口增加一个方法，除了所有实现类需要实现这个方法外，所有代理类也需要实现此方法。增加了代码维护的复杂度。
>* 2）代理对象只服务于一种类型的对象，如果要服务多类型的对象。势必要为每一种对象都进行代理，静态代理在程序规模稍大时就无法胜任了。如上的代码是只为Realsubject类的访问提供了代理，但是如果还要为其他类如Realsubject2类提供代理的话，就需要我们再次添加代理Realsubject2的代理类。

---

### 动态代理:
#### jdk动态代理（实现接口）
* 动态代理类图



java动态代理类位于java.lang.reflect包下，一般主要涉及到以下两个类：
* Interface InvocationHandler：该接口中仅定义了一个方法Object：invoke(Object obj,Method method, Object[] args)。在实际使用时，第一个参数obj一般是指代理 类，method是被代理的方法，如上例中的request()，args为该方法的参数数组。 这个抽 象方法在代理类中动态实现。
* Proxy：该类即为动态代理类，作用类似于上例中的ProxySubject。
* Protected Proxy(InvocationHandler h)：构造函数，估计用于给内部的h赋值。
* Static Class getProxyClass (ClassLoader loader, Class[] interfaces)：获得一个 代理类，其中loader是类装载器，interfaces是真实类所拥有的全部接口的数组。
* Static Object newProxyInstance(ClassLoader loader, Class[] interfaces, InvocationHandler h)：返回代理类的一个实例，返回后的代理类可以当作被代理类使用 (可使用被代理类的在Subject接口中声明过的方法)。




运行结果：

通过这种方式，被代理的对象(RealSubject)可以在运行时动态改变，需要控制的接口 (Subject接口)可以在运行时改变，控制的方式(DynamicSubject类)也可以动态改变，从而实 现了非常灵活的动态代理关系。

### 从JDK 1.3以来，Java 语言通过java.lang.reflex库提供的三个类直接支持代理：
* java.lang.reflect.Proxy
* java.lang.reflect.InvocationHandler 
* Method.
Proxy类在运行时动态创建代理对象，这也是dynamic proxy的由来，其中最重要的是newProxyInstance,这个方法中，指明了将要代理的类的加载器，业务类接口，以及代理类要执行动作的调用处理器（InvokeHandler)

```
public static Object newProxyInstance(
                    ClassLoader loader, Class[] interfaces,InvocationHandler h)
                             throws IllegalArgumentException
```

---

### 参数说明：
* ClassLoader loader：类加载器
* Class[] interfaces：得到全部的接口
* InvocationHandler h：得到InvocationHandler接口的子类实例
**注**:类加载器
在Proxy类中的newProxyInstance（）方法中需要一个ClassLoader类的实例，ClassLoader实际上对应的是类加载器，在Java中主要有一下三种类加载器;
* Booststrap ClassLoader：此加载器采用C++编写，一般开发中是看不到的；
* Extendsion ClassLoader：用来进行扩展类的加载，一般对应的是jre\lib\ext目录中的类;
* AppClassLoader：(默认)加载classpath指定的类，是最常使用的是一种加载器。

当系统有了一个代理对象之后，对原方法的调用会首先被分派到一个调用处理器（Invocation Handler).InvocationHandler 

---

 ### 对于JDK 的Proxy,有以下几点：
* 1）Interface：对于JDK proxy，业务类是需要一个Interface的
* 2）Proxy，Proxy 类是动态产生的，这个类在调用Proxy.newProxyInstance(targetCls.getClassLoader, targetCls.getInterface,InvocationHander)之后，会产生一个Proxy类的实例。实际上这个Proxy类也是存在的，不仅仅是类的实例。这个Proxy类可以保存到硬盘上。
* 3） Method:对于业务委托类的每个方法，现在Proxy类里面都不用静态显示出来
* 4） InvocationHandler: 这个类在业务委托类执行时，会先调用invoke方法。invoke方法再执行相应的代理操作，可以实现对业务方法的再包装

---

### cglib动态代理（继承）
cglib是针对类来实现代理的，他的原理是对指定的目标类生成一个子类，并覆盖其中方法实现增强，**但因为采用的是继承，所以不能对final修饰的类进行代理。** 



运行结果：

CGLib采用了非常底层的字节码技术，其原理是通过字节码技术为一个类创建子类，并在子类中采用方法拦截的技术拦截所有父类方法的调用，顺势织入横切逻辑。
* JDK动态代理与CGLib动态代理均是实现Spring AOP的基础。
* 而spring中的AOP，是通过动态代理实现的。
### 一、简单来说：
* JDK动态代理只能对实现了接口的类生成代理，而不能针对类
* CGLIB是针对类实现代理，主要是对指定的类生成一个子类，覆盖其中的方法（继承）
### 二、Spring在选择用JDK还是CGLiB的依据：
* (1)当Bean实现接口时，Spring就会用JDK的动态代理
* (2)当Bean没有实现接口时，Spring使用CGlib是实现
* (3)可以强制使用CGlib（在spring配置中加入<aop:aspectj-autoproxy proxy-target-class="true"/>）


---

### 单例模式

* 单例模式有以下特点：
>* 1、单例类只能有一个实例。
>* 2、单例类必须自己创建自己的唯一实例。
>* 3、单例类必须给所有其他对象提供这一实例。

* 单例模式确保某个类只有一个实例，而且自行实例化并向整个系统提供这个实例。在计算机系统中，线程池、缓存、日志对象、对话框、打印机、显卡的驱动程序对象常被设计成单例。这些应用都或多或少具有资源管理器的功能。每台计算机可以有若干个打印机，但只能有一个Printer Spooler，以避免两个打印作业同时输出到打印机中。每台计算机可以有若干通信端口，系统应当集中管理这些通信端口，以避免一个通信端口同时被两个请求同时调用。总之，选择单例模式就是为了避免不一致状态，避免政出多头。

---

###  一、懒汉式单例

```
[java] view plain copy
1.    //懒汉式单例类.在第一次调用的时候实例化自己   
2.    public class Singleton {  
3.        private Singleton() {}  
4.        private static Singleton single=null;  
5.        //静态工厂方法   
6.        public static Singleton getInstance() {  
7.             if (single == null) {  //single 为空  
8.                 single = new Singleton();  
9.             }    
10.            return single;  
11.        }  
12.    }  
```

Singleton通过将构造方法限定为private避免了类在外部被实例化，在同一个虚拟机范围内，Singleton的唯一实例只能通过getInstance()方法访问。（事实上，通过Java反射机制是能够实例化构造方法为private的类的，那基本上会使所有的Java单例实现失效。此问题在此处不做讨论，姑且掩耳盗铃地认为反射机制不存在。）

但是以上懒汉式单例的实现没有考虑线程安全问题，它是线程不安全的，并发环境下很可能出现多个Singleton实例，要实现线程安全，有以下三种方式，都是对getInstance这个方法改造，保证了懒汉式单例的线程安全，如果你第一次接触单例模式，对线程安全不是很了解，可以先跳过下面这三小条，去看饿汉式单例，等看完后面再回头考虑线程安全的问题：


* 1、在getInstance方法上加同步

```
[java] view plain copy
1.    public static synchronized Singleton getInstance() {  
2.             if (single == null) {    
3.                 single = new Singleton();  
4.             }    
5.            return single;  
6.    }  
```


* 2、双重检查锁定

```
[java] view plain copy
1.    public static Singleton getInstance() {  
2.            if (singleton == null) {    
3.                synchronized (Singleton.class) {    
4.                   if (singleton == null) {    
5.                      singleton = new Singleton();   
6.                   }    
7.                }    
8.            }    
9.            return singleton;   
10.        }  
```

* 3、静态内部类

```
[java] view plain copy
1.    public class Singleton {    
2.        private static class LazyHolder {    
3.           private static final Singleton INSTANCE = new Singleton();    
4.        }    
5.        private Singleton (){}    
6.        public static final Singleton getInstance() {    
7.           return LazyHolder.INSTANCE;    
8.        }    
9.    }    
```

这种比上面1、2都好一些，既实现了线程安全，又避免了同步带来的性能影响。

---

### 二、饿汉式单例

```
[java] view plain copy
1.    //饿汉式单例类.在类初始化时，已经自行实例化   
2.    public class Singleton1 {  
3.        private Singleton1() {}  
4.        private static final Singleton1 single = new Singleton1();  
5.        //静态工厂方法   
6.        public static Singleton1 getInstance() {  
7.            return single;  
8.        }  
9.    }  
```

饿汉式在类创建的同时就已经创建好一个静态的对象供系统使用，以后不再改变，所以天生是线程安全的。

---

###三、登记式单例

```
[java] view plain copy
1.    //类似Spring里面的方法，将类名注册，下次从里面直接获取。  
2.    public class Singleton3 {  
3.        private static Map<String,Singleton3> map = new HashMap<String,Singleton3>();  
4.        static{  
5.            Singleton3 single = new Singleton3();  
6.            map.put(single.getClass().getName(), single);  
7.        }  
8.        //保护的默认构造子  
9.        protected Singleton3(){}  
10.        //静态工厂方法,返还此类惟一的实例  
11.        public static Singleton3 getInstance(String name) {  
12.            if(name == null) {  
13.                name = Singleton3.class.getName();  
14.                System.out.println("name == null"+"--->name="+name);  
15.            }  
16.            if(map.get(name) == null) {  
17.                try {  
18.                    map.put(name, (Singleton3) Class.forName(name).newInstance());  
19.                } catch (InstantiationException e) {  
20.                    e.printStackTrace();  
21.                } catch (IllegalAccessException e) {  
22.                    e.printStackTrace();  
23.                } catch (ClassNotFoundException e) {  
24.                    e.printStackTrace();  
25.                }  
26.            }  
27.            return map.get(name);  
28.        }  
29.        //一个示意性的商业方法  
30.        public String about() {      
31.            return "Hello, I am RegSingleton.";      
32.        }      
33.        public static void main(String[] args) {  
34.            Singleton3 single3 = Singleton3.getInstance(null);  
35.            System.out.println(single3.about());  
36.        }  
37.    }  
```

登记式单例实际上维护了一组单例类的实例，将这些实例存放在一个Map（登记薄）中，对于已经登记过的实例，则从Map直接返回，对于没有登记的，则先登记，然后返回。

这里我对登记式单例标记了可忽略，我的理解来说，首先它用的比较少，另外其实内部实现还是用的饿汉式单例，因为其中的static方法块，它的单例在类被装载的时候就被实例化了。

---

### 饿汉式和懒汉式区别

* 从名字上来说，饿汉和懒汉，
>* 饿汉就是类一旦加载，就把单例初始化完成，保证getInstance的时候，单例是已经存在的了，
>* 而懒汉比较懒，只有当调用getInstance的时候，才回去初始化这个单例。

**另外从以下两点再区分以下这两种方式**

* 1、线程安全：
>* 饿汉式天生就是线程安全的，可以直接用于多线程而不会出现问题，
>* 懒汉式本身是非线程安全的，为了实现线程安全有几种写法，分别是上面的1、2、3，这三种实现在资源加载和性能方面有些区别。

* 2、资源加载和性能：
>* 饿汉式在类创建的同时就实例化一个静态对象出来，不管之后会不会使用这个单例，都会占据一定的内存，但是相应的，在第一次调用时速度也会更快，因为其资源已经初始化完成，
>* 而懒汉式顾名思义，会延迟加载，在第一次使用该单例的时候才会实例化对象出来，第一次调用时要做初始化，如果要做的工作比较多，性能上会有些延迟，之后就和饿汉式一样了。

---

### 至于1、2、3这三种实现又有些区别，
* 第1种，在方法调用上加了同步，虽然线程安全了，但是每次都要同步，会影响性能，毕竟99%的情况下是不需要同步的，
* 第2种，在getInstance中做了两次null检查，确保了只有第一次调用单例的时候才会做同步，这样也是线程安全的，同时避免了每次都同步的性能损耗
* 第3种，利用了classloader的机制来保证初始化instance时只有一个线程，所以也是线程安全的，同时没有性能损耗，所以一般我倾向于使用这一种。


---

### 什么是线程安全？
* 如果你的代码所在的进程中有多个线程在同时运行，而这些线程可能会同时运行这段代码。如果每次运行结果和单线程运行的结果是一样的，而且其他的变量的值也和预期的是一样的，就是线程安全的。

* 或者说：一个类或者程序所提供的接口对于线程来说是原子操作，或者多个线程之间的切换不会导致该接口的执行结果存在二义性,也就是说我们不用考虑同步的问题，那就是线程安全的。

---

### 应用
以下是一个单例类使用的例子，以懒汉式为例，这里为了保证线程安全，使用了双重检查锁定的方式：

```
[java] view plain copy
1.    public class TestSingleton {  
2.        String name = null;  
3.      
4.            private TestSingleton() {  
5.        }  
6.      
7.        private static volatile TestSingleton instance = null;  
8.      
9.        public static TestSingleton getInstance() {  
10.               if (instance == null) {    
11.                 synchronized (TestSingleton.class) {    
12.                    if (instance == null) {    
13.                       instance = new TestSingleton();   
14.                    }    
15.                 }    
16.               }   
17.               return instance;  
18.        }  
19.      
20.        public String getName() {  
21.            return name;  
22.        }  
23.      
24.        public void setName(String name) {  
25.            this.name = name;  
26.        }  
27.      
28.        public void printInfo() {  
29.            System.out.println("the name is " + name);  
30.        }  
31.      
32.    }  
```

* 可以看到里面加了volatile关键字来声明单例对象，既然synchronized已经起到了多线程下原子性、有序性、可见性的作用

```
[java] view plain copy
1.    public class TMain {  
2.        public static void main(String[] args){  
3.            TestStream ts1 = TestSingleton.getInstance();  
4.            ts1.setName("jason");  
5.            TestStream ts2 = TestSingleton.getInstance();  
6.            ts2.setName("0539");  
7.              
8.            ts1.printInfo();  
9.            ts2.printInfo();  
10.              
11.            if(ts1 == ts2){  
12.                System.out.println("创建的是同一个实例");  
13.            }else{  
14.                System.out.println("创建的不是同一个实例");  
15.            }  
16.        }  
17.    }  
```

---

### 数据库连接池的好处
频繁的建立、关闭连接，会极大的减低系统的性能

连接复用。通过建立一个数据库连接池以及一套连接进行管理，使得一个数据库连接可以得到高效、安全的复用，避免了数据库连接频繁建立、关闭的开销。 

对于共享资源，有一个很著名的设计模式：资源池。该模式正是为了解决资源频繁分配、释放所造成的问题的，可说是进行合理的分配资源，防止资源竞争现象。

**数据库连接池技术带来的优势： **

* 1． 资源重用 
```
由于数据库连接得到重用，避免了频繁创建、释放连接引起的大量性能开销。在减少系统消耗的基础上，

另一方面也增进了系统运行环境的平稳性（减少内存碎片以及数据库临时进程/线程的数量）。 
```

* 2． 更快的系统响应速度 
```
数据库连接池在初始化过程中，往往已经创建了若干数据库连接置于池中备用。此时连接的初始化工作均已完成。对于业务请求处理而言，

直接利用现有可用连接，避免了数据库连接初始化和释放过程的时间开销，从而缩减了系统整体响应时间。 
```

* 3． 新的资源分配手段 
```
对于多应用共享同一数据库的系统而言，可在应用层通过数据库连接的配置，实现数据库连接池技术，

某一应用最大可用数据库连接数的限制，避免某一应用独占所有数据库资源。 
```

* 4． 统一的连接管理，避免数据库连接溢出
```
在数据库连接池中，可根据预先的连接占用超时设定，强制收回被占用连接。

从而避免了常规数据库连接操作中可能出现的资源泄漏，可以使用一个最小化的数据库连接池来实现。

缓冲池：

1、从连接池获取或创建可用连接，；

2、使用完毕之后，把连接返还给连接池；

3、在系统关闭前，断开所有连接并释放连接占用的系统资源；

```

---

### 分页功能的实现

### 一、分页的思路

首先我们得知道写分页代码时的思路，保持思路清晰，有步骤的进行，才能行云如水。先来看看分页的效果　　　　　　　　　　　　　　　　　　　　　　

**这就是一个分页导航，其中能得到的数据有**

* totalRecord：总共员工数，数据库中总的记录数，这里有55条

* totalPage：总页数，11页

* pageSize：每页显示的记录数，这里可以看到每页显示5条

* pageNum：当前页为第几页，比如图中就为第9页，因为9是没有超链接的，

* start:总共能显示5页，让用户进行点击，7为起始页

* end：11为能显示的尾页，也就是，如果用户点击第8页，那么start就为6，end就为10，每次都只有5页共点击查询。

**每次能够得到对应页数所需要的5条数据，等等这些数据都要在jsp中显示出来，也就是说，每次都要从后台拿那么多数据过来进行显示，所以我们就想办法把这些数据封装在一个javabean当中，每次后台都将查询到的数据放入javabean对象中，我们只需要将该对象存入request作用域，然后在jsp页面中从域中获取需要的数据即可。**

　　　　　　　　

 

### 二、创建PageBean存放数据

* PageBean.java

* 总共需要8个属性pageNum、pageSize、totalRecord、totalPage、startIndex、list、start、end，

* pageNum、pageSize、totalRecord：通过构造方法就能得到。pageNum请求页面提交过来的参数，pageSize是自己设置的，totalRecord是查询数据库得到的

* totalPage、startIndex、start、end是通过内部算法得出，

* list需要通过查询数据库在通过set方式得到。

* **注意：该类使用泛型是为了不仅仅在这个项目中使用，在别的项目中也同样可以使用**

　　　　　　　　

　　　　　　　　

代码如下
```

package com.jxpx.myums.domain;

import java.util.List;

public class PageBean<T> {
    //已知数据
    private int pageNum;    //当前页,从请求那边传过来。
    private int pageSize;    //每页显示的数据条数。
    private int totalRecord;    //总的记录条数。查询数据库得到的数据
    
    //需要计算得来
    private int totalPage;    //总页数，通过totalRecord和pageSize计算可以得来
    //开始索引，也就是我们在数据库中要从第几行数据开始拿，有了startIndex和pageSize，
    //就知道了limit语句的两个数据，就能获得每页需要显示的数据了
    private int startIndex;        
        
    
    //将每页要显示的数据放在list集合中
    private List<T> list;
    
    //分页显示的页数,比如在页面上显示1，2，3，4，5页，start就为1，end就为5，这个也是算过来的
    private int start;
    private int end;
    
    //通过pageNum，pageSize，totalRecord计算得来tatalPage和startIndex
    //构造方法中将pageNum，pageSize，totalRecord获得
    public PageBean(int pageNum,int pageSize,int totalRecord) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;
        
        //totalPage 总页数
        if(totalRecord%pageSize==0){
            //说明整除，正好每页显示pageSize条数据，没有多余一页要显示少于pageSize条数据的
            this.totalPage = totalRecord / pageSize;
        }else{
            //不整除，就要在加一页，来显示多余的数据。
            this.totalPage = totalRecord / pageSize +1;
        }
        //开始索引
        this.startIndex = (pageNum-1)*pageSize ;
        //显示5页，这里自己可以设置，想显示几页就自己通过下面算法修改
        this.start = 1;
        this.end = 5;
        //显示页数的算法

        if(totalPage <=5){
            //总页数都小于5，那么end就为总页数的值了。
            this.end = this.totalPage;
        }else{
            //总页数大于5，那么就要根据当前是第几页，来判断start和end为多少了，
            this.start = pageNum - 2;
            this.end = pageNum + 2;
            
            if(start < 0){
                //比如当前页是第1页，或者第2页，那么就不如和这个规则，
                this.start = 1;
                this.end = 5;
            }
            if(end > this.totalPage){
                //比如当前页是倒数第2页或者最后一页，也同样不符合上面这个规则
                this.end = totalPage;
                this.start = end - 5;
            }
        }
    }
//get、set方法。
    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
    

}
```

 

### 三、在service层编写业务逻辑代码

* 其实就是在该层将我们所需要的PageBean对象构建好，返回给上一层User类是我们需要显示的数据的封装后的javabean。　

### 四、Servlet中编写控制代码

### 五、JSP中显示数据，构建分页导航

因为将我们所有需要的数据都封装在了pageBean中，pageBean对象又在request域中，所以在jsp页面中，我们只需要拿到我们所需要的数据，进行显示即可，构造导航图需要注意的有一点，逻辑要搞清楚，想要显示什么不想显示什么，全屏自己控制了，只需要记得一点，在请求Servlet时，需要把请求的页码交给服务器。不然服务器不知道你要获得第几页的数据。

* 我做的导航图的逻辑代码

* 显示所有员工数量、总页数

* 首先超链接　

* 如果当前页为第一页时，就没有上一页这个超链接显示

* 　如果当前页不是第一页也不是最后一页，则有上一页和下一页这个超链接显示

* 如果当前页是最后一页，则只有上一页这个超链接显示，下一页没有

* 尾页超链接　



　　　　　　

 

代码

```
 1             <%-- 构建分页导航 --%>
 2             共有${requestScope.pageBean.totalRecord}个员工，共${requestScope.pageBean.totalPage }页，当前为${requestScope.pageBean.pageNum}页
 3             <br/>
 4             <a href="${pageContext.request.contextPath}/FindAllWithPage?pageNum=1">首页</a>
 5             <%--如果当前页为第一页时，就没有上一页这个超链接显示 --%>
 6             <c:if test="${requestScope.pageBean.pageNum ==1}">
 7                 <c:forEach begin="${requestScope.pageBean.start}" end="${requestScope.pageBean.end}" step="1" var="i">
 8                     <c:if test="${requestScope.pageBean.pageNum == i}">
 9                         ${i}
10                     </c:if>                
11                     <c:if test="${requestScope.pageBean.pageNum != i}">
12                         <a href="${pageContext.request.contextPath}/FindAllWithPage?pageNum=${i}">${i}</a>                                        
13                     </c:if>                        
14                 </c:forEach>
15                 <a href="${pageContext.request.contextPath}/FindAllWithPage?pageNum=${requestScope.pageBean.pageNum+1}">下一页</a>                    
16             </c:if>
17             
18             <%--如果当前页不是第一页也不是最后一页，则有上一页和下一页这个超链接显示 --%>
19             <c:if test="${requestScope.pageBean.pageNum > 1 && requestScope.pageBean.pageNum < requestScope.pageBean.totalPage}">
20                 <a href="${pageContext.request.contextPath}/FindAllWithPage?pageNum=${requestScope.pageBean.pageNum-1}">上一页</a>
21                 <c:forEach begin="${requestScope.pageBean.start}" end="${requestScope.pageBean.end}" step="1" var="i">    
22                     <c:if test="${requestScope.pageBean.pageNum == i}">
23                         ${i}
24                     </c:if>            
25                     <c:if test="${requestScope.pageBean.pageNum != i}">
26                         <a href="${pageContext.request.contextPath}/FindAllWithPage?pageNum=${i}">${i}</a>                                        
27                     </c:if>                        
28                 </c:forEach>
29                 <a href="${pageContext.request.contextPath}/FindAllWithPage?pageNum=${requestScope.pageBean.pageNum+1}">下一页</a>    
30             </c:if>
31             
32             <%-- 如果当前页是最后一页，则只有上一页这个超链接显示，下一页没有 --%>
33             <c:if test="${requestScope.pageBean.pageNum == requestScope.pageBean.totalPage}">
34                 <a href="${pageContext.request.contextPath}/FindAllWithPage?pageNum=${requestScope.pageBean.pageNum-1}">上一页</a>
35                 <c:forEach begin="${requestScope.pageBean.start}" end="${requestScope.pageBean.end}" step="1" var="i">
36                     <c:if test="${requestScope.pageBean.pageNum == i}">
37                         ${i}
38                     </c:if>
39                     <c:if test="${requestScope.pageBean.pageNum != i}">
40                         <a href="${pageContext.request.contextPath}/FindAllWithPage?pageNum=${i}">${i}</a>                                        
41                     </c:if>                
42                 </c:forEach>
43             </c:if>
44             <%--尾页 --%>
45             <a href="${pageContext.request.contextPath}/FindAllWithPage?pageNum=${requestScope.pageBean.totalPage}">尾页</a>
```
 

　

### 六、总结
其实分页真的很简单，难点就在一个地方，javabean的构建，只要理清楚了pageBean中需要哪些属性，各种属性的作用是什么，那么分页就so easy了。还有一个就是在jsp中写分页导航时的逻辑，不要混乱了。其实一点也不难，有兴趣的同学可以自己动手实现一下分页的功能。对自己理解分页有很大的帮助，以后就在也不用到别人那里复制粘贴别人的分页代码了，自己也能写。靠自己丰衣足食。
    
### JDK1.8中
* 接口中的变量默认是public static final
* 接口中的方法默认是 public abstract，除非是static方法或者默认方法

### 接口中的变量默认是public static final？
* public：接口可以被不同包的不同类实现，是公有的，
* static：一个类继承多个接口时，即使存在同名变量也不会混淆。如果每个接口都含有一个名为a的成员变量，那么在该类中可以通过接口1.a,接口2.a,接口3.a来调用a，
* final：该变量不可被修改。如果一个接口被多个类实现时，在类1中修改了该变量的值，那么其他类中该变量的值也会变化，要防止该情况的发生。
```
interface X {
    public static final String name = "123";
}
interface Y {
    public static final String name = "456";
}
public class Main implements X, Y {
    public static void main(String[] args) {
        System.out.println(X.name);
        System.out.println(Y.name);
    }
}
//123
//456


首先你要弄清接口的含义.接口就是提供一种统一的’协议’,而接口中的属性也属于’协议’中的成员.它们是公共的,静态的,最终的常量.相当于全局常量.
抽象类是不’完全’的类,相当于是接口和具体类的一个中间层.即满足接口的抽象,也满足具体的实现.
如果接口可以定义变量，但是接口中的方法又都是抽象的，在接口中无法通过行为来修改属性。有的人会说了，没有关系，可以通过实现接口的对象的行为来修改接口中的属性。这当然没有问题，但是考虑这样的情况。如果接口A中有一个public访问权限的静态变量a。按照java的语义，我们可以不通过实现接口的对象来访问变量a，通过A.a = xxx;就可以改变接口中的变量a的值了。正如抽象类中是可以这样做的，那么实现接口A的所有对象也都会自动拥有这一改变后的a的值了，也就是说一个地方改变了a，所有这些对象中a的值也都跟着变了。这和抽象类有什么区别呢，怎么体现接口更高的抽象级别呢，怎么体现接口提供的统一的协议呢，那还要接口这种抽象来做什么呢？所以接口中不能出现变量，如果有变量，就和接口提供的统一的抽象这种思想是抵触的。所以接口中的属性必然是常量，只能读不能改，这样才能为实现接口的对象提供一个统一的属性。
```
通俗的讲，你认为是要变化的东西，就放在你自己的实现中，不能放在接口中去，接口只是对一类事物的属性和行为更高层次的抽象。对修改关闭，对扩展（不同的实现implements）开放，接口是对开闭原则的一种体现。
 
转自：
https://blog.csdn.net/ameyume/article/details/6189749

### Java的四种引用方式

[来源于博客园:] http://www.cnblogs.com/a986771570/p/8592660.html

java内存管理分为内存分配和内存回收，都不需要程序员负责，垃圾回收的机制主要是看对象是否有引用指向该对象。

java对象的引用包括
  强引用，软引用，弱引用，虚引用

Java中提供这四种引用类型主要有两个目的：

第一是可以让程序员通过代码的方式决定某些对象的生命周期；

第二是有利于JVM进行垃圾回收。

下面来阐述一下这四种类型引用的概念：

* １．强引用

 是指创建一个对象并把这个对象赋给一个引用变量。

比如：

Object object =new Object();
String str ="hello";
 强引用有引用变量指向时永远不会被垃圾回收，JVM宁愿抛出OutOfMemory错误也不会回收这种对象。

 ```
<pre name="code" class="java">public class Main {  
    public static void main(String[] args) {  
        new Main().fun1();  
    }  
       
    public void fun1() {  
        Object object = new Object();  
        Object[] objArr = new Object[1000];  
 }  
 ```
当运行至Object[] objArr = new Object[1000];这句时，如果内存不足，JVM会抛出OOM错误也不会回收object指向的对象。不过要注意的是，当fun1运行完之后，object和objArr都已经不存在了，所以它们指向的对象都会被JVM回收。

　　如果想中断强引用和某个对象之间的关联，可以显示地将引用赋值为null，这样一来的话，JVM在合适的时间就会回收该对象。

比如Vector类的clear方法中就是通过将引用赋值为null来实现清理工作的：

 ```
<pre name="code" class="java">
/** 
     * Removes the element at the specified position in this Vector. 
     * Shifts any subsequent elements to the left (subtracts one from their 
     * indices).  Returns the element that was removed from the Vector. 
     * 
     * @throws ArrayIndexOutOfBoundsException if the index is out of range 
     *         ({@code index < 0 || index >= size()}) 
     * @param index the index of the element to be removed 
     * @return element that was removed 
     * @since 1.2 
     */  
    public synchronized E remove(int index) {  
    modCount++;  
    if (index >= elementCount)  
        throw new ArrayIndexOutOfBoundsException(index);  
    Object oldValue = elementData[index];  
  
    int numMoved = elementCount - index - 1;  
    if (numMoved > 0)  
        System.arraycopy(elementData, index+1, elementData, index,  
                 numMoved);  
    elementData[--elementCount] = null; // Let gc do its work  
  
    return (E)oldValue;  
    }  

```
* 2.软引用（SoftReference）

如果一个对象具有软引用，内存空间足够，垃圾回收器就不会回收它；

如果内存空间不足了，就会回收这些对象的内存。只要垃圾回收器没有回收它，该对象就可以被程序使用。

软引用可用来实现内存敏感的高速缓存,比如网页缓存、图片缓存等。使用软引用能防止内存泄露，增强程序的健壮性。   
SoftReference的特点是它的一个实例保存对一个Java对象的软引用， 该软引用的存在不妨碍垃圾收集线程对该Java对象的回收。

也就是说，一旦SoftReference保存了对一个Java对象的软引用后，在垃圾线程对 这个Java对象回收前，SoftReference类所提供的get()方法返回Java对象的强引用。

另外，一旦垃圾线程回收该Java对象之 后，get()方法将返回null。

举个栗子：
 ```
<pre name="code" class="java">MyObject aRef = new  MyObject();  
SoftReference aSoftRef=new SoftReference(aRef);  
```
此时，对于这个MyObject对象，有两个引用路径，一个是来自SoftReference对象的软引用，一个来自变量aReference的强引用，所以这个MyObject对象是强可及对象。

随即，我们可以结束aReference对这个MyObject实例的强引用:
```
<pre name="code" class="java">aRef = null; 
````
此后，这个MyObject对象成为了软引用对象。如果垃圾收集线程进行内存垃圾收集，并不会因为有一个SoftReference对该对象的引用而始终保留该对象。
Java虚拟机的垃圾收集线程对软可及对象和其他一般Java对象进行了区别对待:软可及对象的清理是由垃圾收集线程根据其特定算法按照内存需求决定的。
也就是说，垃圾收集线程会在虚拟机抛出OutOfMemoryError之前回收软可及对象，而且虚拟机会尽可能优先回收长时间闲置不用的软可及对象，对那些刚刚构建的或刚刚使用过的“新”软可反对象会被虚拟机尽可能保留。在回收这些对象之前，我们可以通过:
```
<pre name="code" class="java">MyObject anotherRef=(MyObject)aSoftRef.get(); 
```
重新获得对该实例的强引用。而回收之后，调用get()方法就只能得到null了。
使用ReferenceQueue清除失去了软引用对象的SoftReference：

作为一个Java对象，SoftReference对象除了具有保存软引用的特殊性之外，也具有Java对象的一般性。所以，当软可及对象被回收之后，虽然这个SoftReference对象的get()方法返回null,但这个SoftReference对象已经不再具有存在的价值，需要一个适当的清除机制，避免大量SoftReference对象带来的内存泄漏。在java.lang.ref包里还提供了ReferenceQueue。如果在创建SoftReference对象的时候，使用了一个ReferenceQueue对象作为参数提供给SoftReference的构造方法，如:

```
<pre name="code" class="java">ReferenceQueue queue = new  ReferenceQueue();  
SoftReference  ref=new  SoftReference(aMyObject, queue);  
```
那么当这个SoftReference所软引用的aMyOhject被垃圾收集器回收的同时，ref所强引用的SoftReference对象被列入ReferenceQueue。也就是说，ReferenceQueue中保存的对象是Reference对象，而且是已经失去了它所软引用的对象的Reference对象。另外从ReferenceQueue这个名字也可以看出，它是一个队列，当我们调用它的poll()方法的时候，如果这个队列中不是空队列，那么将返回队列前面的那个Reference对象。

  在任何时候，我们都可以调用ReferenceQueue的poll()方法来检查是否有它所关心的非强可及对象被回收。如果队列为空，将返回一个null,否则该方法返回队列中前面的一个Reference对象。利用这个方法，我们可以检查哪个SoftReference所软引用的对象已经被回收。于是我们可以把这些失去所软引用的对象的SoftReference对象清除掉。常用的方式为:
  
```
<pre name="code" class="java">SoftReference ref = null;  
while ((ref = (EmployeeRef) q.poll()) != null) {  
    // 清除ref  
} 
```

* 3.弱引用（WeakReference）

　　弱引用也是用来描述非必需对象的，当JVM进行垃圾回收时，无论内存是否充足，都会回收被弱引用关联的对象。在java中，用java.lang.ref.WeakReference类来表示。下面是使用示例：

[java] view plain copy
 
 在CODE上查看代码片派生到我的代码片
 ```
<pre name="code" class="java">public class test {  
    public static void main(String[] args) {  
        WeakReference<People>reference=new WeakReference<People>(new People("zhouqian",20));  
        System.out.println(reference.get());  
        System.gc();//通知GVM回收资源  
        System.out.println(reference.get());  
    }  
}  
class People{  
    public String name;  
    public int age;  
    public People(String name,int age) {  
        this.name=name;  
        this.age=age;  
    }  
    @Override  
    public String toString() {  
        return "[name:"+name+",age:"+age+"]";  
    }  
}  
```
输出结果：  
[name:zhouqian,age:20]
null
第二个输出结果是null，这说明只要JVM进行垃圾回收，被弱引用关联的对象必定会被回收掉。不过要注意的是，这里所说的被弱引用关联的对象是指只有弱引用与之关联，如果存在强引用同时与之关联，则进行垃圾回收时也不会回收该对象（软引用也是如此）。

比如：将代码做一点小更改：
```
[java] view plain copy
 
 在CODE上查看代码片派生到我的代码片
<pre name="code" class="java">package yinyong;  
  
import java.lang.ref.WeakReference;  
  
public class test {  
    public static void main(String[] args) {  
        People people=new People("zhouqian",20);  
        WeakReference<People>reference=new WeakReference<People>(people);//<span style="color:#FF0000;">关联强引用</span>  
        System.out.println(reference.get());  
        System.gc();  
        System.out.println(reference.get());  
    }  
}  
class People{  
    public String name;  
    public int age;  
    public People(String name,int age) {  
        this.name=name;  
        this.age=age;  
    }  
    @Override  
    public String toString() {  
        return "[name:"+name+",age:"+age+"]";  
    }  
}//结果发生了很大的变化  
[name:zhouqian,age:20]  
[name:zhouqian,age:20]  
```

弱引用可以和一个引用队列（ReferenceQueue）联合使用，如果弱引用所引用的对象被JVM回收，这个软引用就会被加入到与之关联的引用队列中。

* 4.虚引用（PhantomReference）

　　虚引用和前面的软引用、弱引用不同，它并不影响对象的生命周期。在java中用java.lang.ref.PhantomReference类表示。如果一个对象与虚引用关联，则跟没有引用与之关联一样，在任何时候都可能被垃圾回收器回收。

　　要注意的是，虚引用必须和引用队列关联使用，当垃圾回收器准备回收一个对象时，如果发现它还有虚引用，就会把这个虚引用加入到与之 关联的引用队列中。程序可以通过判断引用队列中是否已经加入了虚引用，来了解被引用的对象是否将要被垃圾回收。如果程序发现某个虚引用已经被加入到引用队列，那么就可以在所引用的对象的内存被回收之前采取必要的行动。
```
[java] view plain copy
 
 在CODE上查看代码片派生到我的代码片
<pre name="code" class="java">import java.lang.ref.PhantomReference;  
import java.lang.ref.ReferenceQueue;  
public class Main {  
    public static void main(String[] args) {  
        ReferenceQueue<String> queue = new ReferenceQueue<String>();  
        PhantomReference<String> pr = new PhantomReference<String>(new String("hello"), queue);  
        System.out.println(pr.get());  
    }  
}  
 
```
* 软引用和弱引用
    对于强引用，我们平时在编写代码时经常会用到。而对于其他三种类型的引用，使用得最多的就是软引用和弱引用，这2种既有相似之处又有区别。它们都是用来描述非必需对象的，但是被软引用关联的对象只有在内存不足时才会被回收，而被弱引用关联的对象在JVM进行垃圾回收时总会被回收。

    在SoftReference类中，有三个方法，两个构造方法和一个get方法（WekReference类似）：

* 两个构造方法：
```
 在CODE上查看代码片派生到我的代码片
<pre name="code" class="java">public SoftReference(T referent) {  
    super(referent);  
    this.timestamp = clock;  
    }  
public SoftReference(T referent, ReferenceQueue<? super T> q) {  
    super(referent, q);  
    this.timestamp = clock;  
    }  
        get方法用来获取与软引用关联的对象的引用，如果该对象被回收了，则返回null。
```
 　　在使用软引用和弱引用的时候，我们可以显示地通过System.gc()来通知JVM进行垃圾回收，但是要注意的是，虽然发出了通知，JVM不一定会立刻执行，也就是说这句是无法确保此时JVM一定会进行垃圾回收的。

对象可及性的判断

在很多时候，一个对象并不是从根集直接引用的，而是一个对象被其他对象引用，甚至同时被几个对象所引用，从而构成一个以根集为顶的树形结构。如图2所示


    在这个树形的引用链中，箭头的方向代表了引用的方向，所指向的对象是被引用对象。由图可以看出，从根集到一个对象可以由很多条路径。比如到达对象5的路径就有①-⑤，③-⑦两条路径。由此带来了一个问题，那就是某个对象的可及性如何判断:
* 单条引用路径可及性判断:在这条路径中，最弱的一个引用决定对象的可及性。
* 多条引用路径可及性判断:几条路径中，最强的一条的引用决定对象的可及性。
    比如，我们假设图2中引用①和③为强引用，⑤为软引用，⑦为弱引用，对于对象5按照这两个判断原则，路径①-⑤取最弱的引用⑤，因此该路径对对象5的引用为软引用。同样，③-⑦为弱引用。在这两条路径之间取最强的引用，于是对象5是一个软可及对象
 

 

* 如何利用软引用和弱引用解决OOM问题

　　前面讲了关于软引用和弱引用相关的基础知识，那么到底如何利用它们来优化程序性能，从而避免OOM的问题呢？

　　下面举个例子，假如有一个应用需要读取大量的本地图片，如果每次读取图片都从硬盘读取，则会严重影响性能，但是如果全部加载到内存当中，又有可能造成内存溢出，此时使用软引用可以解决这个问题。

　　设计思路是：用一个HashMap来保存图片的路径 和 相应图片对象关联的软引用之间的映射关系，在内存不足时，JVM会自动回收这些缓存图片对象所占用的空间，从而有效地避免了OOM的问题。在Android开发中对于大量图片下载会经常用到。

* 3．使用软引用构建敏感数据的缓存
> 3.1 为什么需要使用软引用
```
   首先，我们看一个雇员信息查询系统的实例。我们将使用一个Java语言实现的雇员信息查询系统查询存储在磁盘文件或者数据库中的雇员人事档案信息。作为一个用户，我们完全有可能需要回头去查看几分钟甚至几秒钟前查看过的雇员档案信息(同样，我们在浏览WEB页面的时候也经常会使用“后退”按钮)。这时我们通常会有两种程序实现方式:一种是把过去查看过的雇员信息保存在内存中，每一个存储了雇员档案信息的Java对象的生命周期贯穿整个应用程序始终;另一种是当用户开始查看其他雇员的档案信息的时候，把存储了当前所查看的雇员档案信息的Java对象结束引用，使得垃圾收集线程可以回收其所占用的内存空间，当用户再次需要浏览该雇员的档案信息的时候，重新构建该雇员的信息。很显然，第一种实现方法将造成大量的内存浪费，而第二种实现的缺陷在于即使垃圾收集线程还没有进行垃圾收集，包含雇员档案信息的对象仍然完好地保存在内存中，应用程序也要重新构建一个对象。我们知道，访问磁盘文件、访问网络资源、查询数据库等操作都是影响应用程序执行性能的重要因素，如果能重新获取那些尚未被回收的Java对象的引用，必将减少不必要的访问，大大提高程序的运行速度。
   ```
> 3.2 如果使用软引用
```
SoftReference的特点是它的一个实例保存对一个Java对象的软引用，该软引用的存在不妨碍垃圾收集线程对该Java对象的回收。也就是说，一旦SoftReference保存了对一个Java对象的软引用后，在垃圾线程对这个Java对象回收前，SoftReference类所提供的get()方法返回Java对象的强引用。另外，一旦垃圾线程回收该Java对象之后，get()方法将返回null。
看下面代码:
MyObject aRef = new  MyObject();
SoftReference aSoftRef=new SoftReference(aRef);
    此时，对于这个MyObject对象，有两个引用路径，一个是来自SoftReference对象的软引用，一个来自变量aReference的强引用，所以这个MyObject对象是强可及对象。
随即，我们可以结束aReference对这个MyObject实例的强引用:
aRef = null;
此后，这个MyObject对象成为了软可及对象。如果垃圾收集线程进行内存垃圾收集，并不会因为有一个SoftReference对该对象的引用而始终保留该对象。Java虚拟机的垃圾收集线程对软可及对象和其他一般Java对象进行了区别对待:软可及对象的清理是由垃圾收集线程根据其特定算法按照内存需求决定的。也就是说，垃圾收集线程会在虚拟机抛出OutOfMemoryError之前回收软可及对象，而且虚拟机会尽可能优先回收长时间闲置不用的软可及对象，对那些刚刚构建的或刚刚使用过的“新”软可反对象会被虚拟机尽可能保留。在回收这些对象之前，我们可以通过:
MyObject anotherRef=(MyObject)aSoftRef.get();
    重新获得对该实例的强引用。而回收之后，调用get()方法就只能得到null了。
    ```
> 3.3 使用ReferenceQueue清除失去了软引用对象的SoftReference
```
作为一个Java对象，SoftReference对象除了具有保存软引用的特殊性之外，也具有Java对象的一般性。所以，当软可及对象被回收之后，虽然这个SoftReference对象的get()方法返回null,但这个SoftReference对象已经不再具有存在的价值，需要一个适当的清除机制，避免大量SoftReference对象带来的内存泄漏。在java.lang.ref包里还提供了ReferenceQueue。如果在创建SoftReference对象的时候，使用了一个ReferenceQueue对象作为参数提供给SoftReference的构造方法，如:
ReferenceQueue queue = new  ReferenceQueue();
SoftReference  ref=new  SoftReference(aMyObject, queue);
    那么当这个SoftReference所软引用的aMyOhject被垃圾收集器回收的同时，ref所强引用的SoftReference对象被列入ReferenceQueue。也就是说，ReferenceQueue中保存的对象是Reference对象，而且是已经失去了它所软引用的对象的Reference对象。另外从ReferenceQueue这个名字也可以看出，它是一个队列，当我们调用它的poll()方法的时候，如果这个队列中不是空队列，那么将返回队列前面的那个Reference对象。
在任何时候，我们都可以调用ReferenceQueue的poll()方法来检查是否有它所关心的非强可及对象被回收。如果队列为空，将返回一个null,否则该方法返回队列中前面的一个Reference对象。利用这个方法，我们可以检查哪个SoftReference所软引用的对象已经被回收。于是我们可以把这些失去所软引用的对象的SoftReference对象清除掉。常用的方式为:
SoftReference ref = null;
while ((ref = (EmployeeRef) q.poll()) != null) {
    // 清除ref
}
理解了ReferenceQueue的工作机制之后，我们就可以开始构造一个Java对象的高速缓存器了。
```
> 3.4通过软可及对象重获方法实现Java对象的高速缓存
```
    利用Java2平台垃圾收集机制的特性以及前述的垃圾对象重获方法，我们通过一个雇员信息查询系统的小例子来说明如何构建一种高速缓存器来避免重复构建同一个对象带来的性能损失。我们将一个雇员的档案信息定义为一个Employee类:
publicclass Employee {
    private String id;// 雇员的标识号码
    private String name;// 雇员姓名
    private String department;// 该雇员所在部门
    private String Phone;// 该雇员联系电话
    privateintsalary;// 该雇员薪资
    private String origin;// 该雇员信息的来源
 
    // 构造方法
    public Employee(String id) {
       this.id = id;
       getDataFromlnfoCenter();
    }
 
    // 到数据库中取得雇员信息
    privatevoid getDataFromlnfoCenter() {
       // 和数据库建立连接井查询该雇员的信息，将查询结果赋值
       // 给name，department，plone，salary等变量
       // 同时将origin赋值为"From DataBase"
    }
```
这个Employee类的构造方法中我们可以预见，如果每次需要查询一个雇员的信息。哪怕是几秒中之前刚刚查询过的，都要重新构建一个实例，这是需要消耗很多时间的。下面是一个对Employee对象进行缓存的缓存器的定义:
```

```
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Hashtable;
publicclass EmployeeCache {
    staticprivate EmployeeCache cache;// 一个Cache实例
    private Hashtable<String,EmployeeRef> employeeRefs;// 用于Chche内容的存储
    private ReferenceQueue<Employee> q;// 垃圾Reference的队列
 
    // 继承SoftReference，使得每一个实例都具有可识别的标识。
    // 并且该标识与其在HashMap内的key相同。
    privateclass EmployeeRef extends SoftReference<Employee> {
       private String _key = "";
 
       public EmployeeRef(Employee em, ReferenceQueue<Employee> q) {
           super(em, q);
           _key = em.getID();
       }
    }
 
    // 构建一个缓存器实例
    private EmployeeCache() {
       employeeRefs = new Hashtable<String,EmployeeRef>();
       q = new ReferenceQueue<Employee>();
    }
 
    // 取得缓存器实例
    publicstatic EmployeeCache getInstance() {
       if (cache == null) {
           cache = new EmployeeCache();
       }
       returncache;
    }
 
    // 以软引用的方式对一个Employee对象的实例进行引用并保存该引用
    privatevoid cacheEmployee(Employee em) {
       cleanCache();// 清除垃圾引用
       EmployeeRef ref = new EmployeeRef(em, q);
       employeeRefs.put(em.getID(), ref);
    }
 
    // 依据所指定的ID号，重新获取相应Employee对象的实例
    public Employee getEmployee(String ID) {
       Employee em = null;
       // 缓存中是否有该Employee实例的软引用，如果有，从软引用中取得。
       if (employeeRefs.containsKey(ID)) {
           EmployeeRef ref = (EmployeeRef) employeeRefs.get(ID);
           em = (Employee) ref.get();
       }
       // 如果没有软引用，或者从软引用中得到的实例是null，重新构建一个实例，
       // 并保存对这个新建实例的软引用
       if (em == null) {
           em = new Employee(ID);
           System.out.println("Retrieve From EmployeeInfoCenter. ID=" + ID);
           this.cacheEmployee(em);
       }
       return em;
    }
 
    // 清除那些所软引用的Employee对象已经被回收的EmployeeRef对象
    privatevoid cleanCache() {
       EmployeeRef ref = null;
       while ((ref = (EmployeeRef) q.poll()) != null) {
           employeeRefs.remove(ref._key);
       }
    }
 
    // 清除Cache内的全部内容
    publicvoid clearCache() {
       cleanCache();
       employeeRefs.clear();
       System.gc();
       System.runFinalization();
    }
}
```
* 4．使用弱引用构建非敏感数据的缓存
4.1全局 Map 造成的内存泄漏
无意识对象保留最常见的原因是使用Map将元数据与临时对象（transient object）相关联。假定一个对象具有中等生命周期，比分配它的那个方法调用的生命周期长，但是比应用程序的生命周期短，如客户机的套接字连接。需要将一些元数据与这个套接字关联，如生成连接的用户的标识。在创建Socket时是不知道这些信息的，并且不能将数据添加到Socket对象上，因为不能控制 Socket 类或者它的子类。这时，典型的方法就是在一个全局 Map 中存储这些信息，如下面的 SocketManager 类所示：使用一个全局 Map 将元数据关联到一个对象。
```
publicclass SocketManager {
    private Map<Socket, User> m = new HashMap<Socket, User>();
 
    publicvoid setUser(Socket s, User u) {
       m.put(s, u);
    }
 
    public User getUser(Socket s) {
       returnm.get(s);
    }
 
    publicvoid removeUser(Socket s) {
       m.remove(s);
    }
}
```
这种方法的问题是元数据的生命周期需要与套接字的生命周期挂钩，但是除非准确地知道什么时候程序不再需要这个套接字，并记住从 Map 中删除相应的映射，否则，Socket 和 User 对象将会永远留在 Map 中，远远超过响应了请求和关闭套接字的时间。这会阻止 Socket 和 User 对象被垃圾收集，即使应用程序不会再使用它们。这些对象留下来不受控制，很容易造成程序在长时间运行后内存爆满。除了最简单的情况，在几乎所有情况下找出什么时候 Socket 不再被程序使用是一件很烦人和容易出错的任务，需要人工对内存进行管理。
 
4.2如何使用WeakHashMap
在Java集合中有一种特殊的Map类型—WeakHashMap，在这种Map中存放了键对象的弱引用，当一个键对象被垃圾回收器回收时，那么相应的值对象的引用会从Map中删除。WeakHashMap能够节约存储空间，可用来缓存那些非必须存在的数据。关于Map接口的一般用法。
下面示例中MapCache类的main()方法创建了一个WeakHashMap对象，它存放了一组Key对象的弱引用，此外main()方法还创建了一个数组对象，它存放了部分Key对象的强引用。
```
import java.util.WeakHashMap;
 
class Element {
    private String ident;
 
    public Element(String id) {
       ident = id;
    }
 
    public String toString() {
       returnident;
    }
 
    publicint hashCode() {
       returnident.hashCode();
    }
 
    publicboolean equals(Object obj) {
       return obj instanceof Element && ident.equals(((Element) obj).ident);
    }
   
    protectedvoid finalize(){
       System.out.println("Finalizing "+getClass().getSimpleName()+" "+ident);
    }
}
 
class Key extends Element{
    public Key(String id){
       super(id);
    }
}
 
class Value extends Element{
    public Value (String id){
       super(id);
    }
}
 
publicclass CanonicalMapping {
    publicstaticvoid main(String[] args){
       int size=1000;
       Key[] keys=new Key[size];
       WeakHashMap<Key,Value> map=new WeakHashMap<Key,Value>();
       for(int i=0;i<size;i++){
           Key k=new Key(Integer.toString(i));
           Value v=new Value(Integer.toString(i));
           if(i%3==0)
              keys[i]=k;
           map.put(k, v);
       }
       System.gc();
    }
}
```
从打印结果可以看出，当执行System.gc()方法后，垃圾回收器只会回收那些仅仅持有弱引用的Key对象。id可以被3整除的Key对象持有强引用，因此不会被回收。
 
4.3用 WeakHashMap 堵住泄漏
在 SocketManager 中防止泄漏很容易，只要用 WeakHashMap 代替 HashMap 就行了。（这里假定SocketManager不需要线程安全）。当映射的生命周期必须与键的生命周期联系在一起时，可以使用这种方法。用WeakHashMap修复 SocketManager。
```
publicclass SocketManager {
    private Map<Socket,User> m = new WeakHashMap<Socket,User>();
   
    publicvoid setUser(Socket s, User u) {
        m.put(s, u);
    }
    public User getUser(Socket s) {
        returnm.get(s);
    }
}
 ```
4.4配合使用引用队列
WeakHashMap 用弱引用承载映射键，这使得应用程序不再使用键对象时它们可以被垃圾收集，get() 实现可以根据 WeakReference.get() 是否返回 null 来区分死的映射和活的映射。但是这只是防止 Map 的内存消耗在应用程序的生命周期中不断增加所需要做的工作的一半，还需要做一些工作以便在键对象被收集后从 Map 中删除死项。否则，Map 会充满对应于死键的项。虽然这对于应用程序是不可见的，但是它仍然会造成应用程序耗尽内存。
引用队列是垃圾收集器向应用程序返回关于对象生命周期的信息的主要方法。弱引用有个构造函数取引用队列作为参数。如果用关联的引用队列创建弱引用，在弱引用对象成为 GC 候选对象时，这个引用对象就在引用清除后加入到引用队列中（具体参考上文软引用示例）。
WeakHashMap 有一个名为 expungeStaleEntries() 的私有方法，大多数 Map 操作中会调用它，它去掉引用队列中所有失效的引用，并删除关联的映射。
5．UML:使用关联类指明特定形式的引用
关联类能够用来指明特定形式的引用，如弱（weak）、软（soft）或虚 （phantom）引用。

也可以如下的构造型方式。

### 为什么使用抽象类？有什么好处？

[来源于博客园:]https://www.cnblogs.com/heyonggang/p/3142338.html

最简单的说法也是最重要的理由：接口和实现分离

老是在想为什么要引用抽象类，一般类不就够用了吗。一般类里定义的方法，子类也可以覆盖，没必要定义成抽象的啊。

看了下面的文章，明白了一点。

其实不是说抽象类有什么用，一般类确实也能满足应用，但是现实中确实有些父类中的方法确实没有必要写，因为各个子类中的这个方法肯定会有不同，所以没有必要再父类里写。当然你也可以把抽象类都写成非抽象类，但是这样没有必要。

而写成抽象类，这样别人看到你的代码，或你看到别人的代码，你就会注意抽象方法，而知道这个方法是在子类中实现的，所以，有个提示作用。

问你个问题，你知道什么是“东西”吗？什么是“物体”吗？ 
“麻烦你，小王。帮我把那个东西拿过来好吗” 
在生活中，你肯定用过这个词－－东西。 
小王：“你要让我帮你拿那个水杯吗？” 
你要的是水杯类的对象。而东西是水杯的父类。通常东西类没有实例对象，但我们有时需要东西的引用指向它的子类实例。 

你看你的房间乱成什么样子了，以后不要把东西乱放了，知道么？ 
又是东西，它是一个数组。而数组中的元素都是其子类的实例。 

上面讲的只是子类和父类。而没有说明抽象类的作用。抽象类是据有一个或多个抽象方法的类，必须声明为抽象类。抽象类的特点是，不能创建实例。 

这些该死的抽象类，也不知道它有什么屁用。我非要把它改一改不可。把抽象类中的抽象方法都改为空实现。也就是给抽象方法加上一个方法体，不过这个方法体是空的。这回抽象类就没有抽象方法了。它就可以不在抽象了。 

当你这么尝试之后，你发现，原来的代码没有任何变化。大家都还是和原来一样，工作的很好。你这回可能更加相信，抽象类根本就没有什么用。但总是不死心，它应该有点用吧，不然创造Java的这伙传说中的天才不成了傻子了吗？ 

接下来，我们来写一个小游戏。俄罗斯方块！我们来分析一下它需要什么类？
我知道它要在一个矩形的房子里完成。这个房子的上面出现一个方块，慢慢的下落，当它接触到地面或是其它方块的尸体时，它就停止下落了。然后房子的上面又会出现一个新的方块，与前一个方块一样，也会慢慢的下落。在它还没有死亡之前，我可以尽量的移动和翻转它。这样可以使它起到落地时起到一定的作用，如果好的话，还可以减下少几行呢。这看起来好象人生一样，它在为后来人努力着。
当然，我们不是真的要写一个游戏。所以我们简化它。我抽象出两个必须的类，一个是那个房间，或者就它地图也行。另一个是方块。我发现方块有很多种，数一下，共6种。它们都是四个小矩形构成的。但是它们还有很多不同，例如：它们的翻转方法不同。先把这个问题放到一边去，我们回到房子这个类中。

房子上面总是有方块落下来，房子应该有个属性是方块。当一个方块死掉后，再创建一个方块，让它出现在房子的上面。当玩家要翻转方法时，它翻转的到底是哪个方块呢？当然，房子中只有一个方块可以被翻转，就是当前方块。它是房子的一个属性。那这个属性到底是什么类型的呢？方块有很多不同啊，一共有6种之多，我需要写六个类。一个属性不可能有六种类型吧。当然一个属性只能有一种类型。

我们写一个方块类，用它来派生出6个子类。而房子类的当前方块属性的类型是方块类型。它可以指向任何子类。但是，当我调用当前方块的翻转方法时，它的子类都有吗？如果你把翻转方法写到方块类中，它的子类自然也就有了。可以这六种子类的翻转方法是不同的。我们知道'田'方块，它只有一种状态，无论你怎么翻转它。而长条的方块有两种状态。一种是‘－’，另一种是‘｜’。这可怎么办呢？我们知道Java的多态性，你可以让子类来重写父类的方法。也就是说，在父类中定义这个方法，子类在重写这个方法。

那么在父类的这个翻转方法中，我写一些什么代码呢？让它有几种状态呢？因为我们不可能实例化一个方块类的实例，所以它的翻转方法中的代码并不重要。而子类必须去重写它。那么你可以在父类的翻转方法中不写任何代码，也就是空方法。

我们发现，方法类不可能有实例，它的翻转方法的内容可以是任何的代码。而子类必须重写父类的翻转方法。这时，你可以把方块类写成抽象类，而它的抽象方法就是翻转方法。当然，你也可以把方块类写为非抽象的，也可以在方块类的翻转方法中写上几千行的代码。但这样好吗？难道你是微软派来的，非要说Java中的很多东西都是没有用的吗？

当我看到方块类是抽象的，我会很关心它的抽象方法。我知道它的子类一定会重写它，而且，我会去找到抽象类的引用。它一定会有多态性的体现。

但是，如果你没有这样做，我会认为可能会在某个地方，你会实例化一个方块类的实例，但我找了所有的地方都没有找到。最后我会大骂你一句，你是来欺骗我的吗，你这个白痴。

把那些和“东西”差不多的类写成抽象的。而水杯一样的类就可以不是抽象的了。当然水杯也有几千块钱一个的和几块钱一个的。水杯也有子类，例如，我用的水杯都很高档，大多都是一次性的纸水杯。

记住一点，面向对象不是来自于Java，面向对象就在你的生活中。而Java的面向对象是方便你解决复杂的问题。这不是说面向对象很简单，虽然面向对象很复杂，但Java知道，你很了解面向对象，因为它就在你身边。

---

### Interface口extends口implement的区别

* interface是定义接口的关键字。
* implement是实现接口的关键字。
* extends是子类继承父类的关键字。
>* 1、interface接口定义不能包含任何属性（如：public、private等），但是在实现接口的类定义中，可以包含必须标记为public。
```
例如： （1）、interface interfaceName [extends interfaceName] {}

       （2）、有一类东西，都具有同样的行为，而这个共有的行为实现方式不一样。

如：笔这类东西，都有共同的行为“写”，铅笔、毛笔、圆珠笔、钢笔都有“写”的功能，但实现起来不一样。那么我们就可以抽象出一个接口“笔”

interface 笔{ //定义一个接口“笔”

void 写(); //定义一个“写”的方法

}

implement的意思是指在铅笔、毛笔、圆珠笔要有”写“的这个功能，就需要实现接口”笔“的”写“功能。而这个关键字implement就是实现的意思，如：

class 铅笔 implement 笔{ //用“铅笔”这个类实现“笔”的功能

void 写(){

用铅芯画

}

}

class 钢笔 implement 笔{ //用“钢笔”这个类实现“笔”的功能

void 写(){

用墨水画

}

}
```
 

>* 2、extends语句可以使用一个接口继承多个接口，通过implement语句可以使用一个类继承多个接口。

extends是继承父类，继承只能继承一个类。

extends是继承某个类之后可以使用父类的方法，也可以重写父类的方法。

```
例如： （1）、class A extends B implement C,D,E; //类A继承了类B，实  现了C,D,E三个接口

       （2）、extends是指一个继承关系，子类继承父类的功能：父类”灯“具有”发光“的功能，而子类"台灯"，只需要extends（继承）父类”灯“就拥有了发光的共功能。
```

>* 3、implement是实现interface定义的类的具体方法功能。
```
      Implement可以实现多个接口，接口中的方法为空的，必须重写才能使用。
```

版权声明：本文为博主原创文章，未经博主允许不得转载。	https://blog.csdn.net/Warpar/article/details/72859529

### 引用类型的强制类型转换

（内容略有改动，作者出处：：https://blog.csdn.net/IBLiplus/article/details/81159710）

正如有时候需要将浮点型的数值转换为整型数值一样，有时候也可能需要将某个类的对象引用转换成两外一个类的对象引用。进行强制类型转换的唯一原因是：在暂时忽视对象的实际类型之后，使用对象的全部功能。
```
  编写Java程序时，引用类型只能调用声明该变量的类型的方法，也就是编译时类型的方法，不允许调用运行时类型所定义的方法，即使它实际所引用的对象包含该方法。解释一下就是我们说的，父类对象不能调用子类中新定义的方法，即使new 实例化的是子类类型。如果想要让这个父类类型的变量能够调用子类中新添的方法，就必须对该变量进行强制类型转换，将其转换成自类类型。强制转换类型的方式和基本类型的转换方式之一致的。
```
结合基本类型的强制转换，我们要注意一下：

* 基本类型的强制类型转化是在数值类型之间进行，这里值得是Java中8种基本类型。但是数值类型和布尔类型之间不能转换。
* 引用类型之间的转化只能是两个类型具有继承关系，就是说一个类型是另一个类型的子类类型。不具备继承关系的两个引用类型变量是不能进行强制类型转换的。否则程序会引发ClassCastException异常。
```
public class Cast {
 
	public static void main(String[] args) {
		double d = 1.23;
		long l = (long) (d);
		System.out.println(l);
		int i = 3;
		//boolean bl = (boolean)i;
		//布尔类型的变量不能和数值类型的变量之间进行转换
		Object obj = "hello";
		//Java中String类继承于Object类
		String objStr = (String)obj;
		System.out.println(objStr);
		Object obj1 = new Integer(20);
		String str = (String)obj1;
		//obj1 的编译时类型是Objext 运行时类型是Integer
		// Object与Integer存在继承关系   
		//可以强制类型转换 而obj1的实际类型是Integer
		//所以下面的代码运行时会引发类型转换的异常 因为String类和integer类不存在继承关系
		System.out.println(str);
	}
	
}
结果：



因此 考虑到强制类型转换可能会引发程序异常，所以在进行引用类型的强制类型转换之前要先使用instanceof关键字进行判断。关键字是用来判断类类型的。

String strr = "";
if(  strr instanceof Object) {
			
    System.out.println("Yes");
}
if(strr instanceof String) {
	System.out.println("Yes");
}
结果都是输出Yes.
```
* instanceof运算符的前一个操作数通常是一个引用类型的变量，后一个操作数通常是一个类，也可以是接口，可以把接口理解成为一种特殊的类，它用于判断前面的对象是否是后面的类，或者子类，实现类的实例。
* 在使用instanceof关键字的时候要注意，instanceof运算符前面的操作数的编译时类型要么与后面的类相同，要么与后面的类具有父子继承关系，否则会引起编译错误。


### 序列化与反序列化
（对象流）(作者出处，内容略有改动)
File 类的介绍：http://www.cnblogs.com/ysocean/p/6851878.html

Java IO 流的分类介绍：http://www.cnblogs.com/ysocean/p/6854098.html

Java IO 字节输入输出流：http://www.cnblogs.com/ysocean/p/6854541.html

Java IO 字符输入输出流：https://i.cnblogs.com/EditPosts.aspx?postid=6859242

Java IO 包装流：http://www.cnblogs.com/ysocean/p/6864080.html

* 1、什么是序列化与反序列化？

　　1) 序列化：指把堆内存中的 Java 对象数据，通过某种方式把对象存储到磁盘文件中或者传递给其他网络节点（在网络上传输）。这个过程称为序列化。通俗来说就是将数据结构或对象转换成二进制串的过程

　　2) 反序列化：把磁盘文件中的对象数据或者把网络节点上的对象数据，恢复成Java对象模型的过程。也就是将在序列化过程中所生成的二进制串转换成数据结构或者对象的过程

 

* 2、为什么要做序列化？

　　1)在分布式系统中，此时需要把对象在网络上传输，就得把对象数据转换为二进制形式，需要共享的数据的 JavaBean 对象，都得做序列化。

　　②、服务器钝化：如果服务器发现某些对象好久没活动了，那么服务器就会把这些内存中的对象持久化在本地磁盘文件中（Java对象转换为二进制文件）；如果服务器发现某些对象需要活动时，先去内存中寻找，找不到再去磁盘文件中反序列化我们的对象数据，恢复成 Java 对象。这样能节省服务器内存。

 

* 3、Java 怎么进行序列化？

　　1)需要做序列化的对象的类，必须实现序列化接口：Java.lang.Serializable 接口（这是一个标志接口，没有任何抽象方法），Java 中大多数类都实现了该接口，比如：String，Integer

　　2)底层会判断，如果当前对象是 Serializable 的实例，才允许做序列化，Java对象 instanceof Serializable 来判断。

　　3)在 Java 中使用对象流来完成序列化和反序列化
```
　　　　ObjectOutputStream:通过 writeObject()方法做序列化操作

　　　　ObjectInputStream:通过 readObject() 方法做反序列化操作
```
* 第一步：创建一个 JavaBean 对象
```
public class Person implements Serializable{
    private String name;
    private int age;
     
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }
}　　
 
```
* 第二步：使用 ObjectOutputStream 对象实现序列化
```
在根目录下新建一个 io 的文件夹
        OutputStream op = new FileOutputStream("io"+File.separator+"a.txt");
        ObjectOutputStream ops = new ObjectOutputStream(op);
        ops.writeObject(new Person("vae",1));
        ops.close();
　　我们打开 a.txt 文件，发现里面的内容乱码，注意这不需要我们来看懂，这是二进制文件，计算机能读懂就行了。
```
错误一：如果新建的 Person 对象没有实现 Serializable 接口，那么上面的操作会报错：

　　　　

* 第三步：使用ObjectInputStream 对象实现反序列化,反序列化的对象必须要提供该对象的字节码文件.class
```
    InputStream in = new FileInputStream("io"+File.separator+"a.txt");
    ObjectInputStream os = new ObjectInputStream(in);
    byte[] buffer = new byte[10];
    int len = -1;
    Person p = (Person) os.readObject();
    System.out.println(p);  //Person [name=vae, age=1]
    os.close();
　　
```
* 问题1：如果某些数据不需要做序列化，比如密码，比如上面的年龄？

> 解决办法：在字段面前加上 transient
```
  private String name;//需要序列化
    transient private int age;//不需要序列化
　　那么我们在反序列化的时候，打印出来的就是Person [name=vae, age=0]，整型数据默认值为 0 
```

* 问题2：序列化版本问题，在完成序列化操作后，由于项目的升级或修改，可能我们会对序列化对象进行修改，比如增加某个字段，那么我们在进行反序列化就会报错：

> 解决办法：在 JavaBean 对象中增加一个 serialVersionUID 字段，用来固定这个版本，无论我们怎么修改，版本都是一致的，就能进行反序列化了
```
private static final long serialVersionUID = 8656128222714547171L;
```

---

### 接口和抽象类该什么时候用

以操作数据库为例：
既然是操作数据库就必须会用到 Insert Update Select ，所以Insert Update Select 做成接口
但是，每个功能操作的内容又不一样，所以，做一个抽象类继承接口然后抽象类的派生类去实现抽象类的具体方法

面向对象,就是要把一些代码上的东西当成实体来理解.实体有本身的属性和行为.比如你这个对数据库的操作,你就要把数据库当做一个对象,其行为可以是增删改查.所以你应该声明一个类去进行这些操作.
当然,考虑到各种业务的特性,你还可以将这些类抽象出来,声明一个接口类,为数据库接口类.其实现类为各业务的具体操作..

* 1、接口是一组规则的集合，它规定了实现本接口的类或接口必须拥有的一组规则
* 2、抽象类和接口的区别在于使用动机。使用抽象类是为了代码的复用，而使用接口的动机是为了实现多态性。
假设有2个类，一个类是主力球员，一个类是替补球员。
```
1 public class NormalPlayer
2 {
3 　　public int ID
4 　　{
5 　　　　get;
6 　　　　set;
7 　　}
8 　　public string FirstName
9 　　{
10 　　　　get;
11 　　　　set;
12 　　}
13 　　public string LastName
14 　　{
15 　　　　get;
16 　　　　set;
17 　　}
18 　　public decimal WeekSalary
19 　　{
20 　　　　get;
21 　　　　set;
22 　　}
23 　　public string GetFullName()
24 　　{
25 　　　　return this.FirstName + “ “ + this.LastName;
26 　　}
27 　　public decimal GetDaySalary()
28 　　{
29 　　　　return WeekSalary / 7;
30 　　}
31 }
32 public class SubPlayer
33 {
34 　　public int ID
35 　　{
36 　　　　get;
37 　　　　set;
38 　　}
39 　　public string FirstName
40 　　{
41 　　　　get;
42 　　　　set;
43 　　}
44　　 public string LastName
45 　　{
46 　　　　get;
47 　　　　set;
48 　　}
49 　　public decimal MonthSalary
50 　　{
51 　　　　get;
52 　　　　set;
53 　　}
54 　　public string GetFullName()
55 　　{
56 　　　　return this.FirstName + “ “ + this.LastName;
57 　　}
58 　　public decimal GetWeekSalary()
59 　　{
60 　　　　return MonthSalary / 4;
61 　　}
62 }
```


我们发现，NormalPlayer和SubPlayer有共同的属性和方法，当然也有不同的属性和方法。把2个类的共同部分抽象出一个基类。
```
1 public class BasePlayer
2 {
3 　　public int ID
4 　　{
5 　　　　get;
6 　　　　set;
7 　　}
8 　　public string FirstName
9 　　{
10 　　　　get;
11 　　　　set;
12 　　}
13 　　public string LastName
14 　　{
15 　　　　get;
16 　　　　set;
17 　　}
18
19 　　public string GetFullName()
20 　　{
21 　　　　return this.FirstName + “ “ + this.LastName;
22 　　}
23 }
```


然后让先前的2个类派生于这个基类。
```
1 public class NormalPlayer: BasePlayer
2 {
3 　　public decimal WeekSalary
4 　　{
5 　　　　get;
6 　　　　set;
7 　　}
8 　　public decimal GetDaySalary()
9 　　{
10 　　　　return WeekSalary / 7;
11 　　}
12 }
13 public class SubPlayer : BasePlayer
14 {
15 　　public decimal MonthSalary
16 　　{
17 　　　　get;
18 　　　　set;
19 　　}
20 　　public decimal GetWeekSalary()
21　　 {
22 　　　　return MonthSalary / 4;
23 　　}
24 }
```


接着，我们发现NormalPlayer和SubPlayer计算日薪和周薪的方法也可以抽象出来，作为虚方法放到基类中
```
public class BasePlayer
{
　　public int ID
　　{
　　　　get;
　　　　set;
　　}
　　public string FirstName
　　{
　　　　get;
　　　　set;
　　}
　　public string LastName
　　{
　　　　get;
　　　　set;
　　}
　　public string GetFullName()
　　{
　　　　return this.FirstName + “ “ + this.LastName;
　　}
　　public virtual decimal GetSalary()
　　{
　　　　throw new NotImplementedException();
　　}
}
```


在NormalPlayer和SubPlayer这2个派生类中，需要重写基类的虚方法
```
public class NormalPlayer: BasePlayer
{
　　public decimal WeekSalary
　　{
　　　　get;
　　　　set;
　　}
　　//获取日薪
　　public override decimal GetSalary()
　　{
　　　　return WeekSalary / 7;
　　}
}
public class SubPlayer : BasePlayer
{
　　public decimal MonthSalary
　　{
　　　　get;
　　　　set;
　　}
　　//获取周薪
　　public override decimal GetSalary()
　　{
　　　　return MonthSalary / 4;
　　}
}
```


但在实际情况中，BasePlayer只是一个抽象出来的类，我们并不希望实例化这个类。这时候，就可以把BasePlayer设计为abstract抽象类。同时，在抽象类中，提供一个计算薪水的抽象方法。一旦在基类中声明了没有方法体的抽象方法，所有派生于这个抽象类的类必须实现或重写基类中的抽象方法。
查看源代码打印帮助
```
public abstract class BasePlayer
{
　　public int ID
　　{
　　　　get;
　　　　set;
　　}
　　public string FirstName
　　{
　　　　get;
　　　　set;
　　}
　　public string LastName
　　{
　　　　get;
　　　　set;
　　}
　　public string GetFullName()
　　{
　　　　return this.FirstName + “ “ + this.LastName;
　　}
　　public abstract decimal GetSalary();
}
```


由此可见，当2个或多个类中有重复部分的时候，我们可以抽象出来一个基类，如果希望这个基类不能被实例化，就可以把这个基类设计成抽象类
理解：
* 1、抽象类里面可以有非抽象方法但接口里只能有抽象方法 声明方法的存在而不去实现它的类被叫做抽像类（abstract class），它用于要创建一个体现某些基本行为的类，并为该类声明方法，但不能在该类中实现该类的情况。…
* 2、抽象类不能直接new对象，它只能被继承，而且单一继承。也就是说它把公共的东西抽象出来，子类可以调用父类的方法，也可以拓展自己的功能，就像子承父业一样。接口可以被多次继承，这是和抽象类的最大区别。也就是说接口是一个公共用品谁都可以拿来用的，不想抽象类，不是他的子类是不能调用的。希望对你有帮助
* 3、当描述一组方法的时候使用接口 当描述一个虚拟的物体的时候使用抽象类

### 线程的状态
Java线程的6种状态及切换(透彻讲解)

Java中的线程的状态分为6种。

* 1. 初始(NEW)：新创建了一个线程对象，但还没有调用start()方法。
* 2. 运行(RUNNABLE)：Java线程中将就绪（ready）和运行中（running）两种状态笼统的成为“运行”。
线程对象创建后，其他线程(比如main线程）调用了该对象的start()方法。该状态的线程位于可运行线程池中，等待被线程调度选中，获取cpu 的使用权，此时处于就绪状态（ready）。就绪状态的线程在获得cpu 时间片后变为运行中状态（running）。
* 3.阻塞(BLOCKED)：表线程阻塞于锁。
* 4.等待(WAITING)：进入该状态的线程需要等待其他线程做出一些特定动作（通知或中断）。
* 5.超时等待(TIME_WAITING)：该状态不同于WAITING，它可以在指定的时间内自行返回。
*  6. 终止(TERMINATED)：表示该线程已经执行完毕。

#### 一.线程的状态图
 
#### 二.初始状态
实现Runnable接口和继承Thread可以得到一个线程类，new一个实例出来，线程就进入了初始状态
#### 四.就绪状态
```
就绪状态只是说你资格运行，调度程序没有挑选到你，你就永远是就绪状态。
调用线程的start()方法，此线程进入就绪状态。
当前线程sleep()方法结束，其他线程join()结束，等待用户输入完毕，某个线程拿到对象锁，这些线程也将进入就绪状态。
当前线程时间片用完了，调用当前线程的yield()方法，当前线程进入就绪状态。
锁池里的线程拿到对象锁后，进入就绪状态。
```
#### 五.运行中状态
线程调度程序从可运行池中选择一个线程作为当前线程时线程所处的状态。这也是线程进入运行状态的唯一一种方式。
#### #### 六.阻塞状态
阻塞状态是线程阻塞在进入synchronized关键字修饰的方法或代码块(获取锁)时的状态。
#### 七.终止状态
```
当线程的run()方法完成时，或者主线程的main()方法完成时，我们就认为它终止了。这个线程对象也许是活的，但是，它已经不是一个单独执行的线程。线程一旦终止了，就不能复生。

在一个终止的线程上调用start()方法，会抛出java.lang.IllegalThreadStateException异常。
```
#### 八.等待队列(本是Object里的方法，但影响了线程)
```
调用obj的wait(), notify()方法前，必须获得obj锁，也就是必须写在synchronized(obj) 代码段内。
与等待队列相关的步骤和图

1.线程1获取对象A的锁，正在使用对象A。
2.线程1调用对象A的wait()方法。
3.线程1释放对象A的锁，并马上进入等待队列。
4.锁池里面的对象争抢对象A的锁。
5.线程5获得对象A的锁，进入synchronized块，使用对象A。
6.线程5调用对象A的notifyAll()方法，唤醒所有线程，所有线程进入同步队列。若线程5调用对象A的notify()方法，则唤醒一个线程，不知道会唤醒谁，被唤醒的那个线程进入同步队列。
7.notifyAll()方法所在synchronized结束，线程5释放对象A的锁。
8.同步队列的线程争抢对象锁，但线程1什么时候能抢到就不知道了。
```
#### 九.同步队列状态
当前线程想调用对象A的同步方法时，发现对象A的锁被别的线程占有，此时当前线程进入同步队列。简言之，同步队列里面放的都是想争夺对象锁的线程。
当一个线程1被另外一个线程2唤醒时，1线程进入同步队列，去争夺对象锁。
同步队列是在同步的环境下才有的概念，一个对象对应一个同步队列。
#### 十.几个方法的比较
```
Thread.sleep(long millis)，一定是当前线程调用此方法，当前线程进入TIME_WAITING状态，但不释放对象锁，millis后线程自动苏醒进入就绪状态。作用：给其它线程执行机会的最佳方式。
Thread.yield()，一定是当前线程调用此方法，当前线程放弃获取的cpu时间片，由运行状态变会就绪状态，让OS再次选择线程。作用：让相同优先级的线程轮流执行，但并不保证一定会轮流执行。实际中无法保证yield()达到让步目的，因为让步的线程还有可能被线程调度程序再次选中。Thread.yield()不会导致阻塞。
t.join()/t.join(long millis)，当前线程里调用其它线程t的join方法，当前线程进入TIME_WAITING/TIME_WAITING状态，当前线程不释放已经持有的对象锁。线程t执行完毕或者millis时间到，当前线程进入就绪状态。
obj.wait()，当前线程调用对象的wait()方法，当前线程释放对象锁，进入等待队列。依靠notify()/notifyAll()唤醒或者wait(long timeout)timeout时间到自动唤醒。
obj.notify()唤醒在此对象监视器上等待的单个线程，选择是任意性的。notifyAll()唤醒在此对象监视器上等待的所有线程。.
```
#### 十一.疑问
等待队列里许许多多的线程都wait()在一个对象上，此时某一线程调用了对象的notify()方法，那唤醒的到底是哪个线程？随机？队列FIFO？or sth else？java文档就简单的写了句：选择是任意性的（The choice is arbitrary and occurs at the discretion of the implementation）


### 继承
Java 继承继承的概念继承是java面向对象编程技术的一块基石，因为它允许创建分等级层次的类。
继承就是子类继承父类的特征和行为，使得子类对象（实例）具有父类的实例域和方法，或子类从父类继承方法，使得子类具有父类相同的行为。生活中的继承：
```
兔子和羊属于食草动物类，狮子和豹属于食肉动物类。
食草动物和食肉动物又是属于动物类。
所以继承需要符合的关系是：is-a，父类更通用，子类更具体。
虽然食草动物和食肉动物都是属于动物，但是两者的属性和行为上有差别，所以子类会具有父类的一般特性也会具有自身的特性。类的继承格式
在 Java 中通过 extends 关键字可以申明一个类是从另外一个类继承而来的，一般形式如下：
类的继承格式
```

class 父类 { } class 子类 extends 父类 { }为什么需要继承
接下来我们通过实例来说明这个需求。
```
开发动物类，其中动物分别为企鹅以及老鼠，要求如下：
企鹅：属性（姓名，id），方法（吃，睡，自我介绍）
老鼠：属性（姓名，id），方法（吃，睡，自我介绍）
企鹅类：

public class Penguin { private String name; private int id; public Penguin(String myName, int myid) { name = myName; id = myid; } public void eat(){ System.out.println(name+"正在吃"); } public void sleep(){ System.out.println(name+"正在睡"); } public void introduction() { System.out.println("大家好！我是" + id + "号" + name + "."); } }
老鼠类：

public class Mouse { private String name; private int id; public Mouse(String myName, int myid) { name = myName; id = myid; } public void eat(){ System.out.println(name+"正在吃"); } public void sleep(){ System.out.println(name+"正在睡"); } public void introduction() { System.out.println("大家好！我是" + id + "号" + name + "."); } }
```

从这两段代码可以看出来，代码存在重复了，导致后果就是代码量大且臃肿，而且维护性不高(维护性主要是后期需要修改的时候，就需要修改很多的代码，容易出错)，所以要从根本上解决这两段代码的问题，就需要继承，将两段代码中相同的部分提取出来组成 一个父类：
公共父类：
```
public class Animal { private String name; private int id; public Animal(String myName, int myid) { name = myName; id = myid; } public void eat(){ System.out.println(name+"正在吃"); } public void sleep(){ System.out.println(name+"正在睡"); } public void introduction() { System.out.println("大家好！我是" + id + "号" + name + "."); } }
```
这个Animal类就可以作为一个父类，然后企鹅类和老鼠类继承这个类之后，就具有父类当中的属性和方法，子类就不会存在重复的代码，维护性也提高，代码也更加简洁，提高代码的复用性（复用性主要是可以多次使用，不用再多次写同样的代码） 继承之后的代码：
```
企鹅类：

public class Penguin extends Animal { public Penguin(String myName, int myid) { super(myName, myid); } }
老鼠类：

public class Mouse extends Animal { public Mouse(String myName, int myid) { super(myName, myid); } }
```
继承类型
需要注意的是 Java 不支持多继承，但支持多重继承。
继承的特性

子类拥有父类非private的属性，方法。

子类可以拥有自己的属性和方法，即子类可以对父类进行扩展。

子类可以用自己的方式实现父类的方法。

Java的继承是单继承，但是可以多重继承，单继承就是一个子类只能继承一个父类，多重继承就是，例如A类继承B类，B类继承C类，所以按照关系就是C类是B类的父类，B类是A类的父类，这是java继承区别于C++继承的一个特性。

提高了类之间的耦合性（继承的缺点，耦合度高就会造成代码之间的联系越紧密，代码独立性越差）。继承关键字
继承可以使用 extends 和 implements 这两个关键字来实现继承，而且所有的类都是继承于 java.lang.Object，当一个类没有继承的两个关键字，则默认继承object（这个类在 java.lang 包中，所以不需要 import）祖先类。extends关键字
在 Java 中，类的继承是单一继承，也就是说，一个子类只能拥有一个父类，所以 extends 只能继承一个类。
extends 关键字

public class Animal { private String name; private int id; public Animal(String myName, String myid) { //初始化属性值 } public void eat() { //吃东西方法的具体实现 } public void sleep() { //睡觉方法的具体实现 } } public class Penguin extends Animal{ }implements关键字
使用 implements 关键字可以变相的使java具有多继承的特性，使用范围为类继承接口的情况，可以同时继承多个接口（接口跟接口之间采用逗号分隔）。
implements 关键字

public interface A { public void eat(); public void sleep(); } public interface B { public void show(); } public class C implements A,B { }super 与 this 关键字
super关键字：我们可以通过super关键字来实现对父类成员的访问，用来引用当前对象的父类。
this关键字：指向自己的引用。
实例
```
class Animal { void eat() { System.out.println("animal : eat"); } } class Dog extends Animal { void eat() { System.out.println("dog : eat"); } void eatTest() { this.eat(); // this 调用自己的方法 super.eat(); // super 调用父类方法 } } public class Test { public static void main(String[] args) { Animal a = new Animal(); a.eat(); Dog d = new Dog(); d.eatTest(); } }
输出结果为：

animal : eat
dog : eat
animal : eatfinal关键字
final 关键字声明类可以把类定义为不能继承的，即最终类；或者用于修饰方法，该方法不能被子类重写：

声明类：
final class 类名 {//类体}
```
声明方法：
修饰符(public/private/default/protected) final 返回值类型 方法名(){//方法体}
注:实例变量也可以被定义为 final，被定义为 final 的变量不能被修改。被声明为 final 类的方法自动地声明为 final，但是实例变量并不是 final构造器
子类是不继承父类的构造器（构造方法或者构造函数）的，它只是调用（隐式或显式）。如果父类的构造器带有参数，则必须在子类的构造器中显式地通过 super 关键字调用父类的构造器并配以适当的参数列表。
如果父类构造器没有参数，则在子类的构造器中不需要使用 super 关键字调用父类构造器，系统会自动调用父类的无参构造器。
实例
```
class SuperClass { private int n; SuperClass(){ System.out.println("SuperClass()"); } SuperClass(int n) { System.out.println("SuperClass(int n)"); this.n = n; } } class SubClass extends SuperClass{ private int n; SubClass(){ super(300); System.out.println("SubClass"); } public SubClass(int n){ System.out.println("SubClass(int n):"+n); this.n = n; } } public class TestSuperSub{ public static void main (String args[]){ SubClass sc = new SubClass(); SubClass sc2 = new SubClass(200); } }
输出结果为：
SuperClass(int n)SubClassSuperClass()SubClass(int n):200
```





