package com.elbar.cv_gen.controller.project.template_gen;

import com.elbar.cv_gen.controller.AbstractController;
import com.elbar.cv_gen.dto.project.template_gen.TemplateGenCreateDTO;
import com.elbar.cv_gen.service.project.template_gen.TemplateGenService;
import com.elbar.cv_gen.utils.BaseUtils;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "*")
@RestController
@RequestMapping(value = BaseUtils.PATH + "/template_get/*")
public class TemplateGenController extends AbstractController<TemplateGenService> {
    public TemplateGenController(TemplateGenService service) {
        super(service);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Resource> gen(@RequestBody TemplateGenCreateDTO dto) {
        return new ResponseEntity<>(service.gen(dto), HttpStatus.NO_CONTENT);
    }
}
