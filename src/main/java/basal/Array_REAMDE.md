# 数组
## 一维数组
* 定义：数组是一种数据结构，用来存储`同一类型`值的集合,一组变量的集合，属于引用数据类型。在声明数组变量时，需要指出数组类型（数组元素类型紧跟[]和数组变量的名字）。

### 新增数组方式
###  1、声明并开辟数组：
>* 数组类型 数组名称[] = new 数组类型[长度];
>* 数组类型[] 数组名称  = new 数组类型[长度];（推荐）

在定义数组的同时进行赋值：
>* 数组类型[] 数组名称  = new 数组类型[]{值，值，值.......};

eg: 定义类型为Int长度为100的数组
```$xslt
int[] a = new int[100];
```
当数组开辟空间之后，就可以采用数组名称[下标|索引]的方式进行访问,数组长度为`数组名称.length-1`。
如果超出数组长度，就会报错：数组下标越界异常:ArrayIndexOutOfBoundsException。（一维数组一旦定义，长度固定。）

以上给出的数组定义结构使用的是动态初始化的方式。
	
###  2、分步完成：
> 声明数组：数组类型 数组名称 [] = null;
>
> 开辟数组：数组名称 = new 数组类型[长度];


## 初始化
其实在上面的案例中已经涉及到了数组的初始化，数组的初始化分为静态初始化、动态初始化以及默认初始化 
注：个人比较喜欢简化方法

* 动态初始化就是在创建过程中只是声明数组的大小，而由系统为数组分配值
```
int [] arrNum = new int[5];
int [] arrNum = new int[5];//简化方式
1
2
3
```

* 静态初始化　就是由程序员显式的指定每个数组元素的值
```
int [] arrNum1  = new int[]{1,2,3,4,5};
int[] arrNum1 = {1,2,3,4,5};//简化方式
```

##  数组遍历：
* for循环
```
	int[] a = {1,2,5,6,49};
	for(int i=0;i<a.length;i++){
		syso(a[i]);
	}
更多练习在[java练习题](#https://github.com/ZHoodLum/JavaPractice/blob/master/JAVA%E7%BB%83%E4%B9%A0%E9%A2%98.md)，二维数组排序等。
```

* 总结：
>* 数组中每个元素都是变量,也可以说是8中primitive主数据类型变量中的一种，不然就是引用变量。
>* 创建一个数字数组时，所有元素都初始化为0；一旦创建数组，就不能改变它的大小（尽管可以改变每一个数组元素）。
>* boolean数组的元素会初始化为`flase`,对象数组的元素则初始化为一个特殊值`null`,这表示数组还未存放任何对象。
>* java.lang.ArrayIndexOutOfBoundsException :异常而终止执行，报这种错误，我们称之为`数组下标越界`。
>* 若想获得数组中的元素个数，可以使用array`.length`。


## 二维数组
二维数组本质上是以数组作为数组元素的数组，即“数组的数组”，类型说明符 数组名[常量表达式][常量表达式]。二维数组又称为矩阵，行列数相等的矩阵称为方阵。对称矩阵a[i][j] = a[j][i]，对角矩阵：n阶方阵主对角线外都是零元素。

* 动态初始化：
> 数组类型 数组名称[][] = new 数组类型[行的个数][列的个数];
* 静态初始化：
> 数组类型 数组名称[][] = new 数组类型[行的个数][列的个数]{{值，值，值...}，{值，值，值...}，{值，值，值...}.......};
实际上就是多个一维数组组合而成的数组。

### 二维数组的遍历：
```java
package basal.ArrayStructure;
public class ArrayTest1 {
    public static void main(String[] args) {
        int data[][] = new int[][]
                {
                        {1, 2, 3},
                        {2, 3, 4, 5},
                        {9, 4, 7, 8}
                };
        //外层循环控制数组的数据行内容
        for (int x = 0; x < data.length; x++) {
            for (int y = 0; y < data[x].length; y++) {
                System.out.print(data[x][y] + "    ");
            }
            System.out.println();
        }
    }
}
```

