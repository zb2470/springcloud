package com.example.demo.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
@RefreshScope
public class PreFilter extends ZuulFilter {

    @Value("${token}")
    private boolean token;

    //类型
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    //同类型之间的优先级
    @Override
    public int filterOrder() {
        return 0;
    }

    //是否显示
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        //RequestContext :过滤器数据存储的位置
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

//        String key = request.getParameter("key");
//        System.out.println(key + "access filter 1");
//        if ("1".equals(key)) {
//            ctx.setSendZuulResponse(false);
//        } else {
//            ctx.set("third_filter", false);
//        }
//
//        return null;
        System.out.println("token" + token);
        if (!token) {
            return "pass";
        }
        String token = request.getHeader("token");
        if (token == null || token.equals("")) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("{\"msg\":\"401 account without permission, pls login first\"}");

            return "access denied";
        }

        return "pass";
    }
}
