package com.elbar.cv_gen.repository.auth.auth_payment;

import com.elbar.cv_gen.entity.auth.user_payment.UserPaymentEntity;
import com.elbar.cv_gen.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthPaymentRepository extends JpaRepository<UserPaymentEntity, Integer>, BaseRepository {
    @Query("from UserPaymentEntity where userId = ?1 and transactionId = ?2 and templateId = ?3 and isDeleted =false ")
    boolean existsByUserIdAndTransactionIdAndTemplateIdAndDeletedFalse(Integer userId,Integer tranId,Integer temId);

    @Query("from UserPaymentEntity where id = ?1 and isDeleted =false ")
    Optional<UserPaymentEntity> findByIdAndDeletedFalse(Integer integer);

    Page<UserPaymentEntity> findAllByDeletedFalse(Pageable pageable);
}
