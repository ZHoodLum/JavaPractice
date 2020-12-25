# 构造方法和关键字

### 静态static关键字
* static关键字可以修饰的元素
> 属性
	注意：只能修饰属性，不能修饰局部变量。
> 方法
> 代码块
* static修饰属性：
> 所有对象共享，称为静态变量或类变量
> 不用static修饰的属性称为实例变量
* static修饰方法：
> 不需要实例化，可以直接访问，称为静态方法或类方法
* static修饰语句块：
> 类中由static关键字修饰的，不包含在任何方法体中的代码块，称为静态代码块


### 静态属性
* 用static修饰的属性，它们在类被载入时创建，只要类存在，static变量就存在。
> 静态变量和非静态变量的区别是：静态变量被所有的对象所共享，在内存中只有一个副本，它当且仅当在类初次加载时会被初始化。而非静态变量是对象所拥有的，在创建对象的时候被初始化，存在多个副本，各个对象拥有的副本互不影响。

* 两种方式访问：
> 直接访问：类名.属性；
> 实例化后访问：对象名.属性 （不建议使用）
```
class Book{
	private String title;
	private double price;
	
	String pub="清华大学出版社";
	public Book(String title,double price){
		this.title = title;
		this.price = price;
	}
	public String getInfo(){
		return this.title+","+this.price+","+this.pub;
	}
}

public class TestDemo{
	public static void main(String agrs[]){
		Book ba = new Book("java",10.2);
		Book bb = new Book("cc",11.2);
		Book bc = new Book("aa",12.2);
		//修改了一个属性内容
		ba.pub = "北京大学";
		syso(ba.getInfo());
		syso(bb.getInfo());
		syso(bc.getInfo());
	}
}
输出：
java,10.2,北京大学
cc,10.2,清华大学出版社
aa,10.2,清华大学出版社
```
上面的这个程序：如果现在出现了100W个Book对象，但是要求所有的对象名称更换。那么就要修改100W个对象内容，所以如果将属性定义为普通属性，最终结果就是每一块对内存空间都将要保存各自的信息，这种的结果是不方便的。
进一步将，既然所有的pub内容都应该是一样的，那么就应该将其定义一个共有的同一pub属性，那么这种情况下，就可以使用static来定义属性。

```
class Book{
	private String title;
	private double price;
	
	//这里使用static修饰属性
	static String pub="清华大学出版社";
	public Book(String title,double price){
		this.title = title;
		this.price = price;
	}
	public String getInfo(){
		return this.title+","+this.price+","+this.pub;
	}
}

public class TestDemo{
	public static void main(String agrs[]){
		Book ba = new Book("java",10.2);
		Book bb = new Book("cc",11.2);
		Book bc = new Book("aa",12.2);
		//修改了一个属性内容
		ba.pub = "北京大学";
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
一旦再属性定义上，只要有一个对象修改了属性内容之后，所有的对象属性都会修改。
既然static是一个公共的概念，但是由一个对象可以修改所有对象的属性不太合适，所以正确的做法就是所有对象的公共的代表来进行访问，那么就是类，所以利用static定义的属性可以由类直接调用属性的。
```
//修改代码
Book.pub = "北京大学";
```
