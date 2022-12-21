package com.elbar.cv_gen.service;

import com.elbar.cv_gen.mapper.BaseMapper;
import com.elbar.cv_gen.repository.BaseRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractService<M extends BaseMapper, R extends BaseRepository> implements BaseService {
    protected final M mapper;
    protected final R repository;
}
