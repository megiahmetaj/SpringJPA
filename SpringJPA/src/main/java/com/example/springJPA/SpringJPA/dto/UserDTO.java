package com.example.springJPA.SpringJPA.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @NotBlank(message = "Emri nuk duhet te jete bosh")
    private String name;

    @NotBlank(message = "Emaili nuk duhet te jete bosh")
    @Email(message = "Emaili nuk eshte ne formatin e duhur")
    private String email;

}
