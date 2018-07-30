package cn.liaohongdong.common;

import cn.liaohongdong.exception.ParamException;
import cn.liaohongdong.exception.ShrioException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SpringExceptionResolver implements HandlerExceptionResolver {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        String url = httpServletRequest.getRequestURL().toString();
        ModelAndView mv;
        String defaultMsg = "System error";
        if (e instanceof ShrioException || e instanceof ParamException) {
            JsonData data = JsonData.fail(e.getMessage());
            mv = new ModelAndView("jsonView", data.toMap());
        } else {
            JsonData data = JsonData.fail(e.getMessage());
            mv = new ModelAndView("jsonView", data.toMap());
        }
//        if (url.endsWith(".json")) {
//            if (e instanceof PermissionException || e instanceof ParamException) {
//                JsonData fail = JsonData.fail(e.getMessage());
//                mv = new ModelAndView("jsonView", fail.toMap());
//            } else {
//                logger.error("unknown json exception, url:" + url, e);
//                JsonData fail = JsonData.fail(defaultMsg);
//                mv = new ModelAndView("jsonView", fail.toMap());
//            }
//        } else if (url.endsWith(".page")) {
//            logger.error("unknown page exception, url:" + url, e);
//            JsonData fail = JsonData.fail(defaultMsg);
//            mv = new ModelAndView("exception", fail.toMap());
//        } else {
//            logger.error("unknown exception, url:" + url, e);
//            JsonData fail = JsonData.fail(defaultMsg);
//            mv = new ModelAndView("jsonView", fail.toMap());
//        }
        return mv;
    }
}
