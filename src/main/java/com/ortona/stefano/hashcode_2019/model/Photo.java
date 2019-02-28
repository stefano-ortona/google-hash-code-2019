package com.ortona.stefano.hashcode_2019.model;

import java.util.List;
import java.util.Set;

public class Photo {
	int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	Set<String> tags;

	boolean isVertical;

	public long computeScore(Photo other) {
		// TODO
		return 0;
	}

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

	public boolean isVertical() {
		return isVertical;
	}

	public void setVertical(boolean isVertical) {
		this.isVertical = isVertical;
	}

}
