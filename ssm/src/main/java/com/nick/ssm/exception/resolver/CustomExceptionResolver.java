package com.nick.ssm.exception.resolver;


import com.nick.ssm.exception.CustomExcetion;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception ex) {

        String message = "";

        //异常处理逻辑
        if (ex instanceof CustomExcetion) {
            message = ((CustomExcetion)ex).getMsg();
        }else {
            message = "未知错误";
        }

        ModelAndView mv = new ModelAndView();
        mv.setViewName("error");
        mv.addObject("message", message);

        return mv;
    }

}
