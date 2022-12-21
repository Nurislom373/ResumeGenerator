package com.elbar.cv_gen.dto.project.template;

import com.elbar.cv_gen.dto.GenericDTO;
import lombok.*;
import nonapi.io.github.classgraph.utils.LogNode;
import org.springframework.boot.configurationprocessor.json.JSONObject;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TemplateGetDTO extends GenericDTO {

    private String title;

    private String html;

    private String fields;

    private Integer categoryId;

    private String imagePath;

    private Long price;

    private Integer downloadCount;

    private Boolean isPremium;

    private Boolean isActive;
}
