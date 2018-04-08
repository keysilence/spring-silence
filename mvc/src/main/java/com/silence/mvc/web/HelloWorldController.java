package com.silence.mvc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.Callable;

/**
 * Created by Silence on 2018/4/3.
 */
@Controller
@RequestMapping("/first")
public class HelloWorldController {

    @Autowired
    private RequestMappingHandlerMapping handlerMapping;

    @RequestMapping("/index.html")
    public String index(Model model) {

        model.addAttribute("message", "Hello World!");

        return "index.html";

    }

    //TODO 唯有JSP的没有成功，后面继续研究
    @RequestMapping("/helloWorldJsp")
//    @ResponseBody
    public ModelAndView helloWorldJsp() {

        ModelAndView modelAndView = new ModelAndView("jsp");
        modelAndView.addObject("jsp", "Hello World!");

        return modelAndView;

    }

    @RequestMapping("/helloWorldVelocity")
//    @ResponseBody
    public String helloWorldVelocity(Model model) {

        model.addAttribute("test", "Hello World!");

        return "velocity";

    }

    @RequestMapping("/helloWorldFreemarker")
//    @ResponseBody
    public String helloWorldFreemarker(Model model) {

        model.addAttribute("msg", "Hello World!");

        return "freemarker";

    }

    @RequestMapping("/matrix/{type}")
    @ResponseBody
    public String matrixParam(@PathVariable Integer type,
                              @MatrixVariable String q1) {

        //TODO 一直没有试验成功，后面再看
        //GET /matrix/42;q1=11;q2=22
        StringBuffer sb = new StringBuffer();
        sb.append("type:");
        sb.append(type);
        sb.append(";q1:");
        sb.append(q1);

        return sb.toString();

    }

    @RequestMapping(value = "/contentType", consumes = "application/json")
    @ResponseBody
    public String contentType() {

        //根据可消费的媒体consumes = "application/json"进行匹配
        return "contentType";

    }

    @RequestMapping(value = "/headers", headers = "headerKey=headerValue")
    @ResponseBody
    public String headers() {

        //根据请求头中的键值对进行匹配
        return "headers";

    }

    @RequestMapping(value = "/params", params = "param=paramValue")
    @ResponseBody
    public String params(@RequestParam String param) {

        //根据请求参数中的键值对进行匹配
        return "params";

    }

    @RequestMapping(value = "/processUpload")
//    @ResponseBody
    public Callable<String> processUpload(String file) {

        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "processUpload";
            }
        };

    }

    @RequestMapping("/deferredResult")
    @ResponseBody
    public DeferredResult<String> deferredResult() {

        DeferredResult<String> deferredResult = new DeferredResult<>();
        return deferredResult;

    }

    @RequestMapping("/handle")
    public ResponseBodyEmitter handle() {

        ResponseBodyEmitter emitter = new ResponseBodyEmitter();
        return emitter;

    }

    @RequestMapping("/download")
    public StreamingResponseBody download() {

        return new StreamingResponseBody() {

            @Override
            public void writeTo(OutputStream outputStream) throws IOException {
                String a = "hh";
            }

        };

    }

}
