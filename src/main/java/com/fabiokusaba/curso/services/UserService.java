package com.fabiokusaba.curso.services;

import com.fabiokusaba.curso.dtos.global.MessageDTO;
import com.fabiokusaba.curso.dtos.user.UserCreateReqDTO;
import com.fabiokusaba.curso.entities.UserEntity;
import com.fabiokusaba.curso.repositories.UserRepository;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public ResponseEntity<MessageDTO> create(UserCreateReqDTO body) {
        if (userRepository.existsByEmail(body.email())) {
            throw new EntityExistsException("Usuário já cadastrador");
        }

        UserEntity user = new UserEntity();
        user.setEmail(body.email());
        user.setPassword(body.password());

        userRepository.save(user);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new MessageDTO("Usuário criado com sucesso!"));
    }
}
