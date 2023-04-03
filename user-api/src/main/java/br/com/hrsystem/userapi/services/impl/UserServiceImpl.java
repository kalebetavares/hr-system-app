package br.com.hrsystem.userapi.services.impl;

import br.com.hrsystem.userapi.domain.User;
import br.com.hrsystem.userapi.repositories.UserRepository;
import br.com.hrsystem.userapi.resources.dto.UserDto;
import br.com.hrsystem.userapi.services.UserService;
import br.com.hrsystem.userapi.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Environment environment;

    @Override
    public User findById(Long id) {
        log.info("USER_SERVICE ::: Get request on " + environment.getProperty("local.server.port") + " port");
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(UserDto userDto) {
        return userRepository.save(new User(userDto));
    }
}
