package project.fbatuq.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import project.fbatuq.model.dto.MessageDTO;
import project.fbatuq.service.MessageService;

import java.util.List;


@Controller
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/addmsg")
    public ModelAndView getAddMessageView() {
        return new ModelAndView("addmsg", "newMessage", new MessageDTO());
    }

    @PostMapping("/addmsg")
    public String addNewMessage(@ModelAttribute MessageDTO messageDTO){
        System.out.println(messageDTO.getText());
        messageService.addMessage(messageDTO);
        return "index";
    }

    @GetMapping("/msg")
    public ModelAndView getAllMsgs() {
        List<MessageDTO> messageDTOList = messageService.getAllMessages();
        return new ModelAndView("msg", "messageDTOList", messageDTOList);
    }
}
