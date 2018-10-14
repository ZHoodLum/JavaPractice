### Servlet

[Servlet简介](#Servlet简介)

[HttpServlet简介doPost和doGet请求原理](#HttpServlet简介)

[三种缓存](#三种缓存)

[JSP共有九大内置对象](#JSP共有九大内置对象)


[EL表达式的11个内置对象及其详解](#EL表达式的11个内置对象及其详解)

[JSP和Servlet的区别](#JSP和Servlet的区别)

[请求转发和重定向区别](#请求转发和重定向区别)

[Servlet的生命周期](#Servlet的生命周期)

[Filter过滤器](#Filter过滤器)


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
*>  在该方法中先将ServletRequest和ServletResponse强转为了HttpServletRequest和HttpServletResponse。
*>  然调用重载的service()方法，并将刚刚强转得到对象传递到重载的方法中。

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
### 缓存
**一、Session缓存Session的生存周期 = 用户持续请求时间+超时时间(一般为20分钟)**
Session在用户第一次访问服务器的时候自动创建。Session生成后，用户每访问服务器一次，服务器就会更新Session的最后访问时间，并认为该用户的session"活跃"。
由于会有越来越多的用户访问服务器，因此Session也会越来越多。为了防止内存溢出，服务器会把长时间没有活跃的session删除掉，这个时间就是Session的超时时间。如果超过了超时时间没有访问服务器，Session就自动失效了。

  Session在下面两种情况下会失效：1.超时。 2. 调用Session的invalidate方法。

  关闭浏览器≠Session立刻消失，用户关闭浏览器后标志着：1.Session将不再发送请求到服务器。2.该Session将不会有人调用他的invalidate()方法。所以，此时只能等待Session自己超时死亡。
从session的生命周期看，session缓存信息保存在web服务器当中，并且session缓存容易丢失，导致数据的不确定性。而且session不适宜放大量信息，否则会导致服务器性能降低。
  session是针对单个连接（会话）来使用的，主要存储和连接相关的上下文信息，比如登录信息等等。通常用户登录之后，就会把用户信息放进session中，比如id字段，以后要检查用户是否有登录，就只需检查session中是否存在userId。

session.invalidate()将session对象销毁


**二、Cookie缓存**
* 临时Cookie -----内存，存储在客户端内存中，浏览器窗口关闭就消失
* 持久Cookie------外存，硬盘，可以设置时间 setMaxAge()    单位秒计算，参数为0，表示删除该Cookie

当你在浏览网站的时候，WEB 服务器会先送一小小资料放在你的计算机上，Cookie 会帮你在网站上所打的文字或是一些选择都纪录下来。当下次你再光临同一个网站，WEB 服务器会先看看有没有它上次留下的 Cookie 资料，有的话，就会依据 Cookie里的内容来判断使用者，送出特定的网页内容给你。

具体来说cookie机制采用的是在客户端保持状态的方案(保存客户浏览器请求服务器页面的请求信息)，而session机制采用的是在服务器端保持状态的方案。
* Cookie存储的数据量受限制，大多数的浏览器为4K因此不要存放大数据。由于并非所有的浏览器都支持Cookie，数据将以明文的形式保存在客户端。
* Cookie是用来保存就是被人盗取也无关紧要的信息，例如用户的喜好、用户搜索过的关键字等，用户信息、id字段不建议保存在Cookie中，因为别人可以分析存放在本地的Cookie进行Cookie欺骗。

**三、Cache缓存**

* Cache用于在Http请求期间保存页面或者数据，主要用来保存大容量信息，如数据库中的多个表。即使应用程序终止，只要Cache方法中定义的缓存时间未过期，下次开启应用程序时，缓存的数据依然存在。

* Cache是应用程序级的，主要用来缓存计算或查询结果，减轻服务器负担，并加快响应速度。它允许将频繁访问的服务器资源存储在内存中，当用户发出相同的请求后,服务器不是再次处理而是将Cache中保存的数据直接返回给用户。可以看出Cache节省的是时间—服务器处理时间。
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
---

### javaweb开发需要用到的技术
目前， 国内外信息化建设已经进入基于Web应用为核心的阶段， Java作为应用于网络的最好语言，前景无限看好。然而，就算用Java建造一个不是很烦琐的web应用，也不是件轻松的事情。概括一下，实施Java的WEB项目需要掌握的技术如下： 

 
* Java语言
* 面向对象分析设计思想
* 设计模式和框架结构
* XML语言
* 网页脚本语言
* 数据库
* 应用服务器
* 集成开发环境
 
下面我们具体地看每个技术.
#### 1、Java语言


Java语言体系比较庞大，包括多个模块。从WEB项目应用角度讲有JSP、Servlet、JDBC、JavaBean(Application)四部分技术。
 
* （1）、Java Database Connectivity (JDBC)技术
在Java Web应用开发中，数据库管理系统（RDBMS）的使用是不可缺少的。JDBC(Java Database Connectivity) 是一种用于执行 SQL 语句的 Java API。它由一组用 Java 编程语言编写的类和接口组成。JDBC 为工具/数据库开发人员提供了一个标准的API，使他们能够用纯Java API 来编写数据库应用程序。
简单地说，JDBC 可做三件事：
l与数据库建立连接，
l发送 SQL 语句，
l处理结果。
 
*  （2）、Servlet技术
Servlet是运行在服务器端的程序，可以被认为是服务器端的applet。servlet被Web服务器（例如Tomcat）加载和执行，就如同applet被浏览器加载和执行一样。servlet从客户端(通过Web服务器)接收请求，执行某种操作，然后返回结果。
 
Servlet的主要优点包括
lServlet是持久的。servlet只需Web服务器加载一次，而且可以在不同请求之间保持服务(例如一次数据库连接)。
lServlet是与平台无关的。如前所述，servlet是用Java编写的，它自然也继承了Java的平台无关性。
lServlet是可扩展的。由于servlet是用Java编写的，它就具备了Java所能带来的所有优点。Java是健壮的、面向对象的编程语言，它很容易扩展以适应你的需求。servlet自然也具备了这些特征。
lServlet是安全的。从外界调用一个servlet的惟一方法就是通过Web服务器。这提供了高水平的安全性保障，尤其是在你的Web服务器有防火墙保护的时候。
lServlet可以在多种多样的客户机上使用。由于servlet是用Java编写的，所以你可以很方便地在HTML中使用它们。
 
* （3）、JavaServer Pages(JSP) 技术
JSP是从Servlet上分离出来的一小部分，简化了开发，加强了界面设计。JSP定位在交互网页的开发。运用Java语法，但功能较Servlet弱了很多，并且高级开发中只充当用户界面部分。JSP容器收到客户端发出的请求时，首先执行其中的程序片段，然后将执行结果以HTML格式响应给客户端。其中程序片段可以是：操作数据库、重新定向网页以及发送 E-Mail 等等，这些都是建立动态网站所需要的功能。所有程序操作都在服务器端执行，网络上传送给客户端的仅是得到的结果，与客户端的浏览器无关，因此，JSP 称为Server-Side Language。
 
**JavaServer Pages的主要优点包括**
>* 一次编写，各处执行(Write o­nce, Run Anywhere)特性
作为Java 平台的一部分，JavaServer Pages 技术拥有Java语言“一次编写，各处执行”的特点。随着越来越多的供货商将JavaServer Pages 技术添加到他们的产品中，您可以针对自己公司的需求，做出审慎评估后，选择符合公司成本及规模的服务器，假若未来的需求有所变更时，更换服务器平台并不影响之前所投下的成本、人力所开发的应用程序。
>* 搭配可重复使用的组件
JavaServer Pages技术可依赖于重复使用跨平台的组件（如：JavaBean或Enterprise JavaBean组件）来执行更复杂的运算、数据处理。开发人员能够共享开发完成的组件，或者能够加强这些组件的功能，让更多用户或是客户团体使用。基于善加利用组件的方法，可以加快整体开发过程，也大大降低公司的开发成本和人力。
>* 采用标签化页面开发
Web 网页开发人员不一定都是熟悉Java 语言的程序员。因此，JSP 技术能够将许多功能封装起来，成为一个自定义的标签，这些功能是完全根据XML 的标准来制订的，即JSP 技术中的标签库(Tag Library)。因此，Web 页面开发人员可以运用自定义好的标签来达成工作需求，而无须再写复杂的Java 语法，让Web 页面开发人员亦能快速开发出一动态内容网页。
今后，第三方开发人员和其他人员可以为常用功能建立自己的标签库，让Web 网页开发人员能够使用熟悉的开发工具，如同HTML 一样的标签语法来执行特定功能的工作。
>* N-tier 企业应用架构的支持
有鉴于网际网络的发展，为因应未来服务越来越繁杂的要求，且不再受地域的限制，因此，
必须放弃以往Client-Server的Two-tier 架构，进而转向更具威力、弹性的分散性对象系统。由于JavaServer Page 技术是Java 2 Platform Enterprise Edition (J2EE)集成中的一部分，它主要是负责前端显示经过复杂运算后之结果内容，而分散性的对象系统则是主要依赖EJB ( Enterprise JavaBean )和JNDI ( Java Naming and Directory Interface )构建而成。


* （4）、JavaBean(Application)应用组件技术
Application是Java应用程序，在WEB项目和一些开发中主要应用JavaBean。它就是Application的一部分，逻辑运算能力很强，能极大的发挥Java语言的优点。JavaBean 被称为是Java 组件技术的核心。JavaBean 的结构必须满足一定的命名约定。JavaBean能提供常用功能并且可以重复使用，这使得开发人员可以把某些关键功能和核心算法提取出来封装成为一个组件对象，这样就增加了代码的重用率和系统的安全性。

高级的WEB项目会应用到以上所有技术，它们之间联合使用和协作开发会提高开发的效率和系统的性能。 

#### 2、面向对象分析设计思想

Java语言是完全面向对象的语言，所以在项目设计时会有很大的帮助，在设计时应尽量舍弃以往的面向过程的设计方式。 

在分析项目业务关系的时候，应用一些UML(Unified Modeling Language)图,例如常用的用例图(use case diagram)，类图(class diagram)，时序图(sequence diagram)等等,会有很大的帮助，这样能尽快找出业务逻辑主要面对的对象，然后对每个对象进行行为划分，最后再实现对象之间的集成和通信。


#### 3、设计模式和框架结构

Java从语言角度来讲不是很难，但是从整体设计角度来讲我们还需要了解一些高级应用框架。如果要设计一个良好的框架结构，单单只掌握Java语言远远不够。这就涉及到一个设计模式，还有和设计模式相关的一些知识。 

设计模式在Java项目实施过程更是重中之重。主要在与两层的设计模式、三层的设计模式和Ｎ层的设计模式。它直接决定着项目的应用、部署和实际开发设计。 

在普通的WEB项目中很多采用两层的开发结构。JSP+Servlet或JSP+JavaBean。当对开发要求高的项目中使用很多的还是MVC的三层开发结构，也就是JSP+Servlet+JavaBean。它能分有效的分离逻辑开发，使开发人员能专注于各自的开发。同时也能时整个开发结构流程更清晰，但是需要比较高的开发配合度。 
在项目中，我们经常使用著名的Model-View-Controller(MVC)架构。MVC架构是随着smalltalk language语言的发展提出的，它是一个著名的用户界面设计架构。经典的MVC架构把一个组件（可认为是整个应用程序的一个模块）划分成三部分组 Model管理这个模块中所用到的数据和业务逻辑。而View 管理模块如何显示给用户，Controller 决定如何处理用户和该模块交互式时候产生的事件 如用户点击一个按钮等。 

#### 4、XML语言

在服务器和设计模式结构中会应用到自定义文件，而且在应用高级设计时也会定义自用的标签，现在流行的是用XML去定义配置，所以XML语言应该有一定掌握。

当前，Java 2平台企业版（J2EE）架构在厂商市场和开发者社区中倍受推崇。作为一种工具，可扩展标记语言（XML）简化了数据交换、进程间消息交换这一类的事情，因而对开发者逐渐变得有吸引力，并开始流行起来。自然，在J2EE架构中访问或集成XML解决方案的想法也很诱人。因为这将是强大系统架构同高度灵活的数据管理方案的结合。

XML的应用似乎是无穷无尽的，但它们大致上可以分为三大类：
* 1、简单数据的表示和交换（针对XML的简单API（SAX）和文档对象模型（DOM）语法解析，不同的文档类型定义（DTDs）和概要（schemas））
* 2、用户界面相关、表示相关的上下文（可扩展样式表语言（XSL），可扩展样式表语言转换（XSLT））
* 3、面向消息的计算（XML-RPC（远程过程调用），基于SOAP协议的Web 服务（Web Services），电子化业务XML（ebXML））

#### 5、网页脚本语言
 
为了提高WEB项目的整体性能，提高人机交互的友好界面，网页的脚本语言是很有用处的，有的时候可以解决很大的难题或提高程序的性能和应用性。 

网页脚本语言的执行都是在客户端执行的，速度很很快，并且大多的操作与服务器没有交互运算，所以在一些应用中非常理想。在设计WEB项目的应用中，网页的脚本语言起着不能忽视的作用，所以如果设计WEB项目的应用中，对JavaScript应有一定的了解。
 
JavaScript是一种基于对象(Object Based)和事件驱动(Event Driven)并具有安全性能（Secure）的脚本语言。使用它的目的是与HTML超文本标记语言、Java 脚本语言（Java小程序）一起实现在一个Web页面中链接多个对象，与Web客户交互作用。从而可以开发客户端的应用程序等。它是通过嵌入或调入在标准的HTML语言中实现的。它具有以下几个基本特点：

* 1.它是一种脚本编写语言
JavaScript是一种脚本语言，它采用小程序段的方式实现编程。像其它脚本语言一样,JavaScript同样已是一种解释性语言,它提供了一个易的开发过程。 
它的基本结构形式与C、C++、VB十分类似。但它不像这些语言一样，需要先编译，而是在程序运行过程中被逐行地解释。它与HTML标识结合在一起，从而方便用户的使用操作。

* 2. 基于对象的语言。
 JavaScript是一种基于对象的语言，同时以可以看作一种面向对象的。这意味着它能运用自己已经创建的对象。因此，许多功能可以来自于脚本环境中对象的方法与脚本的相互作用。

* 3.简单性
 JavaScript的简单性主要体现在：首先它是一种基于Java基本语句和控制流之上的简单而紧凑的设计, 从而对于学习Java是一种非常好的过渡。其次它的变量类型是采用弱类型，并未使用严格的数据类型。

* 4.安全性
 JavaScript是一种安全性语言，它不允许访问本地的硬盘，并不能将数据存入到服务器上，不允许对网络文档进行修改和删除，只能通过浏览器实现信息浏览或动态交互。从而有效地防止数据的丢失。

* 5. 动态性
 JavaScript是动态的，它可以直接对用户或客户输入做出响应，无须经过Web服务程序。它对用户的响应，是采用以事件驱动的方式进行的。所谓事件驱动，就是指在主页(Home Page)中执行了某种操作所产生的动作，就称为“事件”(Event)。比如按下鼠标、移动窗口、选择菜单等都可以视为事件。当事件发生后，可能会引起相应的事件响应。 

* 6、开发工具
>* （1）、数据库
在主要的应用中，数据库相关的环节应用很多，所以对数据库应该有一定了解。不能单单只了解一种数据库，因为在很多实际开发中会提出很多数据库解决方案，所以只有在了解多种数据库的情况下才能有一个比较方案。

对于数据库应该了解他的性能和一些基本的操作常识，还有该数据库的特点。而针对与Java语言WEB项目的数据库开发则主要是对JDBC的应用，还有数据库事务处理和连接池等高级概念的应用。
>* （2）、Web服务器
 
同数据库一样，应该了解该服务器的性能，特点和一些常识。
在应用方面，Web服务器主要是针对于配置和部署，对目录的配置，调试；对配置文件属性的修改；对访问权限和并发性的控制；Java类的部署等。


>* （3）、集成开发环境（IDE）：
“公欲善其事， 必先利其器”. 对于Web应用开发人员来讲，好的集成开发环境（IDE：Integrated Development Enviroment）是非常重要的。目前在市场上占主导位置的一个集成开发工具就是Eclipse.
学习有困难可以加扣：578024144进行交流得到帮助还可以关注微信公众号：javaniuniu获取免费得听课权限
原文地址：http://blog.csdn.net/javaniuniu/article/details/51880901


---


### JSP和Servlet的区别

**理解以下三点即可：**
#### 1、不同之处在哪？
* Servlet在Java代码中通过HttpServletResponse对象动态输出HTML内容
* JSP在静态HTML内容中嵌入Java代码，Java代码被动态执行后生成HTML内容


#### 2、各自的特点
* Servlet能够很好地组织业务逻辑代码，但是在Java源文件中通过字符串拼接的方式生成动态HTML内容会导致代码维护困难、可读性差
* JSP虽然规避了Servlet在生成HTML内容方面的劣势，但是在HTML中混入大量、复杂的业务逻辑同样也是不可取的


#### 3、通过MVC双剑合璧

既然JSP和Servlet都有自身的适用环境，那么能否扬长避短，让它们发挥各自的优势呢？答案是肯定的——MVC(Model-View-Controller)模式非常适合解决这一问题。
MVC模式（Model-View-Controller）是软件工程中的一种软件架构模式，把软件系统分为三个基本部分：模型（Model）、视图（View）和控制器（Controller）：

* Controller——负责转发请求，对请求进行处理
* View——负责界面显示
* Model——业务功能编写（例如算法实现）、数据库设计以及数据存取操作实现


#### 在JSP/Servlet开发的软件系统中，这三个部分的描述如下所示：

* 1. Web浏览器发送HTTP请求到服务端，被Controller(Servlet)获取并进行处理（例如参数解析、请求转发）
* 2. Controller(Servlet)调用核心业务逻辑——Model部分，获得结果
* 3. Controller(Servlet)将逻辑处理结果交给View（JSP），动态输出HTML内容
* 4. 动态生成的HTML内容返回到浏览器显示

MVC模式在Web开发中的好处是非常明显，它规避了JSP与Servlet各自的短板，Servlet只负责业务逻辑而不会通过out.append()动态生成HTML代码；JSP中也不会充斥着大量的业务代码，这大大提高了代码的可读性和可维护性。

---

### 请求转发和重定向区别

#### 一、调用方式

我们知道，在servlet中调用转发、重定向的语句如下：

* request.getRequestDispatcher("new.jsp").forward(request, response);   //转发到new.jsp

* response.sendRedirect("new.jsp");   //重定向到new.jsp

在jsp页面中你也会看到通过下面的方式实现转发：

* <jsp:forward page="apage.jsp" />

当然也可以在jsp页面中实现重定向：

* <%response.sendRedirect("new.jsp"); %> //重定向到new.jsp


#### 二、本质区别

* 解释一

一句话，转发是服务器行为，重定向是客户端行为。为什么这样说呢，这就要看两个动作的工作流程：

* 转发过程：客户浏览器发送http请求——》web服务器接受此请求——》调用内部的一个方法在容器内部完成请求处理和转发动作——》将目标资源发送给客户；在这里，转发的路径必须是同一个web容器下的url，其不能转向到其他的web路径上去，中间传递的是自己的容器内的request。在客户浏览器路径栏显示的仍然是其第一次访问的路径，也就是说客户是感觉不到服务器做了转发的。转发行为是浏览器只做了一次访问请求。

* 重定向过程：客户浏览器发送http请求——》web服务器接受后发送302状态码响应及对应新的location给客户浏览器——》客户浏览器发现是302响应，则自动再发送一个新的http请求，请求url是新的location地址——》服务器根据此请求寻找资源并发送给客户。在这里location可以重定向到任意URL，既然是浏览器重新发出了请求，则就没有什么request传递的概念了。在客户浏览器路径栏显示的是其重定向的路径，客户可以观察到地址的变化的。重定向行为是浏览器做了至少两次的访问请求的。

* 解释二

>* 重定向，其实是两次request，第一次，客户端request   A,服务器响应，并response回来，告诉浏览器，你应该去B。这个时候IE可以看到地址变了，而且历史的回退按钮也亮了。重定向可以访问自己web应用以外的资源。在重定向的过程中，传输的信息会被丢失。

例子：

response.sendRedirect("loginsuccess.jsp");

>* 请求转发是服务器内部把对一个request/response的处理权，移交给另外一个,对于客户端而言，它只知道自己最早请求的那个A，而不知道中间的B，甚至C、D。传输的信息不会丢失。

例子：

       RequestDispatcher dis=request.getRequestDispatcher(“loginsuccess.jsp”);

       Dis.forward(request,response);

* 解释三

假设你去办理某个执照

>* 重定向：你先去了A局，A局的人说：“这个事情不归我们管，去B局”，然后，你就从A退了出来，自己乘车去了B局。

>* 转发：你先去了A局，A局看了以后，知道这个事情其实应该B局来管，但是他没有把你退回来，而是让你坐一会儿，自己到后面办公室联系了B的人，让他们办好后，送了过来。

---

### Servlet的生命周期
#### 一、Servlet的生命周期

* Servlet的生命周期分为4个阶段：实例化- ->初始化- ->执行处理- ->销毁 
>* （1）实例化——new：服务器第一次被访问时，加载一个Servlet容器，而且只会被加载一次。 
>* （2）初始化——init：创建完Servlet容器后，会调用仅执行一次的init()初始化方法，用于初始化Servlet对象，无论多少台客户端在服务器运行期间访问都不会再执行init()方法。

可以在继承的GenericServlet这个抽象类中看到初始化方法：
```
public void init() throws ServletException {
}
```

而在我们的Servlet类中应继承调用该方法:
```
public void init() throws ServletException {
super.init();
}
```

>* （3）执行处理——service()方法：HttpServlet的抽象类提供了doGet()、doPost()……等方法。对应了request请求的发送方法，与之相匹配：
```
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
String protocol = req.getProtocol();
String msg = lStrings.getString("http.method_get_not_supported");
if (protocol.endsWith("1.1")) {
resp.sendError(405, msg);
} else {
resp.sendError(400, msg);
}

}
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
String protocol = req.getProtocol();
String msg = lStrings.getString("http.method_post_not_supported");
if (protocol.endsWith("1.1")) {
resp.sendError(405, msg);
} else {
resp.sendError(400, msg);
}

}
```

>* （4）销毁——destroy：在服务器关闭或重启时，Servlet会调用destroy方法来销毁，将Servlet容器标记为垃圾文件，让GC做回收处理。我们编写的Servlet是调用了GenericServlet抽象类的destroy方法：
```
@Override
public void destroy() {
super.destroy();
}
```

#### 二、Servlet的工作原理

* 1、首先简单解释一下Servlet接收和响应客户请求的过程： 

客户发送一个请求，Servlet是调用service()方法对请求进行响应的，通过源代码可见，service()方法中对请求的方式进行了匹配。选择调用doGet,doPost等这些方法，然后再进入对应的方法中调用逻辑层的方法，实现对客户的响应。在Servlet接口和GenericServlet中是没有doGet（）、doPost（）等等这些方法的，HttpServlet中定义了这些方法，但是都是返回error信息，所以，我们每次定义一个Servlet的时候，都必须实现doGet或doPost等这些方法。

* 2、每一个自定义的Servlet都必须实现Servlet的接口，Servlet接口中定义了五个方法，其中比较重要的三个方法涉及到Servlet的生命周期，分别是上文提到的init(),service(),destroy()方法。GenericServlet是一个通用的，不特定于任何协议的Servlet,它实现了Servlet接口。而HttpServlet继承于GenericServlet，因此HttpServlet也实现了Servlet接口。所以我们定义Servlet的时候只需要继承HttpServlet即可。
```
package javax.servlet;

import java.io.IOException;

public interface Servlet {
void init(ServletConfig var1) throws ServletException;

ServletConfig getServletConfig();

void service(ServletRequest var1, ServletResponse var2) throws ServletException, IOException;

String getServletInfo();

void destroy();
}
```

* 3、Servlet接口和GenericServlet是不特定于任何协议的，而HttpServlet是特定于HTTP协议的类，所以HttpServlet中实现了service()方法，并将请求ServletRequest、ServletResponse 强转为HttpRequest 和 HttpResponse。 
以上三点参考：Servlet的工作原理

* 4、另外，Servlet是单例模式，线程是不安全的，因此在service()方法中尽量不要操作全局变量。但实际上，可以通过使用session和application来代替全局变量，只是会加大服务器负载。三、Servlet处理请求的过程

>* 客户端发送请求给服务器。
>* 容器根据请求及web.xml判断对应的Servlet是否存在，如果不存在则返回404
>* 容器根据请求及web.xml判断对应的Servlet是否已经被实例化，若是相应的Servlet没有被实例化，则容器将会加载相应的Servlet到Java虚拟机并实例化
>* 调用实例对象的service()方法，并开启一个新的线程去执行相关处理。调用servce方法，判断是调用doGet方法还是doPost方法,业务完成后响应相关的页面发送给客户端。

---

### Filter过滤器
### 一、Filter简介

　　Filter也称之为过滤器，它是Servlet技术中最激动人心的技术之一，WEB开发人员通过Filter技术，对web服务器管理的所有web资源：例如Jsp,
Servlet, 静态图片文件或静态html文件等进行拦截，从而实现一些特殊的功能。例如实现URL级别的权限访问控制、过滤敏感词汇、压缩响应信息等
一些高级功能。
　　Servlet API中提供了一个Filter接口，开发web应用时，如果编写的Java类实现了这个接口，则把这个java类称之为过滤器Filter。通过Filter
技术，开发人员可以实现用户在访问某个目标资源之前，对访问的请求和响应进行拦截，Filter接口源代码：
```
public abstract interface Filter{  
    public abstract void init(FilterConfig paramFilterConfig) throws ServletException;  
    public abstract void doFilter(ServletRequest paramServletRequest, ServletResponse paramServletResponse, FilterChain   
        paramFilterChain) throws IOException, ServletException;  
    public abstract void destroy();  
}  
```

### 二、Filter是如何实现拦截的？(Filter的工作原理)

　　Filter接口中有一个doFilter方法，当我们编写好Filter，并配置对哪个web资源进行拦截后，WEB服务器每次在调用web资源的service方法之前，
都会先调用一下filter的doFilter方法，因此，在该方法内编写代码可达到如下目的：
    调用目标资源之前，让一段代码执行。
    是否调用目标资源（即是否让用户访问web资源）。
    调用目标资源之后，让一段代码执行。
　　web服务器在调用doFilter方法时，会传递一个filterChain对象进来，filterChain对象是filter接口中最重要的一个对象，它也提供了一个
doFilter方法，开发人员可以根据需求决定是否调用此方法，调用该方法，则web服务器就会调用web资源的service方法，即web资源就会被访问，
否则web资源不会被访问。

### 三、Filter开发流程

* 3.1、Filter开发步骤
* Filter开发分为2步：
>* 编写java类实现Filter接口，并实现其doFilter方法。
>* 在web.xml 文件中使用<filter>和<filter-mapping>元素对编写的filter类进行注册，并设置它所能拦截的资源。
**过滤器范例：**
```
import java.io.IOException;  
import javax.servlet.Filter;  
import javax.servlet.FilterChain;  
import javax.servlet.FilterConfig;  
import javax.servlet.ServletException;  
import javax.servlet.ServletRequest;  
import javax.servlet.ServletResponse;  
public class FilterTest implements Filter{  
    public void destroy() {  
        System.out.println("----Filter销毁----");  
    }  
    public void doFilter(ServletRequest request, ServletResponse response,FilterChain filterChain) throws IOException, ServletException {  
        // 对request、response进行一些预处理  
        request.setCharacterEncoding("UTF-8");  
        response.setCharacterEncoding("UTF-8");  
        response.setContentType("text/html;charset=UTF-8");  
        System.out.println("----调用service之前执行一段代码----");  
        filterChain.doFilter(request, response); // 执行目标资源，放行  
        System.out.println("----调用service之后执行一段代码----");  
    }  
    public void init(FilterConfig arg0) throws ServletException {  
        System.out.println("----Filter初始化----");  
    }  
}  
```

**在web. xml中配置过滤器：**
```
<?xml version="1.0" encoding="UTF-8"?>  
<web-app version="3.0"   
    xmlns="http://java.sun.com/xml/ns/javaee"   
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"   
    xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd">  
  <display-name></display-name>      
  <welcome-file-list>  
    <welcome-file>index.jsp</welcome-file>  
  </welcome-file-list>  
  <!--配置过滤器-->  
  <filter>  
      <filter-name>FilterTest</filter-name>  
      <filter-class>com.yangcq.filter.FilterTest</filter-class>  
  </filter>  
  <!--映射过滤器-->  
  <filter-mapping>  
      <filter-name>FilterTest</filter-name>  
      <!--“/*”表示拦截所有的请求 -->  
      <url-pattern>/*</url-pattern>  
  </filter-mapping>  
</web-app>  
```

* 3.2、Filter链
　　在一个web应用中，可以开发编写多个Filter，这些Filter组合起来称之为一个Filter链。web服务器根据Filter在web.xml文件中的注册顺序，
决定先调用哪个Filter，当第一个Filter的doFilter方法被调用时，web服务器会创建一个代表Filter链的FilterChain对象传递给该方法。在doFilter
方法中，开发人员如果调用了FilterChain对象的doFilter方法，则web服务器会检查FilterChain对象中是否还有filter，如果有，则调用第2个filter，
如果没有，则调用目标资源。





