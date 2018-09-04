#Servlet

[Servlet简介](#Servlet简介)

[HttpServlet简介doPost和doGet请求原理](#HttpServlet简介)

[三种缓存](#三种缓存)

[JSP共有九大内置对象](#JSP共有九大内置对象)

---

---

### Servlet简介

博主地址：https://www.cnblogs.com/libingbin/p/5960456.html
### servlet设置编码格式
```
request.setCharacterEncoding("utf-8");
response.setContentType("text/html;charset=utf-8");
```
---

### web.xml文件执行顺序与配置顺序无关，要想更改顺序，可以使用<load-on-startup>

---

### servlet 默认访问
servlet访问时，如果其他的servlet没有匹配上，就走当前默认的servlet（/）
```
<servlet>
    <servlet-name>servlettest4</servlet-name>
    <servlet-class>test.ServletTest4</servlet-class>
    <!-- 数值越小，加载优先级越高 -->
    <load-on-startup>1</load-on-startup>
  </servlet>
  <servlet-mapping>
    <servlet-name>servlettest4</servlet-name>
    <url-pattern>/</url-pattern>
  </servlet-mapping>
```
---

### Servlet简介与Servlet和HttpServlet运行流程

#### Servlet简介

* Servlet的作用：
>* 接收用户发送的请求
>* 调用其他的java程序来处理请求
>* 根据处理结果，返回给用户一个页面
>* Servlet的HelloWorld
>* 创建一个类并实现Servlet接口
>* 在web.xml文件中对Servlet进行配置

```
<servlet>
        <servlet-name>别名</servlet-name>
        <servlet-class>全类名</servlet-class>
</servlet>
<servlet-mapping>
         <servlet-name>别名</servlet-name>
         <url-pattern>需要servlet处理的请求地址</url-pattern>
</servlet-mapping>
 ```

* Servlet的三个名字：

```
<servlet-name> ----------> Servlet的别名，程序员通过别名对Servlet进行配置

<servlet-class> ----------> Servlet的全类名，服务器通过全类名来创建Servlet的实例

<url-pattern> ----------> Servlet映射的请求地址，用户通过该地址访问Servlet
```

---

 #### Servlet的生命周期
* Servlet的生命周期，指Servlet的对象从被创建到被销毁的过程。
* Servlet的生命周期方法：

```
1.构造器：
      - Servlet第一次处理请求时，会调用构造器，来创建Servlet实例。
      - 只会调用一次，Servlet是单例模式，他是以多线程的方式调用service()方法.
      - Servlet不是线程安全，所以尽量不要再service()方法中操作全局变量。

2.init()方法：
      - 构造器调用之后马上被调用，用来初始化Servlet，只会调用一次。
      -servlet的初始化方法，调用时机：servlet对象创建时调用

3.service()方法：
       - Servlet每次处理请求时都会调用service()方法，用来处理请求，会调用多次。

4.destroy()方法：
         - Servlet对象销毁前(WEB项目卸载时)调用，用来做一些收尾工作，释放资源。
         -servlet的销毁方法，调用时机：销毁servlet对象是执行,一般销毁在服务器(tomcat)关闭的时候或者开发阶段reloading时候
```

---

#### 相关接口
**ServletConfig 代表：当前Servlet的配置信息，每一个Servlet都有其唯一对应的ServletConfig。**

```
<servlet>
     <servlet-name>AServlet</servlet-name>
       <servlet-class>com.atguigu.servlet.AServlet</servlet-class>
      <init-param>
               <param-name>user</param-name>
               <param-value>root</param-value>
      </init-param>
     <init-param>
            <param-name>password</param-name>
            <param-value>123123</param-value>
     </init-param>
</servlet>
 ```

获取：由Tomcat服务器创建，最终作为参数传递到init()方法中，我们可以在init()方法直接使用。 当我们通过继承HttpServlet创建Servlet时，由于父类已经实现ServletConfig接口，所以我们可以在Servlet中直接调用ServletConfig的方法。
 
**功能：**
```
* 获取Servlet的别名
* 获取当前Servlet的初始化参数。
<init-param>
         <param-name>user</param-name>
        <param-value>root</param-value>
</init-param>
<init-param>
          <param-name>password</param-name>
          <param-value>123123</param-value>
</init-param>
* 获取当前WEB应用的ServletContext对象。
 ```

---

**ServletContext代表：当前的WEB应用，一个WEB应用对应一个唯一的ServletContext对象，ServletContext对象在项目启动时创建，在项目卸载时销毁。**
获取：通过ServletConfig的getServletContext()方法获取。
**功能：**

```
可以获取整个WEB应用的初始化参数
context-param>
         <param-name>phone</param-name>
         <param-value>1388888888</param-value>
</context-param>
可以获取资源的真实路径（物理路径），主要在文件的上传和下载时使用。
可以作为一个域对象在不同的web资源之间共享数据。（下回分解）
 ```

**GenericServlet**
* 通用Servlet的父类
* 相比Servlet接口GenericServlet更加简单一些，但是我们最终实际上使用的HttpServlet

---
 
### HttpServlet
* HttpServlet继承了GenericServlet，而GenericServlet实现Servlet接口
* 所以我们可以同构继承HttpServlet来创建一个Servlet。
* HttpServlet重写service()方法：
*> 在该方法中先将ServletRequest和ServletResponse强转为了HttpServletRequest和HttpServletResponse。
*> 然调用重载的service()方法，并将刚刚强转得到对象传递到重载的方法中。

* 重载service(HttpServletRequest request , HttpServletResponse response)
*> 在方法中获取请求的方式（get或post）
*> 在根据不同的请求方式去调用不同的方法：
*>> 如果是GET请求，则调用doGet(HttpServletRequest request , HttpServletResponse response)
*>> 如果是post请求，则调用doPost(HttpServletRequest request , HttpServletResponse response)

**结论：**
            当通过继承HttpServlet来创建一个Servlet时，我们只需要根据要处理的请求的类型，来重写不同的方法。
                处理get请求，则重写doGet()
                处理post请求，则重写doPost()
 
---
 
### HttpServletRequest 
* 代表：浏览器发送给服务器的请求报文。
* 获取：该对象由Tomcat服务器创建，最终作为参数传递到doGet/doPost方法中，就可以在这两个方法中直接使用。
* 功能：

```
获取用户发送的请求参数     request.getParameter("username");

获取项目的名字(用来设置绝对路径)    request.getContextPath();

作为一个域对象，在不同的WEB资源之间共享数据。

请求的转发   request.getRequestDispatcher("target.html").forward(request, response);
 ```
---

### HttpServletResponse
* 代表：服务器发送给浏览器的响应报文。
* 获取：该对象由Tomcat服务器创建，最终作为参数传递到doGet或doPost方法中，我们可以在这两个方法中直接使用。
* 功能：

```
响应给浏览器一个网页或者是网页片段(设置的是响应报文的响应体)
                response.getWriter("");

请求的重定向
                response.sendRedirect("target.html");
 
转发和重定向：（掌握）
 
                                   转发                   重定向
        请求的次数：        1                      2
        发生的位置           服务器内部        浏览器
        浏览器地址栏        不改变                改变
        浏览器的感知        不知道                知道   
 ```

---

### 字符编码
* 当用户通过表单向Servlet发送中文请求参数时，Servlet获取到内容会产生乱码，当Servlet向浏览器响应中文内容时，也会产生乱码。
* 浏览器和服务器之间通信时，中文内容时不能直接发送的，需要对中文进行编码。

```
编码：  - 将字符转换为二进制码的过程叫编码。
解码：  - 将二进制码转换为普通字符的过程叫解码。
编码和解码所采用的规则我们称为字符集。
 
产生乱码问题的根本原因： 编码和解码所采用的字符集不同。
 
解决方法： 统一编码和解码的字符集为UTF-8。
 
常见字符集：
     1.ASCII
     2.ISO8859-1
     3.GBK
     4.GB2312
     5.UTF-8
 ```

**请求编码**
```
     - 请求是浏览器发送给服务器的。
     - 浏览器 --> 服务器
     - 浏览器 编码
                > 浏览器的会自动使用网页的字符集对参数进行编码
                  UTF-8的张三：%E5%BC%A0%E4%B8%89
                  GBK的张三：%D5%C5%C8%FD
 
                > 所以我们只需要统一网页的字符集为UTF-8即可。
```
 
**服务器 解码**
```
         post请求:
                    > request解码时默认字符集时iso8859-1，但是iso压根就不支持中文
                    > post请求在servlet中解码，所以我们只需要指定request的字符集即可。
                    > 我们可以通过如下方法，来设置request的字符集：
                        request.setCharacterEncoding("utf-8");
                    > 注意：
                        该方法要在request.getParameter()第一次调用之前调用
 
          get请求:
                    > get请求是通过url地址传递请求参数，url中的请求参数将会被Tomcat服务器自动解码。
                    > Tomcat的默认编码是iso8859-1，但是iso压根就不支持中文，所以必然乱码。
                    > 只需要修改Tomcat的解码的默认字符集，修改配置文件server.xml
                    > 在server.xml的Connector标签中（改端口号的那个标签）添加如下属性：
                        URIEncoding="utf-8"
                    > 修改完配置文件以后，get请求的编码就不用再处理的，但是post请求还是老样子。
```

**响应编码**
      - 响应是服务器发送给浏览器
      - 服务器 --> 浏览器
      - 服务器 编码
                > 指定服务器的编码字符集为UTF-8。
                > 指定response的字符集
                    response.setCharacterEncoding("utf-8");
                > 虽然我们已经指定了response的字符集为utf-8，但是浏览器并不是用utf-8解码。
                    浏览器默认使用gb2312解码的，所以依然乱码，只不过没有那么乱。
 
**浏览器 解码**
```
       -浏览器的解码字符集可以通过浏览器来设置（不靠谱）
       -我们可以通过服务器来告诉浏览器，我们的内容的编码格式为utf-8
       -我们可以通过一个响应头来告诉浏览器，内容的编码格式： Content-Type:text/html;charset=utf-8
              > 通过response的方法，来设置响应头：
                    response.setHeader("Content-Type", "text/html;charset=utf-8");
 
        解决方案：
                1.设置响应头
                    response.setHeader("Content-Type", "text/html;charset=utf-8");
                2.设置response的编码格式
                    response.setCharacterEncoding("utf-8");
 
                > 当我们设置Content-Type这个响应头时，服务器会自动使用响应头中的字符集为内容编码。
 
                > 最终方案：
                    response.setContentType("text/html;charset=utf-8");
 ```

#### 总结：

```
post请求：
       -在request.getParameter()方法第一次调用之前，调用如下代码：
       -request.setCharacterEncoding("utf-8");

get请求：
        -修改server.xml配置文件
        -<Connector URIEncoding="utf-8" connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443"/>
 
响应：
        -设置一个Content-Type响应头
        -response.setContentType("text/html;charset=utf-8");
 ```

---
 
 
### 路径问题
* URI和URL
            - URL是URI的一种实现，也是URI最常见的实现方式。
            - URI有两种实现方式URL和URN，URN用的很少
            - 我们说URL和URI实际上可以理解为一个意思
 
* URL地址的格式
            http://主机名:端口号/项目名/资源路径/资源名
 
#### 相对路径和绝对路径

**相对路径**
```
     - 之前我们使用的路径全都是相对路径：
     - 所谓的相对路径指相对于当前资源所在路径：
                    http://主机名:端口号/项目名/资源路径/
     - 由于转发的出现，相对路径会经常发生变化，容易出现错误的链接
                所以在开发中我们一般不使用相对路径，而是使用绝对路径。
 ```

**绝对路径**
```
     - 绝对路径使用/开头   
     - 由浏览器解析的绝对路径中的/代表的是服务器的根目录：
                http://主机名:端口号/
                注意：需要加上项目名
 
     由服务器解析的绝对路径中的/代表的项目的根目录：
                http://主机名:端口号/项目名/
                注意：不要加项目名
 
     转发的路径由服务器解析，设置绝对路径时不需要加项目名
     重定向的路径由浏览器解析，设置绝对路径时需要加上项目名
 ```

 
#### 常见的路径：
**url-pattern：**
**转发的路径：**
```
                - url-pattern和转发中的路径都是由服务器解析的，
                    根目录是项目的根目录：
                        http://主机名:端口号/项目名/
                - 所以这两个路径不需要加项目名
```
 
**重定向的路径：**
**页面中的路径：**
```
                - 重定向和页面中的路径（HTML标签中的路径），由浏览器解析的，
                    根目录是服务器的根目录：
                        http://主机名:端口号/
                - 所以这个两个路径必须加上项目名
```

---
 
---
 


### HttpServlet简介

博主源地址 https://blog.csdn.net/m0_38039437/article/details/75264012
* HttpServlet是GenericServlet的子类，又是在GenericServlet的基础上做了增强。
* HttpServlet方法

---

### HTTP实现doGet或doPost请求项目介绍
* 1、通过实现doGet请求和doPost请求实例来了解内部的工作原理。
* 2、doGet请求和doPost请求实例代码介绍：
>* A：创建一个Servlet类继承HttpServlet类
>* B：在index.jsp页面创建一个超链接请求
* 3、doGet请求和doPost请求实例实施介绍：
>* A、创建一个webproject项目。
>* B、创建一个Servlet类的名称为HttpServ继承HttpServlet类同时覆写doGet方法和doPost方法。
* 4、创建Servlet代码展示

```
package httpserve;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class HttpServ extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("发送get请求。。。。。。。。。。。");
        
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        resp.setContentType("text/html;charset=UTF-8");
        System.out.println("发送post方法。。。。。。。。。。");
    }
}

```

* 5、web.xml配置文件代码展示

```
<?xml version="1.0" encoding="UTF-8"?>
<web-app version="3.0"
    xmlns="http://java.sun.com/xml/ns/javaee"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://java.sun.com/xml/ns/javaeehttp://java.sun.com/xml/ns/javaee/web-app_3_0.xsd">
  <servlet>
    <description>This is the description of my J2EE component</description>
    <display-name>This is the display name of my J2EE component</display-name>
    <servlet-name>HttpServ</servlet-name>
    <servlet-class>httpserve.HttpServ</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>HttpServ</servlet-name>
    <url-pattern>/http</url-pattern>
  </servlet-mapping>
</web-app>

```


* 6.在index.jsp页面创建一个超链接请求

```
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
  </head>
  
  <body>
    This is my JSP page. <br>
    <a href="http://localhost:8080/test06/http">get请求1</a><br/>
    <!-- 对于一个html页面来说，如果没有以http开始，则默认的前面会加上
        协议类型://目前这个页面所在的服务器:目前端口/目前项目/你给的这个名称 -->
    <a href="http">get请求2</a><hr/>
    <form method = "post" action="http">
        <input type="submit" value="提交"/>
    </form>
  </body>
</html>

```
* 7.发送doGet请求和doPost请求
>* 1、在浏览器中输入测试地址，http://127.0.0.1:8080/test06/
>* 2、打开项目的首页后分别点击get请求1、get请求2、和 post请求（提交按钮）
>* 3、在控制台可以观察到分别调用了doGet和doPost方法。



---
### HTTP实现doGet或doPost请求原理介绍
* 1、浏览器发送请求到HttpSevr类调用HttpServ的service（servletRequest, servletReponse）方法
* 2、由于没有找到这个方法，去调用父类（HttpServlet） 的同名方法。
* 3、父类的service方法将ServletRequest req请求转换成HttpServletRequest请求，再去调用service(request, response) 方法。
**将ServletRequest req请求转换成HttpServletRequest请求再调用service(request, response) 方法源码如下：**

```
public void service(ServletRequest req, ServletResponse res)
        throws ServletException, IOException {
        HttpServletRequest  request;
        HttpServletResponse response;
        
        try {
            request = (HttpServletRequest) req;
            response = (HttpServletResponse) res;
        } catch (ClassCastException e) {
            throw new ServletException("non-HTTP request or response");
        }
        service(request, response);
    }


```

* 4、 调用的service(request, response) 方法功能是判断用户发出是什么请求，如果是get则调用子类（HttpSevr）的doGet方法，如果是post则调用子类（HttpSevr）的doPost方法。
**service(request, response) 方法源码如下：**

```
  protected void service(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        String method = req.getMethod();
        if (method.equals(METHOD_GET)) {
            long lastModified = getLastModified(req);
            if (lastModified == -1) {
                // servlet doesn't support if-modified-since, no reason
                // to go through further expensive logic
                doGet(req, resp);
            } else {
                long ifModifiedSince;
                try {
                    ifModifiedSince = req.getDateHeader(HEADER_IFMODSINCE);
                } catch (IllegalArgumentException iae) {
                    // Invalid date header - proceed as if none was set
                    ifModifiedSince = -1;
                }
                if (ifModifiedSince < (lastModified / 1000 * 1000)) {
                    // If the servlet mod time is later, call doGet()
                    // Round down to the nearest second for a proper compare
                    // A ifModifiedSince of -1 will always be less
                    maybeSetLastModified(resp, lastModified);
                    doGet(req, resp);
                } else {
                    resp.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
                }
            }
        } else if (method.equals(METHOD_HEAD)) {
            long lastModified = getLastModified(req);
            maybeSetLastModified(resp, lastModified);
            doHead(req, resp);
        } else if (method.equals(METHOD_POST)) {
            doPost(req, resp);
            
        } else if (method.equals(METHOD_PUT)) {
            doPut(req, resp);        
            
        } else if (method.equals(METHOD_DELETE)) {
            doDelete(req, resp);
            
        } else if (method.equals(METHOD_OPTIONS)) {
            doOptions(req,resp);
            
        } else if (method.equals(METHOD_TRACE)) {
            doTrace(req,resp);
            
        } else {
            //
            // Note that this means NO servlet supports whatever
            // method was requested, anywhere on this server.
            //
            String errMsg = lStrings.getString("http.method_not_implemented");
            Object[] errArgs = new Object[1];
            errArgs[0] = method;
            errMsg = MessageFormat.format(errMsg, errArgs);
            
            resp.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED, errMsg);
        }
    }

```

* 5、调用关系图



---


### 注意事项：

```
1、如果在HttpServ中覆盖了service(ServletRequest,SerlvetResonse)方法则这个类的所实现的doGet/doPost都不会再执行
因为service(ServletRequest,SerlvetResonse)是最高接口Servlet定义规范。在tomcat调用时，一定会在最终的子类中去找这个方法且调用它。
如果最终的子类没有则会调用父的service(ServletRequest,SerlvetResonse)。

2、如果覆盖了serivce(HttpServletRequest,HtpServletResponse)
则会执行httpServlet中的service(ServletRequest,SerlvetResonse),
但是由于子类中已经覆盖了serivce(HttpServletRequest,HtpServletResponset)
所以，httpServlet中的serivce(HttpServletRequest,HtpServletResponset)就不再执行了，
而是直接执行子类中同名同参数方法，且doXxxx也不会执行了，
因为子类的serivce(HttpServletRequest,HtpServletResponset)没有调用doXxxx。

3、如果继承了HttpServlet没有实现任何的doXxx方法则会抛出一个异常
```

---

### 三种缓存区别
**session cookie cache缓存区别：**
一、Session缓存Session的生存周期 = 用户持续请求时间+超时时间(一般为20分钟)

```
Session在用户第一次访问服务器时自动创建。Session生成后，用户每访问服务器一次服务器就会更新Session的最后访问时间并认为该用户的session活跃

由于会有越来越多的用户访问服务器，因此Session也会越来越多。为了防止内存溢出，服务器会把长时间没有活跃的session删除掉，

这个时间就是Session的超时时间。如果超过了超时时间没有访问服务器，Session就自动失效了。

  Session在下面两种情况下会失效：1.超时。 2. 调用Session的invalidate方法。
  
  关闭浏览器≠Session立刻消失，用户关闭浏览器后标志着：1.Session将不再发送请求到服务器。2.该Session将不会有人调用他的invalidate()方法。所以，此时只能等待Session自己超时死亡。
  
从session的生命周期看，session缓存信息保存在web服务器当中，并且session缓存容易丢失，导致数据的不确定性。而且session不适宜放大量信息，否则会导致服务器性能降低。

  session是针对单个连接（会话）来使用的，主要存储和连接相关的上下文信息，比如登录信息等等。通常用户登录之后，就会把用户信息放进session中，比如id字段，以后要检查用户是否有登录，就只需检查session中是否存在userId。
```

二、Cookie缓存

```
当你在浏览网站的时候，WEB 服务器会先送一小小资料放在你的计算机上，Cookie 会帮你在网站上所打的文字或是一些选择都纪录下来。当下次你再光临同一个网站，

WEB 服务器会先看看有没有它上次留下的 Cookie 资料，有的话，就会依据 Cookie里的内容来判断使用者，送出特定的网页内容给你。

  具体来说cookie机制采用的是在客户端保持状态的方案(保存客户浏览器请求服务器页面的请求信息)，而session机制采用的是在服务器端保持状态的方案。
  
  Cookie存储的数据量受限制，大多数的浏览器为4K因此不要存放大数据。由于并非所有的浏览器都支持Cookie，数据将以明文的形式保存在客户端。
  
  Cookie是用来保存就是被人盗取也无关紧要的信息，例如用户的喜好、用户搜索过的关键字等，用户信息、id字段不建议保存在Cookie中，因为别人可以分析存放在本地的Cookie进行Cookie欺骗。
```

三、Cache缓存

```
Cache用于在Http请求期间保存页面或者数据，主要用来保存大容量信息，如数据库中的多个表。即使应用程序终止，只要Cache方法中定义的缓存时间未过期，下次开启应用程序时，缓存的数据依然存在。

  Cache是应用程序级的，主要用来缓存计算或查询结果，减轻服务器负担，并加快响应速度。它允许将频繁访问的服务器资源存储在内存中，当用户发出相同的请求后,服务器不是再次处理而是将Cache中保存的数据直接返回给用户。可以看出Cache节省的是时间—服务器处理时间。
```

---

### java中设置session过期时间

session个人认为在不同的服务器端，存活的时间也会不同
session的取值范围是1-1440（就是24小时 ）
```
1. 在web容器中设置（以tomcat为例,Tomcat默认session超时时间为30分钟）
在tomcat-8.0.26\conf\web.xml中设置，以下是tomcat 8.0中的默认配置：
<session-config>  
<!-- 时间单位为分钟   -->  
    <session-timeout>30</session-timeout>  
</session-config> 

2. 在web.xml中设置
 
<session-config>
<!-- 时间单位为分钟   -->  
      <session-timeout>15</session-timeout>
</session-config>

3. 通过Java代码设置
//以秒为单位
session.setMaxInactiveInterval（30*60）;

他们的优先级是：1 < 2 <3
```

---

### JSP共有九大内置对象

* (1) HttpSession类的session对象作用：主要用于来分别保存每个用户信息，与请求关联的会话；会话状态维持是Web应用开发者必须面对的问题。
* (2) HttpServletRequest类的request对象作用：代表请求对象，主要用于接受客户端通过HTTP协议连接传输到服务器端的数据。
* (3) HttpServletResponse类的respone对象作用：代表响应对象，主要用于向客户端发送数据
* (4) JspWriter类的out对象作用：主要用于向客户端输出数据;Out的基类是JspWriter
* (5) ServletContex类的application对象作用：主要用于保存用户信息，代码片段的运行环境；它是一个共享的内置对象，即一个容器中的多个用户共享一个application对象，故其保存的信息被所有用户所共享.
* (6) PageContext类的pageContext对象作用：管理网页属性,为JSP页面包装页面的上下文，管理对属于JSP中特殊可见部分中已命名对象的访问，它的创建和初始化都是由容器来完成的。
* (7) ServletConfig类的config对象作用：代码片段配置对象，表示Servlet的配置。
* (8) Object类的page（相当于this）对象作用：处理JSP网页，是Object类的一个实例，指的是JSP实现类的实例，即它也是JSP本身，只有在JSP页面范围之内才是合法的。
* (9)Exception作用：处理JSP文件执行时发生的错误和异常

### Jsp中pageContext的作用
```
pageContext 隐含物件对应於javax.servlet.jsp.PageContext型态之物件，隐含物件都自动的被加入至pageContext中，

您可以藉由它来取得与JSP相关的隐含物件对应之Servlet物件，像是getRequest()可以取得ServletRequest， getServletConfig()可以取得ServletConfig，

getSession()可以取得HttpSession等等。提供取得隐含物件对应之Servlet物件并不是pageContext的主要作用，它的主要功能在提供一个单一个介面，

以管理各种的公开物件（像是HttpSession、ServletContext、ServletConfig、ServletRequest、ServletResponse等等），提供一个单一的API来管理属性作用范围等等。 
```
```
我们之前曾经使用过session的setAttribute()等方法设定一个进程可以共用的属性物件，使用session设定的属性在同一个进程中可以共用，

除了session之外，还有pageContext、 request、application也都可以使用setAttribute()之类的方法（详请查阅API文件）来设定可以共用的属性物件，只不过这

四个物件所设定的属性其共用范围各不相同。 
```
```
使用pageContext所设定的属性物件，其共用范围限於同一个 JSP页面，使用request所设定的属性物件，

其在同一个request处理期间可以共用（包括forward给其它JSP页面），session物件所设定的属性物件则限於同一个进程作用期间可以共用，

而application物件所设定的属性，则在整个Web应用程式中的JSP页面都可以共用。 
```
以下举application为例，您可以将一些物件当作属性设定给application，则另一个JSP页面就可以在适当的时候取得这个属性物件，例如： 
```
<% 
String attr = "字串物件"; 
out.println("设定属性给application：" + attr); 
application.setAttribute("str", attr); 
%> 
```
我们先连上这个JSP网页以执行属性设定，然后我们再连上这个JSP网页： 
```
<% 
String attr = (String) application.getAttribute("str"); 
out.println("取得application属性：" + attr); 
%> 
```
由于我们之前已经将字串物件设定在application中作为属性，所以我们可以在上面这个页面中取得之前设定的物件，同样的道理，您也可以用相同的方式设定属性给pageContext、request、session等物件，只要在允许的作用范围中，就可以取得所设定的属性物件。 

您可以使用pageContext物件来设定属性，并指定属性的作用范围，而不用使用个别的pageContext、request、session、 application来进行设定，这就是之前所提的，以pageContext提供一个单一的API来管理属性作用范围，您可以使用以下的方法来进行设定： 
```
getAttribute(String name, int scope) 
setAttribute(String name, Object value, int scope) 
removeAttribute(String name, int scope) 
```
其中的scope可以使用以下的常数来进行指定：pageContext.PAGE_SCOPE、pageContext.REQUEST_SCOPE、pageContext.SESSION_SCOPE、pageContext.APPLICATION_SCOPE，常数的名称已经直接指明属性范围，我们可以将上面的两个JSP页面改为以下的形式： 
```
<% 
String attr = "字串物件"; 
out.println("设定属性给application：" + attr); 
pageContext.setAttribute("str", attr, pageContext.APPLICATION_SCOPE); 
%> 

<% 
String attr = (String) pageContext.getAttribute("str", pageContext.APPLICATION_SCOPE); 
out.println("取得application属性：" + attr); 
%>
```

---

### EL表达式的11个内置对象

* pageScope：获取pageContext域属性，相当于pageContext.getAttribute("xxx")
* requestScope：获取request域属性，相当于request.getAttribute("xxx")
* sessionScope：获取session域属性，相当于session.getAttribute("xxx")
* applicationScope：获取application域属性，相当于application.getAttribute("xxx")
* param：对应参数，它是一个Map，其中key是参数，value是参数值，适用于单值的参数，相当于request.getParameter("xxx")
* paramValues：对应参数，她是一个Map，其中key是参数，value是多个参数值，适用于多值的参数，相当于request.getParameterValues("xxx")
* header：对应请求头，它是一个Map，其中key表示头名称，value是单个头值，适用于单值的请求头，相当于request.getHeader("xxx")
* headerValues：对应请求头，它是一个Map，其中key表示头名称，value是多个头值，适用于多值的请求头，相当于request.getHeaders("xxx")
* initParam：获取web.xml中<context-param>内的参数，${ initParam.xxx}，xxx就是<param-name>标签内的值，进而得到<param-value>中的值
* cookie：用于获取cookie，Map<String,Cookie>，其中key是cookie的name，value是cookie对象，例如${cookie.JSESSIONID.value }就是获取sessionId
* pageContext：可以获取JSP九大内置对象，相当于使用该对象调用getxxx()方法，例如pageContext.getRequest()可以写为${pageContext.request)

EL表达式在获取Map的值或Bean的属性值是，可以使用“点”的方法，也可以使用“下标”的方法。
${initParam.a}与${initParam['a']}，它们是完成的东西相同的。但是，如果Map的键或Bean的属性名中包含下划线或横岗时，那么就必须使用“下标”方法，例如：${initParam['a_a']}

### EL表达式语言中定义了11个隐含对象详解

使用这些隐含对象可以很方便地获取web开发中的一些常见对象，并读取这些对象的数据。

语法：${隐式对象名称} ：获得对象的引用


隐含对象名称|描 述
pageContext|对应于JSP页面中的pageContext对象（注意：取的是pageContext对象。）
pageScope|代表page域中用于保存属性的Map对象
requestScope|代表request域中用于保存属性的Map对象
sessionScope|代表session域中用于保存属性的Map对象
applicationScope|代表application域中用于保存属性的Map对象
param|表示一个保存了所有请求参数的Map对象
paramValues|表示一个保存了所有请求参数的Map对象，它对于某个请求参数，返回的是一个string[]
header|表示一个保存了所有http请求头字段的Map对象
headerValues|同上，返回string[]数组。注意：如果头里面有“-” ，例Accept-Encoding，则要headerValues[“Accept-Encoding”]
cookie|表示一个保存了所有cookie的Map对象
initParam|表示一个保存了所有web应用初始化参数的map对象

```
例子
1.1 pageContext
 <%
    pageContext.setAttribute("name", "aaaa");
%>
${name} <!--取出pageContext里面的name属性-->
1.2 sessionScope
  <%
    session.setAttribute("user", "");
  %>
  <!--获取session里面的值，与pageContext有点区别-->
   ${sessionScope.user==null ?"您没有登录":"欢迎您," }${user }
1.3 requestScope
 <%
    request.setAttribute("age", "20");
  %>
  <!--获取reqeust里面的值，与pageContext有点区别-->
  ${requestScope.age}
1.4 param 和paramValues 取地址栏参数
http://127.0.0.1:8080/day10/04param.jsp?name=junjiex&age=10&age=20
<!--获取name-->
${param.name }
<!--获取age数组-->
${paramValues.age[0] }<!--得到10-->
${paramValues.age[1] }<!--得到20-->

```






