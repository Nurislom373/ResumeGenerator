package com.elbar.cv_gen.dto.project.transaction;

import com.elbar.cv_gen.dto.GenericDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TransactionGetDTO extends GenericDTO {
    private Integer templateId;
    private Integer userId;
    private Integer cardId;
    private Long amount;
}
