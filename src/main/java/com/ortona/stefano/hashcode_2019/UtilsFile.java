package com.ortona.stefano.hashcode_2019;

import com.ortona.stefano.hashcode_2019.model.Photo;
import com.ortona.stefano.hashcode_2019.model.ProblemContainer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class UtilsFile {

    /* If file structure is preserved (i.e. first line header, rest of the file data)
        Edit this file as following:
        1. define type of header items and data items
        2. generate setters and getters for header and data
        3. define logic of createHeader() and createData()
     */

    // 1. define type of header items and data items
    private int[] header;
    private char[][] data;
    private int photoAmount;
    private List<Photo> photos;
    private ProblemContainer problemContainer;

    // 2. generate setters and getters for header and data
    public void setHeader(int[] header) {
        this.header = header;
    }

    public void setData(char[][] data) {
        this.data = data;
    }

    public int[] getHeader() {
        return header;
    }

    public char[][] getData() {
        return data;
    }

    public int getPhotoAmount() {
        return photoAmount;
    }

    public void setPhotoAmount(int photoAmount) {
        this.photoAmount = photoAmount;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public ProblemContainer getProblemContainer() {
        return problemContainer;
    }

    public void setProblemContainer(ProblemContainer problemContainer) {
        this.problemContainer = problemContainer;
    }
    //3. define logic of createHeader() and createData()

    public void createHeader() {
        String firstLine = getFirstLineOfFile();
        String[] split = splitString(firstLine, " ");
        int[] converted = convertArrayOfStringToArrayOfInt(split);

        // always finish with this.setHeader()
        this.setHeader(converted);
    }

    public void createData() {
        String[] file = this.getFile();
        String[] dataRaw = cloneArrayOfString(file, 1, file.length);
        char[][] matrix = convertArrayOfStringToArrayOfCharArrays(dataRaw);

        // always finish with this.setData()
        this.setData(matrix);
    }

    public void createPhotos() {

        photos = new ArrayList<>();

        for (int i= 0 ; i < this.file.length - 1; i++){
            Photo p = new Photo();
            p.setId(i);
            String[] split = splitString(this.file[ i + 1], " ");

            //H 3 cat beach sun
            p.setVertical(split[0].equals("V"));

            int tagAmount = Integer.parseInt(split[1]);
            Set<String> tags = new HashSet<>();

            for (int j = 0; j < tagAmount; j ++){
                tags.add(split[2 + j]);
            }
            //System.out.println(tags);
            p.setTags(tags);
            photos.add(p);

        }

        this.setPhotos(photos);
    }


    // ====== Do not change below here

    private static final String RESOURCE_PATH = "src/main/resources/com.ortona.stefano.hashcode_2019/";
    private String[] file;

    public void setFile(String[] file) {
        this.file = file;
    }

    public String[] getFile() {
        return file;
    }

    // Constructor
    public UtilsFile(String filepath) {

        try {
            File file = new File(RESOURCE_PATH + filepath);
            String absolutePath = file.getAbsolutePath();

            readFile(absolutePath);

            createHeader();

            this.setPhotoAmount(this.getHeader()[0]);

            createData();

            createPhotos();

            problemContainer= new ProblemContainer();

            problemContainer.setAllPhotos(this.getPhotos());

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    // Utils
    public void readFile(String filepath) throws IOException {

        String line;
        List<String> list = new ArrayList<>();
        BufferedReader in = new BufferedReader(new FileReader(filepath));

        while ((line = in.readLine()) != null) {
            list.add(line);  //Add line to file
        }

        //Cast List to Array of Array
        String[] stringArr = list.toArray(new String[0]);

        this.setFile(stringArr);

    }

    public String getFirstLineOfFile() {
        return this.file[0];
    }

    public String[] splitString(String string, String separator) {
        return string.split(separator);
    }

    public String[] cloneArrayOfString(String[] source, Integer start, Integer to) {
        return Arrays.copyOfRange(source, start, to);
    }

    public char[] convertStringToArrayOfChar(String string) {
        return string.toCharArray();
    }

    public char[][] convertArrayOfStringToArrayOfCharArrays(String[] dataRaw) {

        char[][] result = new char[dataRaw.length][dataRaw[0].length()];

        for (int i = 0; i < dataRaw.length; i++) {
            result[i] = convertStringToArrayOfChar(dataRaw[i]);
        }
        return result;
    }

    public String convertArrayOfChartToString(char[] a) {
        return new String(a);
    }

    public int[] convertArrayOfStringToArrayOfInt(String[] strings) {
        return Arrays.asList(strings).stream().mapToInt(Integer::parseInt).toArray();

    }

}
