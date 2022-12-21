package com.elbar.cv_gen.mapper.auth.blocked_for;

import com.elbar.cv_gen.dto.GenericDTO;
import com.elbar.cv_gen.dto.auth.blocked_for.BlockedForCreateDTO;
import com.elbar.cv_gen.dto.auth.blocked_for.BlockedForGetDTO;
import com.elbar.cv_gen.entity.auth.blocked_for.BlockedForEntity;
import com.elbar.cv_gen.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface BlockedForMapper extends GenericMapper<BlockedForCreateDTO, GenericDTO, BlockedForGetDTO, BlockedForEntity> {
}
