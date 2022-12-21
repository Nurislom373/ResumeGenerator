package com.elbar.cv_gen.mapper;

import com.elbar.cv_gen.dto.BaseDTO;
import com.elbar.cv_gen.dto.GenericDTO;
import com.elbar.cv_gen.entity.BaseEntity;

import java.util.List;

public interface GenericMapper<CD extends BaseDTO, UD extends GenericDTO, GD extends GenericDTO, E extends BaseEntity> extends BaseMapper {
    E toCreateDTO(CD dto);

    CD fromCreateDTO(E entity);

    E toUpdateDTO(UD dto);

    UD fromUpdateDTO(E entity);

    E toGetDTO(GD dto);

    GD fromGetDTO(E entity);

    List<E> toGetListDTO(List<GD> dto);

    List<GD> fromGetListDTO(List<E> entity);
}
