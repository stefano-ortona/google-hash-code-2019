package com.ortona.stefano.hashcode_2019.model;

import java.util.List;

public class SolutionContainer {

	List<Slide> allSlides;

	public double score;

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public List<Slide> getAllSlides() {
		return allSlides;
	}

	public void setAllSlides(List<Slide> allSlides) {
		this.allSlides = allSlides;
	}
	
	@Override
  public String toString() {
		String string = "" + getAllSlides().size();
		for(Slide s: getAllSlides()) {
			string += s.toString() + "\n";
		}
		return string;
  }
}
