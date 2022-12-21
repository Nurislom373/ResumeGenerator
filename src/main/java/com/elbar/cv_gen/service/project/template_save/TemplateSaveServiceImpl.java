package com.elbar.cv_gen.service.project.template_save;

import com.elbar.cv_gen.annotation.IdConstraint;
import com.elbar.cv_gen.criteria.project.template_save.TemplateSaveCriteria;
import com.elbar.cv_gen.dto.project.template_save.TemplateSaveCreateDTO;
import com.elbar.cv_gen.dto.project.template_save.TemplateSaveDetailDTO;
import com.elbar.cv_gen.dto.project.template_save.TemplateSaveGetDTO;
import com.elbar.cv_gen.entity.auth.auth_user.AuthUserEntity;
import com.elbar.cv_gen.entity.project.template_save.TemplateSaveEntity;
import com.elbar.cv_gen.exception.exception.AlreadyCreatedException;
import com.elbar.cv_gen.exception.exception.InvalidValidationException;
import com.elbar.cv_gen.exception.exception.NotFoundException;
import com.elbar.cv_gen.mapper.project.template_save.TemplateSaveMapper;
import com.elbar.cv_gen.repository.project.template_save.TemplateSaveRepository;
import com.elbar.cv_gen.service.AbstractService;
import com.elbar.cv_gen.service.auth.auth_user.AuthUserService;
import com.elbar.cv_gen.service.project.template.TemplateService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TemplateSaveServiceImpl extends AbstractService<TemplateSaveMapper, TemplateSaveRepository> implements TemplateSaveService {

    private final TemplateService templateService;
    private final AuthUserService userService;

    public TemplateSaveServiceImpl(TemplateSaveMapper mapper, TemplateSaveRepository repository, TemplateService templateService, AuthUserService userService) {
        super(mapper, repository);
        this.templateService = templateService;
        this.userService = userService;
    }

    @Override
    public void create(TemplateSaveCreateDTO dto) {
        if (repository.existsByUserIdAndTemplateId(dto.getUserId(), dto.getTemplateId())) {
            throw new AlreadyCreatedException("Already Created Template!");
        }
        if (!userService.existByIdAndIsNotBlocked(dto.getUserId())) {
            throw new InvalidValidationException("Invalid User ID!");
        }
        if (!templateService.existById(dto.getTemplateId())) {
            throw new NotFoundException("Template not found");
        }
        TemplateSaveEntity templateSaveEntity = mapper.toCreateDTO(dto);
        repository.save(templateSaveEntity);
    }

    @Override
    public void delete(@IdConstraint Integer id) {
        TemplateSaveEntity save = repository.findById(id)
                .orElseThrow(() -> {
                    throw new NotFoundException("Template Save not found");
                });
        save.setDeleted(true);
        save.setUpdatedAt(LocalDateTime.now());
        save.setUpdatedBy(-1);
        repository.save(save);
    }

    @Override
    public TemplateSaveGetDTO get(@IdConstraint Integer id) {
        return mapper.fromGetDTO(
                repository.findById(id).orElseThrow(() -> {
                    throw new NotFoundException("TemplateSave not found");
                })
        );
    }

    @Override
    public List<TemplateSaveGetDTO> list(TemplateSaveCriteria criteria) {
        return repository.findAll(
                        PageRequest.of(criteria.getPage(),
                                criteria.getSize())).stream()
                .map(mapper::fromGetDTO)
                .toList();
    }

    @Override
    public TemplateSaveDetailDTO detail(@IdConstraint Integer id) {
        return mapper.fromDetailDTO(
                repository.findById(id).orElseThrow(() -> {
                    throw new NotFoundException("TemplateSave not found");
                })
        );
    }
}
