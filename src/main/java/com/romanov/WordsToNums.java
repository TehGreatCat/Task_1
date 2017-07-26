package com.romanov;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static com.romanov.Main.NumsArray;
import static com.romanov.Main.go_on_flag;


public class WordsToNums extends Thread {

    private static final Map<String, Integer> singleNums;

    static {
        singleNums = new HashMap<>();
        singleNums.put("one", 1);
        singleNums.put("two", 2);
        singleNums.put("three", 3);
        singleNums.put("four", 4);
        singleNums.put("five", 5);
        singleNums.put("six", 6);
        singleNums.put("seven", 7);
        singleNums.put("eight", 8);
        singleNums.put("nine", 9);
        singleNums.put("ten", 10);
        singleNums.put("eleven", 11);
        singleNums.put("twelve", 12);
        singleNums.put("thirteen", 13);
        singleNums.put("fourteen", 14);
        singleNums.put("fifteen", 15);
        singleNums.put("sixteen", 16);
        singleNums.put("seventeen", 17);
        singleNums.put("eighteen", 18);
        singleNums.put("nineteen", 19);
    }

    private static final Map<String, Integer> numNames;

    static {
        numNames = new HashMap<>();
        numNames.put("one", 1);
        numNames.put("two", 2);
        numNames.put("three", 3);
        numNames.put("four", 4);
        numNames.put("five", 5);
        numNames.put("six", 6);
        numNames.put("seven", 7);
        numNames.put("eight", 8);
        numNames.put("nine", 9);
        numNames.put("ten", 10);
        numNames.put("twenty", 20);
        numNames.put("thirty", 30);
        numNames.put("forty", 40);
        numNames.put("fifty", 50);
        numNames.put("sixty", 60);
        numNames.put("seventy", 70);
        numNames.put("eighty", 80);
        numNames.put("ninety", 90);
    }

    public static Integer WordsToNums(String input) {
        Integer result = 0;
        Integer temp;
        input = input.toLowerCase();
        //thousands
        temp = result;
        result += intExtractor(input, "thousand", 1000);
        if (result.compareTo(temp) != 0) {
            input = input.substring(input.indexOf(" ") + 1);
            input = input.substring(input.indexOf(" ") + 1);
        }
        //hundreds
        temp = result;
        result += intExtractor(input, "hundred", 100);
        if (result.compareTo(temp) != 0)  {
            input = input.substring(input.indexOf(" ") + 1);
            input = input.substring(input.indexOf(" ") + 1);
        }
        //tens
        temp = result;
        result += intExtractor(input, "ty", 1);
        if (result.compareTo(temp) != 0)  {
            input = input.substring(input.indexOf(" ") + 1);
        }
        //singles
        temp = singleNums.get(input.trim());
        if (temp != null) {
            result += temp;
        }
        return result;

    }

    private static Integer intExtractor(String input, String size, Integer multiplier) {
        if (input.contains(size)) {
            Integer temp = numNames.get(input.substring(0, input.indexOf(" ")));
            if (temp != null) {
                return (temp * multiplier);
                }
            }
        return 0;
        }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        while (go_on_flag) {
            Integer output = WordsToNums(sc.nextLine());
            NumsArray.add(output);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

