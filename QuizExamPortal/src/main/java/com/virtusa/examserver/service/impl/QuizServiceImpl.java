package com.virtusa.examserver.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.examserver.entity.qexam.Quiz;
import com.virtusa.examserver.repo.QuizRepo;
import com.virtusa.examserver.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService {

	
	@Autowired
    private QuizRepo quizRepo;
	@Override
	public Quiz addQuiz(Quiz quiz) {
		
		return this.quizRepo.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		
		return this.quizRepo.save(quiz);
	}

	@Override
	public Set<Quiz> getQuizzes() {
		
		return new HashSet<>(this.quizRepo.findAll());
	}

	@Override
	public Quiz getQuiz(Long quizId) {
		
		return this.quizRepo.findById(quizId).get();
	}

	@Override
	public void deleteQuiz(Long quizId) {
		this.quizRepo.deleteById(quizId);
	}

	
}
