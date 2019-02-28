package com.ortona.stefano.hashcode_2019.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ortona.stefano.hashcode_2019.logic.interfaces.IComputeBestPictureGroups;
import com.ortona.stefano.hashcode_2019.model.Photo;
import com.ortona.stefano.hashcode_2019.model.ProblemContainer;
import com.ortona.stefano.hashcode_2019.model.Slide;
import com.ortona.stefano.hashcode_2019.model.SolutionContainer;

/**
 * @author stefano
 */
public class ProblemSolver {
	Logger LOG = LoggerFactory.getLogger(getClass());

	IComputeBestPictureGroups bestPicGroup;
	ComputeNextBestSlideGroup bestSlide = new ComputeNextBestSlideGroup();

	int DEF_GROUP_SIZE = 10;

	public ProblemSolver(int maxGroupSize) {
		bestPicGroup = new ComputeBestPictureGroups(maxGroupSize);
	}

	public ProblemSolver() {
		bestPicGroup = new ComputeBestPictureGroups(DEF_GROUP_SIZE);
	}

	public SolutionContainer process(ProblemContainer problem) {
		final SolutionContainer sCont = new SolutionContainer();

		Set<String> curTags = null;
		final List<Slide> curList = new ArrayList<>();
		final boolean isAtTheEnd = true;
		while (!problem.getAllPhotos().isEmpty()) {
			final List<Photo> bestNextPhotos = bestPicGroup.getBestGroup(curTags, problem.getAllPhotos());
			final List<Slide> nextSlides = bestSlide.nextBestGroup(bestNextPhotos, curTags);
			if (isAtTheEnd) {
				curList.addAll(nextSlides);
			}
			curTags = nextSlides.get(nextSlides.size() - 1).getTags();
			problem.getAllPhotos().removeAll(bestNextPhotos);
		}
		sCont.setAllSlides(curList);
		return sCont;
	}

}
