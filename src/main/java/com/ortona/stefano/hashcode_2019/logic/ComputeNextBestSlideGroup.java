package com.ortona.stefano.hashcode_2019.logic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;
import com.ortona.stefano.hashcode_2019.logic.utils.CommonUtils;
import com.ortona.stefano.hashcode_2019.model.Photo;
import com.ortona.stefano.hashcode_2019.model.Slide;

public class ComputeNextBestSlideGroup {

	public List<Slide> nextBestGroup(List<Photo> pics, Set<String> tags) {
		final List<String> allSol = new LinkedList<>();
		computeNextSolution("", allSol, pics);
		// for each solution, compute the score
		long bestScore = -1;
		String bestSol = null;
		for (final String oneSol : allSol) {
			final long curScore = computeScore(oneSol, pics, tags);
			if (curScore > bestScore) {
				bestScore = curScore;
				bestSol = oneSol;
			}

		}
		return createSlide(bestSol, pics);
	}

	List<Slide> createSlide(String solution, List<Photo> allPics) {
		final List<Slide> nextSlides = new ArrayList<Slide>();
		final String[] allParts = solution.split("-");
		for (final String onePart : allParts) {
			if (onePart.isEmpty()) {
				continue;
			}
			final String[] allPhotos = onePart.split("P");
			if (allPhotos.length > 2) {
				throw new RuntimeException("Too long!");
			}
			final Slide curSlide = new Slide();
			final Photo firstP = allPics.stream().filter(p -> p.getId() == Integer.parseInt(allPhotos[0] + ""))
					.findFirst().get();
			curSlide.addPhoto(firstP);
			if (allPhotos.length == 2) {
				final Photo secondP = allPics.stream().filter(p -> p.getId() == Integer.parseInt(allPhotos[1] + ""))
						.findFirst().get();
				curSlide.addPhoto(secondP);
			}
			nextSlides.add(curSlide);
		}
		return nextSlides;
	}

	private long computeScore(String sol, List<Photo> allPics, Set<String> initialTags) {
		final String[] slidesSplit = sol.split("-");
		Set<String> curTags = initialTags == null ? new HashSet<>() : initialTags;
		long totScore = 0;
		for (final String oneSlide : slidesSplit) {
			if (oneSlide.isEmpty()) {
				continue;
			}
			final String[] allPhotos = oneSlide.split("P");
			if (allPhotos.length > 2) {
				throw new RuntimeException("Too long!");
			}
			final Set<String> allTags = new HashSet<>();
			final Photo first = allPics.stream().filter(p -> p.getId() == Integer.parseInt(allPhotos[0] + ""))
					.findFirst().get();
			allTags.addAll(first.getTags());
			if (allPhotos.length == 2) {
				final Photo second = allPics.stream().filter(p -> p.getId() == Integer.parseInt(allPhotos[1] + ""))
						.findFirst().get();
				allTags.addAll(second.getTags());
			}
			totScore += CommonUtils.computeScore(curTags, allTags);
			curTags = allTags;
		}
		return totScore;
	}

	private void computeNextSolution(String curSol, List<String> allSolutions, List<Photo> availPhotos) {
		if (availPhotos.isEmpty()) {
			allSolutions.add(curSol);
		}
		for (final Photo p : availPhotos) {
			if (p.isVertical()) {
				// if the one before is vertical, try to unifiy it
				if (!curSol.isEmpty() && (curSol.charAt(curSol.length() - 1) != '-')) {
					// unify it and end the slide
					final String newSol = curSol + p.getId() + "-";
					final List<Photo> newPhotos = Lists.newArrayList(availPhotos);
					newPhotos.remove(p);
					computeNextSolution(newSol, allSolutions, newPhotos);

					// unify the previous slide without adding the vertical photo, and keep going
					final String newSolSecond = curSol + "-" + p.getId();
					final List<Photo> newPhotosSecond = Lists.newArrayList(availPhotos);
					newPhotosSecond.remove(p);
					computeNextSolution(newSolSecond, allSolutions, newPhotosSecond);

				} else {
					// if it is first photo, or a new slide, just attach it
					final String newSol = curSol + p.getId() + "P";
					final List<Photo> newPhotos = Lists.newArrayList(availPhotos);
					newPhotos.remove(p);
					computeNextSolution(newSol, allSolutions, newPhotos);
				}

			} else {
				String newSol = curSol;
				// if it is horizontal, can only be alone
				if (!curSol.isEmpty() && (curSol.charAt(curSol.length() - 1) != '-')) {
					newSol += "-";
				}
				newSol += p.getId() + "-";
				final List<Photo> newPhotos = Lists.newArrayList(availPhotos);
				newPhotos.remove(p);
				computeNextSolution(newSol, allSolutions, newPhotos);
			}
		}
	}

}
