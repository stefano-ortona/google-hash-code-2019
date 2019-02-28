package com.ortona.stefano.hashcode_2019.logic;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import com.ortona.stefano.hashcode_2019.model.Photo;

public class ComputeBestPictureGroups {

    int MAX_NUM_PHOTO = 10;

    public List<Photo> getBestGroup(Set<String> tags, List<Photo> allPics) {
        if (tags == null) {
            return getFirstPhotoList(allPics);
        }
        return getPhotoList(tags, allPics, MAX_NUM_PHOTO);
    }


    /*
     * Internal methods
     */

    private List<Photo> getFirstPhotoList(List<Photo> allPics) {
        Photo photo = getBestPhotoEvah(allPics);
        //getPhotoList()

        return null;
    }

    private List<Photo> getPhotoList(Set<String> tags, List<Photo> allPics, int tot) {
        return null;
    }


    /*
     * Utility methods
     */

    private Photo getBestPhotoEvah(List<Photo> allPics) {
        allPics.sort((o1, o2) -> o2.getTags().size() - o1.getTags().size());
        return allPics.get(0); // >> tags
    }

}
