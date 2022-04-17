package com.navnathjadhav.requestvalidation.dto;

import javax.validation.constraints.*;

public record UserRequest(@NotNull(message = "Name is required") String name,
                          @Min(18) @Max(50) int age,
                          @Email(message = "Invalid email format") String email,
                          @NotBlank(message = "Password is required") String password,
                          @NotNull(message = "Mobile number is required") Number mobileNo) {
}
