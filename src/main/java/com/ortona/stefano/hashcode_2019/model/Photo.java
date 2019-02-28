package com.ortona.stefano.hashcode_2019.model;

import com.ortona.stefano.hashcode_2019.logic.utils.CommonUtils;

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

    public long computeScore(Set<String> tags) {
        if (this.tags == null || tags == null) {
            return 0;
        }
        return CommonUtils.computeScore(tags, this.tags);
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
