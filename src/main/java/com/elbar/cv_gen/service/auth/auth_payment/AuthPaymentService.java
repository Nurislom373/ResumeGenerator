package com.elbar.cv_gen.service.auth.auth_payment;

import com.elbar.cv_gen.criteria.auth.auth_payment.AuthPaymentCriteria;
import com.elbar.cv_gen.dto.auth.auth_payment.AuthPaymentCreateDto;
import com.elbar.cv_gen.dto.auth.auth_payment.AuthPaymentGetDto;
import com.elbar.cv_gen.service.BaseService;
import com.elbar.cv_gen.service.GenericGLService;

public interface AuthPaymentService extends GenericGLService<AuthPaymentGetDto, AuthPaymentCriteria, Integer>, BaseService {
    void create(AuthPaymentCreateDto dto);
    void delete(Integer id);
}
