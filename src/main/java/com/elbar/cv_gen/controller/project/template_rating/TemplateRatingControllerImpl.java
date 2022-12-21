package com.elbar.cv_gen.controller.project.template_rating;

import com.elbar.cv_gen.controller.AbstractController;
import com.elbar.cv_gen.criteria.BetweenCriteria;
import com.elbar.cv_gen.criteria.SearchCriteria;
import com.elbar.cv_gen.criteria.project.template_rating.TemplateRatingCriteria;
import com.elbar.cv_gen.dto.project.template_rating.TemplateRatingCreateDTO;
import com.elbar.cv_gen.dto.project.template_rating.TemplateRatingGetDTO;
import com.elbar.cv_gen.dto.project.template_rating.TemplateRatingUpdateDTO;
import com.elbar.cv_gen.response.Data;
import com.elbar.cv_gen.service.project.template_rating.TemplateRatingServiceImpl;
import com.elbar.cv_gen.utils.BaseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/template-rating/*")
public class TemplateRatingControllerImpl extends AbstractController<TemplateRatingServiceImpl> implements TemplateRatingController {
    public TemplateRatingControllerImpl(TemplateRatingServiceImpl service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<String>> create(TemplateRatingCreateDTO DTO) {
        service.create(DTO);
        return new ResponseEntity<>(new Data<>("Successfully created template rating"), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Data<String>> update(TemplateRatingUpdateDTO DTO) {
        service.update(DTO);
        return new ResponseEntity<>(new Data<>("Successfully updated template rating"), HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Data<String>> delete(Integer id) {
        service.delete(id);
        return new ResponseEntity<>(new Data<>("Successfully deleted template rating"), HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Data<TemplateRatingGetDTO>> get(Integer id) {
        return new ResponseEntity<>(new Data<>(service.get(id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<TemplateRatingGetDTO>>> list(TemplateRatingCriteria criteria) {
        return new ResponseEntity<>(new Data<>(service.list(criteria)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<TemplateRatingGetDTO>>> list_with_search(SearchCriteria criteria) {
        return new ResponseEntity<>(new Data<>(service.list_with_search(criteria)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<TemplateRatingGetDTO>>> list_with_between(BetweenCriteria criteria) {
        return new ResponseEntity<>(new Data<>(service.list_with_between(criteria)), HttpStatus.OK);
    }
}
