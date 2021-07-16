package com.imageupload.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class RequestFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("atleash reached here");
		chain.doFilter(request, response);
		
		HttpServletResponse hserResp= (HttpServletResponse) response;
		
		hserResp.setHeader(HttpHeaders.CONNECTION, "close");
	}

}
