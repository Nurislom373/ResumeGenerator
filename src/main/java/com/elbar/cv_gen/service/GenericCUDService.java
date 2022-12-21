package com.elbar.cv_gen.service;

import com.elbar.cv_gen.dto.BaseDTO;
import com.elbar.cv_gen.dto.GenericDTO;

import java.io.Serializable;

public interface GenericCUDService<CD extends BaseDTO, UD extends GenericDTO, K extends Serializable> {
    void create(CD dto);

    void update(UD dto);

    void delete(K id);
}
