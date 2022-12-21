package com.elbar.cv_gen.service.auth.auth_payment;

import com.elbar.cv_gen.criteria.auth.auth_payment.AuthPaymentCriteria;
import com.elbar.cv_gen.dto.auth.auth_payment.AuthPaymentCreateDto;
import com.elbar.cv_gen.dto.auth.auth_payment.AuthPaymentGetDto;
import com.elbar.cv_gen.entity.auth.user_payment.UserPaymentEntity;
import com.elbar.cv_gen.exception.exception.AlreadyCreatedException;
import com.elbar.cv_gen.exception.exception.NotFoundException;
import com.elbar.cv_gen.mapper.auth.auth_payment.AuthPaymentMapper;
import com.elbar.cv_gen.repository.auth.auth_payment.AuthPaymentRepository;
import com.elbar.cv_gen.repository.auth.auth_user.AuthUserRepository;
import com.elbar.cv_gen.repository.project.template.TemplateRepository;
import com.elbar.cv_gen.repository.project.transaction.TransactionRepository;
import com.elbar.cv_gen.service.AbstractService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AuthPaymentServiceImpl  extends AbstractService<AuthPaymentMapper, AuthPaymentRepository>
        implements AuthPaymentService {

    private final AuthUserRepository userRepository;
    private final TemplateRepository templateRepository;
    private final TransactionRepository transactionRepository;


    public AuthPaymentServiceImpl(AuthPaymentMapper mapper, AuthPaymentRepository repository, AuthUserRepository userRepository, TemplateRepository templateRepository, TransactionRepository transactionRepository) {
        super(mapper, repository);
        this.userRepository = userRepository;
        this.templateRepository = templateRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public AuthPaymentGetDto get(Integer id) {
        return mapper.fromGetDTO(
                repository.findByIdAndDeletedFalse(id)
                .orElseThrow(()->new NotFoundException("Payment not found")));
    }

    @Override
    public List<AuthPaymentGetDto> list(AuthPaymentCriteria criteria) {
        Pageable pageable = PageRequest.of(criteria.getPage(), criteria.getSize(), criteria.getSort());
        return repository
                .findAll(pageable)
                .stream()
                .map(mapper::fromGetDTO)
                .toList();
    }

    @Override
    public void create(AuthPaymentCreateDto dto) {
        if(!userRepository.existsByIdAndDeletedFalse(dto.getUserId()))
               throw new NotFoundException("User not found");
        if(!templateRepository.existsByIdAndDeletedFalse(dto.getTemplateId()))
               throw new NotFoundException("Template not found");
        if(!transactionRepository.existsByIdAndDeletedFalse(dto.getTransactionId()))
               throw new NotFoundException("Transaction not found");
        if(repository.existsByUserIdAndTransactionIdAndTemplateIdAndDeletedFalse(
                dto.getUserId(),dto.getTransactionId(), dto.getTemplateId()))
               throw new AlreadyCreatedException("Already exist");
        UserPaymentEntity entity = mapper.toCreateDTO(dto);
        entity.setCreatedAt(LocalDateTime.now());
        entity.setCreatedBy(dto.getUserId());
        repository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        UserPaymentEntity entity = repository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new NotFoundException("Payment not found"));
        entity.setDeleted(true);
        repository.save(entity);
    }
}
