package com.elbar.cv_gen.repository.auth.auth_token;

import com.elbar.cv_gen.entity.auth.auth_token.AuthTokenEntity;
import com.elbar.cv_gen.enums.auth.token.TokenType;
import com.elbar.cv_gen.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthTokenRepository extends JpaRepository<AuthTokenEntity, Integer>, BaseRepository {

    Optional<AuthTokenEntity> findByUserIdEqualsAndTypeEquals(Integer id, TokenType type);

}
