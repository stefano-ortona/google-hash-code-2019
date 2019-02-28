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
		LOG.info("----------------------");
		LOG.info("First test is starting");
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
		Assert.assertEquals(1, sC.getAllSlides().size());
    for (Slide slide: sC.getAllSlides()) {
    	LOG.info(counter + " Slide: " + slide.toString());
      counter++;
      if(counter == 0) {
      	Assert.assertEquals("0 1", slide.toString());
      }
    }
	}
	
	@Test
	public void secondTest() {
		LOG.info("----------------------");
		LOG.info("Second test is starting");
		
		// TAGS MODEL
		Set<String> tagsPhoto0 = new HashSet<String>();
		tagsPhoto0.add("t0");
		tagsPhoto0.add("t1");
		
		Set<String> tagsPhoto1 = new HashSet<String>();
		tagsPhoto1.add("t1");
		
		// PHOTOS MODEL
	  Photo photo0 = new Photo();
	  photo0.setId(0);
	  photo0.setTags(tagsPhoto0);
		
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
		Assert.assertEquals(2, sC.getAllSlides().size());
    for (Slide slide: sC.getAllSlides()) {
    	LOG.info(counter + " Slide: " + slide.toString());
      counter++;
      if(counter == 0) {
      	Assert.assertEquals("0", slide.toString());
      }
      if(counter == 1) {
      	Assert.assertEquals("1", slide.toString());
      }
    }
	}
	
	@Test
	public void thirdTest() {
		LOG.info("----------------------");
		LOG.info("Third test is starting");
		
		// TAGS MODEL
		Set<String> tagsPhoto0 = new HashSet<String>();
		tagsPhoto0.add("cat");
		tagsPhoto0.add("beach");
		tagsPhoto0.add("sun");
		
		Set<String> tagsPhoto1 = new HashSet<String>();
		tagsPhoto1.add("selfie");
		tagsPhoto1.add("smile");
		
		Set<String> tagsPhoto2 = new HashSet<String>();
		tagsPhoto2.add("garden");
		tagsPhoto2.add("selfie");
		
		Set<String> tagsPhoto3 = new HashSet<String>();
		tagsPhoto3.add("garden");
		tagsPhoto3.add("cat");		
		
		// PHOTOS MODEL
	  Photo photo0 = new Photo();
	  photo0.setId(0);
	  photo0.setTags(tagsPhoto0);
		
		Photo photo1 = new Photo();
		photo1.setId(1);
		photo1.setTags(tagsPhoto1);
		photo1.setVertical(true);
		
		Photo photo2 = new Photo();
		photo2.setId(2);
		photo2.setTags(tagsPhoto2);
		photo2.setVertical(true);
		
		Photo photo3 = new Photo();
		photo3.setId(3);
		photo3.setTags(tagsPhoto3);

		// ALLPHOTOS MODEL
		List<Photo> allPhotos = new ArrayList<Photo>();
		allPhotos.add(photo0);
		allPhotos.add(photo1);
		allPhotos.add(photo2);
		allPhotos.add(photo3);
		
		// PROBLEM CONTAINER
		final ProblemContainer pC = new ProblemContainer();
		pC.setAllPhotos(allPhotos);
		
		// SOLUTION CONTAINER 
		final SolutionContainer sC = SOLVER.process(pC);
		
		// ASSERTS
		Assert.assertTrue(2. == sC.getScore());
		int counter = 0;
		Assert.assertEquals(4, sC.getAllSlides().size());
		Assert.assertEquals("0\n3\n1 2", sC.toString());
    for (Slide slide: sC.getAllSlides()) {
    	LOG.info(counter + " Slide: " + slide.toString());
      counter++;
      if(counter == 0) {
      	Assert.assertEquals("0", slide.toString());
      }
      if(counter == 1) {
      	Assert.assertEquals("3", slide.toString());
      }
      if(counter == 2) {
      	Assert.assertEquals("1 2", slide.toString());
      }
    }
	}
	
	@Test
	public void fourthTest() {
		LOG.info("----------------------");
		LOG.info("Fourth test is starting");
		
		// TAGS MODEL
		Set<String> tagsPhoto0 = new HashSet<String>();
		tagsPhoto0.add("cat");
		tagsPhoto0.add("beach");
		tagsPhoto0.add("sun");
		
		Set<String> tagsPhoto1 = new HashSet<String>();
		tagsPhoto1.add("selfie");
		tagsPhoto1.add("smile");
		
		Set<String> tagsPhoto2 = new HashSet<String>();
		tagsPhoto2.add("garden");
		tagsPhoto2.add("selfie");
		
		Set<String> tagsPhoto3 = new HashSet<String>();
		tagsPhoto3.add("garden");
		tagsPhoto3.add("cat");		
		
		// PHOTOS MODEL
	  Photo photo0 = new Photo();
	  photo0.setId(0);
	  photo0.setTags(tagsPhoto0);
		
		Photo photo1 = new Photo();
		photo1.setId(1);
		photo1.setTags(tagsPhoto1);
		photo1.setVertical(true);
		
		Photo photo2 = new Photo();
		photo2.setId(2);
		photo2.setTags(tagsPhoto2);
		photo2.setVertical(true);
		
		Photo photo3 = new Photo();
		photo3.setId(3);
		photo3.setTags(tagsPhoto3);

		// ALLPHOTOS MODEL
		List<Photo> allPhotos = new ArrayList<Photo>();
		allPhotos.add(photo0);
		allPhotos.add(photo1);
		allPhotos.add(photo2);
		allPhotos.add(photo3);
		
		// PROBLEM CONTAINER
		final ProblemContainer pC = new ProblemContainer();
		pC.setAllPhotos(allPhotos);
		
		// SOLUTION CONTAINER 
		ProblemSolver solver = new ProblemSolver(2);
		final SolutionContainer sC = solver.process(pC);
		
		// ASSERTS
		Assert.assertTrue(2. == sC.getScore());
		int counter = 0;
		Assert.assertEquals(4, sC.getAllSlides().size());
    for (Slide slide: sC.getAllSlides()) {
    	LOG.info(counter + " Slide: " + slide.toString());
      counter++;
      if(counter == 0) {
      	Assert.assertEquals("0", slide.toString());
      }
      if(counter == 1) {
      	Assert.assertEquals("3", slide.toString());
      }
      if(counter == 2) {
      	Assert.assertEquals("1 2", slide.toString());
      }
    }
	}
	
	@Test
	public void fifthTest() {
		LOG.info("----------------------");
		LOG.info("Fifth test is starting");
		
		// TAGS MODEL
		Set<String> tagsPhoto0 = new HashSet<String>();
		tagsPhoto0.add("cat");
		tagsPhoto0.add("beach");
		tagsPhoto0.add("sun");
		
		Set<String> tagsPhoto1 = new HashSet<String>();
		tagsPhoto1.add("selfie");
		tagsPhoto1.add("smile");
		
		Set<String> tagsPhoto2 = new HashSet<String>();
		tagsPhoto2.add("garden");
		tagsPhoto2.add("selfie");
		
		Set<String> tagsPhoto3 = new HashSet<String>();
		tagsPhoto3.add("garden");
		tagsPhoto3.add("cat");		
		
		Set<String> tagsPhoto4 = new HashSet<String>();
		tagsPhoto4.add("garden");
		tagsPhoto4.add("selfie");		
		
		Set<String> tagsPhoto5 = new HashSet<String>();
		tagsPhoto5.add("garden");
		
		Set<String> tagsPhoto6 = new HashSet<String>();
		tagsPhoto6.add("kitchen");
		tagsPhoto6.add("cat");
		tagsPhoto6.add("ball");
		tagsPhoto6.add("table");
		
		// PHOTOS MODEL
	  Photo photo0 = new Photo();
	  photo0.setId(0);
	  photo0.setTags(tagsPhoto0);
		
		Photo photo1 = new Photo();
		photo1.setId(1);
		photo1.setTags(tagsPhoto1);
		photo1.setVertical(true);
		
		Photo photo2 = new Photo();
		photo2.setId(2);
		photo2.setTags(tagsPhoto2);
		photo2.setVertical(true);
		
		Photo photo3 = new Photo();
		photo3.setId(3);
		photo3.setTags(tagsPhoto3);
		
		Photo photo4 = new Photo();
		photo4.setId(4);
		photo4.setTags(tagsPhoto4);
		
		Photo photo5 = new Photo();
		photo5.setId(5);
		photo5.setTags(tagsPhoto5);
		
		Photo photo6 = new Photo();
		photo6.setId(6);
		photo6.setTags(tagsPhoto6);

		// ALLPHOTOS MODEL
		List<Photo> allPhotos = new ArrayList<Photo>();
		allPhotos.add(photo0);
		allPhotos.add(photo1);
		allPhotos.add(photo2);
		allPhotos.add(photo3);
		allPhotos.add(photo4);
		allPhotos.add(photo5);
		allPhotos.add(photo6);
		
		// PROBLEM CONTAINER
		final ProblemContainer pC = new ProblemContainer();
		pC.setAllPhotos(allPhotos);
		
		// SOLUTION CONTAINER 
		ProblemSolver solver = new ProblemSolver(3);
		final SolutionContainer sC = solver.process(pC);
		
		// ASSERTS
		// Assert.assertTrue(2. == sC.getScore());
		int counter = 0;
		Assert.assertEquals(7, sC.getAllSlides().size());
    for (Slide slide: sC.getAllSlides()) {
    	LOG.info(counter + " Slide: " + slide.toString());
      counter++;      
    }
	}

	
}
