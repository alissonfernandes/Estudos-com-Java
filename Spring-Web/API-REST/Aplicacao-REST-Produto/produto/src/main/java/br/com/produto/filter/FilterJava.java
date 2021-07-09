package br.com.produto.filter;

import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

@Component
public class FilterJava implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig); //To change body of generated methods, choose Tools | Templates.
    }

    @Override //To change body of generated methods, choose Tools | Templates.
    public void doFilter(ServletRequest sr, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) sr;
        Enumeration<String> headerNames = req.getHeaderNames();
        Map<String, String> mapHeaders = Collections.list(headerNames)
                .stream().collect(Collectors.toMap(it -> it, req::getHeader));
        
        if(mapHeaders.get("authorization") != null && mapHeaders.get("authorization").equals("admin")){
            chain.doFilter(sr, res);
        }else{
            HttpServletResponse response = (HttpServletResponse) res;
            response.sendError(403);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
