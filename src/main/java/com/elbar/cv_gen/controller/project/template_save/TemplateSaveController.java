package com.elbar.cv_gen.controller.project.template_save;

import com.elbar.cv_gen.controller.AbstractController;
import com.elbar.cv_gen.controller.GenericGLController;
import com.elbar.cv_gen.criteria.project.template_save.TemplateSaveCriteria;
import com.elbar.cv_gen.dto.auth.auth_block.AuthBlockCreateDTO;
import com.elbar.cv_gen.dto.auth.auth_block.AuthBlockDetailDTO;
import com.elbar.cv_gen.dto.project.template_save.TemplateSaveCreateDTO;
import com.elbar.cv_gen.dto.project.template_save.TemplateSaveDetailDTO;
import com.elbar.cv_gen.dto.project.template_save.TemplateSaveGetDTO;
import com.elbar.cv_gen.response.Data;
import com.elbar.cv_gen.service.project.template_save.TemplateSaveService;
import com.elbar.cv_gen.utils.BaseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/template_save/*")
public class TemplateSaveController extends AbstractController<TemplateSaveService>
        implements GenericGLController<TemplateSaveGetDTO, TemplateSaveCriteria, Integer> {
    public TemplateSaveController(TemplateSaveService service) {
        super(service);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<Data<String>> create(@RequestBody TemplateSaveCreateDTO dto) {
        service.create(dto);
        return new ResponseEntity<>(new Data<>("Successfully Created - Template Save"), HttpStatus.CREATED);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Data<String>> delete(@Valid @PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>(new Data<>("Successfully Deleted - Template Save"), HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Data<TemplateSaveGetDTO>> get(@Valid Integer id) {
        return new ResponseEntity<>(new Data<>(service.get(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
    public ResponseEntity<Data<TemplateSaveDetailDTO>> detail(@PathVariable Integer id) {
        return new ResponseEntity<>(new Data<>(service.detail(id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<TemplateSaveGetDTO>>> list(TemplateSaveCriteria criteria) {
        return new ResponseEntity<>(new Data<>(service.list(criteria)), HttpStatus.OK);
    }
}
