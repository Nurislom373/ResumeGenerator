package com.elbar.cv_gen.dto.auth.auth_card;

import com.elbar.cv_gen.dto.GenericDTO;
import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthCardUpdateDto extends GenericDTO {
    @Size(min = 3, max = 120, message = "Wrong cardType")
    private String cardType;
    @Size(min = 3, max = 120, message = "Wrong cardType")
    private String holderName;
    @Size(min = 16, max = 16, message = "Invalid card number.")
    private String cardNumber;
    @Pattern(regexp = "^(1[0-2]|0[1-9])/[0-9]{4}$")
    private String expire;
}
