package com.ortona.stefano.hashcode_2019.logic.utils;

import com.google.common.collect.Sets;
import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CommonUtils {

    public static <T> List<T> subListSafe(List<T> list, int firstN) {
        if (list.size() <= firstN) {
            return new ArrayList<>(list);
        }
        return list.subList(0, firstN);
    }

    public static long computeScore(@NotNull Set<String> tag1, @NotNull Set<String> tag2) {
        int commonTagSize = Sets.intersection(tag1, tag2).size();
        return Math.min(Math.min(commonTagSize, tag1.size() - commonTagSize), tag2.size() - commonTagSize);
    }

}
