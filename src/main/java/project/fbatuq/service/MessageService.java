package project.fbatuq.service;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import project.fbatuq.model.dto.MessageDTO;
import project.fbatuq.model.entity.Message;
import project.fbatuq.model.entity.User;
import project.fbatuq.repository.MessageRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    private final ModelMapper modelMapper;

    private MessageRepository messageRepository;
    private UserService userService;

    public MessageService(ModelMapper modelMapper, MessageRepository messageRepository, UserService userService) {
        this.modelMapper = modelMapper;
        this.messageRepository = messageRepository;
        this.userService = userService;
    }

    public ModelMapper getModelMapper() {
        return modelMapper;
    }

    public void addMessage(MessageDTO messageDTO, String userLogin) {
        messageDTO.setUser(userService.findUserByLogin(userLogin));
        Message message = modelMapper.map(messageDTO, Message.class);
        System.out.println("New message: " + message);
        messageRepository.save(message);
    }

    public List<MessageDTO> getAllMessages() {

        return messageRepository.findAll()
                .stream()
                .map(message -> modelMapper.map(message, MessageDTO.class))
                .collect(Collectors.toList());
    }

    public void deleteMessage(Long id){
        messageRepository.deleteById(id);
    }

}
