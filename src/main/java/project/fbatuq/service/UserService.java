package project.fbatuq.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import project.fbatuq.model.dto.UserDTO;
import project.fbatuq.model.entity.User;
import project.fbatuq.repository.UserRepository;

@Service
public class UserService {

    private final ModelMapper modelMapper;

    private UserRepository repository;

    public UserService(ModelMapper modelMapper, UserRepository repository) {
        this.modelMapper = modelMapper;
        this.repository = repository;
    }

    public void addNewUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        System.out.println("We have a new user: " + userDTO.getLogin());
        repository.save(user);
    }

}
