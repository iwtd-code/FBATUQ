package project.fbatuq.service;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import project.fbatuq.model.dto.MessageDTO;
import project.fbatuq.model.entity.Message;
import project.fbatuq.repository.MessageRepository;

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

    public void addMessage(MessageDTO messageDTO){
        Message message = modelMapper.map(messageDTO, Message.class);

        System.out.println("New message: " + message.getText());

        repository.save(message);
    }

    public List<MessageDTO> getAllVisibleMessages() {
        //!!!!!DO ZROBIENIA - jak dostać z bazy tylko te wiadomości co widoczne dla przekazanego usera
        return repository.findAll()
                .stream()
                .map(msg -> modelMapper.map(msg, MessageDTO.class))
                .collect(Collectors.toList());
    }

}