## 数组与方法参数的传递
在之前的所有方法传递的数据几乎都是基本数据类型，那么除了基本数据类型之外，还可以传递数组，传递数组，一定要观察内存分配图。

注：冒泡排序,使用冒牌排序，对A数组内数字进行由小到大排序
```java
package basal.ArrayStructure;

public class BubbleSort {
    public static void main(String[] args) {
        //由小到大进行排序
        int[] a = {23,13,45,6,78,12,4,1};
        //冒泡排序
        //循环a.length次
        //循环次数 可以控制时间
        for(int j=0;j<a.length;j++){
            //1\最大值放在提取出来13 23 6 45 12 4 1 78
            //1\第二大放在提取出来13 6 23 12 4 1 45 78
            //每次排序进行比较 加j与不加j区别  需要优化
            for(int i=0;i<a.length-1-j;i++){
                if(a[i]>a[i+1]){
                    int temp = 0;
                    //a[i]  a[i+1] 进行位置互换
                    temp =a[i+1];
                    a[i+1]=a[i];
                    a[i]=temp;
                }
            }
        }
        //输出
        for(int n:a){
            System.out.print(n+"  ");
        }
    }
}
```
### 思想：冒泡排序，主要使用双重for循环，第一层for循环，为了控制循环次数,j<a.length循环次数小于数组长度，否则会出现数组越界情况； for循环，为了比较数组内数组的大小，共对数组内数字比较a.length-1-j次。 if语句循环，a[i]a[i+1]两两数进行比较，并互换位置。

## 实现一维数组的转置
（首位交换）
```
范例：
原始数组：1，2，3，4，5，6，7，8
转置后的数组：8，7，6，5，4，3，2，1
```

### 实现转置思路：
定义一个新的数组，将原始数组按照倒序的方式插入新的数组之中，虽有改变原始数组的引用。

```java
public class ArrayTranspose {
    public static void main (String args[]){
        int data[] = new int[]{1,2,3,4,5,6,7,8};
        //定义一个新的数组,数组长度与原始数组相同
        int temp[] = new int[data.length];

        //对于新的数组按照索引由小到大的顺序循环输出
        for(int x=0;x<temp.length;x++){
            temp[x] = data[temp.length - x - 1];
        }
        print(temp);
    }

    //专门定义一个输出的功能方法
    public static void print(int temp[]){
        for(int x=0;x<temp.length;x++){
//            System.out.print(temp[x]+",");

            /**
             * 强制转换
             * double > float > long > int > short > byte > char
             *
             * 隐式转换   JAVA自动转换
             * char  >  byte  > short >  int >  long  > float  > double
             *
             *
             * 注意：这里如果拼接的引号是单引号时： Java会把+号看成加法的加号，单引号里包裹的是一个char类型的字符
             * 自动触发隐式转换，所以会输出下面的内容格式
             * 52 51 50 49 48 47 46 45
             */
            System.out.print(temp[x]+',');
        }
    }
}
```
上面的操作达到了转置要求，但是有垃圾。建议不采用。

* 利用算法，在一个数组上完成转置操作
```
原始数组：1，2，3，4，5，6，7，8
第一次转置：`8`，2，3，4，5，6，7，`1`
第二次转置：8，`7`，3，4，5，6，`2`，1
第三次转置：8，7，`6`，4，5，`3`，2，1
第四次转置：8，7，6，`5`，`4`，3，2，1
由此可以判断出，它是由索引控制的，一个向上加的索引，一个向下减的索引。
与数组长度无关！！

转换次数=数组长度/2
```
### 实现方法：

