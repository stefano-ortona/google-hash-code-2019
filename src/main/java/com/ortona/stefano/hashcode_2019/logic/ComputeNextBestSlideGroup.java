package com.ortona.stefano.hashcode_2019.logic;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.ortona.stefano.hashcode_2019.model.Photo;
import com.ortona.stefano.hashcode_2019.model.Slide;

public class ComputeNextBestSlideGroup {

	public List<Slide> nextBestGroup(List<Photo> pics, Set<String> tags) {
		final List<Slide> curSlide = new LinkedList<>();
		// TODO
		return null;
	}

	private void computeNextSolution(List<Slide> curSol, List<List<Slide>> allSolutions, List<Photo> availPhotos) {
		if (availPhotos.isEmpty()) {
			return;
		}
		for (final Photo p : availPhotos) {

		}
	}

}
