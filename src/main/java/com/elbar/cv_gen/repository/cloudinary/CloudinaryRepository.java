package com.elbar.cv_gen.repository.cloudinary;

import com.elbar.cv_gen.entity.cloudinary.CloudinaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CloudinaryRepository extends JpaRepository<CloudinaryEntity, Integer> {
}
