package org.softuni.mobilele.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.softuni.mobilele.model.validation.FieldMatch;
import org.softuni.mobilele.model.validation.UniqueUserEmail;

@FieldMatch(
        first = "password",
        second = "confirmPassword",
        message = "Password should match."
)
public record UserRegistrationDto (@NotEmpty String firstName,
                                   String lastName,
                                   @NotNull
                                           @Email
                                           @UniqueUserEmail
                                   String email,
                                   String password,
                                   String confirmPassword){

}
