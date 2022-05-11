package cn.ipangbo.internshiphw4mvc.interceptor;

import cn.ipangbo.internshiphw4mvc.utils.JwtUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        if (token != null && !"".equals(token) && JwtUtils.validateToken(token)) {
            return true;
        }
        response.setStatus(401);
        return false;
    }
}