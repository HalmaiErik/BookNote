package com.softwaredesign.booknote.application.mapper;

import com.softwaredesign.booknote.domain.entity.Theme;
import com.softwaredesign.booknote.domain.entity.User;
import com.softwaredesign.booknote.presentation.dto.ThemeDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ThemeMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public ThemeMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ThemeDTO convertToDTO(Theme theme) {
        return modelMapper.map(theme, ThemeDTO.class);
    }

    public Theme convertToEntity(ThemeDTO themeDTO, User user) {
        Theme theme = modelMapper.map(themeDTO, Theme.class);
        theme.setUser(user);
        return theme;
    }
}
