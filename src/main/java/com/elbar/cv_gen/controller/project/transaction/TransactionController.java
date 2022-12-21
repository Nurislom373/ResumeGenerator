package com.elbar.cv_gen.controller.project.transaction;

import com.elbar.cv_gen.controller.AbstractController;
import com.elbar.cv_gen.controller.GenericGLController;
import com.elbar.cv_gen.controller.GenericSpecificationController;
import com.elbar.cv_gen.criteria.BetweenCriteria;
import com.elbar.cv_gen.criteria.SearchCriteria;
import com.elbar.cv_gen.criteria.project.transaction.TransactionCriteria;
import com.elbar.cv_gen.dto.project.template_save.TemplateSaveCreateDTO;
import com.elbar.cv_gen.dto.project.transaction.TransactionCreateDTO;
import com.elbar.cv_gen.dto.project.transaction.TransactionDetailDTO;
import com.elbar.cv_gen.dto.project.transaction.TransactionGetDTO;
import com.elbar.cv_gen.response.Data;
import com.elbar.cv_gen.service.project.transaction.TransactionService;
import com.elbar.cv_gen.utils.BaseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/transaction/*")
public class TransactionController extends AbstractController<TransactionService>
        implements GenericGLController<TransactionGetDTO, TransactionCriteria, Integer>,
        GenericSpecificationController<SearchCriteria, BetweenCriteria, TransactionGetDTO> {

    public TransactionController(TransactionService service) {
        super(service);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<Data<String>> create(@RequestBody TransactionCreateDTO dto) {
        service.create(dto);
        return new ResponseEntity<>(new Data<>("Successfully Created - Transaction"), HttpStatus.CREATED);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Data<String>> delete(@Valid @PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>(new Data<>("Successfully Deleted - Transaction"), HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Data<TransactionGetDTO>> get(Integer id) {
        return new ResponseEntity<>(new Data<>(service.get(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
    public ResponseEntity<Data<TransactionDetailDTO>> detail(@Valid @PathVariable Integer id) {
        return new ResponseEntity<>(new Data<>(service.detail(id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<TransactionGetDTO>>> list(TransactionCriteria criteria) {
        return new ResponseEntity<>(new Data<>(service.list(criteria)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<TransactionGetDTO>>> list_with_search(SearchCriteria criteria) {
        return new ResponseEntity<>(new Data<>(service.list_with_search(criteria)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<TransactionGetDTO>>> list_with_between(BetweenCriteria criteria) {
        return new ResponseEntity<>(new Data<>(service.list_with_between(criteria)), HttpStatus.OK);
    }
}
