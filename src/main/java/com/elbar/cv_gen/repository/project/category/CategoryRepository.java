package com.elbar.cv_gen.repository.project.category;

import com.elbar.cv_gen.entity.project.category.CategoryEntity;
import com.elbar.cv_gen.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer>, JpaSpecificationExecutor<CategoryEntity>, BaseRepository {
    Optional<CategoryEntity> findByTitle(String title);
}
