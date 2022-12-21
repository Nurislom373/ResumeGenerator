package com.elbar.cv_gen.service.auth.auth_card;

import com.elbar.cv_gen.criteria.auth.auth_card.AuthCardCriteria;
import com.elbar.cv_gen.dto.auth.auth_card.AuthCardCreateDto;
import com.elbar.cv_gen.dto.auth.auth_card.AuthCardDto;
import com.elbar.cv_gen.dto.auth.auth_card.AuthCardUpdateDto;
import com.elbar.cv_gen.entity.auth.auth_card.AuthCardEntity;
import com.elbar.cv_gen.exception.exception.AlreadyCreatedException;
import com.elbar.cv_gen.exception.exception.NotFoundException;
import com.elbar.cv_gen.mapper.auth.auth_card.AuthCardMapper;
import com.elbar.cv_gen.repository.auth.auth_card.AuthCardRepository;
import com.elbar.cv_gen.repository.auth.auth_user.AuthUserRepository;
import com.elbar.cv_gen.service.AbstractService;
import com.elbar.cv_gen.utils.BaseUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class AuthCardServiceImpl  extends AbstractService<AuthCardMapper, AuthCardRepository>
        implements AuthCardService {

    private final AuthUserRepository userRepository;

    public AuthCardServiceImpl(AuthCardMapper mapper, AuthCardRepository repository, AuthUserRepository userRepository) {
        super(mapper, repository);
        this.userRepository = userRepository;
    }

    @Override
    public void create(AuthCardCreateDto dto) {
        if (!userRepository.existsByIdAndDeletedFalse(dto.getUserId()))
             throw new NotFoundException("User not found");
        if (repository.existsByUserIdAndCardNumber(dto.getUserId(),dto.getCardNumber()))
             throw new AlreadyCreatedException("Already exist this kind of card with user");
        LocalDate localDate = LocalDate.parse(dto.getExpire(), DateTimeFormatter.ofPattern("MM/yyyy"));
        if (localDate.isAfter(LocalDate.now()))
             throw new RuntimeException("This Card already expired");
        AuthCardEntity entity = mapper.toCreateDTO(dto);
        entity.setCreatedAt(LocalDateTime.now());
        entity.setCreatedBy(dto.getUserId());
        repository.save(entity);
    }

    @Override
    public void update(AuthCardUpdateDto dto) {
        if (!repository.existsByIdAndIsDeletedFalse(dto.getId()))
            throw new NotFoundException("Card not found");
        LocalDate localDate = LocalDate.parse(dto.getExpire(), DateTimeFormatter.ofPattern("MM/yyyy"));
        if (localDate.isAfter(LocalDate.now()))
            throw new RuntimeException("The card date expired");
        AuthCardEntity entity = mapper.toUpdateDTO(dto);
        entity.setUpdatedAt(LocalDateTime.now());
        entity.setUpdatedBy(entity.getCreatedBy());
        repository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        AuthCardEntity entity = repository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new NotFoundException("Card not found"));
        entity.setDeleted(true);
        repository.save(entity);
    }

    @Override
    public AuthCardDto get(Integer id) {
         return mapper.fromGetDTO(
                 repository.findByIdAndDeletedFalse(id)
                 .orElseThrow(()->new NotFoundException("Card not found")));
    }

    @Override
    public List<AuthCardDto> list(AuthCardCriteria criteria) {
        Pageable pageable = PageRequest.of(criteria.getPage(), criteria.getSize(), criteria.getSort());
        return repository
                .findAll(pageable)
                .stream()
                .map(mapper::fromGetDTO)
                .toList();
    }

    @Override
    public boolean existCardId(Integer cardId) {
        BaseUtils.checkId(cardId);
        return repository.existsById(cardId);
    }

    @Override
    public AuthCardEntity getEntity(Integer id) {
        BaseUtils.checkId(id);
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Card not found"));
    }
}
