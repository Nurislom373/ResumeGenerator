package com.elbar.cv_gen.entity.auth.user_payment;

import com.elbar.cv_gen.entity.Auditable;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "is_deleted = false")
@Table(name = "user_payment", schema = "auth")
public class UserPaymentEntity extends Auditable {

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "template_id", nullable = false)
    private Integer templateId;

    @Column(name = "transaction_id", nullable = false)
    private Integer transactionId;
}
