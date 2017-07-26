package com.romanov;

import java.util.ArrayList;
import java.util.Collections;

import static com.romanov.Main.NumsArray;
import static com.romanov.Main.go_on_flag;

public class MemoryChecker extends Thread{

    public static void MemoryChecker(ArrayList<Integer> list){
        if (!list.isEmpty()){
            Collections.sort(list);
            System.out.println(list.remove(0));
        } else {
            System.out.println("list is empty ");
        }
    }


    @Override
    public void run() {
        while (go_on_flag) {
            try {
                sleep(15000);
                MemoryChecker(NumsArray);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
