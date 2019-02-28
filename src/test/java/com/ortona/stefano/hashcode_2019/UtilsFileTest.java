/*
 * MIT License

 * Copyright (c) 2016
 */
package com.ortona.stefano.hashcode_2019;

import com.ortona.stefano.hashcode_2019.model.Photo;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;


/**
 * Unit test
 */
public class UtilsFileTest {

    static private final String filePathExample = "a_example.txt";
    static private UtilsFile fr = new UtilsFile(filePathExample);
    static private int[] headerExample = fr.getHeader();
    static private int PHOTO_AMOUNT = 4;
    static private int[] actualHeaderExample = new int[]{PHOTO_AMOUNT};
    // Photos
    static private List<Photo> photosExample = fr.getProblemContainer().getAllPhotos();
    static private List<Photo> photosActuals;

    // Example.in file

    @Test
    public void testHeaderExample() {
        testHeader(headerExample, actualHeaderExample);
        Assert.assertEquals(PHOTO_AMOUNT, fr.getPhotoAmount());
    }

    @Test
    public void testPhotos() {

        photosActuals = new ArrayList<>();

        //        H 3 cat beach sun
        Photo p0 = new Photo();
        p0.setId(0);
        p0.setVertical(false);
        Set<String> t0 = new HashSet<>();
        t0.add("cat");
        t0.add("beach");
        t0.add("sun");
        p0.setTags(t0);
        photosActuals.add(p0);

//        V 2 selfie smile
        Photo p1 = new Photo();
        p1.setId(1);
        p1.setVertical(true);
        Set<String> t1 = new HashSet<>();
        t1.add("selfie");
        t1.add("smile");
        p1.setTags(t1);
        photosActuals.add(p1);

//        V 2 garden selfie
        Photo p2 = new Photo();
        p2.setId(2);
        p2.setVertical(true);
        Set<String> t2 = new HashSet<>();
        t2.add("garden");
        t2.add("selfie");
        p2.setTags(t2);
        photosActuals.add(p2);

//        H 2 garden cat
        Photo p3 = new Photo();
        p3.setId(3);
        p3.setVertical(false);
        Set<String> t3 = new HashSet<>();
        t3.add("garden");
        t3.add("cat");
        p3.setTags(t3);
        photosActuals.add(p3);

        Assert.assertEquals(photosActuals.size(), photosExample.size());

        for ( int k = 0 ; k < photosActuals.size(); k++){
            Photo actual = photosActuals.get(k);
            Photo example = photosExample.get(k);

            Set<String> tagsActual = actual.getTags();
            Set<String> tagsExample = example.getTags();

            Assert.assertEquals(actual.getId(), example.getId());
            Assert.assertEquals(tagsActual.size(), tagsExample.size());

        }

    }

    @Test
    public void testPhotoAmount() {
        Assert.assertEquals(fr.getPhotoAmount(), photosExample.size());
    }


    // utils

    private void testDataLineByLine(String[] actualData, char[][] data) {

        // line by line
        for (int i = 0; i < actualData.length; i++) {
            String d = fr.convertArrayOfChartToString(data[i]);
            Assert.assertEquals(d, actualData[i]);
        }

    }

    private void testHeader(int[] actualHeader, int[] header) {
        for (int i = 0; i < actualHeader.length; i++) {
            Assert.assertEquals(header[i], actualHeader[i]);
        }
    }

    private void testDataCharByChar(String[] actualData, char[][] data) {

        for (int i = 0; i < actualData.length; i++) {
            testCharByChartLine(actualData[i], data[i]);
        }

    }

    private void testCharByChartLine(String line, char[] data) {

        for (int i = 0; i < line.length(); i++) {
            Assert.assertEquals(line.charAt(i), data[i]);
        }

    }
}
