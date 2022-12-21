package com.elbar.cv_gen.controller.auth.blocked_for;

import com.elbar.cv_gen.controller.AbstractController;
import com.elbar.cv_gen.controller.GenericGLController;
import com.elbar.cv_gen.criteria.auth.blocked_for.BlockedForCriteria;
import com.elbar.cv_gen.dto.auth.blocked_for.BlockedForCreateDTO;
import com.elbar.cv_gen.dto.auth.blocked_for.BlockedForGetDTO;
import com.elbar.cv_gen.response.Data;
import com.elbar.cv_gen.service.auth.blocked_for.BlockedForService;
import com.elbar.cv_gen.utils.BaseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/blocked_for/*")
public class BlockedForController extends AbstractController<BlockedForService>
        implements GenericGLController<BlockedForGetDTO, BlockedForCriteria, Integer> {

    public BlockedForController(BlockedForService service) {
        super(service);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<Data<String>> create(@RequestBody BlockedForCreateDTO dto) {
        service.create(dto);
        return new ResponseEntity<>(new Data<>("Successfully Created - Blocked For"), HttpStatus.CREATED);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Data<String>> delete(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>(new Data<>("Successfully Deleted - Blocked For"), HttpStatus.NO_CONTENT);
    }


    @Override
    public ResponseEntity<Data<BlockedForGetDTO>> get(Integer id) {
        return new ResponseEntity<>(new Data<>(service.get(id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<BlockedForGetDTO>>> list(BlockedForCriteria criteria) {
        return new ResponseEntity<>(new Data<>(service.list(criteria)), HttpStatus.OK);
    }
}
