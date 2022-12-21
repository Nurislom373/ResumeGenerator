package com.elbar.cv_gen.controller.auth.auth_payment;

import com.elbar.cv_gen.controller.AbstractController;
import com.elbar.cv_gen.controller.GenericGLController;
import com.elbar.cv_gen.criteria.auth.auth_payment.AuthPaymentCriteria;
import com.elbar.cv_gen.dto.auth.auth_payment.AuthPaymentCreateDto;
import com.elbar.cv_gen.dto.auth.auth_payment.AuthPaymentGetDto;
import com.elbar.cv_gen.response.Data;
import com.elbar.cv_gen.service.auth.auth_payment.AuthPaymentService;
import com.elbar.cv_gen.utils.BaseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/auth_payment/*")
public class AuthPaymentController extends AbstractController<AuthPaymentService>
        implements GenericGLController<AuthPaymentGetDto, AuthPaymentCriteria, Integer> {

    public AuthPaymentController(AuthPaymentService service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<AuthPaymentGetDto>> get(Integer id) {
        return new ResponseEntity<>(new Data<>(service.get(id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<AuthPaymentGetDto>>> list(AuthPaymentCriteria criteria) {
        return new ResponseEntity<>(new Data<>(service.list(criteria)), HttpStatus.OK);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<Data<String>> create(@RequestBody AuthPaymentCreateDto dto) {
        service.create(dto);
        return new ResponseEntity<>(new Data<>("Successfully Created - Card For"), HttpStatus.CREATED);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Data<String>> delete(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>(new Data<>("Successfully Deleted - Car For"), HttpStatus.NO_CONTENT);
    }
}
