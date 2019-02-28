package com.ortona.stefano.hashcode_2019;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ortona.stefano.hashcode_2019.logic.ProblemSolver;
import com.ortona.stefano.hashcode_2019.model.Photo;
import com.ortona.stefano.hashcode_2019.model.ProblemContainer;
import com.ortona.stefano.hashcode_2019.model.Slide;
import com.ortona.stefano.hashcode_2019.model.SolutionContainer;

/**
 *
 */
public class ProblemSolverTest {

	private final static ProblemSolver SOLVER = new ProblemSolver();

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	@Test
	public void firstTest() {
		LOG.info("This is a logger print! by Gio");
		// TAGS MODEL
		Set<String> tagsPhoto0 = new HashSet<String>();
		tagsPhoto0.add("t0");
		
		Set<String> tagsPhoto1 = new HashSet<String>();
		tagsPhoto1.add("t1");
		
		// PHOTOS MODEL
	  Photo photo0 = new Photo();
	  photo0.setId(0);
	  photo0.setTags(tagsPhoto0);
		photo0.setVertical(true);
		
		Photo photo1 = new Photo();
		photo1.setId(1);
		photo1.setTags(tagsPhoto1);
		photo1.setVertical(true);
		
		// ALLPHOTOS MODEL
		List<Photo> allPhotos = new ArrayList<Photo>();
		allPhotos.add(photo0);
		allPhotos.add(photo1);
		
		// PROBLEM CONTAINER
		final ProblemContainer pC = new ProblemContainer();
		pC.setAllPhotos(allPhotos);
		
		// SOLUTION CONTAINER 
		final SolutionContainer sC = SOLVER.process(pC);
		
		// ASSERTS
		Assert.assertTrue(0. == sC.getScore());
		int counter = 0;
    for (Slide slide: sC.getAllSlides()) {
    	LOG.info(counter + " Slide: " + slide.toString());
      counter++;
      Assert.assertEquals("0 1", slide.toString());
    }
	}

}
