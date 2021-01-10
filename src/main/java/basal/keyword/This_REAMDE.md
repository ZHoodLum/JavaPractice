# 构造方法和this关键字
# 1、构造方法
## 构造方法（构造器，Constructor）定义
* 没有返回值
* 类名相同
* 有重载方法
* this调用

注：构造方法也是方法，但是它是特殊的方法而已，所有的对象都是通过构造器来创建的

## 创建构造方法的方式
类名 对象名 = new 构造方法（）;

## 构造器（构造方法/构造器，Constructor）特点
* 构造方法在对象实例化之后只调用一次，而普通方法再对象实例化之后可以多次调用
* 构造方法没有返回值声明
* 构造方法名必须与类相同的名称
* 不含返回值类型，也没有void
* 不能在方法中用return语句返回一个值

## 构造方法作用
构造方法用来完成对象的创建，即完成对象的实例化
>在Java中，每个类都至少要有一个构造器;
>一个类可以不写出构造方法，编译器会自动的给这个类增加一个构造器，
>该构造器没有任何参数，我们称之为“默认的空构造器”。
>编程者为该类定义了构造器，系统就不再提供默认的构造器

## 构造方法重载
构造方法可以像普通方法一样发生重载，通常一个类中不止一个构造方法，而是有多个不同参数的构造器，
用户可以根据需要选择不同的构造器创建对象;一般可以使用构造器来完成对成员变量的初始化。

有带参的构造器，那么不带参的空构造器不会自动产生；为了防止在某些情况下还想使用这样的无参数默认构造器，
因此最好还是养成写出这个无参数的构造器来，以备后用。

例如:
~~~java
public class Employee{
    int age;
    //默认构造方法/也叫无参构造方法
    public Employee(){
    }
    //有参构造方法
    public Employee(int age){
        this.age = age;
    }
}
~~~

---

# 2、关键字
## 关键字特点
在构造方法中，可以使用this或super调用变量、参数；
* this super只能出现在子类构造器中，且必须是第一行。若既没有this也没有super,则默认super();
* 创建子类时，必须调用父类构造器。

### super()
* 作用：调用父类的构造器
* 只能出现在子类的构造器中，且必须是第一行
* super()中的参数，决定了调用父类哪个构造器
* 如果子类构造器中没有出现super，那么编译器会默认加上super()，即调用父类的空构造器，如果父类没有空构造器，编译器提示错误。

### this()

* 作用：调用本类的构造器
* 只能写在构造器的第一行
* 在同一个构造器中super()和this()不能同时出现

### 样例 ThisKeyWord2
```java
public class ThisKeyWord2 {
    private String title;
    private double price;
    //getter setter

    public ThisKeyWord2(String t,double p){
        title = t;
        price = p;
    }

    public String getInfo(){
        return "书名：" +this.title+",价格："+price;
    }

    public static void main(String args[]){
        ThisKeyWord2 thisKeyWord2 = new ThisKeyWord2("java开发",89);
        System.out.println(thisKeyWord2.getInfo());
    }
}
/*
输出结果
书名：java开发，价格：89
*/
```

---

###上面的程序是有问题的，那么接下来我们研究一下这个方法
下面这个使用的是一个构造方法，而这个构造方法主要功能为title,price两个属性所使用，但是方法中的参数名称不好，而构造方法中的参数目的是为了类中的属性初始化，那么我们最好的做法就是将参数设置为属性名称 ，这样做事最好的。
### 将构造方法修改为一下形式
```java
public class ThisKeyWord2 {
    private String title;
    private double price;
    //getter setter

    public ThisKeyWord2(String title,double price){
        title = title;
        price = price;
    }

    public String getInfo(){
        return "书名：" +this.title+",价格："+price;
    }

    public static void main(String args[]){
        ThisKeyWord2 thisKeyWord2 = new ThisKeyWord2("java开发",89);
        System.out.println(thisKeyWord2.getInfo());
    }
}

/*
输出结果
书名：java开发，价格：89
*/
```
修改代码后，参数的作用是合理了，但是最终在构造方法传递的参数内容并没有传递到属性之中，在此构造方法中由局部变量，也有全部变量。如果现在属性名称与参数名称出现了重名的问题，没有加入任何限制，它都会取最近的“{ }”内的变量名称。所以在这种情况下，为了找到明确的变量，就要使用到this了。

