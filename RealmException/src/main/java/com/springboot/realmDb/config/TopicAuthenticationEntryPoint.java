 package com.springboot.realmDb.config;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class TopicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint{
	
	@Override
	public void commence(HttpServletRequest request,HttpServletResponse response,AuthenticationException authException) throws IOException {
		
		response.addHeader("WWW-Authenticate","Basic Realm=\"" + getRealmName()+ "\"");
		
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED,authException.getMessage());
	}
	
	@Override
	public void afterPropertiesSet() {
		setRealmName("Topic Security application Realm");
	}
}
