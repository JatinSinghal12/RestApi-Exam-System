package com.virtusa.examserver.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.virtusa.examserver.entity.qexam.Quiz;


@Repository
public interface QuizRepo extends JpaRepository<Quiz, Long>  {
	
	
}
