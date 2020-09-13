/*
 * Copyright (c) 2018-2999 广州亚米信息科技有限公司 All rights reserved.
 *
 * https://www.gz-yami.com/
 *
 * 未经允许，不可做商业用途！
 *
 * 版权所有，侵权必究！
 */

package com.chryl.common.filter;

import com.chryl.common.xss.XssWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 一些简单的安全过滤：
 * xss
 * @author lgh
 */
public class XssFilter implements Filter {
    Logger logger = LoggerFactory.getLogger(getClass().getName());
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        
        logger.info("uri:{}",req.getRequestURI());
        // xss 过滤
		chain.doFilter(new XssWrapper(req), resp);
    }

    @Override
    public void destroy() {

    }
}
