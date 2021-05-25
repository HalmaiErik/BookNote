package com.softwaredesign.booknote.application.service;

import com.softwaredesign.booknote.application.mapper.ThemeMapper;
import com.softwaredesign.booknote.domain.entity.Theme;
import com.softwaredesign.booknote.presentation.dto.ThemeDTO;
import com.softwaredesign.booknote.repository.ThemeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ThemeService {

    private final ThemeRepository themeRepository;
    private final ThemeMapper themeMapper;
    private final AuthService authService;

    public ThemeDTO save(ThemeDTO themeDTO) {
        Theme theme = themeRepository.save(themeMapper.convertToEntity(themeDTO, authService.getCurrentUser()));
        return themeMapper.convertToDTO(theme);
    }

    public List<ThemeDTO> getCurrentUserThemes() {
        return themeRepository.findAllByUser(authService.getCurrentUser())
                .stream()
                .map(themeMapper::convertToDTO)
                .collect(Collectors.toList());
    }
}
