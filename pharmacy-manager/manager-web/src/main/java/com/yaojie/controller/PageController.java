package com.yaojie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Author  madao
 * Created by madao on 2016/11/7.
 * 通用页面的跳转
 */
@Controller
public class PageController {

    @RequestMapping(value = "/page/{pageName}",method = RequestMethod.GET)
    public String tpage(@PathVariable String pageName){
        return pageName;
    }

    @RequestMapping(value = "/_page/{pageName}",method = RequestMethod.GET)
    public ModelAndView _tpage(@PathVariable String pageName){
        ModelAndView model = new ModelAndView(pageName+".btl");
        return model;
    }
}
