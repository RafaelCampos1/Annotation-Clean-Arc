package com.annotations.infrastructure.jpa;

import com.annotations.infrastructure.persistence.AnnotationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnnotationRepoJpa extends JpaRepository<AnnotationEntity,Long> {
    List<AnnotationEntity> findAllByUserEntityId(Long id);
}
