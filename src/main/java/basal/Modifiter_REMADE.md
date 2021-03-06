# 修饰符


### Java语言提供了很多修饰符，主要分为以下两类：

* 访问修饰符
>* 默认的，也称为default，在同一包内可见，不使用任何修饰符。
>* 私有的，以private修饰符指定，在同一类内可见。
>* 共有的，以public修饰符指定，对所有类可见。
>* 受保护的，以protected修饰符指定，对同一包内的类和所有子类可见。

* 非访问修饰符
>* static修饰符，用来创建类方法和类变量。
>* final修饰符，用来修饰类、方法和变量，final修饰的类不能够被继承，修饰的方法不能被继承类重新定义，修饰的变量为常量，是不可修改的。
>* abstract修饰符，用来创建抽象类和抽象方法。
>* synchronized和volatile修饰符，主要用于线程的编程。

**Static与非Static区别：**
```
所有非Static属性必须产生实例化对象之后才可以访问，但是Static不受实例化的控制，也就是说，在没有产生实例化对象的情况下，依然可以使用Static属性。
```

**Static特征：**
```
虽然定义在类结构里面，但是并不受对象的控制，是独立于类存在的。
```

**那么我们什么时候使用Static属性，什么时候不使用Static属性呢？**
```
在编写类的过程中，你所选择首要的修饰符一定不是Static(95%情况下不写)。如果需要描述共享信息的情况下，使用Static(可以方便集体修改，可以不重复开辟内存空间的)。
```

---

### 静态方法
* 静态方法不需要实例化，可以直接访问，访问方式：
> 直接访问：类名.方法名()
> 实例化后访问：对象名.方法名() （不建议使用）

```
class Book{
	private String title;
	private double price;
	
	//这里使用static修饰属性
	private static String pub="清华大学出版社";
	public Book(String title,double price){
		this.title = title;
		this.price = price;
	}
	public static void setPub(String p){
		pub = p;
	}
	public String getInfo(){
		return this.title+","+this.price+","+this.pub;
	}
}

public class TestDemo{
	public static void main(String agrs[]){
		//在没有对象产生的时候进行调用操作
		Book.setPub("北京大学");
		Book ba = new Book("java",10.2);
		Book bb = new Book("cc",11.2);
		Book bc = new Book("aa",12.2);

		syso(ba.getInfo());
		syso(bb.getInfo());
		syso(bc.getInfo());
	}
}
输出：
java,10.2,北京大学
cc,10.2,北京大学
aa,10.2,北京大学
```
发现Static定义的属性和方法都不受实例化对象控制，也就说属于独立的类属性。

但是这个时候就会出现一个麻烦的问题：此时的类中的方法变成了两组：Static方法、非Static方法，两组方法间的访问也将受到限制：
* **static方法不能够直接访问属性或者方法，只能够调用static属性或方法。**
* 为什么会存在限制问题呢？
>* 所有的非static定义结构，必须在类已经明确的产生了实例化对象才会分配空间，才可以使用。
>* 所有的static定义的结构，不受实例化对象的控制，即：可以在没有实例化对象的时候访问。

* **非static方法可以访问static的属性或方法，不说任何的限制。**

**解决问题**
如果一个方法定义在主类中，并且由主方法调用
```
public static 返回值类型 方法名称(参数类型 参数，...){
	[return[返回值];]
}
```

接下来编写类的时候，发现方法定义的格式改变了（方法由对象调用）
```
public 返回值类型 方法名称(参数类型 参数，...){
	[return[返回值];]
}
```

观察如下代码解决问题：
```
public class TestDemo{
	pubblic static void main(String args[]){
		fun();
	}
	public static void fun(){
		syso("Hello world!!");
	}
}
输出：Hello world!!
```
如果此时fun()方法取消了static修饰符 ，那么就成为了非static方法。所有的非static方法必须由对象调用，此时static方法如果想要使用非static操作，必须产生对象才能进行调用。

所以代码改变成：
```
public class TestDemo{
	pubblic static void main(String args[]){
		new TestDemo.fun();
	}
	public static void fun(){
		syso("Hello world!!");
	}
}
输出：Hello world!!
```
* **与定义属性的规则一样，定义一个类的时候首先考虑非static方法，因为所有的类如果保存的信息多（属性多），那么每一一个对象执行同一个方法的时候，就可以利用static方法执行**
* 比如说一个类没有属性，产生对象就完全没有意义，所以就会使用static方法。
* 对象保存的是属性！！！

