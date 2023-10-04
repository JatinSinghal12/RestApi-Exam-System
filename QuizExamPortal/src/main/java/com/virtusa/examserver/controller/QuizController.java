package com.virtusa.examserver.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.examserver.entity.qexam.Quiz;
import com.virtusa.examserver.service.QuizService;



@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
    private QuizService quizService;

	//add quiz
    @PostMapping("/")
    public ResponseEntity<Quiz> add(@RequestBody Quiz quiz) {
        return ResponseEntity.ok(this.quizService.addQuiz(quiz));
    }

    //update quiz
    @PutMapping("/")
    public ResponseEntity<Quiz> update(@RequestBody Quiz quiz) {
        return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
    }

    //get quiz
    @GetMapping("/")
    public ResponseEntity<?> quizzes() {
        return ResponseEntity.ok(this.quizService.getQuizzes());
    }

    //get single quiz
    @GetMapping("/{qid}")
    public Quiz quiz(@PathVariable("qid") Long qid) {
        return this.quizService.getQuiz(qid);
    }

    //delete the quiz
    @DeleteMapping("/{qid}")
    public void delete(@PathVariable("qid") Long qid) {
        this.quizService.deleteQuiz(qid);
    }

//    @GetMapping("/category/{cid}")
//    public List<Quiz> getQuizzesOfCategory(@PathVariable("cid") Long cid) {
//        Category category = new Category();
//        category.setCid(cid);
//        return this.quizService.getQuizzesOfCategory(category);
//    }
//
//    
//    @GetMapping("/active")
//    public List<Quiz> getActiveQuizzes() {
//        return this.quizService.getActiveQuizzes();
//    }
//
//    
//    @GetMapping("/category/active/{cid}")
//    public List<Quiz> getActiveQuizzes(@PathVariable("cid") Long cid) {
//        Category category = new Category();
//        category.setCid(cid);
//        return this.quizService.getActiveQuizzesOfCategory(category);
//    }
}
//{
//    "title":"Python Basic Quiz",
//    "description":"This quiz contains question of Basic Python",
//    "maxMarks":"200",
//    "numberOfQuestions":"20",
//    "category":{
//        "cid": 11
//    }
//
//}
