package com.elbar.cv_gen.repository.auth.auth_user;

import com.elbar.cv_gen.entity.auth.auth_user.AuthUserEntity;
import com.elbar.cv_gen.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUserEntity, Integer>,
        JpaSpecificationExecutor<AuthUserEntity>, BaseRepository {

    boolean existsByPhoneEquals(String phone);

    @Query("from AuthUserEntity where id = ?1 and isDeleted = false")
    boolean existsByIdAndDeletedFalse(Integer id);

    Optional<AuthUserEntity> findByPhoneEquals(String phone);

}
