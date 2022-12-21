package com.elbar.cv_gen.mapper.cloudinary;

import com.elbar.cv_gen.dto.cloudinary.CloudinaryDetailDTO;
import com.elbar.cv_gen.dto.cloudinary.CloudinaryGetDTO;
import com.elbar.cv_gen.entity.cloudinary.CloudinaryEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface CloudinaryMapper {

    CloudinaryGetDTO getDTO(CloudinaryEntity entity);

    CloudinaryDetailDTO detailDTO(CloudinaryEntity entity);

    List<CloudinaryGetDTO> getListDTO(List<CloudinaryEntity> entities);

}
