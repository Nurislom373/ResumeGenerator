package com.elbar.cv_gen.dto.auth.auth_card;

import com.elbar.cv_gen.dto.GenericDTO;
import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthCardDto extends GenericDTO {
    private Integer userId;
    private String cardType;
    private String holderName;
    private String cardNumber;
    private String expire;
}
