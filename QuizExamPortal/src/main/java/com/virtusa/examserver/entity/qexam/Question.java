package com.virtusa.examserver.entity.qexam;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;



//import lombok.AllArgsConstructor
//import lombok.Data
//import lombok.NoArgsConstructor
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
public class Question {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long quesId;
    @Column(length = 5000)
    private String content;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    
    
    private String answer;

    @Transient
    private  String givenAnswer;

    @ManyToOne(fetch = FetchType.EAGER)
    private Quiz quiz;

	public Long getQuesId() {
		return quesId;
	}

	public void setQuesId(Long quesId) {
		this.quesId = quesId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	//@JsonIgnore
	public String getAnswer() {
		return answer;
	}

	//@JsonProperty("answer")
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getGivenAnswer() {
		return givenAnswer;
	}

	public void setGivenAnswer(String givenAnswer) {
		this.givenAnswer = givenAnswer;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public Question(Long quesId, String content, String option1, String option2, String option3, String option4,
			String answer, String givenAnswer, Quiz quiz) {
		super();
		this.quesId = quesId;
		this.content = content;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.answer = answer;
		this.givenAnswer = givenAnswer;
		this.quiz = quiz;
	}

	public Question() {
		super();
		
	}

    
}
