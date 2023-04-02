package br.com.hrsystem.userapi.services.impl;

import br.com.hrsystem.userapi.domain.User;
import br.com.hrsystem.userapi.repositories.UserRepository;
import br.com.hrsystem.userapi.services.UserService;
import br.com.hrsystem.userapi.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
