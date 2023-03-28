package com.song.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RowChange {
    public static void main(String[] args) {
        List<List<Integer>> listAll = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();

        Collections.addAll(list1, 1, 2, 3,4);
        Collections.addAll(list2, 5, 6, 7,8);
        Collections.addAll(list3, 9, 9, 9,9);
        listAll.add(list1);
        listAll.add(list2);
        listAll.add(list3);
        List<List<Integer>> newlist = new ArrayList<>();
        //for (int o = 0; o < listAll.size(); o++) {
        for (int i = 0; i < listAll.get(0).size(); i++) {
            newlist.add(new ArrayList());
            for (int j = 0; j < listAll.size(); j++) {
                newlist.get(i).add(listAll.get(j).get(i));
            }
        }
        //}
        for (List<Integer> list : newlist) {
            System.out.println(list);
        }
    }
}
