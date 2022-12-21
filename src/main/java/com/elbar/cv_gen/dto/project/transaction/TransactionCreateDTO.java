package com.elbar.cv_gen.dto.project.transaction;

import com.elbar.cv_gen.annotation.IdConstraint;
import com.elbar.cv_gen.dto.BaseDTO;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TransactionCreateDTO implements BaseDTO {
    @IdConstraint
    private Integer templateId;
    @IdConstraint
    private Integer userId;
    @IdConstraint
    private Integer cardId;
    @NotNull
    @Min(1)
    private Long amount;
}
