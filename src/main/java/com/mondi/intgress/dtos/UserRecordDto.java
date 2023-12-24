package com.mondi.intgress.dtos;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;

public record UserRecordDto(  @NotBlank String name,
                              @NotBlank @Nullable String email,
                              @NotBlank @Nullable String photo,
                              @NotBlank @Nullable String phoneNumber,
                              @NotBlank String password) {
}
