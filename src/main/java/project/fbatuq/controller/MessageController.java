package project.fbatuq.controller;


import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import project.fbatuq.model.dto.MessageDTO;
import project.fbatuq.service.MessageService;

import java.sql.Timestamp;
import java.time.LocalDateTime;
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
        messageDTO.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userLogin = authentication.getName();
        System.out.println(userLogin + messageDTO);
        messageService.addMessage(messageDTO, userLogin);
        return "redirect:/addmsg";
    }

    @GetMapping("/msg")
    public ModelAndView getAllMsgs() {
        List<MessageDTO> messageDTOList = messageService.getAllMessages();
        return new ModelAndView("msg", "messageDTOList", messageDTOList);
    }
    @PostMapping("/deletemsg")
    public String deleteMessage(@ModelAttribute MessageDTO messageDTO){
        messageService.deleteMessage(messageDTO.getId());
        return "redirect:/msg";
    }

}
