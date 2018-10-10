package com.zcb.filter.demo.filter;

import org.apache.catalina.servlet4preview.http.HttpServletRequestWrapper;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Vector;

/**
 * Created by zhuocongbin
 * date 2018/10/10
 */
@Component
@WebFilter(urlPatterns = "/*", filterName = "myFilter")
public class FirstFilter extends OncePerRequestFilter{


    @Override
    public void destroy() {

    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        ModifyParametersWrapper modifyParametersWrapper = new ModifyParametersWrapper(httpServletRequest);
        filterChain.doFilter(modifyParametersWrapper, httpServletResponse);
    }

    private class ModifyParametersWrapper extends HttpServletRequestWrapper{
        private Map<String, String[]> parameterMap;
        /**
         * Constructs a request object wrapping the given request.
         *
         * @param request The request to wrap
         * @throws IllegalArgumentException if the request is null
         */
        public ModifyParametersWrapper(HttpServletRequest request) {
            super(request);
            parameterMap = request.getParameterMap();
        }

        @Override
        public Enumeration<String> getParameterNames() {
            Vector<String> vector = new Vector<String>(parameterMap.keySet());
            return vector.elements();
        }

        @Override
        public String getParameter(String name) {
            String[] results = parameterMap.get(name);
            if (results == null || results.length <= 0)
                return null;
            else {
                System.out.println("修改之前： " + results[0]);
                return modify(results[0]);
            }
        }
        @Override
        public String[] getParameterValues(String name) {
            String[] results = parameterMap.get(name);
            if (results == null || results.length <= 0)
                return null;
            else {
                int length = results.length;
                for (int i = 0; i < length; i++) {
                    System.out.println("修改之前2： " + results[i]);
                    results[i] = modify(results[i]);
                }
                return results;
            }
        }

        /**
         * 自定义的一个简单修改原参数的方法，即：给原来的参数值前面添加了一个修改标志的字符串
         *
         * @param string
         *            原参数值
         * @return 修改之后的值
         */
        private String modify(String string) {
            return "Modified: " + string;
        }
    }
}
