package com.elbar.cv_gen.mapper.auth.auth_payment;

import com.elbar.cv_gen.dto.GenericDTO;
import com.elbar.cv_gen.dto.auth.auth_payment.AuthPaymentCreateDto;
import com.elbar.cv_gen.dto.auth.auth_payment.AuthPaymentGetDto;
import com.elbar.cv_gen.entity.auth.user_payment.UserPaymentEntity;
import com.elbar.cv_gen.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AuthPaymentMapper  extends GenericMapper<AuthPaymentCreateDto, GenericDTO, AuthPaymentGetDto, UserPaymentEntity> {

}