---
```
public ThisKeyWord2(String title,double price){
        this.title = title;
        this.price = price;
}

输出结果
书名：java开发，价格：89
```
这样一来，this.title和this.price就会取类中的参数变量了。
以后的程序开发中，只要访问类中的属性，前面最好加上“this”关键字。

---

---

##特点
* 使用this()调用构造方法形式的代码只能放在构造方法的首行，放在构造方法的第一行。
* 构造方法能调用普通方法，但是普通方法无法调用构造方法。
* 进行构造方法互相调用的时候，一定要保留调用的出口。

## this表示当前对象
所谓的当前对象就是当前正在调用类中的方法的对象。
###样例ThisKeyWord3
```java
public class ThisKeyWord3 {
    public static void main(String args[]){
        ThisKeyWord1 thisKeyWord1 = new ThisKeyWord1();
        System.out.println("第1个对象"+thisKeyWord1);

        ThisKeyWord1 thisKeyWord11 = new ThisKeyWord1();
        System.out.println("第11个对象"+thisKeyWord11);
    }
}

/*
输出结果
第1个对象basal.keyword.ThisOrSuperKeyWord.BookObject@4554617c

第11个对象basal.keyword.ThisOrSuperKeyWord.BookObject@74a14482

两个关键字，表示开辟了两块对内存空间，存储地址也不同，输出的是存储地址。
*/
```

```java
public class ThisKeyWord3 {
    public static void main(String args[]){
        BookObject bookObject1 = new BookObject();
        System.out.println("第1个对象"+bookObject1);
        System.out.println("第1个this对象"+bookObject1);

        BookObject bookObject2 = new BookObject();
        System.out.println("第2个对象"+bookObject2);
        System.out.println("第2个this对象"+bookObject2);
    }
}

/**
第1个对象basal.keyword.ThisOrSuperKeyWord.BookObject@4554617c
第1个this对象basal.keyword.ThisOrSuperKeyWord.BookObject@4554617c

第2个对象basal.keyword.ThisOrSuperKeyWord.BookObject@74a14482
第2个this对象basal.keyword.ThisOrSuperKeyWord.BookObject@74a14482
此时的this，那个对象调用了print方法，this就自动于此对象指向同一块内存地址，this就是调用当前方法的对象。
*/
```


---
---
---

#总结 super与 this区别
##不同点：
* 调用：
>* super()主要是对父类构造函数的调用；
>* this()是对重载构造函数的调用
* 使用：
>* super()主要是在继承了父类的子类的构造函数中使用，是在不同类中的使用；
>* Super:当前父类引用
>* this()主要是在同一类的不同构造函数中的使用 ；
>* This:当前子类引用
##相同点：
super()和this()都必须在构造函数的第一行进行调用，否则就是错误的
##注：
> 构造函数是一种特殊的函数。其主要功能是用来在创建对象时初始化对象， 即为对象成员变量赋初始值，总与new运算符一起使用在创建对象的语句中。

>构造函数与类名相同，可重载多个不同的构造函数。在JAVA语言中，构造函数与C++语言中的构造函数相同，JAVA语言中普遍称之为构造方法。

>构造函数也叫构造方法，方法名必须与类名相同

>构造器最大的用处就是在创建对象时执行初始化，当创建一个对象时，系统会为这个对象的实例进行默认的初始化。
* 1、构造方法最特殊的地方在于，它不需要返回类型，这并不是说，它的返回类型是void，而是根本没有。
* 2、为了保证类字段（数据成员或属性）的初始化。
* 3、 构造方法作用就是对类进行初始化。

##思想：
假设没有构造方法，创建对象可能是这样的：
Apple apple = new Apple;
apple.initialize();
但是自从有了构造方法，就成了这样：
Apple apple = new Apple();

* 1、 直接在类名后面加了个圆括号，一举两得：既指明了类的名称，又调用了初始化方法。
* 2、坏处就是显得不伦不类：new后面怎么跟了个方法，不应该是个类吗？这也是构造方法的名称必须要和类名保持一致的原因，
* 3、创建对象必须指明是哪个类，同时还得调用构造方法，那干脆用类名做构造方法名好了，起别的名字人家怎么知道是哪个类？

#调用构造方法就是在创建对象，而创建对象同时也调用了构造方法，二者合一。


