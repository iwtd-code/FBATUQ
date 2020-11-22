package project.fbatuq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import project.fbatuq.model.dto.UserDTO;
import project.fbatuq.service.UserService;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/adduser")
    public ModelAndView getAddNewUserData () {
        return new ModelAndView("adduser", "newUser", new UserDTO());
    }

    @PostMapping("/adduser")
    public String addNewUserAccount (@ModelAttribute UserDTO userDTO) {
        userService.addNewUser(userDTO);
        return "index";
    }
}
