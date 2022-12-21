package com.elbar.cv_gen.controller.auth.auth_token;

import com.elbar.cv_gen.controller.AbstractController;
import com.elbar.cv_gen.controller.GenericGLController;
import com.elbar.cv_gen.criteria.auth.auth_token.AuthTokenCriteria;
import com.elbar.cv_gen.dto.auth.auth_token.AuthTokenCreateDTO;
import com.elbar.cv_gen.dto.auth.auth_token.AuthTokenDetailDTO;
import com.elbar.cv_gen.dto.auth.auth_token.AuthTokenGetDTO;
import com.elbar.cv_gen.response.Data;
import com.elbar.cv_gen.service.auth.auth_token.AuthTokenService;
import com.elbar.cv_gen.utils.BaseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/auth_token/*")
public class AuthTokenController extends AbstractController<AuthTokenService>
        implements GenericGLController<AuthTokenGetDTO, AuthTokenCriteria, Integer> {

    public AuthTokenController(AuthTokenService service) {
        super(service);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<Data<String>> create(@RequestBody AuthTokenCreateDTO dto) {
        service.create(dto);
        return new ResponseEntity<>(new Data<>("Successfully Created - Auth Token"), HttpStatus.CREATED);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Data<String>> delete(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>(new Data<>("Successfully Deleted - Auth Token"), HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Data<AuthTokenGetDTO>> get(Integer id) {
        return new ResponseEntity<>(new Data<>(service.get(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
    public ResponseEntity<Data<AuthTokenDetailDTO>> detail(@PathVariable Integer id) {
        return new ResponseEntity<>(new Data<>(service.detail(id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<AuthTokenGetDTO>>> list(AuthTokenCriteria criteria) {
        return new ResponseEntity<>(new Data<>(service.list(criteria)), HttpStatus.OK);
    }
}
