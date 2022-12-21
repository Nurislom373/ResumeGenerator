package com.elbar.cv_gen.controller.auth.auth_block;

import com.elbar.cv_gen.controller.AbstractController;
import com.elbar.cv_gen.controller.GenericGLController;
import com.elbar.cv_gen.criteria.auth.auth_block.AuthBlockCriteria;
import com.elbar.cv_gen.dto.auth.auth_block.AuthBlockCreateDTO;
import com.elbar.cv_gen.dto.auth.auth_block.AuthBlockDetailDTO;
import com.elbar.cv_gen.dto.auth.auth_block.AuthBlockGetDTO;
import com.elbar.cv_gen.response.Data;
import com.elbar.cv_gen.service.auth.auth_block.AuthBlockService;
import com.elbar.cv_gen.utils.BaseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/auth_block/*")
public class AuthBlockController extends AbstractController<AuthBlockService>
        implements GenericGLController<AuthBlockGetDTO, AuthBlockCriteria, Integer> {

    public AuthBlockController(AuthBlockService service) {
        super(service);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<Data<String>> create(@RequestBody AuthBlockCreateDTO dto) {
        service.create(dto);
        return new ResponseEntity<>(new Data<>("Successfully Created - Auth Block"), HttpStatus.CREATED);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Data<String>> delete(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>(new Data<>("Successfully Deleted - Auth Block"), HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Data<AuthBlockGetDTO>> get(Integer id) {
        return new ResponseEntity<>(new Data<>(service.get(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
    public ResponseEntity<Data<AuthBlockDetailDTO>> detail(@PathVariable Integer id) {
        return new ResponseEntity<>(new Data<>(service.detail(id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<AuthBlockGetDTO>>> list(AuthBlockCriteria criteria) {
        return new ResponseEntity<>(new Data<>(service.list(criteria)), HttpStatus.OK);
    }
}
