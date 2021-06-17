package study.springcoreprinciple.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import study.springcoreprinciple.common.MyLogger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody // 문자열을 그대로 응답을 보낼 수 있음
    public String logDemo(HttpServletRequest request) {
        var requestURL = request.getRequestURL().toString();
        System.out.println("myLogger: " + myLogger.getClass());
        myLogger.setRequestURL(requestURL);
        System.out.println("myLogger: " + myLogger.getClass());
        myLogger.log("Controller test");
        logDemoService.logic("testId");
        return "OK";
    }

}
