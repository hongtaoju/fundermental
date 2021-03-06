/*
 * module: fundermental
 * file: InitController.java
 * date: 4/5/20 4:51 PM
 * author: VectorJu
 */

/*
 * module: fundermental
 * file: InitController.java
 * date: 4/5/20 4:20 PM
 * author: VectorJu
 */

/**
 * @create 2020-04-05 16:19
 * @desc jump into websockpage
 **/
package com.sd.lx.vector.ws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

@Controller
public class InitController {

    @RequestMapping("/websocketpage")
    public String start() {
        return "websockpage";
    }
}

