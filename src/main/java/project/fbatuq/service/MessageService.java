package project.fbatuq.service;


import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import project.fbatuq.model.dto.MessageDTO;
import project.fbatuq.model.entity.Message;
import project.fbatuq.repository.MessageRepository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    private final ModelMapper modelMapper;

    private MessageRepository repository;

    public MessageService(ModelMapper modelMapper, MessageRepository repository) {
        this.modelMapper = modelMapper;
        this.repository = repository;
    }

    public ModelMapper getModelMapper() {
        return modelMapper;
    }

    public void addMessage(MessageDTO messageDTO) {
        Message message = modelMapper.map(messageDTO, Message.class);

        System.out.println("New message: " + message.getText());

        repository.save(message);
    }

    public List<MessageDTO> getAllVisibleMessages(Authentication authentication) {
        List<MessageDTO> msgList = new ArrayList<>();
        if (authentication == null) {

        }

    }

}
