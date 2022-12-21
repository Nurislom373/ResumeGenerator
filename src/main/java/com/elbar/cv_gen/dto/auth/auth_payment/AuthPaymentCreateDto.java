package com.elbar.cv_gen.dto.auth.auth_payment;

import com.elbar.cv_gen.dto.BaseDTO;
import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthPaymentCreateDto implements BaseDTO {
    @NotNull(message = "User id cannot be null")
    private Integer userId;
    @NotNull(message = "User template cannot be null")
    private Integer templateId;
    @NotNull(message = "User transaction cannot be null")
    private Integer transactionId;
}
