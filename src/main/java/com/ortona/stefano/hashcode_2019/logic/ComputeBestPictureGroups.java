package com.ortona.stefano.hashcode_2019.logic;

import java.util.*;

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
        if (tags == null || tags.isEmpty()) {
            return getFirstPhotoList(allPics);
        }
        return getPhotoList(tags, allPics, maxNumPhoto);
    }


    /*
     * Internal methods
     */

    private List<Photo> getFirstPhotoList(@NotNull List<Photo> allPics) {
        Photo photo = getBestPhotoEvah(allPics);
        allPics.remove(photo);
        List<Photo> bestPhotoList = getPhotoList(photo.getTags(), allPics, maxNumPhoto - 1);
        bestPhotoList.add(photo);
        return bestPhotoList;
    }

    private List<Photo> getPhotoList(@NotNull Set<String> tags, @NotNull List<Photo> allPics, int tot) {
        List<Photo> ordered = new ArrayList<>(allPics);
        ordered.sort((o1, o2) -> {
            long res = o2.computeScore(tags) - o1.computeScore(tags);
            if (res < 0) {
                return -1;
            } else if (res > 0) {
                return 1;
            } else {
                return 0;
            }
        });
        return CommonUtils.subListSafe(ordered, tot);
    }


    /*
     * Utility methods
     */

    private Photo getBestPhotoEvah(List<Photo> allPics) {
        allPics.sort((o1, o2) -> o2.getTags().size() - o1.getTags().size());
        return allPics.get(0); // >> tags
    }

}
