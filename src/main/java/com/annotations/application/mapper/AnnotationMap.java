package com.annotations.application.mapper;

import com.annotations.application.model.AnnotationInput;
import com.annotations.application.model.AnnotationOutPut;
import com.annotations.domain.aggregate.Annotation;

import java.util.ArrayList;
import java.util.List;
public abstract class AnnotationMap {

    public static AnnotationOutPut convert(AnnotationInput annotationInput){
        return new AnnotationOutPut(
                annotationInput.content().content(),
                annotationInput.title().title(),
                annotationInput.userId());
    }

    /*Conversor de Lista de DTOs de anotacao para saida da API
        recebe uma lista de models de Annotation, pega os dados de cada indice
        e coloca esses dados dentro de uma lista vazia de AnnotationOuput
        TODO: trocar o nome do model para AnnotationOutput
     */

    public static List<AnnotationOutPut> convert(List<Annotation> annotationList){
        List<AnnotationOutPut> annotationOutPutList = new ArrayList<>();
        annotationList
                .forEach(list -> annotationOutPutList.add(
                        new AnnotationOutPut(list.getTitle(),list.getContent(),list.getUser().getId())));
        return annotationOutPutList;
    }


}
