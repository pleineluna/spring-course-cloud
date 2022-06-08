package com.imooc.course.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * Description:前置过滤器
 */
@Component
public class PreRequestFilter extends ZuulFilter {
    //指明过滤器类型
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;//前置过滤器
    }
    //指明过滤器执行顺序
    @Override
    public int filterOrder() {
        return 5;
    }
    //是否走此过滤器，可以配合条件进行选择性过滤
    @Override
    public boolean shouldFilter() {
        return true;
    }
    //过滤器的具体业务逻辑
    @Override
    public Object run() throws ZuulException {
        String currentURI = RequestContext.getCurrentContext().getRequest().getRequestURI();
        System.out.println("URI:::"+currentURI);
        return null;
    }
}
