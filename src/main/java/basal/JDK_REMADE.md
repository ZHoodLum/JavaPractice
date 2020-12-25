#JDK

### JDK与JRE区别：

```
    JRE(Java Runtime Enviroment)是Java的运行环境。面向Java程序的使用者，而不是开发者。JRE是运行Java程序所必须环境的集合，包含JVM标

准实现及 Java核心类库。它包括Java虚拟机、Java平台核心类和支持文件。它不包含开发工具(编译器、调试器等)。

    JDK(Java Development Kit)又称J2SDK(Java2 Software Development Kit)，是Java开发工具包，它提供了Java的开发环境(提供了编译器

javac等工具，用于将java文件编译为class文件)和运行环境(提 供了JVM和Runtime辅助包，用于解析class文件使其得到运行)。如果你下载并安装

了JDK，那么你不仅可以开发Java程序，也同时拥有了运 行Java程序的平台。JDK是整个Java的核心，包括了Java运行环境(JRE)，一堆Java工具

tools.jar和Java标准类库 (rt.jar)
```

---


### java环境变量的配置

下面是我对应的JDK安装位置： JDK 位置：C:\Program Files\Java\jdk1.8.0_73

环境变量配置：
* (1) JAVA_HOME 编辑：
C:\Program Files\Java\jdk1.8.0_73

* (2)CLASSPATH 编辑：
%JAVA_HOME%\lib;%JAVA_HOME%\lib\tools.jar

* (3)PATH 点击编辑文本：
%JAVA_HOME%\bin;%JAVA_HOME%\jre\bin

* (4)检查是否环境配置成功
 使用CMD查看环境是否配置成功：java      javac     java -version

---

### java环境变量的配置的理解

#### 设置环境变量
在java 中需要设置三个环境变量（1.5之后不用再设置classpath了，但个人强烈建议继续设置以保证向下兼用问题）
JDK安装完成之后我们来设置环境变量：右击“我的电脑”，选择“属性”，选择“高级”标签，进入环境变量设置，分别设置如下三个环境变量：
#### （1）配置path变量：
为什么要配置path变量？因为电脑系统将根据该变量的值找到java编程中需要的一些程序，比如javac.exe、java.exe、javah.exe等等,其中javac.exe程序是用于编译java源代码，java.exe程序是用于执行后缀为class的代码。
#### 如何配置path变量？
path变量一般电脑系统都已经创建好了，所以不用新建该变量，只需在系统变量里选中到path变量，点击“选择” ->“编辑"，需要注意的是，不要随便删除方框里原有的其他path值，而是先在那一大串值之后，添加一个分号，再把C:\Program Files\Java\jdk1.5.0_17\bin填上去。下面列出其键值对：
变量名: PATH(不区分大小写但建议使用大写)
变量值: C:\Program Files\Java\jdk1.5.0_17\bin
path指定一个路径列表，用于搜索可执行文件。执行一个可执行文件时，如果该文件不能再当前路径下找到，则依次寻找PATH中的每一个路径，直至找到。java编译命令（javac）,执行命令（java）和一些工具命令（javadoc，jdb等）都在其安装路径下的bin目录中，因此应该将该路径添加到Path环境变量中，以方便今后在任何地方执行与调用。
不把JDK的bin目录加到PATH的话，需要path\to\jdk\bin\javac Xxx.java 这样编译程序，加到PATH后，可以直接 javac Xxxx.java， 输入省事多了。
#### （2）配置classpath变量：
为什么要配置classpath变量？配置classpath变量，才能使得java解释器知道到哪里去找标准类库，这些标准类库是别人已经写好了的，我们只管使用。比如我们常用到java.lang包中的类，在配置classpath变量后被设为默认导入，所以在写程序时就不用import这个包了。那么这些标准类库在哪呢？在以JDK的lib目录下以jar为后缀的文件中：一个是dt.jar，一个是tools.jar，这两个jar包都位于C:/jdk1.6.0/lib目录下，所以通常我们都会把这两个jar包加到我们的classpath环境变量的值为：.; C:\Program Files\Java\jdk1.5.0_17\\lib\tools.jar; C:\Program Files\Java\jdk1.5.0_17\\lib\dt.jar;
#### 如何配置classpath变量？
在系统环境变量那一栏中点击新建classpath ，具体过程省略，下面只列出其键值对：
变量名: CLASSPATH
变量值: .;%JAVA_HOME%\lib\tools.jar;%JAVA_HOME%\lib\dt.jar;
（注意，CLASSPATH最前面是有个 “.”的，表示当前目录。用两个%包围JAVA_HOME这个变量的意思是引用变量的值，当然如果你不想这样做，也可以这样配置classpath的值为：.;%JAVA_HOME%\lib\tools.jar;%JAVA_HOME%\lib\dt.jar; 也就是用JAVA_HOME变量的值替换%JAVA_HOME%）;
CLASSPATH也指定一个路径，用于搜索java编译或者运行时需要用到的类。在CLASSPATH列表中出了可以包含路径外，还可以包含Jar文件。Java查找类时会把这个Jar文件当做一个目录来进行查找。通常，需要将JDK安装路径下的jre\lib\rt.jar包含在CLASSPATH中。
JDK1.5后，就不必再配置classpath了。但建议继续设置以保证向下兼用问题最初的jdk自己找不到jdk\lib目录下的tools.jar，所以需要配置这个环境变量。CLASSPATH=.;%JAVA_HOME%\lib;%JAVA_HOME%\lib\tools.jar
其中"."表示在当前目录下寻找所要编译的类配置classpath变量，才能使得java解释器知道到哪里去找标准类库，这些标准类库是别人已经写好了的，我们只管使用。比如我们常用到java.lang包中的类，在配置classpath变量后被设为默认导入，所以在写程序时就不用import这个包了。这些标准类库在哪？在以JDK的lib目录下以jar为后缀的文件中：一个是dt.jar，一个是tools.jar，这两个jar包都位于jdk/lib目录下。
#### （3）配置JAVA_HOME变量：
为什么要配置classpath环境变量？一是为了方便引用，比如，JDK安装在C:\Program Files\Java\jdk1.5.0_17目录里，则设置JAVA_HOME为该目录路径, 那么以后要使用这个路径的时候, 只需输入%JAVA_HOME%即可, 避免每次引用都输入很长的路径串; 二则是归一原则, 当JDK路径改变的时候, 仅需更改JAVA_HOME的变量值即可, 否则,就要更改任何用绝对路径引用JDK目录的文档, 要是万一没有改全, 某个程序找不到JDK, 后果是可想而知的----系统崩溃! 三则是第三方软件会引用约定好的JAVA_HOME变量, 不然, 你不能正常使用该软件。
#### 如何配置JAVA_HOME变量？
在系统环境变量那一栏中点击新建JAVA_HOME （JAVA_HOME指向的是JDK的安装路径），变量的值实际上是JDK安装路径的根目录。具体过程省略，下面只列出其键值对：
变量名： JAVA_HOME
变量值：C:\Program Files\Java\jdk1.5.0_17
