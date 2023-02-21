package shop.mtcoding.loginexample.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import shop.mtcoding.loginexample.controller.MainController;
import shop.mtcoding.loginexample.model.User;

@Component
public class CustomInterceptor implements HandlerInterceptor {

    // @Autowired
    // private HttpSession session;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        // MainController obj = new MainController();
        // final Logger logger = LoggerFactory.getLogger(obj.getClass());

        final Logger logger = LoggerFactory.getLogger("[preHandle]");

        logger.info("PreHandle 진입!");

        HttpSession session = request.getSession();
        User principal = (User) session.getAttribute("principal");
        if (principal == null) {
            // return false;
            throw new Exception("오류 발생");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable Exception ex)
            throws Exception {
    }
}