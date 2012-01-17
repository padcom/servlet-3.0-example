package org.example.webapp;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@WebFilter(servletNames="example-servlet")
public class ExampleFilter implements Filter {
	private static final Log log = LogFactory.getLog(ExampleFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		if (log.isTraceEnabled())
			log.trace(String.format("init(%s)", filterConfig));
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if (log.isTraceEnabled())
			log.trace(String.format("BEGIN doFilter(%s, %s, %s)", request, response, chain));
		chain.doFilter(request, response);
		if (log.isTraceEnabled())
			log.trace(String.format("END doFilter(%s, %s, %s)", request, response, chain));
	}

	@Override
	public void destroy() {
		if (log.isDebugEnabled())
			log.debug("destroy()");
	}

}
