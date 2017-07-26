package com.romanov;

import java.util.ArrayList;

public class Main {

    public static ArrayList<Integer> NumsArray = new ArrayList<>();

    static WordsToNums Thread_1;

    static MemoryChecker Thread_2;

    static Boolean go_on_flag = true;

    public static void main(String[] args) {
        Thread_1 = new WordsToNums();
        Thread_2 = new MemoryChecker();

        Thread_1.start();
        Thread_2.start();

    }

    public static void stopAllThreads() {
        go_on_flag = false;
    }

}
