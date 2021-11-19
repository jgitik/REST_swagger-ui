package rest.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rest.configuration.dto.UserDto;
import rest.exception.UserAlreadyExistException;
import rest.exception.UserNotFoundException;
import rest.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public List<UserDto> getAllUsers() {
        return userRepository.getAllEntity()
                .stream()
                .map(UserDto::new)
                .collect(Collectors.toList());

    }

    public UserDto getUserByEmail(String email) {
        if (userRepository.findUserByEmail(email).isEmpty())
            throw new UserNotFoundException("User not found");
        return new UserDto(userRepository.findUserByEmail(email).get());

    }

    public UserDto createUser(UserDto newUser) {
        if (userRepository.findUserByEmail(newUser.getEmail()).isPresent())
            throw new UserAlreadyExistException("User  already exist");

        return new UserDto(userRepository.createEntity(newUser.toUserEntity(newUser)));

    }


}




