package com.ortona.stefano.hashcode_2019.model;

import java.util.List;

public class Photo {
	List<String> tags;
	boolean isVertical;

	public long computeScore(Photo other) {
		// TODO
		return 0;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public boolean isVertical() {
		return isVertical;
	}

	public void setVertical(boolean isVertical) {
		this.isVertical = isVertical;
	}

}