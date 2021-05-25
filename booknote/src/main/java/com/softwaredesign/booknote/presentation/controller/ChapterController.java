package com.softwaredesign.booknote.presentation.controller;

import com.softwaredesign.booknote.application.service.ChapterService;
import com.softwaredesign.booknote.presentation.dto.ChapterDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chapter")
@AllArgsConstructor
@Slf4j
public class ChapterController {
    private final ChapterService chapterService;

    @PostMapping
    public ResponseEntity<ChapterDTO> saveChapter(@RequestBody ChapterDTO chapterDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(chapterService.save(chapterDTO));
    }

    @GetMapping("/by-book/{id}")
    public ResponseEntity<List<ChapterDTO>> getChaptersByBook(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(chapterService.getByBook(id));
    }
}
