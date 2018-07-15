# Java-Practice
关于java一些的日常练习
## 目录

[原码补码反码](#原码补码反码)

---
[循环练习题](#循环原练习题)

> [冒泡排序](#冒泡排序)

> [学学人家作弊](#学学人家作弊)

> [判定年份是否为闰年](#判定年份是否为闰年)

> [求大于200的最小质数](#求大于200的最小质数)

> [求1-100以内奇数和值](#求1-100以内奇数和值)

> [打印99表](#打印99表)

> [求水仙花数](#求水仙花数)

> [输出正三角形](#输出正三角形)

---
---

### 原码补码反码

唯一运算

数字与数字  是相加  6+6    加号为+
数字与字符串或字符串与数字    是连字符   +“6”  加号为连字符

switch语句  用char int 类型的
jdk7以前的版本 
可以用String类型 ，不过只有jdk7版本才可以用String 
ps:break  终止循环
变量的作用域与代码块{}有关  在当前代码块 或当前代码块内部的代码块中有效

### 循环练习题

####  冒泡排序 
> 使用冒牌排序，对A数组内数字进行由小到大排序
```
public static void main(String[] args) {
		//由小到大进行排序
		int[] a = {23,13,45,6,78,12,4,1};
		//冒泡排序
		//循环a.length次
		//循环次数 可以控制时间
		for(int j=0;j<a.length;j++){
			//1\最大值放在提取出来13 23 6 45 12 4 1 78
			//1\第二大放在提取出来13 6 23 12 4 1 45 78
			//每次排序进行比较
//			for(int i=0;i<a.length-1;i++) 加j与不加j区别  需要优化
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
	
	//arrays.sort排序
	Arrays.sort(a);
	for(int i=0;i<a.length;i++){
		System.out.print(a[i]+" ");
	}
```
>>* 思想：冒泡排序，主要使用双重for循环，第一层for循环，为了控制循环次数,j<a.length循环次数小于数组长度，否则会出现数组越界情况；
				for循环，为了比较数组内数组的大小，共对数组内数字比较a.length-1-j次。
				if语句循环，a[i]a[i+1]两两数进行比较，并互换位置。
####  学学人家作弊
> 输出空心正方形
```
public static void main(String[] args) {
		//开始作弊了昂
		//直接打印64个*   如果对8取余   换行		
		//使用数组
		int[] a = {
				1,1,1,1,1,1,1,1,
				1,0,0,0,0,0,0,1,
				1,0,0,0,0,0,0,1,
				1,0,0,0,0,0,0,1,
				1,0,0,0,0,0,0,1,
				1,0,0,0,0,0,0,1,
				1,0,0,0,0,0,0,1,
				1,1,1,1,1,1,1,1
				};
		for(int i=0;i<a.length;i++){
			if(a[i]==1){
				System.out.print("*");
			}else if(a[i]==0){
				System.out.print(" ");
			}
			if((i+1)%8==0){
				System.out.println();
			}
		}
	}
```
>>* 思想：使用数组（可以打印任何形状，缺点：太麻烦，大数值键盘会碎=。= ，无脑操作！），对数组进行定位a[i],若`a[i]==1`，则输出 ` *` ，则输出其他内容（自己定）使用`（i+1）%行数  `控制来行数。
#### 数值调换位置
> 输入四位整数1234  进行反转  4321
```
public static void main(String[] args) {
//		输入四位整数1234  进行反转  4321
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int sum=0;
		
		while(a!=0){
			/*
			 * 1234
			 * 4  321
			 */
			sum = a%10+sum*10;
			a = a/10;
		}
		System.out.println(sum);
	}
```
>> 思想：大部分第一时间都会想到：我可以将这些数按个位十位百位千位提炼出来，然后再依次放入对应的位置。我想说：方法很好，不错，但是你就没有想过优化一下嘛？来，让我们想想：每次取完位数，我们可以把它和对应位数互换，一次一次进行循环。
####  判定年份是否为闰年
>  编写程序，判断给定的某个年份是否是闰年。闰年的判断规则如下：（1）若某个年份能被4整除但不能被100整除，则是闰年。（2）若某个年份能被400整除，则也是闰年。
```
     public static void main(String[] args) {
	   System.out.println("请输入一个整数年份：");		
       for(;;){
			Scanner s = new Scanner(System.in);
			int a = s.nextInt();
			if(a%400==0){
				System.out.println("今年是闰年啊！");continue;
			}else if(a%4==0&&a%100!=0){
				System.out.println("今年是闰年啊！");continue;
			}else{
				System.out.println("不是闰年哦！！");continue;
			}
		}		
	}
```
####  求大于200的最小质数

```
public static void main(String[] args) {
	boolean f = true;
	for(int i=200;;i++) {
		for(int j=2;j<i;j++) {
			if(i%j == 0) {
				//如果找到一个i能被j整除，则不是质数
				f = false;
			}
		}
		if(f) {
			System.out.println("大于200的最小质数："+i);
			break;
		}
		f = true;
	}
}
```
####  求1-100以内奇数和值
>  编写程序求截止到某位数之前所有奇数的的和值。
```
public static void main(String[] args) {
		System.out.println("请输入一个正整数：");
		Scanner sr = new Scanner(System.in);
		int n = sr.nextInt();
		int s = 0;
		//此处为for循环的关键点，a+=2：求奇数
		for(int a = 1;a<=n;a+=2){
			s = s+a;	
		}
		System.out.println("截止到"+n+"所有奇数和为："+s);
	}
```
>>* 思想：输入一个数，求这个数范围内奇数和。我们需要去想，怎末才会得到奇数的问题，最后再把他们相加起来呢？奇数 = 1+2、3+2、5+2，
也就是说：起点为奇数，每次加2，结果得到下一位奇数，依次循环并相加这些奇数。提示：运用for循环。
#### 打印99表
>  利用for while dowhile循环打印 9*9  表?
```
public static void main(String[] args) {
		//for 循环行列进行打印
/*		for(int i=0;i<9;i++){
			
			for(int j=1;j<9;j++){
				System.out.print(" * ");
			}
			System.out.println(" * ");
		}
		System.out.println();
*/
		
		//while循环
		
/*		int i=0;
		while(i<9){
			i++;
			for(int j=1;j<9;j++){
				System.out.print(" * ");
			}
			System.out.println(" * ");
		}
*/	
		//do while循环
		int a = 1;
		int s = 0;
		do{
			a++;
			for(int j=1;j<9;j++){
				System.out.print(" * ");
			}
			System.out.println(" * ");
		}while(a<9);
	}
```
####  求水仙花数
> 5、输出所有的水仙花数，把谓水仙花数是指一个数3位数，其各各位数字立方和等于其本身，例如： 153 = 1*1*1 + 3*3*3 + 5*5*5  
```
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
		for(;;){
			System.out.print("请输入水仙花数值：");
			int a = sc.nextInt();
			
			int b = a/100;
			System.out.println("个位数为："+b);
			int c = (a/10)%10;
			System.out.println("十位数为："+c);
			int d = a%10;
			System.out.println("百位数为："+d);
			
			 if((b*b*b+c*c*c+d*d*d)== a){
				 System.out.println();
				 System.out.println("水仙花数为："+a);
			 }else{
				 System.out.println("不是水仙花数！");
				 System.out.println();
			 }continue;
		}
	}
```
>>* 思想：要判断是否为水仙花数，那么我就需要将这三位数提取出来，个位：a/100、十位:(a/10)%10、百位数:a%10 提炼出来，再进行计算。提示：根据求余进行计算。
####  输出正三角形
> 在屏幕上打印出n行的金字塔图案，如，若n=5,则图案如下：
        *
       ***
      *****
     *******
    *********
```
public static void main(String[] args) {
//			正三角形
			int l=5;
			for(int i=0;i<l;i++){

		        for(int j=0;j<l-1-i;j++){
		                System.out.print(" ");
		            }
		           
		        for( int j=0;j<2*i+1;j++){
		            System.out.print("*");
		        }
		               
		            System.out.println();
	        } 	
		}		
```



