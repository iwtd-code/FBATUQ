package project.fbatuq.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @GetMapping(value = {"/", "/index"})
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @GetMapping("/login")
    public String login(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userLogin = authentication.getName();
        model.addAttribute("userLogin", userLogin);
        System.out.println("User "+ userLogin + " logged.");
        return "login";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }



}
