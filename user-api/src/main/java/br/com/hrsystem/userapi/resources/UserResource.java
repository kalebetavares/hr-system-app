package br.com.hrsystem.userapi.resources;

import br.com.hrsystem.userapi.domain.User;
import br.com.hrsystem.userapi.resources.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserResource {

    @GetMapping(value = "/{id}")
    ResponseEntity<User> findById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<User>> findAll();

    @PostMapping
    ResponseEntity<User> create(@RequestBody UserDto userDto);

}
