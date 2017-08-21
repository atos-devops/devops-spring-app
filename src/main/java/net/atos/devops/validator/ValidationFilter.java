package net.atos.devops.validator;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

public class ValidationFilter implements Filter{
	
	final static Logger logger = Logger.getLogger(ValidationFilter.class);
	
	@Override
	public void destroy() {
		logger.info("ValidationFilter.destroy()....");		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		logger.info("ValidationFilter.doFilter()....");	
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		logger.info("ValidationFilter.init()....");
	}

}
