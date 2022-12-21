package com.elbar.cv_gen.service.project.category;

import com.elbar.cv_gen.criteria.BetweenCriteria;
import com.elbar.cv_gen.criteria.SearchCriteria;
import com.elbar.cv_gen.criteria.project.category.CategoryCriteria;
import com.elbar.cv_gen.dto.project.category.CategoryCreateDTO;
import com.elbar.cv_gen.dto.project.category.CategoryGetDTO;
import com.elbar.cv_gen.dto.project.category.CategoryUpdateDTO;
import com.elbar.cv_gen.entity.project.category.CategoryEntity;
import com.elbar.cv_gen.exception.exception.NotFoundException;
import com.elbar.cv_gen.mapper.project.category.CategoryMapper;
import com.elbar.cv_gen.repository.project.category.CategoryRepository;
import com.elbar.cv_gen.service.AbstractService;
import com.elbar.cv_gen.specification.project.category.CategoryBetweenSpecification;
import com.elbar.cv_gen.specification.project.category.CategorySearchSpecification;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryServiceImpl extends AbstractService<CategoryMapper, CategoryRepository> implements CategoryService {

    public CategoryServiceImpl(CategoryMapper mapper, CategoryRepository repository) {
        super(mapper, repository);
    }

    @Override
    public void create(CategoryCreateDTO dto) {
        Optional<CategoryEntity> category = repository.findByTitle(dto.getTitle());
        if (category.isPresent()) {
            throw new RuntimeException("Category already exists");
        } else {
            CategoryEntity entity = mapper.toCreateDTO(dto);
            repository.save(entity);
        }
    }

    @Override
    public void update(CategoryUpdateDTO dto) {
        CategoryEntity category = repository.findById(dto.getId()).orElseThrow(() -> new RuntimeException("Category not found"));
        BeanUtils.copyProperties(dto, category);
        category.setUpdatedAt(LocalDateTime.now());
        repository.save(category);
    }

    @Override
    public void delete(Integer id) {
        CategoryEntity category = repository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        category.setDeleted(true);
        repository.save(category);
    }

    @Override
    public CategoryGetDTO get(Integer id) {
        CategoryEntity category = repository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        return mapper.fromGetDTO(category);
    }

    @Override
    public List<CategoryGetDTO> list(CategoryCriteria criteria) {
        Pageable request = PageRequest.of(criteria.getPage(), criteria.getSize(), criteria.getSort(), criteria.getProperties().getValue());
        Page<CategoryEntity> entities = repository.findAll(request);
        return entities.stream().map(mapper::fromGetDTO).toList();
    }

    @Override
    public List<CategoryGetDTO> list_with_search(SearchCriteria criteria) {
        List<CategoryEntity> entities = repository.findAll(new CategorySearchSpecification(criteria));
        return entities.stream().map(mapper::fromGetDTO).toList();
    }

    @Override
    public List<CategoryGetDTO> list_with_between(BetweenCriteria criteria) {
        List<CategoryEntity> entities = repository.findAll(new CategoryBetweenSpecification(criteria));
        return entities.stream().map(mapper::fromGetDTO).toList();
    }

    @Override
    public String getCategoryTitle(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Category not found"))
                .getTitle();
    }
}
