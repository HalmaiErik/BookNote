package com.softwaredesign.booknote.application.service;

import com.softwaredesign.booknote.application.mapper.BookMapper;
import com.softwaredesign.booknote.domain.entity.Book;
import com.softwaredesign.booknote.presentation.dto.BookDTO;
import com.softwaredesign.booknote.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookDTO save(BookDTO bookDTO) {
        Book book = bookRepository.save(bookMapper.convertToEntity(bookDTO));
        return bookMapper.convertToDTO(book);
    }

    public List<BookDTO> getByTheme(Long id) {
        return bookRepository.findAllByTheme_Id(id)
                .stream()
                .map(bookMapper::convertToDTO)
                .collect(Collectors.toList());
    }
}
