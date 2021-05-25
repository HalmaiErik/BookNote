package com.softwaredesign.booknote.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "theme")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Theme name is required")
    private String name;
    @ManyToOne
    @JoinColumn(name = "iduser")
    private User user;
    @OneToMany(mappedBy = "theme")
    private List<Book> books;
}
