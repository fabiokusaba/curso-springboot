package com.fabiokusaba.curso.dtos.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserCreateReqDTO(
        @NotBlank
        @Email(message = "{validation.email}")
        String email,

        @NotBlank
        String password
) {
}
