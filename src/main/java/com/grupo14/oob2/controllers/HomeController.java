package com.grupo14.oob2.controllers;

import com.grupo14.oob2.utils.ViewRouteHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;




@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.INDEX);
        return modelAndView;
    }

    @GetMapping("/")
    public RedirectView redirectToHomeIndex() {
        return new RedirectView(ViewRouteHelper.ROUTE);
    }



}
