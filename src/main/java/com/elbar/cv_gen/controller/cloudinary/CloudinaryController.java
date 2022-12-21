package com.elbar.cv_gen.controller.cloudinary;

import com.elbar.cv_gen.criteria.cloudinary.CloudinaryCriteria;
import com.elbar.cv_gen.dto.cloudinary.CloudinaryDetailDTO;
import com.elbar.cv_gen.dto.cloudinary.CloudinaryGetDTO;
import com.elbar.cv_gen.response.Data;
import com.elbar.cv_gen.service.cloudinary.CloudinaryService;
import com.elbar.cv_gen.utils.BaseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/upload/*")
public class CloudinaryController {

    private final CloudinaryService service;

    public CloudinaryController(CloudinaryService service) {
        this.service = service;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Data<CloudinaryGetDTO>> add(@RequestParam("file") MultipartFile file) {
        return new ResponseEntity<>(new Data<>(service.upload(file)), HttpStatus.OK);
    }

    @RequestMapping(value = "addAll", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Data<List<CloudinaryGetDTO>>> addAll(@RequestParam("file") MultipartFile[] files) {
        return new ResponseEntity<>(new Data<>(service.multiUpload(files)), HttpStatus.OK);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Data<String>> delete(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>(new Data<>("Successfully Deleted - Cloudinary"), HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public ResponseEntity<Data<CloudinaryGetDTO>> get(@PathVariable Integer id) {
        return new ResponseEntity<>(new Data<>(service.get(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
    public ResponseEntity<Data<CloudinaryDetailDTO>> detail(@PathVariable Integer id) {
        return new ResponseEntity<>(new Data<>(service.detail(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseEntity<Data<List<CloudinaryGetDTO>>> list(@Valid CloudinaryCriteria criteria) {
        return new ResponseEntity<>(new Data<>(service.list(criteria)), HttpStatus.OK);
    }

}
