package com.softwaredesign.booknote.application.service;

import com.softwaredesign.booknote.application.mapper.ChapterMapper;
import com.softwaredesign.booknote.domain.entity.Chapter;
import com.softwaredesign.booknote.presentation.dto.ChapterDTO;
import com.softwaredesign.booknote.repository.ChapterRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ChapterService {
    private final ChapterRepository chapterRepository;
    private final ChapterMapper chapterMapper;

    public ChapterDTO save(ChapterDTO chapterDTO) {
        Chapter chapter = chapterRepository.save(chapterMapper.convertToEntity(chapterDTO));
        return chapterMapper.convertToDTO(chapter);
    }

    public List<ChapterDTO> getByBook(Long id) {
        return chapterRepository.findAllByBook_Id(id)
                .stream()
                .map(chapterMapper::convertToDTO)
                .collect(Collectors.toList());
    }
}
