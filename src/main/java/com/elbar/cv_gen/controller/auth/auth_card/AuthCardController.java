package com.elbar.cv_gen.controller.auth.auth_card;

import com.elbar.cv_gen.controller.AbstractController;
import com.elbar.cv_gen.controller.GenericCUDController;
import com.elbar.cv_gen.controller.GenericGLController;
import com.elbar.cv_gen.criteria.auth.auth_block.AuthBlockCriteria;
import com.elbar.cv_gen.criteria.auth.auth_card.AuthCardCriteria;
import com.elbar.cv_gen.dto.auth.auth_block.AuthBlockGetDTO;
import com.elbar.cv_gen.dto.auth.auth_card.AuthCardCreateDto;
import com.elbar.cv_gen.dto.auth.auth_card.AuthCardDto;
import com.elbar.cv_gen.dto.auth.auth_card.AuthCardUpdateDto;
import com.elbar.cv_gen.dto.auth.auth_payment.AuthPaymentCreateDto;
import com.elbar.cv_gen.dto.auth.auth_user.AuthUserCreateDTO;
import com.elbar.cv_gen.dto.auth.auth_user.AuthUserUpdateDTO;
import com.elbar.cv_gen.dto.auth.blocked_for.BlockedForCreateDTO;
import com.elbar.cv_gen.response.Data;
import com.elbar.cv_gen.service.auth.auth_block.AuthBlockService;
import com.elbar.cv_gen.service.auth.auth_card.AuthCardService;
import com.elbar.cv_gen.utils.BaseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = BaseUtils.PATH + "/auth_card/*")
public class AuthCardController extends AbstractController<AuthCardService>
        implements GenericCUDController<AuthCardCreateDto, AuthCardUpdateDto, Integer>,
        GenericGLController<AuthCardDto, AuthCardCriteria, Integer> {

    public AuthCardController(AuthCardService service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<AuthCardDto>> get(Integer id) {
        return new ResponseEntity<>(new Data<>(service.get(id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<AuthCardDto>>> list(AuthCardCriteria criteria) {
        return new ResponseEntity<>(new Data<>(service.list(criteria)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<String>> update(AuthCardUpdateDto DTO) {
        service.update(DTO);
        return new ResponseEntity<>(new Data<>("Successfully Updated - Auth User"), HttpStatus.CREATED);

    }

    @Override
    public ResponseEntity<Data<String>> create(AuthCardCreateDto DTO) {
        service.create(DTO);
        return new ResponseEntity<>(new Data<>("Successfully Created - Auth User"), HttpStatus.CREATED);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Data<String>> delete(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>(new Data<>("Successfully Deleted - Car For"), HttpStatus.NO_CONTENT);
    }

}
