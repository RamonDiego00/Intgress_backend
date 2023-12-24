package com.mondi.intgress.controllers;

import com.mondi.intgress.dtos.LoginDto;
import com.mondi.intgress.dtos.UserRecordDto;
import com.mondi.intgress.models.UserModel;
import com.mondi.intgress.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/create")
    public ResponseEntity<UserModel> createUser(@RequestBody @Valid UserRecordDto userRecordDto) {
        var userModel = new UserModel();
        BeanUtils.copyProperties(userRecordDto, userModel);

//        userModel.setEmail(userRecordDto.getEmail());
//        userModel.setPassword(userRecordDto.getPassword());


        userModel = userRepository.save(userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userModel);
    }

    @PostMapping("/login")
    public ResponseEntity<UserModel> login(@RequestBody @Valid LoginDto loginDto) {
        var user = userRepository.findByEmail(loginDto.getEmail());

        if (user.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        return ResponseEntity.ok(user.get());
    }


    @PutMapping("/{id}")
    public ResponseEntity<UserModel> updateUser(@PathVariable UUID id, @RequestBody @Valid UserRecordDto userRecordDto) {
        var userModel = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));

        BeanUtils.copyProperties(userRecordDto, userModel, "id", "createdAt", "updatedAt");

        return ResponseEntity.ok(userRepository.save(userModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        userRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }



}
