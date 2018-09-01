#### 此处的java理解来源于各个网站的博客

[Java的四种引用方式](Java的四种引用方式)

[为什么使用抽象类？有什么好处？](#为什么使用抽象类有什么好处)

[Interface口extends口implement的区别](#Interface口extends口implement的区别)

[引用类型的强制类型转换](#引用类型的强制类型转换)

[序列化与反序列化](#序列化与反序列化)


---
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

### 接口和抽象类该什么时候用？

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



