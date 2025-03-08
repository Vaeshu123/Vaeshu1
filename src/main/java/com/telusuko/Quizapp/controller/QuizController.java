package com.telusuko.Quizapp.controller;

import com.telusuko.Quizapp.dao.Response;
import com.telusuko.Quizapp.model.Question;
import com.telusuko.Quizapp.model.QuestionWrapper;
import com.telusuko.Quizapp.service.QuizService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestBody Question question, @RequestParam int numQ, @RequestParam String title){
        return quizService.createQuiz(question.getCategory(),numQ,title);
    }

    @GetMapping("/get/{id}")
    public  ResponseEntity<List<QuestionWrapper>>getQuizQuestions(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.calculateResult(id, responses);
    }
}
