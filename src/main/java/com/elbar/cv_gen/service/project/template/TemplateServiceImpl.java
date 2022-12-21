package com.elbar.cv_gen.service.project.template;

import com.elbar.cv_gen.criteria.BetweenCriteria;
import com.elbar.cv_gen.criteria.SearchCriteria;
import com.elbar.cv_gen.criteria.project.template.TemplateCriteria;
import com.elbar.cv_gen.dto.project.template.TemplateCreateDTO;
import com.elbar.cv_gen.dto.project.template.TemplateGetDTO;
import com.elbar.cv_gen.dto.project.template.TemplateTiDTO;
import com.elbar.cv_gen.dto.project.template.TemplateUpdateDTO;
import com.elbar.cv_gen.entity.project.template.TemplateEntity;
import com.elbar.cv_gen.exception.exception.InvalidValidationException;
import com.elbar.cv_gen.exception.exception.NotFoundException;
import com.elbar.cv_gen.mapper.project.template.TemplateMapper;
import com.elbar.cv_gen.repository.project.template.TemplateRepository;
import com.elbar.cv_gen.service.AbstractService;
import com.elbar.cv_gen.service.auth.auth_block.AuthBlockService;
import com.elbar.cv_gen.service.project.category.CategoryService;
import com.elbar.cv_gen.specification.project.template.TemplateBetweenSpecification;
import com.elbar.cv_gen.specification.project.template.TemplateSearchSpecification;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class TemplateServiceImpl extends AbstractService<TemplateMapper, TemplateRepository> implements TemplateService {

    private final AuthBlockService blockService;
    private final CategoryService categoryService;

    public TemplateServiceImpl(TemplateMapper mapper, TemplateRepository repository, AuthBlockService blockService, CategoryService categoryService) {
        super(mapper, repository);
        this.blockService = blockService;
        this.categoryService = categoryService;
    }

    @Override
    public void create(TemplateCreateDTO dto) {
        Optional<TemplateEntity> template = repository.findByTitle(dto.getTitle());
        if (template.isPresent()) {
            throw new RuntimeException("Template already exists");
        } else {
            TemplateEntity entity = mapper.toCreateDTO(dto);
            repository.save(entity);
        }
    }

    @Override
    public void update(TemplateUpdateDTO dto) {
        TemplateEntity template = repository.findById(dto.getId()).orElseThrow(() -> new RuntimeException("Template not found"));
        BeanUtils.copyProperties(dto, template);
        template.setUpdatedAt(LocalDateTime.now());
        repository.save(template);
    }

    @Override
    public void delete(Integer id) {
        TemplateEntity template = repository.findById(id).orElseThrow(() -> new RuntimeException("Template not found"));
        template.setDeleted(true);
        repository.save(template);
    }

    @Override
    public TemplateGetDTO get(Integer id) {
        TemplateEntity template = repository.findById(id).orElseThrow(() -> new RuntimeException("Template not found"));
        return mapper.fromGetDTO(template);
    }

    @Override
    public List<TemplateGetDTO> list(TemplateCriteria criteria) {
        Pageable request = PageRequest.of(criteria.getPage(), criteria.getSize(), criteria.getSort(),
                criteria.getProperties().getValue());
        Page<TemplateEntity> entities = repository.findAll(request);
        return entities.stream().map(mapper::fromGetDTO).toList();
    }

    @Override
    public List<TemplateGetDTO> list_with_search(SearchCriteria criteria) {
        List<TemplateEntity> entities = repository.findAll(new TemplateSearchSpecification(criteria));
        return entities.stream().map(mapper::fromGetDTO).toList();
    }

    @Override
    public List<TemplateGetDTO> list_with_between(BetweenCriteria criteria) {
        List<TemplateEntity> entities = repository.findAll(new TemplateBetweenSpecification(criteria));
        return entities.stream().map(mapper::fromGetDTO).toList();
    }

    @Override
    public TemplateEntity getEntity(Integer id) {
        if (Objects.isNull(id) || id < 1) {
            throw new InvalidValidationException("Invalid ID!");
        }
        return repository.findById(id)
                .orElseThrow(() -> {
                    throw new NotFoundException("Template not found");
                });
    }

    @Override
    public boolean existById(Integer id) {
        if (Objects.isNull(id) || id < 1) {
            throw new InvalidValidationException("Invalid ID!");
        }
        return repository.existsById(id);
    }

    @Override
    public List<TemplateTiDTO> tiTemplates(TemplateCriteria criteria) {
        Pageable request = PageRequest.of(criteria.getPage(), criteria.getSize(), criteria.getSort(),
                criteria.getProperties().getValue());
        Page<TemplateEntity> entities = repository.findAll(request);
        return entities.stream().map(this::returnTiDTO).toList();
    }

    private TemplateTiDTO returnTiDTO(TemplateEntity entity) {
        TemplateTiDTO dto = new TemplateTiDTO();
        BeanUtils.copyProperties(entity, dto);
        dto.setCategory(categoryService.getCategoryTitle(entity.getCategoryId()));
        return dto;
    }
}
