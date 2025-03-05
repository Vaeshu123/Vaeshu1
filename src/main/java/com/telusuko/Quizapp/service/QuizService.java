package com.telusuko.Quizapp.service;

import com.telusuko.Quizapp.dao.QuestionDao;
import com.telusuko.Quizapp.dao.QuizDao;
import com.telusuko.Quizapp.model.Question;
import com.telusuko.Quizapp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions = questionDao.findRandomByCategory(category,numQ,title);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
       return new ResponseEntity<>("quiz created", HttpStatus.CREATED);

    }
}
