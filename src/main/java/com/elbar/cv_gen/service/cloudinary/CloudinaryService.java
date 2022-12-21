package com.elbar.cv_gen.service.cloudinary;

import com.elbar.cv_gen.criteria.cloudinary.CloudinaryCriteria;
import com.elbar.cv_gen.dto.cloudinary.CloudinaryDetailDTO;
import com.elbar.cv_gen.dto.cloudinary.CloudinaryGetDTO;
import com.elbar.cv_gen.entity.cloudinary.CloudinaryEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CloudinaryService {

    CloudinaryGetDTO upload(MultipartFile file);

    List<CloudinaryGetDTO> multiUpload(MultipartFile[] files);

    String save(MultipartFile file);

    CloudinaryGetDTO get(Integer id);

    CloudinaryDetailDTO detail(Integer id);

    void delete(Integer id);

    void delete(CloudinaryEntity entity);

    List<CloudinaryGetDTO> getMultiGet(List<Integer> ids);

    List<CloudinaryGetDTO> list(CloudinaryCriteria criteria);

}
