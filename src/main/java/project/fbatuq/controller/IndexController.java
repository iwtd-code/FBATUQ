package project.fbatuq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @GetMapping(value = {"/", "/index"})
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/about")
    public ModelAndView about() {
        return new ModelAndView("about");
    }
}
