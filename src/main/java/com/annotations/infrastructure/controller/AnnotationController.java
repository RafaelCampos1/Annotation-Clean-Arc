package com.annotations.infrastructure.controller;

import com.annotations.application.ApiConfiguration;
import com.annotations.application.usecase.AnnotationUseCase;
import com.annotations.application.enun.ApiResponseEnum;
import com.annotations.application.model.AnnotationInput;
import com.annotations.application.model.AnnotationOutPut;
import com.annotations.application.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(ApiConfiguration.API_VERSION
        + ApiConfiguration.ANNOTATION)
public class AnnotationController {

    private final AnnotationUseCase annotationUseCase;

    public AnnotationController(AnnotationUseCase annotationUseCase) {
        this.annotationUseCase = annotationUseCase;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> create(@Valid @RequestBody AnnotationInput annotationInput){
        log.info(String.valueOf(annotationInput));
        annotationUseCase.createAnnotation(annotationInput);
        return new ResponseEntity<>(new ApiResponse().response(ApiResponseEnum.RESPONSE_CREATED), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable("id") Long id){
        annotationUseCase.deleteAnnotation(id);
        return new ResponseEntity<>(new ApiResponse().response(ApiResponseEnum.RESPONSE_DELETED), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> update(@RequestBody AnnotationInput annotationInput, @PathVariable("id") Long id){
        annotationUseCase.updateAnnotation(annotationInput,id);
        return new ResponseEntity<>(new ApiResponse().response(ApiResponseEnum.RESPONSE_UPDATED), HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<List<AnnotationOutPut>> find(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(annotationUseCase.findAnnotation(id));
    }
}

