# IO流操作
[TOP]

* [1. 文件管理的概述](#文件管理的概述)
* [2. 文件管理--File类](#文件管理--File类)
* [3. 流的概念](#流的概念)
* [4. 流操作常用方法](#流操作常用方法)
* [5. 流的概念](#流的概念)
---
字节输入流的主要方法
* [6. 字节输入流的主要方法](#字节输入流的主要方法)
* [7. FileInputStream的使用](#一、FileInputStream的使用)
* [8. FileInputStream构造方法](#FileInputStream构造方法)
* [9. FileInputStream的API方法](#FileInputStream的API方法)
* [10. FileInputStream测试用例](#FileInputStream测试用例)
* [11. ByteArrayInputStream的使用](#二、ByteArrayInputStream的使用)
* [12. ByteArrayInputStream字段摘要](#ByteArrayInputStream字段摘要)
* [13. ByteArrayInputStream构造方法摘要](#ByteArrayInputStream构造方法摘要)
* [14. ByteArrayInputStream的API方法摘要](#ByteArrayInputStream的API方法摘要)
* [15. ByteArrayInputStream测试用例](#ByteArrayInputStream测试用例)
---
字节输出流的主要方法
* [16. 字节输出流的主要方法](#字节输出流的主要方法)
* [17. FileOutputStream的使用](#一、FileOutputStream的使用)
* [18. FileOutputStream构造方法](#FileOutputStream构造方法)
* [19. FileOutputStream的API方法](#FileOutputStream的API方法)
* [20. FileOutputStream测试用例](#FileOutputStream测试用例)
* [21. ByteArrayOutputStream的使用](#二、ByteArrayOutputStream的使用)
* [22. ByteArrayOutputStream字段摘要](#ByteArrayOutputStream字段摘要)
* [23. ByteArrayOutputStream构造方法摘要](#ByteArrayOutputStream构造方法摘要)
* [24. ByteArrayOutputStream的API方法摘要](#ByteArrayOutputStream的API方法摘要)
---
缓冲输入输出字节流
* [25. 缓冲输入输出字节流](#缓冲输入输出字节流)
* [26. BufferedInputStream的使用](#一、BufferedInputStream的使用)
* [27. BufferedInputStream字段摘要](#BufferedInputStream字段摘要)
* [28. BufferedInputStream构造方法摘要](#BufferedInputStream构造方法摘要)
* [29. BufferedInputStream的API方法摘要](#BufferedInputStream的API方法摘要)
* [30. BufferedOutputStream使用](#二、BufferedOutputStream使用)
* [31. BufferedOutputStream字段摘要](#BufferedOutputStream字段摘要)
* [32. BufferedOutputStream构造方法摘要](#BufferedOutputStream构造方法摘要)
* [33. BufferedOutputStream的API方法摘要](#BufferedOutputStream的API方法摘要)
* [34. BufferedInputStream和BufferedOutputStream测试用例](#BufferedInputStream和BufferedOutputStream测试用例)
---
字符输入流的主要方法
* [35. 字符输入流的主要方法](#字符输入流的主要方法)
* [36. InputStreamReader的使用](#一、InputStreamReader的使用)
* [37. InputStreamReader构造方法摘要](#InputStreamReader构造方法摘要)
* [38. InputStreamReader的API方法摘要](#InputStreamReader的API方法摘要)
* [39. InputStreamReader测试用例](#InputStreamReader测试用例)
---
字符输出流的主要方法
* [40. 字符输出流的主要方法](#字符输出流的主要方法)
* [41. OutputStreamWriter的使用](#一、OutputStreamWriter的使用)
* [42. OutputStreamWriter构造方法摘要](#OutputStreamWriter构造方法摘要)
* [43. OutputStreamWriter的API方法摘要](#OutputStreamWriter的API方法摘要)
* [44. OutputStreamWriter测试用例](#OutputStreamWriter测试用例)
---
字符流之读写文件的操作FileReader和FileWriter
* [45. 字符流之读写文件的操作FileReader和FileWriter](#字符流之读写文件的操作FileReader和FileWriter)
* [45. 字符流之读写文件的操作FileReader和FileWriter][字符流之读写文件的操作FileReader和FileWriter]
* [46. FileReader的使用](#一、FileReader的使用)
* [47. FileReader构造方法摘要](#FileReader构造方法摘要)
* [48. FileReader的API方法](#FileReader的API方法)
* [49. FileReader测试用例](#FileReader测试用例)
* [50. FileWriter的使用](#二、FileWriter的使用)
* [51. FileWriter构造方法摘要](#FileWriter构造方法摘要)
* [52. FileWriter的API方法摘要](#FileWriter的API方法摘要)
* [53. FileWriter测试用例](#FileWriter测试用例)
---
字符流之读取缓冲类的操作BufferedReader和BufferedWriter
* [54. 字符流之读取缓冲类的操作BufferedReader和BufferedWriter](#字符流之读取缓冲类的操作BufferedReader和BufferedWriter)
* [55. BufferedReader的使用](#一、BufferedReader的使用)
* [56. BufferedReader构造方法摘要](#BufferedReader构造方法摘要)
* [57. BufferedReader的API方法摘要](#BufferedReader的API方法摘要)
* [58. BufferedReader测试用例](#BufferedReader测试用例)
* [59. BufferedWriter的使用](#二、BufferedWriter的使用 )
* [60. BufferedWriter构造方法摘要 ](#BufferedWriter构造方法摘要)
* [61. BufferedWriter的API方法摘要 ](#BufferedWriter的API方法摘要)
* [62. BufferedWriter测试用例 ](#BufferedWriter测试用例)

------------自行食用，以防中毒---------
* [63. 节点流与处理流的使用 ](#节点流与处理流的使用)
* [64. 节点流 ](#一、节点流)
* [65. 处理流 ](#二、处理流)

---
---
---

## 文件管理的概述
* Java中的对文件的管理，通过java.io包中的File类实现
* Java中文件的管理，主要是针对文件或是目录路径名的管理
>* 文件的属性信息
>* 文件的检查
>* 文件的删除等
>* 不包括文件的访问

## 文件管理--File类

* 通过将给定路径名字符串转换成抽象路径名来创建一个新 File 实例

```
File  变量名 = new File(String pathname);

File f1 = new File("d:\temp\abc.txt");
```

* 通过将给定File的uri转换成抽象路径名来创建一个新 File 实例

```
File  变量名 = new File(URL url);

File f2 = new File("abc.txt");
```

* 根据 parent 路径名字符串和 child 路径名字符串创建一个新 File 实例

```
File  变量名 = new File(String parent,String child);

File f3 = new File("d:/temp","abc.txt");
```

* 根据 parent 抽象路径名和 child 路径名字符串创建一个新 File 实例


```
File  变量名 = new File(File paent,String child);

File f = new File("d:/temp","abc.txt");
File f = new File(f,"abc.txt");
```

# 流操作常用方法
| 方法  | 含义  | 
| -------- | -------- |
boolean  createNewFile()|当且仅当不存在具有此抽象路径名指定的名称的文件时，原子地创建由此抽象路径名指定的一个新的空文件。
static File createTempFile(String prefix,String suffix) |在默认临时文件目录中创建一个空文件，使用给定前缀和后缀生成其名称
static File createTempFile(String prefix,Stirng suffix,File directory) |在指定目录中创建一个新的空文件，使用给定的前缀和后缀字符串生成其名称
boolean exists( ) |测试此抽象路径名表示的文件或目录是否存在
boolean delete( ) |删除此抽象路径名表示的文件或目录
boolean equals(Object obj) |测试此抽象路径名与给定对象是否相等
boolean canRead() |测试应用程序是否可以读取此抽象路径名表示的文件
boolean canWrite() |测试应用程序是否可以修改此抽象路径名表示的文件
String[] list( ) |返回由此抽象路径名所表示的目录中的文件和目录的名称所组成字符串数组
String getAbsolutePath( ) |返回抽象路径名的绝对路径名字符串
String getName( ) |返回由此抽象路径名表示的文件或目录的名称，不包括路径名称
String getPath( ) |将此抽象路径名转换为一个路径名字符串
File[] listFiles() |返回一个抽象路径名数组，这些路径名表示此抽象路径名所表示目录中的文件
boolean renameTo(File dest ) |重新命名此抽象路径名表示的文件
long length( ) |返回由此抽象路径名表示的文件的大小，以byte为单位
boolean mkdir( ) |创建此抽象路径名指定的目录
boolean mkdirs( ) |创建此抽象路径名指定的目录，包括创建必需但不存在的父目录。注意，如果此操作失败，可能已成功创建了一些必需的父目录


### 代码演示：
```java
package advanced.IO;

import java.io.File;

/**
 * @author：ZDY
 * @Date：Created in 2020/12/28
 * @Description:文件管理--File类
 */


public class FileTest {
    public static void main(String[] args) {
        /**
         * File这个类名起的有点歧义，他代表的不仅仅是文件，还有文件夹
         * 所以说FilePath这个名字更能体现出File的真实含义
         */
        String projectPath = System.getProperty("user.dir");

        File file = new File(projectPath + "\\src\\main\\resources\\IO");

        //文件夹是否存在
        if (!file.exists()) {//不存在
            //递归的创建文件夹
            file.mkdirs();
            System.out.println("创建文件夹成功！！");
            //如果说文件夹存在多级目录  使用file.mkdir()会报错
            // file.mkdir();
        }
        //如果文件夹存在  则证明可以获取信息
        else {
            //listFiles() 获取该文件夹下的所有文件信息
            File[] files = file.listFiles();
            for(File getFile:files){
                System.out.println("文件名称：" + getFile.getName() + "             文件路径：" + getFile.getPath() + "             是否是一个文件：" + getFile.isFile()+"             是否是一个文件夹：" + getFile.isDirectory());
            }
        }
    }
}

//输出
//文件名称：10、字节数组输出流ByteArrayOutputStream.flv             文件路径：E:\安装包\video\《JavaSE轻松入门高级教程》\10、字节数组输出流ByteArrayOutputStream.flv             是否是一个文件：true             是否是一个文件夹：false
```
---
---

##Java 流(Stream)、文件(File)和IO

Java 流(Stream)、文件(File)和IO
> Java.io包几乎包含了所有操作输入、输出需要的类。所有这些流类代表了输入源和输出目标。

> Java.io包中的流支持很多种格式，比如：基本类型、对象、本地化字符集等等。

> 一个流可以理解为一个数据的序列。输入流表示从一个源读取数据，输出流表示向一个目标写数据。

> Java为I/O提供了强大的而灵活的支持，使其更广泛地应用到文件传输和网络编程中。

> 但本节讲述最基本的和流与I/O相关的功能。我们将通过一个个例子来学习这些功能。

## 流的概念
* 流（Stream )的概念代表的是程序中数据的流通
* 数据流是一串连续不断的数据的集合
* 在Java程序中，对于数据的输入/输出操作是以流(Stream)的方式进行的
>* 输入流 — 流入程序的数据
>* 输出流 — 流出程序的数据
>* 在java程序中，从输入流读取数据（读到内存中），而从输出流输出数据（从内存存储到文件或显示到屏幕上）

* 流的分类
>* 按流的方向不同：输入流、输出流
>* 按处理数据的单位不同：字节流、字符流 
>* 按功能不同：节点流、处理流
>* 字节流：用于以字节为单位的输入输出，主要是处理以字节或二进制数据的各种输入输出，一般用于处理声音、图像等文件；
>* 字符流：用于以字符为单位的输入输出，主要用于处理字符或者文本类型的各种输入输出，一般用于读取以及网络文本信息的交互；

## Java语言中，控制数据流的 类都放在java.io包中

| 流  | 字节流  | 字符流  |
| -------- | -------- | -------- |
输入流祖先类|InputStream|Reader|
输出流祖先类|OutputStream|Writer|

* java.io包中有两大继承体系
>* 以字节流处理为主的Stream类，他们的命名方式是：XXXStream
>* 以字符处理为主的Reader/Writer，他们命名方式是：XXXReader或XXXWriter
* InputStream、OutputStream、Reader\Writer这四个类，是这两大继承体系的父类

---
---
---

## 流
![iopng](https://github.com/ZHoodLum/JavaPractice/blob/master/src/main/resources/images/io.png)

## 字节输入流的主要方法
* 此抽象类是表示`输入字节流`的所有类的超类

* java.lang.Object
>* java.io.InputStream所有已实现的接口：Closeable
>* 直接已知子类：AudioInputStream, ByteArrayInputStream, `FileInputStream`, FilterInputStream,` InputStream`, ObjectInputStream, PipedInputStream, SequenceInputStream, StringBufferInputStream
![inputStreampng](https://github.com/ZHoodLum/JavaPractice/blob/master/src/main/resources/images/inputStream.png)

---
### 一、FileInputStream的使用
> java.lang.Object
>> 继承者 java.io.InputStream
>>> 继承者 java.io.FileInputStream

* FileInputStream 从文件系统中的某个文件中获得输入字节。哪些文件可用取决于主机环境。 
* FileInputStream 用于读取诸如图像数据之类的原始字节流。要读取字符流，请考虑使用 FileReader。 

### FileInputStream构造方法
| 构造方法| 含义  |
| -------- | -------- | 
`FileInputStream(File file)`  |  通过打开一个到实际文件的连接来创建一个 FileInputStream，该文件通过文件系统中的 File 对象 file 指定。 
FileInputStream(FileDescriptor fdObj)  | 通过使用文件描述符 fdObj 创建一个 FileInputStream，该文件描述符表示到文件系统中某个实际文件的现有连接。 
`FileInputStream(String name)`  | 通过打开一个到实际文件的连接来创建一个 FileInputStream，该文件通过文件系统中的路径名 name 指定。 

> 注：其中处理文件的方法常用的比较多的是：FileInputStream(File file)和FileInputStream(String name)
* File file 类似于：
```
   File file = new File("E:\\安装包\\video\\《JavaSE轻松入门高级教程》\\FileInputStream.txt");
```
* String name 类似于：
```
FileInputStream fileInputStream = null;
fileInputStream = new FileInputStream("E:\\安装包\\video\\《JavaSE轻松入门高级教程》\\FileInputStream.txt");
```

### FileInputStream的API方法
| 方法| 含义  ||
| -------- | -------- |  -------- | 
int available() | 返回下一次对此输入流调用的方法可以不受阻塞地从此输入流读取（或跳过）的估计剩余字节数。|  
void close()  |关闭此文件输入流并释放与此流有关的所有系统资源。 | 
protected  void finalize()  |确保在不再引用文件输入流时调用其 close 方法。 | 
FileChannel getChannel()  |返回与此文件输入流有关的唯一 FileChannel 对象。 | 
FileDescriptor getFD() | 返回表 |示到文件系统中实际文件的连接的 FileDescriptor 对象，该文件系统正被此 FileInputStream 使用。|  
int read() 从此输入流中读取一个数据字节。 |  一次读取一个byte的数据，并以int类型把数据返 回来，如果没有数据可以读了，会返回”-1”
int read(byte[] buffer)  |从此输入流中将最多 b.length 个字节的数据读入一个 byte 数组中。 | 把所读取到的数据放在这个byte数组中，返回一 个int型的数据，这个int型数据存储了返回的真正 读取到的数据byte数
int read(byte[] buffer, int off, int len)  |从此输入流中将最多 len 个字节的数据读入一个 byte 数组中。 | 读取length个字节，并存储到一个字节数组buffer 中，并从offset位置开始返回实际读取的字节数
long skip(long n)  |从输入流中跳过并丢弃 n 个字节的数据。 | 
void mark(int readlimit)|在此输入流中标记当前的位置。| 
boolean markSupported()|测试此输入流是否支持 mark 和 reset 方法。| 
void reset()|将此流重新定位到最后一次对此输入流调用 mark 方法时的位置。| 


### FileInputStream测试用例
```java
package advanced.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author：ZDY
 * @Date：Created in 2020/12/28
 * @Description:字节流的输入操作
 */


public class FileInputStreamTest {
    public static void main(String[] args) throws IOException {
        String projectPath = System.getProperty("user.dir");

        File file = new File(projectPath + "\\src\\main\\resources\\IO\\FileInputStream.txt");

        FileInputStream fileInputStream = null;
        int num = 0;
        //需要抛异常，FileNotFoundException 主要是怕文件找不到
//        fileInputStream = new FileInputStream("E:\\安装包\\video\\《JavaSE轻松入门高级教程》\\FileInputStream.txt");
        fileInputStream = new FileInputStream(file);

        //需要抛异常 IOException(父异常  所以FileNotFoundException就没有了)   主要是怕读文件的是否很有可能会出问题   文件突然被删除  服务器挂机等等
        num = fileInputStream.read();
        while (num != -1) {
            System.out.print((char) num);
            num = fileInputStream.read();
        }
        /**
         * 注意  上面的程序如果说文件中由中文的话  会存在乱码的问题  后续在解决
         *  因为字节流是按照字节去读取文件的，而一个字节无法描述完整的一个杆子，所以会出现乱码的问题
         */
    }
}
//输出：
//ææ¯ä¸ä¸ªå­èæµ FileInputStream
```
---
### 二、ByteArrayInputStream的使用
> java.lang.Object
>> 继承者 java.io.InputStream
>>> 继承者 java.io.ByteArrayInputStream

* FileInputStream  输入源是`文件`
* ByteArrayInputStream 输入源是`字节数组`
* ByteArrayInputStream `包含一个内部缓冲区，该缓冲区包含从流中读取的字节`。内部计数器跟踪 read 方法要提供的下一个字节。 
* 关闭 ByteArrayInputStream 无效。此类中的方法在关闭此流后仍可被调用，而不会产生任何 IOException。

### ByteArrayInputStream字段摘要
| 方法| 含义  |
| -------- | -------- | 
protected  byte[] buf |由该流的创建者提供的 byte 数组。 
protected  int count  |比输入流缓冲区中最后一个有效字符的索引大一的索引。 
protected  int mark  |流中当前的标记位置。 
protected  int pos  |要从输入流缓冲区中读取的下一个字符的索引。 

### ByteArrayInputStream构造方法摘要
| 方法| 含义  |
| -------- | -------- | 
ByteArrayInputStream(byte[] buf) |创建一个 ByteArrayInputStream，使用 buf 作为其缓冲区数组。 
ByteArrayInputStream(byte[] buf, int offset, int length)|  创建 ByteArrayInputStream，使用 buf 作为其缓冲区数组。 

### ByteArrayInputStream的API方法摘要
| 方法| 含义  |
| -------- | -------- | 
int available() | 返回可从此输入流读取（或跳过）的剩余字节数。 
void close() | 关闭 ByteArrayInputStream 无效。 
void `mark`(int readAheadLimit) | 设置流中的`当前标记位置`。 
boolean markSupported() | 测试此 InputStream 是否支持 mark/reset。 
int read() | 从此输入流中读取下一个数据字节。 
int read(byte[] b, int off, int len) | 将最多 len 个数据字节从此输入流读入 byte 数组。 
void `reset() `| 将缓冲区的位置重置为`标记位置。 `
long skip(long n) | 从此输入流中跳过 n 个输入字节。 

### ByteArrayInputStream测试用例
```java
package advanced.IO;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Array;

/**
 * @author：ZDY
 * @Date：Created in 2020/12/28
 * @Description:字节流数组输入操作
 */


public class ByteArrayInputStreamTest {

    public static void main(String[] args) {
        String string = "hello world";
        byte[] bytes = string.getBytes();

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);

        int num = 0;

        //循环两次 目的是配合API使用mark()和reset()方法
        //mark() 设置流中的当前标记位置。
        //reset() 将缓冲区的位置重置为标记位置。
        //两者配合使用时的效果就是   mark标记的位置为标记为   使用reset() 再次读取该字节时，从标记位（mark()）开始读取
        for (int i = 0; i < 2; i++) {
            num = byteArrayInputStream.read();
            //-1代表读到文件末尾啦
            while (num != -1) {
                //第一次读取字符串时
                if (i == 0) {
                    System.out.print((char) num);
                }
                //当i=2时  为第二次循环 读取字符串
                else{
                    System.out.print(Character.toUpperCase((char) num));
                }
                //读取字符串
                num = byteArrayInputStream.read();
            }
            System.out.println("===========我是分割线===========");
            //当i=1时  第一次读完了   那么在我使用for循环第二次读取该字符串时
            //我想从最开头的位置读取  也就是从缓冲区最开始的位置读取
            //注：ByteArrayInputStream本身就是一个缓冲区
            byteArrayInputStream.reset();
        }
    }
}

//输出：
//hello world===========我是分割线===========
//HELLO WORLD===========我是分割线===========
```

---
---

## 字节输出流的主要方法
此抽象类是表示`输出字节流`的所有类的超类。输出流接受输出字节并将这些字节发送到某个接收器。

* java.lang.Object
 >*  java.io.OutputStream所有已实现的接口：Closeable, Flushable
 >* 直接已知子类：ByteArrayOutputStream, `FileOutputStream`, FilterOutputStream, ObjectOutputStream, `OutputStream`, PipedOutputStream
![outputStreampng](https://github.com/ZHoodLum/JavaPractice/blob/master/src/main/resources/images/outputStream.png)

### 一、FileOutputStream的使用
> java.lang.Object
>> 继承者 java.io.OutputStream
>>> 继承者 java.io.FileOutputStream

* 文件输出流是用于将数据写入 File 或 FileDescriptor 的输出流。文件是否可用或能否可以被创建取决于基础平台。特别是某些平台一次只允许一个 FileOutputStream（或其他文件写入对象）打开文件进行写入。在这种情况下，如果所涉及的文件已经打开，则此类中的构造方法将失败。 
* FileOutputStream 用于写入诸如图像数据之类的原始字节的流。要写入字符流，请考虑使用 FileWriter。

### FileOutputStream构造方法
| 构造方法| 含义  |
| -------- | -------- | 
`FileOutputStream(File file)` |创建一个向指定 File 对象表示的文件中写入数据的文件输出流。 
FileOutputStream(File file, boolean append) |创建一个向指定 File 对象表示的文件中写入数据的文件输出流。 
FileOutputStream(FileDescriptor fdObj) |创建一个向指定文件描述符处写入数据的输出文件流，该文件描述符表示一个到文件系统中的某个实际文件的现有连接。 
`FileOutputStream(String name) `|创建一个向具有指定名称的文件中写入数据的输出文件流。 
FileOutputStream(String name, boolean append) |创建一个向具有指定 name 的文件中写入数据的输出文件流。 
> 注：其中处理文件的方法常用的比较多的是：FileOutputStream(File file)和 FileOutputStream(String name)

### FileOutputStream的API方法
| 方法| 含义  |
| -------- | -------- | 
void write(byte[] buffer)| 将要输出的数组先放在一个byte数组中，然后用 这个方法一次把一组数据输出出去 
void write(byte[] buffer,int `off`,int len)| 将指定字节数组中从`偏移量 off` 开始的 len 个字节 写入此输出流 
abstract void write(int b)| 将指定的`字节`写入此输出流 
void close( )| 关闭此输出流并释放与此流有关的所有系统资源 
void flush( )| 刷新此输出流并强制写出所有缓冲的输出字节
protected  void finalize() |清理到文件的连接，并确保在不再引用此文件输出流时调用此流的 close 方法。 
FileChannel getChannel() |返回与此文件输出流有关的唯一 FileChannel 对象。 
FileDescriptor getFD() |返回与此流有关的文件描述符。 

### FileOutputStream测试用例
```java
package advanced.IO;

import java.io.*;

/**
 * @author：ZDY
 * @Date：Created in 2020/12/28
 * @Description:字节流输出操作
 */

public class FileOutputStreamTest {
    public static void main(String[] args) throws IOException {
        //要写入文件的字节
        String string = "we4rt5yuh,olsadfhansfniaWZcfiazivgfinfan";

        FileOutputStream fileOutputStream1 = null;
        FileOutputStream fileOutputStream2 = null;

        String projectPath = System.getProperty("user.dir");

        File file1 = new File(projectPath + "\\src\\main\\resources\\IO\\FileOutPutStream1.txt");
        File file2 = new File(projectPath + "\\src\\main\\resources\\IO\\FileOutPutStream2.txt");

        //判断文件是否存在 创建新的文件
        //创建新的文件  createNewFile
        //创建新的文件夹  mkdirs  或者 mkdir
        if (!file2.exists()) {
            file1.createNewFile();
            System.out.println("创建文件：" + file1);
        }
        if (!file1.exists()) {
            file2.createNewFile();
            System.out.println("创建文件：" + file2);
        }
        try {
            //抛异常 FileNotFoundException
            fileOutputStream1 = new FileOutputStream(file1);
            fileOutputStream2 = new FileOutputStream(file2);

            System.out.println("开始对流进行写的操作.....");
            //字符串转数组  然后根据API的方法直接写入
            byte[] bytes = string.getBytes();

            System.out.println("使用第1种方法写流......");
            //抛异常 IOException
            //使用API方法 void write(byte[] buffer)|
            fileOutputStream1.write(bytes);

            System.out.println("使用第2种方法写流......");
            //使用API方法 void write(byte[] buffer,int `off`,int len)  指定字节数组中从`偏移量 off` 开始的 len 个字节
            fileOutputStream2.write(bytes, 0, string.length());


            System.out.println("写入文件成功！！！");
        }
        //检测流是否为空   不为空的时候 关闭  防止资源浪费
        finally {
            if (fileOutputStream1 != null) {
                fileOutputStream1.close();
                System.out.println("关闭流操作fileOutputStream1");
            }
            if (fileOutputStream2 != null) {
                System.out.println("关闭流操作fileOutputStream2");
                fileOutputStream2.close();
            }
        }
    }
}

//输出：
//开始对流进行写的操作.....
//使用第1种方法写流......
//使用第2种方法写流......
//写入文件成功！！！
//关闭流操作fileOutputStream1
//关闭流操作fileOutputStream2
```

### 二、ByteArrayOutputStream的使用
> java.lang.Object
>> 继承者 java.io.OutputStream
>>> 继承者 java.io.ByteArrayOutputStream

* 此类实现了一个输出流，其中的数据被写入一个 byte 数组。缓冲区会随着数据的不断写入而自动增长。可使用 toByteArray() 和 toString() 获取数据。 
* 关闭 ByteArrayOutputStream 无效。此类中的方法在关闭此流后仍可被调用，而不会产生任何 IOException。 

### ByteArrayOutputStream字段摘要 
| 方法| 含义  |
| -------- | -------- | 
protected  byte[] buf |存储数据的缓冲区。 
protected  int count | 缓冲区中的有效字节数。 

### ByteArrayOutputStream构造方法摘要 
有参构造和无参构造

| 方法| 含义  ||
| -------- | -------- | -------- | 
ByteArrayOutputStream() | 创建一个新的 byte 数组输出流。 |创建一个新的 byte 数组输出流。缓冲区的容量最初是 32 字节，如有必要可增加其大小。 
ByteArrayOutputStream(int size) | 创建一个新的 byte 数组输出流，它具有指定大小的缓冲区容量（以字节为单位）。|创建一个新的 byte 数组输出流，它具有指定大小的缓冲区容量（以字节为单位）。参数：size - 初始大小。 抛出： IllegalArgumentException - 如果 size 为负。 

### ByteArrayOutputStream的API方法摘要 
| 方法| 含义  |
| -------- | -------- | 
void close() |关闭 ByteArrayOutputStream 无效。 
void reset()  |将此 byte 数组输出流的 count 字段重置为零，从而丢弃输出流中目前已累积的所有输出。 
int size()  | 返回缓冲区的当前大小。 
byte[] toByteArray()  |创建一个新分配的 byte 数组。 
String toString()  | 使用平台默认的字符集，通过解码字节将缓冲区内容转换为字符串。 
String toString(int hibyte)  |已过时。 此方法无法将字节正确转换为字符。从 JDK 1.1 开始，完成该转换的首选方法是通过 toString(String enc) 方法（使用一个编码名称参数），或 toString() 方法（使用平台的默认字符编码）。 
String toString(String charsetName)  |使用指定的 charsetName，通过解码字节将缓冲区内容转换为字符串。 
void write(byte[] b, int off, int len)  |将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此 byte 数组输出流。 
void write(int b)  |将指定的字节写入此 byte 数组输出流。 
void writeTo(OutputStream out)  |将此 byte 数组输出流的全部内容写入到指定的输出流参数中，这与使用 out.write(buf, 0, count) 调用该输出流的 write 方法效果一样。 

### ByteArrayOutputStream测试用例
```java
package advanced.IO;

import com.sun.beans.editors.ByteEditor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author：ZDY
 * @Date：Created in 2020/12/28
 * @Description:字节流数组输出操作
 */


public class ByteArrayOutputStreamTest {
    public static void main(String[] args) throws IOException {
        //开辟一块内存空间
        //初始容量默认32
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        //初始容量为自定义的值 64
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(64);

        String string = "hello world ！ any  nothing";
        byte[] bytes = string.getBytes();

        //需要抛异常 IOException
        //这句话就把字符串写到缓冲区中了
        byteArrayOutputStream.write(bytes);

        System.out.println("写进去的流：" + byteArrayOutputStream.toString());
        System.out.println("初始化为64的位操作的流：" + byteArrayOutputStream2.toString());

        System.out.println("=================那么如何获取的byte数组呢？=================");
        byte[] bytes1 = byteArrayOutputStream.toByteArray();
        //打印到控制台
        for (int i = 0; i < bytes1.length; i++) {
            System.out.print((char) bytes1[i]);
        }
    }
}
//输出：
//写进去的流：hello world ！ any  nothing
//初始化为64的位操作的流：
//=================那么如何获取的byte数组呢？=================
//hello world ￯ﾼﾁ any  nothing
```

## 缓冲输入输出字节流
### 一、BufferedInputStream的使用
> java.lang.Object
>> 继承者 java.io.InputStream
>>> 继承者 java.io.FilterInputStream
>>>> 继承者 java.io.BufferedInputStream

BufferedInputStream 为另一个输入流添加一些功能，即缓冲输入以及支持 mark 和 reset 方法的能力。在创建 BufferedInputStream 时，会创建一个内部缓冲区数组。在读取或跳过流中的字节时，可根据需要从包含的输入流再次填充该内部缓冲区，一次填充多个字节。mark 操作记录输入流中的某个点，reset 操作使得在从包含的输入流中获取新字节之前，再次读取自最后一次 mark 操作后读取的所有字节。 
### BufferedInputStream字段摘要 
| 方法| 含义  |
| -------- | -------- | 
protected  byte[] buf |  存储数据的内部缓冲区数组。 
protected  int count | 比缓冲区中最后一个有效字节的索引大 1 的索引。 
protected  int marklimit | 调用 mark 方法后，在后续调用 reset 方法失败之前所允许的最大提前读取量。 
protected  int markpos | 最后一次调用 mark 方法时 pos 字段的值。 
protected  int pos | 缓冲区中的当前位置。 

### BufferedInputStream构造方法摘要 
| 方法| 含义  || 
| -------- | -------- |  --------| 
BufferedInputStream(InputStream in) | 创建一个 BufferedInputStream 并保存其参数，即输入流 in，以便将来使用。|创建一个 BufferedInputStream 并保存其参数，即输入流 in，以便将来使用。创建一个内部缓冲区数组并将其存储在 buf 中。  
BufferedInputStream(InputStream in, int size) |  创建具有指定缓冲区大小的 BufferedInputStream 并保存其参数，即输入流 in，以便将来使用。 |创建具有指定缓冲区大小的 BufferedInputStream 并保存其参数，即输入流 in，以便将来使用。创建一个长度为 size 的内部缓冲区数组并将其存储在 buf 中。 

### BufferedInputStream的API方法摘要 
| 方法| 含义  |
| -------- | -------- |
int available()  |返回可以从此输入流读取（或跳过）、且不受此输入流接下来的方法调用阻塞的估计字节数。 
void close()  |关闭此输入流并释放与该流关联的所有系统资源。 
void mark(int readlimit)  |参见 InputStream 的 mark 方法的常规协定。 
boolean markSupported()  |测试此输入流是否支持 mark 和 reset 方法。 
int read()  |参见 InputStream 的 read 方法的常规协定。 
int read(byte[] b, int off, int len)  | 从此字节输入流中给定偏移量处开始将各字节读取到指定的 byte 数组中。 
void reset()  |参见 InputStream 的 reset 方法的常规协定。 
long skip(long n)  |参见 InputStream 的 skip 方法的常规协定。 

### 二、BufferedOutputStream使用
> java.lang.Object
>> 继承者 java.io.OutputStream
>>> 继承者 java.io.FilterOutputStream
>>>> 继承者 java.io.BufferedOutputStream

该类实现缓冲的输出流。通过设置这种输出流，应用程序就可以将各个字节写入底层输出流中，而不必针对每次字节写入调用底层系统。 

### BufferedOutputStream字段摘要 
| 方法| 含义  |
| -------- | -------- | 
protected  byte[] buf | 存储数据的内部缓冲区。 
protected  int count |  缓冲区中的有效字节数。 

### BufferedOutputStream构造方法摘要 
| 方法| 含义  || 
| -------- | -------- |  --------| 
BufferedOutputStream(OutputStream out) | 
创建一个新的缓冲输出流，以将数据写入指定的底层输出流。 |创建一个新的缓冲输出流，以将数据写入指定的底层输出流。
BufferedOutputStream(OutputStream out, int size) | 
创建一个新的缓冲输出流，以将具有指定缓冲区大小的数据写入指定的底层输出流。| 创建一个新的缓冲输出流，以将具有指定缓冲区大小的数据写入指定的底层输出流。 参数：out - 底层输出流。 size - 缓冲区的大小。 抛出： IllegalArgumentException - 如果 size <= 0
 
### BufferedOutputStream的API方法摘要 
| 方法| 含义  |
| -------- | -------- | 
void flush() | 刷新此缓冲的输出流。 
void write(byte[] b, int off, int len) | 将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此缓冲的输出流。 
void write(int b) | 将指定的字节写入此缓冲的输出流。 

### BufferedInputStream和BufferedOutputStream测试用例
```java
package advanced.IO;

import java.io.*;

/**
 * @author：ZDY
 * @Date：Created in 2020/12/28
 * @Description:主要测试的是 缓冲字节输入（BufferedInputStream）和输出（BufferedOutputStream）流
 * 使用缓冲字节流是  以空间换时间 的一个操作  因为开辟缓冲区是需要内存的   默认开辟8192个内存空间  去操作缓冲流
 */
public class BufferedputStream {

    public static void main(String[] args) throws IOException {
        //输入
        FileInputStream fileInputStream = null;
        //private static int DEFAULT_BUFFER_SIZE = 8192;  默认大小大概在8K这样
        BufferedInputStream bufferedInputStream = null;
        //输出
        FileOutputStream fileOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        //写入文件
        //file是真正和文件进行IO操作的
        //当前项目运行路径
        String projectPath = System.getProperty("user.dir");
        //fileInputStream = new FileInputStream("E:\\安装包\\video\\《JavaSE轻松入门高级教程》\\FileOutPutStream1.txt");
        fileInputStream = new FileInputStream(projectPath + "\\src\\main\\resources\\IO\\FileOutPutStream1.txt");

        //bufferedInputStream = new BufferedInputStream(fileInputStream);

        //这样创建就是一次性读取16384个字节  默认按照默认8192字节去读取文件
        //而buffered是每次和缓冲区（就是我们的字节数组 16384）进行交互  相比file来说  性能要好
        bufferedInputStream = new BufferedInputStream(fileInputStream,16384);

        //输出文件
        //如果单独使用file是每次都要向文件中write(int)个字节 都要进行IO操作
        fileOutputStream = new FileOutputStream(projectPath + "\\src\\main\\resources\\IO\\FileOutPutStream2.txt");
        //先向缓冲区写入字节 当缓冲区写满了 或者 文件数据写完，在将缓冲区的数据直接写入文件  减少IO操作次数
        bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        int num = 0;
        try {
            num = fileInputStream.read();

            while (num != -1) {
                //向文件FileOutPutStream2写数据
                bufferedOutputStream.write((char) num);
                //循环读取文件FileOutPutStream1
                num = fileInputStream.read();
            }
            //必须刷新  因为是缓冲流  如果缓冲区没有写满  则强制将缓冲区的数据写入文件
            bufferedOutputStream.flush();
            System.out.println("我读取文件FileOutPutStream1，向文件FileOutPutStream2写数据成功啦！！");
        }
        //用完流记得关闭
        //操作顺序是  由内向外关闭流操作  否则生成出来的文件有问题或者丢失数据
        finally {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
        }

    }
}
//我读取文件FileOutPutStream1，向文件FileOutPutStream2写数据成功啦！！
```

***
***
***
***

## 字符输入流的主要方法
用于读取（输入）字符流的抽象类。子类必须实现的方法只有 read(char[], int, int) 和 close()。但是，多数子类将重写此处定义的一些方法，以提供更高的效率和/或其他功能

* java.lang.Object
>* java.io.Reader所有已实现的接口：Closeable, Readable
>* 直接已知子类：BufferedReader, CharArrayReader, `FilterReader`,` InputStreamReader`, `PipedReader`, StringReader
![readerpng](https://github.com/ZHoodLum/JavaPractice/blob/master/src/main/resources/images/reader.png)

### 一、InputStreamReader的使用
> java.lang.Object
>> 继承者 java.io.Reader
>>> 继承者 java.io.InputStreamReader
* `InputStreamReader 是字节流通向字符流的桥梁`：它使用指定的 charset 读取字节并将其`解码为字符`。它使用的字符集可以由名称指定或显式给定，或者可以接受平台默认的字符集。 
* 每次调用 InputStreamReader 中的一个 `read() `方法都会导致从`底层输入流`读取一个或多个字节。要启用从字节到字符的有效转换，可以`提前从底层流读取更多的字节`，使其超过满足当前读取操作所需的字节。 
* 使用InputStreamReader()方法可以使字节流转换为字符流，具体详情查看下面的【InputStreamReader构造方法摘要 】标题内容
* 为了达到最高效率，可要考虑在 BufferedReader 内包装 InputStreamReader。例如： 
```aidl
 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
```
### InputStreamReader构造方法摘要 
| 方法| 含义  |参数|
| -------- | -------- | -------- | 
InputStreamReader(InputStream in) | 创建一个使用默认字符集的 InputStreamReader。 
InputStreamReader(InputStream in, Charset cs) |  创建使用给定字符集的 InputStreamReader。  |参数：in - InputStream，cs - 字符集
InputStreamReader(InputStream in, CharsetDecoder dec) |  创建使用给定字符集解码器的 InputStreamReader。|参数：in - InputStream，dec - 字符集解码器
InputStreamReader(InputStream in, String charsetName) | 创建使用指定字符集的 InputStreamReader。 |参数：in - InputStream ，charsetName - 受支持的 charset 的名称 ；抛出： UnsupportedEncodingException - 如果不支持指定的字符集

注：InputStreamReader(InputStream in) 这个构造方法使用默认字符集的 InputStreamReader；

如果想指定字符集：一般比较常用的构造方法InputStreamReader(InputStream in, String charsetName)，通过使用字符集charsetName，将字节解码为字符

### InputStreamReader的API方法摘要 
| 方法| 含义  |
| -------- | -------- | 
void close() | 关闭该流并释放与之关联的所有资源。 
String getEncoding() | 返回此流使用的字符编码的名称。 
int read() | 读取单个字符。 
int read(char[] cbuf, int offset, int length) | 将字符读入数组中的某一部分。 
boolean ready() | 判断此流是否已经准备好用于读取。 

### InputStreamReader测试用例
```java
package advanced.IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author：ZDY
 * @Date：Created in 2020/12/29
 * @Description:字符输入流
 * InputStreamReader 是字节流通向字符流的桥梁 ，字节转换为字符
 */


public class InputStreamReaderTest {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;

        try {
        //当前项目运行路径
        String projectPath = System.getProperty("user.dir");
        //fileInputStream = new FileInputStream("E:\\安装包\\video\\《JavaSE轻松入门高级教程》\\FileInputStream.txt");
        fileInputStream = new FileInputStream(projectPath + "\\src\\main\\resources\\IO\\FileInputStream.txt");
            

            //将 fileInputStream 作为参数传给 inputStreamReader 按照编码格式去读取文本，
            //fileInputStream去读取文本信息，但是每次处理都是inputStreamReader根据编码集的标准去处理文件信息
            //utf8中文按照每三个为一个字符去处理；  GBK中文按照每两个为一个字符去处理

            //手动指定编码集
            inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            //平台处理的可能会有问题 建议使用上面的
//            inputStreamReader = new InputStreamReader(fileInputStream);

            int num = 0;
            //与之前的比较分析一下 fileInputStream每次读取 一个字节 ； 而inputStreamReader每次读取的字节是按照编码集决定的  也就是UTF8读取三个  GBK读取两个
//            fileInputStream.read();
            //从第一个字开始读取文本
            num = inputStreamReader.read();
            while (num != -1) {
                System.out.print((char) num);
                //循环读取文本
                num = inputStreamReader.read();
            }
        }finally {
            //关闭流
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
        }
    }
}
//输出：
//是一个字节流 FileInputStream
//是一个字符流 FileInputStream
//你瞅瞅  我不乱码的了吧，我可以解码转换！！！！
```

#### Reader常用的方法

| 方法| 含义  |
| -------- | -------- | 
int read( )| 一次读取一个char的数据，并以int类型把数据返 回来，如果没有数据可以读了，会返回”-1” 
int read(char[] cbuffer) |把所读取到的数据放在这个char数组中，返回一 个int型的数据，这个int型数据存储了返回的真 正读取到的数据char数
int read(char[] cbuffer,int offset,int length)| 读取length个字符，并存储到一个字节数组 cbuffer中，并从offset位置开始返回实际读取的 字符数
void close( ) |关闭此Reader并释放与其关联的所有系统资源 
void mark(int readAheadLimit)|标记流中的当前位置。 
boolean markSupported()|判断此流是否支持 mark() 操作。
intread()|读取单个字符。
boolean ready()|判断是否准备读取此流。
void reset()|重置该流。
long skip(long n)|跳过字符
***

## 字符输出流的主要方法
写入（输出）字符流的抽象类。子类必须实现的方法仅有 write(char[], int, int)、flush() 和 close()。但是，多数子类将重写此处定义的一些方法，以提供更高的效率和/或其他功能。

* java.lang.Object
>*  java.io.Writer所有已实现的接口：Closeable, Flushable, Appendable
>* 直接已知子类：BufferedWriter, CharArrayWriter, FilterWriter,` OutputStreamWriter`, PipedWriter, `PrintWriter`, StringWriter
  
![writerpng](https://github.com/ZHoodLum/JavaPractice/blob/master/src/main/resources/images/writer.png)

### 一、OutputStreamWriter的使用
> java.lang.Object
>>  继承者 java.io.Writer
>>>  继承者 java.io.OutputStreamWriter
* `OutputStreamWriter 是字符流通向字节流的桥梁`：可使用指定的 charset 将要写入流中的字符编码成字节。它使用的字符集可以由名称指定或显式给定，` 否则将接受平台默认的字符集`。 
* 每次调用 write() 方法都会导致在给定字符（或字符集）上调用编码转换器。在写入底层输出流之前，得到的这些字节将在缓冲区中累积。可以指定此缓冲区的大小，不过，默认的缓冲区对多数用途来说已足够大。注意，传递给 write() 方法的字符没有缓冲。 
* 为了获得最高效率，可考虑将 OutputStreamWriter 包装到 BufferedWriter 中，以避免频繁调用转换器。例如： 
```aidl
 Writer out  = new BufferedWriter(new OutputStreamWriter(System.out));
```
* 代理对 是一个字符，它由两个 char 值序列表示：高 代理项的范围为 '\uD800' 到 '\uDBFF'，后跟范围为 '\uDC00' 到 '\uDFFF' 的低 代理项。 
* 错误代理元素 指的是后面不跟低代理项的高代理项，或前面没有高代理项的低代理项。 
* 此类总是使用字符集的默认替代序列 替代错误代理元素和不可映射的字符序列。如果需要更多地控制编码过程，则应该使用 CharsetEncoder 类。 

### OutputStreamWriter构造方法摘要 
| 方法| 含义  |参数 |
| -------- | -------- |  -------- | 
OutputStreamWriter(OutputStream out) | 创建使用默认字符编码的 OutputStreamWriter。 |out - OutputStream
OutputStreamWriter(OutputStream out, Charset cs) | 创建使用给定字符集的 OutputStreamWriter。 |out - OutputStream，cs - 字符集
OutputStreamWriter(OutputStream out, CharsetEncoder enc) | 创建使用给定字符集编码器的 OutputStreamWriter。 |out - OutputStream， enc - 字符集编码器
OutputStreamWriter(OutputStream out, String charsetName) | 创建使用指定字符集的 OutputStreamWriter。 |参数：out - OutputStream，charsetName - 受支持 charset 的名称 

### OutputStreamWriter的API方法摘要 
| 方法| 含义  |
| -------- | -------- | 
void close() | 关闭此流，但要先刷新它。 
void flush() | 刷新该流的缓冲。 
String getEncoding() | 返回此流使用的字符编码的名称。 
void write(char[] cbuf, int off, int len) | 写入字符数组的某一部分。 
void write(int c) |  写入单个字符。 
void write(String str, int off, int len) |  写入字符串的某一部分。 

### OutputStreamWriter测试用例
```java
package advanced.IO;

import java.io.*;

/**
 * @author：ZDY
 * @Date：Created in 2020/12/29
 * @Description:字符流输出操作 OutputStreamWriter 是字符流通向字节流的桥梁  将字符转换为字节
 */


public class OutputStreamReaderTest {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        String projectPath = System.getProperty("user.dir");
        try {
            fileOutputStream = new FileOutputStream(projectPath + "\\\\src\\\\main\\\\resources\\\\IO\\\\FileOutPutStream2.txt");

//            outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            //防止出现乱码的问题  指定字符集的编码格式
            outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
            String string = "马什么梅？马冬梅；什么冬梅？马冬梅；马什么梅？您歇着吧！好嘞！！";

            for (int i = 0; i < string.length(); i++) {
                outputStreamWriter.write(string.charAt(i));
            }
            //强制写入文件
            outputStreamWriter.flush();
        } finally {
            //关闭流  先关闭被调用的
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (outputStreamWriter != null) {
                //关闭流之前  会先执行flush方法
                outputStreamWriter.close();
            }
            System.out.println("关闭流成功！");
        }


    }
}
//输出
//关闭流成功！
```

### Writer 常用的方法
| 方法| 含义  |
| -------- | -------- | 
Writerappend(char c )| 将指定字符添加到此 writer。
Writerappend(CharSequence csq)| 将指定字符序列添加到此 writer。 
Writerappend(CharSequence csq, int start, int end)| 将指定字符序列的子序列添加到此 writer.Appendable。
abstract  void close(| )关闭此流，但要先刷新它。
abstract  void flush()| 刷新该流的缓冲。
void write(char[] cbuf)| 写入字符数组。
abstract  voidwrite(char[] cbuf, int off, int len)| 写入字符数组的某一部分。 
void write(int c)| 写入单个字符。 
void write(String str| 写入字符串。 
void write(String str, int off, int len)| 写入字符串的某一部分。

### 注：
当我们完成对流的读写时，应该通过调用close方法来关闭它，这个调用会释放掉十分有限的操作系统资源。
如果一个程序打开了很多的流而并没有关闭，那么这个操作系统的资源可能会被耗尽。关闭一个输出流的同时会冲刷用于该输出流的缓冲区：所有被临时置于缓冲区中，以便用更大的包的形式传递的字符在关闭输出流时都将被送出。
程序中打开的文件IO资源不属于内存里的资源，垃圾回收机制无法回收该资源，如果不关闭该资源，那么磁盘将一直被程序引用着，不能删除也不能修改。需要手动调用close()方法关闭。
如何保证IO正常关闭，需要使用try catch{} finally强制关闭。
***
***
## 字符流之读写文件的操作FileReader和FileWriter
了解了流操作的方法和File类的使用后，我们来看看如何访问一个 文件中的数据
* 在java.io包中，可以利用以下四种节点类来进行文件的访问 
>*  FileInputStream 
>*  FileOutputStream 
>*  `FileReader `
>*  `FileWriter`

### 一、FileReader的使用
> java.lang.Object
>> 继承者 java.io.Reader
>>> 继承者 java.io.InputStreamReader
>>>> 继承者 java.io.FileReader

* 用来读取字符文件的便捷类。此类的构造方法假定默认字符编码和默认字节缓冲区大小都是适当的。要自己指定这些值，可以先在 FileInputStream 上构造一个 InputStreamReader。 
* FileReader 用于读取字符流。要读取原始字节流，请考虑使用 FileInputStream。
* FileReader构造方法中没有指定编码集的方法，那么它的`编码集是平台默认的编码集，与平台编码一致`,这也是这个方法的缺点
### FileReader构造方法摘要 
| 方法 | 含义 |参数|抛出异常|
| -------- | -------- |-------- |-------- |
FileReader(File file) |在给定从中读取数据的 File 的情况下创建一个新 FileReader。 |file - 要从中读取数据的 File |FileNotFoundException - 如果文件不存在，或者它是一个目录，而不是一个常规文件，抑或因为其他某些原因而无法打开进行读取
FileReader(FileDescriptor fd) | 在给定从中读取数据的 FileDescriptor 的情况下创建一个新 FileReader。 |fd - 要从中读取数据的 FileDescriptor
FileReader(String fileName) |在给定从中读取数据的文件名的情况下创建一个新 FileReader |fileName - 要从中读取数据的文件的名称 |FileNotFoundException - 如果指定文件不存在，或者它是一个目录，而不是一个常规文件，抑或因为其他某些原因而无法打开进行读取。

### FileReader的API方法 
| 方法 | 含义 |
| -------- | -------- |
从类 java.io.InputStreamReader 继承的方法 |close, getEncoding, read, read, ready 
从类 java.io.Reader 继承的方法 |mark, markSupported, read, read, reset, skip 
从类 java.lang.Object 继承的方法 |clone, equals, finalize, getClass, hashCode, notify, notifyAll, toString, wait, wait, wait 

### FileReader测试用例
```java
package advanced.IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author：ZDY
 * @Date：Created in 2020/12/29
 * @Description:读文件的操作类
 * * 我们先回忆一下字符输入流的操作
 *  * 首先新建FileInputStream fileInputStream = new FileInputStream(projectPath + "\\src\\main\\resources\\IO\\FileInputStream.txt");
 *  * 然后将fileInputStream作为一个变量传给inputStreamReader
 *  * InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
 *  * 过程是这样去操作流的
 *  * 那么FileReader是怎么处理的呢？直接去操作文件  ，可以大大的简化代码量
 */
public class FileReaderTest {
    public static void main(String[] args) throws IOException {
        String projectPath = System.getProperty("user.dir");
        FileReader fileReader = null;
        try {
            //这样的filereader就可以直接去操作文件了   还可以处理中文
            fileReader = new FileReader(projectPath + "\\src\\main\\resources\\IO\\FileReader.txt");

            int num = 0;
            num = fileReader.read();
            while (num != -1) {
                System.out.print((char) num);
                num = fileReader.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileReader != null) {
                fileReader.close();
            }
        }

    }
}
//输出：
//今天是2020年12月29日
//徐州下雪了
//上海为什么不下雪？？？？？？？？
```

### 二、FileWriter的使用
> java.lang.Object
>>  继承者 java.io.Writer
>>>  继承者 java.io.OutputStreamWriter
>>>>  继承者 java.io.FileWriter

* 用来写入字符文件的便捷类。此类的构造方法假定默认字符编码和默认字节缓冲区大小都是可接受的。要自己指定这些值，可以先在 FileOutputStream 上构造一个 OutputStreamWriter。 
* 文件是否可用或是否可以被创建取决于底层平台。特别是某些平台一次只允许一个 FileWriter（或其他文件写入对象）打开文件进行写入。在这种情况下，如果所涉及的文件已经打开，则此类中的构造方法将失败。 
* FileWriter 用于写入字符流。要写入原始字节流，请考虑使用 FileOutputStream。 

### FileWriter构造方法摘要 
| 方法 | 含义 |参数|抛出异常|
| -------- | -------- |-------- |-------- |
FileWriter(File file) |根据给定的 File 对象构造一个 FileWriter 对象。 |file - 要写入数据的 File 对象。 |IOException - 如果该文件存在，但它是一个目录，而不是一个常规文件；或者该文件不存在，但无法创建它；抑或因为其他某些原因而无法打开它
FileWriter(File file, boolean append) |根据给定的 File 对象构造一个 FileWriter 对象。|file - 要写入数据的 File 对象; append - 如果为 true，则将字节写入文件末尾处，而不是写入文件开始处 |IOException - 如果该文件存在，但它是一个目录，而不是一个常规文件；或者该文件不存在，但无法创建它；抑或因为其他某些原因而无法打开它  
FileWriter(FileDescriptor fd) |构造与某个文件描述符相关联的 FileWriter 对象。 |fd - 要写入数据的 FileDescriptor 对象。 |
FileWriter(String fileName) |根据给定的文件名构造一个 FileWriter 对象。 |fileName - 一个字符串，表示与系统有关的文件名。  |IOException - 如果指定文件存在，但它是一个目录，而不是一个常规文件；或者该文件不存在，但无法创建它；抑或因为其他某些原因而无法打开它
FileWriter(String fileName, boolean append) | 根据给定的文件名以及指示是否附加写入数据的 boolean 值来构造 FileWriter 对象。| fileName - 一个字符串，表示与系统有关的文件名。 append - 一个 boolean 值，如果为 true，则将数据写入文件末尾处，而不是写入文件开始处。| IOException - 如果指定文件存在，但它是一个目录，而不是一个常规文件；或者该文件不存在，但无法创建它；抑或因为其他某些原因而无法打开它
### FileWriter的API方法摘要 
| 方法 | 含义 |
| -------- | -------- |
从类 java.io.OutputStreamWriter 继承的方法 |close, flush, getEncoding, write, write, write 
从类 java.io.Writer 继承的方法 |append, append, append, write, write 
从类 java.lang.Object 继承的方法 |clone, equals, finalize, getClass, hashCode, notify, notifyAll, toString, wait, wait, wait 

### FileWriter测试用例
```java
package advanced.IO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author：ZDY
 * @Date：Created in 2020/12/29
 * @Description:写文件字符流，编码集与系统编码默认一致
 */

public class FileWriterTest {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = null;
        String projectPath = System.getProperty("user.dir");

        try {
            fileWriter = new FileWriter(projectPath + "\\src\\main\\resources\\IO\\FileWriter.txt");
            String writerString = "啦啦啦啦 我是卖报的小行家；你kin你擦";

            for (int i = 0; i < writerString.length(); i++) {
                fileWriter.write(writerString.charAt(i));
            }
            //强制写入
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭流要严谨  不为空才关闭
            if (fileWriter != null) {
                fileWriter.close();
            }
        }
    }
}
//输出到文件的内容是：
//啦啦啦啦 我是卖报的小行家；你kin你擦
```

## 字符流之读取缓冲类的操作BufferedReader和BufferedWriter
### 一、BufferedReader的使用
> java.lang.Object
>> 继承者 java.io.Reader
>>> 继承者 java.io.BufferedReader
* 所有已实现的接口： Closeable, Readable 
* 直接已知子类： LineNumberReader 

* 从字符输入流中读取文本，缓冲各个字符，从而实现字符、数组和行的高效读取。 
* 可以指定缓冲区的大小，或者可使用默认的大小。大多数情况下，默认值就足够大了。 
* 通常，Reader 所作的每个读取请求都会导致对底层字符或字节流进行相应的读取请求。因此，建议用 BufferedReader 包装所有其 read() 操作可能开销很高的 Reader（如 FileReader 和 InputStreamReader）。例如， 
```aidl
 BufferedReader in  = new BufferedReader(new FileReader("foo.in"));
```
* 将缓冲指定文件的输入。如果没有缓冲，则每次调用 read() 或 readLine() 都会导致从文件中读取字节，并将其转换为字符后返回，而这是极其低效的。 
* 通过用合适的 BufferedReader 替代每个 DataInputStream，可以对将 DataInputStream 用于文字输入的程序进行本地化。

### BufferedReader构造方法摘要 
| 方法 | 含义 |参数|抛出异常
| -------- | -------- | -------- | -------- |
BufferedReader(Reader in) |创建一个使用默认大小输入缓冲区的缓冲字符输入流。| in - 一个 Reader
BufferedReader(Reader in, int sz) |创建一个使用指定大小输入缓冲区的缓冲字符输入流。 |in - 一个 Reader，sz - 输入缓冲区的大小|IllegalArgumentException - 如果 sz <= 0 


### BufferedReader的API方法摘要 
| 方法 | 含义 |
| -------- | -------- |
void close() | 关闭该流并释放与之关联的所有资源。 
void mark(int readAheadLimit)|  标记流中的当前位置。 
boolean markSupported() | 判断此流是否支持 mark() 操作（它一定支持）。 
int read() |读取单个字符。 
int read(char[] cbuf, int off, int len) |将字符读入数组的某一部分。 
String readLine() | 读取一个文本行。 
boolean ready() | 判断此流是否已准备好被读取。 
void reset() |将流重置到最新的标记。 
long skip(long n) | 跳过字符。 

### BufferedReader测试用例
```java
package advanced.IO;

import java.io.*;

/**
 * @author：ZDY
 * @Date：Created in 2020/12/29
 * @Description:
 */


public class BufferedReaderTest {
    //为了方便   使用InputStreamReader   自定义指定编码集
    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        FileInputStream fileInputStream = null;

        String projectPath = System.getProperty("user.dir");
        try {
            fileInputStream = new FileInputStream(projectPath + "\\src\\main\\resources\\IO\\BufferedReader.txt");
            inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");

            //这里面的1000 指的是缓冲区大小
            bufferedReader = new BufferedReader(inputStreamReader, 1000);

            //标记位   供reset()方法使用  与字节流不同  字节流reset()默认位置为文件开头位置
            //这里面的1000  一定要比文件大小要大  否则会抛异常
            bufferedReader.mark(1000);

            //两种方式去读文件
            //第一种方法  使用read()方法
            System.out.println("第一种方法  使用read()方法");
            int num = 0;
            num = bufferedReader.read();
            while (num != -1) {
                System.out.print((char) num);
                num = bufferedReader.read();
            }
            System.out.println(" ");
            System.out.println(" ");


            //第二种方法 使用readLine()方法
            System.out.println("第二种方法 使用readLine()方法");
            //注意 ****** 这里需要手动的marked 否则会抛异常java.io.IOException: Stream not marked******
            //重置  从文件开头开始读取文件
            bufferedReader.reset();
            //开始读取第一行
            String string = bufferedReader.readLine();
            //readLine判断其是否为空  不为空继续读，与read方法不一样  read方法读取文件末尾会返回-1
            while (string != null) {
                System.out.println(string);
                string = bufferedReader.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
    }

    //使用FileReader方法的同时  也要注意文件与平台程序的编码一致性  否则会乱码
    //乱码的解决方式可以使用InputStreamReader方法  自定义执行编码集  方法如上面所示
    public static void main2(String[] args) throws IOException {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        String projectPath = System.getProperty("user.dir");
        try {
            fileReader = new FileReader(projectPath + "\\src\\main\\resources\\IO\\BufferedReader.txt");
            //这里面的1000 指的是缓冲区大小
            bufferedReader = new BufferedReader(fileReader, 1000);

            //两种方式去读文件
            //第一种方法  使用read()方法
            System.out.println("第一种方法  使用read()方法");
            int num = 0;
            num = bufferedReader.read();
            while (num != -1) {
                System.out.print((char) num);
                num = bufferedReader.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileReader != null) {
                fileReader.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
    }

}
//输出
//第一种方法  使用read()方法
//啊啊啊啊啊啊啊啊啊啊啊啊啊
//啦啦啦啦啦啦啦啦啦
//巴啦啦小魔仙全身边 乌拉拉黑暗之神
//启动后备隐藏能源
//你kin你擦！！！！！！！！！！！！！！！！ 
 
//第二种方法 使用readLine()方法
//啊啊啊啊啊啊啊啊啊啊啊啊啊
//啦啦啦啦啦啦啦啦啦
//巴啦啦小魔仙全身边 乌拉拉黑暗之神
//启动后备隐藏能源
//你kin你擦！！！！！！！！！！！！！！！！
```

### 二、BufferedWriter的使用 
> java.lang.Object
>> 继承者 java.io.Writer
>>> 继承者 java.io.BufferedWriter
* 所有已实现的接口： Closeable, Flushable, Appendable

* 将文本写入字符输出流，缓冲各个字符，从而提供单个字符、数组和字符串的高效写入。 
* 可以指定缓冲区的大小，或者接受默认的大小。在大多数情况下，默认值就足够大了。 
* 该类提供了 newLine() 方法，它使用平台自己的行分隔符概念，此概念由系统属性 line.separator 定义。并非所有平台都使用新行符 ('\n') 来终止各行。因此调用此方法来终止每个输出行要优于直接写入新行符。 
* 通常 Writer 将其输出立即发送到底层字符或字节流。除非要求提示输出，否则建议用 BufferedWriter 包装所有其 write() 操作可能开销很高的 Writer（如 FileWriters 和 OutputStreamWriters）。例如， 
```aidl
 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("foo.out")));
```
 * 将缓冲 PrintWriter 对文件的输出。如果没有缓冲，则每次调用 print() 方法会导致将字符转换为字节，然后立即写入到文件，而这是极其低效的。
 
 ### BufferedWriter构造方法摘要
| 方法 | 含义 |参数
| -------- | -------- |-------- |
BufferedWriter(Writer out)| 创建一个使用默认大小输出缓冲区的缓冲字符输出流。 |out - 一个 Writer
BufferedWriter(Writer out, int sz) | 创建一个使用给定大小输出缓冲区的新缓冲字符输出流。 |out - 一个 Writer ， sz - 输出缓冲区的大小，是一个正整数 

### BufferedWriter的API方法摘要 
| 方法 | 含义 |
| -------- | -------- |
void close() |关闭此流，但要先刷新它。 
void flush() | 刷新该流的缓冲。 
void newLine() |写入一个行分隔符。 
void write(char[] cbuf, int off, int len) |写入字符数组的某一部分。 
void write(int c) |写入单个字符。 
void write(String s, int off, int len) |写入字符串的某一部分。 

### BufferedWriter测试用例
```java
package advanced.IO;

import java.io.*;

/**
 * @author：ZDY
 * @Date：Created in 2020/12/29
 * @Description:通过缓冲流写文件
 * 接下来的示例是拷贝文件，文件拷贝
 */


public class BufferedWriterTest {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        String projectPath = System.getProperty("user.dir");

        try {
            //读取当前的JAVA的文件
            fileReader = new FileReader(projectPath +"\\src\\test\\java\\advanced\\IO\\BufferedWriterTest.java");
            //像文件 BufferedWriter.txt 写入文件信息
            fileWriter = new FileWriter(projectPath + "\\src\\main\\resources\\IO\\BufferedWriter.txt");

            bufferedReader = new BufferedReader(fileReader);
            bufferedWriter = new BufferedWriter(fileWriter);

            System.out.println("开始读取文件.....");
            //接下来开始读取文件信息
            int num = 0;
            //读取文件信息
            num = bufferedReader.read();
            while (num != -1) {
                System.out.println(num);
                //向文件BufferedWriter.txt 写入文件信息
                bufferedWriter.write(num);
                //向下读取文件信息
                num = bufferedReader.read();
            }
            //刷新缓冲区
            bufferedWriter.flush();
            System.out.println("刷新缓冲区, 文件拷贝成功！！！");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (fileReader != null) {
                fileReader.close();
            }
            if (fileWriter != null) {
                fileWriter.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            System.out.println("关闭流成功！！！");
        }

    }
}

```

---
#以下内容自行食用

---

## 节点流与处理流的使用
### 一、节点流
* 定义：节点流：从一个特定的数据源（节点）读写数据（如：文件、内存） 的类叫做节点流类
![memorypng](https://github.com/ZHoodLum/JavaPractice/blob/master/src/main/resources/images/memory.png)

* 这些节点类跟数据源或数据目的地做直接连接用的
* 在java.io包中，字节继承体系有三种节点类，而字符继承体系有四 种节点类

类型|字节流|字符流 
---|---|---
File | FileInputStream、FileOutputStream | FileReader、FileWriter 
Memory Array |ByteArrayInputStream ByteArrayOutputStream |CharArrayReader CharArrayWriter
Memory String | &nbsp;|StringReader、StringWriter 
Piped |PipedInputStream PipedOutputStream |PipedReader PipedWriter
### 节点流的方法
####  1、节点流的方法 — InputStream
>* 这个方法没有参数，一次读取 一个byte的数据，并以int类型把 数据返回来，如果没有数据可 以读了，会返回”-1”。

####  2、节点流的方法 — OutputStream
>* 使用write方法输出数据时，有些数据并不会马上输出到我们指 定的目的，通常会在内存中有个暂存区，有些输出的数据会暂 时存放在这里，如果我们想要立刻把数据输出到目的地，不要 放在暂存区中时，可以调用”flush”这个方法来对暂存区做清 除的动作。
>* 同样，数据输出完后，记得把它”close”，在调用close这个方 法时，会先调用flush这个方法，以确保所有的数据都已经输出 到目的地了。

#### 3、节点流的方法 — Reader 
>* Reader是输入字符数据用的类，它所提供的方法和InputStream 类一样，差别在于InputStream类中用的是byte类型，而Reader 类中用的是char类型。
>* Reader类中没有available方法，取而代之的是”ready” 方法，这个方法会去检查Reader对象是否已经准备好输 入数据了，如果是返回true，反之返回false。

#### 4、节点流的方法 — Writer 
>*  Writer类是输出字符数据的类，同样地，提供的方法和 OutputStream类中的方法类似，将OutputStream类中用到的 byte类型，换成char类型就可。 
>* Writer类另外提供了两个writer方法，所以Writer类有5 个writer方法，多出来的两个只是把char数据换成String 对象而已，方便输出字符的数据。

***

### 二、处理流
* 定义：
只用字节或是字符为单位来对数据做输入输出是不够的，有时候 我们需要一行一行的读数据，有时我们需要读取特定格式的数据， 因此Java提供了这样的机制，能把数据流作连接(chain)，让原本没 有特殊访问方法的流，通过连接到特殊的流后，变成可以用特定 的方法来访问数据
![datasinkpng](https://github.com/ZHoodLum/JavaPractice/blob/master/src/main/resources/images/datasink.png)
* “连接”在已存在的流（节点流或处理流）之上，通过对数据的 处理为程序提供更为强大的读写功能
*  处理流类的构造函数中，都必须接收另外一个流对象作为参数

#### 常见的处理流类

种类/继承体系|字节|字符
---|---|---
缓冲(Buffered)| BufferedInputStream, BufferedOutputStream| BufferedReader, BufferedWriter 
字符和字节转换|&nbsp; |InputStreamReader, OutputStreamWriter 
对象序列化| ObjectInputStream, ObjectOutputStream |&nbsp; 
特定数据类型访问| DataInputStream, DataOutputStream |&nbsp; 
计数| LineNumberInputStream |&nbsp; 
重复| PushbackInputStream|&nbsp; 
打印| PrintStream| PrintWriter|&nbsp; 

### 常见处理流类 — 缓冲流（Buffered）

* 缓冲流对读写的数据提供了缓冲的功能，提高了读写的效率，同 时增加了一些新的方法

#### Java提供了四种缓冲流，其构造方法

构造方法 |含义
---|---
BufferedInputStream(InputStream in)| 创建了一个带有32字节缓冲区的缓冲输 入流 
BufferedInputStream(InputStream in, int size)| 创建了一个带有size大小缓冲区的缓冲 输入流 
BufferedOutputStream(OutputStream out) |创建了一个带有32字节缓冲区的缓冲输 出流 
BufferedOutputStream(OutputStream out，int size) |创建了一个带有size大小缓冲区的缓冲 输出流


#### Java提供了四种缓冲流，其构造方法

构造方法| 含义 
---|---
BufferedReader(Reader in) |创建一个使用默认大小输入缓冲区的 缓冲字符输入流
BufferedReader(Reader in,int size) |创建一个使用size大小输入缓冲区的 缓冲字符输入流
BufferedWriter(Writer out) |创建一个使用默认大小输入缓冲区的 缓冲字符输出流
BufferedWriter(Writer out,int size) |创建一个使用size大小输入缓冲区的 缓冲字符输出流

### 缓冲流中的方法
* BufferedInputStream支持其父类的mark和reset方法 
* BufferedWriter提供了readLine方法用于读取一行字符串(以\r或 \n分隔) 
* BufferedWriter提供了newLine方法用于写入一个行分隔符 
* 对于BufferedOutputStream和BufferdWriter，写出的数据会先在 内存中缓存，使用flush()方法将使内存中的数据立刻写出


[字符流之读写文件的操作FileReader和FileWriter]: #字符流之读写文件的操作FileReader和FileWriter