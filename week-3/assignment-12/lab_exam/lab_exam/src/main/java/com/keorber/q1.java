package com.keorber;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class q1 {
    public static void main(String[] args)
    {
        Map<String, Integer> map=new HashMap<String, Integer>();
        map.put("raj", 95);
        map.put("ekta", 75);
        map.put("rajiv", 85);
        map.put("sunita", 66);
        map.put("gunika", 99);
        System.out.println("------printing map------");

        //print map using stream
        map.forEach((key, value) -> System.out.println(key + ": " + value));
        System.out.println("============================================================================================");
        //print only that record that contain key "raj"
        map.entrySet().stream().filter(entry -> entry.getKey().equals("raj")).forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
        System.out.println("============================================================================================");
        //print map by sorted key
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
        System.out.println("============================================================================================");
        //print map sorted by value
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
        System.out.println("============================================================================================");
        //print map sorted by reversed
        map.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
        System.out.println("============================================================================================");

    }
}