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
		final Set<String> tagsPhoto0 = new HashSet<String>();
		tagsPhoto0.add("t0");

		final Set<String> tagsPhoto1 = new HashSet<String>();
		tagsPhoto1.add("t1");

		// PHOTOS MODEL
		final Photo photo0 = new Photo();
		photo0.setId(0);
		photo0.setTags(tagsPhoto0);
		photo0.setVertical(true);

		final Photo photo1 = new Photo();
		photo1.setId(1);
		photo1.setTags(tagsPhoto1);
		photo1.setVertical(true);

		// ALLPHOTOS MODEL
		final List<Photo> allPhotos = new ArrayList<Photo>();
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
		for (final Slide slide : sC.getAllSlides()) {
			LOG.info(counter + " Slide: " + slide.toString());
			counter++;
			if (counter == 0) {
				Assert.assertEquals("0 1", slide.toString());
			}
		}
	}

	@Test
	public void secondTest() {
		LOG.info("----------------------");
		LOG.info("Second test is starting");

		// TAGS MODEL
		final Set<String> tagsPhoto0 = new HashSet<String>();
		tagsPhoto0.add("t0");
		tagsPhoto0.add("t1");

		final Set<String> tagsPhoto1 = new HashSet<String>();
		tagsPhoto1.add("t1");

		// PHOTOS MODEL
		final Photo photo0 = new Photo();
		photo0.setId(0);
		photo0.setTags(tagsPhoto0);

		final Photo photo1 = new Photo();
		photo1.setId(1);
		photo1.setTags(tagsPhoto1);
		photo1.setVertical(true);

		// ALLPHOTOS MODEL
		final List<Photo> allPhotos = new ArrayList<Photo>();
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
		for (final Slide slide : sC.getAllSlides()) {
			LOG.info(counter + " Slide: " + slide.toString());
			counter++;
			if (counter == 0) {
				Assert.assertEquals("0", slide.toString());
			}
			if (counter == 1) {
				Assert.assertEquals("1", slide.toString());
			}
		}
	}

	@Test
	public void thirdTest() {
		LOG.info("----------------------");
		LOG.info("Third test is starting");

		// TAGS MODEL
		final Set<String> tagsPhoto0 = new HashSet<String>();
		tagsPhoto0.add("cat");
		tagsPhoto0.add("beach");
		tagsPhoto0.add("sun");

		final Set<String> tagsPhoto1 = new HashSet<String>();
		tagsPhoto1.add("selfie");
		tagsPhoto1.add("smile");

		final Set<String> tagsPhoto2 = new HashSet<String>();
		tagsPhoto2.add("garden");
		tagsPhoto2.add("selfie");

		final Set<String> tagsPhoto3 = new HashSet<String>();
		tagsPhoto3.add("garden");
		tagsPhoto3.add("cat");

		// PHOTOS MODEL
		final Photo photo0 = new Photo();
		photo0.setId(0);
		photo0.setTags(tagsPhoto0);

		final Photo photo1 = new Photo();
		photo1.setId(1);
		photo1.setTags(tagsPhoto1);
		photo1.setVertical(true);

		final Photo photo2 = new Photo();
		photo2.setId(2);
		photo2.setTags(tagsPhoto2);
		photo2.setVertical(true);

		final Photo photo3 = new Photo();
		photo3.setId(3);
		photo3.setTags(tagsPhoto3);

		// ALLPHOTOS MODEL
		final List<Photo> allPhotos = new ArrayList<Photo>();
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
		Assert.assertTrue(3 == sC.getScore());
		Assert.assertEquals(4, sC.getAllSlides().size());
		Assert.assertEquals("4\n1\n2\n3\n0\n", sC.toString());
	}

	@Test
	public void fourthTest() {
		LOG.info("----------------------");
		LOG.info("Fourth test is starting");

		// TAGS MODEL
		final Set<String> tagsPhoto0 = new HashSet<String>();
		tagsPhoto0.add("cat");
		tagsPhoto0.add("beach");
		tagsPhoto0.add("sun");

		final Set<String> tagsPhoto1 = new HashSet<String>();
		tagsPhoto1.add("selfie");
		tagsPhoto1.add("smile");

		final Set<String> tagsPhoto2 = new HashSet<String>();
		tagsPhoto2.add("garden");
		tagsPhoto2.add("selfie");

		final Set<String> tagsPhoto3 = new HashSet<String>();
		tagsPhoto3.add("garden");
		tagsPhoto3.add("cat");

		// PHOTOS MODEL
		final Photo photo0 = new Photo();
		photo0.setId(0);
		photo0.setTags(tagsPhoto0);

		final Photo photo1 = new Photo();
		photo1.setId(1);
		photo1.setTags(tagsPhoto1);
		photo1.setVertical(true);

		final Photo photo2 = new Photo();
		photo2.setId(2);
		photo2.setTags(tagsPhoto2);
		photo2.setVertical(true);

		final Photo photo3 = new Photo();
		photo3.setId(3);
		photo3.setTags(tagsPhoto3);

		// ALLPHOTOS MODEL
		final List<Photo> allPhotos = new ArrayList<Photo>();
		allPhotos.add(photo0);
		allPhotos.add(photo1);
		allPhotos.add(photo2);
		allPhotos.add(photo3);

		// PROBLEM CONTAINER
		final ProblemContainer pC = new ProblemContainer();
		pC.setAllPhotos(allPhotos);

		// SOLUTION CONTAINER
		final ProblemSolver solver = new ProblemSolver(2);
		final SolutionContainer sC = solver.process(pC);

		// ASSERTS
		Assert.assertTrue(2. == sC.getScore());
		final int counter = 0;
		Assert.assertEquals(4, sC.getAllSlides().size());
		Assert.assertEquals("4\n3\n0\n1\n2\n", sC.toString());
	}

	@Test
	public void fifthTest() {
		LOG.info("----------------------");
		LOG.info("Fifth test is starting");

		// TAGS MODEL
		final Set<String> tagsPhoto0 = new HashSet<String>();
		tagsPhoto0.add("cat");
		tagsPhoto0.add("beach");
		tagsPhoto0.add("sun");

		final Set<String> tagsPhoto1 = new HashSet<String>();
		tagsPhoto1.add("selfie");
		tagsPhoto1.add("smile");

		final Set<String> tagsPhoto2 = new HashSet<String>();
		tagsPhoto2.add("garden");
		tagsPhoto2.add("selfie");

		final Set<String> tagsPhoto3 = new HashSet<String>();
		tagsPhoto3.add("garden");
		tagsPhoto3.add("cat");

		final Set<String> tagsPhoto4 = new HashSet<String>();
		tagsPhoto4.add("garden");
		tagsPhoto4.add("selfie");

		final Set<String> tagsPhoto5 = new HashSet<String>();
		tagsPhoto5.add("garden");

		final Set<String> tagsPhoto6 = new HashSet<String>();
		tagsPhoto6.add("kitchen");
		tagsPhoto6.add("cat");
		tagsPhoto6.add("ball");
		tagsPhoto6.add("table");

		// PHOTOS MODEL
		final Photo photo0 = new Photo();
		photo0.setId(0);
		photo0.setTags(tagsPhoto0);

		final Photo photo1 = new Photo();
		photo1.setId(1);
		photo1.setTags(tagsPhoto1);
		photo1.setVertical(true);

		final Photo photo2 = new Photo();
		photo2.setId(2);
		photo2.setTags(tagsPhoto2);
		photo2.setVertical(true);

		final Photo photo3 = new Photo();
		photo3.setId(3);
		photo3.setTags(tagsPhoto3);

		final Photo photo4 = new Photo();
		photo4.setId(4);
		photo4.setTags(tagsPhoto4);

		final Photo photo5 = new Photo();
		photo5.setId(5);
		photo5.setTags(tagsPhoto5);

		final Photo photo6 = new Photo();
		photo6.setId(6);
		photo6.setTags(tagsPhoto6);

		// ALLPHOTOS MODEL
		final List<Photo> allPhotos = new ArrayList<Photo>();
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
		final ProblemSolver solver = new ProblemSolver(3);
		final SolutionContainer sC = solver.process(pC);

		// ASSERTS
		// Assert.assertTrue(2. == sC.getScore());
		int counter = 0;
		Assert.assertEquals(7, sC.getAllSlides().size());
		for (final Slide slide : sC.getAllSlides()) {
			LOG.info(counter + " Slide: " + slide.toString());
			counter++;
		}
	}

}
