package com.ysc.blogalone.interceptor;


import com.ysc.blogalone.constant.YSConstant;
import com.ysc.blogalone.exception.YscException;
import com.ysc.blogalone.util.JwtTool;
import com.ysc.blogalone.util.UserContext;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Version: 1.0
 * Class Name: LoginInterceptor
 * Description: TODO(一句话描述功能)
 * Author: ysc
 * Date: 2024/3/31 18:22
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        String token = request.getHeader("Authorization");
        if (!StringUtils.hasText(token)) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            try (PrintWriter writer = response.getWriter()) {
                writer.print(YSConstant.HAS_NOT_LOGIN);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }

        Long userId = null;
        try {
            userId = Long.valueOf(JwtTool.parseJWT(token).getSubject());
        } catch (Exception e) {
            e.printStackTrace();
        }

        if ( userId == null ) {
            throw new YscException(YSConstant.HAS_NOT_LOGIN);
        }
        UserContext.setUser(Long.valueOf(userId));
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        UserContext.removeUser();
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
