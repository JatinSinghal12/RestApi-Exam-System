package com.virtusa.examserver.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.examserver.entity.qexam.Question;
import com.virtusa.examserver.entity.qexam.Quiz;
import com.virtusa.examserver.repo.QuestionRepo;
import com.virtusa.examserver.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepo questionRepo;
	
	@Override
	public Question addQuestion(Question question) {
		
		return this.questionRepo.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		
		return this.questionRepo.save(question);
	}

	@Override
	public Set<Question> getQuestions() {
		
		return new HashSet<>(this.questionRepo.findAll());
	}

	@Override
	public Question getQuestion(Long questionId) {
		
		return this.questionRepo.findById(questionId).get();
	}

	@Override
	public Set<Question> getQuestionsOfQuiz(Quiz quiz) {
		
		return this.questionRepo.findByQuiz(quiz);
	}

	@Override
	public void deleteQuestion(Long quesId) {
		Question question=new Question();
		question.setQuesId(quesId);
		this.questionRepo.delete(question);
		
	}

	@Override
	public Question get(Long quesId) {
		
		return this.questionRepo.getOne(quesId);
	}

}
