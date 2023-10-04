package com.virtusa.examserver.service;


import java.util.Set;


import com.virtusa.examserver.entity.qexam.Quiz;

public interface QuizService {
	public Quiz addQuiz(Quiz quiz);
	
	public Quiz updateQuiz(Quiz quiz);
	
	public Set<Quiz> getQuizzes();
	
	public Quiz getQuiz(Long quizId);
	
	public void deleteQuiz(Long quizId);

	//public List<Quiz> getQuizzesOfCategory(Category category)


}
