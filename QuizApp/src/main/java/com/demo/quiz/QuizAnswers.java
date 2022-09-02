package com.demo.quiz;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.answers.Answers;
import com.demo.answers.AnswersRepo;
import com.demo.questions.Questions;
import com.demo.questions.QuestionsRepo;

@RestController
@RequestMapping("/answers")
public class QuizAnswers {

	@Autowired
	private AnswersRepo repo;

	@Autowired
	private QuizService service;
	@Autowired
	private QuestionsRepo repo1;

	int qid;
	int count=0;
	ArrayList<String> finalresult = new ArrayList<String>();

	@PostMapping("/")
	public ResponseEntity<Object> addAnswers(@RequestBody Answers a) {
		Answers answer = repo.save(a);
		qid = answer.getQuizid();
		if (answer != null)
		{
			ArrayList<String> uans = new ArrayList<String>();
			uans.add(answer.getAnswer1());
			uans.add(answer.getAnswer2());
			uans.add(answer.getAnswer3());
			uans.add(answer.getAnswer4());
			uans.add(answer.getAnswer5());
			
			List<QuizCompete> resp = service.findque(qid);
			
			ArrayList<Integer> questionsid = new ArrayList<Integer>();

			resp.forEach(e -> questionsid.add(e.getQuestionid()));
			System.out.println(questionsid);
			
			
			List<Questions> findall = repo1.findAllById(questionsid);
			ArrayList<String> ans = new ArrayList<String>();
			findall.forEach((e)->ans.add(e.getAnswer()));
			
			

			for(int i=0; i<ans.size(); i++)
			{
				if(ans.get(i).equalsIgnoreCase(uans.get(i)))
				{
					count++;
					
				}
			}
			finalresult.clear();
			finalresult.add("Your score is: "+count);
			finalresult.add("Correct Answers are:");
			for (int i = 0; i < ans.size();i++) 
		      { 		      
			
				finalresult.add(ans.get(i)); 	
		      } 
			//System.out.println(ans);
			count=0;
		}
			
			return new ResponseEntity<Object>(finalresult, HttpStatus.CREATED);
			
		
	}



}
