package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Word;

import java.util.List;

public interface WordRepository extends JpaRepository<Word, Integer> {

    List<Word> findByWordIgnoreCaseContaining(String content);
}