package com.softwaredesign.booknote.presentation.controller;

import com.softwaredesign.booknote.application.service.ThemeService;
import com.softwaredesign.booknote.presentation.dto.ThemeDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theme")
@AllArgsConstructor
@Slf4j
public class ThemeController {
    private final ThemeService themeService;

    @PostMapping("")
    public ResponseEntity<ThemeDTO> saveTheme(@RequestBody ThemeDTO themeDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(themeService.save(themeDTO));
    }

    @GetMapping("")
    public ResponseEntity<List<ThemeDTO>> getCurrentUserThemes() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(themeService.getCurrentUserThemes());
    }
}
