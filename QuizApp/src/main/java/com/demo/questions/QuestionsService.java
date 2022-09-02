package com.demo.questions;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.quiz.QuizCompete;
import com.demo.quiz.QuizRepo;

@Service
public class QuestionsService {
	
	
	@Autowired
	private QuestionsRepo repo;
	
	@Autowired
	private QuizRepo repo1;
	
	public Questions addQuestion(Questions q) {
		return repo.save(q);
	}

	public List<Questions> getAllQuestion() {
		return repo.findAll();
	}

	public boolean deleteQuestion(int id) {

			if(repo.findById(id).isPresent())
			{
				repo.deleteById(id);
				return true;
			}
			else
				return false;
		}

	public Questions getQuestionById(int id) {
		if(repo.findById(id).isPresent()) 
			return repo.findById(id).get();
		else 
			return null;
	}
	
	
	public QuizCompete addQuiz(QuizCompete q) {
		return repo1.save(q);
	}
	

}
