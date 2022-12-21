package com.elbar.cv_gen.dto.cloudinary;

import com.elbar.cv_gen.dto.GenericDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CloudinaryDetailDTO extends GenericDTO {
    private String asset_id;
    private String public_id;
    private Integer version;
    private String version_id;
    private String api_key;
    private String signature;
    private Integer width;
    private Integer height;
    private String format;
    private Boolean overwritten;
    private String original_extension;
    private String resource_type;
    private String tags;
    private String folder;
    private Integer pages;
    private Integer bytes;
    private String type;
    private String etag;
    private boolean placeholder;
    private String url;
    private String secure_url;
    private String access_mode;
    private String original_filename;
}
