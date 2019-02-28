package com.ortona.stefano.hashcode_2019;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ortona.stefano.hashcode_2019.logic.ProblemSolver;
import com.ortona.stefano.hashcode_2019.model.ProblemContainer;
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
		final ProblemContainer pC = new ProblemContainer();
		final SolutionContainer sC = SOLVER.process(pC);
		Assert.assertTrue(0. == sC.getScore());
		Assert.assertEquals("com.ortona.stefano.hashcode_2019.model.ProblemContainer", pC.getClass().getName());
	}

}
