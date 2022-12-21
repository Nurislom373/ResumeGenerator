package com.elbar.cv_gen.entity.cloudinary;

import com.elbar.cv_gen.entity.Auditable;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cloudinary", schema = "uploads")
@ToString
public class CloudinaryEntity extends Auditable {
    @Column(name = "asset_id", nullable = false)
    private String asset_id;
    @Column(name = "public_id", nullable = false)
    private String public_id;
    @Column(name = "version", nullable = false)
    private Integer version;
    @Column(name = "version_id", nullable = false)
    private String version_id;
    @Column(name = "api_key", nullable = false)
    private String api_key;
    @Column(name = "signature", nullable = false)
    private String signature;
    @Column(name = "width", nullable = false)
    private Integer width;
    @Column(name = "height", nullable = false)
    private Integer height;
    @Column(name = "format", nullable = false)
    private String format;
    @Column(name = "overwritten", nullable = false)
    private Boolean overwritten;
    @Column(name = "original_extension", nullable = false)
    private String original_extension;
    @Column(name = "resource_type", nullable = false)
    private String resource_type;
    @Column(name = "tags", nullable = false)
    private String tags;
    @Column(name = "folder", nullable = false)
    private String folder;
    @Column(name = "pages", nullable = false)
    private Integer pages;
    @Column(name = "bytes", nullable = false)
    private Integer bytes;
    @Column(name = "type", nullable = false)
    private String type;
    @Column(name = "etag", nullable = false)
    private String etag;
    @Column(name = "placeholder", nullable = false)
    private boolean placeholder;
    @Column(name = "url", nullable = false)
    private String url;
    @Column(name = "secure_url", nullable = false)
    private String secure_url;
    @Column(name = "access_mode", nullable = false)
    private String access_mode;
    @Column(name = "original_filename", nullable = false)
    private String original_filename;
}
