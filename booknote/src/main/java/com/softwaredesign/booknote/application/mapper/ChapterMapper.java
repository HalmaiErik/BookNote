package com.softwaredesign.booknote.application.mapper;

import com.softwaredesign.booknote.domain.entity.Chapter;
import com.softwaredesign.booknote.presentation.dto.ChapterDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChapterMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public ChapterMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ChapterDTO convertToDTO(Chapter chapter) {
        return modelMapper.map(chapter, ChapterDTO.class);
    }

    public Chapter convertToEntity(ChapterDTO chapterDTO) {
        return modelMapper.map(chapterDTO, Chapter.class);
    }
}
