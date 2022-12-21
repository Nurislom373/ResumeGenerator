package com.elbar.cv_gen.mapper.project.transaction;

import com.elbar.cv_gen.dto.GenericDTO;
import com.elbar.cv_gen.dto.project.transaction.TransactionCreateDTO;
import com.elbar.cv_gen.dto.project.transaction.TransactionDetailDTO;
import com.elbar.cv_gen.dto.project.transaction.TransactionGetDTO;
import com.elbar.cv_gen.entity.project.transaction.TransactionEntity;
import com.elbar.cv_gen.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface TransactionMapper extends GenericMapper<TransactionCreateDTO, GenericDTO, TransactionGetDTO, TransactionEntity> {

    TransactionEntity toDetailDTO(TransactionDetailDTO DTO);

    TransactionDetailDTO fromDetailDTO(TransactionEntity entity);


}
