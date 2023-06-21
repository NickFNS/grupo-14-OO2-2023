package com.grupo14.oob2.controllers;

import com.grupo14.oob2.dtos.DispositivoCreate;
import com.grupo14.oob2.utils.ViewRouteHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String index(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("role", user.getAuthorities().toString());
        return ViewRouteHelper.INDEX;
    }

    @GetMapping("/")
    public RedirectView redirectToHomeIndex() {
        RedirectView redirect =new RedirectView(ViewRouteHelper.ROUTE);
        if(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString() == "anonymousUser"){
            return new RedirectView(ViewRouteHelper.USER_LOGIN);
        }
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(user.getUsername());
        if(user.getUsername() == null) {
            redirect = new RedirectView(ViewRouteHelper.USER_LOGIN);
        }
        return redirect;
    }
}
