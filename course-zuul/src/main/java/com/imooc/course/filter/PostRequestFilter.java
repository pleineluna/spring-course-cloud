package com.imooc.course.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * Description:后置过滤器
 */
@Component
public class PostRequestFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;//后置过滤器
    }

    @Override
    public int filterOrder() {
        //FilterConstants.SEND_RESPONSE_FILTER_ORDER==1000 ；是已经定义好的一些常量
        //数字越大，执行顺序越晚。FilterConstants.SEND_RESPONSE_FILTER_ORDER - 1标识是在最后发送相应之前执行
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        System.out.println("Response状态码:::"+currentContext.getResponse().getStatus());
        return null;
    }
}
