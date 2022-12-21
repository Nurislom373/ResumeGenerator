package com.elbar.cv_gen.repository.project.transaction;

import com.elbar.cv_gen.entity.project.transaction.TransactionEntity;
import com.elbar.cv_gen.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Integer>,
        JpaSpecificationExecutor<TransactionEntity>, BaseRepository {

    boolean existsByTemplateIdAndUserId(Integer templateId, Integer userId);

    @Query("from TransactionEntity where id = ?1 and isDeleted =false  ")
    boolean existsByIdAndDeletedFalse(Integer id);

}
