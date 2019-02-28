package com.ortona.stefano.hashcode_2019.logic;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ortona.stefano.hashcode_2019.model.Photo;
import com.ortona.stefano.hashcode_2019.model.ProblemContainer;
import com.ortona.stefano.hashcode_2019.model.SolutionContainer;

/**
 *
 * @author stefano
 *
 */
public class ProblemSolver {
	Logger LOG = LoggerFactory.getLogger(getClass());

	ComputeBestPictureGroups bestPicGRoup = new ComputeBestPictureGroups();

	public SolutionContainer process(ProblemContainer problem) {
		final SolutionContainer sCont = new SolutionContainer();

		while (!problem.getAllPhotos().isEmpty()) {
			final Set<String> tags = new HashSet<>();
			final List<Photo> bestNextPhotos = bestPicGRoup.getBestGroup(tags, problem.getAllPhotos());
			// optimized for bestNextPhotos and attach to the global sequence
			// get beginning or end of the global sequence ??
		}
		return sCont;
	}

}
