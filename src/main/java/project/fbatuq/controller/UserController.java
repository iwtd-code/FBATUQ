package project.fbatuq.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import project.fbatuq.model.dto.UserDTO;

public class UserController {

    @GetMapping("/adduser")
    public ModelAndView getAddNewUserData () {
        return new ModelAndView("adduser", "newUser", new UserDTO());
    }
}
