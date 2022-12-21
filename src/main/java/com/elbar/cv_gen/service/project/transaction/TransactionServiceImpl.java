package com.elbar.cv_gen.service.project.transaction;

import com.elbar.cv_gen.annotation.IdConstraint;
import com.elbar.cv_gen.criteria.BetweenCriteria;
import com.elbar.cv_gen.criteria.SearchCriteria;
import com.elbar.cv_gen.criteria.project.transaction.TransactionCriteria;
import com.elbar.cv_gen.dto.project.transaction.TransactionCreateDTO;
import com.elbar.cv_gen.dto.project.transaction.TransactionDetailDTO;
import com.elbar.cv_gen.dto.project.transaction.TransactionGetDTO;
import com.elbar.cv_gen.entity.project.transaction.TransactionEntity;
import com.elbar.cv_gen.exception.exception.NotFoundException;
import com.elbar.cv_gen.mapper.project.transaction.TransactionMapper;
import com.elbar.cv_gen.repository.project.transaction.TransactionRepository;
import com.elbar.cv_gen.service.AbstractService;
import com.elbar.cv_gen.service.auth.auth_card.AuthCardService;
import com.elbar.cv_gen.service.auth.auth_user.AuthUserService;
import com.elbar.cv_gen.service.project.template.TemplateService;
import com.elbar.cv_gen.specification.project.transaction.TransactionSpecification;
import com.elbar.cv_gen.utils.BaseUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionServiceImpl extends AbstractService<TransactionMapper, TransactionRepository> implements TransactionService {

    private final AuthUserService userService;
    private final TemplateService templateService;
    private final AuthCardService authCardService;

    public TransactionServiceImpl(TransactionMapper mapper, TransactionRepository repository, AuthUserService userService, TemplateService templateService, AuthCardService authCardService) {
        super(mapper, repository);
        this.userService = userService;
        this.templateService = templateService;
        this.authCardService = authCardService;
    }

    @Override
    public void create(TransactionCreateDTO dto) {
        if (!userService.existById(dto.getUserId())) {
            throw new NotFoundException("User not found");
        }
        if (!authCardService.existCardId(dto.getCardId())) {
            throw new NotFoundException("Card not found");
        }
        if (!templateService.existById(dto.getTemplateId())) {
            throw new NotFoundException("Template not found");
        }
        TransactionEntity transactionEntity = mapper.toCreateDTO(dto);
        repository.save(transactionEntity);
    }

    @Override
    public void delete(@IdConstraint Integer id) {
        TransactionEntity entity = repository.findById(id)
                .orElseThrow(() -> {
                    throw new NotFoundException("Transaction not found");
                });
        entity.setUpdatedAt(LocalDateTime.now());
        entity.setUpdatedBy(-1);
        entity.setDeleted(true);
        repository.save(entity);
    }

    @Override
    public TransactionGetDTO get(@IdConstraint Integer id) {
        return mapper.fromGetDTO(
                repository.findById(id).orElseThrow(() -> {
                    throw new NotFoundException("Transaction not found");
                })
        );
    }

    @Override
    public TransactionDetailDTO detail(@IdConstraint Integer id) {
        TransactionEntity entity = repository.findById(id)
                .orElseThrow(() -> {
                    throw new NotFoundException("Transaction not found");
                });
        TransactionDetailDTO transactionDetailDTO = mapper.fromDetailDTO(entity);
        transactionDetailDTO.setTemplate(templateService.getEntity(entity.getTemplateId()));
        transactionDetailDTO.setUser(userService.getEntity(entity.getUserId()));
        transactionDetailDTO.setCard(authCardService.getEntity(entity.getCardId()));
        return transactionDetailDTO;
    }

    @Override
    public boolean existByTemplateIdAndUserId(Integer templateId, Integer userId) {
        BaseUtils.checkId(templateId);
        BaseUtils.checkId(userId);
        return repository.existsByTemplateIdAndUserId(templateId, userId);
    }

    @Override
    public List<TransactionGetDTO> list(TransactionCriteria criteria) {
        return repository.findAll(
                        PageRequest.of(criteria.getPage(), criteria.getSize(),
                                criteria.getSort(), criteria.getFieldsEnum().getValue())
                ).stream()
                .map(mapper::fromGetDTO)
                .toList();
    }

    @Override
    public List<TransactionGetDTO> list_with_search(SearchCriteria criteria) {
        return repository.findAll(
                        new TransactionSpecification.SearchPredicate(criteria),
                        PageRequest.of(criteria.getPage(), criteria.getSize()))
                .stream()
                .map(mapper::fromGetDTO)
                .toList();
    }

    @Override
    public List<TransactionGetDTO> list_with_between(BetweenCriteria criteria) {
        return repository.findAll(
                        new TransactionSpecification.BetweenPredicate(criteria),
                        PageRequest.of(criteria.getPage(), criteria.getSize())
                ).stream()
                .map(mapper::fromGetDTO)
                .toList();
    }
}
