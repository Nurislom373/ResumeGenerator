package com.elbar.cv_gen.repository.auth.auth_block;

import com.elbar.cv_gen.entity.auth.auth_block.AuthBlockEntity;
import com.elbar.cv_gen.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthBlockRepository extends JpaRepository<AuthBlockEntity, Integer>, BaseRepository {

    boolean existsByUserIdEquals(Integer id);

    Optional<AuthBlockEntity> findByUserId(Integer id);


}
