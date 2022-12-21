package com.elbar.cv_gen.dto.project.template_save;

import com.elbar.cv_gen.dto.GenericDTO;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TemplateSaveDetailDTO extends GenericDTO {
    private Integer templateId;
    private Integer userId;
    private LocalDateTime createdAt;
    private Integer createdBy;
    private LocalDateTime updatedAt;
    private Integer updatedBy;
}
