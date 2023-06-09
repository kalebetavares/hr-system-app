package br.com.hrsystem.userapi.resources.impl;

import br.com.hrsystem.userapi.domain.User;
import br.com.hrsystem.userapi.resources.UserResource;
import br.com.hrsystem.userapi.resources.dto.UserDto;
import br.com.hrsystem.userapi.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/users")
public class UserResourceImpl implements UserResource {

    private final UserService userService;

    @Override
    public ResponseEntity<User> findById(Long id) {
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @Override
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok().body(userService.findAll());
    }

    @Override
    public ResponseEntity<User> create(UserDto userDto) {
        return ResponseEntity.ok().body(userService.save(userDto));
    }
}
