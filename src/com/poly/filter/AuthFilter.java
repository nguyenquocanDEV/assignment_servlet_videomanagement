package com.poly.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.poly.common.SessionUtils;

@WebFilter(urlPatterns = "/*")
public class AuthFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	    throws IOException, ServletException {
	request.setAttribute("isLogin", SessionUtils.isLogn((HttpServletRequest) request));
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");

	chain.doFilter(request, response);
    }

}
