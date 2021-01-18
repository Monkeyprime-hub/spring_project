package com.example.soulmate.internationalization;

import com.example.soulmate.hcache.Calculate;
import com.example.soulmate.profiling.SaySomething;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Scope("prototype")
@Controller
@RequestMapping()
public class HomeController {

    @Autowired
    private Calculate calculate;

    @Autowired
    SaySomething saySomething;

    @RequestMapping(value = "/first", method = RequestMethod.GET)
    public String first() {
        int result = calculate.sum(1, 2);
        System.out.println("****************************" + result);
        System.out.println("****************************");
        System.out.println("****************************");
        System.out.println("****************************");
        saySomething.say();
        return "first";
    }

    @RequestMapping(value = "/second", method = RequestMethod.GET)
    public String second() {
        int result = calculate.sum(1, 20);
        System.out.println("****************************" + result);
        return "second";
    }

}