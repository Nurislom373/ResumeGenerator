package com.elbar.cv_gen.service.project.template_rating;

import com.elbar.cv_gen.criteria.BetweenCriteria;
import com.elbar.cv_gen.criteria.SearchCriteria;
import com.elbar.cv_gen.criteria.project.template_rating.TemplateRatingCriteria;
import com.elbar.cv_gen.dto.project.template_rating.TemplateRatingCreateDTO;
import com.elbar.cv_gen.dto.project.template_rating.TemplateRatingGetDTO;
import com.elbar.cv_gen.dto.project.template_rating.TemplateRatingUpdateDTO;
import com.elbar.cv_gen.entity.project.template_rating.TemplateRatingEntity;
import com.elbar.cv_gen.mapper.project.template_rating.TemplateRatingMapper;
import com.elbar.cv_gen.repository.project.template_rating.TemplateRatingRepository;
import com.elbar.cv_gen.service.AbstractService;
import com.elbar.cv_gen.specification.project.template_rating.TemplateRatingBetweenSpecification;
import com.elbar.cv_gen.specification.project.template_rating.TemplateRatingSearchSpecification;
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
public class TemplateRatingServiceImpl extends AbstractService<TemplateRatingMapper, TemplateRatingRepository> implements TemplateRatingService {
    public TemplateRatingServiceImpl(TemplateRatingMapper mapper, TemplateRatingRepository repository) {
        super(mapper, repository);
    }

    @Override
    public void create(TemplateRatingCreateDTO dto) {
        Optional<TemplateRatingEntity> templateRating = repository.findByTemplateId(dto.getTemplateId());
        if (templateRating.isPresent()) {
            throw new RuntimeException("Template rating already exists");
        } else {
            TemplateRatingEntity entity = mapper.toCreateDTO(dto);
            repository.save(entity);
        }
    }

    @Override
    public void update(TemplateRatingUpdateDTO dto) {
        TemplateRatingEntity rating = repository.findById(dto.getId()).orElseThrow(() -> new RuntimeException("Template rating not found"));
        BeanUtils.copyProperties(dto, rating);
        rating.setUpdatedAt(LocalDateTime.now());
        repository.save(rating);
    }

    @Override
    public void delete(Integer id) {
        TemplateRatingEntity rating = repository.findById(id).orElseThrow(() -> new RuntimeException("Template rating not found"));
        rating.setDeleted(true);
        repository.save(rating);
    }

    @Override
    public TemplateRatingGetDTO get(Integer id) {
        TemplateRatingEntity rating = repository.findById(id).orElseThrow(() -> new RuntimeException("Template rating not found"));
        return mapper.fromGetDTO(rating);
    }

    @Override
    public List<TemplateRatingGetDTO> list(TemplateRatingCriteria criteria) {
        Pageable request = PageRequest.of(criteria.getPage(), criteria.getSize());
        Page<TemplateRatingEntity> entities = repository.findAll(request);
        return entities.stream().map(mapper::fromGetDTO).toList();
    }

    @Override
    public List<TemplateRatingGetDTO> list_with_search(SearchCriteria criteria) {
        List<TemplateRatingEntity> entities = repository.findAll(new TemplateRatingSearchSpecification(criteria));
        return entities.stream().map(mapper::fromGetDTO).toList();
    }

    @Override
    public List<TemplateRatingGetDTO> list_with_between(BetweenCriteria criteria) {
        List<TemplateRatingEntity> entities = repository.findAll(new TemplateRatingBetweenSpecification(criteria));
        return entities.stream().map(mapper::fromGetDTO).toList();
    }
}
