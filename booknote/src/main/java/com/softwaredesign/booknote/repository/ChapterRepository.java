package com.softwaredesign.booknote.repository;

import com.softwaredesign.booknote.domain.entity.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChapterRepository extends JpaRepository<Chapter, Long> {
    List<Chapter> findAllByBook_Id(Long id);
}
