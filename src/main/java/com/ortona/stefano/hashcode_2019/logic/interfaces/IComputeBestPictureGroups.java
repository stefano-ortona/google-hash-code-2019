package com.ortona.stefano.hashcode_2019.logic.interfaces;

import com.ortona.stefano.hashcode_2019.model.Photo;
import com.sun.istack.internal.NotNull;

import java.util.List;
import java.util.Set;

public interface IComputeBestPictureGroups {

    List<Photo> getBestGroup(Set<String> tags, @NotNull List<Photo> allPics);

}
