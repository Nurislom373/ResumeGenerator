package com.elbar.cv_gen.controller.project.category;

import com.elbar.cv_gen.controller.AbstractController;
import com.elbar.cv_gen.criteria.BetweenCriteria;
import com.elbar.cv_gen.criteria.SearchCriteria;
import com.elbar.cv_gen.criteria.project.category.CategoryCriteria;
import com.elbar.cv_gen.dto.project.category.CategoryCreateDTO;
import com.elbar.cv_gen.dto.project.category.CategoryGetDTO;
import com.elbar.cv_gen.dto.project.category.CategoryUpdateDTO;
import com.elbar.cv_gen.response.Data;
import com.elbar.cv_gen.service.project.category.CategoryServiceImpl;
import com.elbar.cv_gen.utils.BaseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/category/*")
public class CategoryControllerImpl extends AbstractController<CategoryServiceImpl> implements CategoryController {
    public CategoryControllerImpl(CategoryServiceImpl service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<String>> create(CategoryCreateDTO DTO) {
        service.create(DTO);
        return new ResponseEntity<>(new Data<>("Successfully created category"), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Data<String>> update(CategoryUpdateDTO DTO) {
        service.update(DTO);
        return new ResponseEntity<>(new Data<>("Successfully updated category"), HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Data<String>> delete(Integer id) {
        service.delete(id);
        return new ResponseEntity<>(new Data<>("Successfully deleted category"), HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Data<CategoryGetDTO>> get(Integer id) {
        return new ResponseEntity<>(new Data<>(service.get(id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<CategoryGetDTO>>> list(CategoryCriteria criteria) {
        return new ResponseEntity<>(new Data<>(service.list(criteria)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<CategoryGetDTO>>> list_with_search(SearchCriteria criteria) {
        return new ResponseEntity<>(new Data<>(service.list_with_search(criteria)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<CategoryGetDTO>>> list_with_between(BetweenCriteria criteria) {
        return new ResponseEntity<>(new Data<>(service.list_with_between(criteria)), HttpStatus.OK);
    }
}
