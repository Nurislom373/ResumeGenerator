package com.elbar.cv_gen.dto.cloudinary;

import com.elbar.cv_gen.dto.GenericDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CloudinaryGetDTO extends GenericDTO {
    private String signature;
    private String format;
    private String resource_type;
    private String secure_url;
    private String url;
    private Integer bytes;
}