**static属性保存在全局数据区**
```
内存区一共有四个：栈内存、堆内存、全局数据区、全局代码区：

栈内存：存放地址；
堆内存：存放普通属性；
全局数据区：存放static数据；
全局代码区：存放方法；
```

---

####  静态变量
* 用static关键字定义的变量，与局部变量相比, static局部变量有三点不同：
> 1. 存储空间分配不同
auto类型分配在栈上，属于动态存储类别，占动态存储区空间，函数调用结束后自动释放， 而static分配在静态存储区，在程序整个运行期间都不释放，两者之间的作用域相同，但生存期不同。
> 2. static局部变量在所处模块在初次运行时进行初始化工作，且只操作一次。
> 3. 对于局部静态变量，如果不赋初值，编译期会自动赋初值0或空字符，而auto类型的初值是不确定的。(对于C++中的class对象例外, class的对象实例如果不初始化, 则会自动调用默认构造函数, 不管是否是static类型)

> 静态全局变量用来表示不能被其它文件访问的全局变量和函数。为了限制全局变量/函数的作用域，函数或变量前加static使得函数成为静态函数。但此处“static”的含义不是指存储方式，而是指对函数的作用域仅局限于本文件(所以又称内部函数)。注意：对于外部(全局)变量，不论是否有static限制，它的存储区域都是在静态存储区，生存期都是全局的。此时的static只是起作用域限制作用，限定作用域在本模块(文件)内部。

> 静态全局变量与全局变量的差别是：静态全局变量只能被同一源文件中的函数调用，其他文件中的函数不能调用静态全局变量

> 只`允许本源文件中`所有函数使用的全局变量，则该变量需要使用的存储类型是static。

### 静态语句块
* 一个类中由static关键字修饰的，不包含在任何方法体中的代码块
> 当类被载入时，静态代码块被执行，且只被执行一次

> 静态块经常用来进行类属性的初始化
#### final和static和abstract区别和使用
##### 一、static 修饰属性、方法和代码块

* 1.static修饰属性，这个属性就可以用类名.属性名来访问，也就是使这个属性成为本类的类变量，为本类对象所共有。这个属性就是全类公有。类加载的过程，类本身保存在文件中（字节码文件保存着类的信息）的，java会通过I/O流把类的文件（字节码文件）读入JVM（java虚拟机），这个过程称为类的加载过程。JVM（java虚拟机）会通过类路径（CLASSPATH）来找字节码文件。类变量，会在加载时自动初始化，初始化规则和实例变量相同。

特别：类中的实例变量是在创建对象时被初始化的，被static修饰的属性(类变量)，是在类加载时被创建并进行初始化，类加载的过程是进行一次。也就是类变量只会被创建一次。

* 2.static修饰方法（静态方法），会使这个方法成为整个类所公有的方法，可以用类名.方法名访问。

"类名.属性名"以及"类名.方法"访问举例：
```
class Test{

	public static String TEST_IP="静态ip127.0.0.1";
	public static void testMethod(){
	System.out.println("调用静态方法成功!");

}}

测试类

public class Test2{
	public static void main(String args[]){
	//1、通过类名.属性名调用
	System.out.println("调用的属性值："+Test.TEST_IP);
	Test.TEST_IP="新的ip127.0.0.1";//重新修改地址指向的值
	System.out.println("调用的属性值："+Test.TEST_IP);
	//2、调用静态方法
	Test test=new Test();
	test.testMethod();
}}
```
* 特别：
> （1）static修饰的方法，不直接能访问本类中的非静态(static)成员（包括方法和属性），本类的非静态方法可以访问本类的静态成员（包括方法和属性）静态方法要慎重使用(原因是静态变量会一直存在，占用资源)，且在静态方法中不能出现this关键字。
> （2）父类中是静态方法，子类中不能覆盖为非静态方法；在符合覆盖规则的前提下，在父子类中，父类中的静态方法可以被子类中的静态方法覆盖，但无多态。（在使用对象调用静态方法时，实则是调用编译时类型的静态方法）
> （3）父子类中，静态方法只能被静态方法覆盖，父子类中，非静态方法只能被非静态方法覆盖。
例：java中的main方法必须写成static的，因为在类加载时无法创建对象，静态方法可以不通过对象调用所以在类的main方法。 所在在类加载时就可以通过main方法入口来运行程序。

