package com.virtusa.examserver.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.examserver.entity.qexam.Question;
import com.virtusa.examserver.entity.qexam.Quiz;


@Repository
public interface QuestionRepo extends JpaRepository<Question, Long> {
	
	Set<Question> findByQuiz(Quiz quiz);
}
