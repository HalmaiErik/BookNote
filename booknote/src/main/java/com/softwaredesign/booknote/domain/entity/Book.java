package com.softwaredesign.booknote.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "book")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Book title is required")
    private String title;
    @NotBlank(message = "Book author is required")
    private String author;
    @Lob
    private String note;
    @ManyToOne
    @JoinColumn(name = "idtheme")
    private Theme theme;
    @OneToMany(mappedBy = "book")
    private List<Chapter> chapters;
}
