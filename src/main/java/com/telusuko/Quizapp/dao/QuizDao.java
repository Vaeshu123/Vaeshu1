package com.telusuko.Quizapp.dao;

import com.telusuko.Quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizDao extends JpaRepository<Quiz,Integer> {
    List<Quiz> findAllById(Integer id);
}
