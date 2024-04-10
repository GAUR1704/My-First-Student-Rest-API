package com.prowings.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoggingInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

//		Log the request URL and method

		System.out.println(">>>>>> Inside Logging Interceptor method <<<<<<");
		System.out.println("Request URL : " + request.getRequestURI().toString());
		System.out.println("Request method : " + request.getMethod());

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("Outgoing Response Headers: ");
		
		response.getHeaderNames().forEach(headerName -> System.out.println(headerName + ": " + response.getHeader(headerName)));
		
		System.out.println("Outgoing Response Status Code: " + response.getStatus());
		
		System.out.println("Handler execution completed.");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		System.out.println("Request proceesing completed");
	}

}
