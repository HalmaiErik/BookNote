package com.softwaredesign.booknote.repository;

import com.softwaredesign.booknote.domain.entity.Theme;
import com.softwaredesign.booknote.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ThemeRepository extends JpaRepository<Theme, Long> {
    List<Theme> findAllByUser(User user);
}
