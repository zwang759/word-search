package com.example.demo;

import com.example.demo.model.Word;
import com.example.demo.repository.WordRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


@SpringBootApplication
public class DemoApplication {
    @Autowired
    private WordRepository wordRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    InitializingBean sendDatabase() {
        return () -> {
            try {
                URL url = new URL("https://raw.githubusercontent.com/dwyl/english-words/master/words.txt");
                Scanner in = new Scanner(url.openStream());
                // read from scanner
                while (in.hasNextLine()) {
                    String word = in.nextLine().trim();
                    wordRepository.save(new Word(word));
                }
            }
            catch(IOException ex) {
                ex.printStackTrace();
            }
        };
    }

}
