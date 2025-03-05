package com.telusuko.Quizapp.controller;

import com.telusuko.Quizapp.model.Question;
import com.telusuko.Quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>>getAllQuestions(){
        return questionService.getAllQuestions();
    }
    @GetMapping("category/{category}")//able to fetch data by id
    public ResponseEntity<List<Question>> getQuestionsbyCategory(@PathVariable String category){
        return questionService.getQuestionsbyCategory(category);
    }

    @PostMapping("add")//able to add data to the database
    public ResponseEntity<String>addQuestion(@RequestBody Question question){
        return questionService.addQuestions(question);

    }
}