```java
package basal.ArrayStructure;
public class ArrayTranspose2 {
    public static void main (String args[]){
        int data[] = new int[]{1,2,3,4,5,6,7,8};
        reverse(data);
        System.out.println("-----------------------");
        /**
         * 注意：下面print(data)方法操作是排过序之后的数组
         * 原因：除了基本类型boolean char  byte short int long  float double之外的数据类型都属于引用类型
         * 对象 数组都是引用类型
         *
         * 即Java中传递任何东西都是传值。
         * 如果传入方法的是基本类型的东西，你就得到此基本类型的一份拷贝。
         * 如果是传递引用，就得到引用的拷贝.
         */
        print(data);
    }
    //专门实现数组的转置操作
    public static void reverse(int arr[]){
        //转置次数
        int len = arr.length/2;
        //头部索引
        int head = 0;
        //尾部索引
        int tail = arr.length-1;
        for(int x=0;x<len;x++){
            int temp = arr[head];
            arr[head] = arr[tail];
            arr[tail] = temp;
            head++;
            tail--;
            print(arr);
        }
    }
    //专门定义一个输出的功能方法
    public static void print(int temp[]){
        for(int x=0;x<temp.length;x++){
            System.out.print(temp[x]+",");
        }
        System.out.println();
    }
}

```

### 实现二维数组的转置
前提：行跟列完全相同得到数组
```
原始数组：
1 2 3
4 5 6
7 8 9

经过转换需要得到数组：（需求）
1 4 7 
2 5 `8` 
3 `6` 9


分析：

第一次转置：
1 `4` 3
`2` 5 6
7 8 9
第二次转置：
1 4 `7` 
2 5 6
`9` 8 9
第三次转置：
1 4 7 
2 5 `8` 
3 `6` 9

```

观察转置的数组，中间对角线没有变，而且变得数据行数和列数是相同的。思想有点类似于冒泡排序

实现方法：
```java
public class ArrayDemo{
	public static void main (String args[]){
		int data[][] = new int[][]{
					{1,2,3},
					{4,5,6},
					{7,8,9}
					  };
		reverse(data);
		println(data);
	}
	//专门实现数组的转置操作
	public static void reverse(int arr[][]){
		for(int x=0;x<arr.length;x++){
			for(int y=x;y<arr[x].length;y++){
				//行和列相同，不进行交换
				if(x != y ){
					int temp = arr[x][y];
					arr[x][y] = arr[y][x];
					arr[y][x] = temp;
				}
			}
		}
	}
	//专门定义一个输出的功能方法
	public static void print(int temp[][]){
		for(int x=0;x<temp.length;x++){
			for(int y=0;y<temp[x].length;y++){
				System.out.print(temp[x][y]+'、');
			}
		}
		System.out.println();
	}
}
```


#### 匿名数组

实现方法：
```
package basal.ArrayStructure;
public class AnonymityArray {
    public static void main (String args[]){
        int data[] = init();
        print(data);
    }
    //匿名数组
    public static int[] init(){
        //重点关注方法的返回内容
        return new int[]{1,2,3,4,5};
    }
    public static void print(int temp[]){
        for(int x=0;x<temp.length;x++){
            System.out.print(temp[x]+",");
        }
        System.out.println();
    }
}

```
注：

init()方法返回的是一个数组，数组可以直接使用length取值长度，返回值可以直接拿来进行操作。

### 数组拷贝
System.arraycopy(原数组名称，原数组拷贝开始，目标数组名称，目标数组拷贝开始索引，长度);
```$xslt
public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
```
* src:源数组;  
>要被复制的数组
* srcPos:源数组要复制的起始位置; 
>是被复制的数字开始复制的下标
* dest:目的数组; 
>是目标数组，也就是要把数据放进来的数组
* destPos:目的数组放置的起始位置;
>是从目标数据第几个下标开始放入数据
* length:复制的长度.
>表示从被复制的数组中拿几个数值放到目标数组中

注意：src 和 dest都必须是同类型或者可以进行转换类型的数组

```
数组A：1，2，3，4，5，6，7，8，9
数组B：11，22，33，44，55，66，77，88
要求拷贝后的数组B：11，22，33，5，6，7，77，88
```

实现方法：
```
public class ArrayDemo{
	public static void main (String args[]){
		int A[] =  new int[]{1，2，3，4，5，6，7，8，9};
		int B[] =  new int[]{11，22，33，44，55，66，77，88};
		System.arraycopy(A,4,B,2,3);
	}
	public static void print(int temp[]){
		for(int x=0;x<temp.length;x++){
			System.out.print(temp[x]+'、');
		}
		System.out.println();
	}
}
```

### 数组的排序
java.util.Arrays.sort(数组名称)------------>升序

冒泡排序等等。