* 3.static修饰初始代码块，这时这个初始代码块就叫做静态初始代码块，该代码块只在类加载时被执行一次。 可以用静态初始代码块初始化一个类。动态初始代码块，写在类体中的“{}”，这个代码块是在生成对象的初始化属性是运行。这种代码块叫动态初始代码块。类在什么时候会被加载，创建对象时会加载类，调用类中静态方法或访问静态属性也是会加载类的。在加载子类时必会先加载父类，类加 载会有延迟加载原则，只有在必须加载时才会加载。

##### 二、final修饰变量、方法和类

* 1.final修饰变量:变量被final修饰，就会变成常量（常量应大写），一旦赋值不能改变（可以在初始化时直接赋值，也可以在构造方法里也可以赋值，
只能在这两种方法里二选一，必须为常量赋值）；final的常量不会有默认初始值，对于直接在初始化是赋值时final修饰符常和static修饰符一起使用。
* 2.final修饰方法，被final修饰的方法将不能被其子类覆盖，保持方法的稳定不能被覆盖。
* 3.final修饰类，被final修饰的类将不能被继承。final类中的方法也都是final的。

> 注意一：final，不能用来修饰构造方法，在父类中如果有常量属性，在子类中使用常量属性时是不会进行父类的类加载。对象一旦创建属性就不会改变。用final修饰属性，也用final修饰类（强不变模式），用final修饰属性（弱不变模式）。如：java.lang.String类，不变模式可以实现对象的共享（可以用一个对象实例赋值给多个对象变量）池化的思想，把需要共享的数据放在池中（节省资源空间，共享数据）
> 注意二：只有String类可以用“”中的字面值创建对象。在String类中，以字面值创建时，会到Java方法空间的串池空间中去查找，如果有就返 回串池中字符串的地址，并把这个地址付给对象变量。如果没有则会在串池里创建一个字符串对象，并返回其地址付购对象变量，当另一个以字面时，创建对象时则会重复上述过程。如果是new在堆空间中创建String类的对象，则不会有上述的过程。String类中的intern()方法会将在堆空间中创建的String类对象中的字符串和串池中的比对，如果有相同的串就返回这个串的串池中的地址。不变模式在对于对象进行修改，添加操作是相当麻烦的，它会产生很多的中间垃圾对象。创建和销毁的资源的开销是相当大的。这就是推荐大量使用StringBuffer，而不建议使用String的原因！String类在字符串连接时会先的效率很低，就是因为它所产生的对象的属性不能被修改的，当连接字符串时也就是只能创建新的对象。造成很多无用的资源开销和浪费！


##### 三、abstract修饰类和方法

* 1.abstract修饰类，使这个类成为一个抽象类，类将不能生成对象实例，但可以做为对象变量声明的类型，也就是编译时类型，抽象类就像当于一类的半成品，需要子类继承并覆盖其中的抽象方法。

* 2.abstract修饰方法，使这个方法变成抽象方法，即只有声明（定义）而没有实现，实现部分以";"代替。需要子类继承实现（覆盖）。

* 注意：
> （1）有抽象方法的类一定是抽象类。但是抽象类中不一定都是抽象方法，也可以全是具体方法。abstract修饰符在修饰类时必须放在类名前。 abstract修饰方法就是要求其子类覆盖（实现）这个方法。调用时可以以多态方式调用子类覆盖（实现）后的方法， 即抽象方法必须在其子类中实现，除非子类本身也是抽象类。
> （2）父类是抽象类，其中有抽象方法，那么子类继承父类，并把父类中的所有抽象方法都实现（覆盖）了，子类才有创建对象的实例的能 力，否则子类也必须是抽象类。抽象类中可以有构造方法，是子类在构造子类对象时需要调用的父类（抽象类）的构造方法。
> （3）不能放在一起的修饰符：final和abstract，private和abstract，static和abstract，因为abstract修饰的方法是必须在其子类中实现（覆盖），才能以多态方式调用，以上修饰符在修饰方法时期子类都覆盖不了这个方法，final是不可以覆盖，private是不能够继承到子类，所以也就不能覆盖，static是可以覆盖的，但是在调用时会调用编译时类型的方法，因为调用的是父类的方法，而父类的方法又是抽象的方法，又不能够调用，所以上的修饰符不能放在一起。
