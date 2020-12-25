## public static void main(String[ ] args){}方法说明

main方法是java程序的入口方法，JVM在运行程序时首先运行方法是main方法

---

### 分析。
* public： 
>* 声明方法为公有的，表明了任何对象和类都可以访问这个方法；JVM就可以调用这个方法了。
>
* static : 
>* 声明方法为静态方法，静态方法在类进行加载后就可以使用类名+方法名进行调用，
这对于main这个入口方法是很有用的。因为类刚进行加载不存在任何实例，只能使用`类名.main`进行调用。

* void： 
>* 声明方法没有返回值。
>为什么要使用void类型呢？因为main返回任何值对程序都没任何意义（main是最先执行的，不需要返回值）。

* main： 
>* main是JVM识别的特殊方法，即程序的入口方法，必须为main。

* String[] args : 
>* 字符串数组给开发人员在命令行状态下与程序交互提供了一种手段。
为什么使用数组呢？因为传入的参数可能多个，需要使用数组来存。args可以换，而String不可以换。

注：也可以这么写： public static void main String args[]{}     
* 数组声明方法：
> String args[] = {}
> String[] args = {}//建议这样写
>
`main方法`必须有`public static void`修饰，
也可以使用`final`或者`synchronized`来修饰，但是不能使用`abstract来修饰`，因为main方法是`入口方法`。
修饰符`顺序`可以变化。