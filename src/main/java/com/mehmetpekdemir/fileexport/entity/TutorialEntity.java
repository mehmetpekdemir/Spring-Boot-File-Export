package com.mehmetpekdemir.fileexport.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "tutorials")
public class TutorialEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Column(name = "description", nullable = false, length = 400)
    private String description;

    @Column(name = "published")
    private Boolean published;

    public TutorialEntity(String title, String description, Boolean published) {
        this.title = title;
        this.description = description;
        this.published = published;
    }

}
