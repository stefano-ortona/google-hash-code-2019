package com.ortona.stefano.hashcode_2019.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.ortona.stefano.hashcode_2019.logic.interfaces.IComputeBestPictureGroups;
import com.ortona.stefano.hashcode_2019.logic.utils.CommonUtils;
import com.ortona.stefano.hashcode_2019.model.Photo;
import com.sun.istack.internal.NotNull;

public class ComputeBestPictureGroups implements IComputeBestPictureGroups {

	private final int maxNumPhoto;

	public ComputeBestPictureGroups(int maxNumPhoto) {
		this.maxNumPhoto = maxNumPhoto;
	}

	@Override
	public List<Photo> getBestGroup(Set<String> tags, @NotNull List<Photo> allPics) {
		if ((tags == null) || tags.isEmpty()) {
			return getFirstPhotoList(allPics);
		}
		return getPhotoList(tags, allPics, maxNumPhoto);
	}

	/*
	 * Internal methods
	 */

	private List<Photo> getFirstPhotoList(@NotNull List<Photo> allPics) {
		final Photo photo = getBestPhotoEvah(allPics);
		allPics.remove(photo);
		final List<Photo> bestPhotoList = getPhotoList(photo.getTags(), allPics, maxNumPhoto - 1);
		bestPhotoList.add(photo);
		return bestPhotoList;
	}

	private List<Photo> getPhotoList(@NotNull Set<String> tags, @NotNull List<Photo> allPics, int tot) {
		final TreeSet<PhotoScore> target = new TreeSet<>();
		for (final Photo p : allPics) {
			final PhotoScore pS = new PhotoScore();
			pS.p = p;
			pS.score = CommonUtils.computeScore(tags, p.getTags());
			if (target.size() < tot) {
				target.add(pS);
			} else {
				target.remove(target.last());
				target.add(pS);
			}
		}
		final List<Photo> output = new ArrayList<>();
		target.forEach(pS -> output.add(pS.p));
		return output;
	}

	private class PhotoScore implements Comparable<PhotoScore> {
		long score;
		Photo p;

		@Override
		public int compareTo(PhotoScore o) {
			return (int) (o.score - this.score);
		}
	}

	/*
	 * Utility methods
	 */

	private Photo getBestPhotoEvah(List<Photo> allPics) {
		Photo bestPhoto = null;
		int tagsSize = 0;
		for (final Photo photo : allPics) {
			if (photo.getTags().size() > tagsSize) {
				bestPhoto = photo;
				tagsSize = photo.getTags().size();
			}
		}
		return bestPhoto;
	}

}
