package com.elbar.cv_gen.dto.auth.auth_block;

import com.elbar.cv_gen.dto.BaseDTO;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthBlockCreateDTO implements BaseDTO {
    @NotNull
    @Min(1)
    private Integer userId;
    @NotBlank
    @Size(min = 2, max = 120)
    private String blockedFor;
}
