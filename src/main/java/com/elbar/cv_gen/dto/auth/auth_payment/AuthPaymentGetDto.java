package com.elbar.cv_gen.dto.auth.auth_payment;

import com.elbar.cv_gen.dto.GenericDTO;
import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthPaymentGetDto extends GenericDTO {
    private Integer userId;
    private Integer templateId;
    private Integer transactionId;
}
