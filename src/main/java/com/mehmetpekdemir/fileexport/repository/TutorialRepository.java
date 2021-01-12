package com.mehmetpekdemir.fileexport.repository;

import com.mehmetpekdemir.fileexport.entity.TutorialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Repository
public interface TutorialRepository extends JpaRepository<TutorialEntity, Long> {

}
