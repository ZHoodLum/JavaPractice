package com.struts.util;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import com.struts.util.Constants;

public class FilterStation extends HttpServlet implements Filter {
    private FilterConfig filterConfig;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain) throws ServletException,
            IOException {
       HttpSession session=((HttpServletRequest)request).getSession();
       response.setCharacterEncoding("gb2312");
       //response.setHeader("Cache-Control", "no-cache");
   	   //response.setHeader("Cache-Control", "no-store");
       if(session.getAttribute("username")==null){
       PrintWriter out=response.getWriter();
       out.print("<script type="+"text/javascript"+">alert('"+Constants.PLEASElOGIN+"');window.location.href='../index.do';</script>");
       }else{
        filterChain.doFilter(request, response);
       }
    }

    public void destroy() {
    }
}

