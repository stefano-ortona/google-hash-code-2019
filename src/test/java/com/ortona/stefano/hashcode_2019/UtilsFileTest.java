/*
 * MIT License

 * Copyright (c) 2016
 */
package com.ortona.stefano.hashcode_2019;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test
 */
public class UtilsFileTest {

    private final String filePathExample = "a_example.txt";
    private UtilsFile fr = new UtilsFile(filePathExample);
    private int[] headerExample = fr.getHeader();
    private int PHOTO_AMOUNT = 4;
    private int[] actualHeaderExample = new int[]{PHOTO_AMOUNT};

    // Example.in file

    @Test
    public void testHeaderExample() {
        testHeader(headerExample, actualHeaderExample);
        Assert.assertEquals(PHOTO_AMOUNT, fr.getPhotoAmount());
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
