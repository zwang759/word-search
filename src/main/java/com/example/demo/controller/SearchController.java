package com.example.demo.controller;

import com.example.demo.model.Word;
import com.example.demo.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    WordRepository wordRepository;

    //    @GetMapping("/")
//    public String home(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
//        model.addAttribute("name", name);
//        return "greeting";
//    }
//
    @GetMapping("/")
    public String wordSearch(Model model) {
        model.addAttribute("word", new Word());
        return "wordSearch";
    }

    @PostMapping("/")
    public String wordSearch(String word, Model model) {
        List<Word> foundWords = wordRepository.findByWordIgnoreCaseContaining(word);
        model.addAttribute("foundWords", foundWords);
        model.addAttribute("word", new Word());
        return "wordSearch";
    }
}
