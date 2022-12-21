package com.elbar.cv_gen.repository.auth.auth_card;

import com.elbar.cv_gen.entity.auth.auth_card.AuthCardEntity;
import com.elbar.cv_gen.repository.BaseRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthCardRepository extends JpaRepository<AuthCardEntity, Integer>, BaseRepository {
    boolean existsByUserIdAndCardNumber(Integer userId, String cardNumber);

    @Query("from AuthCardEntity where id = ?1 and isDeleted = false")
    boolean existsByIdAndIsDeletedFalse(Integer id);

    @Query("from AuthCardEntity where id = ?1 and isDeleted = false")
    Optional<AuthCardEntity> findByIdAndDeletedFalse(Integer integer);
//    List<AuthCardEntity> findAll(Pageable pageable);
}
