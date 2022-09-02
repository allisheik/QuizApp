package com.demo.quiz;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepo extends JpaRepository<QuizCompete, Integer> {

		public List<QuizCompete> findByQuizid(int quizid);
}