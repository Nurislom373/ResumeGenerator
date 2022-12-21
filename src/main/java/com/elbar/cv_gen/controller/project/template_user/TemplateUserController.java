package com.elbar.cv_gen.controller.project.template_user;

import com.elbar.cv_gen.controller.AbstractController;
import com.elbar.cv_gen.controller.GenericCUDController;
import com.elbar.cv_gen.controller.GenericGLController;
import com.elbar.cv_gen.controller.GenericSpecificationController;
import com.elbar.cv_gen.criteria.BetweenCriteria;
import com.elbar.cv_gen.criteria.SearchCriteria;
import com.elbar.cv_gen.criteria.project.template_user.TemplateUserCriteria;
import com.elbar.cv_gen.dto.project.template_user.TemplateUserCreateDTO;
import com.elbar.cv_gen.dto.project.template_user.TemplateUserDetailDTO;
import com.elbar.cv_gen.dto.project.template_user.TemplateUserGetDTO;
import com.elbar.cv_gen.dto.project.template_user.TemplateUserUpdateDTO;
import com.elbar.cv_gen.response.Data;
import com.elbar.cv_gen.service.project.template_user.TemplateUserService;
import com.elbar.cv_gen.utils.BaseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/template_user/*")
public class TemplateUserController extends AbstractController<TemplateUserService>
        implements GenericCUDController<TemplateUserCreateDTO, TemplateUserUpdateDTO, Integer>,
        GenericGLController<TemplateUserGetDTO, TemplateUserCriteria, Integer>,
        GenericSpecificationController<SearchCriteria, BetweenCriteria, TemplateUserGetDTO> {
    public TemplateUserController(TemplateUserService service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<String>> create(TemplateUserCreateDTO DTO) {
        service.create(DTO);
        return new ResponseEntity<>(new Data<>("Successfully Created - Template User"), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Data<String>> update(TemplateUserUpdateDTO DTO) {
        service.update(DTO);
        return new ResponseEntity<>(new Data<>("Successfully Updated - Template User"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<String>> delete(@Valid Integer id) {
        service.delete(id);
        return new ResponseEntity<>(new Data<>("Successfully Deleted - Template User"), HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Data<TemplateUserGetDTO>> get(@Valid Integer id) {
        return new ResponseEntity<>(new Data<>(service.get(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
    public ResponseEntity<Data<TemplateUserDetailDTO>> detail(@PathVariable Integer id) {
        return new ResponseEntity<>(new Data<>(service.detail(id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<TemplateUserGetDTO>>> list(TemplateUserCriteria criteria) {
        return new ResponseEntity<>(new Data<>(service.list(criteria)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<TemplateUserGetDTO>>> list_with_search(SearchCriteria criteria) {
        return new ResponseEntity<>(new Data<>(service.list_with_search(criteria)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<TemplateUserGetDTO>>> list_with_between(BetweenCriteria criteria) {
        return new ResponseEntity<>(new Data<>(service.list_with_between(criteria)), HttpStatus.OK);
    }
}
