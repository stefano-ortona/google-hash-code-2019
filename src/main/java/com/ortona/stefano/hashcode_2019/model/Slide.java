package com.ortona.stefano.hashcode_2019.model;

import java.util.HashSet;
import java.util.Set;

public class Slide {
	private Photo first;
	private Photo second;

	public void addPhoto(Photo p) {
		if (first == null) {
			first = p;
		} else {
			if (!first.isVertical || !p.isVertical) {
				throw new RuntimeException("Cannto add this photo!");
			}
			second = p;
		}
	}

	public long computeScore(Slide nextSlide) {
		// TODO
		return 0;
	}

	public Photo getFirst() {
		return first;
	}

	public void setFirst(Photo first) {
		this.first = first;
	}

	public Photo getSecond() {
		return second;
	}

	public void setSecond(Photo second) {
		this.second = second;
	}

	public Set<String> getTags() {
		final Set<String> tags = new HashSet<String>();
		if (first != null) {
			tags.addAll(first.getTags());
		}
		if (second != null) {
			tags.addAll(second.getTags());
		}
		return tags;
	}

	@Override
	public String toString() {
		if (getSecond() != null) {
			return getFirst().getId() + " " + getSecond().getId();
		} else {
			return Integer.toString(getFirst().getId());
		}
	}

}
