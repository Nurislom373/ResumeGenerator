package com.elbar.cv_gen.dto.auth.auth_card;

import com.elbar.cv_gen.dto.BaseDTO;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthCardCreateDto implements BaseDTO {
    @NotNull(message = "Unknown user")
    private Integer userId;
    @NotBlank(message = "Enter Card type")
    @Size(min = 3, max = 120, message = "Wrong cardType")
    private String cardType;
    @NotBlank(message = "Enter holder name")
    @Size(min = 3, max = 120, message = "Wrong cardType")
    private String holderName;
    @NotBlank(message = "Enter Card number")
    @Size(min = 16, max = 16, message = "Invalid card number.")
    private String cardNumber;
    @NotBlank(message = "Enter expire date of card")
    @Pattern(regexp = "^(1[0-2]|0[1-9])/[0-9]{4}$")
    private String expire;
}
