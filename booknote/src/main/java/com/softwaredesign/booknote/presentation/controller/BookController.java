package com.softwaredesign.booknote.presentation.controller;

import com.softwaredesign.booknote.application.service.BookService;
import com.softwaredesign.booknote.presentation.dto.BookDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
@AllArgsConstructor
@Slf4j
public class BookController {
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<BookDTO> saveBook(@RequestBody BookDTO bookDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(bookService.save(bookDTO));
    }

    @GetMapping("/by-theme/{id}")
    public ResponseEntity<List<BookDTO>> getBooksByTheme(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(bookService.getByTheme(id));
    }
}
