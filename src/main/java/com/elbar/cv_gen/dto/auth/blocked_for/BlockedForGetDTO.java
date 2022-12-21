package com.elbar.cv_gen.dto.auth.blocked_for;

import com.elbar.cv_gen.dto.GenericDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BlockedForGetDTO extends GenericDTO {
    private String code;
    private String name;
    private Integer minDuration;
}
