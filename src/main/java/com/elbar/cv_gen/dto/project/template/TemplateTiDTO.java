package com.elbar.cv_gen.dto.project.template;

import com.elbar.cv_gen.dto.GenericDTO;
import lombok.*;

/**
 * Author: Nurislom
 * <br/>
 * Date: 12/15/2022
 * <br/>
 * Time: 10:29 PM
 * <br/>
 * Package: com.elbar.cv_gen.dto.project.template
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class TemplateTiDTO extends GenericDTO {
    private String title;

    private String category;

    private String imagePath;

    private Long price;

    private Integer downloadCount;

    private Boolean isPremium;
}
