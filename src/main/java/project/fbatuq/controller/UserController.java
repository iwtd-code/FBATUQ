package project.fbatuq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import project.fbatuq.model.dto.UserDTO;

@Controller
public class UserController {

    @GetMapping("/adduser")
    public ModelAndView getAddNewUserData () {
        return new ModelAndView("adduser", "newUser", new UserDTO());
    }
}
