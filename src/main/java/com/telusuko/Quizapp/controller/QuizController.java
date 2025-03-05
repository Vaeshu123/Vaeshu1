package com.telusuko.Quizapp.controller;

import com.telusuko.Quizapp.model.Question;
import com.telusuko.Quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestBody Question question, @RequestParam int numQ, @RequestParam String title){
        return quizService.createQuiz(question.getCategory(),numQ,title);
    }
}
