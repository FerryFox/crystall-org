package com.example.salesfox;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController 
{
    @RequestMapping(value = {"/"})
    public String forwardReactApp() {
        return "forward:/index.html";
    }
}
