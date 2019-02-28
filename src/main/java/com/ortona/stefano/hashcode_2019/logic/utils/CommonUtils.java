package com.ortona.stefano.hashcode_2019.logic.utils;

import java.util.ArrayList;
import java.util.List;

public class CommonUtils {

    public static <T> List<T> subListSafe(List<T> list, int firstN) {
        if (list.size() <= firstN) {
            return new ArrayList<>(list);
        }
        return list.subList(0, firstN);
    }

}
