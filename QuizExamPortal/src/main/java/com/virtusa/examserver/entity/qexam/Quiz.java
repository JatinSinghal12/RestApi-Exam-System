package com.virtusa.examserver.entity.qexam;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

//import lombok.AllArgsConstructor
//import lombok.Data
//import lombok.NoArgsConstructor
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
public class Quiz {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long qId;
	    private String title;

	    @Column(length = 5000)
	    private String description;
	    private String maxMarks;
	    private String numberOfQuestions;
	    private boolean active = false;

	    @ManyToOne(fetch = FetchType.EAGER)
	    private Category category;

	    @OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	    @JsonIgnore
	    private Set<Question> questions = new HashSet<>();
	    
	    public boolean isActive() {
	        return active;
	    }

	    public void setActive(boolean active) {
	        this.active = active;
	    }

		public Long getqId() {
			return qId;
		}

		public void setqId(Long qId) {
			this.qId = qId;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getMaxMarks() {
			return maxMarks;
		}

		public void setMaxMarks(String maxMarks) {
			this.maxMarks = maxMarks;
		}

		public String getNumberOfQuestions() {
			return numberOfQuestions;
		}

		public void setNumberOfQuestions(String numberOfQuestions) {
			this.numberOfQuestions = numberOfQuestions;
		}

		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}

		public Set<Question> getQuestions() {
			return questions;
		}

		public void setQuestions(Set<Question> questions) {
			this.questions = questions;
		}

		public Quiz(Long qId, String title, String description, String maxMarks, String numberOfQuestions,
				boolean active, Category category, Set<Question> questions) {
			super();
			this.qId = qId;
			this.title = title;
			this.description = description;
			this.maxMarks = maxMarks;
			this.numberOfQuestions = numberOfQuestions;
			this.active = active;
			this.category = category;
			this.questions = questions;
		}

		public Quiz() {
			super();
		}
		
	    
	    
}
