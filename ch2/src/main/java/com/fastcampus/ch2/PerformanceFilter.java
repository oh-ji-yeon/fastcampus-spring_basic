package com.fastcampus.ch2;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

// 필터를 적용할 요청의 패턴 지정 - 모든 요청에 필터를 적용.
@WebFilter(urlPatterns = "/*")
			// 필터를 적용할 요청에 대한 것 (어떤 요청에 필터를 적용할꺼야?)
public class PerformanceFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 초기화 작업
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 1. 전처리 작업 - 생략 가능, 서블릿에 적용할 코드
		long startTime = System.currentTimeMillis();

		// 2. 서블릿 또는 다음 필터를 호출 - 고정
		chain.doFilter(request, response);

		// 3. 후처리 작업 - 생략 가능, 서블릿에 적용할 코드
		System.out.print("[" + ((HttpServletRequest) request).getRequestURI() + "]");
		System.out.println(" 소요시간=" + (System.currentTimeMillis() - startTime) + "ms");
	}

	@Override
	public void destroy() {
		// 정리 작업
	}
}