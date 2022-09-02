package com.demo.questions;

import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Questions {
	
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String que;
	private String opA;
	private String opB;
	private String answer;
	
	
	
	public Questions(int id, String que, String opA, String opB,  String answer) {
		super();
		this.id = id;
		this.que = que;
		this.opA = opA;
		this.opB = opB;
		this.answer = answer;
	}



	public Questions() {
		super();
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getQue() {
		return que;
	}



	public void setQue(String que) {
		this.que = que;
	}



	public String getOpA() {
		return opA;
	}



	public void setOpA(String opA) {
		this.opA = opA;
	}



	public String getOpB() {
		return opB;
	}



	public void setOpB(String opB) {
		this.opB = opB;
	}


	public String getAnswer() {
		return answer;
	}



	public void setAnswer(String answer) {
		this.answer = answer;
	}



	@Override
	public String toString() {
		return "Questions [id=" + id + ", que=" + que + ", opA=" + opA + ", opB=" + opB + ", answer=" + answer + "]";
	}
	
	

}
