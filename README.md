# JavaPractice
异常错误

### 一般报java.lang.NullPointerException的原因有以下几种： 
* 字符串变量未初始化； 
* 接口类型的对象没有用具体的类初始化，比如： 
```
List lt; 会报错 
List lt = new ArrayList(); 则不会报错了 
```
* 当一个对象的值为空时，你没有判断为空的情况。 
```
你可以试着把下面的代码前加一行代码： 
if(rb!=null);
..................
String类型的对象可以做如下判断
if(rb!==null&&!"".equals(rb)) 
……
当然还可以多做一个判断，是否不为空字符串
if(rb!==null&&!"".equals(rb.trim())) 
```
