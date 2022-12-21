package com.elbar.cv_gen.controller.auth.auth_user;

import com.elbar.cv_gen.controller.AbstractController;
import com.elbar.cv_gen.controller.GenericCUDController;
import com.elbar.cv_gen.controller.GenericGLController;
import com.elbar.cv_gen.controller.GenericSpecificationController;
import com.elbar.cv_gen.criteria.BetweenCriteria;
import com.elbar.cv_gen.criteria.SearchCriteria;
import com.elbar.cv_gen.criteria.auth.auth_user.AuthUserCriteria;
import com.elbar.cv_gen.dto.auth.auth_user.*;
import com.elbar.cv_gen.response.Data;
import com.elbar.cv_gen.service.auth.auth_user.AuthUserService;
import com.elbar.cv_gen.utils.BaseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/auth_user/*")
public class AuthUserController extends AbstractController<AuthUserService>
        implements GenericCUDController<AuthUserCreateDTO, AuthUserUpdateDTO, Integer>,
        GenericGLController<AuthUserGetDTO, AuthUserCriteria, Integer>,
        GenericSpecificationController<SearchCriteria, BetweenCriteria, AuthUserGetDTO> {

    public AuthUserController(AuthUserService service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<String>> create(AuthUserCreateDTO DTO) {
        service.create(DTO);
        return new ResponseEntity<>(new Data<>("Successfully Created - Auth User"), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Data<String>> update(AuthUserUpdateDTO DTO) {
        service.update(DTO);
        return new ResponseEntity<>(new Data<>("Successfully Updated - Auth User"), HttpStatus.OK);
    }

    @RequestMapping(value = "changePassword", method = RequestMethod.PUT)
    public ResponseEntity<Data<String>> changePassword(@Valid @RequestBody AuthUserChangePasswordDTO dto) {
        service.changePassword(dto);
        return new ResponseEntity<>(new Data<>("Successfully Change Password - Auth User"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<String>> delete(Integer id) {
        service.delete(id);
        return new ResponseEntity<>(new Data<>("Successfully Deleted - Auth User"), HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Data<AuthUserGetDTO>> get(Integer id) {
        return new ResponseEntity<>(new Data<>(service.get(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
    public ResponseEntity<Data<AuthUserDetailDTO>> detail(@PathVariable Integer id) {
        return new ResponseEntity<>(new Data<>(service.detail(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResponseEntity<Data<Object>> detail(@Valid @RequestBody AuthUserRequestDTO dto) {
        return new ResponseEntity<>(new Data<>(service.login(dto)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<AuthUserGetDTO>>> list(AuthUserCriteria criteria) {
        return new ResponseEntity<>(new Data<>(service.list(criteria)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<AuthUserGetDTO>>> list_with_search(SearchCriteria criteria) {
        return new ResponseEntity<>(new Data<>(service.list_with_search(criteria)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<AuthUserGetDTO>>> list_with_between(BetweenCriteria criteria) {
        return new ResponseEntity<>(new Data<>(service.list_with_between(criteria)), HttpStatus.OK);
    }
}
